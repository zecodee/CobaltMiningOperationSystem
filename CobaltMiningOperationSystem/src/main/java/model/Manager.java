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

public class Manager extends Pegawai {
    private String kodeManager;
    private String divisiTanggungJawab;

    public Manager(int idPegawai, String namaPegawai, String noHp, LocalDate tanggalMasuk, StatusPegawai statusPegawai, String kodeManager, String divisiTanggungJawab) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.kodeManager = kodeManager;
        this.divisiTanggungJawab = divisiTanggungJawab;
    }

    public String getKodeManager() {
        return kodeManager;
    }

    public void setKodeManager(String kodeManager) {
        this.kodeManager = kodeManager;
    }

    public String getDivisiTanggungJawab() {
        return divisiTanggungJawab;
    }

    public void setDivisiTanggungJawab(String divisiTanggungJawab) {
        this.divisiTanggungJawab = divisiTanggungJawab;
    }

    @Override
    public String getJenisPegawai() {
        return "MANAGER";
    }
}
