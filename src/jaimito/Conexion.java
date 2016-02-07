/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jaimito;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando
 */
public class Conexion {

    private String servidor;
    private String database;
    private String port;
    private String protocolo;
    private String driver;
    private String usuario;
    private String password;
    private Connection conection;
    private Statement statement;

    public Conexion(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
        getParamet();
    }

    public Connection getConection() {
        return conection;
    }

    public Statement getStatement() {
        return statement;
    }

    public boolean conectar() {
        boolean resultado = false;
        String url = protocolo + "://" + servidor + ":" + port + "/" + database;
        System.out.println(url + " " + usuario + " " + password);
        try {
            Class.forName(driver);
            conection = DriverManager.getConnection(url, usuario, password);
            statement = conection.createStatement();
            resultado = true;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    private void getParamet() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("servidor")));
            String datos;
            do {
                datos = br.readLine();
                if (datos != null) {
                    String[] dato = datos.split("=");
                    String atributo = dato[0].trim();
                    if (atributo.equals("servidor")) {
                        servidor = dato[1].trim();
                    }
                    if (atributo.equals("database")) {
                        database = dato[1].trim();
                    }
                    if (atributo.equals("port")) {
                        port = dato[1].trim();
                    }
                    if (atributo.equals("protocolo")) {
                        protocolo = dato[1].trim();
                    }
                    if (atributo.equals("driver")) {
                        driver = dato[1].trim();
                    }
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
    }
}
