/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package maf;

/*
 * Descripcion ...
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="http://www.MartinAlejandroFernandez.com">Página Web
 * Proximamente...</a>//@author Martín Alejandro
 */
public class Domicilio {
    private int idDomicilio;
    private int idPersona;
    private String calle;
    private int numero;
    private int piso;
    private int departamento;
    private String localidad;
    private String provincia;
    private String pais;

    private void inicializar (){
        this.calle = "";
        this.numero = 0;
        this.piso = 0;
        this.departamento = 0;
        this.localidad = "San Miguel de Tucumán";
        this.provincia = "Tucumán";
        this.pais = "Argentina";
    }
    
    public Domicilio() {
        this.inicializar();
    }

    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">
    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", departamento=" + departamento + ", localidad=" + localidad + ", provincial=" + provincia + ", pais=" + pais + '}';
    }
    //</editor-fold>
    
}
