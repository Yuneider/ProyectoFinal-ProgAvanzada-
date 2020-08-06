package Datos;

import Logica.Paciente;
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
    
    private boolean ValidarUsuario_Usuarios(String usuario){
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
    
}
