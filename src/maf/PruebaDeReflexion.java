/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package maf;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import reflex.anotaciones.CampoPersistente;
import reflex.core.Cargador;
import reflex.interfaces.IReflex;
import reflex.vista.Consola;
import std.modelo.Persona;
import std.modelo.bd.BaseDeDatos;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class PruebaDeReflexion {

    public static void main(String[] args) {

        Cargador loader = new Cargador();
        loader.cargarBD("configuracionPorDefecto.properties");
        BaseDeDatos.inicializar(loader.getHmMetaDatos());

        PruebaDeReflexion pr = new PruebaDeReflexion();

//        pr.ControladorReflexAlta("modelo.ClienteReflex");
//        pr.ControladorReflexAlta("modelo.Cliente");
//        pr.extraerMetaDatosDeClase(modelo.Persona.class);
//        pr.extraerMetaDatosDeClase(modelo.Categoria.class);
//        pr.test4(new Cliente().getClass());
//        pr.test4(new Categoria().getClass());
        //pr.test2();
        //pr.test1();
    }

    public void test5(Class c) {
        String tabla = c.getSimpleName().toLowerCase();
        String campos = "";
        String valores = "";
        String consulta = "";
        boolean primero = true;

        Field[] nombresCampos = c.getDeclaredFields();

        for (int i = 0; i < nombresCampos.length; i++) {
            nombresCampos[i].setAccessible(true);
            Annotation anotacion = nombresCampos[i].getAnnotation(CampoPersistente.class);
            if (anotacion != null) {
                if (primero) {
                    campos += (nombresCampos[i].getName());
                    valores += "?";
                    primero = false;
                } else {
                    campos += ("," + nombresCampos[i].getName());
                    valores += ",?";
                }
            }
        }
        consulta = "INSERT INTO '" + tabla + "' (" + campos + ") values (" + valores + ")";
        Consola.enviar(consulta);
    }

    public void ControladorReflexAlta(String sModelo) {
        try {
            //Creo la clase apartir de su nombre
            Class cModelo = Class.forName(sModelo);
            //Uso la interface de Acceso y creo un nuevo Objeto
            IReflex c = (IReflex) cModelo.getConstructor().newInstance();

            HashMap hmMetaDatos = new HashMap();
            //Inicializo el Objeto
            c.inicializar();

            hmMetaDatos.put("IDCLIENTE", 0);
            hmMetaDatos.put("NOMBRE", "Martin");
            hmMetaDatos.put("APELLIDO", "Fernandez");
            hmMetaDatos.put("DNI", "29729479");
            hmMetaDatos.put("DIRECCION", "Aqui");
            hmMetaDatos.put("TELEFONO", "Samsung");
            hmMetaDatos.put("CUIT", "Te debo");
            hmMetaDatos.put("IDCATEGORIA", 2);

            //Seteo los datos
            c.setDatos(hmMetaDatos);

            Consola.enviar(c);

            //BaseDeDatos.getInstancia().insert(c);
        } catch (ClassCastException | ClassNotFoundException | NoSuchMethodException |
                SecurityException | InstantiationException | IllegalAccessException |
                IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void test4(Class cModelo) {
        Consola.enviar(cModelo.getSimpleName());
        try {
            Persona p = new Persona();
            p.getClass();
            Class[] iface = cModelo.getInterfaces();
            Method m = cModelo.getMethod("getClave");
            if (iface.length != 0) {
                Consola.enviar("Interfaces detectadas : " + iface.length);
                for (Class c : iface) {
                    Consola.enviar("\t" + c.getSimpleName());
                }
            }
            Consola.enviar(m.getName());
            m.setAccessible(true);
            Object ret = m.invoke(null);
            Consola.enviar(String.valueOf(ret));

        } catch (NoSuchMethodException ex) {
            Consola.enviar("Metodo no encontrado");
        } catch (SecurityException ex) {
            Consola.enviar("Metodo no encontrado");
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void test3(Class cModelo) {
        cModelo.getSuperclass();

        String tabla = cModelo.getSimpleName().toLowerCase();
        String campos = "";
        String valores = "";
        String consulta = "";
        boolean primero = true;

        Field[] nombresCampos = cModelo.getDeclaredFields();

        for (int i = 0; i < nombresCampos.length; i++) {
            nombresCampos[i].setAccessible(true);
            Annotation anotacion = nombresCampos[i].getAnnotation(CampoPersistente.class);
            if (anotacion != null) {
                if (primero) {
                    campos += (nombresCampos[i].getName());
                    valores += "?";
                    primero = false;
                } else {
                    campos += ("," + nombresCampos[i].getName());
                    valores += ",?";
                }
            }
        }
        consulta = "INSERT INTO '" + tabla + "' (" + campos + ") values (" + valores + ")";
        Consola.enviar(consulta);
    }

    public void test2() {
        Cargador Loader = new Cargador();

        Loader.cargarModulos("configuracionPorDefecto.properties");

        HashMap hmMetaDatos = (HashMap) Loader.getHmMetaDatos().get("MODULOS");

        String[] modulos = String.valueOf(hmMetaDatos.get("MODULOS")).split(",");

        try {
            Class clase = Class.forName(modulos[0]);

            Consola.enviar(clase.getSimpleName());

            Constructor[] constructores = clase.getDeclaredConstructors();

            for (Constructor c : constructores) {
                Consola.enviar(c.getName());
                for (Class t : c.getParameterTypes()) {
                    Consola.enviar(t.getSimpleName());
                }
            }

//            Consola.enviar(clase.getApellido());
//            Field[] campos = clase.getDeclaredFields();
//
//
//                for (Field f : campos) {
//                    Consola.enviar("\t" + f.getName());
//                    Consola.enviar("\t" + f.getModifiers());
//                }
            //PersonaSimple ps=(Persona)c.cast(c);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
        }
//        catch (InstantiationException ex) {
//            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void test1() {
        Cargador Loader = new Cargador();

        Loader.cargarModulos("configuracionPorDefecto.properties");

        HashMap hmMetaDatos = (HashMap) Loader.getHmMetaDatos().get("MODULOS");

        String[] modulos = String.valueOf(hmMetaDatos.get("MODULOS")).split(",");

        try {
            Class clase;

            for (String s : modulos) {

                clase = Class.forName(s);

                Consola.enviar(clase.getSimpleName());

                Field[] campos = clase.getDeclaredFields();

                for (Field f : campos) {
                    Consola.enviar("\t" + f.getName());
                    Consola.enviar("\t" + f.getModifiers());
                }
            }
            //PersonaSimple ps=(Persona)c.cast(c);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaDeReflexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //////////////////////////////////////////////////7
}
