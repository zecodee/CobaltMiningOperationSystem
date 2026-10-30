/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class MonitoringLingkungan {
    private int idMonitoring;
    private Lokasi lokasi;
    private PetugasHSE petugasHSE;
    private java.time.LocalDateTime tanggalMonitoring;
    private enums.StatusMonitoring statusMonitoring;
    private String tindakLanjut;
    private enums.StatusPenanganan statusPenanganan;
    private String catatan;
    private final java.util.List<DetailMonitoring> detailMonitoring = new java.util.ArrayList<>();
    
    public MonitoringLingkungan(int idMonitoring, Lokasi lokasi, PetugasHSE petugasHSE,
            java.time.LocalDateTime tanggalMonitoring, enums.StatusMonitoring statusMonitoring,
            String tindakLanjut, enums.StatusPenanganan statusPenanganan, String catatan) {
        this.idMonitoring = idMonitoring;
        this.lokasi = lokasi;
        this.petugasHSE = petugasHSE;
        this.tanggalMonitoring = tanggalMonitoring;
        this.statusMonitoring = statusMonitoring;
        this.tindakLanjut = tindakLanjut;
        this.statusPenanganan = statusPenanganan;
        this.catatan = catatan;
    }
    
    public int getIdMonitoring() {
        return idMonitoring;
    }
    
    public void setIdMonitoring(int value) {
        this.idMonitoring = value;
    }
    
    public Lokasi getLokasi() {
        return lokasi;
    }
    
    public void setLokasi(Lokasi value) {
        this.lokasi = value;
    }
    
    public PetugasHSE getPetugasHSE() {
        return petugasHSE;
    }
    
    public void setPetugasHSE(PetugasHSE value) {
        this.petugasHSE = value;
    }
    
    public java.time.LocalDateTime getTanggalMonitoring() {
        return tanggalMonitoring;
    }
    
    public void setTanggalMonitoring(java.time.LocalDateTime value) {
        this.tanggalMonitoring = value;
    }
    
    public enums.StatusMonitoring getStatusMonitoring() {
        return statusMonitoring;
    }
    
    public void setStatusMonitoring(enums.StatusMonitoring value) {
        this.statusMonitoring = value;
    }
    
    public String getTindakLanjut() {
        return tindakLanjut;
    }
    
    public void setTindakLanjut(String value) {
        this.tindakLanjut = value;
    }
    
    public enums.StatusPenanganan getStatusPenanganan() {
        return statusPenanganan;
    }
    
    public void setStatusPenanganan(enums.StatusPenanganan value) {
        this.statusPenanganan = value;
    }
    
    public String getCatatan() {
        return catatan;
    }
    
    public void setCatatan(String value) {
        this.catatan = value;
    }
    
    public java.util.List<DetailMonitoring> getDetailMonitoring() {
        return java.util.Collections.unmodifiableList(detailMonitoring);
    }
    
    public void tambahDetail(DetailMonitoring d) {
        detailMonitoring.add(d);
    }
    
    @Override
    public String toString() {
        return "MonitoringLingkungan #" + idMonitoring;
    }
}
