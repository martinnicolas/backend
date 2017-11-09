/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.helpers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author martin
 */
public class URLHelper {
    
    public static Response redirect(String url){
        ResponseBuilder builder = null;
        try {
            builder = Response.seeOther(new URI(url));
        } catch (URISyntaxException ex) {
            Logger.getLogger(URLHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.build();
    }
    
}
