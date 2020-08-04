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
        <link rel="stylesheet" href="index.css">
        <title>IngresoPaginaInicio</title>
    </head>
    <body>
        <form  action="/*VA A LA BASE DE DATOS QUE NO HEMOS CREADO :'V*/'" method="post">
            <div class="inputslogin">
                <input type="text" name="usuario" value="" placeholder="Ingrese su usuario" required>
                <input type="text" name="usuario" value="" placeholder="Ingrese su contraseña" required>
            </div>
            <div class="botonIngresoUsuario">
                <button type="button" name="iniciarSesion">Iniciar Sesion</button>
            </div>
            <div class="contenedorOlvidoContraseña">
                <button type="button" name="olvidoContraseña">¿Olvido su contraseña?</button>
            </div>
        </form>
        <div class="contenedorImagenInicio">
            <button type="button" name="btnRegistroUsuario">Registrarse</button>
        </div>
    </body>
</html>
