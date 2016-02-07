/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */

package std.modelo;

import std.modelo.bd.BaseDeDatos;
import std.modelo.interfaces.IGestor;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class GestorModelo implements IGestor{
    private Class cModelo;
    
    //<editor-fold defaultstate="collapsed" desc=" Constructores">
    public GestorModelo(Class cModelo) {
        this.cModelo = cModelo;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">
    public Class getcModelo() {
        return cModelo;
    }

    public void setcModelo(Class cModelo) {
        this.cModelo = cModelo;
    }
    //</editor-fold>
    
    @Override
    public String alta() {
        BaseDeDatos bd = BaseDeDatos.getInstancia();
        return bd.insert(this.getcModelo());
    }

    @Override
    public String baja(){
        BaseDeDatos bd = BaseDeDatos.getInstancia();

        
        //return bd.delete(this.getcModelo());
        return "";
    }

    @Override
    public String modificar() {
        BaseDeDatos bd = BaseDeDatos.getInstancia();
        return bd.update(this.getcModelo());
    }

}
