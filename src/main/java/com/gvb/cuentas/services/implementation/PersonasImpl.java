
package com.gvb.cuentas.services.implementation;

import com.gvb.cuentas.dto.PersonaRequest;
import com.gvb.cuentas.dto.PersonasDTO;
import com.gvb.cuentas.entities.Personas;
import com.gvb.cuentas.repository.PersonasRepository;
import com.gvb.cuentas.services.interfaces.iPersonasServices;
import com.gvb.cuentas.utils.BCrypt;
import com.gvb.cuentas.utils.Helpers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PersonasImpl implements iPersonasServices{

    @Autowired
    private PersonasRepository personasRepository;
    
    
    @Override
    public List<PersonasDTO> findAll() {
        
        List<PersonasDTO> dto = new ArrayList<>();
        
        Iterable<Personas> personas = this.personasRepository.findAll();
        
        for(Personas persona : personas){
            PersonasDTO personasDTO;
            PersonasDTO PersonasDTO = personasDTO = Helpers.modelMapper().map(personas, PersonasDTO.class);
            
            dto.add(personasDTO);
                    
        }
        return dto;
    }

    @Override
    public PersonasDTO findByNombre(String nombre) {
        
        Optional<Personas> personas = this.personasRepository.findByNombre(nombre);
        
        if(!personas.isPresent()){
            return null;
        }
        return Helpers.modelMapper().map(personas.get(), PersonasDTO.class);
    }
    

    @Override
    public PersonasDTO findById(int id_personas) {

        Optional<Personas> personas = this.personasRepository.findById(id_personas);
        
        if(!personas.isPresent()){
            return null;
        }
        return Helpers.modelMapper().map(personas.get(), PersonasDTO.class);
    
        }

    @Override
    public void save(PersonaRequest persona) {

        Personas personas = Helpers.modelMapper().map(persona, Personas.class);
        
        //Encriptacion de contrasena 
        personas.setContrasena(BCrypt.hashpw(personas.getContrasena(), BCrypt.gensalt())); //Aqui se construye la contrasena
        
        this.personasRepository.save(personas);
    }

    
    @Override
    public void update (PersonaRequest request, int id_persona){
        Optional<Personas> personas = this.personasRepository.findById(id_persona);  //Estamos recibiendo como parametro el personas
        
        Personas persona  =  personas.get();
        persona.setNombre(request.getNombre());
        persona.setDireccion(request.getDireccion());
        persona.setContrasena(request.getContrasena());
        
        this.personasRepository.save(persona);
    }
    
    @Override
    public void saveAll(List<PersonaRequest> personas) {

        List<Personas> u = new ArrayList<>();
        for (PersonaRequest persona : personas){
            Personas us = Helpers.modelMapper().map(persona, Personas.class);
                    u.add(us);
        }
        this.personasRepository.saveAll(u);
        }

    @Override
    public void deleteById(int id_persona) {

        this.personasRepository.deleteById(id_persona);
    }
    
    private PersonasDTO convertToPersonasDTO(final Personas personas){
        return Helpers.modelMapper().map(personas, PersonasDTO.class);
    }
    
}
