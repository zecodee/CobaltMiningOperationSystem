/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.*;
import model.Pegawai;
import model.User;
import repository.UserRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class UserDAO implements UserRepository {
    private final PegawaiDAO pegawaiDAO = new PegawaiDAO();
    
    private User map(ResultSet rs) throws SQLException {
        int idPegawai = rs.getInt("pegawai_id_pegawai");
        Pegawai pegawai = pegawaiDAO.findById(idPegawai).orElseThrow(()->new exception.DataNotFoundException("Pegawai akun tidak ditemukan: "+idPegawai));
        return new User(rs.getInt("id_user"), pegawai, rs.getString("username"), rs.getString("password"));
    }
    
    private void validate(User u) {
        if (u.getPegawai() == null)throw new exception.ValidationException("Pegawai akun wajib dipilih.");
        if (u.getPegawai() instanceof model.Driver)throw new exception.ValidationException("Driver tidak memiliki akses login.");
    }
    
    @Override
    public User save(User u) {
        validate(u);
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("INSERT INTO user (username,password,pegawai_id_pegawai) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getPegawai().getIdPegawai());
            ps.executeUpdate();
            JdbcSupport.generated(ps, u::setIdUser);
            return u;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan akun", e);
        }
    }
    
    @Override
    public void update(User u) {
        validate(u);
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("UPDATE user SET username=?,password=?,pegawai_id_pegawai=? WHERE id_user=?")) {
            ps.setString(1, u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setInt(3, u.getPegawai().getIdPegawai());
            ps.setInt(4, u.getIdUser());
            JdbcSupport.requireChanged(ps.executeUpdate(),"User");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui akun", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("DELETE FROM user WHERE id_user=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(),"User");
        }
    
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus akun", e);
        }
    }
    
    @Override
    public Optional<User> findById(int id) {
        return one("SELECT * FROM user WHERE id_user=?", id, null);
    }
    
    @Override
    public Optional<User> findByUsername(String name) {
        return one("SELECT * FROM user WHERE username=?", null, name);
    }
    
    @Override
    public Optional<User> findByPegawai(int id) {
        return one("SELECT * FROM user WHERE pegawai_id_pegawai=?", id, null);
    }
    
    private Optional<User> one(String sql, Integer id, String name) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            if (id != null)ps.setInt(1, id);
            else ps.setString(1, name);
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
    
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari akun", e);
        }
    }
    
    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("SELECT * FROM user ORDER BY id_user");ResultSet rs = ps.executeQuery()) {
            while (rs.next())result.add(map(rs));
            return result;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca akun", e);
        }
    }
}
