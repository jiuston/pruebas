package com.propio.pruebas.repositorio;

import com.propio.pruebas.modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByNombre(String nombre);
}
