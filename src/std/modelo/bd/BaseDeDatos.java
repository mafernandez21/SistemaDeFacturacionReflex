/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo.bd;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JTable;
import reflex.vista.Consola;

/*
 * Clase que permite abrirConexion con la base de datos
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>//@author Martín Alejandro
 */
public class BaseDeDatos {

    public static final String MENSAJE_CONEXION_TEST_OK = "Prueba de conexión"
            + " OK";

    public static final String MENSAJE_CONEXION_TEST_ERROR = "Prueba de conexión"
            + " Falló";

    public static final String MENSAJE_CONEXION_OK = "La conexión a la Base de "
            + "Datos se realizó correctamente";

    public static final String MENSAJE_CONEXION_ERROR = "Hubo un error en la "
            + "conexión a la Base de Datos";

    public static final String MENSAJE_CONEXION_CERRADA_OK = "La conexión a la "
            + "Base de Datos fué cerrada";

    public static final String MENSAJE_CONEXION_CERRADA_ERROR = "La conexión "
            + "se cerró de forma inesperada";

    public static final String MENSAJE_DRIVER_ERROR = "Hubo un error en el "
            + "driver";

    public static final String MENSAJE_INSERT_ERROR = "Hubo un error en el "
            + "procedimiento INSERT";

    public static final String MENSAJE_DELETE_ERROR = "Hubo un error en el "
            + "procedimiento DELETE";

    public static final String MENSAJE_UPDATE_ERROR = "Hubo un error en el "
            + "procedimiento UPDATE";

    public static final String MENSAJE_QUERY_ERROR = "Hubo un error al "
            + "ejecutar la consulta";

    private static BaseDeDatos instancia = null;

    private Connection conexion = null;
    private String servidor;
    private String puerto;
    private String driver;
    private String protocolo;
    private String bd;
    private String usuario;
    private String clave;

    /**
     * Este método crear un acceso a la Base de Datos. Usa el patron de diseño
     * Singleton por eso es un método estático y utiliza la variable estática
     * "instancia" y un constructor privado.
     *
     * @param hmMetaDatos Un HashMap que posee los datos de conexión (servidor,
     * protocolo, usuario, contraseña, etc)
     * @return Retorna una única instancia de la Base de Datos
     */
    public static BaseDeDatos inicializar(HashMap hmMetaDatos) {
        if (instancia == null) {
            instancia = new BaseDeDatos(hmMetaDatos);
        }
        return instancia;
    }

    private BaseDeDatos() {
    }

    private BaseDeDatos(HashMap hmMetaDatos) {
        this.setServidor(String.valueOf(hmMetaDatos.get("BDSERVIDOR")));
        this.setPuerto(String.valueOf(hmMetaDatos.get("BDPUERTO")));
        this.setDriver(String.valueOf(hmMetaDatos.get("BDDRIVER")));
        this.setProtocolo(String.valueOf(hmMetaDatos.get("BDPROTOCOLO")));
        this.setBd(String.valueOf(hmMetaDatos.get("BDBD")));
        this.setUsuario(String.valueOf(hmMetaDatos.get("BDUSUARIO")));
        this.setClave(String.valueOf(hmMetaDatos.get("BDCLAVE")));
    }

    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">
    public String getClave() {
        return clave;
    }

    public final void setClave(String clave) {
        this.clave = clave;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getBd() {
        return bd;
    }

    public final void setBd(String bd) {
        this.bd = bd;
    }

    public String getDriver() {
        return driver;
    }

    public final void setDriver(String driver) {
        this.driver = driver;
    }

    public String getServidor() {
        return servidor;
    }

    public final void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public final void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public String getUsuario() {
        return usuario;
    }

    public final void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPuerto() {
        return puerto;
    }

    public final void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public static BaseDeDatos getInstancia() throws NullPointerException {
        return instancia;
    }
//</editor-fold>

    /**
     * Este método abre una conexión y luego la cierra para ejecutar una prueba
     * de conexión contra la Base de Datos.
     *
     * @return VERDADERO si durante la prueba no hubo errores, sino devuelve
     * FALSO
     */
    public boolean pruebaDeConexion() {
        boolean bAbrir = false;
        boolean bCerrar = false;
        Consola.desactivar();
        if (this.abrirConexion() != null) {
            bAbrir = true;
        }
        if (this.cerrarConexion() == null) {
            bCerrar = true;
        }
        Consola.activar();
        return bAbrir && bCerrar;
    }

    /**
     * Este método abre una conexión a la Base de Datos.
     *
     * @return La conexión a la Base de Datos.
     */
    private Connection abrirConexion() {
        //Se crea una cadena de coneccion con los PreparedStatement activados
        String cadenaDeConexion = this.protocolo + "://" + this.servidor + ":"
                + this.puerto + "/" + this.bd + "?useServerPrepStmts=true";
        try {
            //Obtenemos el driver de la base de datos
            Class.forName(this.driver);
            //Establecemos la conexión
            this.conexion = DriverManager.getConnection(cadenaDeConexion,
                    this.getUsuario(), this.getClave());
            if (this.conexion != null) {
                Consola.enviar(BaseDeDatos.MENSAJE_CONEXION_OK);
            }
        } catch (SQLException e) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_CONEXION_ERROR + " -> "
                    + e.getMessage());
            System.exit(0);
        } catch (ClassNotFoundException e) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_DRIVER_ERROR + " -> "
                    + e.getMessage());
            System.exit(0);
        }
        return conexion;
    }

    private Connection cerrarConexion() {
        try {
            this.conexion.close();
            this.conexion = null;
            if (this.conexion == null) {
                Consola.enviar(BaseDeDatos.MENSAJE_CONEXION_CERRADA_OK);
            }
        } catch (SQLException e) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_CONEXION_ERROR + " -> "
                    + e.getMessage());
        } catch (NullPointerException e) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_CONEXION_CERRADA_ERROR + " -> "
                    + e.getMessage());
        }
        return conexion;
    }

    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    private void prepararSentencia(Object obj, PreparedStatement Sentencia, Field[] sCampos) {
//        switch (tipoCampo) {
//            case "int":
//                Sentencia.setInt(i, campo.getInt(obj));
//                //      Consola.enviar(campo.getInt(obj));
//                break;
//            case "String":
//                Sentencia.setString(i, campo.get(obj).toString());
//                //    Consola.enviar(campo.get(obj).toString());
//                break;
//            case "Date":
//                Sentencia.setDate(i, (Date) campo.get(obj));
//                //    Consola.enviar(campo.get(obj).toString());
//                break;
//
//            default:
//                throw new UnsupportedOperationException("Tipo (" + campo.getType().getSimpleName() + ") no implementado");
//
//        }
    }

    public String insert(Object obj) {
        String sOut = "", sParametros = "", sConsulta;
        PreparedStatement Sentencia;
        try {
            Class cModelo = Class.forName(obj.getClass().getName());
            Field[] cCampos = cModelo.getDeclaredFields();
            Field campo;
            String tabla = cModelo.getSimpleName().toLowerCase();

            for (int i = 1; i < cCampos.length; i++) {
                campo = cCampos[i];
                campo.setAccessible(true);
                if (i == 1) {
                    sParametros += "?";
                } else {
                    sParametros += ",?";
                }
            }

            sConsulta = "CALL sp_" + tabla + "_alta(" + sParametros + ");";

            Sentencia = this.conexion.prepareStatement(sConsulta);

            this.prepararSentencia(obj, Sentencia, cCampos);

            Sentencia.executeUpdate();

            ResultSet rs = Sentencia.getResultSet();

            if (rs.next()) {
                sOut = rs.getString(1);

            }

        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | SecurityException ex) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_INSERT_ERROR + " -> "
                    + ex.getMessage());
        }

        return sOut;
    }

    public String update(Object obj) {
        String sOut = "", sParametros = "", sConsulta;
        PreparedStatement Sentencia;
        try {
            Class cModelo = Class.forName(obj.getClass().getName());
            Field[] cCampos = cModelo.getDeclaredFields();
            Field campo;
            String tabla = cModelo.getSimpleName().toLowerCase();

            for (int i = 1; i < cCampos.length; i++) {
                campo = cCampos[i];
                campo.setAccessible(true);
                if (i == 1) {
                    sParametros += "?";
                } else {
                    sParametros += ",?";
                }
            }

            sConsulta = "CALL sp_" + tabla + "_modificar(" + sParametros + ");";

            Sentencia = this.conexion.prepareStatement(sConsulta);

            this.prepararSentencia(obj, Sentencia, cCampos);

            Sentencia.executeUpdate();

            ResultSet rs = Sentencia.getResultSet();

            if (rs.next()) {
                sOut = rs.getString(1);
            }

        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | SecurityException ex) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_UPDATE_ERROR + " -> "
                    + ex.getMessage());
        }

        return sOut;
    }

    public String delete(Object obj) {
        String sOut = "", sConsulta;
        PreparedStatement Sentencia;
        try {
            Class cModelo = Class.forName(obj.getClass().getName());
            String tabla = cModelo.getSimpleName().toLowerCase();

            sConsulta = "CALL sp_" + tabla + "_baja(?);";

            Sentencia = this.conexion.prepareStatement(sConsulta);

            Sentencia.setString(1, clave);

            Sentencia.executeQuery();

            ResultSet rs = Sentencia.getResultSet();

            if (rs.next()) {
                sOut = rs.getString(1);
            }

        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | SecurityException ex) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_DELETE_ERROR + " -> "
                    + ex.getMessage());
        }

        return sOut;
    }

    public Object select(Object obj) {
        String sConsulta = "";
        PreparedStatement Sentencia;
        try {
            Class cModelo = Class.forName(obj.getClass().getName());
            Field[] cCampos = cModelo.getDeclaredFields();

            String tabla = cModelo.getSimpleName().toLowerCase();

            sConsulta = "CALL sp_" + tabla + "_selectClave(?);";

            Sentencia = this.conexion.prepareStatement(sConsulta);

            Sentencia.setString(1, clave);

            Sentencia.executeQuery();

            ResultSet rs = Sentencia.getResultSet();
            while (rs.next()) {
                for (int i = 0; i < cCampos.length; i++) {
                    cCampos[i].setAccessible(true);
                    switch (cCampos[i].getType().getSimpleName()) {
                        case "int":
                            cCampos[i].setInt(obj, rs.getInt(i + 1));
                            break;
                        case "String":
                            cCampos[i].set(obj, String.valueOf(rs.getObject(i + 1)));
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (ClassNotFoundException | IllegalArgumentException | SQLException | SecurityException | IllegalAccessException ex) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_QUERY_ERROR + " -> "
                    + ex.getMessage());
        }
        return obj;
    }

    public ResultSet selectAll(Object obj) {
        String sConsulta;
        ResultSet rs = null;
        PreparedStatement Sentencia;
        try {
            Class cModelo = Class.forName(obj.getClass().getName());
            String tabla = cModelo.getSimpleName().toLowerCase();
            sConsulta = "CALL sp_" + tabla + "_selectAll;";

            Sentencia = this.conexion.prepareStatement(sConsulta);

            Sentencia.executeQuery();

            rs = Sentencia.getResultSet();

        } catch (SQLException | ClassNotFoundException ex) {
            Consola.enviarErr(BaseDeDatos.MENSAJE_QUERY_ERROR + " -> "
                    + ex.getMessage());
        }
        return rs;
    }

    public static void main(String[] args) {
//        BaseDeDatos c = BaseDeDatos.inicializar();
//        c.abrirConexion();
////        co = c.cerrarConexion();
////        Consola.enviar(c.insert(Persona.crear("Martín", "Fernández", "29729479", "Av. Mitre 117", "381-6274324")));
////        Consola.enviar(c.insert(Persona.crear("Alejandro", "Fernández", "20729479", "Av. Mitre 117", "381-6274324")));
////        Consola.enviar(c.insert(Persona.crear("Sergio", "Fernández", "35729479", "Av. Mitre 117", "381-6274324")));
////        Consola.enviar(c.insert(Persona.crear("Sergio", "Fernández", "36729479", "Av. Mitre 117", "381-6274324")));
//        ResultSet rs = c.selectAll(Persona.crear());
//        JFrame f = new JFrame();
//        JScrollPane panelScroll = new JScrollPane(c.setTablaResultSet(rs));
//        panelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        panelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//
//        f.add(panelScroll);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //f.pack();
//        f.setVisible(true);
//        c.cerrarConexion();

    }

    private JTable setTablaResultSet(ResultSet rs) {
//        DefaultTableModel modeloRs = new DefaultTableModel();
//        JTable tablaRs = new JTable(modeloRs);
//
//        try {
//            ResultSetMetaData metaDatos = rs.getMetaData();
//            // Se obtiene el número de columnas.
//            int nColumnas = metaDatos.getColumnCount();
//            // Se crea un array de etiquetas para rellenar
//            Object[] oNombreColumnas = new Object[nColumnas];
//            // Se obtiene cada una de las etiquetas para cada columna
//            for (int i = 0; i < nColumnas; i++) {
//                oNombreColumnas[i] = metaDatos.getColumnLabel(i + 1);
//                //modeloRs.addColumn(oNombreColumnas[i]);
//            }
//            //Asigno los nombres a las columnas del modelo
//            modeloRs.setColumnIdentifiers(oNombreColumnas);
//
//            //Cargo los datos del ResultSet
//            while (rs.next()) {
//                Object[] oFila = new Object[nColumnas];
//                for (int i = 0; i < nColumnas; i++) {
//                    oFila[i] = rs.getObject(i + 1);
//                }
//                modeloRs.addRow(oFila);
//
//            }
//            //Asigno los datos a la tabla
//            tablaRs.setModel(modeloRs);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(BaseDeDatos.class
//                    .getName()).log(Level.SEVERE, null, ex);
//        }
        //return tablaRs;
        return null;
    }
}
