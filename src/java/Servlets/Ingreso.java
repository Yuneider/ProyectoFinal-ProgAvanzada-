package Servlets;

import Datos.BaseDeDatos;
import Logica.*;
import java.io.IOException;
import java.io.PrintWriter;
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
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            if(request.getParameter("opcion").equals("ingreso")){       //Click en ingresar
                String usuario = request.getParameter("usuario"); 
                if(bd.GetRol_Usuarios(usuario).equals("Paciente")){
                    Paciente p = bd.GetPaciente_Pacientes(usuario);
                    request.getSession().setAttribute("paciente", p);
                    response.sendRedirect("HomePaciente.jsp");
                }
                if(bd.GetRol_Usuarios(usuario).equals("Admin")){
                    request.getSession().setAttribute("usuario", usuario);
                    response.sendRedirect("HomeAdmin.jsp");
                }
                if(bd.GetRol_Usuarios(usuario).equals("Doctor")){
                    Doctor d = bd.GetDoctor_Doctores(usuario);
                    request.getSession().setAttribute("doctor", d);
                    response.sendRedirect("HomeDoctor.jsp");
                }
            }
            
            if(request.getParameter("opcion").equals("registrarse")){      //Click en registrarse
                Paciente p = new Paciente();
                p.setBarrio(request.getParameter("barrio"));
                p.setCelular(request.getParameter("celular"));
                p.setCorreo(request.getParameter("correo"));
                p.setDir(request.getParameter("direccion"));              
                p.setDni(request.getParameter("dni"));
                p.setUsuario(request.getParameter("usuario")); 
                p.setEdad(CalcularEdad(request.getParameter("fecha_nacimiento")));
                p.setNombre(request.getParameter("nombre"));
                p.setContrasena(request.getParameter("contra"));
                bd.InsertarPaciente_Pacientes(p);
                response.sendRedirect("index.jsp");
            }
            if(request.getParameter("opcion").equals("olvido_contrasena")){        //Click en olvidó su contraseña            
                String correo = request.getParameter("correo_olvido");
                String mensaje ="Cordial saludo por parte de todo el equipo Medicine-Plus. \n\n"
                        + "Nos llego la solicitud de que olvidaste tu contraseña ¡No te preocupes!\n\n"
                        + "Esta es tu contraseña: "+bd.GetContra_Usuarios(bd.GetUsuario_Pacientes(correo))+" "
                        + "Te recordamos que es de uso personal, dale el uso adecuado.\n\n"
                        + "Muchas gracias por usar nuestros servicios.";
                bd.EnviarCorreo(correo, mensaje, "¿Olvidaste tu contraseña?");
                response.sendRedirect("index.jsp");
            }
            if(request.getParameter("opcion").equals("eliminarDoctor")){   //click en Eliminar Doctor
                bd.EliminarDoctor_Doctores(request.getParameter("usuario"));
                response.sendRedirect("VerDoctores.jsp");
            }
            if(request.getParameter("opcion").equals("AgregarDoctor")){   //click en Agregar Doctor
                Doctor d = new Doctor();
                d.setNombre(request.getParameter("nombre"));
                d.setUsuario(request.getParameter("usuario"));
                d.setContrasena(request.getParameter("contrasena"));
                d.setHospital(request.getParameter("hospital"));
                d.setEspecialidad(request.getParameter("especialidad"));
                out.print("ingreso");
                bd.InsertarDoctor_Doctores(d);
                response.sendRedirect("VerDoctores.jsp");
            }
            if(request.getParameter("opcion").equals("eliminarPaciente")){   //click en Eliminar Paciente
                bd.EliminarPaciente_Pacientes(request.getParameter("dni"),request.getParameter("usuario"),request.getParameter("nombre"));
                response.sendRedirect("VerPacientes.jsp");
            }
            if(request.getParameter("opcion").equals("eliminarHospital")){   //click en Eliminar Hospital
                bd.EliminarHospital_Hospitales(request.getParameter("hospital"));
                response.sendRedirect("VerHospitales.jsp");
            }
            if(request.getParameter("opcion").equals("AgregarHospital")){   //click en Agregar Hospital
                Hospital h = new Hospital();
                h.setNombre(request.getParameter("hospital"));
                h.setLocalidad(request.getParameter("localidad"));
                h.setDir(request.getParameter("direccion"));
                bd.InsertarHospital_Hospitales(h);
                response.sendRedirect("VerHospitales.jsp");
            }
            if(request.getParameter("opcion").equals("cancelarCita")){ //click en Cancelar Cita
                bd.ModificarEstadoCita_Citas(Integer.parseInt(request.getParameter("id")),2);
                response.sendRedirect("verCitas.jsp");
            }
            if(request.getParameter("opcion").equals("evolucionarCita")){ //click en Evolucionar Cita
                bd.ModificarEstadoCita_Citas(Integer.parseInt(request.getParameter("id")),4);
                response.sendRedirect("HomeDoctor.jsp");
            }
            if(request.getParameter("opcion").equals("citaIncumplida")){ //click en Cita Incumplida
                bd.ModificarEstadoCita_Citas(Integer.parseInt(request.getParameter("id")),3);
                response.sendRedirect("HomeDoctor.jsp");
            }
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
