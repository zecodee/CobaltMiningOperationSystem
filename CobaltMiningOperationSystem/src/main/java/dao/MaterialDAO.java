/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import model.JenisMaterial;
import repository.MaterialRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class MaterialDAO implements MaterialRepository {
    static JenisMaterial map(ResultSet rs) throws SQLException {
        return new JenisMaterial(rs.getInt("id_material"), rs.getString("nama_material"),
                rs.getString("satuan"), rs.getString("deskripsi"));
    }
    
    @Override
    public JenisMaterial save(JenisMaterial data) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("INSERT INTO jenis_material (nama_material,satuan,deskripsi) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, data.getNamaMaterial());
            ps.setString(2, data.getSatuan());
            ps.setString(3, data.getDeskripsi());
            ps.executeUpdate();
            JdbcSupport.generated(ps, data::setIdMaterial);
            return data;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan material", e);
        }
    }
    
    @Override
    public void update(JenisMaterial data) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("UPDATE jenis_material SET nama_material=?,satuan=?,deskripsi=? WHERE id_material=?")) {
            ps.setString(1, data.getNamaMaterial());
            ps.setString(2, data.getSatuan());
            ps.setString(3, data.getDeskripsi());
            ps.setInt(4, data.getIdMaterial());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Material");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui material", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("DELETE FROM jenis_material WHERE id_material=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(),"Material");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus material", e);
        }
    }
    
    @Override
    public Optional<JenisMaterial> findById(int id) {
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement("SELECT * FROM jenis_material WHERE id_material=?")) {
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? Optional.of(map(rs)) : Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari material", e);
        }
    }
    
    @Override
    public List<JenisMaterial> findAll() {
        return search("SELECT * FROM jenis_material ORDER BY id_material", null);
    }
    
    @Override
    public List<JenisMaterial> findByNama(String nama) {
        return search("SELECT * FROM jenis_material WHERE nama_material LIKE ? ORDER BY nama_material", "%"+nama+"%");
    }
    
    private List<JenisMaterial> search(String sql, String keyword) {
        List<JenisMaterial> items = new ArrayList<>();
        
        try (Connection c = JdbcSupport.open(); PreparedStatement ps = c.prepareStatement(sql)) {
            if (keyword != null) ps.setString(1, keyword);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) items.add(map(rs));
            }
            
            return items;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca material", e);
        }
    }
}
