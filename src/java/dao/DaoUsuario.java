/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
public class DaoUsuario {
    public static Connection conectarBD() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaproyecto?useSSL=false&allowPublicKeyRetrieval=true",
                "root", "");
//                return DriverManager.getConnection("jdbc:mysql://10.100.18.253:3306/proyecto?useSSL=false&allowPublicKeyRetrieval=true",
//                "root", "BIPobs46866");
    }
    
    public static void desconectarBD(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
    
    public static void crearUsuario(Usuario u) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "insert into usuarios (usuario, password, nombre, apellidos, email, telefono, rol, suscripcion) values (?, ?, ?, ?, ?, ?, ?, ?)");
        consulta.setString(1, u.getUsuario());
        consulta.setString(2, u.getPassword());
        consulta.setString(3, u.getNombre());
        consulta.setString(4, u.getApellidos());
        consulta.setString(5, u.getEmail());
        consulta.setString(6, u.getTelefono());
        consulta.setString(7, u.getRol());
        consulta.setString(8, u.getSuscripcion());
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void eliminarUsuario(String usuario) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement("delete from usuarios where usuario=?");
        consulta.setString(1, usuario);
        int borrados = consulta.executeUpdate();
        if (borrados == 0) {
            throw new SQLException("No se ha eliminado ningún registro");
        }
        desconectarBD(con);
    }
    
    public static void modificarUsuario(Usuario u) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set password=?, nombre=?, apellidos=?, email=?, telefono=?, rol=? where usuario=?");
        consulta.setString(1, u.getPassword());
        consulta.setString(2, u.getNombre());
        consulta.setString(3, u.getApellidos());
        consulta.setString(4, u.getEmail());
        consulta.setString(5, u.getTelefono());
        consulta.setString(6, u.getRol());
        consulta.setString(7, u.getUsuario());
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void cambiarNombreUsuario(String nombreNuevo, String nombreAntiguo) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set usuario=? where usuario=?");
        consulta.setString(1, nombreNuevo);
        consulta.setString(2, nombreAntiguo);
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void cambiarPassword(String passwordNueva, String usuario) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set password=? where usuario=?");
        consulta.setString(1, passwordNueva);
        consulta.setString(2, usuario);
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void cambiarEmail(String emailNuevo, String usuario) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set email=? where usuario=?");
        consulta.setString(1, emailNuevo);
        consulta.setString(2, usuario);
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void cambiarTelefono(String telefono, String usuario) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set telefono=? where usuario=?");
        consulta.setString(1, telefono);
        consulta.setString(2, usuario);
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void cambiarNombreApellidos(String nombre, String apellidos, String usuario) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set nombre=?, apellidos=? where usuario=?");
        consulta.setString(1, nombre);
        consulta.setString(2, apellidos);
        consulta.setString(3, usuario);
        consulta.execute();
        desconectarBD(con);
    }
        
    public static Usuario buscarEmail(String emailBuscar) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from usuarios where email=?");
        consulta.setString(1, emailBuscar);
        ResultSet rs = consulta.executeQuery();
        Usuario u = null;
        if (rs.next()) {
            String usuario = rs.getString("usuario");
            String password = rs.getString("password");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String rol = rs.getString("rol");
            String suscripcion = rs.getString("suscripcion");
            u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol, suscripcion);
        }
        desconectarBD(con);
        return u;
    }
    
    public static Usuario buscarUsuario(String usuario) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from usuarios where usuario=?");
        consulta.setString(1, usuario);
        ResultSet rs = consulta.executeQuery();
        Usuario u = null;
        if (rs.next()) {
            String password = rs.getString("password");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String rol = rs.getString("rol");
            String suscripcion = rs.getString("suscripcion");
            Timestamp fechaSuscripcion = rs.getTimestamp("fecha_suscripcion");
            u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol, suscripcion, fechaSuscripcion);
        }
        desconectarBD(con);
        return u;
    }
    
    public static List<Usuario> consultarUsuarios() throws SQLException {
        List<Usuario> usuarios = new LinkedList();
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from usuarios");
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            String usuario = rs.getString("usuario");
            String password = rs.getString("password");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String rol = rs.getString("rol");
            String suscripcion = rs.getString("suscripcion");
            Usuario u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol, suscripcion);
            usuarios.add(u);
        }
        desconectarBD(con);
        return usuarios;
    }
    
    public static int totalUsuarios() throws SQLException {
        int total = 0;
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select count(*) from usuarios");
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            total = rs.getInt(1);
        }
        
        return total;
    }

    public static void suscribir(String sus, Usuario usuario) throws SQLException {
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set suscripcion=?, fecha_suscripcion = NOW() where usuario=?");
        consulta.setString(1, sus);
        consulta.setString(2, usuario.getNombre());
        consulta.execute();
        desconectarBD(con);
        
    }
    
    public static List<Usuario> consultarUsuariosSuscritos() throws SQLException {
        List<Usuario> usuarios = new LinkedList();
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from usuarios where suscripcion in ('Culturismo', 'Powerlifting')");
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            String usuario = rs.getString("usuario");
            String password = rs.getString("password");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String rol = rs.getString("rol");
            String suscripcion = rs.getString("suscripcion");
            Usuario u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol, suscripcion);
            usuarios.add(u);
        }
        desconectarBD(con);
        return usuarios;
    }
    
    public static List<Usuario> filtrarCulturismo() throws SQLException {
        List<Usuario> usuarios = new LinkedList();
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from usuarios where suscripcion = 'Culturismo'");
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            String usuario = rs.getString("usuario");
            String password = rs.getString("password");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String rol = rs.getString("rol");
            String suscripcion = rs.getString("suscripcion");
            Usuario u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol, suscripcion);
            usuarios.add(u);
        }
        desconectarBD(con);
        return usuarios;
    }
    
    
    public static List<Usuario> filtrarPowerlifting() throws SQLException {
        List<Usuario> usuarios = new LinkedList();
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from usuarios where suscripcion = 'Powerlifting'");
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            String usuario = rs.getString("usuario");
            String password = rs.getString("password");
            String nombre = rs.getString("nombre");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            String rol = rs.getString("rol");
            String suscripcion = rs.getString("suscripcion");
            Usuario u = new Usuario(usuario, password, nombre, apellidos, email, telefono, rol, suscripcion);
            usuarios.add(u);
        }
        desconectarBD(con);
        return usuarios;
    }
    
        public static void terminarSuscripcion(Usuario usuario) throws SQLException {
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update usuarios set suscripcion='', fecha_suscripcion = null where usuario=?");
        consulta.setString(1, usuario.getNombre());
        consulta.execute();
        desconectarBD(con);
        
    }
    
}
