/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Timestamp;

/**
 *
 * @author Miguel
 */
public class Pedido {
    
    private int codigo;
    private String usuario;
    private Timestamp fecha;
    private double precio;
    private String provincia;
    private String codigoPostal;
    private String calle;
    private int numero;
    private String estado;

    public Pedido(int codigo, String usuario, Timestamp fecha, double precio, String provincia, String codigoPostal, String calle, int numero, String estado) {
        this.codigo = codigo;
        this.usuario = usuario;
        this.fecha = fecha;
        this.precio = precio;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.numero = numero;
        this.estado = estado;
    }
    
    public Pedido(String usuario, double precio, String provincia, String codigoPostal, String calle, int numero, String estado) {
        this.usuario = usuario;
        this.precio = precio;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.numero = numero;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getDireccion() {
        return this.codigoPostal + ", " + this.calle + " " + this.numero;
    }
    
    
    
    
}
