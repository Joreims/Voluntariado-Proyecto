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
    private int actividadID;
    private String fecha;
    private float hora;
    private String descripcion;
    private boolean estado;

    public Actividades() {
    }

    public Actividades(int actividadID, String fecha, float hora, String descripcion, boolean estado) {
        this.actividadID = actividadID;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getActividadID() {
        return actividadID;
    }

    public void setActividadID(int actividadID) {
        this.actividadID = actividadID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getHora() {
        return hora;
    }

    public void setHora(float hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
