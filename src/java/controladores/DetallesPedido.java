/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DaoListaItems;
import dao.DaoPedido;
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
import modelo.ListaItems;
import modelo.Pedido;
import modelo.Producto;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "DetallesPedido", urlPatterns = {"/DetallesPedido"})
public class DetallesPedido extends HttpServlet {

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
        
        int codigoP = Integer.parseInt(request.getParameter("codigo"));
        List<ListaItems> lista = new ArrayList();
        List<Producto> productos = new ArrayList();
        List<Integer> cantidades =  new ArrayList();
        
        Pedido pedido = null;
        
        try {
            
            pedido = DaoPedido.buscarPedido(codigoP);
            lista = DaoListaItems.getListaItems(codigoP);
            
            for (ListaItems l : lista) {
                
                productos.add(DaoProducto.buscarProducto(l.getCodigoProducto()));
                cantidades.add(l.getCantidad());        
                
            }
            
            
            
        } catch(SQLException e) {
            
            System.out.println(e.getErrorCode());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            
        }
        
        request.setAttribute("pedido", pedido);
        request.setAttribute("cantidades", cantidades);
        request.setAttribute("productos", productos);
        request.getRequestDispatcher("/admin/detallesPedido.jsp").forward(request, response);
        
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
