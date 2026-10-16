/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusProduksi;
import java.time.LocalDate;

/**
 *
 * @author zefrialrizkullah
 */

public class ProduksiTambang {
    private int idProduksi;
    private JenisMaterial material;
    private Lokasi lokasi;
    private PetugasOperasional petugasOperasional;
    private LocalDate tanggalProduksi;
    private double jumlahProduksi;
    private double jumlahTersedia;
    private StatusProduksi statusProduksi;

    public ProduksiTambang(int idProduksi, JenisMaterial material, Lokasi lokasi, PetugasOperasional petugasOperasional, LocalDate tanggalProduksi, double jumlahProduksi, double jumlahTersedia, StatusProduksi statusProduksi) {
        this.idProduksi = idProduksi;
        this.material = material;
        this.lokasi = lokasi;
        this.petugasOperasional = petugasOperasional;
        this.tanggalProduksi = tanggalProduksi;
        this.jumlahProduksi = jumlahProduksi;
        this.jumlahTersedia = jumlahTersedia;
        this.statusProduksi = statusProduksi;
    }

    public int getIdProduksi() {
        return idProduksi;
    }

    public void setIdProduksi(int idProduksi) {
        this.idProduksi = idProduksi;
    }

    public JenisMaterial getMaterial() {
        return material;
    }

    public void setMaterial(JenisMaterial material) {
        this.material = material;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public PetugasOperasional getPetugasOperasional() {
        return petugasOperasional;
    }

    public void setPetugasOperasional(PetugasOperasional petugasOperasional) {
        this.petugasOperasional = petugasOperasional;
    }

    public LocalDate getTanggalProduksi() {
        return tanggalProduksi;
    }

    public void setTanggalProduksi(LocalDate tanggalProduksi) {
        this.tanggalProduksi = tanggalProduksi;
    }

    public double getJumlahProduksi() {
        return jumlahProduksi;
    }

    public void setJumlahProduksi(double jumlahProduksi) {
        this.jumlahProduksi = jumlahProduksi;
    }

    public double getJumlahTersedia() {
        return jumlahTersedia;
    }

    public void setJumlahTersedia(double jumlahTersedia) {
        this.jumlahTersedia = jumlahTersedia;
    }

    public StatusProduksi getStatusProduksi() {
        return statusProduksi;
    }

    public void setStatusProduksi(StatusProduksi statusProduksi) {
        this.statusProduksi = statusProduksi;
    }

    @Override
    public String toString() {
        return "Produksi #"+idProduksi+" - "+material.getNamaMaterial()+" - "+jumlahTersedia+" "+material.getSatuan();
    }
}