function CrearHospital(){
    var validaciones = 0;
    if(!document.getElementById("hospital").value==""){
        const url = "Validaciones?tipoValidacion=existeHospital&hospital="+ document.getElementById("hospital").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200){
                document.getElementById("error").innerHTML = this.responseText;
                if(this.responseText == ""){
                    if(document.getElementById("localidad").value!="0"){
                        ++validaciones;
                    }
                    if(!document.getElementById("direccion").value==""){
                        ++validaciones;
                    }
                    if(validaciones!=2){
                        alert("Error verifique los campos.");
                    }else{
                        document.getElementById("formulario").action="Ingreso";
                        document.getElementById("formulario").submit();
                    }
                }else{
                    return false;
                }        
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }else{
        alert("Error verifique los campos.");
    }
}