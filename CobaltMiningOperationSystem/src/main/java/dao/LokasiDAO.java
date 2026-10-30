/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.JenisLokasi;
import enums.StatusLokasi;
import java.sql.*;
import java.util.*;
import model.Lokasi;
import repository.LokasiRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class LokasiDAO implements LokasiRepository {
    static Lokasi map(ResultSet rs) throws SQLException {
        return new Lokasi(rs.getInt("id_lokasi"), rs.getString("nama_lokasi"),
                JdbcSupport.enumValue(rs, "jenis_lokasi", JenisLokasi.class),
                JdbcSupport.enumValue(rs, "status_operasional", StatusLokasi.class),
                rs.getString("keterangan"));
    }
    
    @Override
    public Lokasi save(Lokasi data) {
        String sql = "INSERT INTO lokasi (nama_lokasi,jenis_lokasi,status_operasional,keterangan) VALUES (?,?,?,?)";
        
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, data.getNamaLokasi());
            ps.setString(2, data.getJenisLokasi().name());
            ps.setString(3, data.getStatusOperasional().name());
            ps.setString(4, data.getKeterangan());
            ps.executeUpdate();
            JdbcSupport.generated(ps, data::setIdLokasi);
            return data;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan lokasi", e);
        }
    }
    
    @Override
    public void update(Lokasi data) {
        String sql = "UPDATE lokasi SET nama_lokasi=?,jenis_lokasi=?,status_operasional=?,keterangan=? WHERE id_lokasi=?";
        
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, data.getNamaLokasi());
            ps.setString(2, data.getJenisLokasi().name());
            ps.setString(3, data.getStatusOperasional().name());
            ps.setString(4, data.getKeterangan());
            ps.setInt(5, data.getIdLokasi());
            JdbcSupport.requireChanged(ps.executeUpdate(), "Lokasi");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui lokasi", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("DELETE FROM lokasi WHERE id_lokasi=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(), "Lokasi");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus lokasi", e);
        }
    }
    
    @Override
    public Optional<Lokasi> findById(int id) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("SELECT * FROM lokasi WHERE id_lokasi=?")) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(map(rs)) : Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari lokasi", e);
        }
    }
    
    @Override
    public List<Lokasi> findAll() {
        return search("SELECT * FROM lokasi ORDER BY id_lokasi", null);
    }
    
    @Override
    public List<Lokasi> findByNama(String nama) {
        return search("SELECT * FROM lokasi WHERE nama_lokasi LIKE ? ORDER BY nama_lokasi",
                "%" + nama + "%");
    }
    
    private List<Lokasi> search(String sql, String keyword) {
        List<Lokasi> items = new ArrayList<>();
        
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement(sql)) {
            if (keyword != null) ps.setString(1, keyword);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) items.add(map(rs));
            }
            
            return items;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca lokasi", e);
        }
    }
}
