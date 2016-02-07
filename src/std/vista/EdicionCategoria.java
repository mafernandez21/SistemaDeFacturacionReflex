/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package std.vista;

import maf.ControladorOriginal;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import std.modelo.Persona;

/**
 *
 * @author fernando
 */
public class EdicionCategoria extends javax.swing.JDialog {

    private String[] rotulos = {"Id:", "Nombre:", "Discrimina:"};
    private int[] anchos = {10, 30, 3};

    /**
     * Creates new form EdicionCategoria
     */
    public EdicionCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private void initComponents() {
        setTitle("Edicion Categoria");
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.add(getPanelEdicion(), BorderLayout.CENTER);
        panel1.add(getPanelBotones(), BorderLayout.SOUTH);
        getContentPane().add(panel1);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        pack();
    }

    private JPanel getPanelEdicion() {
        JPanel panelEdicion = new JPanel(new GridLayout(rotulos.length, 1));
        for (int i = 0; i < rotulos.length; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JLabel(ajustar(rotulos[i],12)),BorderLayout.WEST);
            panel.add(new JTextField(anchos[i]),BorderLayout.CENTER);
            panelEdicion.add(panel);
        }
        return panelEdicion;
    }

    private String ajustar(String rotulo, int ancho) {
        return (rotulo + "               ").substring(0, ancho);
    }
    private JPanel getPanelBotones() {
        JPanel panelBotones = new JPanel();
        JButton aceptar = new JButton("Aceptar");
        ControladorOriginal cp=new ControladorOriginal(Persona.class);
        aceptar.addActionListener(cp);
        aceptar.setActionCommand("Aceptar");
        panelBotones.add(aceptar);
        JButton cancelar = new JButton("Cancelar");
        panelBotones.add(cancelar);
        return panelBotones;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EdicionCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EdicionCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EdicionCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EdicionCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EdicionCategoria dialog = new EdicionCategoria(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
