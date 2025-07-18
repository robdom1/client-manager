package com.oriontek.client_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oriontek.client_manager.entities.Direccion;
import java.util.List;


public interface DireccionRepo extends JpaRepository<Direccion, Long>{
    
    List<Direccion> findByClienteid(long id);
}
