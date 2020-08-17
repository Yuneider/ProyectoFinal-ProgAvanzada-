//Inicializacion de fechas 
establecerFechas();

function habilitar(value){
    if(value=="0"){
        document.getElementById("hospital").disabled=true;
    }else{
        const url = "Validaciones?tipoValidacion=hospitalLocalidad&localidad="+document.getElementById("localidad").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("hospital").innerHTML = "Hospital: "+this.responseText;  
                document.getElementById("especialidad").disabled=false;
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }
}
function establecerFechas(){
    var hoy = new Date();
    var inicio = new Date;
    inicio.setDate(hoy.getDate()+1);
    var dia = inicio.getDate();
    var mes = inicio.getMonth()+1;
    var anio = inicio.getFullYear();
    var min = anio,max = anio;;
    if(mes>9){
        min = min+"-"+mes;
    }else{
        min = min+"-0"+mes;
    }
    if(dia>9){
        min = min+"-"+dia;
    }else{
        min = min+"-0"+dia;
    }
    document.getElementById("fecha").min = min;
    
    mes=mes+1;
    if(mes==4 || mes==6 || mes==9 || mes==11){
        if(dia==31){
            dia=30;
        }
    }else if(mes==2){
        if(dia>28){
            dia=28;
        }
    }
    if(mes>9){
        max = max+"-"+mes;
    }else{
        max = max+"-0"+mes;
    }
    if(dia>9){
        max = max+"-"+dia;
    }else{
        max = max+"-0"+dia;
    }
    document.getElementById("fecha").max = max;
    
}

