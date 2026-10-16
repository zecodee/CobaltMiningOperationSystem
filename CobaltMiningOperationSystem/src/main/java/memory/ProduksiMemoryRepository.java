/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import enums.StatusProduksi;
import exception.DataNotFoundException;
import exception.ValidationException;
import model.ProduksiTambang;
import repository.ProduksiRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class ProduksiMemoryRepository
        implements ProduksiRepository {

    private final List<ProduksiTambang> data =
            new ArrayList<ProduksiTambang>();

    @Override
    public void save(ProduksiTambang produksi) {
        if (produksi == null) {
            throw new ValidationException(
                    "Data produksi tidak boleh kosong."
            );
        }

        if (findById(produksi.getIdProduksi()).isPresent()) {
            throw new ValidationException(
                    "ID produksi sudah digunakan."
            );
        }

        data.add(produksi);
    }

    @Override
    public void update(ProduksiTambang produksi) {
        if (produksi == null) {
            throw new ValidationException(
                    "Data produksi tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdProduksi()
                    == produksi.getIdProduksi()) {

                data.set(i, produksi);
                return;
            }
        }

        throw new DataNotFoundException(
                "Produksi tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdProduksi() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Produksi tidak ditemukan."
        );
    }

    @Override
    public Optional<ProduksiTambang> findById(int id) {
        for (ProduksiTambang produksi : data) {
            if (produksi.getIdProduksi() == id) {
                return Optional.of(produksi);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<ProduksiTambang> findAll() {
        return new ArrayList<ProduksiTambang>(data);
    }

    @Override
    public List<ProduksiTambang> findTersedia() {
        List<ProduksiTambang> hasil =
                new ArrayList<ProduksiTambang>();

        for (ProduksiTambang produksi : data) {
            if (produksi.getStatusProduksi()
                    != StatusProduksi.HABIS
                    && produksi.getJumlahTersedia() > 0) {

                hasil.add(produksi);
            }
        }

        return hasil;
    }
}