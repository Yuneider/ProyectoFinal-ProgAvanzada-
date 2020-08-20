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
    String sqr = "select * from citas Where doctor='"+((Doctor)session.getAttribute("doctor")).getNombre()+"' AND fecha='"+((Doctor)session.getAttribute("doctor")).FechaActual()+"';";
    PreparedStatement ps = c.prepareStatement(sqr);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="CSS/HomeDoctor.css">
    <script src="JS/HomeDoctor.js" type="text/javascript"></script>
    <title>Bienvenido <%=((Doctor)session.getAttribute("doctor")).getNombre()%></title>
  </head>
  <body>
    <section class="banner" id="sec">
      <header>
        <div class="logo"><img src="FILES/Logo.png"></div>
        <div id="toggle" onclick="toggle()"></div>
      </header>
        <div class="info-pag"> 
            <div class="titulo">Citas para hoy (<%out.print(((Doctor)session.getAttribute("doctor")).FechaActual());%>)</div>
                <table>
                  <thead>
                    <th>Paciente</th><th>Hora</th><th>Fecha</th><th>Estado</th><th>Acciones</th>
                  </thead>
                  <%while(rs.next()){%>
                  <tr>
                      <td class="pac"><% out.print(rs.getString("paciente"));%></td>
                    <td class="hora"><% out.print(rs.getString("hora"));%>:00</td>
                    <td class="fecha"><% out.print(rs.getString("fecha"));%></td>
                    <td class="estado"><% if(Integer.parseInt(rs.getString("estado"))==1){out.print("Planificada");}
                        else if(Integer.parseInt(rs.getString("estado"))==2){out.print("Cancelada");}
                        else if(Integer.parseInt(rs.getString("estado"))==3){out.print("Incumplida");}
                        else if(Integer.parseInt(rs.getString("estado"))==4){out.print("Realizada");}
                    %></td>
                    <td class="acc">
                        <a class="links"
                         <% if(Integer.parseInt(rs.getString("estado"))==2){out.print("style=\"pointer-events:none;color: black;\" value=\"Cita Cancelada\"");}
                         else if(Integer.parseInt(rs.getString("estado"))==3){out.print("style=\"pointer-events:none;color: black;\" value=\"Cita Incumplida\"");}
                         else if(Integer.parseInt(rs.getString("estado"))==4){out.print("style=\"pointer-events:none;color: black;\" value=\"Cita Realizada\"");}
                         else{out.print("style=\"color: blue;\"");}%>href="Ingreso?opcion=evolucionarCita&id=<%= rs.getInt("id")%>">Evolucionar Cita</a>                        
                         
                         <a  <% if(Integer.parseInt(rs.getString("estado"))!=1){out.print("style=\"pointer-events:none;color:black;\"");}%> 
                                href="Ingreso?opcion=citaIncumplida&id=<%= rs.getInt("id")%>">Cita incumplida</a>
                    </td>
                  </tr>
                  <% }%>
                </table>
        </div>    
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
