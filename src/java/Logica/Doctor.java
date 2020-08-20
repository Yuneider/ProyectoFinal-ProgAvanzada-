package Logica;

import java.util.Calendar;

public class Doctor {

    private String hospital;
    private String nombre;
    private String especialidad;
    private String usuario;
    private String contrasena;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String FechaActual(){
        Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DATE);
        int mes = fecha.get(Calendar.MONTH)+1;
        int anio = fecha.get(Calendar.YEAR);
        String fechaF="";
        if(dia<10){
            fechaF+="0"+dia;
        }else{
            fechaF+=dia;
        }
        if(mes<10){
            fechaF+="/0"+mes+"/"+anio;
        }else{
            fechaF+="/"+mes+"/"+anio;
        }
        return fechaF;
    }
}    
