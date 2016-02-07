/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import std.modelo.Producto;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class VistaAlta extends JDialog {

    private JPanel getPanelGeneral() {
        JPanel panelGeneral = new JPanel(new BorderLayout());
        ((BorderLayout) panelGeneral.getLayout()).setHgap(10);
        ((BorderLayout) panelGeneral.getLayout()).setVgap(10);
        return panelGeneral;
    }

    private JPanel setPanelCampos(Class clase) {
        Field[] campos = clase.getDeclaredFields();
        
        JLabel[] lblEtiquetas = new JLabel[campos.length];
        JTextField[] txtIngresos = new JTextField[campos.length];
        //String[] nombresCampos = new String[campos.length];
        JPanel[] panelIngreso = new JPanel[campos.length];
        FlowLayout layoutHorizontal = new FlowLayout(FlowLayout.CENTER, 10, 10);
        GridLayout layoutVertical = new GridLayout(campos.length, 2, 40, 10);

        JPanel panelCampos = new JPanel(layoutVertical);

        for (int i = 0; i < campos.length; i++) {
            campos[i].setAccessible(true);
            lblEtiquetas[i] = new JLabel(campos[i].getName().toUpperCase());
            lblEtiquetas[i].setPreferredSize(new Dimension(150, 20));
            txtIngresos[i] = new JTextField();
            txtIngresos[i].setPreferredSize(new Dimension(150, 20));
            panelIngreso[i] = new JPanel(layoutHorizontal);
            panelIngreso[i].add(lblEtiquetas[i]);
            panelIngreso[i].add(txtIngresos[i]);
            panelCampos.add(panelIngreso[i]);
        }
        panelCampos.setVisible(true);
        return panelCampos;
    }
    
    private PanelBotones setPanelBotones(){
        String[] sBotones={PanelBotones.BOTON_ALTA,PanelBotones.BOTON_CANCELAR};
        return new PanelBotones(this, sBotones, true);
    }


    public VistaAlta(Object oClasePatron) {
        try {
            Class clase = Class.forName(oClasePatron.getClass().getName());
//            
//            this.setClasePatron(clase.getSimpleName());
//
//            this.setTitle("Gestor Dinámico de Altas ("+this.getClasePatron()+")-VGestorAlta");
//            
//            JPanel panelGeneral = this.setPanelGeneral();

            PanelBotones panelBotones = this.setPanelBotones();


            //TODO TOMAR LOS DATOS DE LOS CAMPOS
            JPanel panelCampos = this.setPanelCampos(clase);

//            panelGeneral.add(panelCampos, BorderLayout.CENTER);
//            panelGeneral.add(panelBotones, BorderLayout.SOUTH);
//
//            this.add(panelGeneral);
//            this.setSize(400, 400);
            this.pack();
            this.setLocationRelativeTo(null);
            this.setAlwaysOnTop(true);
            this.repaint();
            this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(VistaAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        
        
        VistaAlta gp=new VistaAlta(new Producto());
        
        gp.setVisible(true);
        
        while (gp.isActive()){
        
        }
        
//        System.out.println(gp.getAccion()+" Activo:"+gp.isActive());
//            
//        
//        new VistaAlta(new Persona()).setVisible(true);
    }
}
