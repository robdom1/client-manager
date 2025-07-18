package com.oriontek.client_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.oriontek.client_manager.entities.Cliente;
import com.oriontek.client_manager.entities.Direccion;
import com.oriontek.client_manager.repositories.DireccionRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DireccionService {

    private final DireccionRepo direccionRepo;
    private final ClienteService clienteService;

    public List<Direccion> getAllDirections(){
        return direccionRepo.findAll();
    }

    public Optional<Direccion> getDirection(Long id){
        return direccionRepo.findById(id);
    }

    public List<Direccion> getAllDirectionByClient(Long clientId){
        return direccionRepo.findByClienteid(clientId);
    }

    public Cliente getClientByDirection(Long id){
        Optional<Direccion> fetchedDir = getDirection(id);

        if(!fetchedDir.isPresent()){
            return null;
        }

        return fetchedDir.get().getCliente();
    }


    public Direccion createDirection(String direccion, Long clientId){
        Optional<Cliente> nuevoCliente = clienteService.getClient(clientId);

        if (!nuevoCliente.isPresent()) {
            return null;
        }

        Direccion newDirection = new Direccion(direccion);
        newDirection.setCliente(nuevoCliente.get());

        return direccionRepo.save(newDirection);
    }

    public Optional<Direccion> editDirection(String direccionStr, Long id){
        Optional<Direccion> direccion = getDirection(id);

        if(!direccion.isPresent()){
            return Optional.empty();
        }

        Direccion editedDireccion = direccion.get();
        editedDireccion.setDireccionCompleta(direccionStr);
        return Optional.of(direccionRepo.save(editedDireccion));

    }

    public String deleteDirection(Long id){
        direccionRepo.deleteById(id);
        return "Deleted direction " + id;
    }


}
