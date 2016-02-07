/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */

package reflex.modulos;

import java.util.HashMap;
import reflex.anotaciones.CampoPersistente;
import reflex.interfaces.IReflex;
import std.modelo.Persona;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public final class ClienteReflex extends Persona implements IReflex{
    
    @CampoPersistente
    private int idCliente;
    @CampoPersistente
    private String cuit;
    @CampoPersistente
    private int idCategoria;
    
    
    public ClienteReflex() {
        super();
        this.inicializar();
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return super.toString() + ("\nCuit=" + cuit + "\nCategoria=" + idCategoria).toUpperCase();
    }
    //</editor-fold>
    
    @Override
    public void inicializar() {
        this.setIdCliente(0);
        this.setNombre("Sin Nombre");
        this.setApellido("Sin Apellido");
        this.setDni("00000000");
        this.setDireccion("Sin dirección");
        this.setTelefono("000-0000000");
        this.setCuit("Sin-CUIT");
        this.setIdCategoria(0);
    }

    @Override
    public void setDatos(HashMap hmMetaDatos) {
        this.setIdCliente((int)hmMetaDatos.get("IDCLIENTE"));
        this.setNombre((String)hmMetaDatos.get("NOMBRE"));
        this.setApellido((String)hmMetaDatos.get("APELLIDO"));
        this.setDni((String)hmMetaDatos.get("DNI"));
        this.setDireccion((String)hmMetaDatos.get("DIRECCION"));
        this.setTelefono((String)hmMetaDatos.get("TELEFONO"));
        this.setCuit((String)hmMetaDatos.get("CUIT"));
        this.setIdCategoria((int)hmMetaDatos.get("IDCATEGORIA"));
    }

    @Override
    public HashMap getDatos() {
        HashMap hmMetaDatos=new HashMap();
        hmMetaDatos.put("IDCLIENTE",this.getIdCliente());
        hmMetaDatos.put("NOMBRE",this.getNombre());
        hmMetaDatos.put("APELLIDO",this.getApellido());
        hmMetaDatos.put("DNI",this.getDni());
        hmMetaDatos.put("DIRECCION",this.getDireccion());
        hmMetaDatos.put("TELEFONO",this.getTelefono());
        hmMetaDatos.put("CUIT",this.getCuit());
        hmMetaDatos.put("IDCATEGORIA",this.getIdCategoria());
        return hmMetaDatos;
    }
}