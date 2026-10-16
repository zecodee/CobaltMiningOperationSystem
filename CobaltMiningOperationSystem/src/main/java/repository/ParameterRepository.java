/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.ParameterLingkungan;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public interface ParameterRepository extends CrudRepository<ParameterLingkungan> {
    List<ParameterLingkungan> findByNama(String nama);
}