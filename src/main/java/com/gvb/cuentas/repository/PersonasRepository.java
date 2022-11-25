
package com.gvb.cuentas.repository;

import com.gvb.cuentas.dto.PersonasDTO;
import com.gvb.cuentas.entities.Personas;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PersonasRepository extends CrudRepository<Personas, Integer> {
    
    @Transactional(readOnly = true)
    Optional<Personas> findByNombre(String nombre);
    
    public void save(PersonasDTO persona);
    
}
