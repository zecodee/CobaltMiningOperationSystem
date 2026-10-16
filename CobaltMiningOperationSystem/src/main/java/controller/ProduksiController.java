/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import exception.ValidationException;
import model.Pegawai;
import model.PetugasOperasional;
import model.ProduksiTambang;
import service.AuthService;
import service.ProduksiService;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public class ProduksiController {
    private final ProduksiService produksiService;
    private final AuthService authService;

    public ProduksiController(
            ProduksiService produksiService,
            AuthService authService) {

        this.produksiService = produksiService;
        this.authService = authService;
    }

    public ProduksiTambang tambahProduksi(
            int idProduksi,
            int idMaterial,
            int idLokasi,
            LocalDate tanggalProduksi,
            double jumlahProduksi) {

        PetugasOperasional petugas = getPetugasOperasionalLogin();

        return produksiService.tambahProduksi(
                idProduksi,
                idMaterial,
                idLokasi,
                petugas,
                tanggalProduksi,
                jumlahProduksi
        );
    }

    public void ubahProduksi(
            int idProduksi,
            int idMaterial,
            int idLokasi,
            LocalDate tanggalProduksi,
            double jumlahProduksi) {

        getPetugasOperasionalLogin();
        produksiService.ubahProduksi(idProduksi, idMaterial, idLokasi, tanggalProduksi, jumlahProduksi);
    }

    public void hapusProduksi(int idProduksi) {
        getPetugasOperasionalLogin();

        produksiService.hapusProduksi(idProduksi);
    }

    public ProduksiTambang cariProduksiById(int idProduksi) {
        return produksiService.cariProduksiById(idProduksi);
    }

    public List<ProduksiTambang>tampilkanSemuaProduksi() {
        return produksiService.tampilkanSemuaProduksi();
    }

    public List<ProduksiTambang>tampilkanProduksiTersedia() {
        return produksiService.tampilkanProduksiTersedia();
    }

    private PetugasOperasional getPetugasOperasionalLogin() {
        if (!authService.isLoggedIn()) {
            throw new ValidationException(
                    "Silakan login terlebih dahulu."
            );
        }

        Pegawai pegawai = authService.getCurrentPegawai();

        if (!(pegawai instanceof PetugasOperasional)) {
            throw new ValidationException(
                    "Fitur produksi hanya dapat digunakan oleh Petugas Operasional."
            );
        }

        return (PetugasOperasional) pegawai;
    }
}
