/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Manager extends Pegawai {
    private String divisiTanggungJawab;
    
    public Manager(int idPegawai, String namaPegawai, String noHp, java.time.LocalDate tanggalMasuk,
            enums.StatusPegawai statusPegawai, String divisiTanggungJawab) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.divisiTanggungJawab = divisiTanggungJawab;
    }
    
    public String getDivisiTanggungJawab() {
        return divisiTanggungJawab;
    }
    
    public void setDivisiTanggungJawab(String value) {
        this.divisiTanggungJawab = value;
    }
    
    @Override
    public String getJenisPegawai() {
        return "MANAGER";
    }
    
    @Override
    public String toString() {
        return "Manager #" + getIdPegawai();
    }
}
