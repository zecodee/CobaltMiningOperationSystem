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

public final class PengangkutanService {
    private final PengangkutanRepository haul;
    private final ProduksiRepository prod;
    private final KendaraanRepository vehicle;
    private final LokasiRepository loc;
    public PengangkutanService(PengangkutanRepository h, ProduksiRepository p, KendaraanRepository v,
            LokasiRepository l) {
        haul = h;
        prod = p;
        vehicle = v;
        loc = l;
    }
    private static void require(boolean b, String msg) {
        if (!b)throw new ValidationException(msg);
    }
    private static boolean validAmount(double v) {
        return Double.isFinite(v) && v>0 && Math.abs(v*100-Math.rint(v*100))<0.00001;
    }
    private Pengangkutan get(int id) {
        return haul.findById(id).orElseThrow(()->new DataNotFoundException("Pengangkutan tidak ditemukan."));
    }
    public Pengangkutan buatPengangkutan(int id, int idProd, PetugasOperasional ops, int idVehicle,
            model.Driver driver, int idAsal, int idTujuan, LocalDate date, double amount) {
        require(id == 0,"ID baru harus 0.");
        require(ops != null && ops.getStatusPegawai() == StatusPegawai.AKTIF,"Petugas operasional tidak aktif.");
        require(driver != null && driver.getStatusPegawai() == StatusPegawai.AKTIF
 && driver.getStatusDriver() == StatusDriver.TERSEDIA,"Driver tidak tersedia.");
        require(date != null && !date.isBefore(LocalDate.now()),"Tanggal pengangkutan tidak valid.");
        require(driver.isSimAktif(date),"SIM driver tidak berlaku pada tanggal pengangkutan.");
        require(validAmount(amount),"Muatan harus positif dengan maksimal 2 desimal.");
        ProduksiTambang p = prod.findById(idProd).orElseThrow(()->new DataNotFoundException("Produksi tidak ditemukan."));
        Kendaraan v = vehicle.findById(idVehicle).orElseThrow(()->new DataNotFoundException("Kendaraan tidak ditemukan."));
        Lokasi a = loc.findById(idAsal).orElseThrow(()->new DataNotFoundException("Lokasi asal tidak ditemukan."));
        Lokasi t = loc.findById(idTujuan).orElseThrow(()->new DataNotFoundException("Lokasi tujuan tidak ditemukan."));
        require(!date.isBefore(p.getTanggalProduksi()),"Tanggal pengangkutan sebelum produksi.");
        require(v.getStatusKendaraan() == StatusKendaraan.TERSEDIA && amount <= v.getKapasitas(),
                "Kendaraan tidak tersedia atau kapasitas terlampaui.");
        require(a.getIdLokasi() != t.getIdLokasi() && p.getLokasi().getIdLokasi() == a.getIdLokasi()
 && a.getStatusOperasional() == StatusLokasi.AKTIF
 && t.getStatusOperasional() == StatusLokasi.AKTIF && t.getJenisLokasi() == JenisLokasi.STOCKPILE,
                "Lokasi asal/tujuan tidak valid.");
        // Lock all shared scheduling resources in one transaction; insert in same transaction.
        try(Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                lock(c,"SELECT id_produksi FROM produksi_tambang WHERE id_produksi=? FOR UPDATE", idProd);
                lock(c,"SELECT id_kendaraan FROM kendaraan WHERE id_kendaraan=? FOR UPDATE", idVehicle);
                lock(c,"SELECT id_pegawai FROM driver WHERE id_pegawai=? FOR UPDATE", driver.getIdPegawai());
                double available;
                try(PreparedStatement ps = c.prepareStatement("SELECT jumlah_tersedia-(SELECT COALESCE(SUM(jumlah_muatan),0) FROM pengangkutan WHERE produksi_tambang_id_produksi=? AND status_pengangkutan IN ('DIJADWALKAN','DALAM_PERJALANAN')) AS available FROM produksi_tambang WHERE id_produksi=?")) {
                    ps.setInt(1, idProd);
                    ps.setInt(2, idProd);
                    try(ResultSet rs = ps.executeQuery()) {
                        if (!rs.next())throw new DataNotFoundException("Produksi tidak ditemukan.");
                        available = rs.getDouble(1);
                    }
                }
                require(amount <= available+0.000001,"Stok yang belum dipesan tidak mencukupi.");
                try(PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM pengangkutan WHERE (kendaraan_id_kendaraan=? OR driver_id_pegawai=?) AND (status_pengangkutan='DALAM_PERJALANAN' OR (status_pengangkutan='DIJADWALKAN' AND tanggal_pengangkutan=?))")) {
                    ps.setInt(1, idVehicle);
                    ps.setInt(2, driver.getIdPegawai());
                    ps.setDate(3, java.sql.Date.valueOf(date));
                    try(ResultSet rs = ps.executeQuery()) {
                        rs.next();
                        require(rs.getInt(1) == 0,"Driver/kendaraan memiliki jadwal bentrok.");
                    }
                }
                int newId;
                String sql = "INSERT INTO pengangkutan (tanggal_pengangkutan,waktu_mulai,waktu_selesai,jumlah_muatan,status_pengangkutan,produksi_tambang_id_produksi,kendaraan_id_kendaraan,lokasi_id_lokasi,lokasi_tujuan_id_lokasi,petugas_operasional_id_pegawai,driver_id_pegawai) VALUES (?,NULL,NULL,?,'DIJADWALKAN',?,?,?,?,?,?)";
                try(PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setDate(1, java.sql.Date.valueOf(date));
                    ps.setBigDecimal(2, java.math.BigDecimal.valueOf(amount));
                    ps.setInt(3, idProd);
                    ps.setInt(4, idVehicle);
                    ps.setInt(5, idAsal);
                    ps.setInt(6, idTujuan);
                    ps.setInt(7, ops.getIdPegawai());
                    ps.setInt(8, driver.getIdPegawai());
                    ps.executeUpdate();
                    try(ResultSet rs = ps.getGeneratedKeys()) {
                        if (!rs.next())throw new SQLException("ID pengangkutan tidak ditemukan.");
                        newId = rs.getInt(1);
                    }
                }
                c.commit();
                return get(newId);
            }
            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException("Gagal membuat pengangkutan: "+e.getMessage(), e);
        }
    }
    public Pengangkutan buatPengangkutan(int idProd, PetugasOperasional ops, int idVehicle, model.Driver d,
            int asal, int tujuan, LocalDate date, double amount) {
        return buatPengangkutan(0, idProd, ops, idVehicle, d, asal, tujuan, date, amount);
    }
    private static void lock(Connection c, String sql, int id)throws SQLException {
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if (!rs.next())throw new DataNotFoundException("Data terkait tidak ditemukan.");
            }
        }
    }
    private static int update(Connection c, String sql, int id)throws SQLException {
        try(PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate();
        }
    }
    public void mulaiPengangkutan(int id) {
        try(Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                int idVehicle, idDriver, idAsal, idTujuan;
                LocalDate date;
                try(PreparedStatement ps = c.prepareStatement("SELECT kendaraan_id_kendaraan,driver_id_pegawai,lokasi_id_lokasi,lokasi_tujuan_id_lokasi,tanggal_pengangkutan,status_pengangkutan FROM pengangkutan WHERE id_pengangkutan=? FOR UPDATE")) {
                    ps.setInt(1, id);
                    try(ResultSet rs = ps.executeQuery()) {
                        if (!rs.next())throw new DataNotFoundException("Pengangkutan tidak ditemukan.");
                        require("DIJADWALKAN".equals(rs.getString("status_pengangkutan")),
                                "Pengangkutan bukan DIJADWALKAN.");
                        idVehicle = rs.getInt(1);
                        idDriver = rs.getInt(2);
                        idAsal = rs.getInt(3);
                        idTujuan = rs.getInt(4);
                        date = rs.getDate(5).toLocalDate();
                    }
                }
                require(date.equals(LocalDate.now()),
                        "Pengangkutan hanya dapat dimulai pada tanggal jadwal.");
                lock(c,"SELECT id_lokasi FROM lokasi WHERE id_lokasi=? AND status_operasional='AKTIF' FOR UPDATE", idAsal);
                lock(c,"SELECT id_lokasi FROM lokasi WHERE id_lokasi=? AND status_operasional='AKTIF' FOR UPDATE", idTujuan);
                require(update(c,"UPDATE kendaraan SET status_kendaraan='DIGUNAKAN' WHERE id_kendaraan=? AND status_kendaraan='TERSEDIA'", idVehicle) == 1,"Kendaraan tidak tersedia.");
                require(update(c,"UPDATE driver SET status_driver='BERTUGAS' WHERE id_pegawai=? AND status_driver='TERSEDIA' AND masa_berlaku_sim>=CURRENT_DATE()", idDriver) == 1,"Driver tidak tersedia atau SIM kedaluwarsa.");
                require(update(c,"UPDATE pengangkutan SET status_pengangkutan='DALAM_PERJALANAN',waktu_mulai=NOW() WHERE id_pengangkutan=? AND status_pengangkutan='DIJADWALKAN'", id) == 1,"Gagal memulai pengangkutan.");
                c.commit();
            }
            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException("Gagal memulai pengangkutan", e);
        }
    }
    public void selesaikanPengangkutan(int id) {
        try(Connection c = DatabaseConfig.getConnection()) {
            c.setAutoCommit(false);
            try {
                int prodId, vId, dId;
                double amount;
                try(PreparedStatement ps = c.prepareStatement("SELECT produksi_tambang_id_produksi,kendaraan_id_kendaraan,driver_id_pegawai,jumlah_muatan,status_pengangkutan FROM pengangkutan WHERE id_pengangkutan=? FOR UPDATE")) {
                    ps.setInt(1, id);
                    try(ResultSet rs = ps.executeQuery()) {
                        if (!rs.next())throw new DataNotFoundException("Pengangkutan tidak ditemukan.");
                        require("DALAM_PERJALANAN".equals(rs.getString(5)),
                                "Pengangkutan belum dalam perjalanan.");
                        prodId = rs.getInt(1);
                        vId = rs.getInt(2);
                        dId = rs.getInt(3);
                        amount = rs.getDouble(4);
                    }
                }
                try(PreparedStatement ps = c.prepareStatement("UPDATE produksi_tambang SET status_produksi=CASE WHEN jumlah_tersedia-?<=0 THEN 'HABIS' WHEN jumlah_tersedia-?<jumlah_produksi THEN 'SEBAGIAN_DIANGKUT' ELSE 'TERSEDIA' END,jumlah_tersedia=jumlah_tersedia-? WHERE id_produksi=? AND jumlah_tersedia>=?")) {
                    for (int i = 1;i <= 3;i++)ps.setBigDecimal(i, java.math.BigDecimal.valueOf(amount));
                    ps.setInt(4, prodId);
                    ps.setBigDecimal(5, java.math.BigDecimal.valueOf(amount));
                    require(ps.executeUpdate() == 1,"Stok produksi tidak cukup.");
                }
                require(update(c,"UPDATE kendaraan SET status_kendaraan='TERSEDIA' WHERE id_kendaraan=? AND status_kendaraan='DIGUNAKAN'", vId) == 1,"Status kendaraan tidak sesuai.");
                require(update(c,"UPDATE driver SET status_driver='TERSEDIA' WHERE id_pegawai=? AND status_driver='BERTUGAS'", dId) == 1,"Status driver tidak sesuai.");
                require(update(c,"UPDATE pengangkutan SET status_pengangkutan='SELESAI',waktu_selesai=NOW() WHERE id_pengangkutan=? AND status_pengangkutan='DALAM_PERJALANAN'", id) == 1,"Gagal menyelesaikan pengangkutan.");
                c.commit();
            }
            catch (Exception e) {
                c.rollback();
                throw e;
            }
        }
        catch (SQLException e) {
            throw new IllegalStateException("Gagal menyelesaikan pengangkutan", e);
        }
    }
    public void batalkanPengangkutan(int id) {
        try(Connection c = DatabaseConfig.getConnection();PreparedStatement ps = c.prepareStatement("UPDATE pengangkutan SET status_pengangkutan='DIBATALKAN' WHERE id_pengangkutan=? AND status_pengangkutan='DIJADWALKAN'")) {
            ps.setInt(1, id);
            require(ps.executeUpdate() == 1,"Hanya pengangkutan DIJADWALKAN yang dapat dibatalkan.");
        }
        catch (SQLException e) {
            throw new IllegalStateException("Gagal membatalkan pengangkutan", e);
        }
    }
    public double hitungMaterialTersediaUntukDijadwalkan(ProduksiTambang p) {
        if (p == null)return 0;
        double reserved = 0;
        for (Pengangkutan x:haul.findByProduksi(p.getIdProduksi()))if (x.getStatusPengangkutan() == StatusPengangkutan.DIJADWALKAN || x.getStatusPengangkutan() == StatusPengangkutan.DALAM_PERJALANAN)reserved+=x.getJumlahMuatan();
        return Math.max(0, p.getJumlahTersedia()-reserved);
    }
    public Pengangkutan cariPengangkutanById(int id) {
        return get(id);
    }
    public List<Pengangkutan> tampilkanSemuaPengangkutan() {
        return haul.findAll();
    }
}
