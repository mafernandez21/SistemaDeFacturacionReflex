/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package reflex.vista;

import javax.swing.JOptionPane;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class ConsolaGUI {

    public static boolean activa = true;

    public static void activar() {
        activa = true;
    }

    public static void desactivar() {
        activa = false;
    }

    public boolean estaActiva() {
        return activa;
    }

    public static void enviar(Object msg) {
        if (activa) {
            JOptionPane.showMessageDialog(null, String.valueOf(msg),
                    "Sistema de Facturacion Reflex", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void enviarErr(Object msg) {
        if (!activa) {
            ConsolaGUI.activar();
            JOptionPane.showMessageDialog(null, String.valueOf(msg),
                    "Sistema de Facturacion Reflex", JOptionPane.ERROR_MESSAGE);
            ConsolaGUI.desactivar();
        } else {
            JOptionPane.showMessageDialog(null, String.valueOf(msg),
                    "Sistema de Facturacion Reflex", JOptionPane.ERROR_MESSAGE);
        }
    }
}
