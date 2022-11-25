
package com.gvb.cuentas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class PersonaRequest implements Serializable {
    
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("contrasena")
    private String contrasena;
    @JsonProperty("estado")
    private String estado;
    
}
