package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print("Servlet_Ingreso");
            if(request.getParameter("opcion").equals("ingresar")){              //Click en ingresar
                String usuario = request.getParameter("usuario"); 
                String contrasena = request.getParameter("contrasena");
                //No se si meter rol aquí tambien, para q no cualquiera pueda crearse una cuenta de admi
            }
            if(request.getParameter("registrarse").equals("registrarse")){      //Click en registrarse
                
            }
            if(request.getParameter("contrasena").equals("contrasena")){        //Click en olvidó su contraseña            
            }
        }
    }
    
    private void ValidarIngreso(String usuario, String contraseña){
        //SELECT usuario, contrasena FROM 'usuarios' WHERE usuario=usuario;     
        //Linea (SQL) para consultar en la base de datos  
        //Crear método "ExisteUsuario()" (retorne boolean [existe ese usuario o no]) en una nueva clase "Usuarios_Tabla" 
        //ver si la contraseña coincide con la guardada en la base de datos
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
