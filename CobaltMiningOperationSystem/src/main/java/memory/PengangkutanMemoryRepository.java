/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.Pengangkutan;
import repository.PengangkutanRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class PengangkutanMemoryRepository
        implements PengangkutanRepository {

    private final List<Pengangkutan> data =
            new ArrayList<Pengangkutan>();

    @Override
    public void save(Pengangkutan pengangkutan) {
        if (pengangkutan == null) {
            throw new ValidationException(
                    "Data pengangkutan tidak boleh kosong."
            );
        }

        if (findById(
                pengangkutan.getIdPengangkutan()).isPresent()) {

            throw new ValidationException(
                    "ID pengangkutan sudah digunakan."
            );
        }

        data.add(pengangkutan);
    }

    @Override
    public void update(Pengangkutan pengangkutan) {
        if (pengangkutan == null) {
            throw new ValidationException(
                    "Data pengangkutan tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdPengangkutan()
                    == pengangkutan.getIdPengangkutan()) {

                data.set(i, pengangkutan);
                return;
            }
        }

        throw new DataNotFoundException(
                "Pengangkutan tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdPengangkutan() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Pengangkutan tidak ditemukan."
        );
    }

    @Override
    public Optional<Pengangkutan> findById(int id) {
        for (Pengangkutan pengangkutan : data) {
            if (pengangkutan.getIdPengangkutan() == id) {
                return Optional.of(pengangkutan);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<Pengangkutan> findAll() {
        return new ArrayList<Pengangkutan>(data);
    }

    @Override
    public List<Pengangkutan> findByProduksi(int idProduksi) {
        List<Pengangkutan> hasil =
                new ArrayList<Pengangkutan>();

        for (Pengangkutan pengangkutan : data) {
            if (pengangkutan.getProduksi() != null
                    && pengangkutan.getProduksi()
                    .getIdProduksi() == idProduksi) {

                hasil.add(pengangkutan);
            }
        }

        return hasil;
    }
}