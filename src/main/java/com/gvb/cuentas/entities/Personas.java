
package com.gvb.cuentas.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "personas")
public class Personas implements Serializable{
    
    @Id
    @Column (name = "id_personas")
    private int id_persona;
     @Column (name = "nombre")
    private String nombre;
    @Column (name = "genero")
    private String genero;
    @Column (name = "edad")
    private int edad;
    @Column (name = "identificacion")
    private String identificacion;
    @Column (name = "direccion")
    private String direccion;
    @Column (name = "telefono")
    private String telefono;
    @Column (name = "contrasena")
    private String contrasena;
     
    
}
