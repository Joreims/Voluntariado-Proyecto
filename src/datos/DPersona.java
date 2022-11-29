/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Persona;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author jegar
 */
public class DPersona {
    //Atributos
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //Metodos
    public void obtRegistros(){
        try{
            conn = Conexion.getConnection();
            String tSQL = "Select * from Persona";
            ps = conn.prepareStatement(tSQL, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE,
                   ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }catch (SQLException ex){
            System.out.println("Error al obtener registros " + ex.getMessage());
        }
    }
    public ArrayList<Persona> listarPersona(){
        ArrayList<Persona> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Persona(
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("cedula"),
                        rs.getString("fechaNac"),
                        rs.getString("email")
                ));
            }
        }catch (SQLException ex){
            System.out.println("Error al listar persona " + ex.getMessage());
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
    
    public boolean guardarPersona(Persona a){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("nombres", a.getNombres());
            rs.updateString("apellidos", a.getApellidos());
            rs.updateString("cedula", a.getCedula());
            rs.updateString("fechaNac", a.getFechaNac());
            rs.updateString("email", a.getEmail());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        }catch(SQLException ex){
            System.out.println("Error al guardar la persona:" + ex.getMessage());
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
    public boolean existePersona(String nombres){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while (rs.next()){
                    if (rs.getString("nombres").equals(nombres)){
                    resp = true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar persona"+ ex.getMessage());
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
    
    public boolean editarPersona(Persona a){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("nombres").equals(a.getNombres())){
                    rs.updateString("nombres", a.getNombres());
                    rs.updateString("apellidos", a.getApellidos());
                    rs.updateString("cedula", a.getCedula());
                    rs.updateString("fechaNac", a.getFechaNac());
                    rs.updateString("email", a.getEmail());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch(SQLException ex){
            System.out.println("Error al editar persona"+ ex.getMessage());
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
    
    public boolean eliminarPersona(String nombres){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getString("nombres").equals(nombres)){
                    rs.deleteRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al eliminar persona"+ ex.getMessage());
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


