/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Persona;
import entidades.Voluntario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alessandra
 */
public class DVoluntario {
    //Atributos
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //Metodos
    public void obtRegistros(){
        try{
            conn = Conexion.getConnection();
            String tSQL = "Select * from Voluntario";
            ps = conn.prepareStatement(tSQL, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE,
                   ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }catch (SQLException ex){
            System.out.println("Error al obtener registros " + ex.getMessage());
        }
    }
    
    public ArrayList<Voluntario> listarVoluntario(){
        ArrayList<Voluntario> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while (rs.next()){
                lista.add(new Voluntario(
                        rs.getInt("VoluntarioID"),
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("Cedula"),
                        rs.getString("FechaNac"),
                        rs.getString("Email")
                ));
            }
        } catch (SQLException ex){
            System.out.println("Error al listar voluntario" + ex.getMessage());
    } finally{
            
            try {
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    ps.close();
                }
                
                if (conn != null){
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return lista;
    }
    
    public boolean guardarVoluntario(Voluntario a){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateString("Nombres", a.getNombres());
            rs.updateString("Apellidos", a.getApellidos());
            rs.updateString("Cedula", a.getCedula());
            rs.updateString("FechaNac", a.getFechaNac());
            rs.updateString("Email", a.getEmail());
            rs.insertRow();
            guardado = true;
        } catch (SQLException ex){
            System.out.println("Error al guardar voluntario: " + ex.getMessage());
        } finally {
            try {
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    ps.close();
                }
                
                if (conn != null){
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        } return guardado;
    }
    
    public boolean existeVoluntario (int id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while (rs.next()){
                if (rs.getInt("VoluntarioID") == id){
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al buscar voluntario: " + ex.getMessage());
        }
        finally {
            try{
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    ps.close();
                }
                
                if (conn != null){
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        } return resp;
    }
    
    public boolean editarVoluntario(Voluntario a){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while (rs.next()){
                if (rs.getInt("VoluntarioID") == a.getId()){
                    rs.updateString("Nombres", a.getNombres());
                    rs.updateString("Apellidos", a.getApellidos());
                    rs.updateString("Cedula", a.getCedula());
                    rs.updateString("FechaNac", a.getFechaNac());
                    rs.updateString("Email", a.getEmail());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al editar: " + ex.getMessage());
        } finally {
            try{
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    ps.close();
                }
                
                if (conn != null){
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        } return resp;
    }
    
    public boolean eliminarVoluntario(int id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if (rs.getInt("VoluntarioID") == id){
                    rs.deleteRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al eliminar voluntario" + ex.getMessage());
        } finally {
            try{
                if (rs != null){
                    rs.close();
                }
                
                if (ps != null){
                    ps.close();
                }
                
                if (conn != null){
                    Conexion.closeConexion(conn);
                }
            } catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        } return resp;
    }
}
