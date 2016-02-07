/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class PanelIngresoTexto extends JPanel {

    private final VistaAlta ventana;

    public PanelIngresoTexto(VistaAlta ventana, String sEtiqueta, String sTextoPorDefecto,boolean bHorizontal) {
        this.ventana = ventana;
        if(bHorizontal){this.setLayout(new GridLayout(1,2,40,10));}
        else{this.setLayout(new GridLayout(2,1,40,10));}
        
        JLabel lblEtiqueta=new JLabel(sEtiqueta);
        lblEtiqueta.setPreferredSize(new Dimension(100,20));
        lblEtiqueta.setVisible(true);
        this.add(lblEtiqueta);
        
        JTextField txtInput=new JTextField();
        if(sTextoPorDefecto!=null){txtInput.setText(sTextoPorDefecto);}
        txtInput.setPreferredSize(new Dimension(100,20));
        txtInput.setVisible(true);
        this.add(txtInput);
        
        this.validate();
        this.setVisible(true);
        this.repaint();
        
    }
    
    public static void main(String[] args){
//        VistaAlta g=new VistaAlta(new Persona());
//        g.removeAll();
//        JPanel pan=new JPanel();
//        pan.add(new PanelIngresoTexto(g,"Hola","soy un texto",true));
//        g.add(pan);
//        //g.pack();//g.repaint();
//        g.setVisible(true);
    }
}
