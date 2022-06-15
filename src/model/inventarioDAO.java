package model;

import conexionBD.ConexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Bito
 */
public class inventarioDAO {
    //Atributos que establecen conexión y ejecución de query sql
    ConexionBD conexion = new ConexionBD();
    private static Connection con = null;
    private Statement ps = null;
    private ResultSet rs = null;
    
     //Listar - Select (Read)
    public List listar() {
        String sql = "SELECT * FROM producto"; 
        List producto = new ArrayList(); 
        try {
            con = ConexionBD.iniciarConexion();
            ps = con.createStatement();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Inventario p = new Inventario();
                p.setCodigo(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setPrecio(rs.getInt(3));
                p.setDescripcion(rs.getString(4));
                producto.add(p);                
            }
            
        } catch (Exception e) {
            System.out.println("Error SQL"+e);
        }
        return producto; 
    }
    
    //Create-Agregar
    public void ingresar (Inventario inventario){
          String sql  = "INSERT INTO  inventario(nombre, precio, descripcion) values(?,?,?)";
          try {
            con = ConexionBD.iniciarConexion(); //inicio la conexion con la BD
            ps = con.prepareStatement(sql);
            //ps.setString(1, inventario.getNombre());
            //ps.setInt(2, inventario.getPrecio());
            //ps.setString(3, inventario.getDescripcion());
            ps.executeUpdate(sql); //Ejecutando la query
             } catch (SQLException e) {
            System.out.println("Error SQL"+e); //en caso de error de la query
        }
    }

}
