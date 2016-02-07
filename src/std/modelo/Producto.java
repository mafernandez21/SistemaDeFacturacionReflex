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
public class Producto {

    //Miembros de la Clase
    private int id;
    private String descripcion;
    private double precio;
    private int stock;
    private TipoIva iva;

    public final void inicializar() {
        this.id = 0;
        this.descripcion = "Sin Descripcion";
        this.precio = 0.0;
        this.stock = 0;
        this.iva = new TipoIva();
    }

    //<editor-fold defaultstate="collapsed" desc=" Constructores">   
    public Producto() {
        this.inicializar();
    }

    public Producto(int id, String descripcion, double precio, int stock) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

//</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">  
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoIva getIva() {
        return iva;
    }

    public void setIva(TipoIva iva) {
        this.iva = iva;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

//</editor-fold>
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + ", iva=" + iva + '}';
    }

}
