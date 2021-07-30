package com.propio.pruebas.servicios;

import com.propio.pruebas.modelo.Persona;
import com.propio.pruebas.modelo.PersonaInputDTO;
import com.propio.pruebas.repositorio.PersonaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonaServicio {

    private PersonaRepository personaRepository;
    private EntityManager entityManager;

    public Optional<Persona> findById(int id){
        //Aquí iría la lógica de negocio
        //Por ejemplo, comprobar que la ID sea válida
        //O que los datos que nos lleguen se correspondan con lo que requerimos
        return personaRepository.findById(id);
    }

    public Optional<Persona> findByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }


    public List<Persona> findAll(){
        return personaRepository.findAll();
    }

    public void save(Persona persona){
        personaRepository.save(persona);
    }


    public List<Persona> search(PersonaInputDTO personaInputDTO) {
       List<Persona> personas;
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery=criteriaBuilder.createQuery(Persona.class);
        Root<Persona> root=criteriaQuery.from(Persona.class);
        List<Predicate> condiciones=new ArrayList<>();

        condiciones.add(criteriaBuilder.like(root.get("ciudad"), "%"+personaInputDTO.getCiudad()+"%"));
       criteriaQuery.select(root).where(condiciones.toArray(new Predicate[]{}));
       personas=entityManager.createQuery(criteriaQuery).getResultList();
       return personas;
    }

}
