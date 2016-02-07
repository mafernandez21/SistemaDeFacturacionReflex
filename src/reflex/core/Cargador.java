/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package reflex.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import reflex.vista.Consola;
import std.modelo.bd.BaseDeDatos;

/**
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class Cargador {
    public static final String ERROR_IO="No se pudo acceder al dispositivo de "
            + "almacenamiento";
    public static final String ERROR_HASHMAP="Datos corruptos";
    public static final String ERROR_CARGA_MODULO="El módulo no se pudo cargar";
    
    HashMap hmMetaDatos = new HashMap();

    public HashMap getHmMetaDatos() {
        return hmMetaDatos;
    }

    public void cargarModulos(String sArchivo) {
        Properties pCfgSistema = new Properties();
        InputStream isCfgSistema = null;
        HashMap hmMetaDatosModulos = new HashMap();
        String sMod="";
        
        try {
            //Cargamos el archivo de configuracion
            isCfgSistema = new FileInputStream(sArchivo);
            pCfgSistema.load(isCfgSistema);
            //Obtenemos los módulos que el sistema va a poder utilizar
            Consola.enviar("Cargando módulos...");// + cfgSistema.getProperty("modulos"));
            String sModulos[] = pCfgSistema.getProperty("modulos").split(",");
            int n = 0;
            //Verificamos si los módulos existen
            for (String s : sModulos) {
                try {
                    Class c = Class.forName(s);
                    n++;
                    sMod = sMod.concat(s).concat(",");
                } catch (ClassNotFoundException ex) {
                    Consola.enviarErr(Cargador.ERROR_CARGA_MODULO + " (" + s + ")");
                }
            }
            Consola.enviar(n + "/" + sModulos.length + " módulos cargados");
        } catch (IOException ex) {
            Consola.enviarErr(Cargador.ERROR_IO);
        } finally {
            if (isCfgSistema != null) {
                try {
                    hmMetaDatosModulos.put("MODULOS", sMod.substring(0, 
                            sMod.length() - 1));
                    this.hmMetaDatos.put("MODULOS", hmMetaDatosModulos);
                    isCfgSistema.close();
                } catch (IOException e) {
                    Consola.enviarErr(Cargador.ERROR_IO + "(" + e.getMessage() + ")");
                }catch(StringIndexOutOfBoundsException ex){
                    Consola.enviarErr(Cargador.ERROR_HASHMAP + "(" + ex.getMessage() + ")");
                }
            }
        }
    }
    
    public void cargarBD(String sArchivo) {
        Properties pCfgSistema = new Properties();
        InputStream isCfgSistema = null;
        HashMap hmMetaDatosBD = new HashMap();
        String sMod="";
        try {
            //Cargamos el archivo de configuracion
            isCfgSistema = new FileInputStream(sArchivo);
            pCfgSistema.load(isCfgSistema);
            Consola.enviar("Configurando acceso a la Base de Datos");
            hmMetaDatosBD.put("BDSERVIDOR",pCfgSistema.getProperty("servidor"));
            hmMetaDatosBD.put("BDPUERTO",pCfgSistema.getProperty("puerto"));
            hmMetaDatosBD.put("BDDRIVER",pCfgSistema.getProperty("driver"));
            hmMetaDatosBD.put("BDPROTOCOLO",pCfgSistema.getProperty("protocolo"));
            hmMetaDatosBD.put("BDBD",pCfgSistema.getProperty("bd"));
            hmMetaDatosBD.put("BDUSUARIO",pCfgSistema.getProperty("usuario"));
            hmMetaDatosBD.put("BDCLAVE",pCfgSistema.getProperty("clave"));
            BaseDeDatos.inicializar(hmMetaDatosBD);
            if(BaseDeDatos.getInstancia().pruebaDeConexion()){
                Consola.enviar(BaseDeDatos.MENSAJE_CONEXION_TEST_OK);
            }else
            {
                Consola.enviar(BaseDeDatos.MENSAJE_CONEXION_TEST_ERROR);
            }
        } catch (IOException ex) {
            Consola.enviarErr(Cargador.ERROR_IO);
        } finally {
            if (isCfgSistema != null) {
                try {
                    this.hmMetaDatos.put("BD", hmMetaDatosBD);
                    isCfgSistema.close();
                } catch (IOException e) {
                    Consola.enviarErr(Cargador.ERROR_IO);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Cargador cargador =new Cargador();
        cargador.cargarModulos("configuracionPorDefecto.properties");
        cargador.cargarBD("configuracionPorDefecto.properties");
        HashMap md=cargador.getHmMetaDatos();
        Consola.enviar("STOP");
    }

}