/*
 * Esta clase fué desarrollada por Martín Alejandro Fernández.
 * La edición de la presente clase, sin expresa autorización
 * no esta permitida.
 */
package reflex.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import javax.swing.JOptionPane;
import reflex.anotaciones.CampoPersistente;
import reflex.interfaces.IReflex;
import reflex.interfaces.IVista;
import reflex.vista.Consola;
import reflex.vista.ConsolaGUI;
import reflex.vista.VistaReflexGestionDatos;
import std.modelo.bd.BaseDeDatos;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
@SuppressWarnings("FieldMayBeFinal")
public class ControladorReflex implements ActionListener {

    public static final String NOMBRE_DEL_SISTEMA="Sistema de Facturacion Reflex";
    
    public static final String COMANDO_ACEPTAR = "ACEPTAR";
    public static final String COMANDO_CANCELAR = "CANCELAR";
    public static final String COMANDO_SALIR = "SALIR";
    public static final String COMANDO_ALTA = "ALTA";
    public static final String COMANDO_BAJA = "BAJA";
    public static final String COMANDO_MODIFICAR = "MODIFICAR";

    public static final String ERROR_IRRECUPERABLE = "Error Irrecuperable";

    private String sIDControlador;
    private IReflex modReflex;
    private HashMap hmMetaDatos;
    private HashMap hmDatos;
    private IVista vistaControlador;

    public ControladorReflex(String sModulo) {
        try {
            this.hmMetaDatos = new HashMap();
            this.hmDatos = new HashMap();
            this.modReflex = (IReflex) Class.forName(sModulo).newInstance();
            this.sIDControlador = this.modReflex.getClass().getSimpleName();
            //this.prepararVistaDeGestion();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            this.hmMetaDatos = null;
            this.hmDatos = null;
            this.modReflex = null;
            this.sIDControlador = null;
            ConsolaGUI.enviarErr(ControladorReflex.ERROR_IRRECUPERABLE + " (" + ex.getMessage() + " - " + ex.getClass().getSimpleName() + ")");
            Consola.enviarErr(ControladorReflex.ERROR_IRRECUPERABLE + " (" + ex.getMessage() + " - " + ex.getClass().getSimpleName() + ")");
            JOptionPane.showMessageDialog(null, "El sistema se cerrará",ControladorReflex.NOMBRE_DEL_SISTEMA,JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getsIDControlador() {
        return this.sIDControlador;
    }

    private void setsIDControlador(String sIDControlador) {
        this.sIDControlador = sIDControlador;
    }

    private IReflex getModReflex() {
        return modReflex;
    }

    private void setModReflex(IReflex modReflex) {
        this.modReflex = modReflex;
    }

    private IVista getVistaControlador() {
        return vistaControlador;
    }

    public void setVistaControlador(IVista vistaControlador) {
        this.vistaControlador = vistaControlador;
    }

    private HashMap getHmMetaDatos() {
        return hmMetaDatos;
    }

    private void setHmMetaDatos(HashMap hmMetaDatos) {
        this.hmMetaDatos = hmMetaDatos;
    }

    private HashMap getHmDatos() {
        return hmDatos;
    }

    private void setHmDatos(HashMap hmDatos) {
        this.hmDatos = hmDatos;
    }

    private IVista getVista() {
        return vistaControlador;
    }

    public void setVista(IVista ivVistaControlador) {
        this.vistaControlador = ivVistaControlador;
    }

    //</editor-fold>
    
    public HashMap getMetaDatosDeClase(Class cClaseModelo) {
        HashMap hmMetaDatosClase = new HashMap();
        //Extraigo todos los campos/miembros de la clase
        Field fCamposDeClase[] = cClaseModelo.getDeclaredFields();
        //Indicador de primer campo persistente
        boolean bPrimerCampo = true;
        //Variable para extraer la anotación de "CampoPersistente"
        Annotation aAnotacionDeCampo;
        /*Extraigo el nombre de todos los campos/miembros que van a tener
        persistencia*/
        String sNombresDeCampos = "";
        for (Field c : fCamposDeClase) {
            c.setAccessible(true);
            aAnotacionDeCampo = c.getAnnotation(CampoPersistente.class);
            if ((aAnotacionDeCampo != null)
                    && (aAnotacionDeCampo instanceof CampoPersistente)) {
                if (bPrimerCampo) {
                    sNombresDeCampos += c.getName();
                    bPrimerCampo = false;
                } else {
                    sNombresDeCampos += "," + c.getName();
                }
            }
        }
        //Los datos extraidos se los incluye en un HashMap
        hmMetaDatosClase.put("NOMBRE_CLASE", cClaseModelo.getSimpleName());
        hmMetaDatosClase.put("CAMPOS_CLASE", sNombresDeCampos);
        return hmMetaDatosClase;
    }

    public void getEntradaDeUsuario() {
        this.setHmDatos(this.getVista().getEntradaDeUsuario());
        this.getModReflex().inicializar();
        this.getModReflex().setDatos(this.getHmDatos());
    }

    public void prepararVistaDeGestion() {
        String sNombreDeClase = String.valueOf(this.getMetaDatosDeClase(this.getModReflex().getClass()).get("NOMBRE_CLASE")
        );
        String sNombreDeCampos[] = String.valueOf(this.getMetaDatosDeClase(this.getModReflex().getClass()).get("CAMPOS_CLASE"))
                .split(",");
        this.vistaControlador=new VistaReflexGestionDatos();
        
        this.vistaControlador.inicializar(this);
        
        
        this.vistaControlador.mostrarVista();
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case ControladorReflex.COMANDO_ACEPTAR:
                break;
            case ControladorReflex.COMANDO_CANCELAR:
                this.getVista().cerrarVista();
                break;
            case ControladorReflex.COMANDO_ALTA:
                this.getEntradaDeUsuario();
                BaseDeDatos.getInstancia().insert(this.getModReflex());
                break;
            case ControladorReflex.COMANDO_BAJA:
                this.getEntradaDeUsuario();
                BaseDeDatos.getInstancia().delete(this.getModReflex());
                break;
            case ControladorReflex.COMANDO_MODIFICAR:
                this.getEntradaDeUsuario();
                BaseDeDatos.getInstancia().update(this.getModReflex());
                break;
            case ControladorReflex.COMANDO_SALIR:
                this.getVistaControlador().cerrarVista();
            default:
                break;
        }
        JOptionPane.showMessageDialog(null, "El controlador " + this.getsIDControlador() + " escuchó " + e.getActionCommand());
        JOptionPane.showMessageDialog(null, this.getMetaDatosDeClase(this.modReflex.getClass()).get("NOMBRE_CLASE"));
        JOptionPane.showMessageDialog(null, this.getMetaDatosDeClase(this.modReflex.getClass()).get("CAMPOS_CLASE"));
    }
}
