<%-- 
    Document   : AgendarCitas
    Created on : 14/08/2020, 01:23:11 PM
    Author     : Familia Garay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<!DOCTYPE html>
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
      <div class="item">
        <h2>HOSPITAL:</h2>
        <select id="Nombre" name="Nombre" required>
                <option value="">Seleccione</option>
                <option value="CAMI CHAPINERO-CL 76 # 20 C 96">CAMI CHAPINERO-CL 76 # 20 C 96</option>
                <option value="UBA SANIDAD PORTUARIA TERMINAL TERRESTRE-SANIDAD PORTUARIA TERMINAL TERRESTRE MODULO VERDE LC 416">UBA SANIDAD PORTUARIA TERMINAL TERRESTRE-SANIDAD PORTUARIA TERMINAL TERRESTRE MODULO VERDE LC 416</option>
                <option value="Hospital de engativa-Dirección: Cll. 78 No. 82 – 96">Hospital de engativa-Dirección: Cll. 78 No. 82 – 96</option>
                <option value="CAMI DIANA TURBAY-KR 1 F # 48 X 40 SUR">CAMI DIANA TURBAY-KR 1 F # 48 X 40 SUR</option>
                <option value="UPA LOS ALPES-TV 10 B ES # 36 D 13 SUR">UPA LOS ALPES-TV 10 B ES # 36 D 13 SUR</option>
                <option value="UPA SAN CRISTOBAL-CL 164 # 7 F 10">UPA SAN CRISTOBAL-CL 164 # 7 F 10</option>
                <option value="UPA YOMASA-KR 1 C ESTE # 81 A 04 SUR">UPA YOMASA-KR 1 C ESTE # 81 A 04 SUR</option>
                <option value="Subred Integrada de Servicios de Salud Norte - Centro de Servicios Especializados Suba-Cra. 104 #50 # 152c">Subred Integrada de Servicios de Salud Norte - Centro de Servicios Especializados Suba-Cra. 104 #50 # 152c</option>
                <option value="Hospital Universitario Méderi Barrios Unidos-Cl. 66a #No. 52-25">Hospital Universitario Méderi Barrios Unidos-Cl. 66a #No. 52-25</option>
                <option value="Hospital de la Policia-Cra. 59 ##26-21">Hospital de la Policia-Cra. 59 ##26-21</option>
                <option value="Hospital De Kennedy- Av. 1 de Mayo #40B-54">Hospital De Kennedy- Av. 1 de Mayo #40B-54</option>
                <option value="Hospital Bosa II Nivel-Calle 65d Sur No. 79C - 90, Bosa Centro">Hospital Bosa II Nivel-Calle 65d Sur No. 79C - 90, Bosa Centro</option>
                <option value="Unidad Médica San Antonio Policía Nacional-# 33 a 2, Cl. 4 Sur">Unidad Médica San Antonio Policía Nacional-# 33 a 2, Cl. 4 Sur</option>
                <option value="Hospital Tunjuelito-Cl. 52 Sur #1416">Hospital Tunjuelito-Cl. 52 Sur #1416</option>
                <option value="USS Vista Hermosa-Calle 67A Sur # 18C-12, Ciudad Bolivar">USS Vista Hermosa-Calle 67A Sur # 18C-12, Ciudad Bolivar</option>
                <option value="Hospital San Cristóbal-Sur, Cra. 7a #30D-44">CAMI CHAPINERO-CL 76 # 20 C 96</option>
                <option value="Fundacion Santa Fe De Bogota Hospital Universitario-Cra. 7b #12390">Fundacion Santa Fe De Bogota Hospital Universitario-Cra. 7b #12390</option>
                <option value="Hospital Centro Oriente CAMI Samper Mendoza-Cra. 22 ##22A-26">Hospital Centro Oriente CAMI Samper Mendoza-Cra. 22 ##22A-26</option>
        </select>
      </div>
      <div class="item">
        <h2>DOCTOR:</h2>
        <select id="Nombre" name="Nombre" required>
          <option value="Hilario Noguera">Hilario Noguera</option>
          <option value="Reyes Gascon">Reyes Gascon</option>
          <option value="Francesc Xavier Vico">Francesc Xavier Vico</option>
          <option value="Brian Postigo">Brian Postigo</option>
          <option value="Camilo Mari">Camilo Mari</option>
          <option value="Diego Muñoz">Diego Muñoz</option>
          <option value="Francisco Borja Nicolas">Francisco Borja Nicolas</option>
          <option value="Carla Murillo">Carla Murillo</option>
          <option value="Salma Vallejo">Salma Vallejo</option>
          <option value="Bouchra Mari">Bouchra Mari</option>
          <option value="Ascension Feijoo">Ascension Feijoo</option>
          <option value="Clara Paz">Clara Paz</option>
          <option value="Carolina Lamas">Carolina Lamas</option>
          <option value="Maialen Nieto">Maialen Nieto</option>
          <option value="Maria Magdalena Parada">Maria Magdalena Parada</option>
          <option value="Marcela Hidalgo">Marcela Hidalgo</option>
          <option value="Andrea Camara">Andrea Camara</option>
          <option value="Samir Olmo">Samir Olmo</option>
          <option value="Ivet Aguado">Ivet Aguado</option>
          <option value="Emiliana Cornejo">Emiliana Cornejo</option>
          <option value="Karen Abril">Karen Abril</option>
          <option value="Julia Agullo">Julia Agullo</option>
          <option value="Ismael Blanco">Ismael Blanco</option>
          <option value="Michael Guillen">Michael Guillen</option>
          <option value="Sonia Mateo">Sonia Mateo</option>
          <option value="Dionisia Mora">Dionisia Mora</option>
          <option value="Julieta Prado">Julieta Prado</option>
          <option value="Anselmo Canovas">Anselmo Canovas</option>
          <option value="Marta Aguilera">Marta Aguilera</option>
          <option value="Samuel Parada">Samuel Parada</option>
          <option value="Eliseo Arana">Eliseo Arana</option>
          <option value="Frank Villa">Frank Villa</option>
        </select>
      </div>
      <div class="item">
        <h2>FECHA:</h2>
        <input type="date" name="fecha" value="">
      </div>
      <div class="item">
        <h2>HORA:</h2>
        <select id="Hora" name="Hora" required>
                <option value="">Seleccione</option>
                <option value="8 A.M.">8 A.M.</option>
                <option value="5 P.M.">5 P.M.</option>
        </select>
      </div>
    NO SUPE HACER LO DE DESBLOQUEAR POR PARTECITAS LAS OPCIONES :'C
  </section>
  <div id="Navegacion">
    <ul>
      <li><a href="homePaciente.html">Inicio</a></li>
      <li><a href="PerfilPaciente.html">Ver Perfil</a></li>
      <li><a href="index.html">Cerrar Sesión</a></li>
    </ul>
  </div>
  </body>
  <script src="JS/Barra.js"></script>
</html>
