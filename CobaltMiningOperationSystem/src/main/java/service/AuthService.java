/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import enums.StatusPegawai;
import exception.ValidationException;
import model.Admin;
import model.Driver;
import model.Manager;
import model.Pegawai;
import model.PetugasHSE;
import model.PetugasOperasional;
import model.User;
import repository.UserRepository;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class AuthService {
    private final UserRepository userRepository;
    private User currentUser;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(String username, String password) {
        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException(
                    "Username wajib diisi."
            );
        }

        if (password == null || password.trim().isEmpty()) {
            throw new ValidationException(
                    "Password wajib diisi."
            );
        }

        Optional<User> data =
                userRepository.findByUsername(
                        username.trim()
                );

        if (!data.isPresent()) {
            throw new ValidationException(
                    "Username atau password salah."
            );
        }

        User user = data.get();

        if (!user.getPassword().equals(password)) {
            throw new ValidationException(
                    "Username atau password salah."
            );
        }

        if (user.getPegawai() == null) {
            throw new ValidationException(
                    "Akun tidak terhubung dengan data Pegawai."
            );
        }

        if (user.getPegawai().getStatusPegawai()
                != StatusPegawai.AKTIF) {

            throw new ValidationException(
                    "Pegawai pemilik akun sudah tidak aktif."
            );
        }

        if (user.getPegawai() instanceof Driver) {
            throw new ValidationException(
                    "Driver tidak memiliki akses login ke C-MOS."
            );
        }

        if (!(user.getPegawai() instanceof Admin)
                && !(user.getPegawai()
                instanceof PetugasOperasional)
                && !(user.getPegawai()
                instanceof PetugasHSE)
                && !(user.getPegawai()
                instanceof Manager)) {

            throw new ValidationException(
                    "Jenis Pegawai tidak memiliki hak akses aplikasi."
            );
        }

        currentUser = user;

        return user;
    }

    public void logout() {
        currentUser = null;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public User getCurrentUser() {
        if (currentUser == null) {
            throw new ValidationException(
                    "Belum ada User yang login."
            );
        }

        return currentUser;
    }

    public Pegawai getCurrentPegawai() {
        return getCurrentUser().getPegawai();
    }

    public boolean isAdmin() {
        return isLoggedIn()
                && currentUser.getPegawai()
                instanceof Admin;
    }

    public boolean isPetugasOperasional() {
        return isLoggedIn()
                && currentUser.getPegawai()
                instanceof PetugasOperasional;
    }

    public boolean isPetugasHSE() {
        return isLoggedIn()
                && currentUser.getPegawai()
                instanceof PetugasHSE;
    }

    public boolean isManager() {
        return isLoggedIn()
                && currentUser.getPegawai()
                instanceof Manager;
    }
}