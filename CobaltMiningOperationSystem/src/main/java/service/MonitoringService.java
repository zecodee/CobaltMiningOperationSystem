/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import enums.StatusDetail;
import enums.StatusLokasi;
import enums.StatusMonitoring;
import enums.StatusPegawai;
import enums.StatusPenanganan;
import exception.DataNotFoundException;
import exception.ValidationException;
import model.DetailMonitoring;
import model.Lokasi;
import model.MonitoringLingkungan;
import model.ParameterLingkungan;
import model.PetugasHSE;
import repository.LokasiRepository;
import repository.MonitoringRepository;
import repository.ParameterRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class MonitoringService {
    private final MonitoringRepository monitoringRepository;
    private final LokasiRepository lokasiRepository;
    private final ParameterRepository parameterRepository;

    public MonitoringService(
            MonitoringRepository monitoringRepository,
            LokasiRepository lokasiRepository,
            ParameterRepository parameterRepository) {

        this.monitoringRepository =
                monitoringRepository;

        this.lokasiRepository =
                lokasiRepository;

        this.parameterRepository =
                parameterRepository;
    }

    public MonitoringLingkungan buatMonitoring(
            int idMonitoring,
            int idLokasi,
            PetugasHSE petugasHSE,
            LocalDateTime tanggalMonitoring,
            String catatan) {

        if (idMonitoring <= 0) {
            throw new ValidationException(
                    "ID monitoring tidak valid."
            );
        }

        if (monitoringRepository
                .findById(idMonitoring)
                .isPresent()) {

            throw new ValidationException(
                    "ID monitoring sudah digunakan."
            );
        }

        validasiPetugasHSE(petugasHSE);

        Lokasi lokasi =
                getLokasiOrThrow(idLokasi);

        if (lokasi.getStatusOperasional()
                == StatusLokasi.DITUTUP_SEMENTARA) {
        }

        if (tanggalMonitoring == null) {
            tanggalMonitoring =
                    LocalDateTime.now();
        }

        MonitoringLingkungan monitoring =
                new MonitoringLingkungan(
                        idMonitoring,
                        lokasi,
                        petugasHSE,
                        tanggalMonitoring,
                        StatusMonitoring.NORMAL,
                        null,
                        StatusPenanganan.TIDAK_DIPERLUKAN,
                        catatan
                );

        monitoringRepository.save(monitoring);

        return monitoring;
    }

    public DetailMonitoring tambahDetail(
            int idMonitoring,
            int idDetail,
            int idParameter,
            double nilaiPengukuran,
            String catatan) {

        MonitoringLingkungan monitoring =
                getMonitoringOrThrow(idMonitoring);

        if (idDetail <= 0) {
            throw new ValidationException(
                    "ID detail monitoring tidak valid."
            );
        }

        for (DetailMonitoring detail :
                monitoring.getDetailMonitoring()) {

            if (detail.getIdDetail() == idDetail) {
                throw new ValidationException(
                        "ID detail monitoring sudah digunakan."
                );
            }

            if (detail.getParameter() != null
                    && detail.getParameter()
                    .getIdParameter() == idParameter) {

                throw new ValidationException(
                        "Parameter tersebut sudah dicatat pada monitoring ini."
                );
            }
        }

        ParameterLingkungan parameter =
                getParameterOrThrow(idParameter);

        StatusDetail statusDetail =
                tentukanStatusDetail(
                        parameter,
                        nilaiPengukuran
                );

        DetailMonitoring detail =
                new DetailMonitoring(
                        idDetail,
                        monitoring,
                        parameter,
                        nilaiPengukuran,
                        statusDetail,
                        catatan
                );

        monitoring.tambahDetail(detail);

        hitungUlangStatusMonitoring(
                monitoring
        );

        monitoringRepository.update(
                monitoring
        );

        return detail;
    }

    public void aturTindakLanjut(
            int idMonitoring,
            String tindakLanjut) {

        MonitoringLingkungan monitoring =
                getMonitoringOrThrow(idMonitoring);

        if (monitoring.getStatusMonitoring()
                != StatusMonitoring.PERINGATAN) {

            throw new ValidationException(
                    "Tindak lanjut hanya diperlukan untuk monitoring berstatus PERINGATAN."
            );
        }

        if (tindakLanjut == null
                || tindakLanjut.trim().isEmpty()) {

            throw new ValidationException(
                    "Tindak lanjut wajib diisi."
            );
        }

        monitoring.setTindakLanjut(
                tindakLanjut.trim()
        );

        if (monitoring.getStatusPenanganan()
                == StatusPenanganan.TIDAK_DIPERLUKAN) {

            monitoring.setStatusPenanganan(
                    StatusPenanganan.BELUM_DITANGANI
            );
        }

        monitoringRepository.update(
                monitoring
        );
    }

    public void mulaiPenanganan(
            int idMonitoring) {

        MonitoringLingkungan monitoring =
                getMonitoringOrThrow(idMonitoring);

        if (monitoring.getStatusMonitoring()
                != StatusMonitoring.PERINGATAN) {

            throw new ValidationException(
                    "Monitoring NORMAL tidak memerlukan penanganan."
            );
        }

        if (monitoring.getTindakLanjut() == null
                || monitoring.getTindakLanjut()
                .trim().isEmpty()) {

            throw new ValidationException(
                    "Tindak lanjut harus diisi sebelum penanganan dimulai."
            );
        }

        if (monitoring.getStatusPenanganan()
                != StatusPenanganan.BELUM_DITANGANI) {

            throw new ValidationException(
                    "Penanganan hanya dapat dimulai dari status BELUM_DITANGANI."
            );
        }

        monitoring.setStatusPenanganan(
                StatusPenanganan.DALAM_PENANGANAN
        );

        monitoringRepository.update(
                monitoring
        );
    }

    public void selesaikanPenanganan(
            int idMonitoring) {

        MonitoringLingkungan monitoring =
                getMonitoringOrThrow(idMonitoring);

        if (monitoring.getStatusPenanganan()
                != StatusPenanganan.DALAM_PENANGANAN) {

            throw new ValidationException(
                    "Penanganan hanya dapat diselesaikan dari status DALAM_PENANGANAN."
            );
        }

        monitoring.setStatusPenanganan(
                StatusPenanganan.SELESAI
        );

        monitoringRepository.update(
                monitoring
        );
    }

    public void ubahStatusLokasi(
            int idMonitoring,
            StatusLokasi statusLokasi) {

        MonitoringLingkungan monitoring =
                getMonitoringOrThrow(idMonitoring);

        if (statusLokasi == null) {
            throw new ValidationException(
                    "Status lokasi wajib dipilih."
            );
        }

        Lokasi lokasi =
                monitoring.getLokasi();

        lokasi.setStatusOperasional(
                statusLokasi
        );

        lokasiRepository.update(lokasi);
    }

    public MonitoringLingkungan
            cariMonitoringById(int idMonitoring) {

        return getMonitoringOrThrow(
                idMonitoring
        );
    }

    public List<MonitoringLingkungan>
            tampilkanSemuaMonitoring() {

        return monitoringRepository.findAll();
    }

    public List<MonitoringLingkungan>
            tampilkanMonitoringByLokasi(
                    int idLokasi) {

        getLokasiOrThrow(idLokasi);

        return monitoringRepository
                .findByLokasi(idLokasi);
    }

    private StatusDetail tentukanStatusDetail(
            ParameterLingkungan parameter,
            double nilai) {

        Double minimum =
                parameter.getBatasMinimum();

        Double maksimum =
                parameter.getBatasMaksimum();

        if (minimum != null
                && nilai < minimum) {

            return StatusDetail.PERINGATAN;
        }

        if (maksimum != null
                && nilai > maksimum) {

            return StatusDetail.PERINGATAN;
        }

        return StatusDetail.NORMAL;
    }

    private void hitungUlangStatusMonitoring(
            MonitoringLingkungan monitoring) {

        boolean adaPeringatan = false;

        for (DetailMonitoring detail :
                monitoring.getDetailMonitoring()) {

            if (detail.getStatusDetail()
                    == StatusDetail.PERINGATAN) {

                adaPeringatan = true;
                break;
            }
        }

        if (adaPeringatan) {

            monitoring.setStatusMonitoring(
                    StatusMonitoring.PERINGATAN
            );

            if (monitoring.getStatusPenanganan()
                    == StatusPenanganan.TIDAK_DIPERLUKAN) {

                monitoring.setStatusPenanganan(
                        StatusPenanganan.BELUM_DITANGANI
                );
            }

        } else {

            monitoring.setStatusMonitoring(
                    StatusMonitoring.NORMAL
            );

            monitoring.setTindakLanjut(null);

            monitoring.setStatusPenanganan(
                    StatusPenanganan.TIDAK_DIPERLUKAN
            );
        }
    }

    private void validasiPetugasHSE(
            PetugasHSE petugasHSE) {

        if (petugasHSE == null) {
            throw new ValidationException(
                    "Petugas HSE tidak tersedia."
            );
        }

        if (petugasHSE.getStatusPegawai()
                != StatusPegawai.AKTIF) {

            throw new ValidationException(
                    "Petugas HSE tidak aktif."
            );
        }

        if (!petugasHSE.isSertifikasiAktif(
                LocalDate.now())) {

            throw new ValidationException(
                    "Sertifikasi Petugas HSE sudah tidak berlaku."
            );
        }
    }

    private MonitoringLingkungan
            getMonitoringOrThrow(int idMonitoring) {

        Optional<MonitoringLingkungan> data =
                monitoringRepository
                .findById(idMonitoring);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Monitoring tidak ditemukan."
            );
        }

        return data.get();
    }

    private Lokasi getLokasiOrThrow(
            int idLokasi) {

        Optional<Lokasi> data =
                lokasiRepository.findById(idLokasi);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Lokasi tidak ditemukan."
            );
        }

        return data.get();
    }

    private ParameterLingkungan
            getParameterOrThrow(int idParameter) {

        Optional<ParameterLingkungan> data =
                parameterRepository
                .findById(idParameter);

        if (!data.isPresent()) {
            throw new DataNotFoundException(
                    "Parameter lingkungan tidak ditemukan."
            );
        }

        return data.get();
    }
}