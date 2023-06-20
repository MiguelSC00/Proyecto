/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DaoPdf;
import dao.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Pdf;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "CrearPdfCliente", urlPatterns = {"/CrearPdfCliente"})
public class CrearPdfCliente extends HttpServlet {

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
        
        String titulo = request.getParameter("titulo");
        Usuario usuario = (Usuario)sesion.getAttribute("usuario");
        String nombreUsuario = usuario.getUsuario();
        System.out.println(titulo);    
    
        Pdf pdf = new Pdf(titulo, nombreUsuario, "Reporte");
            
        try {
            DaoPdf.crearPdf(pdf);
        } catch (SQLException ex) {
            Logger.getLogger(CrearPdfEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Pdf ultimo = null;
        
        try {
            ultimo = DaoPdf.getUltimoPdf();
        } catch (SQLException ex) {
            Logger.getLogger(CrearPdfEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int ultimoCodigo = ultimo.getCodigo();
        
        
        
        
        
            

        request.setAttribute("usuario", nombreUsuario);
        
        getServletContext().getRequestDispatcher("/entrenador/detallesAlumno.jsp").forward(request, response);
        
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
