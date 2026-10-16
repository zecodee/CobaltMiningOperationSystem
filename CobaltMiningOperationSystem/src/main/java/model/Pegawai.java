/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import enums.StatusPegawai;

/**
 *
 * @author zefrialrizkullah
 */

public abstract class Pegawai {
    private int idPegawai;
    private String namaPegawai;
    private String noHp;
    private LocalDate tanggalMasuk;
    private StatusPegawai statusPegawai;

    public Pegawai(int idPegawai, String namaPegawai, String noHp, LocalDate tanggalMasuk, StatusPegawai statusPegawai) {
        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.noHp = noHp;
        this.tanggalMasuk = tanggalMasuk;
        this.statusPegawai = statusPegawai;
    }

    public int getIdPegawai() {
        return idPegawai;
    }

    public void setIdPegawai(int idPegawai) {
        this.idPegawai = idPegawai;
    }

    public String getNamaPegawai() {
        return namaPegawai;
    }

    public void setNamaPegawai(String namaPegawai) {
        this.namaPegawai = namaPegawai;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public LocalDate getTanggalMasuk() {
        return tanggalMasuk;
    }

    public void setTanggalMasuk(LocalDate tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public StatusPegawai getStatusPegawai() {
        return statusPegawai;
    }

    public void setStatusPegawai(StatusPegawai statusPegawai) {
        this.statusPegawai = statusPegawai;
    }

    public abstract String getJenisPegawai();

    @Override
    public String toString() {
        return idPegawai+" - "+namaPegawai+" - "+getJenisPegawai();
    }
}
