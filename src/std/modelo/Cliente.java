/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo;

import reflex.anotaciones.CampoPersistente;
import std.modelo.interfaces.IDao;

/**
 * Clase que modela un cliente común, con tres atributos obligatorios idCliente,
 * cuit, e idCategoria.
 * <ul>
 * <li>idCliente: Es un identificador que lo vincula con una {@link 
 * std.modelo.Persona} física o jurídica.</li>
 * <li>cuit: Clave Única de Identificación Tributaria. <a href="https://
 * seti.afip.gob.ar/padron-puc-constancia-internet/ConsultaConstanciaAction.do">
 * obtener CUIT</a>.</li>
 * <li>idCategoria: Identificador que representa una categoria tributaria ver {@link std.modelo.Categoria}</li>
 * </ul>
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 
 */
public final class Cliente extends Persona implements IDao {
    @CampoPersistente
    private int idCliente;
    @CampoPersistente
    private String cuit;
    @CampoPersistente
    private int idCategoria;

    private void inicializar() {
        this.setIdCliente(0);
        this.setNombre("Sin Nombre");
        this.setApellido("Sin Apellido");
        this.setDni("00000000");
        this.setDireccion("Sin dirección");
        this.setTelefono("000-0000000");
        this.setCuit("Sin-CUIT");
        this.setIdCategoria(0);
    }
    
    public Cliente() {
        super();
        this.inicializar();
    }

    /**
     *
     * @param dni DNI del Cliente
     * @param cuit CUIL del Cliente
     * @param idCategoria Categoría impositiva del Cliente
     */
    public Cliente(String dni,String cuit, int idCategoria) {
        super();
        this.inicializar();
        this.setDni(dni);
        this.setCuit(cuit);
        this.setIdCategoria(idCategoria);
    }

    /**
     * Cliente completamente cuantificado
     * @param idCliente
     * @param nombre
     * @param apellido
     * @param dni
     * @param direccion
     * @param telefono
     * @param cuit
     * @param idCategoria
     */
    public Cliente(int idCliente, String nombre, String apellido, String dni, String direccion, String telefono, String cuit, int idCategoria) {
        super();
        this.inicializar();
        this.setIdCliente(idCliente);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
        this.setCuit(cuit);
        this.setIdCategoria(idCategoria);
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public void setIdCliente(int idCliente){
        this.idCliente=idCliente;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public String getCuit() {
        return cuit;
    }

    public final void setCuit(String cuit) {
        this.cuit = cuit;
    }

    /**
     *
     * @return
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     *
     * @param idCategoria
     */
    public final void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    //</editor-fold>
    
    @Override
    public String toString() {
        return super.toString() + ("\nCuit=" + cuit + "\nCategoria=" + idCategoria).toUpperCase();
    }
    
    @Override
    public String getClave() {
        return this.getDni();
    }
    
    public static void main(String[] args) {
//        Cliente c = new Cliente("29729479","20297294790", 0);
//        Consola.enviar(c);
//        Consola.enviar("/////////////////////////////////////////////////////////////////");
//        Cliente c1 = new Cliente("Martín Alejandro", "Fernández", "29729479", "Mitre N°117 Piso 3 depto 4", "0381-6274324", "20297294790", 0);
//        Consola.enviar(c1);
    }



}
