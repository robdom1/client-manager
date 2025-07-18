package com.oriontek.client_manager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.oriontek.client_manager.entities.Client;
import com.oriontek.client_manager.entities.Address;
import com.oriontek.client_manager.repositories.AddressRepo;
import com.oriontek.client_manager.repositories.ClientRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepo addressRepo;
    private final ClientRepo clientRepo;


    // Obtener todas las direcciones de un cliente
    public List<Address> getAllAddressesByClient(Long clientId){
        return addressRepo.findByClientId(clientId);
    }

    // Obtener una direccion de un cliente
    public ResponseEntity<Address> getAddressByClient(Long clientId, Long addressId){
        Optional<Address> foundAddress = addressRepo.findByIdAndClientId(addressId, clientId);

        if(foundAddress.isPresent()){
            return ResponseEntity.ok(foundAddress.get());
        }

        return ResponseEntity.notFound().build();
    }

    // Crear una direccion para un cliente
    public ResponseEntity<Address> createAddress(Address address, Long clientId){
        Optional<Client> client = clientRepo.findById(clientId);

        if (client.isPresent()) {
            address.setClient(client.get());
            return ResponseEntity.ok(addressRepo.save(address));
        }

        return ResponseEntity.notFound().build();
    }

    // Actualizar una direccion
    public ResponseEntity<Address> updateAddress(Address newAddress, Long id){
        Optional<Address> oldAddress = addressRepo.findById(id);

        if(oldAddress.isPresent()){
            Address editedAddress = oldAddress.get();
            editedAddress.setStreet(newAddress.getStreet());
            editedAddress.setCity(newAddress.getCity());
            editedAddress.setCountry(newAddress.getCountry());

            return ResponseEntity.ok(addressRepo.save(editedAddress));
        }

        return ResponseEntity.notFound().build();

    }

    // Eliminar una direccion
    public String deleteAddress(Long id){
        addressRepo.deleteById(id);
        return "Deleted address " + id;
    }

    // Obtener todas las direcciones
    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public ResponseEntity<Address> getAddressById(Long addressId) {
        Optional<Address> address = addressRepo.findById(addressId);

        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }

        return ResponseEntity.notFound().build();
    }


}
