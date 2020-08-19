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
    <title>Administrador</title>
  </head>
  <body>
    <section class="banner" id="sec">
      <header>
        <div class="logo"><img src="FILES/Logo.png"></div>
        <div id="toggle" onclick="toggle()"></div>
      </header>
        <ul class="sci">
          <div class="contenedorGeneral">
            <li><a href="VerPacientes.jsp"><img src="FILES/grupo.png"><h2>Usuarios</h2></a></li>
            <li><a href="VerDoctores.jsp"><img src="FILES/doctor.png"><h2>Doctores</h2></a></li>
            <li><a href="VerHospitales.jsp"><img src="FILES/hospital.png"><h2>Hospitales</h2></a></li>
          </div>
        </ul>
    </section>
    <div id="Navegacion">
      <ul>
        <li><a href="index.jsp">Cerrar Sesión</a></li>
      </ul>
    </div>
  </body>
  <script src="JS/Barra.js"></script>
</html>
