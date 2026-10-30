/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.*;
import exception.*;
import model.*;
import repository.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class ProduksiService {
    private final ProduksiRepository prod;
    private final MaterialRepository mat;
    private final LokasiRepository loc;
    private final PengangkutanRepository haul;
    public ProduksiService(ProduksiRepository p, MaterialRepository m, LokasiRepository l,
            PengangkutanRepository h) {
        prod = p;
        mat = m;
        loc = l;
        haul = h;
    }
    public ProduksiTambang tambahProduksi(int idProduksi, int idMaterial, int idLokasi,
            PetugasOperasional petugas, LocalDate tanggal, double jumlah) {
        if (idProduksi != 0)throw new ValidationException("ID baru harus 0.");
        if (petugas == null || petugas.getStatusPegawai() != StatusPegawai.AKTIF)throw new ValidationException("Petugas tidak aktif.");
        validasi(tanggal, jumlah);
        JenisMaterial m = mat.findById(idMaterial).orElseThrow(()->new DataNotFoundException("Material tidak ditemukan."));
        Lokasi l = lokasi(idLokasi);
        validasiLokasi(l);
        return prod.save(new ProduksiTambang(0, m, l, petugas, tanggal, jumlah, jumlah, StatusProduksi.TERSEDIA));
    }
    public ProduksiTambang tambahProduksi(int idMaterial, int idLokasi, PetugasOperasional p, LocalDate t,
            double j) {
        return tambahProduksi(0, idMaterial, idLokasi, p, t, j);
    }
    public void ubahProduksi(int id, int idMaterial, int idLokasi, LocalDate t, double j) {
        ProduksiTambang p = cariProduksiById(id);
        checkHistory(id);
        validasi(t, j);
        JenisMaterial m = mat.findById(idMaterial).orElseThrow(()->new DataNotFoundException("Material tidak ditemukan."));
        Lokasi l = lokasi(idLokasi);
        validasiLokasi(l);
        p.setMaterial(m);
        p.setLokasi(l);
        p.setTanggalProduksi(t);
        p.setJumlahProduksi(j);
        p.setJumlahTersedia(j);
        p.setStatusProduksi(StatusProduksi.TERSEDIA);
        prod.update(p);
    }
    public void hapusProduksi(int id) {
        cariProduksiById(id);
        checkHistory(id);
        prod.delete(id);
    }
    private void checkHistory(int id) {
        if (!haul.findByProduksi(id).isEmpty())throw new ValidationException("Produksi sudah memiliki riwayat pengangkutan.");
    }
    private void validasi(LocalDate t, double j) {
        if (t == null || t.isAfter(LocalDate.now()))throw new ValidationException("Tanggal produksi tidak valid.");
        if (!Double.isFinite(j) || j <= 0
 || Math.abs(j*100-Math.rint(j*100))>0.00001)throw new ValidationException("Jumlah produksi harus positif dengan maksimal 2 desimal.");
    }
    private void validasiLokasi(Lokasi l) {
        if (l.getJenisLokasi() != JenisLokasi.PIT
 || l.getStatusOperasional() != StatusLokasi.AKTIF)throw new ValidationException("Produksi hanya pada PIT aktif.");
    }
    private Lokasi lokasi(int id) {
        return loc.findById(id).orElseThrow(()->new DataNotFoundException("Lokasi tidak ditemukan."));
    }
    public ProduksiTambang cariProduksiById(int id) {
        return prod.findById(id).orElseThrow(()->new DataNotFoundException("Produksi tidak ditemukan."));
    }
    public List<ProduksiTambang> tampilkanSemuaProduksi() {
        return prod.findAll();
    }
    public List<ProduksiTambang> tampilkanProduksiTersedia() {
        return prod.findTersedia();
    }
}
