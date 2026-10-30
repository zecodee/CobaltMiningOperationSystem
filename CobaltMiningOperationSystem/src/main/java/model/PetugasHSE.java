/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class PetugasHSE extends Pegawai {
    private String noSertifikasiHSE;
    private java.time.LocalDate masaBerlakuSertifikasi;
    
    public PetugasHSE(int idPegawai, String namaPegawai, String noHp, java.time.LocalDate tanggalMasuk,
            enums.StatusPegawai statusPegawai, String noSertifikasiHSE,
            java.time.LocalDate masaBerlakuSertifikasi) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.noSertifikasiHSE = noSertifikasiHSE;
        this.masaBerlakuSertifikasi = masaBerlakuSertifikasi;
    }
    
    public String getNoSertifikasiHSE() {
        return noSertifikasiHSE;
    }
    
    public void setNoSertifikasiHSE(String value) {
        this.noSertifikasiHSE = value;
    }
    
    public java.time.LocalDate getMasaBerlakuSertifikasi() {
        return masaBerlakuSertifikasi;
    }
    
    public void setMasaBerlakuSertifikasi(java.time.LocalDate value) {
        this.masaBerlakuSertifikasi = value;
    }
    
    @Override
    public String getJenisPegawai() {
        return "PETUGASHSE";
    }
    
    public boolean isSertifikasiAktif(java.time.LocalDate d) {
        return masaBerlakuSertifikasi != null && !masaBerlakuSertifikasi.isBefore(d);
    }
    
    @Override
    public String toString() {
        return "PetugasHSE #" + getIdPegawai();
    }
}
