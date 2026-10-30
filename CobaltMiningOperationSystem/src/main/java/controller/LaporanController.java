/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDate;
import java.util.List;
import service.AuthService;
import service.LaporanService;

/**
 *
 * @author zefrialrizkullah
 */

public final class LaporanController {
    private final LaporanService laporanService;
    private final AuthService authService;

    public LaporanController(LaporanService laporanService, AuthService authService) {
        this.laporanService = laporanService;
        this.authService = authService;
    }

    public LaporanService.Ringkasan ringkasan(LocalDate awal, LocalDate akhir) {
        authService.requireManager();
        return laporanService.ringkasan(awal, akhir);
    }

    public List<LaporanService.BarisProduksi> laporanProduksi(
            LocalDate awal, LocalDate akhir) {
        authService.requireManager();
        return laporanService.laporanProduksi(awal, akhir);
    }

    public List<LaporanService.BarisPengangkutan> laporanPengangkutan(
            LocalDate awal, LocalDate akhir) {
        authService.requireManager();
        return laporanService.laporanPengangkutan(awal, akhir);
    }

    public List<LaporanService.BarisMonitoring> laporanMonitoring(
            LocalDate awal, LocalDate akhir) {
        authService.requireManager();
        return laporanService.laporanMonitoring(awal, akhir);
    }

    public LaporanService.DetailLaporanMonitoring detailMonitoring(int idMonitoring) {
        authService.requireManager();
        return laporanService.detailMonitoring(idMonitoring);
    }
}
