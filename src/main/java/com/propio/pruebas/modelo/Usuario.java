package com.propio.pruebas.modelo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Usuario {
    @Id
    private int id_usuario;

    private String nombre;
    private String clave;

}
