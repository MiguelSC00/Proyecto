/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DaoProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Producto;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "CrearProducto", urlPatterns = {"/CrearProducto"})
public class CrearProducto extends HttpServlet {

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
        
        final String patron = "^[0-9]+(\\.[0-9]+){0,1}$";
        String error = null;
        
        if (request.getParameter("submit") != null) {
            
            String nombre = request.getParameter("nombre");
            String precioStr = request.getParameter("precioStr");
            double precio = 0;
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            if (nombre != null && precioStr != null && !nombre.isEmpty() && !precioStr.isEmpty()) {
                
                if (precioStr.matches(patron)) {
                    
                    precio = Double.parseDouble(precioStr);
                    
                    if (precio > 0) {
                        
                        Producto p = new Producto(1, nombre, precio, stock);
                        
                        try {
                            DaoProducto.crearProducto(p);
                            response.sendRedirect("MostrarProductos?target=administrar");
                        } catch (SQLException e) {
                            
                        }
                        
                    } else {
                        error = "Introduce un precio mayor que 0";
                        request.setAttribute("errorCrear", error);
                        getServletContext().getRequestDispatcher("/admin/crearProducto.jsp").forward(request, response);
                    }
                    
                } else {
                    error = "Introduce el precio con el formato: (Parte entera).(Dos decimales).";
                    request.setAttribute("errorCrear", error);
                    getServletContext().getRequestDispatcher("/admin/crearProducto.jsp").forward(request, response);
                }
                
            } else {
                error = "Rellene todos los campos.";
                request.setAttribute("errorCrear", error);
                getServletContext().getRequestDispatcher("/admin/crearProducto.jsp").forward(request, response);
            }
            
        } else {
            getServletContext().getRequestDispatcher("/admin/crearProducto.jsp").forward(request, response);
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
