/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */

package std.modelo.bd;
/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>
 */
public class Conexion {
//    private String host="";
//    private String usuario="";
//    private String clave = "";
//    private String motor="";
//    private String bd="";
//    private Connection conexion=null;
//    private String driver="";
//    private boolean conectado=false;
//
//    public void inicializar(){
//        this.usuario = "root";
//        this.clave = "german";
//        this.motor = "mysql";
//        this.bd = "prueba";
//        this.driver = "com.mysql.jdbc.Driver";
//        this.host = "localhost";
//    }
//    
//    public Conexion() {
//        this.inicializar();
//    }
//
//    public void conectar() {
//        String sCadenaConexion = "jdbc:" + this.motor + "://" + host + "/" + bd;
//        try {
//            Class.forName(this.driver);
//            conexion = DriverManager.getConnection(sCadenaConexion, usuario, clave);
//            conectado = true;
//            conexion.setAutoCommit(false);
//        } catch (ClassNotFoundException ex) {
//            Consola.enviar("Cadena de Conexion=" + sCadenaConexion);
//            Consola.enviar(ex.getMessage());
//        } catch (SQLException f) {
//            Consola.enviar(f.getMessage());
//        }
//    }
//
//    public Conexion(String usuario, String motor, String bd, Connection conexion, String driver) {
//        this.usuario = usuario;
//        this.motor = motor;
//        this.bd = bd;
//        this.conexion = conexion;
//        this.driver = driver;
//    }
//
//    public String getClave() {
//        return clave;
//    }
//
//    public void setClave(String clave) {
//        this.clave = clave;
//    }
//
//    public Connection getConexion() {
//        return conexion;
//    }
//
//    public void setConexion(Connection conexion) {
//        this.conexion = conexion;
//    }
//
//    public String getDb() {
//        return db;
//    }
//
//    public void setDb(String db) {
//        this.db = db;
//    }
//
//    public String getDriver() {
//        return driver;
//    }
//
//    public void setDriver(String driver) {
//        this.driver = driver;
//    }
//
//    public String getHost() {
//        return host;
//    }
//
//    public void setHost(String host) {
//        this.host = host;
//    }
//
//    public String getMotor() {
//        return motor;
//    }
//
//    public void setMotor(String motor) {
//        this.motor = motor;
//    }
//
//    public String getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }
//
//    public boolean isConectado() {
//        return conectado;
//    }
//
//    public ResultSet ejecutarConResult(String consulta) {
//        ResultSet rs = null;
//        try {
//            rs = conexion.createStatement().executeQuery(consulta);
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rs;
//    }

}