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
                <form action="Ingreso">
                <span class="titulo">AGREGAR NUEVO DOCTOR:</span>
                <div class="item">
                    <input class="ingreso" id="nombre" name="nombre" type="text" placeholder="Ingrese su nombre"></input>
                </div>
                <div class="item">
                    <input class="ingreso" id="usuario" name="usuario" type="text" placeholder="Ingrese su usuario"></input>
                </div>
                <div class="item">
                    <input class="ingreso" id="contrasena" name="contrasena" type="text" placeholder="Ingrese su contraseña"></input>
                </div>
                <div class="item">
                    <select id="hospital" name="hospital">
                        <option disabled selected>Seleccione un hospital</option>
                        <option value="Unidad Médica San Antonio Policía Nacional">Unidad Médica San Antonio Policía Nacional</option>
                        <option value="Hospital Universitario Méderi Barrios Unidos">Hospital Universitario Méderi Barrios Unidos</option>
                        <option value="Hospital de Bosa II Nivel">Hospital de Bosa II Nivel</option>
                        <option value="CAMI CHAPINERO">CAMI CHAPINERO</option>
                        <option value="Hospital Meissen">Hospital Meissen</option>
                        <option value="CAMI DIANA TURBAY">CAMI DIANA TURBAY</option>
                        <option value="Hospital de Engativa">Hospital de Engativa</option>
                        <option value="Hospital Fontibón E.S.E.">Hospital Fontibón E.S.E.</option>
                        <option value="Hospital de Kennedy">Hospital de Kennedy</option>
                        <option value="Hospital del Sur UPA 11">Hospital del Sur UPA 11</option>
                        <option value="Hospital Rafael Uribe Uribe E.S.E.">Hospital Rafael Uribe Uribe E.S.E.</option>
                        <option value="Fundacion Santa Fe de Bogota Hospital Universitario">Fundacion Santa Fe de Bogota Hospital Universitario</option>
                        <option value="UPA SAN CRISTOBAL">UPA SAN CRISTOBAL</option>
                        <option value="Hospital Cafam Suba">Hospital Cafam Suba</option>
                        <option value="Hospital Tunjuelito">Hospital Tunjuelito</option>
                        <option value="Hospital de Usaquen">Hospital de Usaquen</option>
                        <option value="Hospital de Usme">Hospital de Usme</option>
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
                <input type="hidden" id="opcion" name="opcion" value="AgregarDoctor"></input>  
                <input type="submit" class="boton"  value="Ingresar Doctor"></input>  
                </form>
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