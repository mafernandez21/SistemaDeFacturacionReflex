/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo.interfaces;

/**
 * Interface para la gestión de los modelos (ABM) y sus datos en la 
 * Base de Datos.
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public interface IGestor {

    /**
     * Modelo DAO (Data Access Object) Objeto de Acceso a Datos para realizar el
     * alta de datos en la Base de Datos.
     * @return Retorna una cadena con el resultado de la operacion
     */
    String alta();

    /**
     * Modelo DAO (Data Access Object) Objeto de Acceso a Datos para realizar la
     * baja de datos en la Base de Datos.
     * @param clave Clave para encontrar el objeto que se quiere eliminar de la
     * Base de Datos
     * @return Retorna una cadena con el resultado de la operacion
     */
    String baja();

    /**
     * Modelo DAO (Data Access Object) Objeto de Acceso a Datos para realizar la
     * modificación/edición de datos en la Base de Datos.
     * @return Retorna una cadena con el resultado de la operacion
     */
    String modificar();
    
//    /**
//     * Modelo de Acceso a Datos para leer datos de la BD
//     *
//     * @param clave Clave para encontrar el objeto que se quiere leer de la
//     * base de datos
//     * @return Un objeto que contiene los datos leidos de la base de datos
//     */
//    Object leer(String clave) throws NullPointerException;
//      
//    /**
//     * Modelo de Acceso a Datos para leer datos de la BD
//     *
//     * @return Un objeto ResultSet que contiene todos los elementos consultados
//     */
//    ResultSet listar();
//
//    /**
//     * Modelo de Acceso a Datos para determinar si existen datos en la BD
//     *
//     * @param clave Clave para encontrar el objeto que se quiere leer de la
//     * base de datos
//     * @return Retorna VERDADERO o FALSO según si se encuentran datos o no
//     */
//    boolean existe(String clave);
    
}
