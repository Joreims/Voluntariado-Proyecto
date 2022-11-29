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
    private int VoluntarioID;

    public Voluntario(int VoluntarioID) {
        this.VoluntarioID = VoluntarioID;
    }

    public Voluntario(int VoluntarioID, String nombres, String apellidos, String cedula, String fechaNac, String email) {
        super(nombres, apellidos, cedula, fechaNac, email);
        this.VoluntarioID = VoluntarioID;
    }

    public int getVoluntarioID() {
        return VoluntarioID;
    }

    public void setVoluntarioID(int VoluntarioID) {
        this.VoluntarioID = VoluntarioID;
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}