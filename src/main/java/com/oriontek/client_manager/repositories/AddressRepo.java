package com.oriontek.client_manager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oriontek.client_manager.entities.Address;
import java.util.List;
import java.util.Optional;


public interface AddressRepo extends JpaRepository<Address, Long>{
    
    List<Address> findByClientId(long id);
    Optional<Address> findByIdAndClientId(long id, long clientId);
}
