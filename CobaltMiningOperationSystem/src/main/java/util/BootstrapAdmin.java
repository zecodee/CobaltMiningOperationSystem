/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import config.DatabaseConfig;
import dao.PegawaiDAO;
import dao.UserDAO;
import enums.StatusPegawai;
import java.io.Console;
import java.time.LocalDate;
import model.Admin;
import model.User;

/**
 *
 * @author zefrialrizkullah
 */

public final class BootstrapAdmin {
    private BootstrapAdmin() {
    }
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("Jalankan dari terminal interaktif (console diperlukan).");
            return;
        }
        if (!DatabaseConfig.testConnection()) throw new IllegalStateException("Database tidak terhubung.");
        UserDAO users = new UserDAO();
        if (!users.findAll().isEmpty()) {
            throw new IllegalStateException("Bootstrap hanya diperbolehkan jika belum ada akun user.");
        }
        String nama = console.readLine("Nama Admin: ").trim();
        String hp = console.readLine("No HP: ").trim();
        String kode = console.readLine("Kode Admin: ").trim();
        String username = console.readLine("Username: ").trim();
        char[] secret = console.readPassword("Password (min 8 karakter): ");
        String password = new String(secret);
        java.util.Arrays.fill(secret, '\0');
        if (nama.isEmpty() || hp.isEmpty() || kode.isEmpty()
 || username.isEmpty())             throw new IllegalArgumentException("Semua data wajib diisi.");
        if (users.findByUsername(username).isPresent()) throw new IllegalArgumentException("Username sudah ada.");
        Admin admin = new Admin(0, nama, hp, LocalDate.now(), StatusPegawai.AKTIF, kode, LocalDate.now());
        new PegawaiDAO().save(admin);
        users.save(new User(0, admin, username, PasswordUtil.hashPassword(password)));
        System.out.println("Akun admin berhasil dibuat. ID Pegawai: " + admin.getIdPegawai());
    }
}
