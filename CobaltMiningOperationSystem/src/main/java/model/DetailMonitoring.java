/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class DetailMonitoring {
    private int idDetail;
    private MonitoringLingkungan monitoring;
    private ParameterLingkungan parameter;
    private double nilaiPengukuran;
    private enums.StatusDetail statusDetail;
    private String catatan;
    
    public DetailMonitoring(int idDetail, MonitoringLingkungan monitoring, ParameterLingkungan parameter,
            double nilaiPengukuran, enums.StatusDetail statusDetail, String catatan) {
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
    
    public void setIdDetail(int value) {
        this.idDetail = value;
    }
    
    public MonitoringLingkungan getMonitoring() {
        return monitoring;
    }
    
    public void setMonitoring(MonitoringLingkungan value) {
        this.monitoring = value;
    }
    
    public ParameterLingkungan getParameter() {
        return parameter;
    }
    
    public void setParameter(ParameterLingkungan value) {
        this.parameter = value;
    }
    
    public double getNilaiPengukuran() {
        return nilaiPengukuran;
    }
    
    public void setNilaiPengukuran(double value) {
        this.nilaiPengukuran = value;
    }
    
    public enums.StatusDetail getStatusDetail() {
        return statusDetail;
    }
    
    public void setStatusDetail(enums.StatusDetail value) {
        this.statusDetail = value;
    }
    
    public String getCatatan() {
        return catatan;
    }
    
    public void setCatatan(String value) {
        this.catatan = value;
    }
    
    @Override
    public String toString() {
        return "DetailMonitoring #" + idDetail;
    }
}
