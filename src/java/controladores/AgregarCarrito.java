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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Producto;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "AgregarCarrito", urlPatterns = {"/AgregarCarrito"})
public class AgregarCarrito extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            
            HttpSession sesion = request.getSession();
            List<Producto> cesta = (ArrayList)sesion.getAttribute("cesta");
            List <Integer> cantidades = (ArrayList)sesion.getAttribute("cantidades");
            
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Producto producto = null;
            
            int contador = 0;

            
            
            try {
                
                producto = DaoProducto.buscarProducto(codigo);
                
//                if (producto.getStock() == 0) { //Si ya no queda stock del producto, no se puede añadir a la cesta
//                    
//                    request.setAttribute("error", "No queda stock de " + producto.getNombre());
//                    getServletContext().getRequestDispatcher("/cesta.jsp").forward(request, response);
//                    
//                } else {
                    
                    if (cesta.isEmpty()) {
                
                        cesta.add(producto);
                        cantidades.add(1);

                    } else {

                        if (cesta.contains(producto)) {

                            cantidades.set(cesta.indexOf(producto), cantidades.get(cesta.indexOf(producto)) +1);

                        } else {

                            cesta.add(producto);
                            cantidades.add(1);

                        }

                    }


                    System.out.println(cantidades);

                    sesion.setAttribute("cesta", cesta);
                    response.sendRedirect("MostrarProductos?target=tienda");
                    
                //}
                
                
                
            } catch (SQLException e) {
                e.getErrorCode();
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
