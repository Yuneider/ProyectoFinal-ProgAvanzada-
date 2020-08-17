<%-- 
    Document   : AgendarCitas
    Created on : 14/08/2020, 01:23:11 PM
    Author     : Familia Garay
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
                <span class="titulo">AGENDAR NUEVA CITA:</span>
                <p>
                    <span class="punto">•</span>La unicas citas que los usuarios pueden agendar sin orden medica son: Medicina General, Optometria y Odontologia.<br>     
                    <span class="punto">•</span>En caso de no poder asistir a su cita recuerde cancelarla por lo menos con 24 horas de anticipacion.<br>
                    <span class="punto">•</span>Los unicos bloques horarios que se muestran son los disponibles.
                </p>
                <div class="item">
                    <select id="localidad" name="localidad" onchange="habilitar(this.value);" required>
                        <option value="0" disabled selected >Seleccione una localidad</option>
                        <option value="ANTONIO NARIÑO">ANTONIO NARIÑO</option>
                        <option value="BARRIOS UNIDOS">BARRIOS UNIDOS</option>
                        <option value="BOSA">BOSA</option>
                        <option value="CHAPINERO">CHAPINERO</option>
                        <option value="CIUDAD BOLIVAR">CIUDAD BOLIVAR</option>
                        <option value="DIANA TURBAY">DIANA TURBAY</option>
                        <option value="ENGATIVA">ENGATIVA</option>
                        <option value="FONTIBON">FONTIBON</option>
                        <option value="KENNEDY">KENNEDY</option>
                        <option value="PUENTE ARANDA">PUENTE ARANDA</option>
                        <option value="RAFAEL URIBE URIBE">RAFAEL URIBE URIBE</option>
                        <option value="SANTA FE">SANTA FE</option>
                        <option value="SAN CRISTOBAL">SAN CRISTOBAL</option>
                        <option value="SUBA">SUBA</option>
                        <option value="TUNJUELITO">TUNJUELITO</option>
                        <option value="USAQUEN">USAQUEN</option>
                        <option value="USME">USME</option>
                    </select>
                </div>
                <div class="item">
                    <span id="hospital" name="hospital" class="hospital">Hospital: No definido</span>
                </div>
                <div class="item">
                    <select id="especialidad" name="especialidad" disabled>
                        <option disabled selected>Seleccione una especialidad</option>
                        <option>Medicina General</option>
                        <option>Optometria</option>
                        <option>Odontología</option>
                    </select>
                </div>
                <div class="item">
                    <span id="doctor" name="doctor" class="doctor">Doctor: No definido</span>
                </div>
                <div class="item">
                    <input class="fecha" type="date" name="fecha" id="fecha">
                </div>
                <div class="item">
                    <select id="hora" name="hora" required>
                        <option disabled selected>Seleccione una hora</option>
                        <option>08 A.M.</option>
                        <option>09 A.M.</option>
                        <option>10 A.M.</option>
                        <option>11 A.M.</option>
                        <option>12 P.M.</option>
                        <option>01 P.M.</option>
                        <option>02 P.M.</option>
                        <option>03 P.M.</option>
                        <option>04 P.M.</option>
                        <option>05 P.M.</option>
                    </select>
                </div>
                <input type="button" class="boton" value="Programar Cita">
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
    <script src="JS/AgendarCitas.js" type="text/javascript"></script>
</html>