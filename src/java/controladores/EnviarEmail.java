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
import modelo.Email;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "EnviarEmail", urlPatterns = {"/EnviarEmail"})
public class EnviarEmail extends HttpServlet {

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
        
        String usuario = request.getParameter("usuario");
        HttpSession sesion = request.getSession();
        
        Usuario u = null;
        try {
            u = DaoUsuario.buscarUsuario(usuario);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        if (request.getParameter("enviar") == null) {
            System.out.println(1);
            request.setAttribute("destinatario", u);
            request.getRequestDispatcher("/escribirEmail.jsp").forward(request, response);
        } else {
            
            Usuario remitente = (Usuario)sesion.getAttribute("usuario");
            Email email = new Email();
            System.out.println(remitente.getEmail());
            System.out.println(u.getEmail());
            email.setFrom(remitente.getEmail());
            email.setSubject(request.getParameter("asunto"));
            email.setTo(u.getEmail());
            email.setText(request.getParameter("texto"));
            try {
                remitente.setEnviarEmail(email, request.getParameter("password"));
            } catch (Exception ex) {
                throw new ServletException(ex.getMessage(), ex);
            }
            
            response.sendRedirect("MostrarUsuariosSuscritos");
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
