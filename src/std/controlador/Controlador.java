/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */

package std.controlador;

import reflex.vista.Consola;
import reflex.vista.VistaReflexGestionDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import std.modelo.Persona;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class Controlador implements ActionListener {
    public static final String COMANDO_ACEPTAR="ACEPTAR";
    public static final String COMANDO_CANCELAR="CANCELAR";
    public static final String COMANDO_ALTA="ALTA";
    public static final String COMANDO_BAJA="BAJA";
    public static final String COMANDO_MODIFICAR="MODIFICAR";
    
    Class cModelo;
    VistaReflexGestionDatos cVista;

    public Controlador(Class cModelo){
        this.cModelo=cModelo;
        this.cVista=new VistaReflexGestionDatos();
//        this.cVista.inicializar(this);
        this.cVista.mostrarVista();
        this.inicializar();
    }    
    
    private void inicializar(){
        Field[] cMiembros=this.cModelo.getDeclaredFields();
        //sNombreCampo=new String[cMiembros.length];
        for(int i=0;i<cMiembros.length;i++){
            Consola.enviar(cMiembros[i].getName()+String.valueOf(cMiembros[i].getModifiers()));
            
            //sNombreCampo[i]=cMiembros[i].getName();
            //this.hmTipoCampo.put(cMiembros[i].getName(), cMiembros[i].getType().getSimpleName());
            //this.hmValorCampo.put(cMiembros[i].getName(), null);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Escuche la Accion "+e.getActionCommand());
        
//        switch(e.getActionCommand()){
//            case ControladorOriginal.COMANDO_ACEPTAR:
//                this.cModelo.cast(Persona.crear());
//                break;
//            case ControladorOriginal.COMANDO_ALTA:
//                this.cModelo.cast(Persona.crear());
//                break;
//            
//        }
    }
    
    public static void main(String[] args) {
        Controlador c=new Controlador (Persona.class);
    }

}
