/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.*;
import service.AuthService;

/**
 *
 * @author zefrialrizkullah
 */

public final class AuthController {
    private final AuthService auth;
    
    public AuthController(AuthService auth) {
        this.auth = auth;
    }
    
    public User login(String u, String p) {
        return auth.login(u, p);
    }
    
    public void logout() {
        auth.logout();
    }
    
    public boolean isLoggedIn() {
        return auth.isLoggedIn();
    }
    
    public User getCurrentUser() {
        return auth.getCurrentUser();
    }
    
    public Pegawai getCurrentPegawai() {
        return auth.getCurrentPegawai();
    }
    
    public boolean isAdmin() {
        return auth.isAdmin();
    }
    
    public boolean isPetugasOperasional() {
        return auth.isPetugasOperasional();
    }
    
    public boolean isPetugasHSE() {
        return auth.isPetugasHSE();
    }
    
    public boolean isManager() {
        return auth.isManager();
    }
}