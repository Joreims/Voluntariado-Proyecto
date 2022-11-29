/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entidades.Persona;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class DUsuario {
    //Atributos
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    //Metodos
    public void obtRegistros(){
        try{
            conn = Conexion.getConnection();
            String tSQL = "Select * from Usuario";
            ps = conn.prepareStatement(tSQL, 
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                   ResultSet.CONCUR_UPDATABLE,
                   ResultSet.HOLD_CURSORS_OVER_COMMIT);
            rs = ps.executeQuery();
        }catch (SQLException ex){
            System.out.println("Error al obtener registros " + ex.getMessage());
        }
    }
    public ArrayList<Usuario> listarUsuario(){
        ArrayList<Usuario> lista = new ArrayList<>();
        try{
            this.obtRegistros();
            while(rs.next()){
                lista.add(new Usuario(
                        rs.getInt("Id"),
                        rs.getString("Password"),
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("Cedula"),
                        rs.getString("FechaNac"),
                        rs.getString("Celular"),
                        rs.getString("Email")
                        
                ));
            }
        }catch (SQLException ex){
            System.out.println("Error al listar usuario " + ex.getMessage());
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
    
    public boolean guardarUsuario(Usuario a){
        boolean guardado = false;
        this.obtRegistros();
        try{
            rs.moveToInsertRow();
            rs.updateInt("Id", a.getId());
            rs.updateString("Password", a.getPassword());
            rs.updateString("Nombres", a.getNombres());
            rs.updateString("Apellidos", a.getApellidos());
            rs.updateString("Cedula", a.getCedula());
            rs.updateString("FechaNac", a.getFechaNac());
            rs.updateString("Celular", a.getCelular());
            rs.updateString("Email", a.getEmail());
            rs.insertRow();
            rs.moveToCurrentRow();
            guardado = true;
        }catch(SQLException ex){
            System.out.println("Error al guardar la usuario:" + ex.getMessage());
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
    public boolean existeUsuario(int id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while (rs.next()){
                if (rs.getInt("Id") == id){
                    resp = true;
                    break;
                }
            }
        }catch(SQLException ex){
            System.out.println("Error al buscar usuario"+ ex.getMessage());
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
    
    public boolean editarUsuario(Usuario a){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Id") == a.getId()){
                    rs.updateString("Password", a.getPassword());
                    rs.updateRow();
                    resp = true;
                    break;
                }
            }
        } catch(SQLException ex){
            System.out.println("Error al editar usuario"+ ex.getMessage());
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
    
    public boolean eliminarUsuario(int id){
        boolean resp = false;
        this.obtRegistros();
        try{
            rs.beforeFirst();
            while(rs.next()){
                if(rs.getInt("Id") == id){
                    rs.deleteRow();
                    resp = true;
                    break;
                }
            }
        } catch (SQLException ex){
            System.out.println("Error al eliminar usuario"+ ex.getMessage());
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
