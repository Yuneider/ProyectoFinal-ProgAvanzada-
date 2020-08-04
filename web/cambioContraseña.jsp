<%-- 
    Document   : cambioContraseña
    Created on : 4/08/2020, 04:00:02 PM
    Author     : Familia Garay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="CambioDeContraseña.css">
        <title>CambioDeContraseña</title>
    </head>
    <body>
        <form action="/*VA A LA BASE DE DATOS QUE NO HEMOS CREADO :'V*/'" id="cambiodeContraseña" method="get">
            <div class="contenedorGeneral">
                <div class="cambioInfoContraseña">
                    <h3>Debido al olvido de su contraseña, procedera a ingresar una nueva contraseña con los siguientes datos personales</h3>
                </div>
                <div class="cambioInfoContraseña">
                    <h2>Correo electrónico:</h2>
                    <input type="email" name="correoElectronico" id= "correoElectronico" value="" placeholder="Ingrese la info" required>
                </div>
                <div class="cambioInfoContraseña">
                    <h2>Nueva contraseña:</h2>
                    <input type="text" name="nuevaContraseña" id= "nuevaContraseña" value="" placeholder="Ingrese la info" required>
                </div>
                <div class="">
                    <h2>Confirmar contraseña:</h2>
                    <input type="text" value="" placeholder="Ingrese la info" required>
                </div>
            </div>
            <div class="cambioInfoContraseña">
                <button type="button" name="cambioContraseña"><a href="index.html">Guardar Cambios</a></button>
            </div>
        </form>
    </body>
</html>
