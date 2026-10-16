/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.ParameterLingkungan;
import repository.ParameterRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class ParameterMemoryRepository
        implements ParameterRepository {

    private final List<ParameterLingkungan> data =
            new ArrayList<ParameterLingkungan>();

    @Override
    public void save(ParameterLingkungan parameter) {
        if (parameter == null) {
            throw new ValidationException(
                    "Data parameter tidak boleh kosong."
            );
        }

        if (findById(parameter.getIdParameter()).isPresent()) {
            throw new ValidationException(
                    "ID parameter sudah digunakan."
            );
        }

        data.add(parameter);
    }

    @Override
    public void update(ParameterLingkungan parameter) {
        if (parameter == null) {
            throw new ValidationException(
                    "Data parameter tidak boleh kosong."
            );
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdParameter()
                    == parameter.getIdParameter()) {

                data.set(i, parameter);
                return;
            }
        }

        throw new DataNotFoundException(
                "Parameter lingkungan tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdParameter() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "Parameter lingkungan tidak ditemukan."
        );
    }

    @Override
    public Optional<ParameterLingkungan> findById(int id) {
        for (ParameterLingkungan parameter : data) {
            if (parameter.getIdParameter() == id) {
                return Optional.of(parameter);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<ParameterLingkungan> findAll() {
        return new ArrayList<ParameterLingkungan>(data);
    }

    @Override
    public List<ParameterLingkungan> findByNama(String nama) {
        List<ParameterLingkungan> hasil =
                new ArrayList<ParameterLingkungan>();

        if (nama == null) {
            return hasil;
        }

        String keyword = nama.trim().toLowerCase();

        for (ParameterLingkungan parameter : data) {
            if (parameter.getNamaParameter() != null
                    && parameter.getNamaParameter()
                    .toLowerCase()
                    .contains(keyword)) {

                hasil.add(parameter);
            }
        }

        return hasil;
    }
}