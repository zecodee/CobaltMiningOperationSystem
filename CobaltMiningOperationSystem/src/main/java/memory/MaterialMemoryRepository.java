/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.JenisMaterial;
import repository.MaterialRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class MaterialMemoryRepository implements MaterialRepository {

    private final List<JenisMaterial> data =
            new ArrayList<JenisMaterial>();

    @Override
    public void save(JenisMaterial material) {
        if (material == null) {
            throw new ValidationException(
                    "Data material tidak boleh kosong."
            );
        }

        if (findById(material.getIdMaterial()).isPresent()) {
            throw new ValidationException(
                    "ID material sudah digunakan."
            );
        }

        data.add(material);
    }

    @Override
    public void update(JenisMaterial material) {
        if (material == null) {
            throw new ValidationException(
                    "Data material tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdMaterial()
                    == material.getIdMaterial()) {

                data.set(i, material);
                return;
            }
        }

        throw new DataNotFoundException(
                "Material tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdMaterial() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Material tidak ditemukan."
        );
    }

    @Override
    public Optional<JenisMaterial> findById(int id) {
        for (JenisMaterial material : data) {
            if (material.getIdMaterial() == id) {
                return Optional.of(material);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<JenisMaterial> findAll() {
        return new ArrayList<JenisMaterial>(data);
    }

    @Override
    public List<JenisMaterial> findByNama(String nama) {
        List<JenisMaterial> hasil =
                new ArrayList<JenisMaterial>();

        if (nama == null) {
            return hasil;
        }

        String keyword = nama.trim().toLowerCase();

        for (JenisMaterial material : data) {
            if (material.getNamaMaterial() != null
                    && material.getNamaMaterial()
                    .toLowerCase()
                    .contains(keyword)) {

                hasil.add(material);
            }
        }

        return hasil;
    }
}