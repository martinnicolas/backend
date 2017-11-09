/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author martin
 */
@Table("persona")
public class Personas extends Model{
    
    public int getDni(){
        return this.getInteger("dni");
    }
    
    public String getApellido(){
        return this.getString("apellido");
    }    
    
    public String getNombre(){
        return this.getString("nombre");
    }    
    
}
