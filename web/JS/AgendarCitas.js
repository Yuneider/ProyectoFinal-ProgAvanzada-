//Inicializacion de fechas 
establecerFechas();

function habilitarHospital(value){
    if(value=="0"){
        document.getElementById("hospital").disabled=true;
    }else{
        const url = "Validaciones?tipoValidacion=hospitalLocalidad&localidad="+document.getElementById("localidad").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("hospital").innerHTML = "Hospital: "+this.responseText;  
                document.getElementById("especialidad").disabled=false;
                document.getElementById("fecha").disabled=false;
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }
}
function habilitarDoctor(value){
    if(value=="0"){
        document.getElementById("hora").disabled=true;
    }else{
        const url = "Validaciones?tipoValidacion=doctorEspecialidad&especialidad="+document.getElementById("especialidad").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("doctor").innerHTML = "Doctor: "+this.responseText;  
                document.getElementById("hora").disabled=false;
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
function ValidarFechas(){
    //Comprobamos que tenga formato correcto
    var fecha_aux = document.getElementById("fecha").value.split("-");
    var Fecha1 = new Date(parseInt(fecha_aux[0]),parseInt(fecha_aux[1])-1,parseInt(fecha_aux[2]));

    if (isNaN(Fecha1)){
        alert("Fecha introducida no existe");
    }else{
        fecha_aux = document.getElementById("fecha").max.split("-");
        var max = new Date(parseInt(fecha_aux[0]),parseInt(fecha_aux[1])-1,parseInt(fecha_aux[2]));
        fecha_aux = document.getElementById("fecha").min.split("-");
        var min = new Date(parseInt(fecha_aux[0]),parseInt(fecha_aux[1]-1),parseInt(fecha_aux[2]));
        if(Fecha1.getMonth()==min.getMonth()){
            if(Fecha1.getDate()>=min.getDate()){
                alert("Fecha correcta");
            }else{
                alert("Fecha introducida fuera de el rango autorizado");
            }
        }else if(Fecha1.getMonth()==max.getMonth()){
            if(Fecha1.getDate()<=max.getDate()){
                alert("Fecha correcta");
            }
            else{
                alert("Fecha introducida fuera de el rango autorizado");
            }
        }else{
            alert("Fecha introducida fuera de el rango autorizado");
        }
    }
}
