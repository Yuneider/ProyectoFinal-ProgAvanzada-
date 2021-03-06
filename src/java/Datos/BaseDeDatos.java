package Datos;

import Logica.*;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BaseDeDatos {

    static Conexion con = new Conexion();

    public boolean ExisteUsuario_Usuarios(String usuario, String contrasena) {
        try {
            if (ValidarUsuario_Usuarios(usuario)) {
                PreparedStatement ps = con.Conexion().prepareStatement("SELECT contrasena FROM `usuarios` WHERE usuario=?;");
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return rs.getString("contrasena").equals(contrasena);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean ValidarUsuario_Usuarios(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT usuario FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return true;
        }
    }

    public void InsertarUsuario_Usuarios(String usuario, String contrasena, String rol) {
        try {
            if (!ValidarUsuario_Usuarios(usuario)) {
                PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `usuarios` (usuario,contrasena,rol) VALUES(?,?,?);");
                ps.setString(1, usuario);
                ps.setString(2, contrasena);
                ps.setString(3, rol);
                ps.executeUpdate();
            } else {
                System.out.println("Usuario repetido");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void EliminarUsuario_Usuarios(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String GetRol_Usuarios(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select rol FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("rol");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String GetContra_Usuarios(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select contrasena FROM `usuarios` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("contrasena");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String GetCorreo_Pacientes(String nombre){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select correo FROM `pacientes` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("correo");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public boolean ValidarPaciente_Pacientes(String dni) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT dni FROM `pacientes` WHERE dni=?;");
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ValidarUsuario_Pacientes(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT usuario FROM `pacientes` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("usuario").equals(usuario);
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void InsertarPaciente_Pacientes(Paciente p) {
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
            InsertarUsuario_Usuarios(p.getUsuario(), p.getContrasena(), "Paciente");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void EliminarPaciente_Pacientes(String dni, String usuario, String nombre) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `pacientes` WHERE dni=?;");
            ps.setString(1, dni);
            ps.executeUpdate();
            EliminarUsuario_Usuarios(usuario);
            EliminarCitasporPaciente_Citas(nombre);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public String GetUsuario_Pacientes(String correo) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select usuario FROM `pacientes` WHERE correo=?;");
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("usuario");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public Paciente GetPaciente_Pacientes(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select * FROM `pacientes` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
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
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public boolean ValidarNombreDoctor_Doctores(String nombre) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT nombre FROM `doctores` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public Doctor GetDoctor_Doctores(String usuario) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select * FROM `doctores` WHERE usuario=?;");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Doctor d = new Doctor();
                d.setNombre(rs.getString("nombre"));
                d.setHospital(rs.getString("hospital"));
                d.setEspecialidad(rs.getString("especialidad"));
                d.setUsuario(rs.getString("usuario"));
                return d;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public String GetNombreDoctor_Doctores(String hospital, String especialidad) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select nombre FROM `doctores` WHERE hospital=? AND especialidad=?;");
            ps.setString(1, hospital);
            ps.setString(2, especialidad);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("fallo");
            return null;
        }
    }

    public void InsertarDoctor_Doctores(Doctor d) {
        try {
            if (!ValidarNombreDoctor_Doctores(d.getNombre())) {
                PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `doctores` (hospital,nombre,especialidad,usuario) VALUES(?,?,?,?);");
                ps.setString(1, d.getHospital());
                ps.setString(2, d.getNombre());
                ps.setString(3, d.getEspecialidad());
                ps.setString(4, d.getUsuario());
                ps.executeUpdate();
                InsertarUsuario_Usuarios(d.getUsuario(), d.getContrasena(), "Doctor");
            } else {
                System.out.println("Nombre repetido");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void EliminarDoctor_Doctores(String usuario) {
        try {
            PreparedStatement ps1 = con.Conexion().prepareStatement("Select nombre FROM `doctores` WHERE usuario=?;");
            ps1.setString(1, usuario);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                EliminarUsuario_Usuarios(usuario);
                EliminarCitasporDoctor_Citas(rs.getString("nombre"));
            }
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `doctores` WHERE usuario=?;");
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void InsertarCita_Citas(Cita c) throws UnsupportedEncodingException {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO `citas` (hospital,fecha,hora,doctor,paciente,estado,comentario) VALUES(?,?,?,?,?,?,?);");
            ps.setString(1, c.getHospital());
            ps.setString(2, c.getFecha());
            ps.setInt(3, c.getHora());
            ps.setString(4, c.getDoctor());
            ps.setString(5, c.getPaciente());
            ps.setInt(6, c.getEstado());
            ps.setString(7, c.getComentario());
            ps.executeUpdate();
            String mensaje ="Cordial saludo por parte de todo el equipo Medicine-Plus. "
                        + "Es para nosotros un placer prestarte nuestros servicios.\n\n"
                        + "Queremos notificarte que tu cita quedó programada para el dia "+c.getFecha()
                        + " a las "+c.getHora()+":00, con el Dr(a) "+c.getDoctor()
                        + ", en la dirección: "+GetDir_Hosptiales(c.getHospital())+" ("+c.getHospital()
                        + ").\n\nMuchas gracias por usar nuestros servicios.";
            EnviarCorreo(GetCorreo_Pacientes(c.getPaciente()),mensaje,"Confirmación de su cita");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public String GetPaciente_Citas(int id){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select paciente FROM `citas` WHERE id=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("paciente");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    public void ModificarEstadoCita_Citas(int id, int estado) throws UnsupportedEncodingException {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("UPDATE citas SET estado=? WHERE id=?;");
            ps.setInt(1, estado);
            ps.setInt(2, id);
            ps.executeUpdate();
            String mensaje ="Cordial saludo por parte de todo el equipo Medicine-Plus. \n\n"
                        + "Es para nosotros un placer prestarte nuestros servicios.\n\n"
                        + "Queremos notificarle que tu cita ha sido cancelada\n\n"
                        + "Muchas gracias por usar nuestros servicios.";
            EnviarCorreo(GetCorreo_Pacientes(GetPaciente_Citas(id)),mensaje,"Modificación de su cita");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void CitaRealizada_Citas(int id) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("UPDATE citas SET estado=? WHERE id=?;");
            ps.setInt(1, 4);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void EliminarCitasporPaciente_Citas(String paciente) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `citas` WHERE paciente=?;");
            ps.setString(1, paciente);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void EliminarCitasporDoctor_Citas(String doctor) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Delete FROM `citas` WHERE doctor=?;");
            ps.setString(1, doctor);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean ValidarNombreHospital_Hospitales(String nombre) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT nombre FROM `hospitales` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ValidarDirHospital_Hospitales(String dir) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT dir FROM `hospitales` WHERE dir=?;");
            ps.setString(1, dir);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean ExisteHospital_Hospitales(String nombre) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("SELECT nombre FROM `hospitales` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
    
    public String GetNombreHospital_Hospitales(String localidad) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select nombre FROM `hospitales` WHERE localidad=?;");
            ps.setString(1, localidad);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("nombre");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("fallo");
            return null;
        }
    }
    
    public void InsertarHospital_Hospitales(Hospital h) {
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("INSERT INTO hospitales (nombre,dir,localidad) VALUES(?,?,?);");
            ps.setString(1, h.getNombre());
            ps.setString(2, h.getDir());
            ps.setString(3, h.getLocalidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void EliminarHospital_Hospitales(String nombre) { //ELIMINAR DOCTORES DE ESE HOSPITAL
        try {
            PreparedStatement ps1 = con.Conexion().prepareStatement("Delete FROM `hospitales` WHERE nombre=?;");
            ps1.setString(1, nombre);
            ps1.executeUpdate();
            PreparedStatement ps2 = con.Conexion().prepareStatement("SELECT nombre FROM `doctores` WHERE hospital=?;");
            ps2.setString(1, nombre);
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                EliminarDoctor_Doctores(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
    public String GetDir_Hosptiales(String nombre){
        try {
            PreparedStatement ps = con.Conexion().prepareStatement("Select dir FROM `hospitales` WHERE nombre=?;");
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("dir");
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public void EnviarCorreo(String correo, String mensaje, String asunto) throws UnsupportedEncodingException {
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "medinice.plus@gmail.com";
        String contrasena = "vxnprjlttsposofv";
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia,"Medicine-Plus"));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }

}
