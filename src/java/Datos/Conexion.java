package Datos;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public Connection Conexion(){
        Connection conexion=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.  getConnection("jdbc:mysql://localhost:3308/agendarcitas","root","");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
    }
    
}
