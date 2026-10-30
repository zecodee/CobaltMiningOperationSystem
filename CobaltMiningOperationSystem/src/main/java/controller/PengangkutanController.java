/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.*;
import model.*;
import repository.PegawaiRepository;
import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class PengangkutanController {
    private final PengangkutanService service;
    private final AuthService auth;
    private final PegawaiRepository pegawai;
    
    public PengangkutanController(PengangkutanService service, AuthService a, PegawaiRepository p) {
        this.service = service;
        auth = a;
        pegawai = p;
    }
    
    public Pengangkutan buatPengangkutan(int produksi, int kendaraan, int driver, int asal, int tujuan,
            LocalDate tanggal, double jumlah) {
        auth.requirePetugasOperasional();
        Pegawai p = pegawai.findById(driver).orElseThrow(()->new exception.DataNotFoundException("Driver tidak ditemukan."));
        if (!(p instanceof Driver))throw new exception.ValidationException("Pegawai bukan driver.");
        return service.buatPengangkutan(produksi, (PetugasOperasional)auth.getCurrentPegawai(), kendaraan,
                (Driver)p, asal, tujuan, tanggal, jumlah);
    }
    
    public void mulaiPengangkutan(int id) {
        auth.requirePetugasOperasional();
        service.mulaiPengangkutan(id);
    }
    
    public void selesaikanPengangkutan(int id) {
        auth.requirePetugasOperasional();
        service.selesaikanPengangkutan(id);
    }
    
    public void batalkanPengangkutan(int id) {
        auth.requirePetugasOperasional();
        service.batalkanPengangkutan(id);
    }
   
    public Pengangkutan cariPengangkutanById(int id) {
        auth.requirePetugasOperasional();
        return service.cariPengangkutanById(id);
    }
    
    public List<Pengangkutan> tampilkanSemuaPengangkutan() {
        auth.requirePetugasOperasional();
        return service.tampilkanSemuaPengangkutan();
    }
}
