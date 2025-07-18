package com.oriontek.client_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oriontek.client_manager.entities.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
    
}
