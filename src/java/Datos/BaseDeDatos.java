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
            return false;
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
    
    public  void InsertarPaciente_Pacientes(Paciente p){
         try {
             if(ValidarPaciente_Pacientes(p.getDni())){
                 System.out.println("El paciente ya está registrado");
             }else{
                 PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `pacientes` (dni,usuario,edad,correo,dir,barrio,celular) VALUES(?,?,?,?,?,?,?);");
                 ps.setInt(1, p.getDni());
                 ps.setString(2, p.getUsuario());
                 ps.setInt(3, p.getEdad());
                 ps.setString(4, p.getCorreo());
                 ps.setString(5, p.getDir());
                 ps.setString(6, p.getBarrio());
                 ps.setInt(7, p.getCelular());
                 ps.executeUpdate();
             }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    
}
