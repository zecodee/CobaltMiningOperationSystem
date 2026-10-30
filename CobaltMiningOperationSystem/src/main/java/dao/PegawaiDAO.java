/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.*;
import java.sql.*;
import java.util.*;
import model.*;
import repository.PegawaiRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class PegawaiDAO implements PegawaiRepository {
    private static final String SELECT = "SELECT p.*,a.kode_admin,a.tanggal_mulai_akses,o.shift_kerja,h.no_sertifikasi_hse,h.masa_berlaku_sertifikasi,m.divisi_tanggung_jawab,d.no_sim,d.masa_berlaku_sim,d.status_driver "             + "FROM pegawai p LEFT JOIN admin a ON a.id_pegawai=p.id_pegawai LEFT JOIN petugas_operasional o ON o.id_pegawai=p.id_pegawai "             + "LEFT JOIN petugas_hse h ON h.id_pegawai=p.id_pegawai LEFT JOIN manager m ON m.id_pegawai=p.id_pegawai "             + "LEFT JOIN driver d ON d.id_pegawai=p.id_pegawai ";
    
    static Pegawai map(ResultSet rs) throws SQLException {
        int id = rs.getInt("id_pegawai");
        String nama = rs.getString("nama_pegawai"), hp = rs.getString("no_hp");
        java.time.LocalDate masuk = JdbcSupport.date(rs,"tanggal_masuk");
        StatusPegawai status = JdbcSupport.enumValue(rs,"status_pegawai", StatusPegawai.class);
        
        if (rs.getString("kode_admin") != null)return new Admin(id, nama, hp, masuk, status,
                rs.getString("kode_admin"), JdbcSupport.date(rs,"tanggal_mulai_akses"));
        
        if (rs.getString("shift_kerja") != null)return new PetugasOperasional(id, nama, hp, masuk, status,
                JdbcSupport.enumValue(rs,"shift_kerja", ShiftKerja.class));
        
        if (rs.getString("no_sertifikasi_hse") != null)return new PetugasHSE(id, nama, hp, masuk, status,
                rs.getString("no_sertifikasi_hse"), JdbcSupport.date(rs,"masa_berlaku_sertifikasi"));
        
        if (rs.getString("divisi_tanggung_jawab") != null)return new Manager(id, nama, hp, masuk, status,
                rs.getString("divisi_tanggung_jawab"));
        
        if (rs.getString("no_sim") != null)return new model.Driver(id, nama, hp, masuk, status,
                rs.getString("no_sim"), JdbcSupport.date(rs,"masa_berlaku_sim"), JdbcSupport.enumValue(rs,
                "status_driver", StatusDriver.class));
        
        throw new SQLException("Pegawai #"+id+" tidak memiliki subtype; periksa integritas database.");
    }
    
    private static String table(Pegawai p) {
        if (p instanceof Admin)return "admin";
        if (p instanceof PetugasOperasional)return "petugas_operasional";
        if (p instanceof PetugasHSE)return "petugas_hse";
        if (p instanceof Manager)return "manager";
        if (p instanceof model.Driver)return "driver";
        throw new IllegalArgumentException("Jenis pegawai tidak dikenal.");
    }
    
    private static void subtype(Connection c, Pegawai p, boolean insert) throws SQLException {
        String table = table(p), sql;
    
        if (p instanceof Admin)sql = (insert?"INSERT INTO admin (kode_admin,tanggal_mulai_akses,id_pegawai) VALUES (?,?,?)":"UPDATE admin SET kode_admin=?,tanggal_mulai_akses=? WHERE id_pegawai=?");
        
        else if (p instanceof PetugasOperasional)sql = (insert?"INSERT INTO petugas_operasional (shift_kerja,id_pegawai) VALUES (?,?)":"UPDATE petugas_operasional SET shift_kerja=? WHERE id_pegawai=?");
        
        else if (p instanceof PetugasHSE)sql = (insert?"INSERT INTO petugas_hse (no_sertifikasi_hse,masa_berlaku_sertifikasi,id_pegawai) VALUES (?,?,?)":"UPDATE petugas_hse SET no_sertifikasi_hse=?,masa_berlaku_sertifikasi=? WHERE id_pegawai=?");
        
        else if (p instanceof Manager)sql = (insert?"INSERT INTO manager (divisi_tanggung_jawab,id_pegawai) VALUES (?,?)":"UPDATE manager SET divisi_tanggung_jawab=? WHERE id_pegawai=?");
        
        else sql = (insert?"INSERT INTO driver (no_sim,masa_berlaku_sim,status_driver,id_pegawai) VALUES (?,?,?,?)":"UPDATE driver SET no_sim=?,masa_berlaku_sim=?,status_driver=? WHERE id_pegawai=?");
        
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            int i = 1;
        
            if (p instanceof Admin) {
                Admin d = (Admin)p;
                ps.setString(i++, d.getKodeAdmin());
                JdbcSupport.date(ps, i++, d.getTanggalMulaiAkses());
            }
            
            else if (p instanceof PetugasOperasional) {
                ps.setString(i++, ((PetugasOperasional)p).getShiftKerja().name());
            }
            
            else if (p instanceof PetugasHSE) {
                PetugasHSE d = (PetugasHSE)p;
                ps.setString(i++, d.getNoSertifikasiHSE());
                JdbcSupport.date(ps, i++, d.getMasaBerlakuSertifikasi());
            }
            
            else if (p instanceof Manager) {
                ps.setString(i++, ((Manager)p).getDivisiTanggungJawab());
            }
            
            else {
                model.Driver d = (model.Driver)p;
                ps.setString(i++, d.getNoSim());
                JdbcSupport.date(ps, i++, d.getMasaBerlakuSim());
                ps.setString(i++, d.getStatusDriver().name());
            }
            
            ps.setInt(i, p.getIdPegawai());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Subtype "+table);
        }
    }
    
    @Override
    public Pegawai save(Pegawai p) {
        table(p);
    
        try(Connection c = JdbcSupport.open()) {
            c.setAutoCommit(false);
            try(PreparedStatement ps = c.prepareStatement("INSERT INTO pegawai (nama_pegawai,no_hp,tanggal_masuk,status_pegawai) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, p.getNamaPegawai());
                ps.setString(2, p.getNoHp());
                JdbcSupport.date(ps, 3, p.getTanggalMasuk());
                ps.setString(4, p.getStatusPegawai().name());
                ps.executeUpdate();
                JdbcSupport.generated(ps, p::setIdPegawai);
                subtype(c, p, true);
                c.commit();
                return p;
            }
            
            catch (Exception e) {
                JdbcSupport.rollback(c, e);
                throw e;
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan pegawai", e);
        }
    }
    
    @Override
    public void update(Pegawai p) {
        table(p);
        
        try(Connection c = JdbcSupport.open()) {
            c.setAutoCommit(false);
            
            try {
                String current = typeForUpdate(c, p.getIdPegawai());
                if (!current.equals(table(p)))throw new exception.ValidationException("Jenis pegawai tidak boleh diubah.");

                try(PreparedStatement ps = c.prepareStatement("UPDATE pegawai SET nama_pegawai=?,no_hp=?,tanggal_masuk=?,status_pegawai=? WHERE id_pegawai=?")) {
                    ps.setString(1, p.getNamaPegawai());
                    ps.setString(2, p.getNoHp());
                    JdbcSupport.date(ps, 3, p.getTanggalMasuk());
                    ps.setString(4, p.getStatusPegawai().name());
                    ps.setInt(5, p.getIdPegawai());
                    JdbcSupport.requireChanged(ps.executeUpdate(),"Pegawai");
                }
                subtype(c, p, false);
                c.commit();
            }
            
            catch (Exception e) {
                JdbcSupport.rollback(c, e);
                throw e;
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui pegawai", e);
        }
    }
    
    private String typeForUpdate(Connection c, int id) throws SQLException {
        String[] tables = {
            "admin","petugas_operasional","petugas_hse","manager","driver"
        };
        
        for (String table:tables)try(PreparedStatement ps = c.prepareStatement("SELECT 1 FROM "+table+" WHERE id_pegawai=?")) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next())return table;
            }
        }
        throw new exception.DataNotFoundException("Subtype pegawai #"+id+" tidak ditemukan.");
    }
    
    @Override
    public void delete(int id) {
        try(Connection c = JdbcSupport.open()) {
            c.setAutoCommit(false);
            
            try {
                String type = typeForUpdate(c, id);
            
                try(PreparedStatement ps = c.prepareStatement("DELETE FROM "+type+" WHERE id_pegawai=?")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                
                try(PreparedStatement ps = c.prepareStatement("DELETE FROM pegawai WHERE id_pegawai=?")) {
                    ps.setInt(1, id);
                    JdbcSupport.requireChanged(ps.executeUpdate(),"Pegawai");
                }
                c.commit();
            }
            
            catch (Exception e) {
                JdbcSupport.rollback(c, e);
                throw e;
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus pegawai", e);
        }
    }
    
    @Override
    public Optional<Pegawai> findById(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(SELECT+"WHERE p.id_pegawai=?")) {
            ps.setInt(1, id);
    
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari pegawai", e);
        }
    }
    
    @Override
    public List<Pegawai> findAll() {
        return search(SELECT+"ORDER BY p.id_pegawai", null);
    }
    
    @Override
    public List<Pegawai> findByNama(String nama) {
        return search(SELECT+"WHERE p.nama_pegawai LIKE ? ORDER BY p.nama_pegawai","%"+nama+"%");
    }
    
    @Override
    public List<Pegawai> findByJenisPegawai(String jenis) {
        String t;
    
        switch (jenis.trim().toUpperCase(java.util.Locale.ROOT).replace(' ','_')) {
            case "ADMIN":t = "a";
            break;
            case "PETUGAS_OPERASIONAL":t = "o";
            break;
            case "PETUGAS_HSE":t = "h";
            break;
            case "MANAGER":t = "m";
            break;
            case "DRIVER":t = "d";
            break;
            default:throw new exception.ValidationException("Jenis pegawai tidak dikenal: "+jenis);
        }
        return search(SELECT+"WHERE "+t+".id_pegawai IS NOT NULL ORDER BY p.nama_pegawai", null);
    }
    
    private List<Pegawai> search(String sql, String keyword) {
        List<Pegawai> result = new ArrayList<>();
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            if (keyword != null)ps.setString(1, keyword);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next())result.add(map(rs));
            }
            return result;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca pegawai", e);
        }
    }
}
