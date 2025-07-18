package com.oriontek.client_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oriontek.client_manager.entities.Client;
import com.oriontek.client_manager.repositories.ClientRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepo clientRepo;

    // Obtener todos los clientes
    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }

    // Obtener cliente por id
    public ResponseEntity<Client> getClient(Long id){
        Optional<Client> client = clientRepo.findById(id);

        if(client.isPresent()){
            return ResponseEntity.ok(client.get());
        }

        return ResponseEntity.notFound().build();

    }

    // Crear un nuevo cliente 
    public Client createClient(Client newClient){
        return clientRepo.save(newClient);
    }

    // Actualizar un cliente
    public ResponseEntity<Client> updateClient(Long id, Client newClient){
        Optional<Client> oldClient = clientRepo.findById(id);

        if(oldClient.isPresent()){
            Client editedClient = oldClient.get();
            editedClient.setFirstName(newClient.getFirstName());
            editedClient.setLastName(newClient.getLastName());
            editedClient.setDateOfBirth(newClient.getDateOfBirth());
            editedClient.setEmail(newClient.getEmail());
            editedClient.setPhoneNumber(newClient.getPhoneNumber());

            return ResponseEntity.ok(clientRepo.save(editedClient));
        }

        return ResponseEntity.notFound().build();
    }

    // Eliminar un cliente
    public String deleteClient(Long id){
        clientRepo.deleteById(id);
        return "Deleted client " + id;
    }

}
