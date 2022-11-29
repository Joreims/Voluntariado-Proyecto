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

    public Voluntario() {
    }
    
    public Voluntario(int id, String nombres, String apellidos, String cedula, String fechaNac,String email){
        super(nombres, apellidos, cedula, fechaNac,email);
        this.id = id;
    }
   
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}