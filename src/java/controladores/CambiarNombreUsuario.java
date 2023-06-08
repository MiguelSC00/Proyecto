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
@WebServlet(name = "CambiarNombreUsuario", urlPatterns = {"/CambiarNombreUsuario"})
public class CambiarNombreUsuario extends HttpServlet {

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

        String usuarioNuevo = request.getParameter("usuarioNuevo");
        HttpSession sesion = request.getSession();
        Usuario u = (Usuario)sesion.getAttribute("usuario");
        String usuarioAntiguo = u.getUsuario();
        
        String error = "";
        
        if (usuarioNuevo != "") {
            try {
                Usuario usu = DaoUsuario.buscarUsuario(usuarioNuevo);
            
                if (usu == null) {
                    DaoUsuario.cambiarNombreUsuario(usuarioNuevo, usuarioAntiguo);
                    u.setUsuario(usuarioNuevo);
                    sesion.setAttribute("usuario", u);

                    response.sendRedirect("perfil.jsp");
                } else {
                    error = "Este usuario ya existe";
                    request.setAttribute("errorUsuario", error);
                    getServletContext().getRequestDispatcher("/perfil.jsp").forward(request, response);
                }

            } catch (SQLException e){

            }
        } else {
            error = "Introduce el nombre de usuario nuevo";
            request.setAttribute("errorUsuario", error);
            getServletContext().getRequestDispatcher("/perfil.jsp").forward(request, response);
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
