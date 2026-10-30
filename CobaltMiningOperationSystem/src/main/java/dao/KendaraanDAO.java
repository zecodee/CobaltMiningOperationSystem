/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.StatusKendaraan;
import java.sql.*;
import java.util.*;
import model.Kendaraan;
import repository.KendaraanRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class KendaraanDAO implements KendaraanRepository {
    static Kendaraan map(ResultSet rs) throws SQLException {
        return new Kendaraan(rs.getInt("id_kendaraan"), rs.getString("jenis_kendaraan"),
                rs.getString("nomor_polisi"), rs.getDouble("kapasitas"),
                rs.getInt("tahun_kendaraan"), JdbcSupport.enumValue(rs,"status_kendaraan",
                StatusKendaraan.class));
    }
    
    @Override
    public Kendaraan save(Kendaraan data) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("INSERT INTO kendaraan (jenis_kendaraan,nomor_polisi,kapasitas,tahun_kendaraan,status_kendaraan) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, data);
            ps.executeUpdate();
            JdbcSupport.generated(ps, data::setIdKendaraan);
            return data;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan kendaraan", e);
        }
    }
    
    private static void bind(PreparedStatement ps, Kendaraan d) throws SQLException {
        ps.setString(1, d.getJenisKendaraan());
        ps.setString(2, d.getNomorPolisi());
        ps.setBigDecimal(3, java.math.BigDecimal.valueOf(d.getKapasitas()));
        ps.setInt(4, d.getTahunKendaraan());
        ps.setString(5, d.getStatusKendaraan().name());
    }
    
    @Override
    public void update(Kendaraan data) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("UPDATE kendaraan SET jenis_kendaraan=?,nomor_polisi=?,kapasitas=?,tahun_kendaraan=?,status_kendaraan=? WHERE id_kendaraan=?")) {
            bind(ps, data);
            ps.setInt(6, data.getIdKendaraan());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Kendaraan");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui kendaraan", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("DELETE FROM kendaraan WHERE id_kendaraan=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(),"Kendaraan");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus kendaraan", e);
        }
    }
    
    @Override
    public Optional<Kendaraan> findById(int id) {
        return one("SELECT * FROM kendaraan WHERE id_kendaraan=?", id, null);
    }
    
    @Override
    public Optional<Kendaraan> findByNomorPolisi(String nomor) {
        return one("SELECT * FROM kendaraan WHERE nomor_polisi=?", null, nomor);
    }
    
    private Optional<Kendaraan> one(String sql, Integer id, String nomor) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement(sql)) {
            if (id != null) ps.setInt(1, id);
            else ps.setString(1, nomor);
            
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari kendaraan", e);
        }
    }
    
    @Override
    public List<Kendaraan> findAll() {
        List<Kendaraan> result = new ArrayList<>();
        
        try(Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("SELECT * FROM kendaraan ORDER BY id_kendaraan");ResultSet rs = ps.executeQuery()) {
            while (rs.next()) result.add(map(rs));
            return result;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca kendaraan", e);
        }
    }
}
