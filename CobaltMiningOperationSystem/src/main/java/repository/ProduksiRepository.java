/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.ProduksiTambang;

/**
 *
 * @author zefrialrizkullah
 */

public interface ProduksiRepository extends CrudRepository<ProduksiTambang> {
    List<ProduksiTambang> findTersedia();
}
