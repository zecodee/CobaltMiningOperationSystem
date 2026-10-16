/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.MonitoringLingkungan;
import repository.MonitoringRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class MonitoringMemoryRepository
        implements MonitoringRepository {

    private final List<MonitoringLingkungan> data =
            new ArrayList<MonitoringLingkungan>();

    @Override
    public void save(MonitoringLingkungan monitoring) {
        if (monitoring == null) {
            throw new ValidationException(
                    "Data monitoring tidak boleh kosong."
            );
        }

        if (findById(monitoring.getIdMonitoring()).isPresent()) {
            throw new ValidationException(
                    "ID monitoring sudah digunakan."
            );
        }

        data.add(monitoring);
    }

    @Override
    public void update(MonitoringLingkungan monitoring) {
        if (monitoring == null) {
            throw new ValidationException(
                    "Data monitoring tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdMonitoring()
                    == monitoring.getIdMonitoring()) {

                data.set(i, monitoring);
                return;
            }
        }

        throw new DataNotFoundException(
                "Monitoring tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdMonitoring() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Monitoring tidak ditemukan."
        );
    }

    @Override
    public Optional<MonitoringLingkungan> findById(int id) {
        for (MonitoringLingkungan monitoring : data) {
            if (monitoring.getIdMonitoring() == id) {
                return Optional.of(monitoring);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<MonitoringLingkungan> findAll() {
        return new ArrayList<MonitoringLingkungan>(data);
    }

    @Override
    public List<MonitoringLingkungan> findByLokasi(
            int idLokasi) {

        List<MonitoringLingkungan> hasil =
                new ArrayList<MonitoringLingkungan>();

        for (MonitoringLingkungan monitoring : data) {
            if (monitoring.getLokasi() != null
                    && monitoring.getLokasi()
                    .getIdLokasi() == idLokasi) {

                hasil.add(monitoring);
            }
        }

        return hasil;
    }
}