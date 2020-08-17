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
    String sqr = "select * from doctores";
    PreparedStatement ps = c.prepareStatement(sqr);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <link rel="stylesheet" href="CSS/VerDoctores.css">
        <meta charset="utf-8">
        <title></title>
    </head>
    <body>
        <div class="banner" id="sec">
            <header>
                <div class="logo"><img src="FILES/Logo.png"></div>
                <div id="toggle" onclick="toggle()"></div>
            </header>
            <div>
                <div class="titulo">Doctores registrados</div>
                <table>
                    <thead>
                        <th>Hospital</th><th>Doctor(nombre)</th><th>Especialidad</th><th>Horario</th><th>Usuario</th><th>Acciones</th>
                    </thead>
                    <%while(rs.next()){%>
                    <tr>
                        <td><% out.print(rs.getString("hospital"));%></td>
                        <td><% out.print(rs.getString("nombre"));%></td>
                        <td><% out.print(rs.getString("especialidad"));%></td>
                        <td>8:00 - 17:00</td>
                        <td><% out.print(rs.getString("usuario"));%></td>
                        <td class="links">
                            <a href="Ingreso?opcion=eliminarDoctor&usuario=<%= rs.getString("usuario")%>">Eliminar</a>
                        </td>
                    </tr>
                    <% }%>
                    <tr>
                        <td colspan="6" class="links"><a href="AgregarDoctor.jsp">Agregar Doctor</a></td>
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
