/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author manza
 */
public class Actividades {
    private String actividadID;
    private String fecha;
    private String hora;
    private String descripcion;

    public Actividades() {
    }

    public Actividades(String actividadID, String fecha, String hora, String descripcion) {
        this.actividadID = actividadID;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public Actividades(int i, String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getActividadID() {
        return actividadID;
    }

    public void setActividadID(String actividadID) {
        this.actividadID = actividadID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
