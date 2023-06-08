/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DaoListaItems.conectarBD;
import static dao.DaoProducto.conectarBD;
import static dao.DaoProducto.desconectarBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author Miguel
 */
public class DaoPedido {
    
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
    
    public static void crearPedido(Pedido p) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "insert into pedidos (usuario, precio, provincia, codigo_postal, calle, numero, estado) values (?, ?, ?, ?, ?, ?, ?)");
    
        consulta.setString(1, p.getUsuario());
        consulta.setDouble(2, p.getPrecio());
        consulta.setString(3, p.getProvincia());
        consulta.setString(4, p.getCodigoPostal());
        consulta.setString(5, p.getCalle());
        consulta.setInt(6, p.getNumero());
        consulta.setString(7, p.getEstado());
        consulta.execute();
        desconectarBD(con);
    }
    
    public static void eliminarPedido(int codigo) throws SQLException {
        Connection con = conectarBD();
        
        PreparedStatement consulta = con.prepareStatement(
                "delete from pedidos where codigo=?");
    
        consulta.setInt(1, codigo);
        consulta.execute();
        
        desconectarBD(con);
    }
    
    public static Pedido buscarPedido(int codigo) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from pedidos where codigo=?");
        consulta.setInt(1, codigo);
        ResultSet rs = consulta.executeQuery();
        Pedido p = null;
        if (rs.next()) {
            String usuario = rs.getString("usuario");
            Timestamp fecha = rs.getTimestamp("fecha");
            double precio = rs.getDouble("precio");
            String provincia = rs.getString("provincia");
            String codigoPostal = rs.getString("codigo_postal");
            String calle = rs.getString("calle");
            int numero = rs.getInt("numero");
            String estado = rs.getString("estado");
            p = new Pedido(codigo, usuario, fecha, precio, provincia, codigoPostal, calle, numero, estado);
        }
        desconectarBD(con);
        return p;
    }
    
    public static Pedido buscarUltimoPedido() throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from pedidos order by codigo desc limit 1");
        ResultSet rs = consulta.executeQuery();
        Pedido p = null;
        if (rs.next()) {
            int codigo = rs.getInt("codigo");
            String usuario = rs.getString("usuario");
            Timestamp fecha = rs.getTimestamp("fecha");
            double precio = rs.getDouble("precio");
            String provincia = rs.getString("provincia");
            String codigoPostal = rs.getString("codigo_postal");
            String calle = rs.getString("calle");
            int numero = rs.getInt("numero");
            String estado = rs.getString("estado");
            p = new Pedido(codigo, usuario, fecha, precio, provincia, codigoPostal, calle, numero, estado);
        }
        desconectarBD(con);
        return p;
    }
    
    public static int totalPedidos() throws SQLException {
        int total = 0;
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select count(*) from pedidos");
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            total = rs.getInt(1);
        }
        
        return total;
    }
    
        public static int pedidosAceptados() throws SQLException {
        
        int n = 0;
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select count(*) from pedidos where estado = ?");
        consulta.setString(1, "Pago aceptado");
        ResultSet rs = consulta.executeQuery();
        if (rs.next()) {
            n = rs.getInt(1);
        }
        
        return n; 
    }
        
    public static void enviarPedido(int codigo) throws SQLException {
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "update pedidos set estado = 'Enviado' where codigo =?");
        consulta.setInt(1, codigo);
        consulta.execute();
    }
    
    public static List<Pedido> pedidosPendientes() throws SQLException {
        
        List<Pedido> pedidos = new ArrayList();
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from pedidos where estado = 'Pago aceptado' order by codigo asc limit 4");
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String usuario = rs.getString("usuario");
            Timestamp fecha = rs.getTimestamp("fecha");
            double precio = rs.getDouble("precio");
            String provincia = rs.getString("provincia");
            String codigoPostal = rs.getString("codigo_postal");
            String calle = rs.getString("calle");
            int numero = rs.getInt("numero");
            String estado = rs.getString("estado");
            
            Pedido p = new Pedido(codigo, usuario, fecha, precio, provincia, codigoPostal, calle, numero, estado);
            pedidos.add(p);
        }
        
        return pedidos;
    }
    
    public static List<Pedido> consultarPedidos() throws SQLException {
        
        List<Pedido> pedidos = new ArrayList();
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement(
                "select * from pedidos");
        ResultSet rs = consulta.executeQuery();
        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String usuario = rs.getString("usuario");
            Timestamp fecha = rs.getTimestamp("fecha");
            double precio = rs.getDouble("precio");
            String provincia = rs.getString("provincia");
            String codigoPostal = rs.getString("codigo_postal");
            String calle = rs.getString("calle");
            int numero = rs.getInt("numero");
            String estado = rs.getString("estado");
            
            Pedido p = new Pedido(codigo, usuario, fecha, precio, provincia, codigoPostal, calle, numero, estado);
            pedidos.add(p);
        }
        
        return pedidos;
    }
    
    
    
}
