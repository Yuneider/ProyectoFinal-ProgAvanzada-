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
        <link href="CSS/AgregarDoctor.css" rel="stylesheet" type="text/css"/>
        <script src="JS/AgregarDoctor.js" type="text/javascript"></script>
        <title>Nuevo Doctor</title>    
    </head>
    <body>
        <section class="banner" id="sec">
            <header>
                <div class="logo"><img src="FILES/Logo.png"></div>
                <div id="toggle" onclick="toggle()"></div>
            </header>
            <div class="pag-centro">
                <span class="titulo">AGREGAR NUEVO DOCTOR:</span>    
                <div class="item">
                    <input class="ingreso" id="nombre" name="nombre" type="text" onKeyPress="if(this.value.length==30) return false" placeholder="Ingrese su nombre"></input>
                </div>
                <div class="item">
                    <input class="ingreso" id="usuario" name="usuario" type="text" onKeyPress="if(this.value.length==20) return false" placeholder="Ingrese su usuario"></input>
                </div>
                <div class="error" id="error"></div>
                <div class="item">
                    <input class="ingreso" id="contrasena" name="contrasena" type="password" onKeyPress="if(this.value.length==20) return false" placeholder="Ingrese su contraseña"></input>
                    <button class="boton-ver" onclick="mostrarContrasena()">
                        <img class="img-ver" src="FILES/Ver.png" alt=""/>
                    </button>
                </div>
                <div class="item">
                    <select id="localidad" name="localidad" onchange="habilitarHospital(this.value);">
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
                    <select id="hospital" name="hospital"  onchange="habilitarEspecialidad(this.value);" disabled>
                        <option value="0" disabled selected >Seleccione un hospital</option>
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
                <input type="button" class="boton" onclick="crearDoctor()" value="Ingresar Doctor"></input> 
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
</html>