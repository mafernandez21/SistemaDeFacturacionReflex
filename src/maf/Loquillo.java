/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */
package maf;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class Loquillo {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Método Main">
    public static void main(String[] args) {
        //TODO-Aquí va la lógica para iniciar la clase
        HiloLoquillo hl = new HiloLoquillo();
        Thread hilo = new Thread(hl);

        Thread hilo2 = new Thread(hl);
        Thread hilo3 = new Thread(hl);
        
        hilo.start();
        hilo2.start();
        hilo3.start();

        try {
            Thread.sleep(5000);
            System.out.println("Soy " + Loquillo.class.getSimpleName().toUpperCase() + " y mando un System.exit()");
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Loquillo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //</editor-fold>

}
