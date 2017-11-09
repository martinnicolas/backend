/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.app;

import com.martin.backend.controllers.PersonasController;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;
import org.glassfish.jersey.servlet.ServletProperties;

/**
 * Clase utilizada para la configuración de los resources
 * 
 * @author martin
 */
public class App extends ResourceConfig{

    public App(){
        //Resources
        packages(PersonasController.class.getPackage().getName());        
        //MVC
        register(JspMvcFeature.class);
        //Bootstrap y demás contenido estatico
        property(ServletProperties.FILTER_STATIC_CONTENT_REGEX, "(/assets/.*)|(/api-doc/.*)");
        //Swagger
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
    }   
    
}
