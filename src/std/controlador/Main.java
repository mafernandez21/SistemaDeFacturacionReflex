/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.controlador;

import reflex.core.Cargador;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import reflex.vista.Consola;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>//@author Martín Alejandro
 */
public class Main {

    public static void main(String[] args) {
        Controlador c;
                
        Cargador loader=new Cargador();
        
        loader.cargarModulos("configuracionPorDefecto.properties");
        
        HashMap md = (HashMap)loader.getHmMetaDatos().get("MODULOS");
        
        String sModulos[]=String.valueOf(md.get("MODULOS")).split(",");
        
        for (String s: sModulos){
            Consola.enviar(s);
            try {
                
                c=new Controlador(Class.forName(s));
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        
        
    }

}
