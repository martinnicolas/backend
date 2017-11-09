/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.controllers;

import com.martin.backend.db.DBFilter;
import com.martin.backend.helpers.URLHelper;
import com.martin.backend.models.Personas;
import io.swagger.annotations.Api;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebFilter;
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
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;
import org.javalite.activejdbc.Base;

/**
 *
 * @author martin
 */
@Api("PersonasController")
@Path("personas")
public class PersonasController {
    
    @Context
    private HttpServletRequest request;
    
    @Context
    private HttpServletResponse response;

    @GET
    @Path("/index")
    @Produces(MediaType.TEXT_HTML)
    public Response index(){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        List<Personas> personas = Personas.findAll();
        Map<String, Object> map = new HashMap<>();
        map.put("personas",personas);                
        return Response.ok(new Viewable("/views/personas/index.jsp",map)).build();
    }
    
    @GET
    @Path("/show/{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response show(@PathParam("id") Integer id){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = Personas.findFirst("id = ?", id);        
        Map<String, Object> map = new HashMap<>();
        map.put("persona",persona);                
        return Response.ok(new Viewable("/views/personas/show.jsp", map)).build();
    }
    
    @GET
    @Path("/new")
    @Produces(MediaType.TEXT_HTML)
    public Response add(){
        return Response.ok(new Viewable("/views/personas/add.jsp")).build();
    }
    
    @GET
    @Path("/edit/{id}")
    @Produces(MediaType.TEXT_HTML)
    public Response edit(@PathParam("id") Integer id){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = Personas.findFirst("id = ?", id);        
        Map<String, Object> map = new HashMap<>();
        map.put("persona",persona);
        return Response.ok(new Viewable("/views/personas/edit.jsp", map)).build();
    }
    
    @POST
    @Path("/update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id,
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
        return URLHelper.redirect("personas/show/"+id.toString());
    }
    
    @GET
    @Path("/destroy/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response destroy(@PathParam("id") Integer id){
        //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/alq", "root", "chacho77");
        Base.open("org.postgresql.Driver", "jdbc:postgresql://localhost/base", "postgres", "chacho77");
        Personas persona = Personas.findFirst("id = ?", id);        
        persona.delete();        
        return URLHelper.redirect("personas/index");
    }
    
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(
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
        return URLHelper.redirect("personas/index");
    }
    
}
