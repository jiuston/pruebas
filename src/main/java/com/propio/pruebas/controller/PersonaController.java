package com.propio.pruebas.controller;

import com.propio.pruebas.modelo.Persona;
import com.propio.pruebas.modelo.PersonaInputDTO;
import com.propio.pruebas.modelo.PersonaOutputDTO;
import com.propio.pruebas.servicios.PersonaServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/personas")
@AllArgsConstructor
public class PersonaController {

    private PersonaServicio ps;

    @GetMapping("/{id}")
    public PersonaOutputDTO getByID(@PathVariable Integer id) throws Exception {
        Persona persona = ps.findById(id).orElseThrow(() -> new Exception("No se encontró"));
        return new PersonaOutputDTO(persona);
    }

    @GetMapping()
    public ResponseEntity<?> getPersonas(){
        return ResponseEntity.status(HttpStatus.OK).body(ps.findAll());
    }

    @PostMapping()
    public ResponseEntity<?> postPersonas(@RequestBody Persona persona){
        ps.save(persona);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<?> getPersonasFiltradas(@RequestBody PersonaInputDTO personaInputDTO){
        List<PersonaOutputDTO> personas=ps.search(personaInputDTO).stream().map(PersonaOutputDTO::new).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(personas);
    }


}
