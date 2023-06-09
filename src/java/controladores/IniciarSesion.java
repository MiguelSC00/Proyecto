/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.DaoProducto;
import dao.DaoUsuario;
import modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

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
        
        String error = null; //Variable donde se almacenará el error en caso de que lo haya
        //Almacenamos todas las variables que se han mandado por el formulario
        String usuario = request.getParameter("usuarioI");
        String password = request.getParameter("passwordI");
        
        
        //Si ninguna está vacía
        if (usuario != null && password != null && !usuario.isEmpty() && !password.isEmpty()) {
            
            Usuario u = null; //Inicializamos un objeto usuario
            
            try { //Comprobamos si hay un usuario con ese nombre de usuario
                u = DaoUsuario.buscarUsuario(usuario);
            } catch(SQLException ex) {
                System.err.println(ex.getClass().getName() + ":" + ex.getMessage());
                return;
            }
            
            if (u != null) {  // Si se ha encontrado el usuario en la BD
                if (u.getPassword().equals(password)) { //y la contraseña es correcta
                    if (!u.getSuscripcion().isEmpty()) {
                        comprobarSuscripcion(u);
                    }
                    
                    try {
                        u = DaoUsuario.buscarUsuario(usuario);
                    } catch (SQLException ex) {
                        Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    HttpSession sesion = request.getSession();
                    sesion.setAttribute("usuario", u);
                    
                    List<Producto> c = new ArrayList();
                    sesion.setAttribute("cesta", c);
                    
                    List<Integer> cantidades = new ArrayList();
                    sesion.setAttribute("cantidades", cantidades);
                 
                    
                    if (u.getRol().equals("Administrador")) { //Si el usuario es admin
                        response.sendRedirect("CargarPanel");
                    } else { //Si el usuario no es admin
                        response.sendRedirect("index.jsp");
                    }
         
                    return;
                } else { //Si la contraseña no es correcta
                    error = "Usuario o contraseña incorrectos";
                }
            } else { //Si no se ha encontrado el usuario
                error = "Usuario o contraseña incorrectos";
            } 
            
        } else { //Si algún campo está vacío
            error = "Debe rellenar ambos campos";
        }
        
        //Se manda el error de vuelta a la página de registro
        request.setAttribute("error", error);
        getServletContext().getRequestDispatcher("/iniciarSesion.jsp").forward(request, response);
        
    }
    
    public static void comprobarSuscripcion(Usuario u) {
        
        // Crear dos objetos Timestamp con las fechas que deseas restar
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp2 = u.getFechaSuscripcion();

        // Convertir los objetos Timestamp a objetos Date
        Date date1 = new Date(timestamp1.getTime());
        Date date2 = new Date(timestamp2.getTime());

        // Crear objetos Calendar y asignar las fechas
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);

        // Restar los campos de fecha correspondientes (año, mes, día)
        double diffYear = calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR);
        double diffMonth = diffYear * 12 + calendar1.get(Calendar.MONTH) - calendar2.get(Calendar.MONTH);

        if (diffMonth > 0) {
            try {
                DaoUsuario.terminarSuscripcion(u);
            } catch (SQLException ex) {
                Logger.getLogger(IniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // Imprimir el resultado
        System.out.println("Diferencia en meses: " + diffMonth);
        
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
