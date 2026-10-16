/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.Optional;
import model.Kendaraan;

/**
 *
 * @author zefrialrizkullah
 */

public interface KendaraanRepository extends CrudRepository<Kendaraan> {
    Optional<Kendaraan> findByNomorPolisi(String nomorPolisi);
}
