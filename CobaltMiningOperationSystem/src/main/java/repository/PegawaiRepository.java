/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.Pegawai;
import java.util.List;

/**
 *
 * @author zefrialrizkullah
 */

public interface PegawaiRepository extends CrudRepository<Pegawai> {
    List<Pegawai> findByNama(String nama);
    List<Pegawai> findByJenisPegawai(String jenisPegawai);
}

