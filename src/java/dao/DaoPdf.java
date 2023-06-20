/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DaoPedido.conectarBD;
import static dao.DaoPedido.desconectarBD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import modelo.Pdf;
import modelo.Usuario;

/**
 *
 * @author Miguel
 */
public class DaoPdf {
    
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
    
    public static void crearPdf(Pdf pdf) throws SQLException {
        Connection con = conectarBD();
        System.out.println("He llegado al metodo");
        PreparedStatement consulta = con.prepareStatement("INSERT INTO pdf (titulo, usuario, tipo) VALUES(?, ?, ?)");
        
        consulta.setString(1, pdf.getTitulo());
        consulta.setString(2, pdf.getUsuario());
        consulta.setString(3, pdf.getTipo());
        consulta.execute();
        desconectarBD(con);
    }
    
    public static Pdf getPdf(int id) throws SQLException {

        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement("SELECT * FROM pdf WHERE codigo = ?");
        consulta.setInt(1, id);
        ResultSet rs = consulta.executeQuery();
        
        Pdf pdf = null;
        if (rs.next()) {
            int codigo = (Integer)rs.getInt("codigo");
            String titulo = rs.getString("titulo");
            Timestamp fecha = rs.getTimestamp("fecha");
            String usuario = rs.getString("usuario");
            String tipo = rs.getString("tipo");
            
            pdf = new Pdf(codigo, titulo, fecha, usuario, tipo);
        }
        
        return pdf;
    }
    
    public static List<Pdf> getEntrenamientos(Usuario u) throws SQLException {
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement("SELECT * FROM pdf WHERE usuario = ? and tipo = ?");
        consulta.setString(1, u.getUsuario());
        consulta.setString(2, "Plan");
        ResultSet rs = consulta.executeQuery();
        
        List<Pdf> lista = new ArrayList();
        
        Pdf pdf = null;
        
        while (rs.next()) {
            int codigo = (Integer)rs.getInt("codigo");
            String titulo = rs.getString("titulo");
            Timestamp fecha = rs.getTimestamp("fecha");
            String usuario = rs.getString("usuario");
            String tipo = rs.getString("tipo");
            
            pdf = new Pdf(codigo, titulo, fecha, usuario, tipo);
            lista.add(pdf);
        }
        
        return lista;
    }
    
    public static List<Pdf> getReportes(Usuario u) throws SQLException {
        
        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement("SELECT * FROM pdf WHERE usuario = ? and tipo = ?");
        consulta.setString(1, u.getUsuario());
        consulta.setString(2, "Reporte");
        ResultSet rs = consulta.executeQuery();
        
        List<Pdf> lista = new ArrayList();
        
        Pdf pdf = null;
        
        while (rs.next()) {
            int codigo = (Integer)rs.getInt("codigo");
            String titulo = rs.getString("titulo");
            Timestamp fecha = rs.getTimestamp("fecha");
            String usuario = rs.getString("usuario");
            String tipo = rs.getString("tipo");
            
            pdf = new Pdf(codigo, titulo, fecha, usuario, tipo);
            lista.add(pdf);
        }
        
        return lista;
    }
    
    
        public static Pdf getUltimoPdf() throws SQLException {

        Connection con = conectarBD();
        PreparedStatement consulta = con.prepareStatement("select * from pdf order by codigo desc limit 1");
        ResultSet rs = consulta.executeQuery();
        
        Pdf pdf = null;
        if (rs.next()) {
            int codigo = (Integer)rs.getInt("codigo");
            String titulo = rs.getString("titulo");
            Timestamp fecha = rs.getTimestamp("fecha");
            String usuario = rs.getString("usuario");
            String tipo = rs.getString("tipo");
            
            pdf = new Pdf(codigo, titulo, fecha, usuario, tipo);
        }
        
        return pdf;
    }
    
    
    
    
    
}
