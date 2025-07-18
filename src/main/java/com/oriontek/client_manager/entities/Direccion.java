package com.oriontek.client_manager.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Direccion")
@Data
@NoArgsConstructor
public class Direccion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String direccionCompleta;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Cliente cliente;

    public Direccion(String direccion){
        this.direccionCompleta = direccion;
    }

}
