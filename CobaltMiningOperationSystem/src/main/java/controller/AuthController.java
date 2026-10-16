/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.Pegawai;
import model.User;
import service.AuthService;

/**
 *
 * @author zefrialrizkullah
 */

public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {
        return authService.login(username, password);
    }

    public void logout() {
        authService.logout();
    }

    public boolean isLoggedIn() {
        return authService.isLoggedIn();
    }

    public User getCurrentUser() {
        return authService.getCurrentUser();
    }

    public Pegawai getCurrentPegawai() {
        return authService.getCurrentPegawai();
    }

    public boolean isAdmin() {
        return authService.isAdmin();
    }

    public boolean isPetugasOperasional() {
        return authService.isPetugasOperasional();
    }

    public boolean isPetugasHSE() {
        return authService.isPetugasHSE();
    }

    public boolean isManager() {
        return authService.isManager();
    }
}
