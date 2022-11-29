/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author abiga
 */
public class Voluntariado {
    private String nombre;
    private String tipo;

    public Voluntariado() {
    }

    public Voluntariado(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Voluntariado(int i, String text, String text0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Voluntariado{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
    
    
}
