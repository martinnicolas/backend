/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.controllers;

import io.swagger.annotations.Api;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.server.mvc.Viewable;

/**
 * 
 * @author martin
 */
@Api("IndexController")
@Path("index")
public class IndexController {
    @Context
    private HttpServletRequest request;
    
    @Context
    private HttpServletResponse response;
    
    @GET
    @Path("/index")
    @Produces(MediaType.TEXT_HTML)
    public Response index(){        
        return Response.ok(new Viewable("/views/index/index.jsp")).build();
    }
}
