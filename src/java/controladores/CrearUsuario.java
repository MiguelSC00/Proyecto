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
@WebServlet(name = "CrearUsuario", urlPatterns = {"/CrearUsuario"})
public class CrearUsuario extends HttpServlet {

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
        
        //Variable donde se almacenará el error en caso de que lo haya
        String error = null;
        String creaAdmin = request.getParameter("creaAdmin");
        
        if (creaAdmin != null) {
            getServletContext().getRequestDispatcher("/admin/crearUsuario.jsp").forward(request, response);
        }
        
        //Si se ha mandado el formulario de registro
        if (request.getParameter("submitR") != null) {
            
            //Almacenamos todas las variables que se han mandado por el formulario
            String nombre = request.getParameter("nombreR");
            String apellidos = request.getParameter("apellidosR");
            String usuario = request.getParameter("usuarioR");
            String password1 = request.getParameter("passwordR");
            String password2 = request.getParameter("passwordR2");
            String email = request.getParameter("emailR");
            String telefono = request.getParameter("telefonoR");
            
            //Si ninguna está vacía
            if (nombre != null && apellidos != null && usuario != null && password1 != null && password2 != null && email != null && telefono != null
            && !nombre.isEmpty() && !apellidos.isEmpty() && !usuario.isEmpty() && !password1.isEmpty() && !password2.isEmpty() && !email.isEmpty() && !telefono.isEmpty()) {
                
                Usuario u = null; //Inicializamos un objeto usuario
                
                try { //Comprobamos si hay un usuario con ese nombre de usuario
                    u = DaoUsuario.buscarUsuario(usuario);
                } catch(SQLException ex) {
                    System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                    return;
                }
                
                if (u == null) { //Si el usuario es null, no existe
                    
                    if (password1.equals(password2)) { //Si las dos contraseñas coinciden
                        
                        //Si el número de teléfono tiene el formato correcto
                        if (telefono.length() == 9 && telefono.matches("[+-]?\\d*(\\.\\d+)?")) {
                            
                            //Creamos un objeto usuario con la información del formulario
                            u = new Usuario(usuario, password1, nombre, apellidos, email, telefono, "Cliente");
                            try { //Lo introducimos en la base de datos
                                DaoUsuario.crearUsuario(u);
                                response.sendRedirect("iniciarSesion.jsp");
                            } catch (SQLException ex) {
                                System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                                return;
                            }
                            
                        } else { //Si el número de teléfono no es válido
                            error = "Introduce un número válido de 9 dígitos.";
                            request.setAttribute("errorRegistro", error);
                            getServletContext().getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
                        }
                        
                    } else { //Si las dos contraseñas no coinciden
                        error = "Las contraseñas no coinciden.";
                        request.setAttribute("errorRegistro", error);
                        getServletContext().getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
                    }
                    
                } else { //Si ya existe un usuario con ese nombre de usuario
                    error = "El nombre de usuario está en uso";
                    request.setAttribute("errorRegistro", error);
                    getServletContext().getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
                }
                
            } else { //Si alguna variable está vacía
                error = "Rellene todos los campos";
                request.setAttribute("errorRegistro", error);
                getServletContext().getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
            }  
            
            //Se manda el error de vuelta a la página de registro
            
        }
        
        if (request.getParameter("crearAdmin") != null) {
            
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String usuario = request.getParameter("usuario");
            String password1 = request.getParameter("password1");
            String password2 = request.getParameter("password2");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");
            String rol = request.getParameter("rol");
            
            if (nombre != null && apellidos != null && usuario != null && password1 != null && password2 != null && email != null && telefono != null
            && !nombre.isEmpty() && !apellidos.isEmpty() && !usuario.isEmpty() && !password1.isEmpty() && !password2.isEmpty() && !email.isEmpty() && !telefono.isEmpty()) {
                
                Usuario u = null; //Inicializamos un objeto usuario
                
                try { //Comprobamos si hay un usuario con ese nombre de usuario
                    u = DaoUsuario.buscarUsuario(usuario);
                } catch(SQLException ex) {
                    System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                    return;
                }
                
                if (u == null) { //Si el usuario es null, no existe
                    
                    if (password1.equals(password2)) { //Si las dos contraseñas coinciden
                        
                        //Si el número de teléfono tiene el formato correcto
                        if (telefono.length() == 9 && telefono.matches("[+-]?\\d*(\\.\\d+)?")) {
                            
                            //Creamos un objeto usuario con la información del formulario
                            u = new Usuario(usuario, password1, nombre, apellidos, email, telefono, rol);
                            try { //Lo introducimos en la base de datos
                                DaoUsuario.crearUsuario(u);
                                response.sendRedirect("MostrarUsuarios");
                            } catch (SQLException ex) {
                                System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                                return;
                            }
                            
                        } else { //Si el número de teléfono no es válido
                            error = "Introduce un número válido de 9 dígitos.";
                            request.setAttribute("errorCrear", error);
                            getServletContext().getRequestDispatcher("/admin/crearUsuario.jsp").forward(request, response);
                        }
                        
                    } else { //Si las dos contraseñas no coinciden
                        error = "Las contraseñas no coinciden.";
                        request.setAttribute("errorCrear", error);
                    getServletContext().getRequestDispatcher("/admin/crearUsuario.jsp").forward(request, response);
                    }
                    
                } else { //Si ya existe un usuario con ese nombre de usuario
                    error = "El nombre de usuario está en uso";
                    request.setAttribute("errorCrear", error);
                    getServletContext().getRequestDispatcher("/admin/crearUsuario.jsp").forward(request, response);
                }
                
            } else { //Si alguna variable está vacía
                error = "Rellene todos los campos";
                request.setAttribute("errorCrear", error);
                getServletContext().getRequestDispatcher("/admin/crearUsuario.jsp").forward(request, response);
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
