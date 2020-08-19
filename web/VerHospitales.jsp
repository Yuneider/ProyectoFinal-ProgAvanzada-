<%-- 
    Document   : VerDoctores
    Created on : 14/08/2020, 09:49:39 AM
    Author     : Familia Garay
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Conexion con = new Conexion();
    Connection c = con.Conexion();
    String sqr = "select * from hospitales";
    PreparedStatement ps = c.prepareStatement(sqr);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <link rel="stylesheet" href="CSS/VerHospitales.css">
        <meta charset="utf-8">
        <title>Hospitales</title>
    </head>
    <body>
        <div class="banner" id="sec">
            <header>
                <div class="logo"><img src="FILES/Logo.png"></div>
                <div id="toggle" onclick="toggle()"></div>
            </header>
            <div class="contenido-pag">
                <div class="Titulo">Instituciones aliadas</div>
                <table>
                    <thead>
                    <th class="td-numero"></th><th>Localidad</th><th>IPS</th><th>Dirección</th><th class="th-acciones">Acciones</th>
                    </thead>
                        <%int numero=0;
                        while(rs.next()){
                        numero=numero+1;%>
                    <tr>
                        <td class="td-numero"><%out.print(numero);%></td>
                        <td class="td-localidad"><% out.print(rs.getString("localidad"));%></td>
                        <td class="td-ips"><% out.print(rs.getString("nombre"));%></td>
                        <td class="td-direccion"><% out.print(rs.getString("dir"));%></td>
                        <td class="links">
                            <a href="Ingreso?opcion=eliminarHospital&hospital=<%= rs.getString("nombre")%>">Eliminar</a>
                        </td>
                    </tr>
                    <% }%>
                    <tr>
                        <td colspan="5" class="links"><a href="AgregarHospital.jsp">Agregar Hospital</a></td>
                    </tr>
                </table>
            </div>            
        </div>
        <div id="Navegacion">
            <ul>
                <li><a href="HomeAdmin.jsp">Inicio</a></li>
                <li><a href="index.jsp">Cerrar Sesión</a></li>
            </ul>
        </div>
    </body>
    <script src="JS/Barra.js"></script>
</html>
