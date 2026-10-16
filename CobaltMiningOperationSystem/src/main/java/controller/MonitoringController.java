/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import enums.StatusLokasi;
import exception.ValidationException;
import model.DetailMonitoring;
import model.MonitoringLingkungan;
import model.Pegawai;
import model.PetugasHSE;
import service.AuthService;
import service.MonitoringService;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public class MonitoringController {
    private final MonitoringService monitoringService;
    private final AuthService authService;

    public MonitoringController(
            MonitoringService monitoringService,
            AuthService authService) {

        this.monitoringService = monitoringService;
        this.authService = authService;
    }

    public MonitoringLingkungan buatMonitoring(
            int idMonitoring,
            int idLokasi,
            LocalDateTime tanggalMonitoring,
            String catatan) {

        PetugasHSE petugas = getPetugasHSELogin();

        return monitoringService
                .buatMonitoring(
                        idMonitoring,
                        idLokasi,
                        petugas,
                        tanggalMonitoring,
                        catatan
                );
    }

    public DetailMonitoring tambahDetail(
            int idMonitoring,
            int idDetail,
            int idParameter,
            double nilaiPengukuran,
            String catatan) {

        getPetugasHSELogin();

        return monitoringService
                .tambahDetail(
                        idMonitoring,
                        idDetail,
                        idParameter,
                        nilaiPengukuran,
                        catatan
                );
    }

    public void aturTindakLanjut(
            int idMonitoring,
            String tindakLanjut) {

        getPetugasHSELogin();

        monitoringService
                .aturTindakLanjut(
                        idMonitoring,
                        tindakLanjut
                );
    }

    public void mulaiPenanganan(int idMonitoring) {
        getPetugasHSELogin();
        monitoringService.mulaiPenanganan(idMonitoring);
    }

    public void selesaikanPenanganan(int idMonitoring) {
        getPetugasHSELogin();
        monitoringService.selesaikanPenanganan(idMonitoring);
    }

    public void ubahStatusLokasi(int idMonitoring, StatusLokasi statusLokasi) {
        getPetugasHSELogin();
        monitoringService.ubahStatusLokasi(idMonitoring, statusLokasi);
    }

    public MonitoringLingkungan cariMonitoringById(int idMonitoring) {
        return monitoringService.cariMonitoringById(idMonitoring);
    }

    public List<MonitoringLingkungan> tampilkanSemuaMonitoring() {
        return monitoringService.tampilkanSemuaMonitoring();
    }

    public List<MonitoringLingkungan> tampilkanMonitoringByLokasi(int idLokasi) {
        return monitoringService.tampilkanMonitoringByLokasi(idLokasi);
    }

    private PetugasHSE getPetugasHSELogin() {
        if (!authService.isLoggedIn()) {
            throw new ValidationException(
                    "Silakan login terlebih dahulu."
            );
        }

        Pegawai pegawai = authService.getCurrentPegawai();

        if (!(pegawai instanceof PetugasHSE)) {
            throw new ValidationException(
                    "Fitur monitoring hanya dapat digunakan oleh Petugas HSE."
            );
        }

        return (PetugasHSE) pegawai;
    }
}
