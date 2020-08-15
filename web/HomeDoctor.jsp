<%-- 
    Document   : InicioDoctor
    Created on : 11/08/2020, 06:42:02 PM
    Author     : Jhony Caro
--%>

<%@page import="Logica.Doctor"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Medinice-Plus</title>
    </head>
    <body>
        <h1><%= ((Doctor)session.getAttribute("doctor")).getNombre()%></h1>
    </body>
</html>
