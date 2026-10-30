/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class PetugasOperasional extends Pegawai {
    private enums.ShiftKerja shiftKerja;
    
    public PetugasOperasional(int idPegawai, String namaPegawai, String noHp,
            java.time.LocalDate tanggalMasuk, enums.StatusPegawai statusPegawai,
            enums.ShiftKerja shiftKerja) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.shiftKerja = shiftKerja;
    }
    
    public enums.ShiftKerja getShiftKerja() {
        return shiftKerja;
    }
    
    public void setShiftKerja(enums.ShiftKerja value) {
        this.shiftKerja = value;
    }
    
    @Override
    public String getJenisPegawai() {
        return "PETUGASOPERASIONAL";
    }
    
    @Override
    public String toString() {
        return "PetugasOperasional #" + getIdPegawai();
    }
}
