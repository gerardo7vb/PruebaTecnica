
package com.gvb.cuentas.utils.exeptions;

import org.springframework.http.HttpStatus; 
import org.springframework.web.bind.annotation.ResponseStatus;

 @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class ApiUnprocessableEntity extends Exception  {
    //En esta clase vamos a manejar todas nuestras Exepciones
    //Este se conoce como el codigo 422, que es el UnprocessableEntity, lo que indica es que le entidad que se esta recibiendo
     //no es la correcta
     //Excepcion personalisada de estatus 422
   
    public ApiUnprocessableEntity(String message){
        super(message);
    }
    
}
