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
    
    public void InsertarUsuario_Usuarios(String usuario, String contrasena,String rol){
        try {
            if(!ValidarUsuario_Usuarios(usuario)){
                PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `usuarios` (usuario,contrasena,rol) VALUES(?,?,?);");
                ps.setString(1, usuario);
                ps.setString(2, contrasena);
                ps.setString(3, rol);
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
    
    public String GetRol_Usuarios(String usuario){
         try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select rol FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("rol");
            }else{
                return null;
            }
         } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public String GetContra_Usuarios(String usuario){
         try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select contrasena FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("contrasena");
            }else{
                return null;
            }
         } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public boolean ValidarPaciente_Pacientes(String dni){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT dni FROM `pacientes` WHERE dni=?;");
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean ValidarUsuario_Pacientes(String usuario){
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
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `pacientes` (dni,usuario,nombre,edad,correo,dir,barrio,celular) VALUES(?,?,?,?,?,?,?,?);");
            ps.setString(1, p.getDni());
            ps.setString(2, p.getUsuario());
            ps.setString(3, p.getNombre());
            ps.setInt(4, p.getEdad());
            ps.setString(5, p.getCorreo());
            ps.setString(6, p.getDir());
            ps.setString(7, p.getBarrio());
            ps.setString(8, p.getCelular());
            ps.executeUpdate();
            InsertarUsuario_Usuarios(p.getUsuario(),p.getContrasena(),"Paciente"); 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarPaciente_Pacientes(String dni,String usuario){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `pacientes` WHERE dni=?;");
            ps.setString(1, dni);
            ps.executeUpdate();
            EliminarUsuario_Usuarios(usuario);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public String GetUsuario_Pacientes(String correo){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select usuario FROM `pacientes` WHERE correo=?;");
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getString("usuario");
            }else{
                return null;
            }
         } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
     public Paciente GetPaciente_Pacientes(String usuario){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select * FROM `pacientes` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Paciente p = new Paciente();
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setEdad(rs.getInt("edad"));
                p.setCorreo(rs.getString("correo"));
                p.setCelular(rs.getString("celular"));
                p.setBarrio(rs.getString("barrio"));
                p.setDir(rs.getString("dir"));
                p.setUsuario(rs.getString("usuario"));
                return p;
            }else{
                return null;
            }
         } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public boolean ValidarNombreDoctor_Doctores(String nombre){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT nombre FROM `doctores` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public Doctor GetDoctor_Doctores(String nombre){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select * FROM `doctores` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Doctor d = new Doctor();
                d.setNombre(rs.getString("nombre"));
                d.setHospital(rs.getString("hospital"));
                d.setEspecialidad(rs.getString("especialidad"));
                d.setUsuario(rs.getString("usuario"));
                return d;
            }else{
                return null;
            }
         } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public void InsertarDoctor_Doctores(Doctor d){
        try {
            if(!ValidarNombreDoctor_Doctores(d.getNombre())){
                PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `doctores` (hospital,nombre,especialidad,usuario) VALUES(?,?,?,?);");
                ps.setString(1, d.getHospital());
                ps.setString(2, d.getNombre());
                ps.setString(3, d.getEspecialidad());
                ps.setString(4, d.getUsuario());
                ps.executeUpdate();
                InsertarUsuario_Usuarios (d.getUsuario(),d.getNombre(),"Doctor");
            }else{
                System.out.println("Nombre repetido");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarDoctor_Doctores(String usuario){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `doctores` WHERE usuario=?;");
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void InsertarCita_Citas(Cita c){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `citas` (hospital,fecha,hora,doctor,paciente,estado,comentario) VALUES(?,?,?,?,?,?,?);");
            ps.setString(1, c.getHospital());
            ps.setString(2, c.getFecha());
            ps.setInt(3, c.getHora());
            ps.setString(4, c.getDoctor());
            ps.setString(5, c.getPaciente());
            ps.setString(6, "Programada");
            ps.setString(7, c.getComentario());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void CancelarCita_Citas(int id){ 
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("UPDATE citas SET estado=? WHERE id=?;"); 
            ps.setString(1, "Cancelada");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void CitaRealizada_Citas(int id){ 
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("UPDATE citas SET estado=? WHERE id=?;"); 
            ps.setString(1, "Realizada");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public boolean ValidarNombreHospital_Hospitales(String nombre){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT nombre FROM `hospitales` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean ValidarDirHospital_Hospitales(String dir){
        try{
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT dir FROM `hospitales` WHERE dir=?;");
            ps.setString(1, dir);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void InsertarHospital_Hospitales(Hospital h){
        try {
            if(!ValidarNombreHospital_Hospitales(h.getNombre()) && !ValidarDirHospital_Hospitales(h.getDir())){
                PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `hospitales` (nombre,dir,localidad) VALUES(?,?,?);");
                ps.setString(1, h.getNombre());
                ps.setString(2, h.getDir());
                ps.setString(3, h.getLocalidad());
                ps.executeUpdate();
            }else{
                System.out.println("El hospital ya existe");
            } 
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarHospital_Hospitales(String nombre){ //ELIMINAR DOCTORES DE ESE HOSPITAL
        try {
            PreparedStatement ps1 = con.Conexion().prepareStatement("Delete FROM `hospitales` WHERE nombre=?;");
            ps1.setString(1, nombre);
            ps1.executeUpdate();
            PreparedStatement ps2 = con.Conexion().prepareStatement("SELECT nombre FROM `doctores` WHERE hospital=?;");
            ps2.setString(1, nombre);
            ResultSet rs = ps2.executeQuery();
            while(rs.next()){
                EliminarDoctor_Doctores(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
 
}
