/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.StatusProduksi;
import java.sql.*;
import java.util.*;
import model.*;
import repository.ProduksiRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class ProduksiDAO implements ProduksiRepository {
    private final MaterialDAO materialDAO = new MaterialDAO();
    
    private final LokasiDAO lokasiDAO = new LokasiDAO();
    
    private final PegawaiDAO pegawaiDAO = new PegawaiDAO();
    
    private ProduksiTambang map(ResultSet rs) throws SQLException {
        int material = rs.getInt("jenis_material_id_material"), lokasi = rs.getInt("lokasi_id_lokasi"),
                pegawai = rs.getInt("petugas_operasional_id_pegawai");
        JenisMaterial m = materialDAO.findById(material).orElseThrow(()->new exception.DataNotFoundException("Material #"+material+" tidak ditemukan."));
        Lokasi l = lokasiDAO.findById(lokasi).orElseThrow(()->new exception.DataNotFoundException("Lokasi #"+lokasi+" tidak ditemukan."));
        Pegawai p = pegawaiDAO.findById(pegawai).orElseThrow(()->new exception.DataNotFoundException("Petugas #"+pegawai+" tidak ditemukan."));
    
        if (!(p instanceof PetugasOperasional))throw new SQLException("Petugas produksi bukan petugas operasional.");
        return new ProduksiTambang(rs.getInt("id_produksi"), m, l, (PetugasOperasional)p, JdbcSupport.date(rs,
                "tanggal_produksi"), rs.getDouble("jumlah_produksi"),
                rs.getDouble("jumlah_tersedia"), JdbcSupport.enumValue(rs,"status_produksi",
                StatusProduksi.class));
    }
    
    private static void bind(PreparedStatement ps, ProduksiTambang p) throws SQLException {
        JdbcSupport.date(ps, 1, p.getTanggalProduksi());
        ps.setBigDecimal(2, java.math.BigDecimal.valueOf(p.getJumlahProduksi()));
        ps.setBigDecimal(3, java.math.BigDecimal.valueOf(p.getJumlahTersedia()));
        ps.setString(4, p.getStatusProduksi().name());
        ps.setInt(5, p.getMaterial().getIdMaterial());
        ps.setInt(6, p.getLokasi().getIdLokasi());
        ps.setInt(7, p.getPetugasOperasional().getIdPegawai());
    }
    
    @Override
    public ProduksiTambang save(ProduksiTambang p) {
        String sql = "INSERT INTO produksi_tambang (tanggal_produksi,jumlah_produksi,jumlah_tersedia,status_produksi,jenis_material_id_material,lokasi_id_lokasi,petugas_operasional_id_pegawai) VALUES (?,?,?,?,?,?,?)";
        
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS)) {
            bind(ps, p);
            ps.executeUpdate();
            JdbcSupport.generated(ps, p::setIdProduksi);
            return p;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan produksi", e);
        }
    }
    
    @Override
    public void update(ProduksiTambang p) {
        String sql = "UPDATE produksi_tambang SET tanggal_produksi=?,jumlah_produksi=?,jumlah_tersedia=?,status_produksi=?,jenis_material_id_material=?,lokasi_id_lokasi=?,petugas_operasional_id_pegawai=? WHERE id_produksi=?";
        
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            bind(ps, p);
            ps.setInt(8, p.getIdProduksi());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Produksi");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui produksi", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("DELETE FROM produksi_tambang WHERE id_produksi=?")) {
            ps.setInt(1, id);
            JdbcSupport.requireChanged(ps.executeUpdate(),"Produksi");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus produksi", e);
        }
    }
    
    @Override
    public Optional<ProduksiTambang> findById(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("SELECT * FROM produksi_tambang WHERE id_produksi=?")) {
            ps.setInt(1, id);
            
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari produksi", e);
        }
    }
    
    @Override
    public List<ProduksiTambang> findAll() {
        return search("SELECT * FROM produksi_tambang ORDER BY id_produksi", null);
    }
    
    @Override
    public List<ProduksiTambang> findTersedia() {
        return search("SELECT * FROM produksi_tambang WHERE jumlah_tersedia>0 AND status_produksi IN ('TERSEDIA','SEBAGIAN_DIANGKUT') ORDER BY tanggal_produksi DESC", null);
    }
    
    @Override
    public List<ProduksiTambang> findByLokasi(int id) {
        return search("SELECT * FROM produksi_tambang WHERE lokasi_id_lokasi=? ORDER BY tanggal_produksi DESC", id);
    }
    
    private List<ProduksiTambang> search(String sql, Integer id) {
        List<ProduksiTambang> result = new ArrayList<>();
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            if (id != null)ps.setInt(1, id);
        
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next())result.add(map(rs));
            }
            return result;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca produksi", e);
        }
    }
}
