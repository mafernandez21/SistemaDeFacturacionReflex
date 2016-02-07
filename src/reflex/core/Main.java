/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package reflex.core;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import reflex.controlador.ControladorReflex;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class Main {

    public static void main(String[] args) {
       
        String archivoDeConfiguracion = "configuracionPorDefecto.properties";
        Cargador cargador = new Cargador();
        HashMap metaDatos;
        
        cargador.cargarModulos(archivoDeConfiguracion);
        cargador.cargarBD(archivoDeConfiguracion);

        metaDatos= (HashMap) cargador.getHmMetaDatos().get("MODULOS");

        String sModulosIReflex[] = String.valueOf(metaDatos.get("MODULOS")).split(",");

        int numModulos=sModulosIReflex.length;
        
        ControladorReflex crListaDeControladoresReflex[] = new ControladorReflex[numModulos];
        
        int numMenuItems=numModulos+1;//1 boton por modulo + el cancelar
        
        
        final JFrame vm = new JFrame();
        vm.setTitle("Sistema de Facturación Reflex");
        vm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vm.setLayout(new FlowLayout());
        vm.setSize(300, 300);
                
        JMenuBar barraDeMenu=new JMenuBar();
        
        JMenu menuFacturacion=new JMenu();
        
        JMenuItem menuItems[]=new JMenuItem[numMenuItems];
       
        menuFacturacion.setText("Facturacion");
        
        for(int i=0; i<numModulos;i++){
           crListaDeControladoresReflex[i] = new ControladorReflex(sModulosIReflex[i]);
           menuItems[i]=new JMenuItem(crListaDeControladoresReflex[i].getsIDControlador());         
           menuItems[i].setActionCommand(crListaDeControladoresReflex[i].getsIDControlador()+"."+menuItems[i].getText());
           menuItems[i].addActionListener(crListaDeControladoresReflex[i]);
           menuFacturacion.add(menuItems[i]);
        }
        
           menuItems[menuItems.length-1]=new JMenuItem("Salir");         
           menuItems[menuItems.length-1].setActionCommand(ControladorReflex.COMANDO_SALIR);
           menuItems[menuItems.length-1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vm.dispose();
            }
        });
        
        menuFacturacion.add(menuItems[menuItems.length-1]);
        
        
        
        barraDeMenu.add(menuFacturacion);
        
        //barraDeMenu.setVisible(true);
        
        vm.setJMenuBar(barraDeMenu);
        
        vm.setSize(300, 300);
        vm.setLocationRelativeTo(null);
        
        vm.setVisible(true);
        
        ControladorReflex cr=new ControladorReflex("modelo.clientes");
    }

}
