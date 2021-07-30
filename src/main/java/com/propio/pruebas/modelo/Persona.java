package com.propio.pruebas.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Random;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_persona;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "ciudad")
    private String ciudad;



    public Persona(String nombre, String apellidos,String ciudad){
        this.id_persona = new Random().nextInt();
        this.ciudad=ciudad;
        this.nombre=nombre;
        this.apellidos=apellidos;
    }
    public Persona(String id_persona,String nombre, String apellidos,String ciudad){
        this.id_persona =Integer.valueOf(id_persona);
        this.ciudad=ciudad;
        this.nombre=nombre;
        this.apellidos=apellidos;
    }

}
