
function mostrarContrasena(){
    event.preventDefault();
    var tipo = document.getElementById("contrasena");
    if(tipo.type == "password"){
    	tipo.type = "text";
    }else{
        tipo.type = "password";
    }
}
function habilitarHospital(value){
    if(value=="0"){
        document.getElementById("hospital").disabled=true;
    }else{
        const url = "Validaciones?tipoValidacion=hospitalLocalidad&localidad="+document.getElementById("localidad").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("hospital").innerHTML =this.responseText;  
                document.getElementById("hospital").disabled=false;
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }
}
function crearDoctor(){
    const url = "Validaciones?tipoValidacion=existeUsuario&usuario="+ document.getElementById("usuario").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("error").innerHTML = this.responseText;
            if(this.responseText == ""){
                document.getElementById("form").submit();
            }        
        }
    };
    xhttp.open("POST", url, true);
    xhttp.send();        
}
