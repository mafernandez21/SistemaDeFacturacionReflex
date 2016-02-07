/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */

package maf;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class HiloLoquillo implements Runnable{
    
    //<editor-fold defaultstate="collapsed" desc="Atributos">
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Método Main">
    public static void main(String[] args){
        //TODO-Aquí va la lógica para iniciar la clase
    }
    //</editor-fold>

    @Override
    public void run() {
        while(true){
            System.out.println("Soy " + this.getClass().getSimpleName() + " y sigo activo");
        }
    }
}
