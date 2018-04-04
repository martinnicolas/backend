/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.controllers;

import com.martin.backend.db.DB;
import com.martin.backend.models.Personas;
import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.javalite.activejdbc.Base;
import org.javalite.activejdbc.LazyList;

/**
 * Resource class para obtener servicios relacionados con los datos de las
 * Personas
 * 
 * @author martin
 */
@Api("PersonasController")
@Path("personas")
public class PersonasController {
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public String index(){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        LazyList<Personas> personas = Personas.findAll();
        return personas.toJson(true);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String show(@PathParam("id") Integer id){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = Personas.findFirst("id = ?", id);        
        return persona.toJson(true);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public String update(@PathParam("id") Integer id,
            @FormParam("dni") Integer dni, 
            @FormParam("apellido") String apellido,
            @FormParam("nombre") String nombre){        
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = Personas.findFirst("id = ?", id);        
        persona.setInteger("dni", dni);
        persona.setString("apellido", apellido);
        persona.setString("nombre", nombre);
        persona.saveIt();
        return persona.toJson(true);
    }
    
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String destroy(@PathParam("id") Integer id){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = Personas.findFirst("id = ?", id);        
        persona.delete();        
        return persona.getId().toString();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String create(
            @FormParam("dni") Integer dni, 
            @FormParam("apellido") String apellido,
            @FormParam("nombre") String nombre){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = new Personas();
        persona.setInteger("dni", dni);
        persona.setString("apellido", apellido);
        persona.setString("nombre", nombre);
        persona.saveIt();
        return persona.toJson(true);
    }
    
}
