
package com.gvb.cuentas.services.interfaces;

import com.gvb.cuentas.dto.PersonaRequest;
import com.gvb.cuentas.dto.PersonasDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface iPersonasServices {
    
    List<PersonasDTO> findAll();
        
        PersonasDTO findByNombre(String nombre);
        
        PersonasDTO findById (int id_personas);
        
        void save (PersonaRequest persona);
        
        void update (PersonaRequest persona, int id_persona);
        
        void saveAll(List<PersonaRequest> personas);
        
        void  deleteById (int persona_id);
        
        
        
}
    

