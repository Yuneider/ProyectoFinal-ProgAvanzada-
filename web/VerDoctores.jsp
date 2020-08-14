<%-- 
    Document   : VerDoctores
    Created on : 14/08/2020, 09:49:39 AM
    Author     : Familia Garay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <link rel="stylesheet" href="CSS/VerDoctores.css">
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
          <th>Hospital</th><th>Doctor(nombre)</th><th>Especialidad</th><th>Horario</th><th>Acciones</th>
        </thead>
        <tr>
          <td>AQUI VA EL HOSPITAL</td>
          <td>AQUI VA EL DOCTOR</td>
          <td>AQUI VA LA ESPECIALIDAD</td>
          <td>AQUI VA EL HORARIO</td>
          <td class="links">
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Editar</a>
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Eliminar</a>
          </td>
        </tr>
        <tr>
          <td colspan="5" class="links"><a href="AñadirDoctor.html">Agregar Doctor</a></td>
        </tr>
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
