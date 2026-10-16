/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.Lokasi;
import repository.LokasiRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class LokasiMemoryRepository implements LokasiRepository {

    private final List<Lokasi> data = new ArrayList<Lokasi>();

    @Override
    public void save(Lokasi lokasi) {
        if (lokasi == null) {
            throw new ValidationException(
                    "Data lokasi tidak boleh kosong."
            );
        }

        if (findById(lokasi.getIdLokasi()).isPresent()) {
            throw new ValidationException(
                    "ID lokasi sudah digunakan."
            );
        }

        data.add(lokasi);
    }

    @Override
    public void update(Lokasi lokasi) {
        if (lokasi == null) {
            throw new ValidationException(
                    "Data lokasi tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdLokasi() == lokasi.getIdLokasi()) {
                data.set(i, lokasi);
                return;
            }
        }

        throw new DataNotFoundException(
                "Lokasi tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdLokasi() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Lokasi tidak ditemukan."
        );
    }

    @Override
    public Optional<Lokasi> findById(int id) {
        for (Lokasi lokasi : data) {
            if (lokasi.getIdLokasi() == id) {
                return Optional.of(lokasi);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Lokasi> findAll() {
        return new ArrayList<Lokasi>(data);
    }

    @Override
    public List<Lokasi> findByNama(String nama) {
        List<Lokasi> hasil = new ArrayList<Lokasi>();

        if (nama == null) {
            return hasil;
        }

        String keyword = nama.trim().toLowerCase();

        for (Lokasi lokasi : data) {
            if (lokasi.getNamaLokasi() != null
                    && lokasi.getNamaLokasi()
                    .toLowerCase()
                    .contains(keyword)) {

                hasil.add(lokasi);
            }
        }

        return hasil;
    }
}