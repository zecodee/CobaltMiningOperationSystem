/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusPengangkutan;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate tanggalPengangkutan;
    private LocalDateTime waktuMulai;
    private LocalDateTime waktuSelesai;
    private double jumlahMuatan;
    private StatusPengangkutan statusPengangkutan;

    public Pengangkutan(int idPengangkutan, ProduksiTambang produksi, PetugasOperasional petugasOperasional, Kendaraan kendaraan, Driver driver, Lokasi lokasiAsal, Lokasi lokasiTujuan, LocalDate tanggalPengangkutan, LocalDateTime waktuMulai, LocalDateTime waktuSelesai, double jumlahMuatan, StatusPengangkutan statusPengangkutan) {
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

    public void setIdPengangkutan(int idPengangkutan) {
        this.idPengangkutan = idPengangkutan;
    }

    public ProduksiTambang getProduksi() {
        return produksi;
    }

    public void setProduksi(ProduksiTambang produksi) {
        this.produksi = produksi;
    }

    public PetugasOperasional getPetugasOperasional() {
        return petugasOperasional;
    }

    public void setPetugasOperasional(PetugasOperasional petugasOperasional) {
        this.petugasOperasional = petugasOperasional;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Lokasi getLokasiAsal() {
        return lokasiAsal;
    }

    public void setLokasiAsal(Lokasi lokasiAsal) {
        this.lokasiAsal = lokasiAsal;
    }

    public Lokasi getLokasiTujuan() {
        return lokasiTujuan;
    }

    public void setLokasiTujuan(Lokasi lokasiTujuan) {
        this.lokasiTujuan = lokasiTujuan;
    }

    public LocalDate getTanggalPengangkutan() {
        return tanggalPengangkutan;
    }

    public void setTanggalPengangkutan(LocalDate tanggalPengangkutan) {
        this.tanggalPengangkutan = tanggalPengangkutan;
    }

    public LocalDateTime getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(LocalDateTime waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public LocalDateTime getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(LocalDateTime waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public double getJumlahMuatan() {
        return jumlahMuatan;
    }

    public void setJumlahMuatan(double jumlahMuatan) {
        this.jumlahMuatan = jumlahMuatan;
    }

    public StatusPengangkutan getStatusPengangkutan() {
        return statusPengangkutan;
    }

    public void setStatusPengangkutan(StatusPengangkutan statusPengangkutan) {
        this.statusPengangkutan = statusPengangkutan;
    }

    @Override
    public String toString() {
        return "Pengangkutan #"+idPengangkutan+" - "+statusPengangkutan;
    }
}