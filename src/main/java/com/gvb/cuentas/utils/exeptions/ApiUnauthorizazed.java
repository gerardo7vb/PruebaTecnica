/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gvb.cuentas.utils.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *Excepcion personalizada del status 401
 * @author rareg
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ApiUnauthorizazed extends Exception{
    
    public ApiUnauthorizazed (String message){
        super(message);
    }
    
}
