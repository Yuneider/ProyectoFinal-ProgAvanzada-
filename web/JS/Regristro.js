/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarAjax() {
    //Campo documento
    if(!document.getElementById("dni").value == ""){
        const url = "Validaciones?tipoValidacion=existeDni&dni="+ document.getElementById("dni").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("valDocumento").innerHTML = this.responseText;
                if(this.responseText == ""){
                    document.getElementById("valDocumento").innerHTML = "(*)";
                    ValidarCampos();
                }        
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }else{
        document.getElementById("valDocumento").innerHTML = "(*)";
        document.getElementById("campos_obligatorios").innerHTML = "(*) Faltan campos obligatorios";
    }
}

function ValidarCampos(){    
    var validaciones=0;
    //Campo nombre
    if(!document.getElementById("nombre").value == ""){
        validaciones=validaciones+1;
    }
    
    //Validacion fecha de nacimiento
    var fechaVal = CompararFechas();
    if(fechaVal==true){
        validaciones=validaciones+1;
    }
    
    //Campo correo
    if(!document.getElementById("correo").value == ""){
        validaciones=validaciones+1;
    }
    
    //Campo celular
    var celular = document.getElementById("celular").value;
    if(celular.length<10){
        document.getElementById("valCelular").innerHTML = "(Numero imcompleto)";
    }else{
        document.getElementById("valCelular").innerHTML = "(*)";
        validaciones=validaciones+1;
    }
    
    //Campo direccion
    if(!document.getElementById("direccion").value == ""){
        validaciones=validaciones+1;
    }
    
    //Campo contraseña
    if(!document.getElementById("contra").value == ""){
        validaciones=validaciones+1;
    }
    
    //Campo confirmacion contraseña
    if(!document.getElementById("contra_confirmacion").value == ""){
        validaciones=validaciones+1;
    }
    
    //Campo usuario
    if(!document.getElementById("usuario").value == ""){
        const url = "Validaciones?tipoValidacion=existeUsuario&usuario="+ document.getElementById("usuario").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("valUsuario").innerHTML = this.responseText;
                if(this.responseText == ""){
                    document.getElementById("valUsuario").innerHTML = "(*)";
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
    }else{
        document.getElementById("valUsuario").innerHTML = "(*)";
        document.getElementById("campos_obligatorios").innerHTML = "(*) Faltan campos obligatorios";
    }
}

function CompararFechas(){
    //Comprobamos que tenga formato correcto
    var fecha_aux = document.getElementById("fecha_nacimiento").value.split("-");
    var Fecha1 = new Date(parseInt(fecha_aux[0]),parseInt(fecha_aux[1]-1),parseInt(fecha_aux[2]));

    //Comprobamos si existe la fecha
    if (isNaN(Fecha1)){
        alert("Fecha introducida no existe");
        return false;
    }
    else{
        var fechaActual = new Date();
        if (fechaActual.getFullYear()-Fecha1.getFullYear()>17 && fechaActual.getFullYear()-Fecha1.getFullYear()<100){
            return true;
        }else{
            alert("Fecha fuera de rango");
            return false;
        }
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

