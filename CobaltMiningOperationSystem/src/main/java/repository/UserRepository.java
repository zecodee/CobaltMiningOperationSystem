/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Optional;
import model.User;

/**
 *
 * @author zefrialrizkullah
 */

public interface UserRepository extends CrudRepository<User> {
    Optional<User> findByUsername(String username);
    Optional<User> findByPegawai(int idPegawai);
}
