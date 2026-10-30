/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import model.ParameterLingkungan;
import repository.ParameterRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class ParameterDAO implements ParameterRepository {
    static ParameterLingkungan map(ResultSet rs) throws SQLException {
        return new ParameterLingkungan(rs.getInt("id_parameter"), rs.getString("nama_parameter"),
                rs.getString("satuan"), JdbcSupport.nullableDouble(rs,"batas_minimum"),
                JdbcSupport.nullableDouble(rs,"batas_maksimum"), rs.getString("keterangan"));
    }
    
    private static void bind(PreparedStatement ps, ParameterLingkungan d) throws SQLException {
        ps.setString(1, d.getNamaParameter());
        ps.setString(2, d.getSatuan());
        JdbcSupport.nullableDouble(ps, 3, d.getBatasMinimum());
        JdbcSupport.nullableDouble(ps, 4, d.getBatasMaksimum());
        ps.setString(5, d.getKeterangan());
    }
    
    @Override
    public ParameterLingkungan save(ParameterLingkungan d) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("INSERT INTO parameter_lingkungan (nama_parameter,satuan,batas_minimum,batas_maksimum,keterangan) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, d);
            ps.executeUpdate();
            JdbcSupport.generated(ps, d::setIdParameter);
            return d;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan parameter", e);
        }
    }
    
    @Override
    public void update(ParameterLingkungan d) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("UPDATE parameter_lingkungan SET nama_parameter=?,satuan=?,batas_minimum=?,batas_maksimum=?,keterangan=? WHERE id_parameter=?")) {
            bind(ps, d);
            ps.setInt(6, d.getIdParameter());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Parameter");
        }
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui parameter", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("DELETE FROM parameter_lingkungan WHERE id_parameter=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(),"Parameter");
        }
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus parameter", e);
        }
    }
    
    @Override
    public Optional<ParameterLingkungan> findById(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("SELECT * FROM parameter_lingkungan WHERE id_parameter=?")) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari parameter", e);
        }
    }
    
    @Override
    public List<ParameterLingkungan> findAll() {
        return search("SELECT * FROM parameter_lingkungan ORDER BY id_parameter", null);
    }
    
    @Override
    public List<ParameterLingkungan> findByNama(String nama) {
        return search("SELECT * FROM parameter_lingkungan WHERE nama_parameter LIKE ? ORDER BY nama_parameter","%"+nama+"%");
    }
    
    private List<ParameterLingkungan> search(String sql, String keyword) {
        List<ParameterLingkungan> result = new ArrayList<>();
        
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            if (keyword != null)ps.setString(1, keyword);
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next())result.add(map(rs));
            }
            return result;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca parameter", e);
        }
    }
}
