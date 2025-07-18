package com.oriontek.client_manager.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oriontek.client_manager.entities.Address;
import com.oriontek.client_manager.services.AddressService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/client/{clientId}/address")
@RequiredArgsConstructor
public class AddressClientController {
    
    private final AddressService addressService;

    @GetMapping
    public List<Address> getAddresses(@PathVariable Long clientId) {
        return addressService.getAllAddressesByClient(clientId);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<Address> getAddressByClient(@PathVariable Long clientId, @PathVariable Long addressId) {
        return addressService.getAddressByClient(clientId, addressId);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@PathVariable Long clientId, @RequestBody Address address) {
        return addressService.createAddress(address, clientId);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long clientId, @PathVariable Long addressId, @RequestBody Address newAddress) {
        return addressService.updateAddress(newAddress, addressId);
    }

    @DeleteMapping("/{addressId}")
    public String deleteAddress(@PathVariable Long addressId){
        return addressService.deleteAddress(addressId);
    }

}
