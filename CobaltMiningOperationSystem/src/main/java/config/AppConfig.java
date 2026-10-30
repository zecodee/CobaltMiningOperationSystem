/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import controller.*;
import dao.*;
import repository.*;
import service.*;

/**
 *
 * @author zefrialrizkullah
 */

public final class AppConfig {
    private AppConfig() {}

    private static boolean initialized;

    private static PegawaiRepository pegawaiRepository;

    private static UserRepository userRepository;

    private static LokasiRepository lokasiRepository;

    private static MaterialRepository materialRepository;

    private static KendaraanRepository kendaraanRepository;

    private static ParameterRepository parameterRepository;

    private static ProduksiRepository produksiRepository;

    private static PengangkutanRepository pengangkutanRepository;

    private static MonitoringRepository monitoringRepository;

    private static AuthService authService;

    private static MasterDataService masterDataService;

    private static ProduksiService produksiService;

    private static PengangkutanService pengangkutanService;

    private static MonitoringService monitoringService;

    private static LaporanService laporanService;

    private static LaporanController laporanController;

    private static AuthController authController;

    private static MasterDataController masterDataController;

    private static ProduksiController produksiController;

    private static PengangkutanController pengangkutanController;

    private static MonitoringController monitoringController;

    public static synchronized void initialize() {
        if (initialized) return;
        
        if (!DatabaseConfig.testConnection())throw new IllegalStateException("Tidak dapat terhubung ke database cmos_db. Periksa konfigurasi JDBC.");
        
        pegawaiRepository = new PegawaiDAO();
        userRepository = new UserDAO();
        lokasiRepository = new LokasiDAO();
        materialRepository = new MaterialDAO();
        kendaraanRepository = new KendaraanDAO();
        parameterRepository = new ParameterDAO();
        produksiRepository = new ProduksiDAO();
        pengangkutanRepository = new PengangkutanDAO();
        monitoringRepository = new MonitoringDAO();
        authService = new AuthService(userRepository);
        masterDataService = new MasterDataService(pegawaiRepository, userRepository, lokasiRepository, materialRepository, kendaraanRepository, parameterRepository);
        produksiService = new ProduksiService(produksiRepository, materialRepository, lokasiRepository, pengangkutanRepository);
        pengangkutanService = new PengangkutanService(pengangkutanRepository, produksiRepository, kendaraanRepository, lokasiRepository);
        monitoringService = new MonitoringService(monitoringRepository, lokasiRepository, parameterRepository);
        authController = new AuthController(authService);
        masterDataController = new MasterDataController(masterDataService, authService);
        produksiController = new ProduksiController(produksiService, authService);
        pengangkutanController = new PengangkutanController(pengangkutanService, authService, pegawaiRepository);
        monitoringController = new MonitoringController(monitoringService, authService);
        laporanService = new LaporanService(produksiRepository, pengangkutanRepository, monitoringRepository);
        laporanController = new LaporanController(laporanService, authService);
        initialized = true;
    }
    
    public static PegawaiRepository getPegawaiRepository() {
        return pegawaiRepository;
    }
    
    public static UserRepository getUserRepository() {
        return userRepository;
    }
    
    public static LokasiRepository getLokasiRepository() {
        return lokasiRepository;
    }
    
    public static MaterialRepository getMaterialRepository() {
        return materialRepository;
    }
    
    public static KendaraanRepository getKendaraanRepository() {
        return kendaraanRepository;
    }
    
    public static ParameterRepository getParameterRepository() {
        return parameterRepository;
    }
    
    public static ProduksiRepository getProduksiRepository() {
        return produksiRepository;
    }
    
    public static PengangkutanRepository getPengangkutanRepository() {
        return pengangkutanRepository;
    }
    
    public static MonitoringRepository getMonitoringRepository() {
        return monitoringRepository;
    }
    
    public static AuthService getAuthService() {
        return authService;
    }
    
    public static MasterDataService getMasterDataService() {
        return masterDataService;
    }
    
    public static ProduksiService getProduksiService() {
        return produksiService;
    }
    
    public static PengangkutanService getPengangkutanService() {
        return pengangkutanService;
    }
    
    public static MonitoringService getMonitoringService() {
        return monitoringService;
    }
    
    public static AuthController getAuthController() {
        return authController;
    }
    
    public static MasterDataController getMasterDataController() {
        return masterDataController;
    }
    
    public static ProduksiController getProduksiController() {
        return produksiController;
    }
    
    public static PengangkutanController getPengangkutanController() {
        return pengangkutanController;
    }
    
    public static LaporanService getLaporanService() {
        return laporanService;
    }
    
    public static LaporanController getLaporanController() {
        return laporanController;
    }
    
    public static MonitoringController getMonitoringController() {
        return monitoringController;
    }
}
