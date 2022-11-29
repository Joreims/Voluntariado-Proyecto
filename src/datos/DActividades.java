/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manza
 */
public class DActividades {
    //Atributos
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //Metodos
    public void obtRegistros(){
        try{
            conn = Conexion.getConnection();
            String tSQL = "Select * from Actividades";
            ps = conn.prepareStatement(tSQL, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE,
                   ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }catch (SQLException ex){
            System.out.println("Error al obtener registros " + ex.getMessage());
        }
    }
    public ArrayList<Actividades> listarActividades(){
        ArrayList<Actividades> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Actividades(
                        rs.getString("Fecha"),
                        rs.getString("Hora"),
                        rs.getString("Descripcion")
                ) {});
            }
        }catch (SQLException ex){
            System.out.println("Error al listar actividad " + ex.getMessage());
        }finally{
            try{
                if (rs !=null){
                      rs.close();
                }
                if (ps !=null){
                      ps.close();
                }
                if (conn !=null){
                      Conexion.closeConexion(conn);
                }
             
            }catch (SQLException ex){
            System.out.println(ex.getMessage());
            }
        }
        return lista;
    }
    
    public boolean guardarActividades(Actividades a){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("Fecha", a.getFecha());
            rs.updateString("Hora", a.getHora());
            rs.updateString("Descripcion", a.getDescripcion());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        }catch(SQLException ex){
            System.out.println("Error al guardar la actividad:" + ex.getMessage());
        }finally{
            try{
                if (rs !=null){
                      rs.close();
                }
                if (ps !=null){
                      ps.close();
                }
                if (conn !=null){
                      Conexion.closeConexion(conn);
                }
             
            }catch (SQLException ex){
            System.out.println(ex.getMessage());
            }
        }
        return guardado;
}
    public boolean existeActividades(String id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while (rs.next()){
                if (rs.getString("ActividadID").equals(id)){
                    resp = true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar actividad"+ ex.getMessage());
        }
        finally{
            try{
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    rs.close();
                }
                
                if(conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resp;
    }
    
    public boolean editarActividades(Actividades a){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("ActividadID").equals(a.getActividadID())){
                    rs.updateString("Fecha", a.getFecha());
                    rs.updateString("Hora", a.getHora());
                    rs.updateString("Descripcion", a.getDescripcion());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch(SQLException ex){
            System.out.println("Error al editar actividad"+ ex.getMessage());
        }
        
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (ps != null) {
                    rs.close();
                }
                
                if (conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resp;
    }
    
    public boolean eliminarActividades(String id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("ActividadID").equals(id)){
                    rs.deleteRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al eliminar actividad"+ ex.getMessage());
        }
        finally{
            try {
                if (rs != null) {
                    rs.close();
                }
                
                if (ps != null) {
                    rs.close();
                }
                
                if (conn != null) {
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return resp;
    }
}
