<%-- 
    Document   : Registro
    Created on : 2/08/2020, 04:12:26 PM
    Author     : 57315
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="Registro.css">
        <title>Registro</title>
    </head>
    <body>
        <form action="/*VA A LA BASE DE DATOS QUE NO HEMOS CREADO :'V*/" id="usuarioRegistrado" method="get">
            <div class="InfoPersonalPaciente">
                <h2>Documento de identidad:</h2>
                <input type="number" name="dni" id= "dni" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Nombre completo:</h2>
                <input type="text" name="text" id= "usuario" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Edad:</h2>
                <input type="number" name="edad" id= "edad" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Correo electrónico:</h2>
                <input type="email" name="correoElectronico" id= "correoElectronico" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Ingrese una contraseña:</h2>
                <input type="text" name="contraseña" id= "contraseña" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Direccion de su hogar:</h2>
                <input type="text" name="direccionHogar" id= "direccionHogar" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Barrio en el que reside:</h2>
                <input type="text" name="barrio" id= "barrio" value="" placeholder="Ingrese la info" required>
            </div>
            <div class="InfoPersonalPaciente">
                <h2>Número celular:</h2>
                <input type="number" name="numcelular" id= "numcelular" value="" placeholder="Ingrese la info" required>
            </div>
            <button type="button" name="registrarUsuario">Registrarse</button>
        </form>
    </body>
</html>
