/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import dao.DaoUsuario;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import modelo.Pdf;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "CrearPdfEntrenador", urlPatterns = {"/CrearPdfEntrenador"})
@MultipartConfig(maxFileSize = 16177215) 
public class CrearPdfEntrenador extends HttpServlet {

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
        
        if (request.getParameter("submitEntrenador") == null) {
            response.sendRedirect("entrenador/subirPdfEntrenador.jsp");
            return;
        }
        
        String ruta = "archivosPdf\\";
        File uploads = new File(ruta);
        String extension = ".pdf";
        
        String error = "";
        
        
        Part part = request.getPart("archivo");
        
        if (part == null) {
            error = "No ha seleccionado ningún archivo";
        } else {
            
            if (tieneExtension(part.getSubmittedFileName(), extension)) {
                
                String hola = saveFile(part, uploads);
                
            } else {
                error = "El archivo tiene que ser .pdf";
            }
            
        }
        
        
        
        
    }
    
    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";
        
        try {
            
            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();
            
            if (input != null) {
                File file = new File(pathUploads, fileName);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return pathAbsolute;
    }
    
    private boolean tieneExtension(String fileName, String extension) {
        if (fileName.toLowerCase().endsWith(extension)) {
            return true;
        } else {
            return false;
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
