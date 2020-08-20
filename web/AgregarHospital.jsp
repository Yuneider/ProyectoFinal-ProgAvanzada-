<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta charset="utf-8">
        <link href="CSS/AgregarHospital.css" rel="stylesheet" type="text/css"/>
        <script src="JS/AgregarHospital.js" type="text/javascript"></script>
        <title>Nuevo Hospital</title>
    </head>
    <body>
        <section class="banner" id="sec">
            <header>
                <div class="logo"><img src="FILES/Logo.png"></div>
                <div id="toggle" onclick="toggle()"></div>
            </header>
            <div class="pag-centro">
                <div class="titulo">AGREGAR NUEVO HOSPITAL</div>
                    <div class="entrada-info">
                        <form id="formulario" method="POST"> 
                            <div class="item">
                                <select id="localidad" name="localidad">
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
                            <div> <input type="text" name="hospital" id= "hospital" onKeyPress="if (this.value.length == 40)
                                          return false" placeholder="Razón social">
                            </div>
                            <div id="error" class="error"> </div>
                            <div> <input type="text" name="direccion" id= "direccion" onKeyPress="if (this.value.length == 40)
                                          return false" placeholder="Direccion">
                            </div>
                            <input id="opcion" name="opcion" type="hidden" value="AgregarHospital"></input>
                        </form>
                    </div>
                <input type="button" class="boton" onclick="CrearHospital()" value="Ingresar Hospital"></input>
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