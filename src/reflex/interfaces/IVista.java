/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package reflex.interfaces;

import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public interface IVista {

    void inicializar(ActionListener alControlador);
    
    void setTitulo(String sTitulo);
    
    void setCampos(HashMap hmMetaDatosClase);
    
    void actualizar();
    
    void mostrarVista();
    
    void ocultarVista();
    
    void cerrarVista();
    
    void setEntradaDeUsuario(HashMap hmMetaDatos);
    
    HashMap getEntradaDeUsuario();
}
