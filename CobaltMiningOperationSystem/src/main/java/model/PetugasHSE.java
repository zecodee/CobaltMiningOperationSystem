/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusPegawai;
import java.time.LocalDate;

/**
 *
 * @author zefrialrizkullah
 */

public class PetugasHSE extends Pegawai {
    private String noSertifikasiHSE;
    private LocalDate masaBerlakuSertifikasi;

    public PetugasHSE(int idPegawai, String namaPegawai, String noHp, LocalDate tanggalMasuk, StatusPegawai statusPegawai, String noSertifikasiHSE, LocalDate masaBerlakuSertifikasi) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.noSertifikasiHSE = noSertifikasiHSE;
        this.masaBerlakuSertifikasi = masaBerlakuSertifikasi;
    }

    public String getNoSertifikasiHSE() {
        return noSertifikasiHSE;
    }

    public void setNoSertifikasiHSE(String noSertifikasiHSE) {
        this.noSertifikasiHSE = noSertifikasiHSE;
    }

    public LocalDate getMasaBerlakuSertifikasi() {
        return masaBerlakuSertifikasi;
    }

    public void setMasaBerlakuSertifikasi(LocalDate masaBerlakuSertifikasi) {
        this.masaBerlakuSertifikasi = masaBerlakuSertifikasi;
    }

    public boolean isSertifikasiAktif(LocalDate tanggal) {
        return masaBerlakuSertifikasi != null && !masaBerlakuSertifikasi.isBefore(tanggal);
    }

    @Override
    public String getJenisPegawai() {
        return "PETUGAS HSE";
    }
}
