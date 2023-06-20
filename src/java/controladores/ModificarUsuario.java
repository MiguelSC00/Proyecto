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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
@WebServlet(name = "ModificarUsuario", urlPatterns = {"/ModificarUsuario"})
public class ModificarUsuario extends HttpServlet {

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
        
        String nombreUsuario = request.getParameter("usuario");
        Usuario u = null;
        String error = "";
        
        if (request.getParameter("modificar") == null) {
            try {
                u = DaoUsuario.buscarUsuario(nombreUsuario);
                request.setAttribute("usuarioModificar", u);
                request.getRequestDispatcher("/admin/modificarUsuario.jsp").forward(request, response);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String rol = request.getParameter("rol");

            //Si ninguna está vacía
            if (nombre != null && apellidos != null && usuario != null && password != null  && email != null && telefono != null
            && !nombre.isEmpty() && !apellidos.isEmpty() && !usuario.isEmpty() && !password.isEmpty()  && !email.isEmpty() && !telefono.isEmpty()) {
                

                
                

                    
                        
                        //Si el número de teléfono tiene el formato correcto
                        if (telefono.length() == 9 && telefono.matches("[+-]?\\d*(\\.\\d+)?")) {
                            
                            //Creamos un objeto usuario con la información del formulario
                            u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol);
                            try { //Lo introducimos en la base de datos
                                DaoUsuario.modificarUsuario(u);
                                response.sendRedirect("MostrarUsuarios");
                            } catch (SQLException ex) {
                                System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                                return;
                            }
                            
                        } else { //Si el número de teléfono no es válido
                            try {
                            
                            u = DaoUsuario.buscarUsuario(nombreUsuario);
                            } catch (SQLException ex) {
                                Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            error = "Introduce un número válido de 9 dígitos.";
                            request.setAttribute("error", error);
                            request.setAttribute("usuarioModificar", u);
                            request.getRequestDispatcher("/admin/modificarUsuario.jsp").forward(request, response);
                        }
                        
                   
                    
                
            } else { //Si alguna variable está vacía
                try {
                            
                            u = DaoUsuario.buscarUsuario(nombreUsuario);
                            } catch (SQLException ex) {
                                Logger.getLogger(ModificarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                            }
                error = "Rellene todos los campos";
                request.setAttribute("error", error);
                request.setAttribute("usuarioModificar", u);
                request.getRequestDispatcher("/admin/modificarUsuario.jsp").forward(request, response);
            } 
            
            
//            u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol);
//            
//            try {
//                DaoUsuario.modificarUsuario(u);
//            } catch (SQLException e) {
//                e.getStackTrace();
//            }
//            
//            response.sendRedirect("MostrarUsuarios");
        
            
           
            
            
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
