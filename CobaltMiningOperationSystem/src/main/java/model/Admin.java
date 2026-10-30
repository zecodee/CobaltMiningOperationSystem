/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Admin extends Pegawai {
    private String kodeAdmin;
    private java.time.LocalDate tanggalMulaiAkses;
    
    public Admin(int idPegawai, String namaPegawai, String noHp, java.time.LocalDate tanggalMasuk,
            enums.StatusPegawai statusPegawai, String kodeAdmin, java.time.LocalDate tanggalMulaiAkses) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.kodeAdmin = kodeAdmin;
        this.tanggalMulaiAkses = tanggalMulaiAkses;
    }
    
    public String getKodeAdmin() {
        return kodeAdmin;
    }
    
    public void setKodeAdmin(String value) {
        this.kodeAdmin = value;
    }
    
    public java.time.LocalDate getTanggalMulaiAkses() {
        return tanggalMulaiAkses;
    }
    
    public void setTanggalMulaiAkses(java.time.LocalDate value) {
        this.tanggalMulaiAkses = value;
    }
    
    @Override
    public String getJenisPegawai() {
        return "ADMIN";
    }
    
    @Override
    public String toString() {
        return "Admin #" + getIdPegawai();
    }
}
