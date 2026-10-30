/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public abstract class Pegawai {
    private int idPegawai;
    private String namaPegawai;
    private String noHp;
    private java.time.LocalDate tanggalMasuk;
    private enums.StatusPegawai statusPegawai;
    public Pegawai(int idPegawai, String namaPegawai, String noHp, java.time.LocalDate tanggalMasuk,
            enums.StatusPegawai statusPegawai) {
        this.idPegawai = idPegawai;
        this.namaPegawai = namaPegawai;
        this.noHp = noHp;
        this.tanggalMasuk = tanggalMasuk;
        this.statusPegawai = statusPegawai;
    }
    
    public int getIdPegawai() {
        return idPegawai;
    }
    
    public void setIdPegawai(int value) {
        this.idPegawai = value;
    }
    
    public String getNamaPegawai() {
        return namaPegawai;
    }
    
    public void setNamaPegawai(String value) {
        this.namaPegawai = value;
    }
    
    public String getNoHp() {
        return noHp;
    }
    
    public void setNoHp(String value) {
        this.noHp = value;
    }
    
    public java.time.LocalDate getTanggalMasuk() {
        return tanggalMasuk;
    }
    
    public void setTanggalMasuk(java.time.LocalDate value) {
        this.tanggalMasuk = value;
    }
    
    public enums.StatusPegawai getStatusPegawai() {
        return statusPegawai;
    }
    
    public void setStatusPegawai(enums.StatusPegawai value) {
        this.statusPegawai = value;
    }
    
    public abstract String getJenisPegawai();
    
    @Override
    public String toString() {
        return "Pegawai #" + idPegawai;
    }
}
