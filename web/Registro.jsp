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
        <link href="CSS/Registro.css" rel="stylesheet" type="text/css"/>
        <script src="JS/Regristro.js" type="text/javascript"></script>
        <title>Medinice-Plus</title>
    </head>
    <body>
        <div class="p-registro">
            <div><img class="img-logo" src="FILES/Logo.png"></div>
            <div><p>¡Bienvenido! Medicine-Plus es una plataforma creada pensando en el bienestar de todos y cada uno de los Colombianos 
                ¿Estas cansado de llamar a las lineas de atencion de tu EPS y tardar media hora agendando una cita?
                Con Medicine-Plus puedes agendar citas de: Medicina general, Promocion y Prevencion (PyP), Optometria,
                Odontologia, Consegeria profesional y muchas mas especialidades en solo minutos. Ademas, manejamos convenios
                con las mejores clinicas y hospitales de Bogotá para poder ofrecerte la mejor atencion cerca a tu casa.</p>
            </div>
            <div class="etiquetas">
                <div class="etiqueta">Doc. de identidad: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Nombre Completo: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Fecha de nacimiento: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Correo electrónico: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Número de celular: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Dir. de residencia: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Barrio/Localidad:</div>
                <div class="etiqueta">Usuario: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Contraseña: <span class="campo-obligatorio">(*)</span></div>
                <div class="etiqueta">Confirmación contraseña: <span class="campo-obligatorio">(*)</span></div>
            </div>
            <form id="usuarioRegistrado" method="post" autocomplete="off" >
                <div class="entrada-info">
                    <input type="number" name="dni" id= "dni" maxlength="12" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" placeholder="123456789" required>
                    <div> <input type="text" name="nombre" id= "nombre" placeholder="Daniel Garay" required></div>
                    <div> <input type="date" name="fecha_nacimiento" id= "fecha_nacimiento" max="2019-12-31" min="1920-01-01" value="2000-05-26" required></div>
                    <div> <input type="text" name="correo" id= "correo" placeholder="daniel.garay@correo.com" required></div>    
                    <div> <input type="number" name="celular" id= "celular" maxlength="10" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" placeholder="3101110000" required></div>
                    <div> <input type="text" name="direccion" id= "direccion" placeholder="Carrera 5 # 26b - 30"></div>
                    <div> <input type="text" name="barrio" id= "barrio"></div>
                    <div> <input type="text" name="usuario" id= "usuario" placeholder="DGARAY" required></div>
                    <div> <input type="password" name="contra" id= "contra">
                        <button class="boton-ver" onclick="mostrarContrasena()">
                            <img class="img-ver" src="FILES/Ver.png" alt=""/>
                        </button>
                    </div>
                    <div> <input type="password" name="contra_confirmacion" id= "contra_confirmacion"></div> 
                    <input type="hidden" name="opcion" value="registrarse">
                </div>
                <div class="boton-registro">
                    <input type="submit" class="boton" value="Registrarse" onclick="Validar()">
                </div>
            </form>
        </div>
    </body>
</html>
