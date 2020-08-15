<%-- 
    Document   : VerUsuarios
    Created on : 14/08/2020, 09:51:53 AM
    Author     : Familia Garay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
          <th>DNI</th><th>Usuario</th><th>Edad</th><th>Correo</th><th>Contraseña</th><th>Dirección</th><th>Barrio</th><th>Célular</th><th>Acciones</th>
        </thead>
        <tr>
          <td>AQUI VA EL DNI</td>
          <td>AQUI VA EL Usuario</td>
          <td>AQUI VA LA Edad</td>
          <td>AQUI VA EL Correo</td>
          <td>AQUI VA EL Contraseña</td>
          <td>AQUI VA EL Dirección</td>
          <td>AQUI VA EL Barrio</td>
          <td>AQUI VA EL Célular</td>
          <td class="links">
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Editar</a>
            <a href="ACA VA HACIA SU FUNCION CORRESPONDIENTE">Eliminar</a>
          </td>
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
