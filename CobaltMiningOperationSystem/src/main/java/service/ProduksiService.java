/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.JenisLokasi;
import enums.StatusLokasi;
import enums.StatusPegawai;
import enums.StatusProduksi;
import exception.DataNotFoundException;
import exception.ValidationException;
import model.JenisMaterial;
import model.Lokasi;
import model.PetugasOperasional;
import model.ProduksiTambang;
import repository.MaterialRepository;
import repository.LokasiRepository;
import repository.ProduksiRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class ProduksiService {
    private final ProduksiRepository produksiRepository;
    private final MaterialRepository materialRepository;
    private final LokasiRepository lokasiRepository;

    public ProduksiService(
            ProduksiRepository produksiRepository,
            MaterialRepository materialRepository,
            LokasiRepository lokasiRepository) {

        this.produksiRepository = produksiRepository;
        this.materialRepository = materialRepository;
        this.lokasiRepository = lokasiRepository;
    }

    public ProduksiTambang tambahProduksi(
            int idProduksi,
            int idMaterial,
            int idLokasi,
            PetugasOperasional petugasOperasional,
            LocalDate tanggalProduksi,
            double jumlahProduksi) {

        if (idProduksi <= 0) {
            throw new ValidationException(
                    "ID produksi tidak valid."
            );
        }

        if (produksiRepository.findById(idProduksi).isPresent()) {
            throw new ValidationException(
                    "ID produksi sudah digunakan."
            );
        }

        if (petugasOperasional == null) {
            throw new ValidationException(
                    "Petugas Operasional tidak tersedia."
            );
        }

        if (petugasOperasional.getStatusPegawai()
                != StatusPegawai.AKTIF) {

            throw new ValidationException(
                    "Petugas Operasional tidak aktif."
            );
        }

        if (tanggalProduksi == null) {
            throw new ValidationException(
                    "Tanggal produksi wajib diisi."
            );
        }

        if (jumlahProduksi <= 0) {
            throw new ValidationException(
                    "Jumlah produksi harus lebih dari 0."
            );
        }

        JenisMaterial material = getMaterialOrThrow(idMaterial);
        Lokasi lokasi = getLokasiOrThrow(idLokasi);
        validasiLokasiProduksi(lokasi);

        ProduksiTambang produksi =
                new ProduksiTambang(
                        idProduksi,
                        material,
                        lokasi,
                        petugasOperasional,
                        tanggalProduksi,
                        jumlahProduksi,
                        jumlahProduksi,
                        StatusProduksi.TERSEDIA
                );

        produksiRepository.save(produksi);
        return produksi;
    }

    public void ubahProduksi(
            int idProduksi,
            int idMaterial,
            int idLokasi,
            LocalDate tanggalProduksi,
            double jumlahProduksi) {

        ProduksiTambang produksi = getProduksiOrThrow(idProduksi);

        if (Math.abs(produksi.getJumlahProduksi() - produksi.getJumlahTersedia()) > 0.000001) {
            throw new ValidationException("Produksi tidak dapat diubah karena sebagian material sudah diangkut.");
        }

        if (tanggalProduksi == null) {
            throw new ValidationException("Tanggal produksi wajib diisi.");
        }

        if (jumlahProduksi <= 0) {
            throw new ValidationException("Jumlah produksi harus lebih dari 0.");
        }

        JenisMaterial material = getMaterialOrThrow(idMaterial);
        Lokasi lokasi = getLokasiOrThrow(idLokasi);
        validasiLokasiProduksi(lokasi);
        produksi.setMaterial(material);
        produksi.setLokasi(lokasi);
        produksi.setTanggalProduksi(tanggalProduksi);
        produksi.setJumlahProduksi(jumlahProduksi);
        produksi.setJumlahTersedia(jumlahProduksi);
        produksi.setStatusProduksi(StatusProduksi.TERSEDIA);
        produksiRepository.update(produksi);
    }

    public void hapusProduksi(int idProduksi) {
        ProduksiTambang produksi = getProduksiOrThrow(idProduksi);

        if (Math.abs(produksi.getJumlahProduksi() - produksi.getJumlahTersedia()) > 0.000001) {
            throw new ValidationException("Produksi tidak dapat dihapus karena material sudah pernah diangkut.");
        }

        produksiRepository.delete(idProduksi);
    }

    public ProduksiTambang cariProduksiById(int idProduksi) {
        return getProduksiOrThrow(idProduksi);
    }

    public List<ProduksiTambang> tampilkanSemuaProduksi() {
        return produksiRepository.findAll();
    }

    public List<ProduksiTambang> tampilkanProduksiTersedia() {
        return produksiRepository.findTersedia();
    }

    private ProduksiTambang getProduksiOrThrow(
            int idProduksi) {

        Optional<ProduksiTambang> produksi = produksiRepository.findById(idProduksi);

        if (!produksi.isPresent()) {
            throw new DataNotFoundException("Produksi tidak ditemukan.");
        }

        return produksi.get();
    }

    private JenisMaterial getMaterialOrThrow(
            int idMaterial) {

        Optional<JenisMaterial> material = materialRepository.findById(idMaterial);

        if (!material.isPresent()) {
            throw new DataNotFoundException("Jenis material tidak ditemukan.");
        }

        return material.get();
    }

    private Lokasi getLokasiOrThrow(int idLokasi) {
        Optional<Lokasi> lokasi = lokasiRepository.findById(idLokasi);

        if (!lokasi.isPresent()) {
            throw new DataNotFoundException("Lokasi tidak ditemukan.");
        }

        return lokasi.get();
    }

    private void validasiLokasiProduksi(Lokasi lokasi) {
        if (lokasi.getJenisLokasi() != JenisLokasi.PIT) {
            throw new ValidationException("Produksi tambang hanya dapat dicatat pada lokasi PIT.");
        }

        if (lokasi.getStatusOperasional() != StatusLokasi.AKTIF) {
            throw new ValidationException("Lokasi produksi harus berstatus AKTIF.");
        }
    }
}
