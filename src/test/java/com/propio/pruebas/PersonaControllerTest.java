package com.propio.pruebas;

import com.propio.pruebas.controller.PersonaController;
import com.propio.pruebas.modelo.Persona;
import com.propio.pruebas.modelo.PersonaOutputDTO;
import com.propio.pruebas.servicios.PersonaServicio;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class PersonaControllerTest {

    @Mock
    PersonaServicio personaServicio;

    @InjectMocks
    PersonaController personaController;

    List<Persona> personas;

    @Before
    public void setUp(){
        Persona persona=new Persona();
        persona.setId_persona(1);
        persona.setCiudad("Logroño");
        persona.setNombre("Miguel");
        persona.setApellidos("Rodriguez");
        Persona persona2=new Persona();
        persona2.setId_persona(2);
        persona2.setCiudad("Madrid");
        persona2.setNombre("Pepe");
        persona2.setApellidos("Perez");
       /* personas=List.of(persona,persona2);
        Mockito.when(personaServicio.findAll()).thenReturn(personas);
        Mockito.when(personaServicio.findById(1)).thenReturn(Optional.of(persona));*/
    }

    @Test
    public void getPersonasTest(){

        ResponseEntity<?> response = personaController.getPersonas();
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals(personas,response.getBody());
    }

    @Test
    public void getByIdTest()throws Exception{
        Persona persona=personas.get(0);

        PersonaOutputDTO personaOutputDTO=new PersonaOutputDTO(persona);
        PersonaOutputDTO personaBuscada= personaController.getByID(1);
        Assertions.assertEquals(personaOutputDTO, personaBuscada);
    }

    @Test
    public void getByIdException(){
        Throwable exception = Assertions.assertThrows(Exception.class, () -> personaController.getByID(3));
        Assertions.assertEquals("No se encontró", exception.getMessage());
    }

}
