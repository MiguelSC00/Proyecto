/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DaoPedido.conectarBD;
import static dao.DaoPedido.desconectarBD;
import static dao.DaoProducto.conectarBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.ListaItems;
import modelo.Pedido;

/**
 *
 * @author Miguel
 */
public class DaoListaItems {
    
    public static Connection conectarBD() throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebaproyecto?useSSL=false&allowPublicKeyRetrieval=true",
                "root", "");
//        return DriverManager.getConnection("jdbc:mysql://10.100.18.253:3306/proyecto?useSSL=false&allowPublicKeyRetrieval=true",
//                "root", "BIPobs46866");
    }
    
    public static void desconectarBD(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            System.err.println(ex.getClass().getName() + ": " + ex.getMessage());
        }
    }
    
    public static void crearListaItems(ListaItems l) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "insert into lista_items (codigo_pedido, codigo_producto, cantidad) values (?, ?, ?)");
    
        consulta.setInt(1, l.getCodigoPedido());
        consulta.setInt(2, l.getCodigoProducto());
        consulta.setInt(3, l.getCantidad());

        consulta.execute();
        desconectarBD(con);
    }
    
    public static boolean existeItems(int codigoProducto, int codigoPedido) throws SQLException {
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from lista_items where codigo_pedido =? and codigo_producto =?");
        consulta.setInt(1, codigoPedido);
        consulta.setInt(2, codigoProducto);
        ResultSet rs = consulta.executeQuery();
        
        if (rs.next()) {
            return true;
        } else {
            return false;
        }   
    }
    
    public static void updateCantidad(int codigoProducto, int codigoPedido) throws SQLException {
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "UPDATE tabla SET cantidad = cantidad + 1 WHERE codigo_pedido =? and codigo_producto =?");
        consulta.setInt(1, codigoPedido);
        consulta.setInt(1, codigoProducto);
        
        consulta.execute();
        desconectarBD(con);
         
    }
    
    public static void eliminarListaItems(int codigoPedido) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "delete from lista_items where codigo_pedido=?");
    
        consulta.setInt(1, codigoPedido);
        consulta.execute();
        
        desconectarBD(con);
    }
    
    public static  List<ListaItems> getListaItems(int codigoPedido) throws SQLException {
        Connection con = conectarBD();
        
        List<ListaItems> listaItems = new ArrayList();
        
        PreparedStatement consulta = con.prepareStatement(
                "select * from lista_items where codigo_pedido = ? order by codigo_producto");
    
        consulta.setInt(1, codigoPedido);
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            
            int codigoP = rs.getInt("codigo_pedido");
            int codigoProducto = rs.getInt("codigo_producto");
            int cantidad = rs.getInt("cantidad");
            
            ListaItems l = new ListaItems(codigoP, codigoProducto, cantidad);
            listaItems.add(l);
            
        }
        
        return listaItems;
        
    }
    

    
}
