/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class Driver extends Pegawai {
    private String noSim;
    private java.time.LocalDate masaBerlakuSim;
    private enums.StatusDriver statusDriver;
    
    public Driver(int idPegawai, String namaPegawai, String noHp, java.time.LocalDate tanggalMasuk,
            enums.StatusPegawai statusPegawai, String noSim, java.time.LocalDate masaBerlakuSim,
            enums.StatusDriver statusDriver) {
        super(idPegawai, namaPegawai, noHp, tanggalMasuk, statusPegawai);
        this.noSim = noSim;
        this.masaBerlakuSim = masaBerlakuSim;
        this.statusDriver = statusDriver;
    }
    
    public String getNoSim() {
        return noSim;
    }
    
    public void setNoSim(String value) {
        this.noSim = value;
    }
    
    public java.time.LocalDate getMasaBerlakuSim() {
        return masaBerlakuSim;
    }
    
    public void setMasaBerlakuSim(java.time.LocalDate value) {
        this.masaBerlakuSim = value;
    }
    
    public enums.StatusDriver getStatusDriver() {
        return statusDriver;
    }
    
    public void setStatusDriver(enums.StatusDriver value) {
        this.statusDriver = value;
    }
    
    @Override
    public String getJenisPegawai() {
        return "DRIVER";
    }
    
    public boolean isSimAktif(java.time.LocalDate d) {
        return masaBerlakuSim != null && !masaBerlakuSim.isBefore(d);
    }
    
    @Override
    public String toString() {
        return "Driver #" + getIdPegawai();
    }
}
