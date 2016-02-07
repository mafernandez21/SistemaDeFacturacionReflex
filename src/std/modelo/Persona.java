/*
 * Este proyecto pertenece a Martín Alejandro Fernández.
 * Cualquier edición del siguiente archivo, sin autorización
 * no esta permitida.
 */
package std.modelo;

import reflex.anotaciones.CampoPersistente;

/**
 * Clase que modela una persona común
 *
 * @author Martín Alejandro Fernández
 * @version 1.0
 * @see <a href="mailto://mafernandez21@hotmail.com">Contacto</a>
 */
public class Persona {
    @CampoPersistente
    private int idPersona;
    @CampoPersistente
    private String dni;
    @CampoPersistente
    private String apellido;
    @CampoPersistente
    private String nombre; //o razon social
    @CampoPersistente
    private String direccion;
    @CampoPersistente
    private String telefono;

    //<editor-fold defaultstate="collapsed" desc=" Constructores">    
    private void inicializar() {
        this.idPersona = 0;
        this.nombre = "Sin Nombre";
        this.apellido = "Sin Apellido";
        this.dni = "00000000";
        this.direccion = "Sin Dirección";
        this.telefono = "0000-000000";
    }

    public Persona() {
        this.inicializar();
    }

    public Persona(String nombre, String apellido, String dni, String direccion, String telefono) {
        this.inicializar();
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDni(dni);
        this.setDireccion(direccion);
        this.setTelefono(telefono);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc=" Getters and Setters">
    public int getIdPersona() {
        return this.idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDni() {
        return this.dni;
    }

    public final void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return this.apellido;
    }

    public final void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return this.nombre;
    }

    public final void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public final void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public final void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return ("Nombre=" + this.getNombre() + "\nApellido=" + this.getApellido() + "\nDNI=" + this.getDni() + "\nDomicilio=" + this.getDireccion()).toUpperCase();
    }

    //</editor-fold>
    



    public static void main(String[] args) {
//        BaseDeDatos b = BaseDeDatos.instancia();
//        Persona p1, p2, p3;
//        p1 = Persona.crear("Martin", "Fernandez", "29729479", "Av.Mitre 117, San Miguel de Tucumán", "381-6274324");
//        p1.alta();
//        p2 = Persona.crear("Emilia", "Salomon", "25279796", "Av.Mitre 117, San Miguel de Tucumán", "381-4164190");
//        p2.alta();
//        p1.setNombre("Alejandro");
//        p1.modificar();
//        p3 = Persona.buscar("29729479");
//        System.out.println(p3);
//        p3 = Persona.buscar("25279796");
//        System.out.println(p3);
//        if (Persona.eliminar("38729479").contains("OK")) {
//            p1 = null;
//        }
//        if (Persona.eliminar(p1.getDni()).contains("OK")) {
//            p1 = null;
//        }
//        try {
//            p1.baja(p1.getDni());
//            p2.baja(p2.getDni());
//        } catch (NullPointerException e) {
//        }
    }
}
