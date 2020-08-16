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
function mostrarContrasena(){
    event.preventDefault();
    var tipo = document.getElementById("contrasena");
    if(tipo.type == "password"){
    	tipo.type = "text";
    }else{
        tipo.type = "password";
    }
}
function ingresar(){
    var validaciones=0;
    
    if(document.getElementById("usuario").value != ""){
        validaciones=validaciones+1;
    }
    
    if(document.getElementById("contrasena").value != ""){
        validaciones=validaciones+1;
    }
    
    if(validaciones!=2){
        document.getElementById("error_ingreso").innerHTML = "Error: Debe compretar los campos obligatorios.";
    }else{
        const url = "Validaciones?tipoValidacion=ingresoCorrecto&usuario="+document.getElementById("usuario").value+"&contrasena="+document.getElementById("contrasena").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("error_ingreso").innerHTML = this.responseText;
                if(this.responseText == ""){
                    document.getElementById("datos").action="Ingreso";
                    document.getElementById("datos").submit();
                }        
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }
}
