/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.*;
import model.*;
import java.util.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class MasterDataController {
    private final MasterDataService data;
    private final AuthService auth;
    public MasterDataController(MasterDataService data, AuthService a) {
        this.data = data;
        auth = a;
    }
    
    private void guard() {
        auth.requireAdmin();
    }
    
    public void tambahPegawai(Pegawai x) {
        guard();
        data.tambahPegawai(x);
    }
    
    public void ubahPegawai(Pegawai x) {
        guard();
        data.ubahPegawai(x);
    }
    
    public void hapusPegawai(int id) {
        guard();
        data.hapusPegawai(id);
    }
    
    public Pegawai cariPegawaiById(int id) {
        guard();
        return data.cariPegawaiById(id);
    }
    
    public List<Pegawai> tampilkanSemuaPegawai() {
        guard();
        return data.tampilkanSemuaPegawai();
    }
    
    public List<Pegawai> cariPegawaiByNama(String n) {
        guard();
        return data.cariPegawaiByNama(n);
    }
    
    public void tambahUser(User x) {
        guard();
        data.tambahUser(x);
    }
    
    public void ubahUser(User x) {
        guard();
        data.ubahUser(x);
    }
    
    public void hapusUser(int id) {
        guard();
        data.hapusUser(id);
    }
    
    public User cariUserById(int id) {
        guard();
        return data.cariUserById(id);
    }
    
    public Optional<User> cariUserByPegawai(int id) {
        guard();
        return data.cariUserByPegawai(id);
    }
    
    public List<User> tampilkanSemuaUser() {
        guard();
        return data.tampilkanSemuaUser();
    }
    
    public void tambahLokasi(Lokasi x) {
        guard();
        data.tambahLokasi(x);
    }
    
    public void ubahLokasi(Lokasi x) {
        guard();
        data.ubahLokasi(x);
    }
    
    public void hapusLokasi(int id) {
        guard();
        data.hapusLokasi(id);
    }
    
    public Lokasi cariLokasiById(int id) {
        guard();
        return data.cariLokasiById(id);
    }
    
    public List<Lokasi> tampilkanSemuaLokasi() {
        guard();
        return data.tampilkanSemuaLokasi();
    }
    
    public List<Lokasi> cariLokasiByNama(String n) {
        guard();
        return data.cariLokasiByNama(n);
    }
    
    public void tambahMaterial(JenisMaterial x) {
        guard();
        data.tambahMaterial(x);
    }
    
    public void ubahMaterial(JenisMaterial x) {
        guard();
        data.ubahMaterial(x);
    }
    
    public void hapusMaterial(int id) {
        guard();
        data.hapusMaterial(id);
    }
    
    public JenisMaterial cariMaterialById(int id) {
        guard();
        return data.cariMaterialById(id);
    }
    
    public List<JenisMaterial> tampilkanSemuaMaterial() {
        guard();
        return data.tampilkanSemuaMaterial();
    }
    
    public List<JenisMaterial> cariMaterialByNama(String n) {
        guard();
        return data.cariMaterialByNama(n);
    }
    
    public void tambahKendaraan(Kendaraan x) {
        guard();
        data.tambahKendaraan(x);
    }
    
    public void ubahKendaraan(Kendaraan x) {
        guard();
        data.ubahKendaraan(x);
    }
    
    public void hapusKendaraan(int id) {
        guard();
        data.hapusKendaraan(id);
    }
    
    public Kendaraan cariKendaraanById(int id) {
        guard();
        return data.cariKendaraanById(id);
    }
    
    public List<Kendaraan> tampilkanSemuaKendaraan() {
        guard();
        return data.tampilkanSemuaKendaraan();
    }
    
    public void tambahParameter(ParameterLingkungan x) {
        guard();
        data.tambahParameter(x);
    }
    
    public void ubahParameter(ParameterLingkungan x) {
        guard();
        data.ubahParameter(x);
    }
    
    public void hapusParameter(int id) {
        guard();
        data.hapusParameter(id);
    }
    
    public ParameterLingkungan cariParameterById(int id) {
        guard();
        return data.cariParameterById(id);
    }
    
    public List<ParameterLingkungan> tampilkanSemuaParameter() {
        guard();
        return data.tampilkanSemuaParameter();
    }
    
    public List<ParameterLingkungan> cariParameterByNama(String n) {
        guard();
        return data.cariParameterByNama(n);
    }
    
    public List<Kendaraan> tampilkanKendaraanTersedia() {
        if (!auth.isAdmin() && !auth.isPetugasOperasional())throw new exception.ValidationException("Akses ditolak.");
        return data.tampilkanKendaraanTersedia();
    }
    
    public List<Lokasi> tampilkanLokasiPitAktif() {
        if (!auth.isAdmin() && !auth.isPetugasOperasional())throw new exception.ValidationException("Akses ditolak.");
        return data.tampilkanLokasiPitAktif();
    }
    
    public List<Lokasi> tampilkanLokasiAktif() {
        if (!auth.isAdmin() && !auth.isPetugasOperasional() && !auth.isPetugasHSE())throw new exception.ValidationException("Akses ditolak.");
        return data.tampilkanLokasiAktif();
    }
}
