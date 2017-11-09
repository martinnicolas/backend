<%-- 
    Document   : add
    Created on : 22/10/2017, 19:01:05
    Author     : martin
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<c:url value="/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>" rel="stylesheet"/>
        <script src="<c:url value="/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"/>"></script>
        <title>Proyecto Base</title>
    </head>
    <body>
        <h4>Nueva Persona</h4>
        <jsp:include page="_form.jsp"/>
    </body>
</html>
