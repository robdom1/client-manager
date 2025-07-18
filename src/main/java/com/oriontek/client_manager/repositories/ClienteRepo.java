package com.oriontek.client_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oriontek.client_manager.entities.Cliente;

public interface ClienteRepo extends JpaRepository<Cliente, Long> {
    
}
