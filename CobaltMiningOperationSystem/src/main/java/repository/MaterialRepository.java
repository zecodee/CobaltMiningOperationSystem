/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.JenisMaterial;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public interface MaterialRepository extends CrudRepository<JenisMaterial> {
    List<JenisMaterial> findByNama(String nama);
}
