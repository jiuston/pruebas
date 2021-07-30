package com.propio.pruebas.repositorio;

import com.propio.pruebas.modelo.Persona;
import com.propio.pruebas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


}
