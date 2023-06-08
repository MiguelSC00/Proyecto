/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Miguel
 */
public class ListaItems {
    
    private int codigoPedido;
    private int codigoProducto;
    private int cantidad;

    public ListaItems(int codigoPedido, int codigoProducto, int cantidad) {
        this.codigoPedido = codigoPedido;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
