/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.Kendaraan;
import repository.KendaraanRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class KendaraanMemoryRepository implements KendaraanRepository {

    private final List<Kendaraan> data = new ArrayList<Kendaraan>();

    @Override
    public void save(Kendaraan kendaraan) {
        if (kendaraan == null) {
            throw new ValidationException("Data kendaraan tidak boleh kosong.");
        }

        if (findById(kendaraan.getIdKendaraan()).isPresent()) {
            throw new ValidationException("ID kendaraan sudah digunakan.");
        }

        if (kendaraan.getNomorPolisi() != null
                && findByNomorPolisi(kendaraan.getNomorPolisi()).isPresent()) {
            throw new ValidationException("Nomor polisi sudah digunakan.");
        }

        data.add(kendaraan);
    }

    @Override
    public void update(Kendaraan kendaraan) {
        if (kendaraan == null) {
            throw new ValidationException("Data kendaraan tidak boleh kosong.");
        }

        for (Kendaraan existing : data) {
            if (existing.getIdKendaraan() != kendaraan.getIdKendaraan()
                    && existing.getNomorPolisi() != null
                    && kendaraan.getNomorPolisi() != null
                    && existing.getNomorPolisi()
                    .equalsIgnoreCase(kendaraan.getNomorPolisi())) {

                throw new ValidationException(
                        "Nomor polisi sudah digunakan."
                );
            }
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdKendaraan()
                    == kendaraan.getIdKendaraan()) {

                data.set(i, kendaraan);
                return;
            }
        }

        throw new DataNotFoundException("Kendaraan tidak ditemukan.");
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdKendaraan() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException("Kendaraan tidak ditemukan.");
    }

    @Override
    public Optional<Kendaraan> findById(int id) {
        for (Kendaraan kendaraan : data) {
            if (kendaraan.getIdKendaraan() == id) {
                return Optional.of(kendaraan);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Kendaraan> findAll() {
        return new ArrayList<Kendaraan>(data);
    }

    @Override
    public Optional<Kendaraan> findByNomorPolisi(String nomorPolisi) {
        if (nomorPolisi == null) {
            return Optional.empty();
        }

        for (Kendaraan kendaraan : data) {
            if (kendaraan.getNomorPolisi() != null
                    && kendaraan.getNomorPolisi()
                    .equalsIgnoreCase(nomorPolisi)) {

                return Optional.of(kendaraan);
            }
        }

        return Optional.empty();
    }
}