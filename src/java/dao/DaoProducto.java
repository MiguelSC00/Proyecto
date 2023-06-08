/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DaoUsuario.conectarBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelo.Producto;

/**
 *
 * @author Miguel
 */
public class DaoProducto {
    
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
    
    
    
    public static void crearProducto(Producto p) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "insert into productos (nombre, precio, stock) values (?, ?, ?)");
    
        consulta.setString(1, p.getNombre());
        consulta.setDouble(2, p.getPrecio());
        consulta.setInt(3, p.getStock());
        consulta.execute();
        desconectarBD(con);
    }
    
    
    public static void eliminarProducto(int codigo) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "delete from productos where codigo=?");
    
        consulta.setInt(1, codigo);
        consulta.execute();
        
        desconectarBD(con);
    }
    
    
    public static Producto buscarProducto(int codigo) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from productos where codigo=?");
        consulta.setInt(1, codigo);
        ResultSet rs = consulta.executeQuery();
        Producto p = null;
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio");
            int stock = rs.getInt("stock");
            p = new Producto(codigo, nombre, precio, stock);
        }
        desconectarBD(con);
        return p;
    }
    
    
    public static void modificarProducto(Producto p) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "update productos set nombre=?, precio=?, stock=? where codigo=?");
        
        consulta.setString(1, p.getNombre());
        consulta.setDouble(2, p.getPrecio());
        consulta.setInt(3, p.getStock());
        consulta.setInt(4, p.getCodigo());
        consulta.execute();
        
        desconectarBD(con);
    }
    
    
    public static List<Producto> consultarProductos() throws SQLException {
        List<Producto> productos = new LinkedList();
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "select * from productos");
        
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String nombre = rs.getString("nombre");
            double precio = rs.getDouble("precio");
            int stock = rs.getInt("stock");
            
            Producto p = new Producto(codigo, nombre, precio, stock);
            productos.add(p);
        }
        
        return productos;
    }
    
    
    public static int totalProductos() throws SQLException {
        int total = 0;
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select count(*) from productos");
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            total = rs.getInt(1);
        }
        
        return total;
    }
    
    
    public static int productosSinStock() throws SQLException {
        
        int n = 0;
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select count(*) from productos where stock = 0");
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            n = rs.getInt(1);
        }
        
        return n;
        
    }
    
    public static void restarStock(Producto p, int n) throws SQLException {
        
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "update productos set  stock=stock-? where codigo=?");
        
        consulta.setInt(1, n);
        consulta.setInt(2, p.getCodigo());

        desconectarBD(con);
        
    }
    
    
    
       
}
