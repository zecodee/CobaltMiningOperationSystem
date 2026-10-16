/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.JenisLokasi;
import enums.StatusLokasi;

/**
 *
 * @author zefrialrizkullah
 */

public class Lokasi {
    private int idLokasi;
    private String namaLokasi;
    private JenisLokasi jenisLokasi;
    private StatusLokasi statusOperasional;
    private String keterangan;
    
    public Lokasi() {}
    
    public Lokasi(int idLokasi, String namaLokasi, JenisLokasi jenisLokasi, StatusLokasi statusOperasional, String keterangan) {
        this.idLokasi = idLokasi;
        this.namaLokasi = namaLokasi;
        this.jenisLokasi = jenisLokasi;
        this.statusOperasional = statusOperasional;
        this.keterangan = keterangan;
    }
    
    public int getIdLokasi() {
        return idLokasi;
    }
    
    public void setIdLokasi(int idLokasi) {
        this.idLokasi = idLokasi;
    }
    
    public String getNamaLokasi() {
        return namaLokasi;
    }
    
    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }
    
    public JenisLokasi getJenisLokasi() {
        return jenisLokasi;
    }
    
    public void setJenisLokasi(JenisLokasi jenisLokasi) {
        this.jenisLokasi = jenisLokasi;
    }
    
    public StatusLokasi getStatusOperasional() {
        return statusOperasional;
    }
    
    public void setStatusOperasional(StatusLokasi statusOperasional) {
        this.statusOperasional = statusOperasional;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    @Override
    public String toString() {
        return namaLokasi;
    }
}
