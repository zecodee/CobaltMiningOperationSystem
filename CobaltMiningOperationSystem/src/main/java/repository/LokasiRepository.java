/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Lokasi;

/**
 *
 * @author zefrialrizkullah
 */

public interface LokasiRepository extends CrudRepository<Lokasi> {
    List<Lokasi> findByNama(String nama);
}