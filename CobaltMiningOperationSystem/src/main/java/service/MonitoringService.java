/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import config.DatabaseConfig;
import enums.*;
import exception.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import model.*;
import repository.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class MonitoringService {
    private final MonitoringRepository mon;
    private final LokasiRepository loc;
    private final ParameterRepository par;
    
    public MonitoringService(MonitoringRepository m, LokasiRepository l, ParameterRepository p) {
        mon = m;
        loc = l;
        par = p;
    }
    
    private MonitoringLingkungan find(int id) {
        return mon.findById(id).orElseThrow(()->new DataNotFoundException("Monitoring tidak ditemukan."));
    }
    
    private ParameterLingkungan param(int id) {
        return par.findById(id).orElseThrow(()->new DataNotFoundException("Parameter tidak ditemukan."));
    }
    
    private StatusDetail status(ParameterLingkungan p,double v) {
        if(!Double.isFinite(v)||Math.abs(v*100-Math.rint(v*100))>0.00001)throw new ValidationException("Pengukuran harus berupa angka maksimal 2 desimal.");
        Double min=p.getBatasMinimum(),max=p.getBatasMaksimum();
        if(min!=null&&v<min){return v<=min-(max!=null?(max-min)*0.20:Math.abs(min)*0.20)?StatusDetail.BERBAHAYA:StatusDetail.PERINGATAN;}
        if(max!=null&&v>max){return v>=max+((min!=null&&min>0)?(max-min)*0.20:Math.abs(max)*0.20)?StatusDetail.BERBAHAYA:StatusDetail.PERINGATAN;}
        return StatusDetail.NORMAL;
    }

    /** Persetujuan per lokasi tersimpan di database, tidak hilang saat aplikasi ditutup. */
    public static final class Permintaan {
        public final int id, lokasiId;
        public final String lokasi, alasan, status, pengaju, tanggal;
        public Permintaan(int id,int lokasiId,String lokasi,String alasan,String status,String pengaju,String tanggal) {
            this.id=id;this.lokasiId=lokasiId;this.lokasi=lokasi;this.alasan=alasan;this.status=status;this.pengaju=pengaju;this.tanggal=tanggal;
        }
        @Override public String toString(){ return lokasi+" | "+alasan+" (#"+id+")"; }
    }
    // Persetujuan disimpan dalam tabel monitoring_lingkungan yang sudah ada.
    // Catatan dengan awalan internal tidak ditampilkan sebagai kegiatan pengukuran.
    private static final String MENUNGGU = "[CMOS_MENUNGGU]";
    private static final String DISETUJUI = "[CMOS_DISETUJUI]";
    private static final String DIBACA = "[CMOS_DIBACA]";
    public String statusPermintaan(int lokasi) {
        String sql="SELECT catatan,status_penanganan FROM monitoring_lingkungan WHERE lokasi_id_lokasi=? AND (catatan=? OR catatan=? OR status_penanganan='DALAM_PENANGANAN') ORDER BY id_monitoring DESC LIMIT 1";
        try(Connection c=DatabaseConfig.getConnection();PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setInt(1,lokasi);ps.setString(2,MENUNGGU);ps.setString(3,DISETUJUI);
            try(ResultSet rs=ps.executeQuery()) {
                if(!rs.next())return "BELUM_ADA";
                String cat=rs.getString(1);
                if(MENUNGGU.equals(cat))return "MENUNGGU";
                if(DISETUJUI.equals(cat))return "DISETUJUI";
                return "BERJALAN";
            }
        }catch(SQLException ex){throw new IllegalStateException("Gagal membaca permintaan monitoring.",ex);}
    }
    public void ajukanMonitoring(int lokasi,String alasan,int pengaju) {
        if(alasan==null||alasan.trim().length()<8)throw new ValidationException("Tuliskan alasan monitoring minimal 8 karakter.");
        if(alasan.length()>255)throw new ValidationException("Alasan maksimal 255 karakter.");
        try(Connection c=DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                try(PreparedStatement lock=c.prepareStatement("SELECT id_lokasi FROM lokasi WHERE id_lokasi=? FOR UPDATE")) {
                    lock.setInt(1,lokasi);try(ResultSet rs=lock.executeQuery()){if(!rs.next())throw new DataNotFoundException("Lokasi tidak ditemukan.");}
                }
                try(PreparedStatement check=c.prepareStatement("SELECT id_monitoring FROM monitoring_lingkungan WHERE lokasi_id_lokasi=? AND (catatan IN (?,?) OR status_penanganan='DALAM_PENANGANAN') LIMIT 1")) {
                    check.setInt(1,lokasi);check.setString(2,MENUNGGU);check.setString(3,DISETUJUI);
                    try(ResultSet rs=check.executeQuery()){if(rs.next())throw new ValidationException("Lokasi ini sudah memiliki permintaan atau kegiatan yang belum selesai.");}
                }
                try(PreparedStatement ps=c.prepareStatement("INSERT INTO monitoring_lingkungan (tanggal_monitoring,status_monitoring,tindak_lanjut,status_penanganan,catatan,lokasi_id_lokasi,petugas_hse_id_pegawai) VALUES (NOW(),'NORMAL',?,'BELUM_DITANGANI',?,?,?)")) {
                    ps.setString(1,alasan.trim());ps.setString(2,MENUNGGU);ps.setInt(3,lokasi);ps.setInt(4,pengaju);ps.executeUpdate();
                }
                c.commit();
            }catch(Exception ex){c.rollback();throw ex;}
        }catch(SQLException ex){throw new IllegalStateException("Gagal mengirim permintaan monitoring.",ex);}
    }
    public java.util.List<Permintaan> permintaanMenunggu() {
        java.util.List<Permintaan> list=new ArrayList<>();
        String sql="SELECT m.id_monitoring,m.lokasi_id_lokasi,l.nama_lokasi,m.tindak_lanjut,peg.nama_pegawai,m.tanggal_monitoring FROM monitoring_lingkungan m JOIN lokasi l ON l.id_lokasi=m.lokasi_id_lokasi JOIN pegawai peg ON peg.id_pegawai=m.petugas_hse_id_pegawai WHERE m.catatan=? AND m.status_penanganan='BELUM_DITANGANI' ORDER BY m.tanggal_monitoring";
        try(Connection c=DatabaseConfig.getConnection();PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setString(1,MENUNGGU);
            try(ResultSet rs=ps.executeQuery()) {while(rs.next())list.add(new Permintaan(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),"MENUNGGU",rs.getString(5),rs.getString(6)));}
        }catch(SQLException ex){throw new IllegalStateException("Gagal memuat permintaan monitoring.",ex);}
        return list;
    }
    public static final class Peringatan {
        public final int id,monitoringId;
        public final String pesan;
        public Peringatan(int id,int monitoringId,String pesan){this.id=id;this.monitoringId=monitoringId;this.pesan=pesan;}
        @Override public String toString(){return pesan;}
    }
    public java.util.List<Peringatan> peringatanManager() {
        java.util.List<Peringatan> list=new ArrayList<>();
        String sql="SELECT m.id_monitoring,l.nama_lokasi,m.status_monitoring FROM monitoring_lingkungan m JOIN lokasi l ON l.id_lokasi=m.lokasi_id_lokasi WHERE m.status_monitoring IN ('PERINGATAN','BERBAHAYA') AND (m.catatan IS NULL OR m.catatan<>?) ORDER BY m.tanggal_monitoring DESC";
        try(Connection c=DatabaseConfig.getConnection();PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setString(1,DIBACA);
            try(ResultSet rs=ps.executeQuery()){while(rs.next()){int id=rs.getInt(1);list.add(new Peringatan(id,id,rs.getString(3)+" di "+rs.getString(2)+". Lihat hasil pengukuran."));}}
        }catch(SQLException ex){throw new IllegalStateException("Gagal membaca peringatan lingkungan.",ex);}
        return list;
    }
    public void tandaiPeringatanDibaca(int id) {
        try(Connection c=DatabaseConfig.getConnection();PreparedStatement ps=c.prepareStatement("UPDATE monitoring_lingkungan SET catatan=? WHERE id_monitoring=? AND status_monitoring IN ('PERINGATAN','BERBAHAYA') AND (catatan IS NULL OR catatan<>?)")) {
            ps.setString(1,DIBACA);ps.setInt(2,id);ps.setString(3,DIBACA);
            if(ps.executeUpdate()!=1)throw new ValidationException("Informasi sudah dibaca atau tidak ditemukan.");
        }catch(SQLException ex){throw new IllegalStateException("Gagal menandai informasi.",ex);}
    }
    public void setujuiMonitoring(int id,int manager) {
        try(Connection c=DatabaseConfig.getConnection();PreparedStatement ps=c.prepareStatement("UPDATE monitoring_lingkungan SET catatan=? WHERE id_monitoring=? AND catatan=? AND status_penanganan='BELUM_DITANGANI'")) {
            ps.setString(1,DISETUJUI);ps.setInt(2,id);ps.setString(3,MENUNGGU);
            if(ps.executeUpdate()!=1)throw new ValidationException("Permintaan sudah diproses atau tidak ditemukan.");
        }catch(SQLException ex){throw new IllegalStateException("Gagal menyetujui kegiatan.",ex);}
    }
    private void kunciPengukuran(Connection c,int id) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT status_penanganan FROM monitoring_lingkungan WHERE id_monitoring=? FOR UPDATE")) {
            ps.setInt(1,id);
            try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())throw new DataNotFoundException("Kegiatan monitoring tidak ditemukan.");
                if(!"DALAM_PENANGANAN".equals(rs.getString(1)))throw new ValidationException("Pengukuran hanya dapat diubah selama penanganan berlangsung.");
            }
        }
    }
    public MonitoringLingkungan buatMonitoring(int id,int lokasiId,PetugasHSE h,LocalDateTime t,String catatan) {
        if(id!=0)throw new ValidationException("ID kegiatan baru harus 0.");
        if(t==null)t=LocalDateTime.now();
        if(t.isAfter(LocalDateTime.now()))throw new ValidationException("Tanggal tidak boleh di masa depan.");
        if(h==null||h.getStatusPegawai()!=StatusPegawai.AKTIF||!h.isSertifikasiAktif(t.toLocalDate()))throw new ValidationException("Petugas HSE tidak aktif atau sertifikasi sudah tidak berlaku.");
        final LocalDateTime tanggal=t;
        try(Connection c=DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                int requestId;
                try(PreparedStatement ps=c.prepareStatement("SELECT id_monitoring FROM monitoring_lingkungan WHERE lokasi_id_lokasi=? AND petugas_hse_id_pegawai=? AND catatan=? AND status_penanganan='BELUM_DITANGANI' ORDER BY id_monitoring DESC LIMIT 1 FOR UPDATE")) {
                    ps.setInt(1,lokasiId);ps.setInt(2,h.getIdPegawai());ps.setString(3,DISETUJUI);
                    try(ResultSet rs=ps.executeQuery()){if(!rs.next())throw new ValidationException("Permintaan belum disetujui Manager atau diajukan oleh petugas lain.");requestId=rs.getInt(1);}
                }
                try(PreparedStatement ps=c.prepareStatement("UPDATE monitoring_lingkungan SET tanggal_monitoring=?,catatan=?,status_penanganan='DALAM_PENANGANAN' WHERE id_monitoring=? AND catatan=?")) {
                    ps.setTimestamp(1,Timestamp.valueOf(tanggal));ps.setString(2,catatan);ps.setInt(3,requestId);ps.setString(4,DISETUJUI);
                    if(ps.executeUpdate()!=1)throw new ValidationException("Persetujuan sudah dipakai.");
                }
                c.commit();return find(requestId);
            }catch(Exception ex){c.rollback();throw ex;}
        }catch(SQLException ex){throw new IllegalStateException("Gagal memulai monitoring.",ex);}
    }

    public MonitoringLingkungan buatMonitoring(int lokasiId, PetugasHSE h, LocalDateTime t, String catatan) {
        return buatMonitoring(0, lokasiId, h, t, catatan);
    }
    
    public DetailMonitoring tambahDetail(int idMon, int idDetail, int idParam, double nilai, String catatan) {
        if (idDetail != 0)throw new ValidationException("ID detail baru harus 0.");
        ParameterLingkungan p = param(idParam);
        StatusDetail st = status(p, nilai);
    
        try(Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                try(PreparedStatement ps = c.prepareStatement("SELECT id_monitoring,status_penanganan FROM monitoring_lingkungan WHERE id_monitoring=? FOR UPDATE")) {
                    ps.setInt(1, idMon);
                    try(ResultSet rs = ps.executeQuery()) {
                        if (!rs.next())throw new DataNotFoundException("Monitoring tidak ditemukan.");
                        if(!"DALAM_PENANGANAN".equals(rs.getString("status_penanganan")))throw new ValidationException("Pengukuran sudah ditutup atau belum dimulai.");
                    }
                }
                
                int generated;
                
                try(PreparedStatement ps = c.prepareStatement("INSERT INTO detail_monitoring (nilai_pengukuran,status_detail,catatan,monitoring_lingkungan_id_monitoring,parameter_lingkungan_id_parameter) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                    ps.setBigDecimal(1, java.math.BigDecimal.valueOf(nilai));
                    ps.setString(2, st.name());
                    ps.setString(3, catatan);
                    ps.setInt(4, idMon);
                    ps.setInt(5, idParam);
                    ps.executeUpdate();
                
                    try(ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next())throw new SQLException("ID detail tidak ditemukan.");
                        generated = rs.getInt(1);
                    }
                }
                
                rehitungStatus(c,idMon);
                c.commit();
                return new DetailMonitoring(generated, find(idMon), p, nilai, st, catatan);
            }
            
            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }
        
        catch (SQLException e) {
            throw new IllegalStateException("Gagal menambah detail monitoring: "+e.getMessage(), e);
        }
    }
    
    public DetailMonitoring tambahDetail(int idMon, int idParam, double nilai, String catatan) {
        return tambahDetail(idMon, 0, idParam, nilai, catatan);
    }
    
    public void mulaiPenanganan(int id) {
        MonitoringLingkungan m=find(id);
        if(m.getStatusPenanganan()!=StatusPenanganan.BELUM_DITANGANI)throw new ValidationException("Monitoring belum dapat dimulai.");
        statusUpdate(id,"status_penanganan","DALAM_PENANGANAN","status_penanganan='BELUM_DITANGANI'");
    }
    public void selesaikanPenanganan(int id) {
        MonitoringLingkungan m=find(id);
        if(m.getStatusPenanganan()!=StatusPenanganan.DALAM_PENANGANAN)throw new ValidationException("Kegiatan sudah selesai atau belum dimulai.");
        if(m.getDetailMonitoring().isEmpty())throw new ValidationException("Tambahkan minimal satu hasil pengukuran sebelum menyelesaikan kegiatan.");
        try(Connection c=DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                try(PreparedStatement ps=c.prepareStatement("UPDATE monitoring_lingkungan SET status_penanganan='SELESAI' WHERE id_monitoring=? AND status_penanganan='DALAM_PENANGANAN'")) {
                    ps.setInt(1,id);if(ps.executeUpdate()!=1)throw new ValidationException("Kegiatan sudah selesai.");
                }
                c.commit();
            }catch(Exception e){c.rollback();throw e;}
        }catch(SQLException e){throw new IllegalStateException("Gagal menyelesaikan monitoring.",e);}
    }
    /** Peringatan dicatat untuk Manager tanpa mengganti alasan kegiatan yang sudah disetujui. */
    public void informasikanManager(int id,String oleh) {
        MonitoringLingkungan m=find(id);
        if(m.getStatusMonitoring()==StatusMonitoring.NORMAL)throw new ValidationException("Belum terdapat hasil yang perlu diperhatikan Manager.");
        // Manager langsung membaca data monitoring PERINGATAN/BERBAHAYA dari tabel asli.
        // Tidak dibuat tabel notifikasi tambahan.
    }
    private void statusUpdate(int id, String col, String value, String condition) {
        String sql = "UPDATE monitoring_lingkungan SET "+col+"=? WHERE id_monitoring=? AND "+condition;
    
        try(Connection c = DatabaseConfig.getConnection();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, value);
            ps.setInt(2, id);
            if (ps.executeUpdate() != 1)throw new ValidationException("Status monitoring tidak sesuai.");
        }
        
        catch (SQLException e) {
            throw new IllegalStateException("Gagal memperbarui monitoring", e);
        }
    }
    
    /** Memperbarui satu pengukuran lalu menghitung ulang status monitoring. */
    public DetailMonitoring ubahDetail(int idDetail, int idParam, double nilai, String catatan) {
        ParameterLingkungan p = param(idParam);
        StatusDetail st = status(p, nilai);
        int idMon;

        try (Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT monitoring_lingkungan_id_monitoring FROM detail_monitoring WHERE id_detail=? FOR UPDATE")) {
                    ps.setInt(1, idDetail);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next())throw new DataNotFoundException("Pengukuran tidak ditemukan.");
                        idMon = rs.getInt(1);
                    }
                }

                kunciPengukuran(c,idMon);
                try (PreparedStatement ps = c.prepareStatement("UPDATE detail_monitoring SET nilai_pengukuran=?,status_detail=?,catatan=?,parameter_lingkungan_id_parameter=? WHERE id_detail=?")) {
                    ps.setBigDecimal(1, java.math.BigDecimal.valueOf(nilai));
                    ps.setString(2, st.name());
                    ps.setString(3, catatan);
                    ps.setInt(4, idParam);
                    ps.setInt(5, idDetail);
                    if (ps.executeUpdate() != 1)throw new DataNotFoundException("Pengukuran tidak ditemukan.");
                }

                rehitungStatus(c, idMon);
                c.commit();
                return new DetailMonitoring(idDetail, find(idMon), p, nilai, st, catatan);
            }

            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }

        catch (SQLException e) {
            throw new IllegalStateException("Gagal mengubah detail monitoring: " + e.getMessage(), e);
        }
    }

    /** Menghapus satu pengukuran lalu menghitung ulang status monitoring. */
    public void hapusDetail(int idDetail) {
        int idMon;

        try (Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("SELECT monitoring_lingkungan_id_monitoring FROM detail_monitoring WHERE id_detail=? FOR UPDATE")) {
                    ps.setInt(1, idDetail);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next())throw new DataNotFoundException("Pengukuran tidak ditemukan.");
                        idMon = rs.getInt(1);
                    }
                }

                kunciPengukuran(c,idMon);
                try (PreparedStatement ps = c.prepareStatement("DELETE FROM detail_monitoring WHERE id_detail=?")) {
                    ps.setInt(1, idDetail);
                    if (ps.executeUpdate() != 1)throw new DataNotFoundException("Pengukuran tidak ditemukan.");
                }

                rehitungStatus(c, idMon);
                c.commit();
            }

            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }

        catch (SQLException e) {
            throw new IllegalStateException("Gagal menghapus detail monitoring: " + e.getMessage(), e);
        }
    }

    /** Hitung ulang status tertinggi dan tutup lokasi bila BERBAHAYA. */
    private void rehitungStatus(Connection c,int idMon) throws SQLException {
        String sql="UPDATE monitoring_lingkungan SET status_monitoring=CASE WHEN EXISTS (SELECT 1 FROM detail_monitoring WHERE monitoring_lingkungan_id_monitoring=? AND status_detail='BERBAHAYA') THEN 'BERBAHAYA' WHEN EXISTS (SELECT 1 FROM detail_monitoring WHERE monitoring_lingkungan_id_monitoring=? AND status_detail='PERINGATAN') THEN 'PERINGATAN' ELSE 'NORMAL' END WHERE id_monitoring=?";
        try(PreparedStatement ps=c.prepareStatement(sql)){ps.setInt(1,idMon);ps.setInt(2,idMon);ps.setInt(3,idMon);ps.executeUpdate();}
        String upd="UPDATE lokasi l JOIN monitoring_lingkungan m ON m.lokasi_id_lokasi=l.id_lokasi SET l.status_operasional=CASE WHEN m.status_monitoring='BERBAHAYA' THEN 'DITUTUP_SEMENTARA' ELSE 'AKTIF' END WHERE m.id_monitoring=? AND l.status_operasional<>'NONAKTIF' AND m.id_monitoring=(SELECT MAX(x.id_monitoring) FROM monitoring_lingkungan x WHERE x.lokasi_id_lokasi=l.id_lokasi AND (x.catatan IS NULL OR x.catatan NOT IN (?,?)))";
        try(PreparedStatement ps=c.prepareStatement(upd)){ps.setInt(1,idMon);ps.setString(2,MENUNGGU);ps.setString(3,DISETUJUI);ps.executeUpdate();}
    }

    /** Menghapus monitoring beserta seluruh pengukurannya. */
    public void hapusMonitoring(int id) {
        MonitoringLingkungan m = find(id);
        if (m.getStatusPenanganan() == StatusPenanganan.DALAM_PENANGANAN)throw new ValidationException("Monitoring dalam penanganan tidak dapat dihapus.");

        try (Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                try (PreparedStatement ps = c.prepareStatement("DELETE FROM detail_monitoring WHERE monitoring_lingkungan_id_monitoring=?")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }

                try (PreparedStatement ps = c.prepareStatement("DELETE FROM monitoring_lingkungan WHERE id_monitoring=?")) {
                    ps.setInt(1, id);
                    if (ps.executeUpdate() != 1)throw new DataNotFoundException("Monitoring tidak ditemukan.");
                }

                c.commit();
            }

            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }

        catch (SQLException e) {
            throw new IllegalStateException("Gagal menghapus monitoring: " + e.getMessage(), e);
        }
    }

    /** Memperbarui lokasi, tanggal, dan catatan monitoring yang sudah ada. */
    public MonitoringLingkungan ubahMonitoring(int id, int lokasiId, LocalDateTime t, String catatan) {
        MonitoringLingkungan m = find(id);
        if(m.getStatusPenanganan()==StatusPenanganan.SELESAI)throw new ValidationException("Kegiatan selesai tidak dapat diubah.");
        if (t == null)throw new ValidationException("Tanggal monitoring wajib dipilih.");
        if (t.isAfter(LocalDateTime.now()))throw new ValidationException("Waktu monitoring di masa depan.");
        Lokasi l = loc.findById(lokasiId).orElseThrow(() -> new DataNotFoundException("Lokasi tidak ditemukan."));

        MonitoringLingkungan updated = new MonitoringLingkungan(id, l, m.getPetugasHSE(), t,
                m.getStatusMonitoring(), m.getTindakLanjut(), m.getStatusPenanganan(), catatan);
        mon.update(updated);
        return updated;
    }

    public void ubahStatusLokasi(int id, StatusLokasi status) {
        if (status == null)throw new ValidationException("Status lokasi wajib dipilih.");
        Lokasi l = find(id).getLokasi();
        l.setStatusOperasional(status);
        loc.update(l);
    }
    
    public MonitoringLingkungan cariMonitoringById(int id) {
        return find(id);
    }
    
    public List<MonitoringLingkungan> tampilkanSemuaMonitoring() {
        return mon.findAll();
    }
    
    /** Daftar lokasi tampil (NONAKTIF disembunyikan) untuk katalog Kondisi Lokasi HSE. */
    public List<Lokasi> tampilkanSemuaLokasi() {
        return loc.findAll();
    }
    
    public List<MonitoringLingkungan> tampilkanMonitoringByLokasi(int id) {
        if (!loc.findById(id).isPresent())throw new DataNotFoundException("Lokasi tidak ditemukan.");
        return mon.findByLokasi(id);
    }
}
