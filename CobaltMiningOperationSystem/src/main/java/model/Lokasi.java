/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Lokasi {
    private int idLokasi;
    private String namaLokasi;
    private enums.JenisLokasi jenisLokasi;
    private enums.StatusLokasi statusOperasional;
    private String keterangan;
    
    public Lokasi(int idLokasi, String namaLokasi, enums.JenisLokasi jenisLokasi,
            enums.StatusLokasi statusOperasional, String keterangan) {
        this.idLokasi = idLokasi;
        this.namaLokasi = namaLokasi;
        this.jenisLokasi = jenisLokasi;
        this.statusOperasional = statusOperasional;
        this.keterangan = keterangan;
    }
    
    public int getIdLokasi() {
        return idLokasi;
    }
    
    public void setIdLokasi(int value) {
        this.idLokasi = value;
    }
    
    public String getNamaLokasi() {
        return namaLokasi;
    }
    
    public void setNamaLokasi(String value) {
        this.namaLokasi = value;
    }
    
    public enums.JenisLokasi getJenisLokasi() {
        return jenisLokasi;
    }
    
    public void setJenisLokasi(enums.JenisLokasi value) {
        this.jenisLokasi = value;
    }
    
    public enums.StatusLokasi getStatusOperasional() {
        return statusOperasional;
    }
    
    public void setStatusOperasional(enums.StatusLokasi value) {
        this.statusOperasional = value;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public void setKeterangan(String value) {
        this.keterangan = value;
    }
    
    @Override
    public String toString() {
        return "Lokasi #" + idLokasi;
    }
}
