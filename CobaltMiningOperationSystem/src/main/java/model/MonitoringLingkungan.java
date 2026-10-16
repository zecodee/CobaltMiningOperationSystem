/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusMonitoring;
import enums.StatusPenanganan;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public class MonitoringLingkungan {
    private int idMonitoring;
    private Lokasi lokasi;
    private PetugasHSE petugasHSE;
    private LocalDateTime tanggalMonitoring;
    private StatusMonitoring statusMonitoring;
    private String tindakLanjut;
    private StatusPenanganan statusPenanganan;
    private String catatan;
    private List<DetailMonitoring> detailMonitoring;

    public MonitoringLingkungan(int idMonitoring, Lokasi lokasi, PetugasHSE petugasHSE, LocalDateTime tanggalMonitoring, StatusMonitoring statusMonitoring, String tindakLanjut, StatusPenanganan statusPenanganan, String catatan) {
        this.idMonitoring = idMonitoring;
        this.lokasi = lokasi;
        this.petugasHSE = petugasHSE;
        this.tanggalMonitoring = tanggalMonitoring;
        this.statusMonitoring = statusMonitoring;
        this.tindakLanjut = tindakLanjut;
        this.statusPenanganan = statusPenanganan;
        this.catatan = catatan;
        this.detailMonitoring = new ArrayList<DetailMonitoring>();
    }

    public int getIdMonitoring() {
        return idMonitoring;
    }

    public void setIdMonitoring(int idMonitoring) {
        this.idMonitoring = idMonitoring;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }

    public PetugasHSE getPetugasHSE() {
        return petugasHSE;
    }

    public void setPetugasHSE(PetugasHSE petugasHSE) {
        this.petugasHSE = petugasHSE;
    }

    public LocalDateTime getTanggalMonitoring() {
        return tanggalMonitoring;
    }

    public void setTanggalMonitoring(LocalDateTime tanggalMonitoring) {
        this.tanggalMonitoring = tanggalMonitoring;
    }

    public StatusMonitoring getStatusMonitoring() {
        return statusMonitoring;
    }

    public void setStatusMonitoring(StatusMonitoring statusMonitoring) {
        this.statusMonitoring = statusMonitoring;
    }

    public String getTindakLanjut() {
        return tindakLanjut;
    }

    public void setTindakLanjut(String tindakLanjut) {
        this.tindakLanjut = tindakLanjut;
    }

    public StatusPenanganan getStatusPenanganan() {
        return statusPenanganan;
    }

    public void setStatusPenanganan(StatusPenanganan statusPenanganan) {
        this.statusPenanganan = statusPenanganan;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    public List<DetailMonitoring> getDetailMonitoring() {
        return detailMonitoring;
    }

    public void setDetailMonitoring(List<DetailMonitoring> detailMonitoring) {
        this.detailMonitoring = detailMonitoring;
    }

    public void tambahDetail(DetailMonitoring detail) {
        if (detail != null) {
            detailMonitoring.add(detail);
        }
    }

    @Override
    public String toString() {
        return "Monitoring #"+idMonitoring+" - "+lokasi.getNamaLokasi()+" - "+statusMonitoring;
    }
}