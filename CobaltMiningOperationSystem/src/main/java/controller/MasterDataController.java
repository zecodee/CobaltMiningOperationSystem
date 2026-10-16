/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.JenisMaterial;
import model.Kendaraan;
import model.Lokasi;
import model.ParameterLingkungan;
import model.Pegawai;
import model.User;
import service.MasterDataService;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public class MasterDataController {
    private final MasterDataService masterDataService;

    public MasterDataController(MasterDataService masterDataService) {
        this.masterDataService = masterDataService;
    }

    // PEGAWAI

    public void tambahPegawai(Pegawai pegawai) {
        masterDataService.tambahPegawai(pegawai);
    }

    public void ubahPegawai(Pegawai pegawai) {
        masterDataService.ubahPegawai(pegawai);
    }

    public void hapusPegawai(int idPegawai) {
        masterDataService.hapusPegawai(idPegawai);
    }

    public Pegawai cariPegawaiById(int idPegawai) {
        return masterDataService
                .cariPegawaiById(idPegawai);
    }

    public List<Pegawai> tampilkanSemuaPegawai() {
        return masterDataService
                .tampilkanSemuaPegawai();
    }

    public List<Pegawai> cariPegawaiByNama(String nama) {
        return masterDataService.cariPegawaiByNama(nama);
    }

    // USER

    public void tambahUser(User user) {
        masterDataService.tambahUser(user);
    }

    public void ubahUser(User user) {
        masterDataService.ubahUser(user);
    }

    public void hapusUser(int idUser) {
        masterDataService.hapusUser(idUser);
    }

    public User cariUserById(int idUser) {
        return masterDataService
                .cariUserById(idUser);
    }

    public List<User> tampilkanSemuaUser() {
        return masterDataService
                .tampilkanSemuaUser();
    }

    // LOKASI

    public void tambahLokasi(Lokasi lokasi) {
        masterDataService.tambahLokasi(lokasi);
    }

    public void ubahLokasi(Lokasi lokasi) {
        masterDataService.ubahLokasi(lokasi);
    }

    public void hapusLokasi(int idLokasi) {
        masterDataService.hapusLokasi(idLokasi);
    }

    public Lokasi cariLokasiById(int idLokasi) {
        return masterDataService
                .cariLokasiById(idLokasi);
    }

    public List<Lokasi> tampilkanSemuaLokasi() {
        return masterDataService
                .tampilkanSemuaLokasi();
    }

    public List<Lokasi> cariLokasiByNama(String nama) {

        return masterDataService.cariLokasiByNama(nama);
    }

    // MATERIAL

    public void tambahMaterial(JenisMaterial material) {
        masterDataService.tambahMaterial(material);
    }

    public void ubahMaterial(JenisMaterial material) {
        masterDataService.ubahMaterial(material);
    }

    public void hapusMaterial(int idMaterial) {
        masterDataService.hapusMaterial(idMaterial);
    }

    public JenisMaterial cariMaterialById(int idMaterial) {
        return masterDataService.cariMaterialById(idMaterial);
    }

    public List<JenisMaterial> tampilkanSemuaMaterial() {
        return masterDataService.tampilkanSemuaMaterial();
    }

    public List<JenisMaterial> cariMaterialByNama(String nama) {
        return masterDataService.cariMaterialByNama(nama);
    }

    // KENDARAAN

    public void tambahKendaraan(Kendaraan kendaraan) {
        masterDataService.tambahKendaraan(kendaraan);
    }

    public void ubahKendaraan(Kendaraan kendaraan) {
        masterDataService.ubahKendaraan(kendaraan);
    }

    public void hapusKendaraan(int idKendaraan) {
        masterDataService.hapusKendaraan(idKendaraan);
    }

    public Kendaraan cariKendaraanById(int idKendaraan) {
        return masterDataService.cariKendaraanById(idKendaraan);
    }

    public List<Kendaraan> tampilkanSemuaKendaraan() {
        return masterDataService.tampilkanSemuaKendaraan();
    }

    // PARAMETER

    public void tambahParameter(ParameterLingkungan parameter) {
        masterDataService.tambahParameter(parameter);
    }

    public void ubahParameter(ParameterLingkungan parameter) {
        masterDataService.ubahParameter(parameter);
    }

    public void hapusParameter(int idParameter) {
        masterDataService.hapusParameter(idParameter);
    }

    public ParameterLingkungan cariParameterById(int idParameter) {
        return masterDataService.cariParameterById(idParameter);
    }

    public List<ParameterLingkungan> tampilkanSemuaParameter() {
        return masterDataService.tampilkanSemuaParameter();
    }

    public List<ParameterLingkungan> cariParameterByNama(String nama) {
        return masterDataService.cariParameterByNama(nama);
    }
    
    public List<Kendaraan> tampilkanKendaraanTersedia() {
        return masterDataService.tampilkanKendaraanTersedia();
    }
    
    public List<Lokasi> tampilkanLokasiPitAktif() {
        return masterDataService.tampilkanLokasiPitAktif();
    }

    public List<Lokasi> tampilkanLokasiAktif() {
        return masterDataService.tampilkanLokasiAktif();
    }
}