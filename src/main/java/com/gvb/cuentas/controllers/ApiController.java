
package com.gvb.cuentas.controllers;

import com.gvb.cuentas.dto.PersonaRequest;
import com.gvb.cuentas.services.interfaces.iPersonasServices;
import com.gvb.cuentas.utils.exeptions.ApiUnprocessableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import validator.UserValidatorImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/personas")
public class ApiController {
    
    @Autowired
    private iPersonasServices personaService;
    @Autowired
    private UserValidatorImpl userValidator;
    
    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index(){
        
        return ResponseEntity.ok(this.personaService.findAll());
    }
    
    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@RequestBody PersonaRequest request ) throws ApiUnprocessableEntity{
        
        this.userValidator.validator(request); //Aqui es donde le pasamos el request al metodo que acabamos de inyectar de validator
        this.personaService.save(request);      //El post es unicamnete para almacenar datos, no nos debe retornar nada
                
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
    @DeleteMapping(value = "/(id_persona)/delete")
    public ResponseEntity<Object> deletePersona(@PathVariable int id_persona){
        
        this.personaService.deleteById(id_persona);
        
      return ResponseEntity.ok(Boolean.TRUE);   
    }
    
    @PutMapping(value = "/(is_persona)/update")
    public ResponseEntity<Object> updatePersona(@RequestBody PersonaRequest request, @PathVariable int id_persona ){
        
        this.personaService.update(request, id_persona);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    
}
