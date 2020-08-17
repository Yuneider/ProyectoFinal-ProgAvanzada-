<%-- 
    Document   : InicioPaciente
    Created on : 12/08/2020, 08:26:53 AM
    Author     : Jhony Caro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="CSS/HomePaciente.css">
    <title>Home_Usuario</title>
  </head>
  <body>
    <section class="banner" id="sec">
      <header>
        <div class="logo"><img src="FILES/Logo.png"></div>
        <div id="toggle" onclick="toggle()"></div>
      </header>
        <ul class="sci">
          <div class="contenedorGeneral">
            <li><a href="AgendarCitas.jsp"><img src="FILES/estudiar.png"><h2>Agendar una cita</h2></a></li>
            <li><a href="verCitas.jsp"><img src="FILES/historial.png"><h2>Ver citas</h2></a></li>
          </div>
        </ul>
    </section>
    <div id="Navegacion">
      <ul>
        <li><a href="PerfilPaciente.jsp">Ver Perfil</a></li>
        <li><a href="index.jsp">Cerrar Sesión</a></li>
      </ul>
    </div>
  </body>
  <script src="JS/Barra.js"></script>
</html>