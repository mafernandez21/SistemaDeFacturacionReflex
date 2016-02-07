/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */

package maf;

import reflex.vista.VistaReflexGestionDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.HashMap;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class ControladorOriginal implements ActionListener {
    public static final String COMANDO_ACEPTAR="ACEPTAR";
    public static final String COMANDO_CANCELAR="CANCELAR";
    public static final String COMANDO_ALTA="ALTA";
    public static final String COMANDO_BAJA="BAJA";
    public static final String COMANDO_MODIFICAR="MODIFICAR";
    
    Class cModelo;
    VistaReflexGestionDatos cVista;
    
    String[] sNombreCampo;
    HashMap hmTipoCampo=new HashMap();
    HashMap hmValorCampo=new HashMap();

    public ControladorOriginal(Class cModelo){
        this.cModelo=cModelo;//Persona.crear().getClass();
//        this.cVista=new VistaReflexGestionDatos(this);
//        this.cVista.mostrar(true);
        this.inicializar();
    }    
    
    private void inicializar(){
        Field[] cMiembros=this.cModelo.getDeclaredFields();
        sNombreCampo=new String[cMiembros.length];
        for(int i=0;i<cMiembros.length;i++){
            sNombreCampo[i]=cMiembros[i].getName();
            this.hmTipoCampo.put(cMiembros[i].getName(), cMiembros[i].getType().getSimpleName());
            this.hmValorCampo.put(cMiembros[i].getName(), null);
        }
    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Escuche la Accion "+e.getActionCommand());
        
//        switch(e.getActionCommand()){
//            case ControladorOriginal.COMANDO_ACEPTAR:
//                this.cModelo.cast(PersonaSimple.crear());
//                break;
//            case ControladorOriginal.COMANDO_ALTA:
//                this.cModelo.cast(PersonaSimple.crear());
//                break;
//            
//        }
    }
    
//    public static void main(String[] args){
////        ControladorOriginal c=new ControladorOriginal(PersonaSimple.class);
//    }

}
