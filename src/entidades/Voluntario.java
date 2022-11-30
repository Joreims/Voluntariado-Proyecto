/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author jegar
 */
public class Voluntario extends Persona{
    private int id;
    private String voluntariado;

    public Voluntario(int id, String voluntariado, String string1, String string2, String string3, String string4) {
        this.id = id;
        this.voluntariado = voluntariado;
    }

    public Voluntario(int id, String voluntariado, String nombres, String apellidos, String cedula, String fechaNac, String email) {
        super(nombres, apellidos, cedula, fechaNac, email);
        this.id = id;
        this.voluntariado = voluntariado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getVoluntariado() {
        return voluntariado;
    }

    public void setVoluntariado(String voluntariado) {
        this.voluntariado = voluntariado;
    }
    
}