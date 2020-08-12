package Datos;

import Logica.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDeDatos {

    static Conexion con = new Conexion();

    public boolean ExisteUsuario_Usuarios(String usuario,String contrasena){
        try{
            if(ValidarUsuario_Usuarios(usuario)){
                PreparedStatement ps = con.Conexion().prepareStatement("SELECT contrasena FROM `usuarios` WHERE usuario=?;");
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    return rs.getString("contrasena").equals(contrasena);
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }catch(SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public boolean ValidarUsuario_Usuarios(String usuario){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT usuario FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }
    
    public void InsertarUsuario_Usuarios(String usuario, String contrasena){
        try {
            if(!ValidarUsuario_Usuarios(usuario)){
                PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `usuarios` (usuario,contrasena,rol) VALUES(?,?,?);");
                ps.setString(1, usuario);
                ps.setString(2, contrasena);
                ps.setString(3, "paciente");
                ps.executeUpdate();
            }else{
                System.out.println("Usuario repetido");
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarUsuario_Usuarios(String usuario){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    private boolean ValidarPaciente_Pacientes(int dni){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT dni FROM `pacientes` WHERE dni=?;");
            ps.setString(1, String.valueOf(dni));
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    private boolean ValidarUsuario_Pacientes(String usuario){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT usuario FROM `pacientes` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("usuario").equals(usuario);
            }else{
                return false;
            }
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void InsertarPaciente_Pacientes(Paciente p){
         try {
             if(ValidarPaciente_Pacientes(p.getDni())||ValidarUsuario_Pacientes(p.getUsuario())){
                 System.out.println("El paciente ya está registrado");
             }else{
                 PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `pacientes` (dni,usuario,nombre,edad,correo,dir,barrio,celular) VALUES(?,?,?,?,?,?,?,?);");
                 ps.setInt(1, p.getDni());
                 ps.setString(2, p.getUsuario());
                 ps.setString(3, p.getNombre());
                 ps.setInt(4, p.getEdad());
                 ps.setString(5, p.getCorreo());
                 ps.setString(6, p.getDir());
                 ps.setString(7, p.getBarrio());
                 ps.setString(8, p.getCelular());
                 ps.executeUpdate();
                 InsertarUsuario_Usuarios(p.getUsuario(),p.getContrasena());
             }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarPaciente_Pacientes(int dni){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `pacientes` WHERE dni=?;");
            ps.setInt(1, dni);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void InsertarDoctor_Doctores(Doctor d){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `doctores` (hospital,nombre,especialidad) VALUES(?,?,?);");
            ps.setString(1, d.getHospital());
            ps.setString(2, d.getNombre());
            ps.setString(3, d.getEspecialidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarDoctor_Doctores(String nombre){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `doctores` WHERE nombre=?;");
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void InsertarCita_Citas(Cita c){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `citas` (hospital,fecha,hora,doctor,paciente,estado) VALUES(?,?,?,?,?,?);");
            ps.setString(1, c.getHospital());
            ps.setString(2, c.getFecha());
            ps.setInt(3, c.getHora());
            ps.setString(4, c.getDoctor());
            ps.setString(5, c.getPaciente());
            ps.setString(6, c.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void CancelarCita_Citas(int id){ //TERMINAR FUNCION - SETEAR ESTADO A CANCELADA
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `citas` (estado) WHERE id=?;"); 
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void InsertarHospital_Hospitales(Hospital h){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `hospitales` (nombre,dir,barrio) VALUES(?,?,?);");
            ps.setString(1, h.getNombre());
            ps.setString(2, h.getDir());
            ps.setString(3, h.getBarrio());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarHospital_Hospitales(String nombre){ //ELIMINAR DOCTORES DE ESE HOSPITAL
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `hospitales` WHERE nombre=?;");
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public static void main(String[] args) {
    }
    
}
