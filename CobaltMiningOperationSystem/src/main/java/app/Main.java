/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app;

import config.AppConfig;
import enums.StatusDriver;
import enums.StatusOperator;
import enums.StatusPegawai;
import java.time.LocalDate;
import model.Driver;
import model.Kendaraan;
import model.Lokasi;
import model.Operator;

/**
 *
 * @author zefrialrizkullah
 */


public class Main {
    public static void main(String[] args) {
        AppConfig.initialize();
        System.out.println("==========================================");
        System.out.println("        TEST DATA ARRAYLIST C-MOS");
        System.out.println("==========================================");
        System.out.println("\n--- DRIVER ---");
        for (Driver driver : AppConfig.getPegawaiRepository().findAllDriver()) {
            System.out.println("ID      : " + driver.getIdPegawai());
            System.out.println("Nama    : " + driver.getNamaPegawai());
            System.out.println("SIM     : " + driver.getNoSim());
            System.out.println("Status  : " + driver.getStatusDriver());
        }
        System.out.println("\n--- OPERATOR ---");
        for (Operator operator : AppConfig.getPegawaiRepository().findAllOperator()) {
            System.out.println("ID          : " + operator.getIdPegawai());
            System.out.println("Nama        : " + operator.getNamaPegawai());
            System.out.println("Sertifikasi : " + operator.getNoSertifikasi());
            System.out.println("Status      : " + operator.getStatusOperator());
        }
        System.out.println("\n--- LOKASI ---");
        for (Lokasi lokasi : AppConfig.getLokasiRepository().findAll()) {
            System.out.println(lokasi.getIdLokasi() + " | " + lokasi.getNamaLokasi() + " | " + lokasi.getJenisLokasi() + " | " + lokasi.getStatusOperasional());
        }
        System.out.println("\n--- KENDARAAN ---");
        for (Kendaraan kendaraan : AppConfig.getKendaraanRepository().findAll()) {
            System.out.println(kendaraan.getIdKendaraan() + " | " + kendaraan.getNomorPolisi() + " | " + kendaraan.getKapasitas() + " Ton | " + kendaraan.getStatusKendaraan());
        }
        System.out.println("\n==========================================");
        System.out.println("Repository ArrayList berhasil dijalankan.");
        System.out.println("==========================================");
    }
}
