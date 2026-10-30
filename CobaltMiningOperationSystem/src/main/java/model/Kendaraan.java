/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
    private enums.StatusKendaraan statusKendaraan;
    
    public Kendaraan(int idKendaraan, String jenisKendaraan, String nomorPolisi, double kapasitas,
            int tahunKendaraan, enums.StatusKendaraan statusKendaraan) {
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
    
    public void setIdKendaraan(int value) {
        this.idKendaraan = value;
    }
    
    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
    
    public void setJenisKendaraan(String value) {
        this.jenisKendaraan = value;
    }
    
    public String getNomorPolisi() {
        return nomorPolisi;
    }
    
    public void setNomorPolisi(String value) {
        this.nomorPolisi = value;
    }
    
    public double getKapasitas() {
        return kapasitas;
    }
    
    public void setKapasitas(double value) {
        this.kapasitas = value;
    }
    
    public int getTahunKendaraan() {
        return tahunKendaraan;
    }
    
    public void setTahunKendaraan(int value) {
        this.tahunKendaraan = value;
    }
    
    public enums.StatusKendaraan getStatusKendaraan() {
        return statusKendaraan;
    }
    
    public void setStatusKendaraan(enums.StatusKendaraan value) {
        this.statusKendaraan = value;
    }
    
    @Override
    public String toString() {
        return "Kendaraan #" + idKendaraan;
    }
}
