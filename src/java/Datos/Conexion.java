package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection Conexion(){
        Connection conexion=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.  getConnection("jdbc:mysql://localhost/pf_agendarcitas","yune","yuneider");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
    
    public static void main(String[] args) {
        Conexion cbd = new Conexion();
        cbd.Conexion();
    }
    
}
