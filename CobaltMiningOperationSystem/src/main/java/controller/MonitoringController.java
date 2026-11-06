/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.*;
import model.*;
import enums.StatusLokasi;
import java.time.LocalDateTime;
import java.util.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class MonitoringController {
    private final MonitoringService service;
    private final AuthService auth;
    public MonitoringController(MonitoringService service, AuthService a) {
        this.service = service;
        auth = a;
    }
    
    public String statusPermintaan(int lokasi) { auth.requirePetugasHSE(); return service.statusPermintaan(lokasi); }
    public void ajukanMonitoring(int lokasi, String alasan) { auth.requirePetugasHSE(); service.ajukanMonitoring(lokasi, alasan, auth.getCurrentPegawai().getIdPegawai()); }
    public java.util.List<service.MonitoringService.Permintaan> permintaanMenunggu() { auth.requireManager(); return service.permintaanMenunggu(); }
    public java.util.List<service.MonitoringService.Peringatan> peringatanManager() {auth.requireManager();return service.peringatanManager();}
    public void tandaiPeringatanDibaca(int id) {auth.requireManager();service.tandaiPeringatanDibaca(id);}
    public java.util.List<service.MonitoringService.Permintaan> semuaPermintaanMenunggu() {auth.requireManager();return service.permintaanMenunggu();}
    public void setujuiMonitoring(int permintaanId) { auth.requireManager(); service.setujuiMonitoring(permintaanId,auth.getCurrentPegawai().getIdPegawai()); }

    public MonitoringLingkungan buatMonitoring(int lokasi, LocalDateTime tanggal, String catatan) {
        auth.requirePetugasHSE();
        return service.buatMonitoring(lokasi, (PetugasHSE)auth.getCurrentPegawai(), tanggal, catatan);
    }
    
    public DetailMonitoring tambahDetail(int id, int parameter, double nilai, String catatan) {
        auth.requirePetugasHSE();
        return service.tambahDetail(id, parameter, nilai, catatan);
    }
    

    
    public void mulaiPenanganan(int id) {
        auth.requirePetugasHSE();
        service.mulaiPenanganan(id);
    }
    
    public void selesaikanPenanganan(int id) {
        auth.requirePetugasHSE();
        service.selesaikanPenanganan(id);
    }
    
    /** HSE meneruskan informasi peringatan lokasi kepada Manager. */
    public void informasikanManager(int id) {
        auth.requirePetugasHSE();
        service.informasikanManager(id, auth.getCurrentPegawai().getNamaPegawai());
    }
    
    public void hapusMonitoring(int id) {
        auth.requirePetugasHSE();
        service.hapusMonitoring(id);
    }

    public MonitoringLingkungan ubahMonitoring(int id, int lokasi, LocalDateTime tanggal, String catatan) {
        auth.requirePetugasHSE();
        return service.ubahMonitoring(id, lokasi, tanggal, catatan);
    }

    public DetailMonitoring ubahDetail(int idDetail, int parameter, double nilai, String catatan) {
        auth.requirePetugasHSE();
        return service.ubahDetail(idDetail, parameter, nilai, catatan);
    }

    public void hapusDetail(int idDetail) {
        auth.requirePetugasHSE();
        service.hapusDetail(idDetail);
    }

    public void ubahStatusLokasi(int id, StatusLokasi status) {
        auth.requirePetugasHSE();
        service.ubahStatusLokasi(id, status);
    }
    
    public MonitoringLingkungan cariMonitoringById(int id) {
        if (!auth.isPetugasHSE() && !auth.isManager())throw new IllegalStateException("Akses monitoring tidak tersedia.");
        return service.cariMonitoringById(id);
    }
    
    public List<MonitoringLingkungan> tampilkanSemuaMonitoring() {
        if (!auth.isPetugasHSE() && !auth.isManager())throw new IllegalStateException("Akses monitoring tidak tersedia.");
        return service.tampilkanSemuaMonitoring();
    }
    
    public List<MonitoringLingkungan> tampilkanMonitoringByLokasi(int id) {
        if (!auth.isPetugasHSE() && !auth.isManager())throw new IllegalStateException("Akses monitoring tidak tersedia.");
        return service.tampilkanMonitoringByLokasi(id);
    }
    
    public List<model.Lokasi> tampilkanSemuaLokasi() {
        if (!auth.isPetugasHSE() && !auth.isManager())throw new IllegalStateException("Akses monitoring tidak tersedia.");
        return service.tampilkanSemuaLokasi();
    }
}
