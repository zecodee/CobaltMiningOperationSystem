/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.*;
import model.*;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class ProduksiController {
    private final ProduksiService service;
    private final AuthService auth;
    
    public ProduksiController(ProduksiService service, AuthService a) {
        this.service = service;
        auth = a;
    }
    
    public ProduksiTambang tambahProduksi(int material, int lokasi, LocalDate tanggal, double jumlah) {
        auth.requirePetugasOperasional();
        return service.tambahProduksi(material, lokasi, (PetugasOperasional)auth.getCurrentPegawai(), tanggal,
                jumlah);
    }
    
    public void ubahProduksi(int id, int material, int lokasi, LocalDate tanggal, double jumlah) {
        auth.requirePetugasOperasional();
        service.ubahProduksi(id, material, lokasi, tanggal, jumlah);
    }
    
    public void hapusProduksi(int id) {
        auth.requirePetugasOperasional();
        service.hapusProduksi(id);
    }
    
    public ProduksiTambang cariProduksiById(int id) {
        auth.requirePetugasOperasional();
        return service.cariProduksiById(id);
    }
    
    public List<ProduksiTambang> tampilkanSemuaProduksi() {
        auth.requirePetugasOperasional();
        return service.tampilkanSemuaProduksi();
    }
    
    public List<ProduksiTambang> tampilkanProduksiTersedia() {
        auth.requirePetugasOperasional();
        return service.tampilkanProduksiTersedia();
    }
}
