<%-- 
    Document   : index
    Created on : 23/07/2020, 05:40:48 PM
    Author     : 57315
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link href="CSS/Ingreso.css" rel="stylesheet" type="text/css"/>
        <script src="JS/index.js" type="text/javascript"></script>
        <title>Medinice-Plus</title>
    </head>
    <body class="fondo">
        <div class="login-centrado">
            <div><img class="img-logo" src="FILES/Logo.png"></div>
            <div class="error-ingreso" id="error_ingreso"></div>
            <form  id="datos" method="post" autocomplete="off">    
                <div class="datos-ingreso" id="datos_ingreso">
                    <div><input class="usuario" type="text" name="usuario" id="usuario" placeholder="Usuario"></div>
                    <br>
                    <div><input type="password" name="contrasena" id="contrasena" placeholder="Contraseña">
                        <button class="boton-ver" onclick="mostrarContrasena()">
                            <img class="img-ver" src="FILES/Ver.png" alt=""/>
                        </button>
                    </div>
                    <br>
                    <div><input class="boton" type="button" onclick="ingresar()" value="INICIAR SESIÓN"></div>
                    <input type="hidden" name="opcion" value="ingreso">
                </div>
            </form>
            <br>
            <div><input class="olvido-contra" type="submit" onclick="Recuperar()" id="recuperar" value="¿Olvido su contraseña?" ></div>        
            <form action="Ingreso" method="post" autocomplete="off">
                <div id="olvido_contrasena" style="display: none;">
                    <br>
                    <p>Para recuperar su contraseña se enviara un email al correo electronico correspondiente a su cuenta
                        , digite por favor el correo con el que se encuentra registrado.<br><br>
                        Al dar click en "ENVIAR" revise la bandeja de entrada de su correo.
                    </p>
                    <div><input type="text" name="correo_olvido" placeholder="Correo electrónico" required></div>
                    <br>
                    <div><input class="boton" type="submit" onclick="Cambiar()" value="ENVIAR"></div>
                    <input type="hidden" name="opcion" value="olvido_contrasena">
                </div>
            </form>    
            <div id="nuevo_paciente" class="registro-nuevo">
                <p class="parrafo-npaciente">En caso de ser nuevo en Medicine-Plus <a href="Registro.jsp" class="nuevo-paciente" > Registrarse aquí</a> y agende su primera cita en minutos.</p>
            </div>    
        </div>
    </body>
</html>
