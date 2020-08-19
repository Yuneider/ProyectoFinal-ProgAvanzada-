<%-- 
    Document   : CancelarCita
    Created on : 14/08/2020, 01:19:33 PM
    Author     : Familia Garay
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Datos.Conexion"%>
<%@page import="Logica.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    Conexion con = new Conexion();
    Connection c = con.Conexion();
    String nombre = ((Paciente)session.getAttribute("paciente")).getNombre();
    String sqr = "select * from citas where paciente='"+nombre+"';";
    PreparedStatement ps = c.prepareStatement(sqr);
    ResultSet rs=ps.executeQuery();
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <link rel="stylesheet" href="CSS/CancelarCita.css">
        <meta charset="utf-8">
        <title></title>
    </head>
    <body>
        <section class="banner" id="sec">
            <header>
                <div class="logo"><img src="FILES/Logo.png"></div>
                <div id="toggle" onclick="toggle()"></div>
            </header>
            <div>
                <span class="titulo">Citas</span>
                <table>
                    <thead>
                        <th>Hospital</th><th>Doctor</th><th>Fecha</th><th>Hora</th><th>Estado</th><th>Comentario</th><th>Acciones</th>
                    </thead>
                    <%while(rs.next()){%>
                    <tr>
                        <td><% out.print(rs.getString("hospital"));%></td>
                        <td><% out.print(rs.getString("doctor"));%></td>
                        <td><% out.print(rs.getString("fecha"));%></td>
                        <td><% out.print(rs.getInt("hora"));%>:00</td>
                        <td><% if(Integer.parseInt(rs.getString("estado"))==1){out.print("Planificada");}
                        else if(Integer.parseInt(rs.getString("estado"))==2){out.print("Cancelada");}
                        else if(Integer.parseInt(rs.getString("estado"))==3){out.print("Incumplida");}
                        else if(Integer.parseInt(rs.getString("estado"))==4){out.print("Realizada");}
                            %></td>
                        <td><% out.print(rs.getString("comentario"));%></td>
                        <td class="links">
                            <a  <% if(Integer.parseInt(rs.getString("estado"))!=1){out.print("style=\"pointer-events:none;color:rgb(98,99,100);\"");}%> 
                                href="Ingreso?opcion=cancelarCita&id=<%= rs.getInt("id")%>">Cancelar Cita</a>
                        </td>
                    </tr>
                    <% }%>
                </table>
            </div>    
        </section>
        <div id="Navegacion">
            <ul>
                <li><a href="HomePaciente.jsp">Inicio</a></li>
                <li><a href="PerfilPaciente.jsp">Ver Perfil</a></li>
                <li><a href="index.jsp">Cerrar Sesión</a></li>
            </ul>
        </div>
    </body>
    <script src="JS/Barra.js"></script>
</html>