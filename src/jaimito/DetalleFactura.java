/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jaimito;

import std.modelo.Producto;
import reflex.vista.Consola;

/**
 *
 * @author Paradigmas
 */
public class DetalleFactura {
    private int cantidad;
    private Producto producto;
    private float subtotal;

    public DetalleFactura(int cantidad, Producto producto, float subtotal) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = subtotal;
    }

//<editor-fold defaultstate="collapsed" desc=" Getters and Setters">
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
    
//</editor-fold>

    @Override
    public String toString() {
        return this.cantidad + "\t|" + this.producto.getDescripcion() + "\t|" + this.producto.getPrecio() + "\t|"  + this.subtotal ;
    }

    public static void main(String[] args){
        DetalleFactura df=new DetalleFactura(5,new Producto(),100);
        Consola.enviar(df);
    }
}
