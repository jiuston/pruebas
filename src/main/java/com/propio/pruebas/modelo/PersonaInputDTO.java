package com.propio.pruebas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class PersonaInputDTO {

    private Integer id_persona;
    private String nombre;
    private String apellidos;
    private String ciudad;
}
