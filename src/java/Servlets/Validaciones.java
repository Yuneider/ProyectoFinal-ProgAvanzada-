/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Datos.BaseDeDatos;
import Datos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    Conexion con = new Conexion();
    Connection c = con.Conexion();
    BaseDeDatos bd = new BaseDeDatos();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
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
                String sqr = "select nombre from hospitales where localidad='"+request.getParameter("localidad")+"';";
                PreparedStatement ps = c.prepareStatement(sqr);
                ResultSet rs=ps.executeQuery();
                out.print("<option value=\"0\" disabled selected >Seleccione un hospital</option>");
                while(rs.next()){
                    out.print("<option value=\""+rs.getString("nombre")+"\">"+rs.getString("nombre")+"</option>");
                }
            }
            if("doctorEspecialidad".equals(tipoValidacion)){
                String sqr = "select nombre from doctores where hospital='"+request.getParameter("hospital")+"' AND especialidad='"+request.getParameter("especialidad")+"';";
                PreparedStatement ps = c.prepareStatement(sqr);
                ResultSet rs=ps.executeQuery();
                out.print("<option value=\"0\" disabled selected >Seleccione una doctor</option>");
                while(rs.next()){
                    out.print("<option value=\""+rs.getString("nombre")+"\">"+rs.getString("nombre")+"</option>");
                }
            }
            
            if("disponibilidadCita".equals(tipoValidacion)){
                String sqr = "select * from citas where hospital='"+request.getParameter("hospital")+
                        "' AND doctor='"+request.getParameter("doctor")+
                        "'AND fecha='"+request.getParameter("fecha")+"';";
                PreparedStatement ps = c.prepareStatement(sqr);
                ResultSet rs=ps.executeQuery();
                out.print("<option value=\"0\" disabled selected >Seleccione una hora</option>");
                boolean[] horaMostrar= new boolean[9];
                for(int i=0;i<9;i++){
                    horaMostrar[i]=true;
                }
                /*Estados:
                1-Planificada
                2-Cancelada
                3-Incumplida
                4-Realizada
                */
                while(rs.next()){
                    if(Integer.parseInt(rs.getString("estado"))==1){
                        int espacio =Integer.parseInt(rs.getString("hora"))-8;
                        horaMostrar[espacio]=false;
                    }    
                }
                for(int i=0;i<9;i++){
                    int hora = i+8;
                    if(horaMostrar[i]==true){
                        if(hora<10){
                            out.print("<option value=\""+hora+"\">0"+hora+":00</option>");
                        }else{
                            out.print("<option value=\""+hora+"\">"+hora+":00</option>");
                        }
                    }else{
                        if(hora<10){
                            out.print("<option value=\""+hora+"\" disabled >0"+hora+":00 No disponible</option>");
                        }else{
                            out.print("<option value=\""+hora+"\" disabled >"+hora+":00 No disponible</option>");
                        }
                    }
                        
                }
                
            }
            if("existeHospital".equals(tipoValidacion)){
                if(bd.ExisteHospital_Hospitales(request.getParameter("hospital"))){
                    out.print("(hospital. ya registrado)");
                }else{
                    out.print("");
                }
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
