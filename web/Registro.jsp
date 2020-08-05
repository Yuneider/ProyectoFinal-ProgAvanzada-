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
        <title>Medinice-Plus</title>
    </head>
    <body>
        <form action="Ingreso" id="usuarioRegistrado" method="get">
                
            <div class="p-registro">
                <div><img class="img-logo" src="FILES/Logo.png"></div>
                <div><p>¡Bienvenido! Medicine-Plus es una plataforma creada pensando en el bienestar de todos y cada uno de los Colombianos 
                    ¿Estas cansado de llamar a las lineas de atencion de tu EPS y tardar media hora agendando una cita?
                    Con Medicine-Plus puedes agendar citas de: Medicina general, Promocion y Prevencion (PyP), Optometria,
                    Odontologia, Consegeria profesional y muchas mas especialidades en solo minutos. Ademas, manejamos convenios
                    con las mejores clinicas y hospitales de Bogotá para poder ofrecerte la mejor atencion cerca a tu casa.</p>
                </div>
                <div class="info-paciente-nuevo">
                    <div>Doc. de identidad: <input type="number" name="dni" id= "dni" maxlength="12" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" placeholder="Campo obligatorio" required></div>
                    <br>
                    <div>Nombre Completo: <input type="text" name="nombre" id= "nombre" placeholder="Campo obligatorio" required></div>
                    <br>
                    <div>Fecha de nacimiento: <input type="date" name="fecha_nacimiento" id= "fecha_nacimiento" max="2019-12-31" min="1920-01-01" value="2000-05-26" required></div>
                    <br>
                    <div>Correo electrónico: <input type="text" name="correo" id= "correo" placeholder="Campo obligatorio" required></div>    
                    <br>
                    <div>Número de celular: <input type="number" name="celular" id= "celular" maxlength="10" oninput="if(this.value.length > this.maxLength) this.value = this.value.slice(0, this.maxLength);" placeholder="Campo obligatorio" required></div>
                    <br>
                    <div>Dir. de residencia: <input type="text" name="direccion" id= "direccion" placeholder="Campo obligatorio"></div>
                    <br>
                    <div>Barrio/Localidad: <input type="text" name="barrio" id= "barrio" placeholder="Campo opcional"></div>        
                    <br>
                    <div>Contraseña: <input type="password" name="contra" id= "contra" placeholder="Campo obligatorio"></div>
                    <br>
                    <div>Confirmación: <input type="password" name="contra_confirmacion" id= "contra_confirmacion" placeholder="Campo obligatorio"></div> 
                </div>
                <div class="boton-registro">
                    <input type="submit" class="boton" value="Registrarse">
                </div>
            </div>
        </form>
    </body>
</html>
