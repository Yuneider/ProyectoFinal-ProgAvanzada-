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
                document.getElementById("hospital").innerHTML =this.responseText;  
                document.getElementById("hospital").disabled=false;
                document.getElementById("fecha").disabled=false;
                document.getElementById('especialidad').options[0].selected = true;
                document.getElementById('doctor').options[0].selected = true;
                document.getElementById('hora').options[0].selected = true;
            }
        };
        xhttp.open("POST", url, true);
        xhttp.send();
    }
}
function habilitarHora(value){
    if(value=="0"){
        document.getElementById("hora").disabled=true;
    }else{
        var fecha_correcta = ValidarFechas();
        if(fecha_correcta==true){
            var fecha_aux = document.getElementById("fecha").value.split("-");
            var fecha = fecha_aux[2]+"/"+fecha_aux[1]+"/"+fecha_aux[0];
            const url = "Validaciones?tipoValidacion=disponibilidadCita&hospital="+document.getElementById("hospital").value+
                        "&doctor="+document.getElementById("doctor").value+"&fecha="+fecha;
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("hora").innerHTML =this.responseText;  
                    document.getElementById("hora").disabled=false;
                }
            };
            xhttp.open("POST", url, true);
            xhttp.send();
        }
    }
}
function habilitarEspecialidad(value){
    if(value=="0"){
        document.getElementById("especialidad").disabled=true;
    }else{
        document.getElementById('especialidad').options[0].selected = true;
        document.getElementById('doctor').options[0].selected = true;
        document.getElementById('hora').options[0].selected = true;
        document.getElementById("especialidad").disabled=false;
    }
}
function habilitarDoctor(value){
    if(value=="0"){
        document.getElementById("doctor").disabled=true;
    }else{
        const url = "Validaciones?tipoValidacion=doctorEspecialidad&especialidad="+document.getElementById("especialidad").value+"&hospital="+document.getElementById("hospital").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById("doctor").innerHTML =this.responseText;  
                document.getElementById("doctor").disabled=false;
                document.getElementById('doctor').options[0].selected = true;
                document.getElementById('hora').options[0].selected = true;
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
                return true;
            }else{
                alert("Fecha introducida fuera de el rango autorizado");
                return false;
            }
        }else if(Fecha1.getMonth()==max.getMonth()){
            if(Fecha1.getDate()<=max.getDate()){
                return true;
            }
            else{
                alert("Fecha introducida fuera de el rango autorizado");
                return false;
            }
        }else{
            alert("Fecha introducida fuera de el rango autorizado");
            return false;
        }
    }
}
function CrearCita(){
    var validaciones=0;
    if(ValidarFechas()==true){
        validaciones=validaciones+1;
    }
    if(document.getElementById("localidad").value!="0"){
        validaciones=validaciones+1;
    }
    if(document.getElementById("hospital").value!="0"){
        validaciones=validaciones+1;
    }
    if(document.getElementById("especialidad").value!="0"){
        validaciones=validaciones+1;
    }
    if(document.getElementById("doctor").value!="0"){
        validaciones=validaciones+1;
    }
    if(document.getElementById("hora").value!="0"){
        validaciones=validaciones+1;
    }
    if(validaciones==6){
        document.getElementById("formulario").action="Acciones";
        document.getElementById("formulario").submit();
    }else{
        event.preventDefault();
        alert("Error: Por favor verifique todos los campos");
    }
}

















