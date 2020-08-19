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
<% 
    Conexion con = new Conexion();
    Connection c = con.Conexion();
    String sqr = "select * from citas Where doctor='"+((Doctor)session.getAttribute("doctor")).getNombre()+"';";
    PreparedStatement ps = c.prepareStatement(sqr);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="CSS/HomeDoctor.css">
    <title>Bienvenido <%=((Doctor)session.getAttribute("doctor")).getNombre()%></title>
  </head>
  <body>
    <section class="banner" id="sec">
      <header>
        <div class="logo"><img src="FILES/Logo.png"></div>
        <div id="toggle" onclick="toggle()"></div>
      </header>
      <h1>Citas</h1>
      <table>
        <thead>
          <th>Paciente</th><th>Hora</th><th>Fecha</th><th>Estado</th><th>Observación</th><th>Acciones</th>
        </thead>
        <%while(rs.next()){%>
        <tr>
          <td><% out.print(rs.getString("paciente"));%></td>
          <td><% out.print(rs.getString("hora"));%></td>
          <td><% out.print(rs.getString("fecha"));%></td>
          <td><% out.print(rs.getString("estado"));%></td>
          <td><input type="text" value=<% out.print(rs.getString("comentario"));%>></td>
          <td class="links">
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Evolucionar Cita</a>
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Cita Incumplida</a>
          </td>
        </tr>
        <% }%>
      </table>
    </section>
    <div id="Navegacion">
      <ul>
        <li><a href="index.jsp">Cerrar Sesión</a></li>
      </ul>
    </div>
  </body>
  <script src="JS/Barra.js"></script>
  </body>
</html>
