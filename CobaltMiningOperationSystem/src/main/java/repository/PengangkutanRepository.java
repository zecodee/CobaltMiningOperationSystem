/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.Pengangkutan;

/**
 *
 * @author zefrialrizkullah
 */

public interface PengangkutanRepository extends CrudRepository<Pengangkutan> {
    List<Pengangkutan> findByProduksi(int idProduksi);
    List<Pengangkutan> findByKendaraan(int idKendaraan);
    List<Pengangkutan> findByDriver(int idDriver);
}
