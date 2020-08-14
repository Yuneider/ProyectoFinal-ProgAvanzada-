<%-- 
    Document   : CancelarCita
    Created on : 14/08/2020, 01:19:33 PM
    Author     : Familia Garay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
      <h1>Citas Programadas</h1>
      <table>
        <thead>
          <th>Hospital</th><th>Doctor</th><th>Fecha</th><th>Horario</th><th>Acciones</th>
        </thead>
        <tr>
          <td>AQUI VA EL HOSPITAL</td>
          <td>AQUI VA EL DOCTOR</td>
          <td>AQUI VA LA FECHA</td>
          <td>AQUI VA EL HORARIO</td>
          <td class="links">
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Cancelar Cita</a>
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Reprogramar Cita</a>
          </td>
        </tr>
      </table>
    </section>
    <div id="Navegacion">
      <ul>
        <li><a href="homePaciente.html">Inicio</a></li>
        <li><a href="PerfilPaciente.html">Ver Perfil</a></li>
        <li><a href="index.html">Cerrar Sesión</a></li>
      </ul>
    </div>
  </body>
  <script src="JS/Barra.js"></script>
</html>
