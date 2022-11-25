/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import com.gvb.cuentas.dto.PersonaRequest;
import com.gvb.cuentas.utils.exeptions.ApiUnprocessableEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author rareg
 */
@Component
public class UserValidatorImpl implements UserValidator{

    @Override
    public void validator(PersonaRequest request) throws ApiUnprocessableEntity {

        
        if(request.getNombre() == null || request.getNombre().isEmpty()){
            message("El nombre es obligatorio");
        }
        if(request.getNombre().length()<5){
            message("El nombre es muy corto, debe tener minimo 10 caracteres");
            
        }
    }
    
    private void message(String message) throws ApiUnprocessableEntity{
        
        throw new ApiUnprocessableEntity(message);
        
    }
    
}
