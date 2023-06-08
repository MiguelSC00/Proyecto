/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DaoPedido;
import dao.DaoProducto;
import dao.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Pedido;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "CargarPanel", urlPatterns = {"/CargarPanel"})
public class CargarPanel extends HttpServlet {

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
        
        int totalUsuarios = 0;
        int totalProductos = 0;
        int totalPedidos = 0;
        
        int productosSinStock = 0;
        int pedidosAceptados = 0;
        
        List<Pedido> pedidosPendientes = null;
        
        try {
            
            totalUsuarios = DaoUsuario.totalUsuarios();
            totalProductos = DaoProducto.totalProductos();
            totalPedidos = DaoPedido.totalPedidos();
            
            productosSinStock = DaoProducto.productosSinStock();
            pedidosAceptados = DaoPedido.pedidosAceptados();
            
            pedidosPendientes = DaoPedido.pedidosPendientes();
            
        } catch (SQLException ex) {
            System.out.println(ex.getStackTrace());
            System.out.println(ex.getMessage());
        }
        
        request.setAttribute("totalUsuarios", totalUsuarios);
        request.setAttribute("totalProductos", totalProductos);
        request.setAttribute("totalPedidos", totalPedidos);
        request.setAttribute("productosSinStock", productosSinStock);
        request.setAttribute("pedidosAceptados", pedidosAceptados);
        request.setAttribute("pedidosPendientes", pedidosPendientes);
        request.getRequestDispatcher("/admin/admin.jsp").forward(request, response);
        
        
        
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
