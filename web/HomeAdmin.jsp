<%-- 
    Document   : InicioAdministrador
    Created on : 11/08/2020, 06:38:38 PM
    Author     : Jhony Caro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="CSS/HomeAdmin.css">
    <title>Home_Admin</title>
  </head>
  <body>
    <section class="banner" id="sec">
      <header>
        <div class="logo"><img src="FILES/Logo.png"></div>
        <div id="toggle" onclick="toggle()"></div>
      </header>
        <ul class="sci">
          <div class="contenedorGeneral">
            <li><a href="VerUsuarios.html"><img src="FILES/grupo.png"><h2>Usuarios</h2></a></li>
            <li><a href="VerDoctores.html"><img src="FILES/doctor.png"><h2>Doctores</h2></a></li>
          </div>
        </ul>
    </section>
    <div id="Navegacion">
      <ul>
        <li><a href="index.html">Cerrar Sesión</a></li>
      </ul>
    </div>
  </body>
  <script src="JS/Barra.js"></script>
</html>
