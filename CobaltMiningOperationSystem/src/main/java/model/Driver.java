/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusDriver;
import enums.StatusPegawai;
import java.time.LocalDate;

/**
 *
 * @author zefrialrizkullah
 */

public class Driver extends Pegawai {
    private String noSim;
    private LocalDate masaBerlakuSim;
    private StatusDriver statusDriver;

    public Driver(int idPegawai, String namaPegawai, String noHp, LocalDate tanggalMasuk, StatusPegawai statusPegawai, String noSim, LocalDate masaBerlakuSim, StatusDriver statusDriver) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.noSim = noSim;
        this.masaBerlakuSim = masaBerlakuSim;
        this.statusDriver = statusDriver;
    }

    public String getNoSim() {
        return noSim;
    }

    public void setNoSim(String noSim) {
        this.noSim = noSim;
    }

    public LocalDate getMasaBerlakuSim() {
        return masaBerlakuSim;
    }

    public void setMasaBerlakuSim(LocalDate masaBerlakuSim) {
        this.masaBerlakuSim = masaBerlakuSim;
    }

    public StatusDriver getStatusDriver() {
        return statusDriver;
    }

    public void setStatusDriver(StatusDriver statusDriver) {
        this.statusDriver = statusDriver;
    }

    public boolean isSimAktif(LocalDate tanggal) {
        return masaBerlakuSim != null && !masaBerlakuSim.isBefore(tanggal);
    }

    @Override
    public String getJenisPegawai() {
        return "DRIVER";
    }
}