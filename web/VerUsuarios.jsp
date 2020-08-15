<%-- 
    Document   : VerUsuarios
    Created on : 14/08/2020, 09:51:53 AM
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
    String sqr = "select * from pacientes";
    PreparedStatement ps = c.prepareStatement(sqr);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="CSS/VerUsuarios.css">
    <title>Perfil_usuario</title>
  </head>
  <body>
    <section class="banner" id="sec">
      <header>
        <div class="logo"><img src="FILES/Logo.png"></div>
        <div id="toggle" onclick="toggle()"></div>
      </header>
      <div class="Titulo">
        <h1>Usuarios</h1>
      </div>
      <table>
        <thead>
          <th>DNI</th><th>Nombre</th><th>Edad</th><th>Correo</th><th>Dirección</th><th>Barrio</th><th>Célular</th><th>Usuario</th><th>Acciones</th>
        </thead>
        <%while(rs.next()){%>
        <tr>
          <td><% out.print(rs.getInt("dni"));%></td>
          <td><% out.print(rs.getString("nombre"));%></td>
          <td><% out.print(rs.getInt("edad"));%></td>
          <td><% out.print(rs.getString("correo"));%></td>
          <td><% out.print(rs.getString("dir"));%></td>
          <td><% out.print(rs.getString("barrio"));%></td>
          <td><% out.print(rs.getString("celular"));%></td>
          <td><% out.print(rs.getString("usuario"));%></td>
          <td class="links">
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Editar</a>
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Eliminar</a>
          </td>
        </tr>
        <% }%>
      </table>
    </section>
    <div id="Navegacion">
      <ul>
        <li><a href="HomeAdmin.html">Inicio</a></li>
        <li><a href="index.html">Cerrar Sesión</a></li>
      </ul>
    </div>
  </body>
  <script src="JS/Barra.js"></script>
</html>