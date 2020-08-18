/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datos.BaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jhony Caro
 */
public class Validaciones extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String tipoValidacion = request.getParameter("tipoValidacion");
            
            if("existeUsuario".equals(tipoValidacion)){
                if(bd.ValidarUsuario_Usuarios(request.getParameter("usuario"))){
                    out.print("(El usuario ya existe)");
                }
            }
            
            if("existeDni".equals(tipoValidacion)){
                if(bd.ValidarPaciente_Pacientes(request.getParameter("dni"))){
                    out.print("(Doc. ya registrado)");
                }
            }
            
            if("ingresoCorrecto".equals(tipoValidacion)){
                String usuario = request.getParameter("usuario");
                String contrasena = request.getParameter("contrasena");
                if(!bd.ExisteUsuario_Usuarios(usuario, contrasena)){
                    out.print("Error: usuario y/o contraseña inválido.");
                }
            }
            
            if("hospitalLocalidad".equals(tipoValidacion)){
                out.print(request.getParameter("localidad"));
            }
            if("doctorEspecialidad".equals(tipoValidacion)){
                out.print(request.getParameter("especialidad"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
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
