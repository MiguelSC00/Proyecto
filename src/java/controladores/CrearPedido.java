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
import javax.servlet.http.HttpSession;
import modelo.ListaItems;
import modelo.Pedido;
import modelo.Producto;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "CrearPedido", urlPatterns = {"/CrearPedido"})
public class CrearPedido extends HttpServlet {

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
        
        double precioTotal = (Double)sesion.getAttribute("precioTotal");
        List<Producto> cesta = (ArrayList)sesion.getAttribute("cesta");
        List<Integer> cantidades = (ArrayList)sesion.getAttribute("cantidades");
        Usuario u = (Usuario)sesion.getAttribute("usuario");
        String usuario = u.getUsuario();
        
        //Se recogen los datos de envío
        String provincia = request.getParameter("provincia");
        String codigoPostal = request.getParameter("codigoPostal");
        String calle = request.getParameter("calle");
        int numero = Integer.parseInt(request.getParameter("numero"));
        
        //Se recogen los datos bancarios
        String tarjeta = request.getParameter("tarjeta");
        String fechaCaducidad = request.getParameter("fechaCaducidad");
        String cvv = request.getParameter("cvv");
        
        String error = "";
        
        
        if (provincia != null && codigoPostal != null && calle != null && tarjeta != null && fechaCaducidad != null && cvv != null
            && !provincia.isEmpty() && !codigoPostal.isEmpty() && !calle.isEmpty() && !tarjeta.isEmpty() && !fechaCaducidad.isEmpty() && !cvv.isEmpty()) {
            
            Pedido p = new Pedido(usuario, precioTotal, provincia, codigoPostal, calle, numero, "Pago aceptado");
            
            Pedido ultimo = null;
            
            try {
                
                DaoPedido.crearPedido(p);
                
                ultimo = DaoPedido.buscarUltimoPedido();
                
                int contador = 0;
                
                for (Producto pr : cesta) {
                    
                        DaoProducto.restarStock(pr, cantidades.get(contador));
                        ListaItems l = new ListaItems(ultimo.getCodigo(), pr.getCodigo(), cantidades.get(contador));
                        DaoListaItems.crearListaItems(l);
                        
                        
                        contador++;
                   
                }
                
            } catch (SQLException e) {
                System.out.println(e.getErrorCode());
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            }
            
        } else {
            
                error = "Rellene todos los campos";
                request.setAttribute("error", error);
                getServletContext().getRequestDispatcher("/formularioPedido.jsp").forward(request, response);
            
        }
        
        cesta.clear();
        sesion.setAttribute("cesta", cesta);
        response.sendRedirect("index.jsp");
        
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
