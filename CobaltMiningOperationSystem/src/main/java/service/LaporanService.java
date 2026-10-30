/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.StatusMonitoring;
import enums.StatusPengangkutan;
import enums.StatusPenanganan;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.DetailMonitoring;
import model.MonitoringLingkungan;
import model.Pengangkutan;
import model.ProduksiTambang;
import repository.MonitoringRepository;
import repository.PengangkutanRepository;
import repository.ProduksiRepository;

/**
 *
 * @author zefrialrizkullah
 */

public final class LaporanService {
    private final ProduksiRepository produksiRepository;
    private final PengangkutanRepository pengangkutanRepository;
    private final MonitoringRepository monitoringRepository;

    public LaporanService(ProduksiRepository produksiRepository,
            PengangkutanRepository pengangkutanRepository,
            MonitoringRepository monitoringRepository) {
        this.produksiRepository = produksiRepository;
        this.pengangkutanRepository = pengangkutanRepository;
        this.monitoringRepository = monitoringRepository;
    }

    private void validasiPeriode(LocalDate awal, LocalDate akhir) {
        if (awal == null || akhir == null || awal.isAfter(akhir)) {
            throw new exception.ValidationException("Periode laporan tidak valid.");
        }
    }

    public Ringkasan ringkasan(LocalDate awal, LocalDate akhir) {
        validasiPeriode(awal, akhir);
        double produksi = 0;
        double angkut = 0;
        int selesai = 0;
        int normal = 0;
        int peringatan = 0;
        int penangananSelesai = 0;
        for (ProduksiTambang p : produksiRepository.findAll()) {
            if (dalamPeriode(p.getTanggalProduksi(), awal, akhir)) {
                produksi += p.getJumlahProduksi();
            }
        }
        for (Pengangkutan p : pengangkutanRepository.findAll()) {
            if (p.getStatusPengangkutan() == StatusPengangkutan.SELESAI
                    && p.getWaktuSelesai() != null
                    && dalamPeriode(p.getWaktuSelesai().toLocalDate(), awal, akhir)) {
                angkut += p.getJumlahMuatan();
                selesai++;
            }
        }
        for (MonitoringLingkungan m : monitoringRepository.findAll()) {
            if (m.getTanggalMonitoring() == null
                    || !dalamPeriode(m.getTanggalMonitoring().toLocalDate(), awal, akhir)) {
                continue;
            }
            if (m.getStatusMonitoring() == StatusMonitoring.PERINGATAN) {
                peringatan++;
            } else if (m.getStatusMonitoring() == StatusMonitoring.NORMAL) {
                normal++;
            }
            if (m.getStatusPenanganan() == StatusPenanganan.SELESAI) {
                penangananSelesai++;
            }
        }
        return new Ringkasan(produksi, angkut, selesai,
                normal, peringatan, penangananSelesai);
    }

    public List<BarisProduksi> laporanProduksi(LocalDate awal, LocalDate akhir) {
        validasiPeriode(awal, akhir);
        List<BarisProduksi> hasil = new ArrayList<>();
        for (ProduksiTambang p : produksiRepository.findAll()) {
            if (dalamPeriode(p.getTanggalProduksi(), awal, akhir)) {
                hasil.add(new BarisProduksi(p.getIdProduksi(), p.getTanggalProduksi(),
                        p.getMaterial().getNamaMaterial(), p.getLokasi().getNamaLokasi(),
                        p.getJumlahProduksi(), p.getJumlahTersedia()));
            }
        }
        return Collections.unmodifiableList(hasil);
    }

    public List<BarisPengangkutan> laporanPengangkutan(LocalDate awal, LocalDate akhir) {
        validasiPeriode(awal, akhir);
        List<BarisPengangkutan> hasil = new ArrayList<>();
        for (Pengangkutan p : pengangkutanRepository.findAll()) {
            if (p.getStatusPengangkutan() != StatusPengangkutan.SELESAI
                    || p.getWaktuSelesai() == null
                    || !dalamPeriode(p.getWaktuSelesai().toLocalDate(), awal, akhir)) {
                continue;
            }
            hasil.add(new BarisPengangkutan(p.getIdPengangkutan(),
                    p.getWaktuSelesai().toLocalDate(),
                    p.getProduksi().getMaterial().getNamaMaterial(),
                    p.getLokasiTujuan().getNamaLokasi(), p.getJumlahMuatan()));
        }
        return Collections.unmodifiableList(hasil);
    }

    public List<BarisMonitoring> laporanMonitoring(LocalDate awal, LocalDate akhir) {
        validasiPeriode(awal, akhir);
        List<BarisMonitoring> hasil = new ArrayList<>();
        for (MonitoringLingkungan m : monitoringRepository.findAll()) {
            if (m.getTanggalMonitoring() != null
                    && dalamPeriode(m.getTanggalMonitoring().toLocalDate(), awal, akhir)) {
                hasil.add(new BarisMonitoring(m.getIdMonitoring(),
                        m.getTanggalMonitoring().toLocalDate(),
                        m.getLokasi().getNamaLokasi(), m.getStatusMonitoring().name(),
                        m.getStatusPenanganan().name()));
            }
        }
        return Collections.unmodifiableList(hasil);
    }

    public DetailLaporanMonitoring detailMonitoring(int idMonitoring) {
        MonitoringLingkungan m = monitoringRepository.findById(idMonitoring)
                .orElseThrow(() -> new exception.DataNotFoundException("Monitoring tidak ditemukan."));
        List<BarisDetail> detail = new ArrayList<>();
        for (DetailMonitoring d : m.getDetailMonitoring()) {
            detail.add(new BarisDetail(d.getParameter().getNamaParameter(),
                    d.getParameter().getSatuan(), d.getNilaiPengukuran(),
                    d.getParameter().getBatasMinimum(), d.getParameter().getBatasMaksimum(),
                    d.getStatusDetail().name(), d.getCatatan()));
        }
        return new DetailLaporanMonitoring(m.getIdMonitoring(),
                m.getLokasi().getNamaLokasi(), m.getTanggalMonitoring().toLocalDate(),
                m.getStatusMonitoring().name(), m.getStatusPenanganan().name(),
                m.getTindakLanjut(), m.getCatatan(), detail);
    }

    private boolean dalamPeriode(LocalDate tanggal, LocalDate awal, LocalDate akhir) {
        return tanggal != null && !tanggal.isBefore(awal) && !tanggal.isAfter(akhir);
    }

    public static final class Ringkasan {
        public final double totalProduksi;
        public final double totalDiangkut;
        public final int pengangkutanSelesai;
        public final int monitoringNormal;
        public final int monitoringPeringatan;
        public final int penangananSelesai;

        private Ringkasan(double totalProduksi, double totalDiangkut,
                int pengangkutanSelesai, int monitoringNormal,
                int monitoringPeringatan, int penangananSelesai) {
            this.totalProduksi = totalProduksi;
            this.totalDiangkut = totalDiangkut;
            this.pengangkutanSelesai = pengangkutanSelesai;
            this.monitoringNormal = monitoringNormal;
            this.monitoringPeringatan = monitoringPeringatan;
            this.penangananSelesai = penangananSelesai;
        }
    }

    public static final class BarisProduksi {
        public final int id;
        public final LocalDate tanggal;
        public final String material;
        public final String lokasi;
        public final double jumlahProduksi;
        public final double sisaSaatIni;

        private BarisProduksi(int id, LocalDate tanggal, String material,
                String lokasi, double jumlahProduksi, double sisaSaatIni) {
            this.id = id;
            this.tanggal = tanggal;
            this.material = material;
            this.lokasi = lokasi;
            this.jumlahProduksi = jumlahProduksi;
            this.sisaSaatIni = sisaSaatIni;
        }
    }

    public static final class BarisPengangkutan {
        public final int id;
        public final LocalDate tanggalSelesai;
        public final String material;
        public final String tujuan;
        public final double jumlahMuatan;

        private BarisPengangkutan(int id, LocalDate tanggalSelesai,
                String material, String tujuan, double jumlahMuatan) {
            this.id = id;
            this.tanggalSelesai = tanggalSelesai;
            this.material = material;
            this.tujuan = tujuan;
            this.jumlahMuatan = jumlahMuatan;
        }
    }

    public static final class BarisMonitoring {
        public final int id;
        public final LocalDate tanggal;
        public final String lokasi;
        public final String status;
        public final String penanganan;

        private BarisMonitoring(int id, LocalDate tanggal,
                String lokasi, String status, String penanganan) {
            this.id = id;
            this.tanggal = tanggal;
            this.lokasi = lokasi;
            this.status = status;
            this.penanganan = penanganan;
        }
    }

    public static final class BarisDetail {
        public final String parameter;
        public final String satuan;
        public final double nilai;
        public final Double minimum;
        public final Double maksimum;
        public final String status;
        public final String catatan;

        private BarisDetail(String parameter, String satuan, double nilai,
                Double minimum, Double maksimum, String status, String catatan) {
            this.parameter = parameter;
            this.satuan = satuan;
            this.nilai = nilai;
            this.minimum = minimum;
            this.maksimum = maksimum;
            this.status = status;
            this.catatan = catatan;
        }
    }

    public static final class DetailLaporanMonitoring {
        public final int id;
        public final String lokasi;
        public final LocalDate tanggal;
        public final String status;
        public final String penanganan;
        public final String tindakLanjut;
        public final String catatan;
        public final List<BarisDetail> detail;

        private DetailLaporanMonitoring(int id, String lokasi, LocalDate tanggal,
                String status, String penanganan, String tindakLanjut,
                String catatan, List<BarisDetail> detail) {
            this.id = id;
            this.lokasi = lokasi;
            this.tanggal = tanggal;
            this.status = status;
            this.penanganan = penanganan;
            this.tindakLanjut = tindakLanjut;
            this.catatan = catatan;
            this.detail = Collections.unmodifiableList(new ArrayList<>(detail));
        }
    }
}
