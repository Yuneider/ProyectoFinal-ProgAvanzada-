<%-- 
    Document   : AgregarDoctor
    Created on : 15/08/2020, 11:16:07 AM
    Author     : 57315
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CSS/HomePaciente.css">
        <title>Agendar_Citas</title>    
    </head>
    <body>
        <section class="banner" id="sec">
            <header>
                <div class="logo"><img src="FILES/Logo.png"></div>
                <div id="toggle" onclick="toggle()"></div>
            </header>
            <div class="datos-nueva-cita">
                <span class="titulo">AGREGAR NUEVO DOCTOR:</span>
                <div class="item">
                    <input class="ingreso" id="nombre" name="nombre" type="text" value="Ingrese su nombre"></input>
                </div>
                <div class="item">
                    <input class="ingreso" type="text" value="Ingrese su usuario"></input>
                </div>
                <div class="item">
                    <select id="hospital" name="hospital">
                        <option disabled selected>Seleccione un hospital</option>
                        <option>Medicina General</option>
                        <option>Optometria</option>
                        <option>Odontología</option>
                    </select>
                </div>
                <div class="item">
                    <select id="especialidad" name="especialidad">
                        <option disabled selected>Seleccione un especialidad</option>
                        <option>Medicina General</option>
                        <option>Optometria</option>
                        <option>Odontología</option>
                    </select>
                </div>
                <input type="button" class="boton" onclick="" value="Ingresar Doctor">
            </div>    
        </section>
        <div id="Navegacion">
            <ul>
              <li><a href="HomeAdmin.jsp">Inicio</a></li>
              <li><a href="index.jsp">Cerrar Sesión</a></li>
            </ul>
        </div>
    </body>
    <script src="JS/Barra.js"></script>
    <script src="JS/AgendarCitas.js" type="text/javascript"></script>
</html>