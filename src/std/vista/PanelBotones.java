/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class PanelBotones extends JPanel {

    public final static String BOTON_ACEPTAR = "ACEPTAR";
    public final static String BOTON_APLICAR = "APLICAR";
    public final static String BOTON_CANCELAR = "CANCELAR";
    public final static String BOTON_ALTA = "ALTA";
    public final static String BOTON_BAJA = "BAJA";
    public final static String BOTON_MODIFICAR = "MODIFICAR";
    public final static String BOTON_LISTAR = "LISTAR";
    public final static String BOTON_POR_DEFECTO = "DEFAULT";

    private final VistaAlta ventana;

    // <editor-fold defaultstate="collapsed" desc="Configuracion">     
    private void setBotones(String[] sBotones) {
        if (sBotones == null) {
            String[] s = {PanelBotones.BOTON_ACEPTAR, PanelBotones.BOTON_CANCELAR};
            sBotones = s.clone();
        }
        JButton[] botones = new JButton[sBotones.length];
        for (int i = 0; i < sBotones.length; i++) {
            botones[i] = new JButton();
            botones[i].setText(sBotones[i]);
            botones[i].addActionListener(new ActionListener () {
                @Override
                public void actionPerformed(ActionEvent e) {
                    accion(e);
                }
            }
            );
            botones[i].setSize(new Dimension(botones[i].getText().length(), 20));
            botones[i].setVisible(true);
            this.add(botones[i]);
        }
    }
    
    private void setHorientacion(boolean bHorizontal) throws UnsupportedOperationException {
        if (bHorizontal) {
            this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        } else {
            throw new UnsupportedOperationException("Solo el formato Horizontal está soportado");
        }
    }
    // </editor-fold>  

    /**
     * Crea un panel con los botones que se le indiquen
     *
     * @param ventana Ventana donde se van a agregar los botones, y en la cual
     * se va recibir la acción de los botones.
     * @param sBotones Vector con la cantidad y los nombres de los botones.
     * @param bHorizontal Bandera que indica si la disposición es
     * Horizontal(true) o Vertical(False).
     */
    public PanelBotones(VistaAlta ventana, String[] sBotones, boolean bHorizontal) {
        if(ventana!=null){this.ventana = ventana;}else{this.ventana=new VistaAlta(new Object());}
        this.setBotones(sBotones);
        this.setHorientacion(bHorizontal);
        this.validate();
        this.setVisible(true);
        this.repaint();
    }

    /**
     * Método que devuelve la acción generada en los botones, hacia la ventana
     * que agregó el panel de botones
     *
     * @param evt ActionEvent que captura el evento generado en el botón
     */
    private void accion(ActionEvent evt) {
        JButton btn = (JButton) evt.getSource();
        switch (btn.getText()) {
            case PanelBotones.BOTON_ACEPTAR:
            case PanelBotones.BOTON_CANCELAR:
//                this.setAccion(btn.getText() + "-" + this.ventana.getClasePatron(), true);
                break;
            case PanelBotones.BOTON_ALTA:
            case PanelBotones.BOTON_APLICAR:
            case PanelBotones.BOTON_BAJA:
            case PanelBotones.BOTON_LISTAR:
            case PanelBotones.BOTON_MODIFICAR:
//                this.setAccion(btn.getText() + "-" + this.ventana.getClasePatron(), false);
                break;
            default:
//                this.setAccion(PanelBotones.BOTON_POR_DEFECTO + "-" + this.ventana.getClasePatron(), true);
                break;
        }
    }

    private void setAccion(String sAccion, boolean bCerrarVentana) {
//        this.ventana.setAccion(sAccion);
        if (bCerrarVentana) {
            this.ventana.dispose();
        }
    }

    public static void main(String[] args) {
        JDialog ventana = new JDialog();

        ventana.setLayout(new BorderLayout());

        try {
            ventana.add(new PanelBotones(null, null, true), BorderLayout.SOUTH);
        } catch (Exception e) {
        }

        ventana.setAlwaysOnTop(true);
        ventana.setSize(500, 500);
        ventana.pack();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
}
