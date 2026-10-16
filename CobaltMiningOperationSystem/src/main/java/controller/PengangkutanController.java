/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.Driver;
import model.Pegawai;
import model.Pengangkutan;
import model.PetugasOperasional;
import repository.PegawaiRepository;
import service.AuthService;
import service.PengangkutanService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import enums.StatusDriver;
import enums.StatusPegawai;

/**
 *
 * @author zefrialrizkullah
 */

public class PengangkutanController {
    private final PengangkutanService pengangkutanService;
    private final AuthService authService;
    private final PegawaiRepository pegawaiRepository;

    public PengangkutanController(
            PengangkutanService pengangkutanService,
            AuthService authService,
            PegawaiRepository pegawaiRepository) {

        this.pengangkutanService = pengangkutanService;
        this.authService = authService;
        this.pegawaiRepository = pegawaiRepository;
    }

    public Pengangkutan buatPengangkutan(
            int idPengangkutan,
            int idProduksi,
            int idKendaraan,
            int idDriver,
            int idLokasiAsal,
            int idLokasiTujuan,
            LocalDate tanggalPengangkutan,
            double jumlahMuatan) {

        PetugasOperasional petugas = getPetugasOperasionalLogin();
        Driver driver = getDriverOrThrow(idDriver);

        return pengangkutanService
                .buatPengangkutan(
                        idPengangkutan,
                        idProduksi,
                        petugas,
                        idKendaraan,
                        driver,
                        idLokasiAsal,
                        idLokasiTujuan,
                        tanggalPengangkutan,
                        jumlahMuatan
                );
    }

    public void mulaiPengangkutan(int idPengangkutan) {
        getPetugasOperasionalLogin();
        pengangkutanService.mulaiPengangkutan(idPengangkutan);
    }

    public void selesaikanPengangkutan(int idPengangkutan) {
        getPetugasOperasionalLogin();
        pengangkutanService.selesaikanPengangkutan(idPengangkutan);
    }

    public void batalkanPengangkutan(int idPengangkutan) {
        getPetugasOperasionalLogin();
        pengangkutanService.batalkanPengangkutan(idPengangkutan);
    }

    public Pengangkutan cariPengangkutanById(int idPengangkutan) {
        return pengangkutanService.cariPengangkutanById(idPengangkutan);
    }

    public List<Pengangkutan>tampilkanSemuaPengangkutan() {
        return pengangkutanService.tampilkanSemuaPengangkutan();
    }

    public List<Driver> tampilkanDriverTersedia() {
        List<Driver> hasil = new ArrayList<Driver>();

        for (Pegawai pegawai : pegawaiRepository.findAll()) {
            if (!(pegawai instanceof Driver)) {
                continue;
            }

            Driver driver = (Driver) pegawai;

            if (driver.getStatusPegawai()
                    != StatusPegawai.AKTIF) {
                continue;
            }

            if (driver.getStatusDriver()
                    != StatusDriver.TERSEDIA) {
                continue;
            }

            if (!driver.isSimAktif(LocalDate.now())) {
                continue;
            }

            hasil.add(driver);
        }

        return hasil;
    }

    private Driver getDriverOrThrow(int idDriver) {
        Optional<Pegawai> data = pegawaiRepository.findById(idDriver);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Driver tidak ditemukan."
            );
        }

        if (!(data.get() instanceof Driver)) {
            throw new ValidationException(
                    "Pegawai yang dipilih bukan Driver."
            );
        }

        return (Driver) data.get();
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
                    "Fitur pengangkutan hanya dapat digunakan oleh Petugas Operasional."
            );
        }

        return (PetugasOperasional) pegawai;
    }
}
