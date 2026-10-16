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

    public ParameterLingkungan(
            int idParameter,
            String namaParameter,
            String satuan,
            Double batasMinimum,
            Double batasMaksimum,
            String keterangan) {

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

    public void setIdParameter(int idParameter) {
        this.idParameter = idParameter;
    }

    public String getNamaParameter() {
        return namaParameter;
    }

    public void setNamaParameter(String namaParameter) {
        this.namaParameter = namaParameter;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public Double getBatasMinimum() {
        return batasMinimum;
    }

    public void setBatasMinimum(Double batasMinimum) {
        this.batasMinimum = batasMinimum;
    }

    public Double getBatasMaksimum() {
        return batasMaksimum;
    }

    public void setBatasMaksimum(Double batasMaksimum) {
        this.batasMaksimum = batasMaksimum;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return namaParameter+ " (" + satuan + ")";
    }
}