package Servlets;

import Datos.BaseDeDatos;
import Logica.Admin;
import Logica.Doctor;
import Logica.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ingreso extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    BaseDeDatos bd = new BaseDeDatos();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("opcion").equals("ingreso")){       //Click en ingresar
                String usuario = request.getParameter("usuario"); 
                String contrasena = request.getParameter("contrasena"); 
                if(bd.ExisteUsuario_Usuarios(usuario, contrasena)){   //usuario existe
                    if(bd.GetRol_Usuarios(usuario).equals("Paciente")){
                        Paciente p = bd.GetPaciente_Pacientes(usuario);
                        request.getSession().setAttribute("paciente", p);
                        response.sendRedirect("HomePaciente.jsp");
                    }
                    if(bd.GetRol_Usuarios(usuario).equals("Admin")){
                        response.sendRedirect("HomeAdmin.jsp");
                    }
                    if(bd.GetRol_Usuarios(usuario).equals("Doctor")){
                        Doctor d = bd.GetDoctor_Doctores(usuario);
                        request.getSession().setAttribute("doctor", d);
                        response.sendRedirect("HomeDoctor.jsp");
                    }
                }else{
                    response.sendRedirect("index.jsp");
                }
            }
            if(request.getParameter("opcion").equals("registrarse")){      //Click en registrarse
                Paciente p = new Paciente();
                p.setBarrio(request.getParameter("barrio"));
                p.setCelular(request.getParameter("celular"));
                p.setCorreo(request.getParameter("correo"));
                p.setDir(request.getParameter("direccion"));
                p.setDni(Integer.parseInt(request.getParameter("dni")));
                p.setUsuario(request.getParameter("usuario")); 
                p.setEdad(CalcularEdad(request.getParameter("fecha_nacimiento")));
                p.setNombre(request.getParameter("nombre"));
                p.setContrasena(request.getParameter("contra"));
                bd.InsertarPaciente_Pacientes(p);
                response.sendRedirect("index.jsp");
            }
            if(request.getParameter("opcion").equals("olvido_contrasena")){        //Click en olvidó su contraseña            
                String correo = request.getParameter("correo_olvido");
                String mensaje ="Buen día. \n\n"
                        + "Esta es su contraseña: "+bd.GetContra_Usuarios(bd.GetUsuario_Pacientes(correo))+" "
                        + "recomentamos su uso adecuando.\n\n"
                        + "Muchas gracias por usar nuestros servicios.";
                EnviarCorreo(correo, mensaje, "¿Olvidaste tu contraseña?");
                response.sendRedirect("index.jsp");
            }
            if(request.getParameter("opcion").equals("eliminarDoctor")){   //click en Eliminar Doctor
                bd.EliminarDoctor_Doctores(request.getParameter("usuario"));
                response.sendRedirect("VerDoctores.jsp");
            }
            if(request.getParameter("opcion").equals("eliminarPaciente")){   //click en Eliminar Paciente
                bd.EliminarPaciente_Pacientes(Integer.parseInt(request.getParameter("dni")),request.getParameter("usuario"));
                response.sendRedirect("VerPacientes.jsp");
            }
        }
    }
    
    private void EnviarCorreo(String correo,String mensaje, String asunto){
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "587");
        propiedad.setProperty("mail.smtp.auth", "true");
        Session sesion = Session.getDefaultInstance(propiedad);
        String correoEnvia = "cgpmedicineplus@gmail.com";
        String contrasena = "CGPMedicine";
        MimeMessage mail = new MimeMessage(sesion);
        try {
            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            mail.setSubject(asunto);
            mail.setText(mensaje);
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia,contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
        } catch (MessagingException ex) {
            System.out.println(ex);
        }
    }
    
    private int CalcularEdad(String fecha){
        return 2020-Integer.parseInt(String.valueOf(fecha.charAt(0))+String.valueOf(fecha.charAt(1))+String.valueOf(fecha.charAt(2))+String.valueOf(fecha.charAt(3)));
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
