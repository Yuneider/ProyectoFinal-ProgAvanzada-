/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function Validar(){
    if(document.getElementById("contra").value == document.getElementById("contra_confirmacion").value){
        document.getElementById("usuarioRegistrado").action="Ingreso";
    }else{
     	event.preventDefault();
        alert("Las contraseñas son diferentes");
    }
}
function mostrarContrasena(){
    event.preventDefault();
    var tipo = document.getElementById("contra");
    if(tipo.type == "password"){
    	tipo.type = "text";
    }else{
        tipo.type = "password";
    }
}

