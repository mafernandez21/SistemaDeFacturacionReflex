/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo;

import reflex.anotaciones.CampoPersistente;
import std.modelo.interfaces.IDao;

/**
 * Clase que modela la CategoriaReflex Impositiva del {@link std.modelo.Cliente} frente a 
 * AFIP
 * <ul>
 * <li>Consumidor Final - No Discrimina - Factura Tipo B.</li>
 * <li>Exento o No Responsable - No Discrimina - Factura Tipo B.</li>
 * <li>Responsable inscripto - Discimina - Factura Tipo A.</li>
 * </ul>
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class CategoriaReflex implements IDao {

    //Constantes de la Clase
    public static final String IVA_EXCENTO = "IVA - Excento";
    public static final String IVA_RESPONSABLE_INSCRIPTO = "IVA - Responsable Inscripto";
    public static final String IVA_CONSUMIDOR_FINAL = "IVA - Consumidor Final";
    public static final int IVA_DISCRIMINA = 1;
    public static final int IVA_NO_DISCRIMINA = 0;

    //Miembros de la Clase
    @CampoPersistente
    private int idCategoria;
    @CampoPersistente
    private String descripcion;
    @CampoPersistente
    private int discrimina; //0 o 1 es equivalente a NO y SI se lo declara como entero para ayudar en el calculo

    //<editor-fold defaultstate="collapsed" desc=" Constructores">   
    private void inicializar(String sDescripcion) {
        this.idCategoria = 0;
        switch (sDescripcion) {
            case CategoriaReflex.IVA_CONSUMIDOR_FINAL:
                this.descripcion = CategoriaReflex.IVA_CONSUMIDOR_FINAL;
                this.discrimina = CategoriaReflex.IVA_NO_DISCRIMINA;
                break;
            case CategoriaReflex.IVA_EXCENTO:
                this.descripcion = CategoriaReflex.IVA_EXCENTO;
                this.discrimina = CategoriaReflex.IVA_NO_DISCRIMINA;
                break;
            case CategoriaReflex.IVA_RESPONSABLE_INSCRIPTO:
                this.descripcion = CategoriaReflex.IVA_RESPONSABLE_INSCRIPTO;
                this.discrimina = CategoriaReflex.IVA_DISCRIMINA;
                break;
            default:
                this.descripcion = CategoriaReflex.IVA_CONSUMIDOR_FINAL;
                this.discrimina = CategoriaReflex.IVA_NO_DISCRIMINA;
                break;
        }
    }

    public CategoriaReflex() {
        this.inicializar(CategoriaReflex.IVA_CONSUMIDOR_FINAL);
    }

    public CategoriaReflex(String sDescripcion) {
        this.inicializar(sDescripcion);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">       

    public int getDiscrimina() {
        return discrimina;
    }

    public void setDiscrimina(int discrimina) {
        this.discrimina = discrimina;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return this.descripcion;
    }

    @Override
    public String getClave() {
        return String.valueOf(this.getIdCategoria());
    }
}
