/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package reflex.vista;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import reflex.controlador.ControladorReflex;
import reflex.interfaces.IVista;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class VistaReflexGestionDatos extends JFrame implements IVista {

    private ActionListener controlador;

    private JPanel pnlPanelPrincipal = new JPanel();
    
    private JPanel pnlPanelBotones = new JPanel();
    
    private JPanel pnlPanelDeDatos = new JPanel();
    
    private JScrollPane scrllpPanelGrilla = new JScrollPane();
    
    
    private JMenuBar mnubBarraDeMenu = new JMenuBar();
    private JMenu mnuMenuFacturacion = new JMenu();
    private JMenuItem mnuItemSalir = new JMenuItem();

    private JButton btnAlta = new JButton();
    private JButton btnBaja = new JButton();
    private JButton btnModificar = new JButton();
    private JButton btnVer = new JButton();

    private JTable tblDatos = new JTable();

    public VistaReflexGestionDatos() {
        this.controlador = null;
    }

    @Override
    public void inicializar(ActionListener alControlador) {
        this.setControlador(alControlador);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        pnlPanelPrincipal.setLayout(new FlowLayout());

        JButton btnAceptar = new JButton();
        JButton btnCancelar = new JButton();

        btnAceptar.setText("Aceptar");
        btnAceptar.setActionCommand(ControladorReflex.COMANDO_ACEPTAR);
        btnAceptar.addActionListener(this.getControlador());

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand(ControladorReflex.COMANDO_CANCELAR);
        btnCancelar.addActionListener(this.getControlador());

        pnlPanelPrincipal.add(btnAceptar);
        pnlPanelPrincipal.add(btnCancelar);
        
        this.pnlPanelDeDatos.add(this.tblDatos);
        this.pnlPanelPrincipal.add(this.pnlPanelDeDatos);
        this.add(pnlPanelPrincipal);
    }

    @Override
    public void actualizar() {
        JOptionPane.showMessageDialog(null, "Vista Actualizada");
    }

    @Override
    public void setTitulo(String sTitulo) {
        this.setTitle(sTitulo);
    }

    @Override
    public void mostrarVista() {
        this.setVisible(true);
    }

    @Override
    public void ocultarVista() {
        this.setVisible(false);
    }

    @Override
    public HashMap getEntradaDeUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setEntradaDeUsuario(HashMap hmMetaDatos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarVista() {
        this.dispose();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public void setControlador(ActionListener controlador) {
        this.controlador = controlador;
    }

    public ActionListener getControlador() {
        return this.controlador;
    }

//</editor-fold>
    public static void main(String[] args) {
        IVista miVista = new VistaReflexGestionDatos();
        ControladorReflex ctrl = new ControladorReflex("reflex.modulos.ClienteReflex");
        ctrl.setVista(miVista);
        miVista.inicializar(ctrl);
        miVista.mostrarVista();
    }
    
    public JTable getTblDatos(){
        return this.tblDatos;
    }

    @Override
    public void setCampos(HashMap hmMetaDatosClase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void prepararTabla(HashMap hmMetaDatosClase) {
        DefaultTableModel modelo = new DefaultTableModel();
        this.tblDatos.setModel(modelo);
        //La cantidad de columnas que tiene la consulta
        String sNombreDeModulos[] = String.valueOf(hmMetaDatosClase.get("MODULOS_CLASE")).split(",");
        //Establecer como cabezeras el nombre de las colimnas
        for (String s : sNombreDeModulos) {
            modelo.addColumn(s);
        }

        //Creando las filas para el JTable
        Object[] fila = new Object[sNombreDeModulos.length];
        for (int i = 0; i < sNombreDeModulos.length; i++) {
            fila[i] = null;
        }
        modelo.addRow(fila);
    
    }

}
