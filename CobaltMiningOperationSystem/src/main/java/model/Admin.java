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

public class Admin extends Pegawai {
    private String kodeAdmin;
    private LocalDate tanggalMulaiAkses;

    public Admin(int idPegawai, String namaPegawai, String noHp, LocalDate tanggalMasuk, StatusPegawai statusPegawai, String kodeAdmin, LocalDate tanggalMulaiAkses) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.kodeAdmin = kodeAdmin;
        this.tanggalMulaiAkses = tanggalMulaiAkses;
    }

    public String getKodeAdmin() {
        return kodeAdmin;
    }

    public void setKodeAdmin(String kodeAdmin) {
        this.kodeAdmin = kodeAdmin;
    }

    public LocalDate getTanggalMulaiAkses() {
        return tanggalMulaiAkses;
    }

    public void setTanggalMulaiAkses(LocalDate tanggalMulaiAkses) {
        this.tanggalMulaiAkses = tanggalMulaiAkses;
    }

    @Override
    public String getJenisPegawai() {
        return "ADMIN";
    }
}