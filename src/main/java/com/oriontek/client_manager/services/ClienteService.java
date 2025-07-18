package com.oriontek.client_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oriontek.client_manager.entities.Cliente;
import com.oriontek.client_manager.entities.Direccion;
import com.oriontek.client_manager.repositories.ClienteRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {
    
    private final ClienteRepo clienteRepo;

    // Obtener todos los clientes
    public List<Cliente> getAllClients(){
        return clienteRepo.findAll();
    }

    // Obtener cliente por id
    public Optional<Cliente> getClient(Long id){
        return clienteRepo.findById(id);
    }

    // Crear nuevo cliente 
    public Cliente createClient(String name){
        Cliente nuevoCliente = new Cliente(name);

        return clienteRepo.save(nuevoCliente);
    }

    // Editar Cliente
    public Optional<Cliente> editClient(Long id, String name){
        Optional<Cliente> nuevoCliente = clienteRepo.findById(id);

        if(!nuevoCliente.isPresent()){
            return Optional.empty();
        }

        Cliente editedClient = nuevoCliente.get();
        editedClient.setNombre(name);
        return Optional.of(clienteRepo.save(editedClient));
    }

    public String deleteClient(Long id){
        clienteRepo.deleteById(id);
        return "Deleted client " + id;
    }

    public List<Direccion> getAllClientDirections(Long clientId){
        Optional<Cliente> nuevoCliente = clienteRepo.findById(clientId);

        if (!nuevoCliente.isPresent()) {
            return null;
        }

        return nuevoCliente.get().getDirecciones();
    }

    


}
