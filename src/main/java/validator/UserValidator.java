/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package validator;

import com.gvb.cuentas.dto.PersonaRequest;
import com.gvb.cuentas.utils.exeptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Service;

/**
 *interface para la validacion de datos recibidos para la creacion de personas.
 * @author rareg
 */
@Service
public interface UserValidator {
    
    void validator(PersonaRequest request) throws ApiUnprocessableEntity;
    //La sentencia throw se utiliza para lanzar explícitamente una excepción
}
