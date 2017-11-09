<%-- 
    Document   : index
    Created on : 29/09/2017, 18:48:10
    Author     : martin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="<c:url value="/assets/jquery/jquery-3.2.1.min.js"/>"></script>
        <link href="<c:url value="/assets/application.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <script src="<c:url value="/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>"></script>        
        <title>Proyecto Base</title>
    </head>
    <body>
        <div id="wrapper">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/personas/index"/>">Proyecto base</a>
                </div>
                <ul class="nav navbar-right top-nav">    
                    <li class="dropdown">
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown">usuario
                          <b class="caret"></b>
                      </a>
                      <ul class="dropdown-menu">
                        <li>
                          <a href="<c:url value="/personas/new"/>">Mi cuenta</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                          <a href="<c:url value="/personas/new"/>">Salir</a>
                        </li>
                      </ul>
                    </li>
                </ul>
              
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li class="active">
                            <a href="<c:url value="/personas/new"/>">Nueva Persona</a>    
                        </li>
                    </ul>
                </div>                
            </nav>
                
            <div id="page-wrapper">
                <div class="container-fluid">
              
                    <div class="page-header">            
                        <a class="btn btn-primary" href="<c:url value="/personas/new"/>">Nueva persona</a>
                        <h4>Listado de Personas</h4>
                    </div>
                     
                    <div class="table-responsive">
                        <table class="table table-bordered table-striped table-hover">
                            <thead>
                                <tr>
                                <th>DNI</th>
                                <th>Apellido</th>
                                <th>Nombre</th>
                                <th>Accion</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${it.personas}" var="persona">
                                <tr>
                                    <td>${persona.dni}</td>
                                    <td>${persona.apellido}</td>
                                    <td>${persona.nombre}</td>
                                    <td class="text-center">
                                    <a class="btn btn-sm btn-default" href="<c:url value="/personas/show/${persona.id}"/>"><span class="glyphicon glyphicon-search"></span></a>
                                    <a class="btn btn-sm btn-default" href="<c:url value="/personas/edit/${persona.id}"/>"><span class="glyphicon glyphicon-pencil"></span></a>
                                    <a class="btn btn-sm btn-danger" href="<c:url value="/personas/destroy/${persona.id}"/>"><span class="glyphicon glyphicon-trash"></span></a>
                                    </td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div> 
            </div>
        </div>
    </body>
</html>
