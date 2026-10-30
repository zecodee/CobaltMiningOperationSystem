/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author zefrialrizkullah
 */

public class User {
    private int idUser;
    private Pegawai pegawai;
    private String username;
    private String password;
    
    public User(int idUser, Pegawai pegawai, String username, String password) {
        this.idUser = idUser;
        this.pegawai = pegawai;
        this.username = username;
        this.password = password;
    }
    
    public int getIdUser() {
        return idUser;
    }
    
    public void setIdUser(int value) {
        this.idUser = value;
    }
    
    public Pegawai getPegawai() {
        return pegawai;
    }
    
    public void setPegawai(Pegawai value) {
        this.pegawai = value;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String value) {
        this.username = value;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String value) {
        this.password = value;
    }
    
    @Override
    public String toString() {
        return "User #" + idUser;
    }
}
