/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class JenisMaterial {
    private int idMaterial;
    private String namaMaterial;
    private String satuan;
    private String deskripsi;
    public JenisMaterial() {}
    
    public JenisMaterial(int idMaterial, String namaMaterial, String satuan, String deskripsi) {
        this.idMaterial = idMaterial;
        this.namaMaterial = namaMaterial;
        this.satuan = satuan;
        this.deskripsi = deskripsi;
    }
    
    public int getIdMaterial() {
        return idMaterial;
    }
    
    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }
    
    public String getNamaMaterial() {
        return namaMaterial;
    }
    
    public void setNamaMaterial(String namaMaterial) {
        this.namaMaterial = namaMaterial;
    }
    
    public String getSatuan() {
        return satuan;
    }
    
    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
    
    public String getDeskripsi() {
        return deskripsi;
    }
    
    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
    
    @Override
    public String toString() {
        return namaMaterial;
    }
}