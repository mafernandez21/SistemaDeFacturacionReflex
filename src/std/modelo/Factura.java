/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo;

import java.util.ArrayList;
import java.util.Date;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>//@author Martín Alejandro
 */
public class Factura {

    public static final char TIPO_A = 'A';
    public static final char TIPO_B = 'B';
    public static final char TIPO_C = 'C';

    private int id;
    private long numero;
    private char tipo;
    private Date fecha;
    private Cliente cliente; //Cliente.nuevoCliente(0, new Categoria());
    private ArrayList<LineaDeFactura> lineas = new ArrayList();
    private double totalNeto;// = Suma (LineaDeFactura.importeNeto)
    private double totalIVA;//  = Suma (LineaDeFactura.importeIVA)
    private double total;// = Total Neto + Total IVA

    private void inicializar() {
        this.setId(0);
        this.setNumero(0);
        this.setTipo(Factura.TIPO_A);
        this.setFecha(new Date());
        this.setCliente(null);//Cliente.nuevoCliente(0, new Categoria());
        this.setLineas(new ArrayList());
        this.setTotalNeto(0.0);// = Suma (LineaDeFactura.importeNeto)
        this.setTotalIVA(0.0);//  = Suma (LineaDeFactura.importeIVA)
        this.setTotal(0.0);// = Total Neto + Total IVA
    }

    public Factura() {
        this.inicializar();
    }

    public Factura(long numero) {
        this.inicializar();
        this.setNumero(numero);
    }

    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public final void setNumero(long numero) {
        this.numero = numero;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<LineaDeFactura> getLineas() {
        return lineas;
    }

    public void setLineas(ArrayList<LineaDeFactura> lineas) {
        this.lineas = lineas;
    }

    public LineaDeFactura getLinea(int idx) {
        return lineas.get(idx);
    }

    public void setLinea(LineaDeFactura linea) {
        this.lineas.add(linea);
    }

    public double getTotalNeto() {
        return totalNeto;
    }

    public void setTotalNeto(double totalNeto) {
        this.totalNeto = totalNeto;
    }

    public double getTotalIVA() {
        return totalIVA;
    }

    public void setTotalIVA(double totalIVA) {
        this.totalIVA = totalIVA;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Calculadora">    
    
    public void calcularTotalNeto() {
        // TotalNETO = Suma (LineaDeFactura.importeNeto)
        this.totalNeto = 0.0;
        for (LineaDeFactura lf : this.lineas) {
//            this.totalNeto += lf.calcularImporteNeto();
        }
    }

    public void calcularTotalIVA() {
        // TotalIVA = Suma (LineaDeFactura.importeIVA)
        this.totalIVA = 0.0;
        for (LineaDeFactura lf : this.lineas) {
  //          this.totalIVA += lf.calcularImporteIVA();
        }
    }

    public void calcularTotal() {
        // Total = Total Neto + Total IVA
        this.total = 0.0;
    //    this.total = this.calcularTotalNeto()+this.calcularTotalIVA();
    }
    
    //</editor-fold>    
    
    @Override
    public String toString() {
        String out = "";
        out += "Factura" + "\nid=" + id + ", \nnumero=" + numero
                + ", \ntipo=" + tipo + ", \nfecha=" + fecha;
        out += "\n##############################################################";
        out += "\ncliente=" + cliente;
        out += "\n##############################################################";
        for (LineaDeFactura lf : this.lineas) {
            out += lf.toString();
        }
        out += "\n##############################################################";
        out += "\ntotalNeto=" + totalNeto + ", \ttotalIVA=" + totalIVA + ", \ttotal=" + total;
        return out;
    }

    public static void main(String[] args) {

        Factura f = new Factura();
        f.setLinea(new LineaDeFactura());
        System.out.println(f);
    }
}
