/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Pengangkutan {
    private int idPengangkutan;
    private ProduksiTambang produksi;
    private PetugasOperasional petugasOperasional;
    private Kendaraan kendaraan;
    private Driver driver;
    private Lokasi lokasiAsal;
    private Lokasi lokasiTujuan;
    private java.time.LocalDate tanggalPengangkutan;
    private java.time.LocalDateTime waktuMulai;
    private java.time.LocalDateTime waktuSelesai;
    private double jumlahMuatan;
    private enums.StatusPengangkutan statusPengangkutan;
    
    public Pengangkutan(int idPengangkutan, ProduksiTambang produksi,
            PetugasOperasional petugasOperasional, Kendaraan kendaraan, Driver driver, Lokasi lokasiAsal,
            Lokasi lokasiTujuan, java.time.LocalDate tanggalPengangkutan,
            java.time.LocalDateTime waktuMulai, java.time.LocalDateTime waktuSelesai, double jumlahMuatan,
            enums.StatusPengangkutan statusPengangkutan) {
        this.idPengangkutan = idPengangkutan;
        this.produksi = produksi;
        this.petugasOperasional = petugasOperasional;
        this.kendaraan = kendaraan;
        this.driver = driver;
        this.lokasiAsal = lokasiAsal;
        this.lokasiTujuan = lokasiTujuan;
        this.tanggalPengangkutan = tanggalPengangkutan;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.jumlahMuatan = jumlahMuatan;
        this.statusPengangkutan = statusPengangkutan;
    }
    
    public int getIdPengangkutan() {
        return idPengangkutan;
    }
    
    public void setIdPengangkutan(int value) {
        this.idPengangkutan = value;
    }
    
    public ProduksiTambang getProduksi() {
        return produksi;
    }
    
    public void setProduksi(ProduksiTambang value) {
        this.produksi = value;
    }
    
    public PetugasOperasional getPetugasOperasional() {
        return petugasOperasional;
    }
    
    public void setPetugasOperasional(PetugasOperasional value) {
        this.petugasOperasional = value;
    }
    
    public Kendaraan getKendaraan() {
        return kendaraan;
    }
    
    public void setKendaraan(Kendaraan value) {
        this.kendaraan = value;
    }
    
    public Driver getDriver() {
        return driver;
    }
    
    public void setDriver(Driver value) {
        this.driver = value;
    }
    
    public Lokasi getLokasiAsal() {
        return lokasiAsal;
    }
    
    public void setLokasiAsal(Lokasi value) {
        this.lokasiAsal = value;
    }
    
    public Lokasi getLokasiTujuan() {
        return lokasiTujuan;
    }
    
    public void setLokasiTujuan(Lokasi value) {
        this.lokasiTujuan = value;
    }
    
    public java.time.LocalDate getTanggalPengangkutan() {
        return tanggalPengangkutan;
    }
    
    public void setTanggalPengangkutan(java.time.LocalDate value) {
        this.tanggalPengangkutan = value;
    }
    
    public java.time.LocalDateTime getWaktuMulai() {
        return waktuMulai;
    }
    
    public void setWaktuMulai(java.time.LocalDateTime value) {
        this.waktuMulai = value;
    }
    
    public java.time.LocalDateTime getWaktuSelesai() {
        return waktuSelesai;
    }
    
    public void setWaktuSelesai(java.time.LocalDateTime value) {
        this.waktuSelesai = value;
    }
    
    public double getJumlahMuatan() {
        return jumlahMuatan;
    }
    
    public void setJumlahMuatan(double value) {
        this.jumlahMuatan = value;
    }
    
    public enums.StatusPengangkutan getStatusPengangkutan() {
        return statusPengangkutan;
    }
    
    public void setStatusPengangkutan(enums.StatusPengangkutan value) {
        this.statusPengangkutan = value;
    }
    
    @Override
    public String toString() {
        return "Pengangkutan #" + idPengangkutan;
    }
}
