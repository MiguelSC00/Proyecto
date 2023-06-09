/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "SuscribirCulturismo", urlPatterns = {"/SuscribirCulturismo"})
public class SuscribirCulturismo extends HttpServlet {

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
        
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario)sesion.getAttribute("usuario");
        String error= "";
        
        String tarjeta = request.getParameter("tarjeta");
        String fecha = request.getParameter("fechaCaducidad");
        String cvv = request.getParameter("cvv");
        
        
        
        if (u == null) {
            response.sendRedirect("iniciarSesion.jsp");
        } else {
            
            if (!tarjeta.isEmpty() && !fecha.isEmpty() && !cvv.isEmpty() && tarjeta != null
                    && fecha != null && cvv != null) {
                
                try {

                    DaoUsuario.suscribir("Culturismo", u);
                    
                    u.setSuscripcion("Culturismo");
                    sesion.setAttribute("usuario", u);
                    request.setAttribute("usu", u);
                    request.getRequestDispatcher("/entrenador/detallesAlumno.jsp").forward(request, response);
                } catch (SQLException e) {
                    
                    System.out.println(e.getErrorCode());
                    System.out.println(e.getMessage());
                    System.out.println(e.getStackTrace());
                    
                }

            } else {
             
                error = "Rellene todos los campos";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/formularioSuscripcionCulturismo.jsp").forward(request, response);
                
            }
                
                
                
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
