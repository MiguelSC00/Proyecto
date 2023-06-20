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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ModificarProducto", urlPatterns = {"/ModificarProducto"})
public class ModificarProducto extends HttpServlet {

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
        int codigoModificar = Integer.parseInt(request.getParameter("codigo"));
        Producto p = null;
        
        if (request.getParameter("modificar") == null) {
            try {
                p = DaoProducto.buscarProducto(codigoModificar);
                request.setAttribute("productoModificar", p);
                request.getRequestDispatcher("/admin/modificarProducto.jsp").forward(request, response);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            String nombre = request.getParameter("nombre");
            String precioStr = request.getParameter("precio");
            double precio = 0;
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            if (!nombre.isEmpty() && nombre != null && !precioStr.isEmpty() && precioStr != null) {
                
                if (precioStr.matches(patron)) {
                    
                    precio = Double.parseDouble(precioStr);
                    
                    if (precio > 0) {
                        
                        p = new Producto(codigo, nombre, precio, stock);
            
                        try {
                            DaoProducto.modificarProducto(p);
                        } catch (SQLException e) {
                            e.getStackTrace();
                        }

                        response.sendRedirect("MostrarProductos?target=modificar");
                        
                    } else {
                        try {
                            p = DaoProducto.buscarProducto(codigoModificar);
                        } catch (SQLException ex) {
                            Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        request.setAttribute("productoModificar", p);
                        error = "Introduce un precio mayor que 0";
                        request.setAttribute("error", error);
                        getServletContext().getRequestDispatcher("/admin/modificarProducto.jsp").forward(request, response);
                    }
                    
                } else {
                    try {
                        p = DaoProducto.buscarProducto(codigoModificar);
                    } catch (SQLException ex) {
                        Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setAttribute("productoModificar", p);
                    error = "Introduce el precio con el formato: (Parte entera).(Dos decimales).";
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/admin/modificarProducto.jsp").forward(request, response);
                }
                
            } else {
                    try {
                            p = DaoProducto.buscarProducto(codigoModificar);
                        } catch (SQLException ex) {
                            Logger.getLogger(ModificarProducto.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    request.setAttribute("productoModificar", p);
                    error = "Rellene todos los campos";
                    request.setAttribute("error", error);
                    getServletContext().getRequestDispatcher("/admin/modificarProducto.jsp").forward(request, response);
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
