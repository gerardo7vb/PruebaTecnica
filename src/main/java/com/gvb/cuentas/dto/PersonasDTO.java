
package com.gvb.cuentas.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class PersonasDTO implements Serializable{
    
    private int id_personas;
    private String nombre;
    private String genero;
    private String edad;
    private String identificacion;
    private String direccion;
    private String telefono;
    
    
}
