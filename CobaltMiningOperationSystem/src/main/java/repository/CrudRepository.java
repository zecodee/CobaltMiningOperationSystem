/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author zefrialrizkullah
 */
 
public interface CrudRepository<T> {
    void save(T data);
    void update(T data);
    void delete(int id);
    Optional<T> findById(int id);
    List<T> findAll();
}