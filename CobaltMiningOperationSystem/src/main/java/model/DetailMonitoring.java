/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import enums.StatusDetail;

/**
 *
 * @author zefrialrizkullah
 */

public class DetailMonitoring {
    private int idDetail;
    private MonitoringLingkungan monitoring;
    private ParameterLingkungan parameter;
    private double nilaiPengukuran;
    private StatusDetail statusDetail;
    private String catatan;

    public DetailMonitoring(
            int idDetail,
            MonitoringLingkungan monitoring,
            ParameterLingkungan parameter,
            double nilaiPengukuran,
            StatusDetail statusDetail,
            String catatan) {

        this.idDetail = idDetail;
        this.monitoring = monitoring;
        this.parameter = parameter;
        this.nilaiPengukuran = nilaiPengukuran;
        this.statusDetail = statusDetail;
        this.catatan = catatan;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public MonitoringLingkungan getMonitoring() {
        return monitoring;
    }

    public void setMonitoring(
            MonitoringLingkungan monitoring) {

        this.monitoring = monitoring;
    }

    public ParameterLingkungan getParameter() {
        return parameter;
    }

    public void setParameter(
            ParameterLingkungan parameter) {

        this.parameter = parameter;
    }

    public double getNilaiPengukuran() {
        return nilaiPengukuran;
    }

    public void setNilaiPengukuran(
            double nilaiPengukuran) {

        this.nilaiPengukuran = nilaiPengukuran;
    }

    public StatusDetail getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(
            StatusDetail statusDetail) {

        this.statusDetail = statusDetail;
    }

    public String getCatatan() {
        return catatan;
    }

    public void setCatatan(String catatan) {
        this.catatan = catatan;
    }

    @Override
    public String toString() {
        return parameter.getNamaParameter()
                + " = "
                + nilaiPengukuran
                + " "
                + parameter.getSatuan()
                + " - "
                + statusDetail;
    }
}