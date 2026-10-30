/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import enums.*;
import java.sql.*;
import java.util.*;
import model.*;
import repository.MonitoringRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class MonitoringDAO implements MonitoringRepository {
    private final LokasiDAO lokasiDAO = new LokasiDAO();
    
    private final PegawaiDAO pegawaiDAO = new PegawaiDAO();
    
    private final ParameterDAO parameterDAO = new ParameterDAO();
    
    private MonitoringLingkungan map(ResultSet rs) throws SQLException {
        int lokasiId = rs.getInt("lokasi_id_lokasi"), hseId = rs.getInt("petugas_hse_id_pegawai");
        Lokasi lokasi = lokasiDAO.findById(lokasiId).orElseThrow(()->new exception.DataNotFoundException("Lokasi tidak ditemukan: "+lokasiId));
        Pegawai hse = pegawaiDAO.findById(hseId).orElseThrow(()->new exception.DataNotFoundException("Petugas HSE tidak ditemukan: "+hseId));
    
        if (!(hse instanceof PetugasHSE))throw new SQLException("Pegawai monitoring bukan PetugasHSE.");
        MonitoringLingkungan m = new MonitoringLingkungan(rs.getInt("id_monitoring"), lokasi, (PetugasHSE)hse,
                JdbcSupport.datetime(rs,"tanggal_monitoring"), JdbcSupport.enumValue(rs,"status_monitoring", StatusMonitoring.class), 
                rs.getString("tindak_lanjut"), JdbcSupport.enumValue(rs,"status_penanganan", StatusPenanganan.class), rs.getString("catatan"));
        loadDetails(m);
        return m;
    }
    
    private void loadDetails(MonitoringLingkungan m) throws SQLException {
        String sql = "SELECT * FROM detail_monitoring WHERE monitoring_lingkungan_id_monitoring=? ORDER BY id_detail";
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, m.getIdMonitoring());
        
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("parameter_lingkungan_id_parameter");
                    ParameterLingkungan p = parameterDAO.findById(id).orElseThrow(()->new exception.DataNotFoundException("Parameter tidak ditemukan: "+id));
                    m.tambahDetail(new DetailMonitoring(rs.getInt("id_detail"), m, p,
                            rs.getDouble("nilai_pengukuran"), JdbcSupport.enumValue(rs,"status_detail", StatusDetail.class), rs.getString("catatan")));
                }
            }
        }
    }
    
    private static void bind(PreparedStatement ps, MonitoringLingkungan m) throws SQLException {
        JdbcSupport.datetime(ps, 1, m.getTanggalMonitoring());
        ps.setString(2, m.getStatusMonitoring().name());
        ps.setString(3, m.getTindakLanjut());
        ps.setString(4, m.getStatusPenanganan().name());
        ps.setString(5, m.getCatatan());
        ps.setInt(6, m.getLokasi().getIdLokasi());
        ps.setInt(7, m.getPetugasHSE().getIdPegawai());
    }
    
    private static void details(Connection c, MonitoringLingkungan m) throws SQLException {
        String sql = "INSERT INTO detail_monitoring (nilai_pengukuran,status_detail,catatan,monitoring_lingkungan_id_monitoring,parameter_lingkungan_id_parameter) VALUES (?,?,?,?,?)";
    
        for (DetailMonitoring d:m.getDetailMonitoring()) {
        
            try(PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setBigDecimal(1, java.math.BigDecimal.valueOf(d.getNilaiPengukuran()));
                ps.setString(2, d.getStatusDetail().name());
                ps.setString(3, d.getCatatan());
                ps.setInt(4, m.getIdMonitoring());
                ps.setInt(5, d.getParameter().getIdParameter());
                ps.executeUpdate();
                JdbcSupport.generated(ps, d::setIdDetail);
            }
        }
    }
    
    @Override
    public MonitoringLingkungan save(MonitoringLingkungan m) {
        String sql = "INSERT INTO monitoring_lingkungan (tanggal_monitoring,status_monitoring,tindak_lanjut,status_penanganan,catatan,lokasi_id_lokasi,petugas_hse_id_pegawai) VALUES (?,?,?,?,?,?,?)";
       
        try(Connection c = JdbcSupport.open()) {
            c.setAutoCommit(false);
        
            try(PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                bind(ps, m);
                ps.executeUpdate();
                JdbcSupport.generated(ps, m::setIdMonitoring);
                details(c, m);
                c.commit();
                return m;
            }
            
            catch (Exception e) {
                JdbcSupport.rollback(c, e);
                throw e;
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menyimpan monitoring", e);
        }
    }
    
    @Override
    public void update(MonitoringLingkungan m) {
        String sql = "UPDATE monitoring_lingkungan SET tanggal_monitoring=?,status_monitoring=?,tindak_lanjut=?,status_penanganan=?,catatan=?,lokasi_id_lokasi=?,petugas_hse_id_pegawai=? WHERE id_monitoring=?";
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            bind(ps, m);
            ps.setInt(8, m.getIdMonitoring());
            JdbcSupport.requireChanged(ps.executeUpdate(),"Monitoring");
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("memperbarui monitoring", e);
        }
    }
    
    @Override
    public void delete(int id) {
        try(Connection c = JdbcSupport.open()) {
            c.setAutoCommit(false);
    
            try {
            
                try(PreparedStatement ps = c.prepareStatement("DELETE FROM detail_monitoring WHERE monitoring_lingkungan_id_monitoring=?")) {
                    ps.setInt(1, id);
                    ps.executeUpdate();
                }
                
                try(PreparedStatement ps = c.prepareStatement("DELETE FROM monitoring_lingkungan WHERE id_monitoring=?")) {
                    ps.setInt(1, id);
                    JdbcSupport.requireChanged(ps.executeUpdate(),"Monitoring");
                }
                c.commit();
            }
            
            catch (Exception e) {
                JdbcSupport.rollback(c, e);
                throw e;
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("menghapus monitoring", e);
        }
    }
    
    @Override
    public Optional<MonitoringLingkungan> findById(int id) {
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement("SELECT * FROM monitoring_lingkungan WHERE id_monitoring=?")) {
            ps.setInt(1, id);
    
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next()?Optional.of(map(rs)):Optional.empty();
            }
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("mencari monitoring", e);
        }
    }
    
    @Override
    public List<MonitoringLingkungan> findAll() {
        return search("SELECT * FROM monitoring_lingkungan ORDER BY tanggal_monitoring DESC", null);
    }
    
    @Override
    public List<MonitoringLingkungan> findByLokasi(int id) {
        return search("SELECT * FROM monitoring_lingkungan WHERE lokasi_id_lokasi=? ORDER BY tanggal_monitoring DESC", id);
    }
    
    @Override
    public List<MonitoringLingkungan> findByPetugasHSE(int id) {
        return search("SELECT * FROM monitoring_lingkungan WHERE petugas_hse_id_pegawai=? ORDER BY tanggal_monitoring DESC", id);
    }
    
    private List<MonitoringLingkungan> search(String sql, Integer id) {
        List<MonitoringLingkungan> result = new ArrayList<>();
    
        try(Connection c = JdbcSupport.open();PreparedStatement ps = c.prepareStatement(sql)) {
            if (id != null)ps.setInt(1, id);
         
            try(ResultSet rs = ps.executeQuery()) {
                while (rs.next())result.add(map(rs));
            }
            
            return result;
        }
        
        catch (SQLException e) {
            throw JdbcSupport.fail("membaca monitoring", e);
        }
    }
}
