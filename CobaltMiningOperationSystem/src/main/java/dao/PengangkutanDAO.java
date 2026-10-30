/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.StatusPengangkutan;
import java.sql.*;
import java.util.*;
import model.*;
import repository.PengangkutanRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class PengangkutanDAO implements PengangkutanRepository {
    private final ProduksiDAO produksiDAO = new ProduksiDAO();
    
    private final PegawaiDAO pegawaiDAO = new PegawaiDAO();
    
    private final KendaraanDAO kendaraanDAO = new KendaraanDAO();
    
    private final LokasiDAO lokasiDAO = new LokasiDAO();
    
    private Pengangkutan map(ResultSet rs) throws SQLException {
        int prodId = rs.getInt("produksi_tambang_id_produksi"), opsId = rs.getInt("petugas_operasional_id_pegawai");
        int driverId = rs.getInt("driver_id_pegawai"), kendId = rs.getInt("kendaraan_id_kendaraan");
        int asalId = rs.getInt("lokasi_id_lokasi"), tujuanId = rs.getInt("lokasi_tujuan_id_lokasi");
        ProduksiTambang produksi = produksiDAO.findById(prodId).orElseThrow(() -> new exception.DataNotFoundException("Produksi tidak ditemukan: "+prodId));
        Pegawai ops = pegawaiDAO.findById(opsId).orElseThrow(() -> new exception.DataNotFoundException("Petugas tidak ditemukan: "+opsId));
        Pegawai driver = pegawaiDAO.findById(driverId).orElseThrow(() -> new exception.DataNotFoundException("model.Driver tidak ditemukan: "+driverId));
        
        if (!(ops instanceof PetugasOperasional) || !(driver instanceof model.Driver))throw new SQLException("Subtype pegawai pengangkutan tidak sesuai.");
        Kendaraan kendaraan = kendaraanDAO.findById(kendId).orElseThrow(() -> new exception.DataNotFoundException("Kendaraan tidak ditemukan: "+kendId));
        Lokasi asal = lokasiDAO.findById(asalId).orElseThrow(() -> new exception.DataNotFoundException("Lokasi asal tidak ditemukan: "+asalId));
        Lokasi tujuan = lokasiDAO.findById(tujuanId).orElseThrow(() -> new exception.DataNotFoundException("Lokasi tujuan tidak ditemukan: "+tujuanId));
        return new Pengangkutan(rs.getInt("id_pengangkutan"), produksi, (PetugasOperasional)ops, kendaraan,
                (model.Driver)driver, asal, tujuan, JdbcSupport.date(rs,
                "tanggal_pengangkutan"), JdbcSupport.datetime(rs,"waktu_mulai"), JdbcSupport.datetime(rs,
                "waktu_selesai"), rs.getDouble("jumlah_muatan"), JdbcSupport.enumValue(rs,
                "status_pengangkutan", StatusPengangkutan.class));
    }
    
    private static void bind(PreparedStatement ps, Pengangkutan p) throws SQLException {
        JdbcSupport.date(ps, 1, p.getTanggalPengangkutan());
        JdbcSupport.datetime(ps, 2, p.getWaktuMulai());
        JdbcSupport.datetime(ps, 3, p.getWaktuSelesai());
        ps.setBigDecimal(4, java.math.BigDecimal.valueOf(p.getJumlahMuatan()));
        ps.setString(5, p.getStatusPengangkutan().name());
        ps.setInt(6, p.getProduksi().getIdProduksi());
        ps.setInt(7, p.getKendaraan().getIdKendaraan());
        ps.setInt(8, p.getLokasiAsal().getIdLokasi());
        ps.setInt(9, p.getLokasiTujuan().getIdLokasi());
        ps.setInt(10, p.getPetugasOperasional().getIdPegawai());
        ps.setInt(11, p.getDriver().getIdPegawai());
    }
    
    @Override
    public Pengangkutan save(Pengangkutan p) {
        String sql = "INSERT INTO pengangkutan (tanggal_pengangkutan,waktu_mulai,waktu_selesai,jumlah_muatan,status_pengangkutan,produksi_tambang_id_produksi,kendaraan_id_kendaraan,lokasi_id_lokasi,lokasi_tujuan_id_lokasi,petugas_operasional_id_pegawai,driver_id_pegawai) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, p);
            ps.executeUpdate();
            JdbcSupport.generated(ps, p::setIdPengangkutan);
            return p;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan pengangkutan", e);
        }
    }
    
    @Override
    public void update(Pengangkutan p) {
        String sql = "UPDATE pengangkutan SET tanggal_pengangkutan=?,waktu_mulai=?,waktu_selesai=?,jumlah_muatan=?,status_pengangkutan=?,produksi_tambang_id_produksi=?,kendaraan_id_kendaraan=?,lokasi_id_lokasi=?,lokasi_tujuan_id_lokasi=?,petugas_operasional_id_pegawai=?,driver_id_pegawai=? WHERE id_pengangkutan=?";
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            bind(ps, p);
            ps.setInt(12, p.getIdPengangkutan());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Pengangkutan");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui pengangkutan", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("DELETE FROM pengangkutan WHERE id_pengangkutan=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(),"Pengangkutan");
        }
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus pengangkutan", e);
        }
    }
    
    @Override
    public Optional<Pengangkutan> findById(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("SELECT * FROM pengangkutan WHERE id_pengangkutan=?")) {
            ps.setInt(1, id);
    
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari pengangkutan", e);
        }
    }
    
    @Override
    public List<Pengangkutan> findAll() {
        return search("SELECT * FROM pengangkutan ORDER BY id_pengangkutan", null);
    }
    
    @Override
    public List<Pengangkutan> findByProduksi(int id) {
        return search("SELECT * FROM pengangkutan WHERE produksi_tambang_id_produksi=? ORDER BY id_pengangkutan", id);
    }
    
    @Override
    public List<Pengangkutan> findByKendaraan(int id) {
        return search("SELECT * FROM pengangkutan WHERE kendaraan_id_kendaraan=? ORDER BY id_pengangkutan",
                id);
    }
    
    @Override
    public List<Pengangkutan> findByDriver(int id) {
        return search("SELECT * FROM pengangkutan WHERE driver_id_pegawai=? ORDER BY id_pengangkutan", id);
    }
    
    private List<Pengangkutan> search(String sql, Integer id) {
        List<Pengangkutan> result = new ArrayList<>();
        
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            if (id != null)ps.setInt(1, id);
        
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next())result.add(map(rs));
            }
            return result;
        }
    
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca pengangkutan", e);
        }
    }
}
