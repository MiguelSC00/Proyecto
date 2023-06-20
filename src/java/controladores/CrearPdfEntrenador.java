/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import dao.DaoPdf;
import dao.DaoUsuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
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
        
        String titulo = request.getParameter("titulo");
        String usuario = request.getParameter("nombreUsuario");
            
    
        Pdf pdf = new Pdf(titulo, usuario, "Plan");
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
        
        
//        String savePath = "archivosPdf"; // Especifica la ruta donde quieres guardar el archivo
//
//
//        Part part = request.getPart("fichero");
//        String fileName = getFileName(part);
//
//        InputStream inputStream = part.getInputStream();
//        Files.copy(inputStream, new File(savePath + File.separator + fileName).toPath(),
//                StandardCopyOption.REPLACE_EXISTING);
        

        
        
//        int ultimoCodigo = ultimo.getCodigo();
//        
//        Part filePart = request.getPart("fichero");
//
//            // Obtiene el nombre del archivo
//            String fileName = filePart.getSubmittedFileName();
//
//            // Define la ruta de almacenamiento del archivo en el servidor
//            String rutaDestino = getServletContext().getRealPath("/") + "archivosPdf/" + fileName;
//            System.out.println(rutaDestino);
//            File uploadDirFile = new File(rutaDestino);

            

//            // Guarda el archivo en el servidor
//            filePart.write(rutaDestino + File.separator + fileName);
//            Files.copy(filePart.getInputStream(), rutaDestino);
        
        
        // Directorio en el servidor donde se guardarán los archivos
        

//        // Obtiene el archivo enviado por el usuario
//        Part archivoPart = request.getPart("fichero");
//        
//        // Obtiene el nombre del archivo
//        String nombreArchivo = getSubmittedFileName(archivoPart);
//        
//        String rutaDestino = getServletContext().getRealPath("/") + "archivosPdf/" + nombreArchivo;
//
//        Files.copy(archivoPart.getInputStream(), Path.of(rutaDestino));


        // Guarda el archivo en el servidor


        
        
//        Part fichero = request.getPart("fichero");
//        String nombreFichero = fichero.getSubmittedFileName();
//        InputStream datosFichero = fichero.getInputStream();
//        String path = getServletContext().getRealPath("archivosPdf");
//        FileOutputStream fos = new FileOutputStream(path + "/" + nombreFichero);
//        while (datosFichero.available() > 0) {
//            fos.write(datosFichero.read());
//        }
//        fos.close();
//        datosFichero.close();

//        Part fichero = request.getPart("fichero");
//        String nombre = fichero.getSubmittedFileName();
//        String path = getServletContext().getRealPath("archivosPdf");
//        System.out.println(path);
//        System.out.println(nombre);
//        fichero.write("/" + fichero.getSubmittedFileName());
//        for (Part part : request.getParts()) {
//            part.write("archivosPdf" + nombre);
//        }
        
        String us = "";
            
        try {
            Usuario u = DaoUsuario.buscarUsuario(usuario);
            us =  u.getUsuario();
        } catch (SQLException ex) {
            Logger.getLogger(CrearPdfEntrenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("usuario", us);
        getServletContext().getRequestDispatcher("/DetallesUsuario").forward(request, response);
        
    }
    
    private String getFileName(Part part) {
        String contentDispositionHeader = part.getHeader("content-disposition");
        String[] elements = contentDispositionHeader.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf("=") + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
    
    private String getSubmittedFileName(Part part) {
        String nombreArchivo = null;
        String header = part.getHeader("content-disposition");
        if (header != null) {
          for (String headerPart : header.split(";")) {
            if (headerPart.trim().startsWith("filename")) {
              nombreArchivo = headerPart.substring(headerPart.indexOf('=') + 1).trim().replace("\"", "");
              break;
            }
          }
        }
        return nombreArchivo;
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
