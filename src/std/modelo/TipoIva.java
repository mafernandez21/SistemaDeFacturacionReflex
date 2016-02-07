/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>//@author Martín Alejandro
 */
public class TipoIva {

    //Constantes de la Clase
    public static final String IVA_0 = "I.V.A. 0%";
    public static final String IVA_21 = "I.V.A. 21%";
    //Miembros de la Clase
    private int id;
    private String descripcion;
    private double valor; //este valor puede ser 21% o 0%

    //<editor-fold defaultstate="collapsed" desc=" Constructores">   
    public TipoIva() {
        this.setId(0);
        this.setDescripcion(TipoIva.IVA_21);
        this.setValor(0.21); //este valor puede ser 21% o 0%
    }

    public TipoIva(int id, String nombre, double valor) {
        this.id = id;
        this.descripcion = nombre;
        this.valor = valor;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">   
    public int getId() {
        return id;
    }

    public final void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public final void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getValor() {
        return valor;
    }

    public final void setValor(double valor) {
        this.valor = valor;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return "TipoIva{" + "id=" + id + "nombre=" + descripcion + "porcentaje=" + valor + '}';
    }
}
