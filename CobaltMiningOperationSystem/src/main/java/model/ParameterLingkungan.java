/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class ParameterLingkungan {
    private int idParameter;
    private String namaParameter;
    private String satuan;
    private Double batasMinimum;
    private Double batasMaksimum;
    private String keterangan;
    
    public ParameterLingkungan(int idParameter, String namaParameter, String satuan, Double batasMinimum,
            Double batasMaksimum, String keterangan) {
        this.idParameter = idParameter;
        this.namaParameter = namaParameter;
        this.satuan = satuan;
        this.batasMinimum = batasMinimum;
        this.batasMaksimum = batasMaksimum;
        this.keterangan = keterangan;
    }
    
    public int getIdParameter() {
        return idParameter;
    }
    
    public void setIdParameter(int value) {
        this.idParameter = value;
    }
    
    public String getNamaParameter() {
        return namaParameter;
    }
    
    public void setNamaParameter(String value) {
        this.namaParameter = value;
    }
    
    public String getSatuan() {
        return satuan;
    }
    
    public void setSatuan(String value) {
        this.satuan = value;
    }
    
    public Double getBatasMinimum() {
        return batasMinimum;
    }
    
    public void setBatasMinimum(Double value) {
        this.batasMinimum = value;
    }
    
    public Double getBatasMaksimum() {
        return batasMaksimum;
    }
    
    public void setBatasMaksimum(Double value) {
        this.batasMaksimum = value;
    }
    
    public String getKeterangan() {
        return keterangan;
    }
    
    public void setKeterangan(String value) {
        this.keterangan = value;
    }
    
    @Override
    public String toString() {
        return "ParameterLingkungan #" + idParameter;
    }
}
