/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.Pegawai;
import repository.PegawaiRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class PegawaiMemoryRepository
        implements PegawaiRepository {

    private final List<Pegawai> data =
            new ArrayList<Pegawai>();

    @Override
    public void save(Pegawai pegawai) {
        if (pegawai == null) {
            throw new ValidationException(
                    "Data pegawai tidak boleh kosong."
            );
        }

        if (findById(pegawai.getIdPegawai()).isPresent()) {
            throw new ValidationException(
                    "ID pegawai sudah digunakan."
            );
        }

        data.add(pegawai);
    }

    @Override
    public void update(Pegawai pegawai) {
        if (pegawai == null) {
            throw new ValidationException(
                    "Data pegawai tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdPegawai()
                    == pegawai.getIdPegawai()) {

                data.set(i, pegawai);
                return;
            }
        }

        throw new DataNotFoundException(
                "Pegawai tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdPegawai() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Pegawai tidak ditemukan."
        );
    }

    @Override
    public Optional<Pegawai> findById(int id) {
        for (Pegawai pegawai : data) {
            if (pegawai.getIdPegawai() == id) {
                return Optional.of(pegawai);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Pegawai> findAll() {
        return new ArrayList<Pegawai>(data);
    }

    @Override
    public List<Pegawai> findByNama(String nama) {
        List<Pegawai> hasil =
                new ArrayList<Pegawai>();

        if (nama == null) {
            return hasil;
        }

        String keyword = nama.trim().toLowerCase();

        for (Pegawai pegawai : data) {
            if (pegawai.getNamaPegawai() != null
                    && pegawai.getNamaPegawai()
                    .toLowerCase()
                    .contains(keyword)) {

                hasil.add(pegawai);
            }
        }

        return hasil;
    }
}