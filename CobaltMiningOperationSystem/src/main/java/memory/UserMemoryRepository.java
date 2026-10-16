/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memory;

import exception.DataNotFoundException;
import exception.ValidationException;
import model.User;
import repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */

public class UserMemoryRepository
        implements UserRepository {

    private final List<User> data =
            new ArrayList<User>();

    @Override
    public void save(User user) {
        if (user == null) {
            throw new ValidationException(
                    "Data User tidak boleh kosong."
            );
        }

        if (findById(user.getIdUser()).isPresent()) {
            throw new ValidationException(
                    "ID User sudah digunakan."
            );
        }

        if (user.getUsername() != null
                && findByUsername(user.getUsername()).isPresent()) {

            throw new ValidationException(
                    "Username sudah digunakan."
            );
        }

        data.add(user);
    }

    @Override
    public void update(User user) {
        if (user == null) {
            throw new ValidationException(
                    "Data User tidak boleh kosong."
            );
        }

        for (User existing : data) {
            if (existing.getIdUser() != user.getIdUser()
                    && existing.getUsername() != null
                    && user.getUsername() != null
                    && existing.getUsername()
                    .equalsIgnoreCase(user.getUsername())) {

                throw new ValidationException(
                        "Username sudah digunakan."
                );
            }
        }

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdUser() == user.getIdUser()) {
                data.set(i, user);
                return;
            }
        }

        throw new DataNotFoundException(
                "User tidak ditemukan."
        );
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getIdUser() == id) {
                data.remove(i);
                return;
            }
        }

        throw new DataNotFoundException(
                "User tidak ditemukan."
        );
    }

    @Override
    public Optional<User> findById(int id) {
        for (User user : data) {
            if (user.getIdUser() == id) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(data);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        if (username == null) {
            return Optional.empty();
        }

        for (User user : data) {
            if (user.getUsername() != null
                    && user.getUsername()
                    .equalsIgnoreCase(username.trim())) {

                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}