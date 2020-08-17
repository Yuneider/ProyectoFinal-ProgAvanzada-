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
            <div class="msj-campo-obl" id="campos_obligatorios"></div>
            <div>
                <div class="etiquetas">
                    <div class="etiqueta">Doc. de identidad: <span id="valDocumento" class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Nombre Completo: <span id="valNombre" class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Fecha de nacimiento: <span class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Correo electrónico: <span id="valCorreo" class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Número de celular: <span id="valCelular" class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Dir. de residencia: <span id="valDireccion" class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Barrio/Localidad:</div>
                    <div class="etiqueta">Usuario: <span class="campo-obligatorio" id="valUsuario"></span></div>
                    <div class="etiqueta">Contraseña: <span id="valContrasena" class="campo-obligatorio"></span></div>
                    <div class="etiqueta">Confirmación contraseña: <span id="valConfirmacion"class="campo-obligatorio"></span></div>
                </div>
                <form id="usuarioRegistrado" method="post" autocomplete="off" >
                    <div class="entrada-info">
                        <input type="number" name="dni" id= "dni" onKeyPress="if(this.value.length==10) return false" placeholder="123456789">
                        <div> <input type="text" name="nombre" id= "nombre" placeholder="Daniel Garay"></div>
                        <div> <input type="date" name="fecha_nacimiento" id= "fecha_nacimiento" max="2019-12-31" min="1920-01-01" value="2000-05-26"></div>
                        <div> <input type="text" name="correo" id= "correo" placeholder="daniel.garay@correo.com"></div>    
                        <div> <input type="number" name="celular" id= "celular"  onKeyPress="if(this.value.length==10) return false" placeholder="3101110000"></div>
                        <div> <input type="text" name="direccion" id= "direccion" placeholder="Carrera 5 # 26b - 30"></div>
                        <div> <input type="text" name="barrio" id= "barrio"></div>
                        <div> <input type="text" name="usuario" id= "usuario" placeholder="DGARAY"></div>
                        <div> <input type="password" name="contra" id= "contra">
                            <button class="boton-ver" onclick="mostrarContrasena()">
                                <img class="img-ver" src="FILES/Ver.png" alt=""/>
                            </button>
                        </div>
                        <div> <input type="password" name="contra_confirmacion" id= "contra_confirmacion"></div> 
                        <input type="hidden" name="opcion" value="registrarse">
                    </div>
                    <div class="boton-registro">
                        <input type="button" class="boton" onclick="validarAjax()" value="Registrarse">
                    </div>
                </form>
            </div>    
        </div>
    </body>
</html>
