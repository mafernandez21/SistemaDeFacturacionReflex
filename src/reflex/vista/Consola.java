/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */

package reflex.vista;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class Consola {
    public static boolean activa=true;
    
    public static void activar(){
        activa=true;
    }
    
    public static void desactivar(){
        activa=false;
    }
     
    public boolean estaActiva(){
        return activa;
    }
    public static void enviar(Object str){
        if(activa){System.out.println(String.valueOf(str));}
    }
    
    public static void enviarErr(Object str){
        if(!activa){
            Consola.activar();
            System.err.println(String.valueOf(str));
            Consola.desactivar();
        }else{
            System.err.println(String.valueOf(str));
        }
    }
}