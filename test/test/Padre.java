/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 *
 * @author Paradigmas
 */
public class Padre {
    private String nombre;

    public Padre (){
        this.nombre="Sin Nombre";
    }

    public Padre (String nombre){
        this.nombre=nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Padre{" + "nombre=" + nombre + '}';
    }


    public static void main(String[] args){
        Padre p=new Padre("Wolf");
        Hijo h=new Hijo("Wolfito", "Pechito");
    }
}
