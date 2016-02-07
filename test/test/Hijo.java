/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author Paradigmas
 */
public class Hijo extends Padre{
    private String apodo;

    public Hijo(String nombre, String apodo) {
        super(nombre);
        this.apodo=apodo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    @Override
    public String toString() {
        return "Hijo de " + super.getNombre() + "es {" + "apodo=" + apodo + '}';
    }

}
