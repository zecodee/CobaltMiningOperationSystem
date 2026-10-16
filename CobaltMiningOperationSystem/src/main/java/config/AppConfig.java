/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import enums.JenisLokasi;
import enums.ShiftKerja;
import enums.StatusDriver;
import enums.StatusKendaraan;
import enums.StatusLokasi;
import enums.StatusPegawai;
import memory.KendaraanMemoryRepository;
import memory.LokasiMemoryRepository;
import memory.MaterialMemoryRepository;
import memory.MonitoringMemoryRepository;
import memory.ParameterMemoryRepository;
import memory.PegawaiMemoryRepository;
import memory.PengangkutanMemoryRepository;
import memory.ProduksiMemoryRepository;
import memory.UserMemoryRepository;
import model.Admin;
import model.Driver;
import model.JenisMaterial;
import model.Kendaraan;
import model.Lokasi;
import model.Manager;
import model.ParameterLingkungan;
import model.Pegawai;
import model.PetugasHSE;
import model.PetugasOperasional;
import model.User;
import repository.KendaraanRepository;
import repository.LokasiRepository;
import repository.MaterialRepository;
import repository.MonitoringRepository;
import repository.ParameterRepository;
import repository.PegawaiRepository;
import repository.PengangkutanRepository;
import repository.ProduksiRepository;
import repository.UserRepository;
import java.time.LocalDate;
import service.AuthService;
import service.MasterDataService;
import service.MonitoringService;
import service.PengangkutanService;
import service.ProduksiService;
import controller.AuthController;
import controller.MasterDataController;
import controller.MonitoringController;
import controller.PengangkutanController;
import controller.ProduksiController;

/**
 *
 * @author zefrialrizkullah
 */

public final class AppConfig {
    private static final PegawaiRepository pegawaiRepository =
            new PegawaiMemoryRepository();

    private static final UserRepository userRepository =
            new UserMemoryRepository();

    private static final LokasiRepository lokasiRepository =
            new LokasiMemoryRepository();

    private static final MaterialRepository materialRepository =
            new MaterialMemoryRepository();

    private static final KendaraanRepository kendaraanRepository =
            new KendaraanMemoryRepository();

    private static final ParameterRepository parameterRepository =
            new ParameterMemoryRepository();

    private static final ProduksiRepository produksiRepository =
            new ProduksiMemoryRepository();

    private static final PengangkutanRepository pengangkutanRepository =
            new PengangkutanMemoryRepository();

    private static final MonitoringRepository monitoringRepository =
            new MonitoringMemoryRepository();

    private static boolean initialized = false;

    private AppConfig() {
    }

    public static synchronized void initialize() {
        if (initialized) {
            return;
        }

        initializePegawai();
        initializeUser();
        initializeLokasi();
        initializeMaterial();
        initializeKendaraan();
        initializeParameter();
        initialized = true;
    }

    private static void initializePegawai() {
        Admin admin = new Admin(
                1,
                "Andi Pratama",
                "081234567801",
                LocalDate.of(2024, 1, 10),
                StatusPegawai.AKTIF,
                "ADM-001",
                LocalDate.of(2024, 1, 10)
        );

        PetugasOperasional petugasOperasional =
                new PetugasOperasional(
                        2,
                        "Budi Santoso",
                        "081234567802",
                        LocalDate.of(2024, 2, 15),
                        StatusPegawai.AKTIF,
                        "OPS-001",
                        "Pit A",
                        ShiftKerja.PAGI
                );

        PetugasHSE petugasHSE =
                new PetugasHSE(
                        3,
                        "Citra Lestari",
                        "081234567803",
                        LocalDate.of(2024, 3, 20),
                        StatusPegawai.AKTIF,
                        "HSE-CERT-001",
                        LocalDate.of(2028, 12, 31)
                );

        Manager manager =
                new Manager(
                        4,
                        "Dimas Saputra",
                        "081234567804",
                        LocalDate.of(2023, 8, 1),
                        StatusPegawai.AKTIF,
                        "MGR-001",
                        "Operasional Pertambangan"
                );

        Driver driver1 =
                new Driver(
                        5,
                        "Eko Ramadhan",
                        "081234567805",
                        LocalDate.of(2024, 5, 5),
                        StatusPegawai.AKTIF,
                        "SIM-B2-001",
                        LocalDate.of(2028, 6, 30),
                        StatusDriver.TERSEDIA
                );

        Driver driver2 =
                new Driver(
                        6,
                        "Fajar Nugraha",
                        "081234567806",
                        LocalDate.of(2024, 6, 12),
                        StatusPegawai.AKTIF,
                        "SIM-B2-002",
                        LocalDate.of(2028, 8, 31),
                        StatusDriver.TERSEDIA
                );

        pegawaiRepository.save(admin);
        pegawaiRepository.save(petugasOperasional);
        pegawaiRepository.save(petugasHSE);
        pegawaiRepository.save(manager);
        pegawaiRepository.save(driver1);
        pegawaiRepository.save(driver2);
    }

    private static void initializeUser() {
        Pegawai admin = getPegawaiOrThrow(1);
        Pegawai operasional = getPegawaiOrThrow(2);
        Pegawai hse = getPegawaiOrThrow(3);
        Pegawai manager = getPegawaiOrThrow(4);

        userRepository.save(
                new User(
                        1,
                        admin,
                        "admin",
                        "admin123"
                )
        );

        userRepository.save(
                new User(
                        2,
                        operasional,
                        "operasional",
                        "ops123"
                )
        );

        userRepository.save(
                new User(
                        3,
                        hse,
                        "hse",
                        "hse123"
                )
        );

        userRepository.save(
                new User(
                        4,
                        manager,
                        "manager",
                        "manager123"
                )
        );
    }

    private static void initializeLokasi() {
        lokasiRepository.save(
                new Lokasi(
                        1,
                        "Pit A",
                        JenisLokasi.PIT,
                        StatusLokasi.AKTIF,
                        "Area produksi utama"
                )
        );

        lokasiRepository.save(
                new Lokasi(
                        2,
                        "Pit B",
                        JenisLokasi.PIT,
                        StatusLokasi.AKTIF,
                        "Area produksi tambahan"
                )
        );

        lokasiRepository.save(
                new Lokasi(
                        3,
                        "Stockpile Utama",
                        JenisLokasi.STOCKPILE,
                        StatusLokasi.AKTIF,
                        "Lokasi penampungan material hasil produksi"
                )
        );
    }

    private static void initializeMaterial() {
        materialRepository.save(
                new JenisMaterial(
                        1,
                        "Cobalt Ore",
                        "Ton",
                        "Material bijih cobalt hasil kegiatan produksi"
                )
        );

        materialRepository.save(
                new JenisMaterial(
                        2,
                        "Overburden",
                        "Ton",
                        "Material lapisan penutup kegiatan pertambangan"
                )
        );
    }

    private static void initializeKendaraan() {
        kendaraanRepository.save(
                new Kendaraan(
                        1,
                        "Dump Truck",
                        "KT 8101 CM",
                        30.0,
                        2024,
                        StatusKendaraan.TERSEDIA
                )
        );

        kendaraanRepository.save(
                new Kendaraan(
                        2,
                        "Dump Truck",
                        "KT 8102 CM",
                        35.0,
                        2023,
                        StatusKendaraan.TERSEDIA
                )
        );
    }

    private static void initializeParameter() {
        parameterRepository.save(
                new ParameterLingkungan(
                        1,
                        "pH Air",
                        "pH",
                        6.0,
                        9.0,
                        "Parameter tingkat keasaman atau kebasaan air"
                )
        );

        parameterRepository.save(
                new ParameterLingkungan(
                        2,
                        "Debu",
                        "µg/m3",
                        null,
                        230.0,
                        "Parameter konsentrasi debu di area operasional"
                )
        );

        parameterRepository.save(
                new ParameterLingkungan(
                        3,
                        "Kebisingan",
                        "dB",
                        null,
                        85.0,
                        "Parameter tingkat kebisingan area operasional"
                )
        );

        parameterRepository.save(
                new ParameterLingkungan(
                        4,
                        "TSS",
                        "mg/L",
                        null,
                        50.0,
                        "Parameter Total Suspended Solids"
                )
        );
    }

    private static Pegawai getPegawaiOrThrow(int idPegawai) {
        if (!pegawaiRepository.findById(idPegawai).isPresent()) {
            throw new IllegalStateException(
                    "Dummy Pegawai dengan ID "
                            + idPegawai
                            + " tidak ditemukan."
            );
        }

        return pegawaiRepository.findById(idPegawai).get();
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
    
    private static final AuthService authService = new AuthService(userRepository);
    private static final MasterDataService masterDataService = new MasterDataService(pegawaiRepository, userRepository, lokasiRepository, materialRepository, kendaraanRepository, parameterRepository);
    private static final ProduksiService produksiService = new ProduksiService(produksiRepository, materialRepository, lokasiRepository);
    private static final PengangkutanService pengangkutanService = new PengangkutanService(pengangkutanRepository, produksiRepository, kendaraanRepository, lokasiRepository);
    private static final MonitoringService monitoringService = new MonitoringService( monitoringRepository, lokasiRepository, parameterRepository);
    
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
    
    private static final AuthController authController = new AuthController(authService);
    private static final MasterDataController masterDataController = new MasterDataController(masterDataService);

    private static final ProduksiController produksiController =
            new ProduksiController(
                    produksiService,
                    authService
            );

    private static final PengangkutanController pengangkutanController =
            new PengangkutanController(
                    pengangkutanService,
                    authService,
                    pegawaiRepository
            );

    private static final MonitoringController monitoringController =
            new MonitoringController(
                    monitoringService,
                    authService
            );
    
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

    public static MonitoringController getMonitoringController() {
        return monitoringController;
    }
}