package com.propio.pruebas;

import com.propio.pruebas.modelo.Persona;
import com.propio.pruebas.repositorio.PersonaRepository;
import com.propio.pruebas.servicios.PersonaServicio;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
public class PersonaServicioTest {

    @Mock
    PersonaRepository personaRepository;

    @InjectMocks
    PersonaServicio personaServicio;

    @Before
    public void setUp(){
        Persona persona=new Persona();
        persona.setId_persona(1);
        persona.setCiudad("Logroño");
        persona.setNombre("Miguel");
        persona.setApellidos("Rodriguez");

        Mockito.when(personaRepository.findById(100)).thenReturn(Optional.of(persona));
    }

    @Test
    public void pruebaFindById(){

        Optional<Persona> p = personaServicio.findById(100);
        Assertions.assertEquals(1, p.get().getId_persona());
        Assertions.assertEquals("Miguel", p.get().getNombre());
        Assertions.assertEquals("Logroño", p.get().getCiudad());
        Assertions.assertEquals("Rodriguez", p.get().getApellidos());

    }

}
