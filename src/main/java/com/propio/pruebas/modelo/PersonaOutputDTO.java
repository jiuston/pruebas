package com.propio.pruebas.modelo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaOutputDTO {

    private Integer id_persona;
    private String nombre;
    private String apellidos;
    private String ciudad;

    public PersonaOutputDTO(Persona persona){
        if (persona==null) return;
        this.setId_persona(persona.getId_persona());
        this.setNombre(persona.getNombre());
        this.setApellidos(persona.getApellidos());
        this.setCiudad(persona.getCiudad());


    }

}
