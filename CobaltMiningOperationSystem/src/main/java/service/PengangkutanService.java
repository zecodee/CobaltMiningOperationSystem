/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.StatusDriver;
import enums.StatusKendaraan;
import enums.StatusLokasi;
import enums.StatusPegawai;
import enums.StatusPengangkutan;
import enums.StatusProduksi;
import exception.DataNotFoundException;
import exception.ValidationException;
import model.Driver;
import model.Kendaraan;
import model.Lokasi;
import model.Pengangkutan;
import model.PetugasOperasional;
import model.ProduksiTambang;
import repository.KendaraanRepository;
import repository.LokasiRepository;
import repository.PengangkutanRepository;
import repository.ProduksiRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class PengangkutanService {
    private static final double EPSILON = 0.000001;
    private final PengangkutanRepository pengangkutanRepository;
    private final ProduksiRepository produksiRepository;
    private final KendaraanRepository kendaraanRepository;
    private final LokasiRepository lokasiRepository;

    public PengangkutanService(
            PengangkutanRepository pengangkutanRepository,
            ProduksiRepository produksiRepository,
            KendaraanRepository kendaraanRepository,
            LokasiRepository lokasiRepository) {

        this.pengangkutanRepository = pengangkutanRepository;
        this.produksiRepository = produksiRepository;
        this.kendaraanRepository = kendaraanRepository;
        this.lokasiRepository = lokasiRepository;
    }

    public Pengangkutan buatPengangkutan(
            int idPengangkutan,
            int idProduksi,
            PetugasOperasional petugasOperasional,
            int idKendaraan,
            Driver driver,
            int idLokasiAsal,
            int idLokasiTujuan,
            LocalDate tanggalPengangkutan,
            double jumlahMuatan) {

        if (idPengangkutan <= 0) {
            throw new ValidationException("ID pengangkutan tidak valid.");
        }

        if (pengangkutanRepository.findById(idPengangkutan).isPresent()) {
            throw new ValidationException("ID pengangkutan sudah digunakan.");
        }

        validasiPetugasOperasional(petugasOperasional);
        ProduksiTambang produksi = getProduksiOrThrow(idProduksi);
        Kendaraan kendaraan = getKendaraanOrThrow(idKendaraan);
        Lokasi lokasiAsal = getLokasiOrThrow(idLokasiAsal);
        Lokasi lokasiTujuan = getLokasiOrThrow(idLokasiTujuan);

        if (driver == null) {
            throw new ValidationException("Driver wajib dipilih.");
        }

        if (tanggalPengangkutan == null) {
            throw new ValidationException("Tanggal pengangkutan wajib diisi.");
        }
        
        if (tanggalPengangkutan.isBefore(LocalDate.now())) {
            throw new ValidationException(
                    "Tanggal pengangkutan tidak boleh sebelum hari ini."
            );
        }

        if (jumlahMuatan <= 0) {
            throw new ValidationException("Jumlah muatan harus lebih dari 0.");
        }

        validasiProduksi(produksi, jumlahMuatan);
        
        if (produksi.getTanggalProduksi() != null && tanggalPengangkutan.isBefore(produksi.getTanggalProduksi())) {
            throw new ValidationException(
                    "Tanggal pengangkutan tidak boleh sebelum tanggal produksi."
            );
        }
        
        validasiKendaraan(kendaraan, jumlahMuatan);
        validasiDriver(driver);
        validasiLokasi(produksi, lokasiAsal, lokasiTujuan);
        validasiKetersediaanJadwal(kendaraan, driver, tanggalPengangkutan);
        double tersediaUntukDijadwalkan = hitungMaterialTersediaUntukDijadwalkan(produksi);

        if (jumlahMuatan - tersediaUntukDijadwalkan > EPSILON) {
            throw new ValidationException("Jumlah muatan melebihi material yang tersedia untuk dijadwalkan. Tersedia: " + tersediaUntukDijadwalkan);
        }

        Pengangkutan pengangkutan =
                new Pengangkutan(
                        idPengangkutan,
                        produksi,
                        petugasOperasional,
                        kendaraan,
                        driver,
                        lokasiAsal,
                        lokasiTujuan,
                        tanggalPengangkutan,
                        null,
                        null,
                        jumlahMuatan,
                        StatusPengangkutan.DIJADWALKAN
                );

        pengangkutanRepository.save(pengangkutan);
        return pengangkutan;
    }

    public void mulaiPengangkutan(
            int idPengangkutan) {

        Pengangkutan pengangkutan = getPengangkutanOrThrow(idPengangkutan);

        if (pengangkutan.getStatusPengangkutan()
                != StatusPengangkutan.DIJADWALKAN) {

            throw new ValidationException(
                    "Hanya pengangkutan berstatus DIJADWALKAN yang dapat dimulai."
            );
        }

        Kendaraan kendaraan = pengangkutan.getKendaraan();
        Driver driver = pengangkutan.getDriver();

        if (kendaraan.getStatusKendaraan()
                != StatusKendaraan.TERSEDIA) {

            throw new ValidationException(
                    "Kendaraan sedang tidak tersedia."
            );
        }

        if (driver.getStatusDriver()
                != StatusDriver.TERSEDIA) {

            throw new ValidationException(
                    "Driver sedang tidak tersedia."
            );
        }

        validasiDriver(driver);
        kendaraan.setStatusKendaraan(StatusKendaraan.DIGUNAKAN);
        driver.setStatusDriver(StatusDriver.BERTUGAS);
        pengangkutan.setWaktuMulai(LocalDateTime.now());
        pengangkutan.setStatusPengangkutan(StatusPengangkutan.DALAM_PERJALANAN);
        kendaraanRepository.update(kendaraan);
        pengangkutanRepository.update(pengangkutan);
    }

    public void selesaikanPengangkutan(
            int idPengangkutan) {

        Pengangkutan pengangkutan =
                getPengangkutanOrThrow(
                        idPengangkutan
                );

        if (pengangkutan.getStatusPengangkutan()
                != StatusPengangkutan.DALAM_PERJALANAN) {

            throw new ValidationException(
                    "Hanya pengangkutan DALAM_PERJALANAN yang dapat diselesaikan."
            );
        }

        ProduksiTambang produksi = pengangkutan.getProduksi();
        Kendaraan kendaraan = pengangkutan.getKendaraan();
        Driver driver = pengangkutan.getDriver();
        double sisa = produksi.getJumlahTersedia() - pengangkutan.getJumlahMuatan();

        if (sisa < -EPSILON) {
            throw new ValidationException(
                    "Jumlah material produksi tidak mencukupi."
            );
        }

        if (Math.abs(sisa) <= EPSILON) {
            sisa = 0;
        }

        produksi.setJumlahTersedia(sisa);

        if (sisa <= EPSILON) {
            produksi.setJumlahTersedia(0);
            produksi.setStatusProduksi(
                    StatusProduksi.HABIS
            );
        } else if (sisa
                < produksi.getJumlahProduksi()) {

            produksi.setStatusProduksi(
                    StatusProduksi.SEBAGIAN_DIANGKUT
            );
        } else {
            produksi.setStatusProduksi(
                    StatusProduksi.TERSEDIA
            );
        }

        kendaraan.setStatusKendaraan(StatusKendaraan.TERSEDIA);
        driver.setStatusDriver(StatusDriver.TERSEDIA);
        pengangkutan.setWaktuSelesai(LocalDateTime.now());
        pengangkutan.setStatusPengangkutan(StatusPengangkutan.SELESAI);
        produksiRepository.update(produksi);
        kendaraanRepository.update(kendaraan);
        pengangkutanRepository.update(pengangkutan);
    }

    public void batalkanPengangkutan(
            int idPengangkutan) {

        Pengangkutan pengangkutan =
                getPengangkutanOrThrow(
                        idPengangkutan
                );

        if (pengangkutan.getStatusPengangkutan()
                != StatusPengangkutan.DIJADWALKAN) {

            throw new ValidationException(
                    "Hanya pengangkutan DIJADWALKAN yang dapat dibatalkan."
            );
        }

        pengangkutan.setStatusPengangkutan(StatusPengangkutan.DIBATALKAN);

        pengangkutanRepository.update(
                pengangkutan
        );
    }

    public double hitungMaterialTersediaUntukDijadwalkan(
            ProduksiTambang produksi) {

        if (produksi == null) {
            return 0;
        }

        double reserved = 0;

        List<Pengangkutan> daftar =
                pengangkutanRepository
                .findByProduksi(
                        produksi.getIdProduksi()
                );

        for (Pengangkutan pengangkutan : daftar) {

            if (pengangkutan.getStatusPengangkutan()
                    == StatusPengangkutan.DIJADWALKAN
                    || pengangkutan.getStatusPengangkutan()
                    == StatusPengangkutan.DALAM_PERJALANAN) {

                reserved +=
                        pengangkutan.getJumlahMuatan();
            }
        }

        double tersedia =
                produksi.getJumlahTersedia()
                        - reserved;

        return tersedia < EPSILON
                ? 0
                : tersedia;
    }

    public Pengangkutan cariPengangkutanById(
            int idPengangkutan) {

        return getPengangkutanOrThrow(
                idPengangkutan
        );
    }

    public List<Pengangkutan>
            tampilkanSemuaPengangkutan() {

        return pengangkutanRepository.findAll();
    }

    private void validasiPetugasOperasional(
            PetugasOperasional petugas) {

        if (petugas == null) {
            throw new ValidationException(
                    "Petugas Operasional tidak tersedia."
            );
        }

        if (petugas.getStatusPegawai()
                != StatusPegawai.AKTIF) {

            throw new ValidationException(
                    "Petugas Operasional tidak aktif."
            );
        }
    }

    private void validasiProduksi(
            ProduksiTambang produksi,
            double jumlahMuatan) {

        if (produksi.getStatusProduksi()
                == StatusProduksi.HABIS) {

            throw new ValidationException(
                    "Produksi sudah habis."
            );
        }

        if (produksi.getJumlahTersedia()
                + EPSILON < jumlahMuatan) {

            throw new ValidationException(
                    "Jumlah muatan melebihi jumlah material tersedia."
            );
        }
    }

    private void validasiKendaraan(
            Kendaraan kendaraan,
            double jumlahMuatan) {

        if (kendaraan.getStatusKendaraan()
                != StatusKendaraan.TERSEDIA) {

            throw new ValidationException(
                    "Kendaraan tidak tersedia."
            );
        }

        if (jumlahMuatan
                - kendaraan.getKapasitas() > EPSILON) {

            throw new ValidationException(
                    "Jumlah muatan melebihi kapasitas kendaraan."
            );
        }
    }

    private void validasiDriver(Driver driver) {

        if (driver.getStatusPegawai()
                != StatusPegawai.AKTIF) {

            throw new ValidationException(
                    "Pegawai Driver tidak aktif."
            );
        }

        if (driver.getStatusDriver()
                != StatusDriver.TERSEDIA) {

            throw new ValidationException(
                    "Driver tidak tersedia."
            );
        }

        if (!driver.isSimAktif(LocalDate.now())) {
            throw new ValidationException(
                    "SIM Driver sudah tidak berlaku."
            );
        }
    }

    private void validasiLokasi(
            ProduksiTambang produksi,
            Lokasi asal,
            Lokasi tujuan) {

        if (asal.getIdLokasi()
                == tujuan.getIdLokasi()) {

            throw new ValidationException(
                    "Lokasi asal dan tujuan tidak boleh sama."
            );
        }

        if (asal.getIdLokasi()
                != produksi.getLokasi().getIdLokasi()) {

            throw new ValidationException(
                    "Lokasi asal harus sama dengan lokasi produksi."
            );
        }

        if (asal.getStatusOperasional()
                != StatusLokasi.AKTIF) {

            throw new ValidationException(
                    "Lokasi asal harus berstatus AKTIF."
            );
        }

        if (tujuan.getStatusOperasional()
                != StatusLokasi.AKTIF) {

            throw new ValidationException(
                    "Lokasi tujuan harus berstatus AKTIF."
            );
        }
    }

    private void validasiKetersediaanJadwal(
        Kendaraan kendaraan,
        Driver driver,
        LocalDate tanggalPengangkutan) {

        for (Pengangkutan existing :
                pengangkutanRepository.findAll()) {

            StatusPengangkutan status =
                    existing.getStatusPengangkutan();

            boolean aktif =
                    status == StatusPengangkutan.DIJADWALKAN
                    || status == StatusPengangkutan.DALAM_PERJALANAN;

            if (!aktif) {
                continue;
            }

            if (status == StatusPengangkutan.DALAM_PERJALANAN) {

                if (existing.getKendaraan() != null
                        && existing.getKendaraan()
                        .getIdKendaraan()
                        == kendaraan.getIdKendaraan()) {

                    throw new ValidationException(
                            "Kendaraan sedang digunakan pada pengangkutan lain."
                    );
                }

                if (existing.getDriver() != null
                        && existing.getDriver()
                        .getIdPegawai()
                        == driver.getIdPegawai()) {

                    throw new ValidationException(
                            "Driver sedang bertugas pada pengangkutan lain."
                    );
                }

                continue;
            }

            if (existing.getTanggalPengangkutan() == null
                    || !existing.getTanggalPengangkutan()
                    .equals(tanggalPengangkutan)) {
                continue;
            }

            if (existing.getKendaraan() != null
                    && existing.getKendaraan()
                    .getIdKendaraan()
                    == kendaraan.getIdKendaraan()) {

                throw new ValidationException(
                        "Kendaraan sudah dijadwalkan pada tanggal tersebut."
                );
            }

            if (existing.getDriver() != null
                    && existing.getDriver()
                    .getIdPegawai()
                    == driver.getIdPegawai()) {

                throw new ValidationException(
                        "Driver sudah dijadwalkan pada tanggal tersebut."
                );
            }
        }
    }

    private Pengangkutan getPengangkutanOrThrow(
            int idPengangkutan) {

        Optional<Pengangkutan> data =
                pengangkutanRepository
                .findById(idPengangkutan);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Pengangkutan tidak ditemukan."
            );
        }

        return data.get();
    }

    private ProduksiTambang getProduksiOrThrow(
            int idProduksi) {

        Optional<ProduksiTambang> data =
                produksiRepository
                .findById(idProduksi);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Produksi tidak ditemukan."
            );
        }

        return data.get();
    }

    private Kendaraan getKendaraanOrThrow(
            int idKendaraan) {

        Optional<Kendaraan> data =
                kendaraanRepository
                .findById(idKendaraan);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Kendaraan tidak ditemukan."
            );
        }

        return data.get();
    }

    private Lokasi getLokasiOrThrow(
            int idLokasi) {

        Optional<Lokasi> data =
                lokasiRepository.findById(idLokasi);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Lokasi tidak ditemukan."
            );
        }

        return data.get();
    }
}