/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.JenisLokasi;
import enums.StatusKendaraan;
import enums.StatusLokasi;
import enums.StatusPegawai;
import exception.DataNotFoundException;
import exception.ValidationException;
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
import repository.ParameterRepository;
import repository.PegawaiRepository;
import repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

/**
 *
 * @author zefrialrizkullah
 */

public class MasterDataService {
    private final PegawaiRepository pegawaiRepository;
    private final UserRepository userRepository;
    private final LokasiRepository lokasiRepository;
    private final MaterialRepository materialRepository;
    private final KendaraanRepository kendaraanRepository;
    private final ParameterRepository parameterRepository;

    public MasterDataService(
            PegawaiRepository pegawaiRepository,
            UserRepository userRepository,
            LokasiRepository lokasiRepository,
            MaterialRepository materialRepository,
            KendaraanRepository kendaraanRepository,
            ParameterRepository parameterRepository) {

        this.pegawaiRepository = pegawaiRepository;
        this.userRepository = userRepository;
        this.lokasiRepository = lokasiRepository;
        this.materialRepository = materialRepository;
        this.kendaraanRepository = kendaraanRepository;
        this.parameterRepository = parameterRepository;
    }

    // PEGAWAI

    public void tambahPegawai(Pegawai pegawai) {
        validasiPegawai(pegawai);
        if (pegawaiRepository.findById(pegawai.getIdPegawai()).isPresent()) {
            throw new ValidationException("ID Pegawai sudah digunakan.");
        }
        validasiDataKhususPegawai(pegawai);
        validasiKeunikanDataKhusus(pegawai);
        pegawaiRepository.save(pegawai);
    }

    public void ubahPegawai(Pegawai pegawai) {
        validasiPegawai(pegawai);
        getPegawaiOrThrow(pegawai.getIdPegawai());

        Pegawai lama = getPegawaiOrThrow(pegawai.getIdPegawai());

        if (!lama.getClass().equals(pegawai.getClass())) {
            throw new ValidationException(
                    "Jenis Pegawai tidak dapat diubah melalui proses edit."
            );
        }

        validasiDataKhususPegawai(pegawai);
        validasiKeunikanDataKhusus(pegawai);
        pegawaiRepository.update(pegawai);
    }

    public void hapusPegawai(int idPegawai) {
        getPegawaiOrThrow(idPegawai);

        Optional<User> user = cariUserByPegawai(idPegawai);

        if (user.isPresent()) {
            throw new ValidationException(
                    "Pegawai tidak dapat dihapus karena masih memiliki akun User."
            );
        }

        pegawaiRepository.delete(idPegawai);
    }

    public Pegawai cariPegawaiById(int idPegawai) {
        return getPegawaiOrThrow(idPegawai);
    }

    public List<Pegawai> tampilkanSemuaPegawai() {
        return pegawaiRepository.findAll();
    }

    public List<Pegawai> cariPegawaiByNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            return pegawaiRepository.findAll();
        }
        return pegawaiRepository.findByNama(nama.trim());
    }

    // USER

    public void tambahUser(User user) {
        validasiUser(user);

        if (userRepository.findById(user.getIdUser()).isPresent()) {
            throw new ValidationException("ID User sudah digunakan.");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new ValidationException("Username sudah digunakan.");
        }

        if (cariUserByPegawai(user.getPegawai().getIdPegawai()).isPresent()) {
            throw new ValidationException(
                    "Pegawai tersebut sudah memiliki akun User."
            );
        }

        userRepository.save(user);
    }

    public void ubahUser(User user) {
        validasiUser(user);
        getUserOrThrow(user.getIdUser());

        Optional<User> usernameSama =
                userRepository.findByUsername(user.getUsername());

        if (usernameSama.isPresent()
                && usernameSama.get().getIdUser() != user.getIdUser()) {
            throw new ValidationException("Username sudah digunakan.");
        }

        Optional<User> akunPegawai =
                cariUserByPegawai(user.getPegawai().getIdPegawai());

        if (akunPegawai.isPresent()
                && akunPegawai.get().getIdUser() != user.getIdUser()) {
            throw new ValidationException(
                    "Pegawai tersebut sudah memiliki akun User."
            );
        }

        userRepository.update(user);
    }

    public void hapusUser(int idUser) {
        getUserOrThrow(idUser);
        userRepository.delete(idUser);
    }

    public User cariUserById(int idUser) {
        return getUserOrThrow(idUser);
    }

    public Optional<User> cariUserByPegawai(int idPegawai) {
        for (User user : userRepository.findAll()) {
            if (user.getPegawai() != null
                    && user.getPegawai().getIdPegawai() == idPegawai) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public List<User> tampilkanSemuaUser() {
        return userRepository.findAll();
    }

    // LOKASI

    public void tambahLokasi(Lokasi lokasi) {
        validasiLokasi(lokasi);

        if (lokasiRepository.findById(lokasi.getIdLokasi()).isPresent()) {
            throw new ValidationException("ID Lokasi sudah digunakan.");
        }

        validasiNamaLokasiUnik(lokasi);

        lokasiRepository.save(lokasi);
    }

    public void ubahLokasi(Lokasi lokasi) {
        validasiLokasi(lokasi);
        getLokasiOrThrow(lokasi.getIdLokasi());
        validasiNamaLokasiUnik(lokasi);
        lokasiRepository.update(lokasi);
    }

    public void hapusLokasi(int idLokasi) {
        getLokasiOrThrow(idLokasi);
        lokasiRepository.delete(idLokasi);
    }

    public Lokasi cariLokasiById(int idLokasi) {
        return getLokasiOrThrow(idLokasi);
    }

    public List<Lokasi> tampilkanSemuaLokasi() {
        return lokasiRepository.findAll();
    }

    public List<Lokasi> cariLokasiByNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            return lokasiRepository.findAll();
        }
        return lokasiRepository.findByNama(nama.trim());
    }

    // JENIS MATERIAL

    public void tambahMaterial(JenisMaterial material) {
        validasiMaterial(material);

        if (materialRepository.findById(material.getIdMaterial()).isPresent()) {
            throw new ValidationException("ID Material sudah digunakan.");
        }

        validasiNamaMaterialUnik(material);

        materialRepository.save(material);
    }

    public void ubahMaterial(JenisMaterial material) {
        validasiMaterial(material);
        getMaterialOrThrow(material.getIdMaterial());
        validasiNamaMaterialUnik(material);
        materialRepository.update(material);
    }

    public void hapusMaterial(int idMaterial) {
        getMaterialOrThrow(idMaterial);
        materialRepository.delete(idMaterial);
    }

    public JenisMaterial cariMaterialById(int idMaterial) {
        return getMaterialOrThrow(idMaterial);
    }

    public List<JenisMaterial> tampilkanSemuaMaterial() {
        return materialRepository.findAll();
    }

    public List<JenisMaterial> cariMaterialByNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            return materialRepository.findAll();
        }
        return materialRepository.findByNama(nama.trim());
    }

    // KENDARAAN

    public void tambahKendaraan(Kendaraan kendaraan) {
        validasiKendaraan(kendaraan);

        if (kendaraanRepository.findById(kendaraan.getIdKendaraan()).isPresent()) {
            throw new ValidationException("ID Kendaraan sudah digunakan.");
        }

        if (kendaraanRepository
                .findByNomorPolisi(kendaraan.getNomorPolisi())
                .isPresent()) {
            throw new ValidationException("Nomor polisi sudah digunakan.");
        }

        kendaraanRepository.save(kendaraan);
    }

    public void ubahKendaraan(Kendaraan kendaraan) {
        validasiKendaraan(kendaraan);
        getKendaraanOrThrow(kendaraan.getIdKendaraan());

        Optional<Kendaraan> nomorSama =
                kendaraanRepository.findByNomorPolisi(
                        kendaraan.getNomorPolisi()
                );

        if (nomorSama.isPresent()
                && nomorSama.get().getIdKendaraan()
                != kendaraan.getIdKendaraan()) {
            throw new ValidationException("Nomor polisi sudah digunakan.");
        }

        kendaraanRepository.update(kendaraan);
    }

    public void hapusKendaraan(int idKendaraan) {
        Kendaraan kendaraan = getKendaraanOrThrow(idKendaraan);

        if (kendaraan.getStatusKendaraan()
                == StatusKendaraan.DIGUNAKAN) {
            throw new ValidationException(
                    "Kendaraan yang sedang digunakan tidak dapat dihapus."
            );
        }

        kendaraanRepository.delete(idKendaraan);
    }

    public Kendaraan cariKendaraanById(int idKendaraan) {
        return getKendaraanOrThrow(idKendaraan);
    }

    public List<Kendaraan> tampilkanSemuaKendaraan() {
        return kendaraanRepository.findAll();
    }

    // PARAMETER LINGKUNGAN

    public void tambahParameter(ParameterLingkungan parameter) {
        validasiParameter(parameter);

        if (parameterRepository
                .findById(parameter.getIdParameter())
                .isPresent()) {
            throw new ValidationException(
                    "ID Parameter sudah digunakan."
            );
        }

        validasiNamaParameterUnik(parameter);

        parameterRepository.save(parameter);
    }

    public void ubahParameter(ParameterLingkungan parameter) {
        validasiParameter(parameter);
        getParameterOrThrow(parameter.getIdParameter());
        validasiNamaParameterUnik(parameter);
        parameterRepository.update(parameter);
    }

    public void hapusParameter(int idParameter) {
        getParameterOrThrow(idParameter);
        parameterRepository.delete(idParameter);
    }

    public ParameterLingkungan cariParameterById(int idParameter) {
        return getParameterOrThrow(idParameter);
    }

    public List<ParameterLingkungan> tampilkanSemuaParameter() {
        return parameterRepository.findAll();
    }

    public List<ParameterLingkungan> cariParameterByNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            return parameterRepository.findAll();
        }
        return parameterRepository.findByNama(nama.trim());
    }

    // VALIDASI PEGAWAI

    private void validasiPegawai(Pegawai pegawai) {
        if (pegawai == null) {
            throw new ValidationException(
                    "Data Pegawai tidak boleh kosong."
            );
        }

        if (pegawai.getIdPegawai() <= 0) {
            throw new ValidationException(
                    "ID Pegawai tidak valid."
            );
        }

        if (kosong(pegawai.getNamaPegawai())) {
            throw new ValidationException(
                    "Nama Pegawai wajib diisi."
            );
        }

        if (kosong(pegawai.getNoHp())) {
            throw new ValidationException(
                    "Nomor HP Pegawai wajib diisi."
            );
        }

        if (pegawai.getTanggalMasuk() == null) {
            throw new ValidationException(
                    "Tanggal masuk wajib diisi."
            );
        }

        if (pegawai.getStatusPegawai() == null) {
            throw new ValidationException(
                    "Status Pegawai wajib dipilih."
            );
        }
    }

    private void validasiDataKhususPegawai(Pegawai pegawai) {
        if (pegawai instanceof Admin) {

            Admin admin = (Admin) pegawai;

            if (kosong(admin.getKodeAdmin())) {
                throw new ValidationException(
                        "Kode Admin wajib diisi."
                );
            }

            if (admin.getTanggalMulaiAkses() == null) {
                throw new ValidationException(
                        "Tanggal mulai akses Admin wajib diisi."
                );
            }

            if (admin.getTanggalMulaiAkses()
                    .isBefore(admin.getTanggalMasuk())) {
                throw new ValidationException(
                        "Tanggal mulai akses tidak boleh sebelum tanggal masuk."
                );
            }

        } else if (pegawai instanceof PetugasOperasional) {

            PetugasOperasional operasional =
                    (PetugasOperasional) pegawai;

            if (kosong(operasional.getKodePetugasOperasional())) {
                throw new ValidationException(
                        "Kode Petugas Operasional wajib diisi."
                );
            }

            if (kosong(operasional.getAreaTugas())) {
                throw new ValidationException(
                        "Area tugas wajib diisi."
                );
            }

            if (operasional.getShiftKerja() == null) {
                throw new ValidationException(
                        "Shift kerja wajib dipilih."
                );
            }

        } else if (pegawai instanceof PetugasHSE) {

            PetugasHSE hse = (PetugasHSE) pegawai;

            if (kosong(hse.getNoSertifikasiHSE())) {
                throw new ValidationException(
                        "Nomor sertifikasi HSE wajib diisi."
                );
            }

            if (hse.getMasaBerlakuSertifikasi() == null) {
                throw new ValidationException(
                        "Masa berlaku sertifikasi HSE wajib diisi."
                );
            }

        } else if (pegawai instanceof Manager) {

            Manager manager = (Manager) pegawai;

            if (kosong(manager.getKodeManager())) {
                throw new ValidationException(
                        "Kode Manager wajib diisi."
                );
            }

            if (kosong(manager.getDivisiTanggungJawab())) {
                throw new ValidationException(
                        "Divisi tanggung jawab Manager wajib diisi."
                );
            }

        } else if (pegawai instanceof Driver) {

            Driver driver = (Driver) pegawai;

            if (kosong(driver.getNoSim())) {
                throw new ValidationException(
                        "Nomor SIM Driver wajib diisi."
                );
            }

            if (driver.getMasaBerlakuSim() == null) {
                throw new ValidationException(
                        "Masa berlaku SIM wajib diisi."
                );
            }

            if (driver.getStatusDriver() == null) {
                throw new ValidationException(
                        "Status Driver wajib dipilih."
                );
            }

        } else {
            throw new ValidationException(
                    "Jenis Pegawai tidak dikenali."
            );
        }
    }

    private void validasiKeunikanDataKhusus(Pegawai pegawai) {
        for (Pegawai existing : pegawaiRepository.findAll()) {

            if (existing.getIdPegawai() == pegawai.getIdPegawai()) {
                continue;
            }

            if (pegawai instanceof Admin && existing instanceof Admin) {
                Admin baru = (Admin) pegawai;
                Admin lama = (Admin) existing;

                if (sama(lama.getKodeAdmin(), baru.getKodeAdmin())) {
                    throw new ValidationException(
                            "Kode Admin sudah digunakan."
                    );
                }
            }

            if (pegawai instanceof PetugasOperasional
                    && existing instanceof PetugasOperasional) {

                PetugasOperasional baru =
                        (PetugasOperasional) pegawai;

                PetugasOperasional lama =
                        (PetugasOperasional) existing;

                if (sama(
                        lama.getKodePetugasOperasional(),
                        baru.getKodePetugasOperasional())) {
                    throw new ValidationException(
                            "Kode Petugas Operasional sudah digunakan."
                    );
                }
            }

            if (pegawai instanceof PetugasHSE
                    && existing instanceof PetugasHSE) {

                PetugasHSE baru = (PetugasHSE) pegawai;
                PetugasHSE lama = (PetugasHSE) existing;

                if (sama(
                        lama.getNoSertifikasiHSE(),
                        baru.getNoSertifikasiHSE())) {
                    throw new ValidationException(
                            "Nomor sertifikasi HSE sudah digunakan."
                    );
                }
            }

            if (pegawai instanceof Manager
                    && existing instanceof Manager) {

                Manager baru = (Manager) pegawai;
                Manager lama = (Manager) existing;

                if (sama(
                        lama.getKodeManager(),
                        baru.getKodeManager())) {
                    throw new ValidationException(
                            "Kode Manager sudah digunakan."
                    );
                }
            }

            if (pegawai instanceof Driver
                    && existing instanceof Driver) {

                Driver baru = (Driver) pegawai;
                Driver lama = (Driver) existing;

                if (sama(lama.getNoSim(), baru.getNoSim())) {
                    throw new ValidationException(
                            "Nomor SIM Driver sudah digunakan."
                    );
                }
            }
        }
    }

    // VALIDASI USER

    private void validasiUser(User user) {
        if (user == null) {
            throw new ValidationException(
                    "Data User tidak boleh kosong."
            );
        }

        if (user.getIdUser() <= 0) {
            throw new ValidationException(
                    "ID User tidak valid."
            );
        }

        if (user.getPegawai() == null) {
            throw new ValidationException(
                    "User harus terhubung dengan Pegawai."
            );
        }

        Pegawai pegawai = getPegawaiOrThrow(user.getPegawai().getIdPegawai());

        if (pegawai instanceof Driver) {
            throw new ValidationException(
                    "Driver tidak dapat memiliki akun aplikasi."
            );
        }

        if (!(pegawai instanceof Admin)
                && !(pegawai instanceof PetugasOperasional)
                && !(pegawai instanceof PetugasHSE)
                && !(pegawai instanceof Manager)) {
            throw new ValidationException(
                    "Jenis Pegawai tidak memiliki akses aplikasi."
            );
        }

        if (pegawai.getStatusPegawai()
                != StatusPegawai.AKTIF) {
            throw new ValidationException(
                    "Akun hanya dapat dibuat untuk Pegawai aktif."
            );
        }

        if (kosong(user.getUsername())) {
            throw new ValidationException(
                    "Username wajib diisi."
            );
        }

        if (kosong(user.getPassword())) {
            throw new ValidationException(
                    "Password wajib diisi."
            );
        }
    }

    // VALIDASI LOKASI

    private void validasiLokasi(Lokasi lokasi) {
        if (lokasi == null) {
            throw new ValidationException(
                    "Data Lokasi tidak boleh kosong."
            );
        }

        if (lokasi.getIdLokasi() <= 0) {
            throw new ValidationException(
                    "ID Lokasi tidak valid."
            );
        }

        if (kosong(lokasi.getNamaLokasi())) {
            throw new ValidationException(
                    "Nama Lokasi wajib diisi."
            );
        }

        if (lokasi.getJenisLokasi() == null) {
            throw new ValidationException(
                    "Jenis Lokasi wajib dipilih."
            );
        }

        if (lokasi.getStatusOperasional() == null) {
            throw new ValidationException(
                    "Status operasional Lokasi wajib dipilih."
            );
        }
    }

    private void validasiNamaLokasiUnik(Lokasi lokasi) {

        for (Lokasi existing : lokasiRepository.findAll()) {

            if (existing.getIdLokasi() != lokasi.getIdLokasi()
                    && sama(
                    existing.getNamaLokasi(),
                    lokasi.getNamaLokasi())) {

                throw new ValidationException(
                        "Nama Lokasi sudah digunakan."
                );
            }
        }
    }

    // VALIDASI MATERIAL

    private void validasiMaterial(JenisMaterial material) {

        if (material == null) {
            throw new ValidationException(
                    "Data Material tidak boleh kosong."
            );
        }

        if (material.getIdMaterial() <= 0) {
            throw new ValidationException(
                    "ID Material tidak valid."
            );
        }

        if (kosong(material.getNamaMaterial())) {
            throw new ValidationException(
                    "Nama Material wajib diisi."
            );
        }

        if (kosong(material.getSatuan())) {
            throw new ValidationException(
                    "Satuan Material wajib diisi."
            );
        }
    }

    private void validasiNamaMaterialUnik(
            JenisMaterial material) {

        for (JenisMaterial existing :
                materialRepository.findAll()) {

            if (existing.getIdMaterial()
                    != material.getIdMaterial()
                    && sama(
                    existing.getNamaMaterial(),
                    material.getNamaMaterial())) {

                throw new ValidationException(
                        "Nama Material sudah digunakan."
                );
            }
        }
    }

    // VALIDASI KENDARAAN

    private void validasiKendaraan(Kendaraan kendaraan) {

        if (kendaraan == null) {
            throw new ValidationException(
                    "Data Kendaraan tidak boleh kosong."
            );
        }

        if (kendaraan.getIdKendaraan() <= 0) {
            throw new ValidationException(
                    "ID Kendaraan tidak valid."
            );
        }

        if (kosong(kendaraan.getJenisKendaraan())) {
            throw new ValidationException(
                    "Jenis Kendaraan wajib diisi."
            );
        }

        if (kosong(kendaraan.getNomorPolisi())) {
            throw new ValidationException(
                    "Nomor polisi wajib diisi."
            );
        }

        if (kendaraan.getKapasitas() <= 0) {
            throw new ValidationException(
                    "Kapasitas Kendaraan harus lebih dari 0."
            );
        }

        if (kendaraan.getTahunKendaraan() <= 0) {
            throw new ValidationException(
                    "Tahun Kendaraan tidak valid."
            );
        }

        if (kendaraan.getStatusKendaraan() == null) {
            throw new ValidationException(
                    "Status Kendaraan wajib dipilih."
            );
        }
    }

    // VALIDASI PARAMETER

    private void validasiParameter(
            ParameterLingkungan parameter) {

        if (parameter == null) {
            throw new ValidationException(
                    "Data Parameter tidak boleh kosong."
            );
        }

        if (parameter.getIdParameter() <= 0) {
            throw new ValidationException(
                    "ID Parameter tidak valid."
            );
        }

        if (kosong(parameter.getNamaParameter())) {
            throw new ValidationException(
                    "Nama Parameter wajib diisi."
            );
        }

        if (kosong(parameter.getSatuan())) {
            throw new ValidationException(
                    "Satuan Parameter wajib diisi."
            );
        }

        Double minimum =
                parameter.getBatasMinimum();

        Double maksimum =
                parameter.getBatasMaksimum();

        if (minimum != null
                && maksimum != null
                && minimum > maksimum) {

            throw new ValidationException(
                    "Batas minimum tidak boleh lebih besar dari batas maksimum."
            );
        }
    }

    private void validasiNamaParameterUnik(
            ParameterLingkungan parameter) {

        for (ParameterLingkungan existing :
                parameterRepository.findAll()) {

            if (existing.getIdParameter()
                    != parameter.getIdParameter()
                    && sama(
                    existing.getNamaParameter(),
                    parameter.getNamaParameter())) {

                throw new ValidationException(
                        "Nama Parameter sudah digunakan."
                );
            }
        }
    }

    // HELPER FIND

    private Pegawai getPegawaiOrThrow(int id) {
        Optional<Pegawai> data =
                pegawaiRepository.findById(id);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Pegawai tidak ditemukan."
            );
        }

        return data.get();
    }

    private User getUserOrThrow(int id) {
        Optional<User> data =
                userRepository.findById(id);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "User tidak ditemukan."
            );
        }

        return data.get();
    }

    private Lokasi getLokasiOrThrow(int id) {
        Optional<Lokasi> data =
                lokasiRepository.findById(id);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Lokasi tidak ditemukan."
            );
        }

        return data.get();
    }

    private JenisMaterial getMaterialOrThrow(int id) {
        Optional<JenisMaterial> data =
                materialRepository.findById(id);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Material tidak ditemukan."
            );
        }

        return data.get();
    }

    private Kendaraan getKendaraanOrThrow(int id) {
        Optional<Kendaraan> data =
                kendaraanRepository.findById(id);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Kendaraan tidak ditemukan."
            );
        }

        return data.get();
    }

    private ParameterLingkungan
            getParameterOrThrow(int id) {

        Optional<ParameterLingkungan> data =
                parameterRepository.findById(id);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Parameter Lingkungan tidak ditemukan."
            );
        }

        return data.get();
    }

    // HELPER UMUM

    private boolean kosong(String value) {
        return value == null
                || value.trim().isEmpty();
    }

    private boolean sama(
            String value1,
            String value2) {

        if (value1 == null || value2 == null) {
            return false;
        }

        return value1.trim()
                .equalsIgnoreCase(value2.trim());
    }
    
    public List<Kendaraan> tampilkanKendaraanTersedia() {
        List<Kendaraan> hasil = new ArrayList<Kendaraan>();

        for (Kendaraan kendaraan : kendaraanRepository.findAll()) {
            if (kendaraan.getStatusKendaraan() == StatusKendaraan.TERSEDIA) {
                hasil.add(kendaraan);
            }
        }

        return hasil;
    }
    
    public List<Lokasi> tampilkanLokasiPitAktif() {
        List<Lokasi> hasil = new ArrayList<Lokasi>();

        for (Lokasi lokasi : lokasiRepository.findAll()) {
            if (lokasi.getJenisLokasi() == JenisLokasi.PIT && lokasi.getStatusOperasional() == StatusLokasi.AKTIF) {
                hasil.add(lokasi);
            }
        }

        return hasil;
    }

    public List<Lokasi> tampilkanLokasiAktif() {
        List<Lokasi> hasil = new ArrayList<Lokasi>();

        for (Lokasi lokasi : lokasiRepository.findAll()) {

            if (lokasi.getStatusOperasional() == StatusLokasi.AKTIF) {
                hasil.add(lokasi);
            }
        }

        return hasil;
    }
}