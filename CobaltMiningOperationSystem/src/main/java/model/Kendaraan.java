/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusKendaraan;

/**
 *
 * @author zefrialrizkullah
 */

public class Kendaraan {
    private int idKendaraan;
    private String jenisKendaraan;
    private String nomorPolisi;
    private double kapasitas;
    private int tahunKendaraan;
    private StatusKendaraan statusKendaraan;
    
    public Kendaraan() {}
    
    public Kendaraan(int idKendaraan, String jenisKendaraan, String nomorPolisi, double kapasitas, int tahunKendaraan, StatusKendaraan statusKendaraan) {
        this.idKendaraan = idKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.nomorPolisi = nomorPolisi;
        this.kapasitas = kapasitas;
        this.tahunKendaraan = tahunKendaraan;
        this.statusKendaraan = statusKendaraan;
    }
    
    public int getIdKendaraan() {
        return idKendaraan;
    }
    
    public void setIdKendaraan(int idKendaraan) {
        this.idKendaraan = idKendaraan;
    }
    
    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
    
    public void setJenisKendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }
    
    public String getNomorPolisi() {
        return nomorPolisi;
    }
    
    public void setNomorPolisi(String nomorPolisi) {
        this.nomorPolisi = nomorPolisi;
    }
    
    public double getKapasitas() {
        return kapasitas;
    }
    
    public void setKapasitas(double kapasitas) {
        this.kapasitas = kapasitas;
    }
    
    public int getTahunKendaraan() {
        return tahunKendaraan;
    }
    
    public void setTahunKendaraan(int tahunKendaraan) {
        this.tahunKendaraan = tahunKendaraan;
    }
    
    public StatusKendaraan getStatusKendaraan() {
        return statusKendaraan;
    }
    
    public void setStatusKendaraan(StatusKendaraan statusKendaraan) {
        this.statusKendaraan = statusKendaraan;
    }
    
    @Override
    public String toString() {
        return nomorPolisi + " - " + jenisKendaraan;
    }
}
