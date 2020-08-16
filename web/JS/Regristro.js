/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarAjax() {
    var validaciones=0;
    
    //Campo documento
    if(document.getElementById("dni").value == ""){
        document.getElementById("valDocumento").innerHTML = "(*)";
    }else{
        
        const url = "Validaciones?tipoValidacion=existeDni&dni="+ document.getElementById("dni").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("valDocumento").innerHTML = this.responseText;
                if(this.responseText == ""){
                    validaciones=validaciones+1;
                }        
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }
    
    //Campo nombre
    if(document.getElementById("nombre").value == ""){
        document.getElementById("valNombre").innerHTML = "(*)";
    }else{
        document.getElementById("valNombre").innerHTML = "";
        validaciones=validaciones+1;
    }
    
    //Campo correo
    if(document.getElementById("correo").value == ""){
        document.getElementById("valCorreo").innerHTML = "(*)";
    }else{
        document.getElementById("valCorreo").innerHTML = "";
        validaciones=validaciones+1;
    }
    
    //Campo celular
    if(document.getElementById("celular").value == ""){
        document.getElementById("valCelular").innerHTML = "(*)";
    }else{
        document.getElementById("valCelular").innerHTML = "";
        validaciones=validaciones+1;
    }
    
    //Campo direccion
    if(document.getElementById("direccion").value == ""){
        document.getElementById("valDireccion").innerHTML = "(*)";
    }else{
        document.getElementById("valDireccion").innerHTML = "";
        validaciones=validaciones+1;
    }
    
    //Campo contraseña
    if(document.getElementById("contra").value == ""){
        document.getElementById("valContrasena").innerHTML = "(*)";
    }else{
        document.getElementById("valContrasena").innerHTML = "";
        validaciones=validaciones+1;
    }
    
    //Campo confirmacion contraseña
    if(document.getElementById("contra_confirmacion").value == ""){
        document.getElementById("valConfirmacion").innerHTML = "(*)";
    }else{
        document.getElementById("valConfirmacion").innerHTML = "";
        validaciones=validaciones+1;
    }
    
    //Campo usuario
    if(document.getElementById("usuario").value == ""){
        document.getElementById("valUsuario").innerHTML = "(*)";
    }else{
        const url = "Validaciones?tipoValidacion=existeUsuario&usuario="+ document.getElementById("usuario").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("valUsuario").innerHTML = this.responseText;
                if(this.responseText == ""){
                    if(document.getElementById("contra").value != document.getElementById("contra_confirmacion").value){
                        alert("Las contraseñas son diferentes");
                    }else{  
                        if(validaciones==7){
                            document.getElementById("usuarioRegistrado").action="Ingreso";
                            document.getElementById("usuarioRegistrado").submit();
                        }
                    }
                }        
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();        
    }
    if(validaciones!=7){
        document.getElementById("campos_obligatorios").innerHTML = "(*) Campos obligatorios";
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

