/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import model.MonitoringLingkungan;

/**
 *
 * @author zefrialrizkullah
 */

public interface MonitoringRepository extends CrudRepository<MonitoringLingkungan> {
    List<MonitoringLingkungan> findByLokasi(int idLokasi);
    List<MonitoringLingkungan> findByPetugasHSE(int idPegawai);
}
