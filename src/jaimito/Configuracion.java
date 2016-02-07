/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaimito;

import jaimito.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Configuracion {
    
    private HashMap configuracion = new HashMap();

    public void getParamet() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("servidor.cfg")));
            String datos;
            do {
                datos = br.readLine();
                if (datos != null) {
                    String[] dato = datos.split("=");
                    configuracion.put(dato[0].trim(),dato[1].trim());
                }
            } while (datos != null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.print(configuracion);
    }
}    

