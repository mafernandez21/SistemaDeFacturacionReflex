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
 * Proximamente...</a>
 */
public class LineaDeFactura {
    private int cantidad;
    private Producto producto;
    private double importeUnitario; // = producto.precio
//    private double importeNeto; // = cantidad * ImporteUnitario
//    private double importeIVA; // = discrimina * ImporteNeto * %iva
//    private double importeTotal; //= ImporteNeto + ImporteIVA

    public void inicializar() {
        this.producto = new Producto();
        this.cantidad = 1;
        this.importeUnitario = 0.0; // = producto.precio
//        this.importeNeto = 0.0; // = cantidad * ImporteUnitario
//        this.importeIVA = 0.0; // = discrimina * ImporteNeto * %iva
//        this.importeTotal = 0.0; //= ImporteNeto + ImporteIVA
    }

    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">   

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getImporteUnitario() {
        this.producto.getPrecio();
        return importeUnitario;
    }

    public void setImporteUnitario(double importeUnitario) {
        this.importeUnitario = importeUnitario;
    }
        
    //</editor-fold>
   
//    @Override
//    public String toString() {
//        return "\n" + this.cantidad + " \t|\t " + this.descripcionProducto
//                + " \t|\t " + this.importeUnitario
//                + " \t|\t " + this.importeNeto
//                + " \t|\t " + this.importeIVA + " \t|\t " + importeTotal;
//    }

    public static void main(String[] args) {
        LineaDeFactura lf = new LineaDeFactura();

        System.out.println(lf);
    }

}
