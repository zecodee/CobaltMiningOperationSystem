/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package service;

import enums.JenisLokasi;
import enums.Periode;
import enums.StatusDetail;
import enums.StatusKendaraan;
import enums.StatusLokasi;
import enums.StatusMonitoring;
import enums.StatusPegawai;
import enums.StatusPenanganan;
import enums.StatusPengangkutan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import model.DetailMonitoring;
import model.Kendaraan;
import model.Lokasi;
import model.MonitoringLingkungan;
import model.Pegawai;
import model.Pengangkutan;
import model.ProduksiTambang;
import model.User;
import repository.KendaraanRepository;
import repository.LokasiRepository;
import repository.MaterialRepository;
import repository.MonitoringRepository;
import repository.PegawaiRepository;
import repository.PengangkutanRepository;
import repository.ParameterRepository;
import repository.ProduksiRepository;
import repository.UserRepository;

/**
 * Menghitung seluruh angka KPI, data grafik, dan tabel prioritas untuk
 * dashboard setiap jabatan. Seluruh angka dibaca dinamis dari database.
 *
 * @author zefrialrizkullah
 */
public final class DashboardService {
    private final PegawaiRepository pegawaiRepository;
    private final UserRepository userRepository;
    private final LokasiRepository lokasiRepository;
    private final MaterialRepository materialRepository;
    private final KendaraanRepository kendaraanRepository;
    private final ParameterRepository parameterRepository;
    private final ProduksiRepository produksiRepository;
    private final PengangkutanRepository pengangkutanRepository;
    private final MonitoringRepository monitoringRepository;

    public DashboardService(PegawaiRepository pegawaiRepository,
            UserRepository userRepository,
            LokasiRepository lokasiRepository,
            MaterialRepository materialRepository,
            KendaraanRepository kendaraanRepository,
            ParameterRepository parameterRepository,
            ProduksiRepository produksiRepository,
            PengangkutanRepository pengangkutanRepository,
            MonitoringRepository monitoringRepository) {
        this.pegawaiRepository = pegawaiRepository;
        this.userRepository = userRepository;
        this.lokasiRepository = lokasiRepository;
        this.materialRepository = materialRepository;
        this.kendaraanRepository = kendaraanRepository;
        this.parameterRepository = parameterRepository;
        this.produksiRepository = produksiRepository;
        this.pengangkutanRepository = pengangkutanRepository;
        this.monitoringRepository = monitoringRepository;
    }

    /** Satu baris prioritas penanganan lingkungan (per parameter bermasalah). */
    public static final class PrioritasRow {
        public int idMonitoring;
        public LocalDate tanggal;
        public String lokasi;
        public String parameter;
        public String satuan;
        public double nilai;
        public Double batasMinimum;
        public Double batasMaksimum;
        public StatusPenanganan penanganan;
        public String tindakLanjut;
        public boolean diteruskanKeManager;

        public String batasTeks() {
            if (batasMinimum != null && batasMaksimum != null) return batasMinimum + " - " + batasMaksimum;
            if (batasMaksimum != null) return "maks " + batasMaksimum;
            if (batasMinimum != null) return "min " + batasMinimum;
            return "-";
        }
    }

    /** Satu baris rekap produksi per lokasi untuk Manager. */
    public static final class RekapLokasiRow {
        public String namaLokasi;
        public String jenisLokasi;
        public double produksi;
        public double terkirim;
        public double stok;
    }

    /** Kumpulan angka ringkasan yang dibaca langsung oleh panel dashboard. */
    public static final class Data {
        // ---- administrator
        public int pegawaiTotal;
        public int pegawaiAktif;
        public int pegawaiNonaktif;
        public int akunTotal;
        public int akunAktif;
        public int akunNonaktif;
        public int aksesBelumTersedia;
        public int akunPerluDiperiksa;
        public int lokasiTotal;
        public int lokasiAktif;
        public int kendaraanTotal;
        public int kendaraanTersedia;
        public int materialTotal;
        public int parameterTotal;
        public Map<String, Integer> pegawaiPerJenis = new LinkedHashMap<>();
        public List<PrioritasRow> prioritas = new ArrayList<>();

        // ---- operasional
        public double produksiTon;
        public double stokTon;
        public int produksiCount;
        public int lokasiBerproduksi;
        public Map<String, Double> produksiPerLokasi = new LinkedHashMap<>();
        public List<LocalDate> trenTanggal = new ArrayList<>();
        public List<Double> trenNilai = new ArrayList<>();
        public List<ProduksiTambang> produksiTerbaru = new ArrayList<>();

        // ---- HSE / lingkungan
        public int monitoringTotal;
        public int monitoringNormal;
        public int monitoringPeringatan;
        public int penangananBelumSelesai;
        public Map<String, Integer> peringatanPerParameter = new LinkedHashMap<>();

        // ---- manager
        public List<RekapLokasiRow> rekapLokasi = new ArrayList<>();
        public int lokasiPeringatan;
    }

    // ---------------------------------------------------------------- admin
    public Data admin() {
        Data d = new Data();

        List<Pegawai> semua = pegawaiRepository.findAll();
        d.pegawaiTotal = semua.size();
        for (Pegawai p : semua) {
            if (p.getStatusPegawai() == StatusPegawai.AKTIF) d.pegawaiAktif++;
            else d.pegawaiNonaktif++;
            String jenis = labelJenis(p);
            d.pegawaiPerJenis.merge(jenis, 1, Integer::sum);
        }

        List<User> akun = userRepository.findAll();
        d.akunTotal = akun.size();
        for (User u : akun) {
            Pegawai p = u.getPegawai();
            if (p != null && p.getStatusPegawai() == StatusPegawai.AKTIF) d.akunAktif++;
            else d.akunNonaktif++;
        }

        d.aksesBelumTersedia = 0;
        for (Pegawai p : pegawaiRepository.findAllAktif()) {
            if (p instanceof model.Driver) continue;               // driver tidak memerlukan akun
            if (!userRepository.findByPegawai(p.getIdPegawai()).isPresent()) d.aksesBelumTersedia++;
        }
        d.akunPerluDiperiksa = d.akunNonaktif;                     // akun milik pegawai nonaktif

        List<Lokasi> lokasi = lokasiRepository.findAll();
        d.lokasiTotal = lokasi.size();
        for (Lokasi l : lokasi) if (l.getStatusOperasional() == StatusLokasi.AKTIF) d.lokasiAktif++;

        d.kendaraanTotal = 0;
        d.kendaraanTersedia = 0;
        for (Kendaraan k : kendaraanRepository.findAllDenganNonaktif()) {
            d.kendaraanTotal++;
            if (k.getStatusKendaraan() == StatusKendaraan.TERSEDIA) d.kendaraanTersedia++;
        }

        d.materialTotal = materialRepository.findAll().size();
        d.parameterTotal = parameterRepository.findAll().size();

        d.prioritas = barisPrioritas();
        return d;
    }

    /** Kumpulan id material yang sudah dipakai pada catatan produksi. */
    public java.util.Set<Integer> materialTerpakaiSet() {
        java.util.Set<Integer> unik = new java.util.HashSet<>();
        for (ProduksiTambang p : produksiRepository.findAll()) {
            if (p.getMaterial() != null)unik.add(p.getMaterial().getIdMaterial());
        }
        return unik;
    }

    // ----------------------------------------------------------- operasional
    public Data operasional(Periode periode, LocalDate kustomAwal, LocalDate kustomAkhir) {
        Data d = new Data();
        LocalDate awal = periode.awal(kustomAwal);
        LocalDate akhir = periode.akhir(kustomAkhir);

        double stok = 0;
        Map<String, Double> perLokasi = new LinkedHashMap<>();
        for (Lokasi l : lokasiRepository.findAll()) {
            if (l.getJenisLokasi() == JenisLokasi.PIT && l.getStatusOperasional() == StatusLokasi.AKTIF) {
                perLokasi.put(l.getNamaLokasi(), 0.0);
            }
        }
        Map<LocalDate, Double> tren = new TreeMap<>();
        List<ProduksiTambang> dalamPeriode = new ArrayList<>();
        for (ProduksiTambang p : produksiRepository.findAll()) {
            stok += p.getJumlahTersedia();
            if (!Periode.dalam(p.getTanggalProduksi(), awal, akhir)) continue;
            dalamPeriode.add(p);
            d.produksiTon += p.getJumlahProduksi();
            d.produksiCount++;
            String nama = p.getLokasi() == null ? "-" : p.getLokasi().getNamaLokasi();
            perLokasi.merge(nama, p.getJumlahProduksi(), Double::sum);
            if (p.getTanggalProduksi() != null) tren.merge(p.getTanggalProduksi(), p.getJumlahProduksi(), Double::sum);
        }
        d.stokTon = stok;
        d.lokasiBerproduksi = (int) perLokasi.values().stream().filter(v -> v > 0).count();
        d.produksiPerLokasi = perLokasi;
        for (Map.Entry<LocalDate, Double> e : tren.entrySet()) {
            d.trenTanggal.add(e.getKey());
            d.trenNilai.add(e.getValue());
        }
        dalamPeriode.sort((a, b) -> b.getTanggalProduksi().compareTo(a.getTanggalProduksi()));
        for (int i = 0; i < dalamPeriode.size() && i < 8; i++) d.produksiTerbaru.add(dalamPeriode.get(i));
        return d;
    }

    // ------------------------------------------------------------------ hse
    public Data hse(Periode periode, LocalDate kustomAwal, LocalDate kustomAkhir) {
        Data d = new Data();
        LocalDate awal = periode.awal(kustomAwal);
        LocalDate akhir = periode.akhir(kustomAkhir);

        for (MonitoringLingkungan m : monitoringRepository.findAll()) {
            boolean dalam = Periode.dalam(m.getTanggalMonitoring() == null ? null
                    : m.getTanggalMonitoring().toLocalDate(), awal, akhir);
            if (dalam) {
                d.monitoringTotal++;
                if (m.getStatusMonitoring() == StatusMonitoring.NORMAL) d.monitoringNormal++;
                else if (m.getStatusMonitoring() != StatusMonitoring.NORMAL) d.monitoringPeringatan++;
                if (dalam) hitungPeringatanPerParameter(m, d.peringatanPerParameter);
            }
            if (m.getStatusMonitoring() != StatusMonitoring.NORMAL
                    && (m.getStatusPenanganan() == StatusPenanganan.BELUM_DITANGANI
                    || m.getStatusPenanganan() == StatusPenanganan.DALAM_PENANGANAN)) {
                d.penangananBelumSelesai++;      // seluruh periode
            }
        }
        d.prioritas = barisPrioritas();
        return d;
    }

    // --------------------------------------------------------------- manager
    public Data manager(Periode periode, LocalDate kustomAwal, LocalDate kustomAkhir) {
        Data d = operasional(periode, kustomAwal, kustomAkhir);
        LocalDate awal = periode.awal(kustomAwal);
        LocalDate akhir = periode.akhir(kustomAkhir);

        // terkirim per lokasi (periode) + stok saat ini
        Map<Integer, Double> terkirim = new LinkedHashMap<>();
        for (Pengangkutan a : pengangkutanRepository.findAll()) {
            if (a.getStatusPengangkutan() != StatusPengangkutan.SELESAI) continue;
            if (!Periode.dalam(a.getTanggalPengangkutan(), awal, akhir)) continue;
            int idLokasi = a.getProduksi() != null && a.getProduksi().getLokasi() != null
                    ? a.getProduksi().getLokasi().getIdLokasi() : -1;
            terkirim.merge(idLokasi, a.getJumlahMuatan(), Double::sum);
        }
        for (Lokasi l : lokasiRepository.findAll()) {
            RekapLokasiRow r = new RekapLokasiRow();
            r.namaLokasi = l.getNamaLokasi();
            r.jenisLokasi = l.getJenisLokasi() == JenisLokasi.PIT ? "PIT" : "Stockpile";
            double produksi = d.produksiPerLokasi.getOrDefault(l.getNamaLokasi(), 0.0);
            double stok = 0;
            for (ProduksiTambang p : produksiRepository.findAll()) {
                if (p.getLokasi() != null && p.getLokasi().getIdLokasi() == l.getIdLokasi()) stok += p.getJumlahTersedia();
            }
            r.produksi = produksi;
            r.terkirim = terkirim.getOrDefault(l.getIdLokasi(), 0.0);
            r.stok = stok;
            d.rekapLokasi.add(r);
        }

        for (MonitoringLingkungan m : monitoringRepository.findAll()) {
            if (m.getStatusMonitoring() != StatusMonitoring.NORMAL
                    && (m.getStatusPenanganan() == StatusPenanganan.BELUM_DITANGANI
                    || m.getStatusPenanganan() == StatusPenanganan.DALAM_PENANGANAN)) {
                d.penangananBelumSelesai++;
                if (Periode.dalam(m.getTanggalMonitoring() == null ? null
                        : m.getTanggalMonitoring().toLocalDate(), awal, akhir)) {
                    hitungPeringatanPerParameter(m, d.peringatanPerParameter);
                }
            }
        }
        d.prioritas = barisPrioritas();
        d.lokasiPeringatan = hitungLokasiPeringatan();
        return d;
    }

    // -------------------------------------------------------------- helpers
    private void hitungPeringatanPerParameter(MonitoringLingkungan m, Map<String, Integer> target) {
        if (m.getDetailMonitoring() == null) return;
        for (DetailMonitoring dt : m.getDetailMonitoring()) {
            if (dt.getStatusDetail() != StatusDetail.NORMAL && dt.getParameter() != null) {
                target.merge(dt.getParameter().getNamaParameter(), 1, Integer::sum);
            }
        }
    }

    /** Lokasi yang hasil monitoring terakhirnya PERINGATAN. */
    private int hitungLokasiPeringatan() {
        Map<Integer, MonitoringLingkungan> terakhir = new LinkedHashMap<>();
        for (MonitoringLingkungan m : monitoringRepository.findAll()) {
            int id = m.getLokasi() == null ? -1 : m.getLokasi().getIdLokasi();
            MonitoringLingkungan ada = terakhir.get(id);
            if (ada == null || (m.getTanggalMonitoring() != null && ada.getTanggalMonitoring() != null
                    && m.getTanggalMonitoring().isAfter(ada.getTanggalMonitoring()))) {
                terakhir.put(id, m);
            }
        }
        int jumlah = 0;
        for (MonitoringLingkungan m : terakhir.values()) {
            if (m.getStatusMonitoring() != StatusMonitoring.NORMAL) jumlah++;
        }
        return jumlah;
    }

    /** Baris prioritas penanganan: monitoring PERINGATAN yang belum selesai ditangani. */
    private List<PrioritasRow> barisPrioritas() {
        List<PrioritasRow> out = new ArrayList<>();
        List<MonitoringLingkungan> daftar = monitoringRepository.findAll();
        daftar.sort((a, b) -> {
            if (a.getTanggalMonitoring() == null || b.getTanggalMonitoring() == null) return 0;
            return b.getTanggalMonitoring().compareTo(a.getTanggalMonitoring());
        });
        for (MonitoringLingkungan m : daftar) {
            if (m.getStatusMonitoring() == StatusMonitoring.NORMAL) continue;
            boolean adaBaris = false;
            if (m.getDetailMonitoring() != null) {
                for (DetailMonitoring dt : m.getDetailMonitoring()) {
                    if (dt.getStatusDetail() == StatusDetail.NORMAL) continue;
                    PrioritasRow r = new PrioritasRow();
                    r.idMonitoring = m.getIdMonitoring();
                    r.tanggal = m.getTanggalMonitoring() == null ? null : m.getTanggalMonitoring().toLocalDate();
                    r.lokasi = m.getLokasi() == null ? "-" : m.getLokasi().getNamaLokasi();
                    r.parameter = dt.getParameter() == null ? "-" : dt.getParameter().getNamaParameter();
                    r.satuan = dt.getParameter() == null ? "" : dt.getParameter().getSatuan();
                    r.nilai = dt.getNilaiPengukuran();
                    r.batasMinimum = dt.getParameter() == null ? null : dt.getParameter().getBatasMinimum();
                    r.batasMaksimum = dt.getParameter() == null ? null : dt.getParameter().getBatasMaksimum();
                    r.penanganan = m.getStatusPenanganan();
                    r.tindakLanjut = m.getTindakLanjut();
                    r.diteruskanKeManager = m.getTindakLanjut() != null
                            && m.getTindakLanjut().startsWith("Diteruskan ke Manager");
                    out.add(r);
                    adaBaris = true;
                }
            }
            if (!adaBaris) {
                PrioritasRow r = new PrioritasRow();
                r.idMonitoring = m.getIdMonitoring();
                r.tanggal = m.getTanggalMonitoring() == null ? null : m.getTanggalMonitoring().toLocalDate();
                r.lokasi = m.getLokasi() == null ? "-" : m.getLokasi().getNamaLokasi();
                r.parameter = "Parameter tidak tercatat";
                r.satuan = "";
                r.nilai = 0;
                r.penanganan = m.getStatusPenanganan();
                r.tindakLanjut = m.getTindakLanjut();
                r.diteruskanKeManager = m.getTindakLanjut() != null
                        && m.getTindakLanjut().startsWith("Diteruskan ke Manager");
                out.add(r);
            }
        }
        return out;
    }

    private static String labelJenis(Pegawai p) {
        if (p instanceof model.Admin) return "Admin";
        if (p instanceof model.PetugasOperasional) return "Petugas Operasional";
        if (p instanceof model.PetugasHSE) return "Petugas HSE";
        if (p instanceof model.Manager) return "Manager";
        if (p instanceof model.Driver) return "Driver";
        return "Lainnya";
    }
}
