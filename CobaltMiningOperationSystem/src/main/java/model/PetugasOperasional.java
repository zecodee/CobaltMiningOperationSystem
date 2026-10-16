/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.ShiftKerja;
import enums.StatusPegawai;
import java.time.LocalDate;

/**
 *
 * @author zefrialrizkullah
 */

public class PetugasOperasional extends Pegawai {
    private String kodePetugasOperasional;
    private String areaTugas;
    private ShiftKerja shiftKerja;

    public PetugasOperasional(int idPegawai, String namaPegawai, String noHp, LocalDate tanggalMasuk, StatusPegawai statusPegawai, String kodePetugasOperasional, String areaTugas, ShiftKerja shiftKerja) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.kodePetugasOperasional = kodePetugasOperasional;
        this.areaTugas = areaTugas;
        this.shiftKerja = shiftKerja;
    }

    public String getKodePetugasOperasional() {
        return kodePetugasOperasional;
    }

    public void setKodePetugasOperasional(String kodePetugasOperasional) {
        this.kodePetugasOperasional = kodePetugasOperasional;
    }

    public String getAreaTugas() {
        return areaTugas;
    }

    public void setAreaTugas(String areaTugas) {
        this.areaTugas = areaTugas;
    }

    public ShiftKerja getShiftKerja() {
        return shiftKerja;
    }

    public void setShiftKerja(ShiftKerja shiftKerja) {
        this.shiftKerja = shiftKerja;
    }

    @Override
    public String getJenisPegawai() {
        return "PETUGAS OPERASIONAL";
    }
}