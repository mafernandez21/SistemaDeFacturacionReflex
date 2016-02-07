package jaimito;

import java.util.ArrayList;
import java.util.Date;
import std.modelo.Cliente;
import std.modelo.Producto;

/**
 * @author Paradigmas
 * @version 1.0
 * @created 16-nov-2015 10:40:20
 */
public class Factura2 {

	private int id;
	private Date fecha;
	private int numero;
	private Cliente cliente;
	private Producto producto;
	private float excento;
	private float neto;
	private float iva;
	private float total;
	private ArrayList<DetalleFactura> detalles;

	public Factura2(){

	}

	public void finalize() throws Throwable {

	}

}