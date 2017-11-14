/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martin.backend.db;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.javalite.activejdbc.Base;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase para Establecer la Conexion a la Base de datos
 * 
 * @author martin
 */
public class DBFilter implements Filter{
    private static final Logger LOGGER = LoggerFactory.getLogger(DBFilter.class);

    private String jndiName;

    @Override
    public void init(FilterConfig config) throws ServletException {

        jndiName = config.getInitParameter("jndiName");
        if(jndiName == null)
            throw new IllegalArgumentException("must provide jndiName parameter for this filter");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        long before = System.currentTimeMillis();
        try{
            Base.open(jndiName);
            Base.openTransaction();
            chain.doFilter(req, resp);
            Base.commitTransaction();
        }
        catch (IOException e){
            Base.rollbackTransaction();
            throw e;
        }
        catch (ServletException e){
            Base.rollbackTransaction();
            throw e;
        }
        finally{

            Base.close();
        }
        LOGGER.info("Processing took: {} milliseconds", System.currentTimeMillis() - before);
    }

    @Override
    public void destroy() {}

}
