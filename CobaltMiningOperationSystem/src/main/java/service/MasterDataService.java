/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.*;
import exception.*;
import java.util.*;
import model.*;
import repository.*;
import util.PasswordUtil;

/**
 *
 * @author zefrialrizkullah
 */

public final class MasterDataService {
    private final PegawaiRepository pegawai;
    private final UserRepository users;
    private final LokasiRepository lokasi;
    private final MaterialRepository material;
    private final KendaraanRepository kendaraan;
    private final ParameterRepository parameter;
    public MasterDataService(PegawaiRepository p, UserRepository u, LokasiRepository l, MaterialRepository m,
            KendaraanRepository k, ParameterRepository a) {
        pegawai = p;
        users = u;
        lokasi = l;
        material = m;
        kendaraan = k;
        parameter = a;
    }
    private static void check(boolean ok, String msg) {
        if (!ok)throw new ValidationException(msg);
    }
    private static boolean filled(String s) {
        return s != null && !s.trim().isEmpty();
    }
    private static boolean finite(double v) {
        return Double.isFinite(v) && v>0 && Math.round(v*100.0)/100.0 == v;
    }
    private void validatePegawai(Pegawai p) {
        check(p != null,"Pegawai wajib diisi.");
        check(filled(p.getNamaPegawai()) && filled(p.getNoHp()) && p.getTanggalMasuk() != null
 && p.getStatusPegawai() != null,"Data pegawai belum lengkap.");
        if (p instanceof Admin) {
            Admin a = (Admin)p;
            check(filled(a.getKodeAdmin()) && a.getTanggalMulaiAkses() != null
 && !a.getTanggalMulaiAkses().isBefore(a.getTanggalMasuk()),"Data Admin tidak valid.");
        }
        else if (p instanceof PetugasOperasional)check(((PetugasOperasional)p).getShiftKerja() != null,
                "Shift kerja wajib dipilih.");
        else if (p instanceof PetugasHSE) {
            PetugasHSE h = (PetugasHSE)p;
            check(filled(h.getNoSertifikasiHSE()) && h.getMasaBerlakuSertifikasi() != null,
                    "Data HSE belum lengkap.");
        }
        else if (p instanceof Manager)check(filled(((Manager)p).getDivisiTanggungJawab()),
                "Divisi manager wajib diisi.");
        else if (p instanceof Driver) {
            Driver d = (Driver)p;
            check(filled(d.getNoSim()) && d.getMasaBerlakuSim() != null && d.getStatusDriver() != null,
                    "Data driver belum lengkap.");
        }
        else throw new ValidationException("Jenis pegawai tidak dikenali.");
        for (Pegawai x:pegawai.findAll()) {
            if (p.getIdPegawai()>0 && p.getIdPegawai() == x.getIdPegawai())continue;
            if (p instanceof Admin && x instanceof Admin
 && ((Admin)p).getKodeAdmin().equalsIgnoreCase(((Admin)x).getKodeAdmin()))throw new ValidationException("Kode Admin sudah digunakan.");
            if (p instanceof PetugasHSE && x instanceof PetugasHSE
 && ((PetugasHSE)p).getNoSertifikasiHSE().equalsIgnoreCase(((PetugasHSE)x).getNoSertifikasiHSE()))throw new ValidationException("Nomor sertifikasi sudah digunakan.");
            if (p instanceof Driver && x instanceof Driver
 && ((Driver)p).getNoSim().equalsIgnoreCase(((Driver)x).getNoSim()))throw new ValidationException("Nomor SIM sudah digunakan.");
        }
    }
    public void tambahPegawai(Pegawai p) {
        validatePegawai(p);
        check(p.getIdPegawai() == 0,"ID baru harus 0.");
        if (p instanceof Driver)check(((Driver)p).getStatusDriver() != StatusDriver.BERTUGAS,
                "Driver baru tidak boleh BERTUGAS.");
        pegawai.save(p);
    }
    public void ubahPegawai(Pegawai p) {
        validatePegawai(p);
        Pegawai old = cariPegawaiById(p.getIdPegawai());
        check(old.getClass() == p.getClass(),"Jenis pegawai tidak dapat diubah.");
        if (p instanceof Driver) {
            Driver d = (Driver)p, o = (Driver)old;
            check(d.getStatusDriver() != StatusDriver.BERTUGAS || o.getStatusDriver() == StatusDriver.BERTUGAS,
                    "Status BERTUGAS hanya dari pengangkutan.");
            check(o.getStatusDriver() != StatusDriver.BERTUGAS || d.getStatusDriver() == StatusDriver.BERTUGAS,
                    "Driver sedang bertugas.");
        }
        pegawai.update(p);
    }
    public void hapusPegawai(int id) {
        cariPegawaiById(id);
        check(!users.findByPegawai(id).isPresent(),"Pegawai memiliki akun.");
        pegawai.delete(id);
    }
    public Pegawai cariPegawaiById(int id) {
        return pegawai.findById(id).orElseThrow(()->new DataNotFoundException("Pegawai tidak ditemukan."));
    }
    public List<Pegawai> tampilkanSemuaPegawai() {
        return pegawai.findAll();
    }
    public List<Pegawai> cariPegawaiByNama(String n) {
        return filled(n)?pegawai.findByNama(n.trim()):pegawai.findAll();
    }
    private void validateUser(User u) {
        check(u != null && u.getPegawai() != null && filled(u.getUsername()),"Data user belum lengkap.");
        Pegawai p = cariPegawaiById(u.getPegawai().getIdPegawai());
        check(!(p instanceof Driver) && p.getStatusPegawai() == StatusPegawai.AKTIF,
                "Pegawai tidak boleh memiliki akun.");
    }
    public void tambahUser(User u) {
        validateUser(u);
        check(u.getIdUser() == 0,"ID user baru harus 0.");
        check(filled(u.getPassword()),"Password wajib diisi.");
        check(!users.findByUsername(u.getUsername().trim()).isPresent(),"Username digunakan.");
        check(!users.findByPegawai(u.getPegawai().getIdPegawai()).isPresent(),
                "Pegawai sudah memiliki akun.");
        u.setUsername(u.getUsername().trim());
        u.setPassword(PasswordUtil.hashPassword(u.getPassword()));
        users.save(u);
    }
    public void ubahUser(User u) {
        validateUser(u);
        User old = cariUserById(u.getIdUser());
        check(old.getPegawai().getIdPegawai() == u.getPegawai().getIdPegawai(),
                "Pemilik akun tidak dapat diganti.");
        Optional<User> same = users.findByUsername(u.getUsername().trim());
        check(!same.isPresent() || same.get().getIdUser() == u.getIdUser(),"Username digunakan.");
        String pwd = u.getPassword();
        if (pwd == null || pwd.isEmpty() || pwd.equals(old.getPassword()))u.setPassword(old.getPassword());
        else u.setPassword(PasswordUtil.hashPassword(pwd));
        u.setUsername(u.getUsername().trim());
        users.update(u);
    }
    public void hapusUser(int id) {
        cariUserById(id);
        users.delete(id);
    }
    public User cariUserById(int id) {
        return users.findById(id).orElseThrow(()->new DataNotFoundException("User tidak ditemukan."));
    }
    public Optional<User> cariUserByPegawai(int id) {
        return users.findByPegawai(id);
    }
    public List<User> tampilkanSemuaUser() {
        return users.findAll();
    }
    private void validateLokasi(Lokasi l) {
        check(l != null && filled(l.getNamaLokasi()) && l.getJenisLokasi() != null && l.getStatusOperasional() != null,
                "Data lokasi belum lengkap.");
        for (Lokasi x:lokasi.findAll())if (x.getIdLokasi() != l.getIdLokasi()
 && x.getNamaLokasi().equalsIgnoreCase(l.getNamaLokasi().trim()))throw new ValidationException("Nama lokasi digunakan.");
    }
    public void tambahLokasi(Lokasi l) {
        validateLokasi(l);
        check(l.getIdLokasi() == 0,"ID baru harus 0.");
        lokasi.save(l);
    }
    public void ubahLokasi(Lokasi l) {
        validateLokasi(l);
        cariLokasiById(l.getIdLokasi());
        lokasi.update(l);
    }
    public void hapusLokasi(int id) {
        cariLokasiById(id);
        lokasi.delete(id);
    }
    public Lokasi cariLokasiById(int id) {
        return lokasi.findById(id).orElseThrow(()->new DataNotFoundException("Lokasi tidak ditemukan."));
    }
    public List<Lokasi> tampilkanSemuaLokasi() {
        return lokasi.findAll();
    }
    public List<Lokasi> cariLokasiByNama(String n) {
        return filled(n)?lokasi.findByNama(n.trim()):lokasi.findAll();
    }
    private void validateMaterial(JenisMaterial m) {
        check(m != null && filled(m.getNamaMaterial()) && filled(m.getSatuan()),"Data material belum lengkap.");
        for (JenisMaterial x:material.findAll())if (x.getIdMaterial() != m.getIdMaterial()
 && x.getNamaMaterial().equalsIgnoreCase(m.getNamaMaterial().trim()))throw new ValidationException("Nama material digunakan.");
    }
    public void tambahMaterial(JenisMaterial m) {
        validateMaterial(m);
        check(m.getIdMaterial() == 0,"ID baru harus 0.");
        material.save(m);
    }
    public void ubahMaterial(JenisMaterial m) {
        validateMaterial(m);
        cariMaterialById(m.getIdMaterial());
        material.update(m);
    }
    public void hapusMaterial(int id) {
        cariMaterialById(id);
        material.delete(id);
    }
    public JenisMaterial cariMaterialById(int id) {
        return material.findById(id).orElseThrow(()->new DataNotFoundException("Material tidak ditemukan."));
    }
    public List<JenisMaterial> tampilkanSemuaMaterial() {
        return material.findAll();
    }
    public List<JenisMaterial> cariMaterialByNama(String n) {
        return filled(n)?material.findByNama(n.trim()):material.findAll();
    }
    private void validateKendaraan(Kendaraan k) {
        check(k != null && filled(k.getJenisKendaraan()) && filled(k.getNomorPolisi()) && finite(k.getKapasitas())
 && k.getTahunKendaraan() >= 1900 && k.getTahunKendaraan() <= java.time.LocalDate.now().getYear()+1
 && k.getStatusKendaraan() != null,"Data kendaraan tidak valid.");
        Optional<Kendaraan> x = kendaraan.findByNomorPolisi(k.getNomorPolisi());
        check(!x.isPresent() || x.get().getIdKendaraan() == k.getIdKendaraan(),"Nomor polisi digunakan.");
    }
    public void tambahKendaraan(Kendaraan k) {
        validateKendaraan(k);
        check(k.getIdKendaraan() == 0 && k.getStatusKendaraan() != StatusKendaraan.DIGUNAKAN,
                "ID/status kendaraan baru tidak valid.");
        kendaraan.save(k);
    }
    public void ubahKendaraan(Kendaraan k) {
        validateKendaraan(k);
        Kendaraan old = cariKendaraanById(k.getIdKendaraan());
        check(old.getStatusKendaraan() != StatusKendaraan.DIGUNAKAN
 || k.getStatusKendaraan() == StatusKendaraan.DIGUNAKAN,"Kendaraan sedang digunakan.");
        check(k.getStatusKendaraan() != StatusKendaraan.DIGUNAKAN
 || old.getStatusKendaraan() == StatusKendaraan.DIGUNAKAN,
                "Status DIGUNAKAN hanya dari pengangkutan.");
        kendaraan.update(k);
    }
    public void hapusKendaraan(int id) {
        check(cariKendaraanById(id).getStatusKendaraan() != StatusKendaraan.DIGUNAKAN,"Kendaraan digunakan.");
        kendaraan.delete(id);
    }
    public Kendaraan cariKendaraanById(int id) {
        return kendaraan.findById(id).orElseThrow(()->new DataNotFoundException("Kendaraan tidak ditemukan."));
    }
    public List<Kendaraan> tampilkanSemuaKendaraan() {
        return kendaraan.findAll();
    }
    private void validateParameter(ParameterLingkungan a) {
        check(a != null && filled(a.getNamaParameter()) && filled(a.getSatuan()),"Data parameter belum lengkap.");
        Double min = a.getBatasMinimum(), max = a.getBatasMaksimum();
        check((min == null || Double.isFinite(min)) && (max == null || Double.isFinite(max)) && (min == null || max == null
 || min <= max),"Batas parameter tidak valid.");
        for (ParameterLingkungan x:parameter.findAll())if (x.getIdParameter() != a.getIdParameter()
 && x.getNamaParameter().equalsIgnoreCase(a.getNamaParameter().trim()))throw new ValidationException("Nama parameter digunakan.");
    }
    public void tambahParameter(ParameterLingkungan a) {
        validateParameter(a);
        check(a.getIdParameter() == 0,"ID baru harus 0.");
        parameter.save(a);
    }
    public void ubahParameter(ParameterLingkungan a) {
        validateParameter(a);
        cariParameterById(a.getIdParameter());
        parameter.update(a);
    }
    public void hapusParameter(int id) {
        cariParameterById(id);
        parameter.delete(id);
    }
    public ParameterLingkungan cariParameterById(int id) {
        return parameter.findById(id).orElseThrow(()->new DataNotFoundException("Parameter tidak ditemukan."));
    }
    public List<ParameterLingkungan> tampilkanSemuaParameter() {
        return parameter.findAll();
    }
    public List<ParameterLingkungan> cariParameterByNama(String n) {
        return filled(n)?parameter.findByNama(n.trim()):parameter.findAll();
    }
    public List<Kendaraan> tampilkanKendaraanTersedia() {
        List<Kendaraan> out = new ArrayList<>();
        for (Kendaraan x:kendaraan.findAll())if (x.getStatusKendaraan() == StatusKendaraan.TERSEDIA)out.add(x);
        return out;
    }
    public List<Lokasi> tampilkanLokasiPitAktif() {
        List<Lokasi> out = new ArrayList<>();
        for (Lokasi x:lokasi.findAll())if (x.getJenisLokasi() == JenisLokasi.PIT
 && x.getStatusOperasional() == StatusLokasi.AKTIF)out.add(x);
        return out;
    }
    public List<Lokasi> tampilkanLokasiAktif() {
        List<Lokasi> out = new ArrayList<>();
        for (Lokasi x:lokasi.findAll())if (x.getStatusOperasional() == StatusLokasi.AKTIF)out.add(x);
        return out;
    }
}
