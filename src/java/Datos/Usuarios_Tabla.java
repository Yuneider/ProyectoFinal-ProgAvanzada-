package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuarios_Tabla {

    Conexion con = new Conexion();

    public boolean ExisteUsuario(String usuario,String contrasena){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT usuario,contrasena FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(rs.getString("contrasena").equals(contrasena)){
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios_Tabla.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public static void main(String[] args) {
        Usuarios_Tabla UT = new Usuarios_Tabla();
        UT.ExisteUsuario("yune","yune");
    }
}
