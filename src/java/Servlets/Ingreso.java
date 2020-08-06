package Servlets;

import Datos.BaseDeDatos;
import Logica.Paciente;
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
        try (PrintWriter out = response.getWriter()) {
                if(request.getParameter("opcion").equals("ingreso")){
                String correo = request.getParameter("correo"); 
                String contrasena = request.getParameter("contrasena");
                out.print(bd.ExisteUsuario_Usuarios(correo, contrasena));
            }
            if(request.getParameter("opcion").equals("registrarse")){      //Click en registrarse
                Paciente p = new Paciente();
                p.setBarrio(request.getParameter("barrio"));
                p.setCelular(request.getParameter("celular"));
                p.setCorreo(request.getParameter("correo"));
                p.setDir(request.getParameter("direccion"));
                p.setDni(Integer.parseInt(request.getParameter("dni")));
                p.setUsuario(request.getParameter("nombre")); 
                p.setEdad(CalcularEdad(request.getParameter("fecha_nacimiento")));
                
                bd.InsertarPaciente_Pacientes(p);
                out.print("hecho");
            }
            if(request.getParameter("opcion").equals("contrasena")){        //Click en olvidó su contraseña            
                out.print(request.getParameter("opcion"));
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
