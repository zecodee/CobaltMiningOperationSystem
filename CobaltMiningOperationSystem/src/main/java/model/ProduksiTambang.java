/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class ProduksiTambang {
    private int idProduksi;
    private JenisMaterial material;
    private Lokasi lokasi;
    private PetugasOperasional petugasOperasional;
    private java.time.LocalDate tanggalProduksi;
    private double jumlahProduksi;
    private double jumlahTersedia;
    private enums.StatusProduksi statusProduksi;
    
    public ProduksiTambang(int idProduksi, JenisMaterial material, Lokasi lokasi,
            PetugasOperasional petugasOperasional, java.time.LocalDate tanggalProduksi,
            double jumlahProduksi, double jumlahTersedia, enums.StatusProduksi statusProduksi) {
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
    
    public void setIdProduksi(int value) {
        this.idProduksi = value;
    }
    
    public JenisMaterial getMaterial() {
        return material;
    }
    
    public void setMaterial(JenisMaterial value) {
        this.material = value;
    }
    
    public Lokasi getLokasi() {
        return lokasi;
    }
    
    public void setLokasi(Lokasi value) {
        this.lokasi = value;
    }
    
    public PetugasOperasional getPetugasOperasional() {
        return petugasOperasional;
    }
    
    public void setPetugasOperasional(PetugasOperasional value) {
        this.petugasOperasional = value;
    }
    
    public java.time.LocalDate getTanggalProduksi() {
        return tanggalProduksi;
    }
    
    public void setTanggalProduksi(java.time.LocalDate value) {
        this.tanggalProduksi = value;
    }
    
    public double getJumlahProduksi() {
        return jumlahProduksi;
    }
    
    public void setJumlahProduksi(double value) {
        this.jumlahProduksi = value;
    }
    
    public double getJumlahTersedia() {
        return jumlahTersedia;
    }
    
    public void setJumlahTersedia(double value) {
        this.jumlahTersedia = value;
    }
    
    public enums.StatusProduksi getStatusProduksi() {
        return statusProduksi;
    }
    
    public void setStatusProduksi(enums.StatusProduksi value) {
        this.statusProduksi = value;
    }
    
    @Override
    public String toString() {
        return "ProduksiTambang #" + idProduksi;
    }
}
