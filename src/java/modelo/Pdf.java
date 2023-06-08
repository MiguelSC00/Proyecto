/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.InputStream;
import java.sql.Timestamp;

/**
 *
 * @author Miguel
 */
public class Pdf {
    
    /*Todo los atributos*/
    private int codigopdf;
    private String titulo;
    private Timestamp fecha;
    private String usuario;
    private String tipo;

    public Pdf(int codigopdf, String titulo, Timestamp fecha, String usuario, String tipo) {
        this.codigopdf = codigopdf;
        this.titulo = titulo;
        this.fecha = fecha;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public Pdf(String titulo, String usuario, String tipo) {
        this.titulo = titulo;
        this.usuario = usuario;
        this.tipo = tipo;
    }

    public int getCodigopdf() {
        return codigopdf;
    }

    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
    

    
    
    
    
}
