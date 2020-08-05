/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Recuperar(){
    if (document.getElementById("olvido_contrasena").style.display === "none"){
        document.getElementById("datos_ingreso").style.display= "none";
        document.getElementById("nuevo_paciente").style.display= "none";
        document.getElementById("olvido_contrasena").style.display= "inline";
        var cambio = document.getElementById("recuperar").value = "Iniciar Sesión";
    }else{
        document.getElementById("datos_ingreso").style.display= "inline";
        document.getElementById("nuevo_paciente").style.display= "inline";
        document.getElementById("olvido_contrasena").style.display= "none";
        var cambio = document.getElementById("recuperar").value = "¿Olvido su contraseña?";
    }
}




