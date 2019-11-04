/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;


import Model.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductoDAO {

    
    public static void AgregarProducto(Producto producto) throws ClassNotFoundException, SQLException{
	PreparedStatement query = null;
        Connection cnx = null;
        
	String sql="CALL InsertarProducto(?,?,?,?);";
        
	try {			
          cnx = DBconnection.getConnection();
        
	  query = cnx.prepareStatement(sql);
          
          query.setInt(1, producto.getCodigo());
          query.setString(2, producto.getNombre());
          query.setString(3, producto.getPresentacion());
          query.setInt(4, producto.getCantidadInventario());
          
          query.executeUpdate();
          query.close();
          
          cnx.close();
          
          System.out.println("Producto agregado con exito");
	} catch (SQLException e) {
            
	  System.out.println("Error: Clase ProductoDao, método registrar");
          System.out.println(sql);
          e.printStackTrace();
          cnx.close();
	}
    }
    
    public static ArrayList<Producto> BuscarProducto(Producto producto) throws ClassNotFoundException, SQLException{
        ArrayList<Producto> productos = new ArrayList<Producto>();
	PreparedStatement query = null;
        Connection cnx = null;
        
	String sql="CALL BuscarProducto(?,?,?,?);";
        
	try {			
          cnx = DBconnection.getConnection();
	  query = cnx.prepareStatement(sql);
          
          query.setInt(1, producto.getCodigo());
          query.setString(2, producto.getNombre());
          query.setString(3, producto.getPresentacion());
          query.setInt(4, producto.getCantidadInventario());
          
          ResultSet rs = query.executeQuery();
          while (rs.next()){
             producto = new Producto();
             producto.setCodigo(rs.getInt("Codigo"));
             producto.setNombre(rs.getString("Nombre"));
             producto.setPresentacion(rs.getString("Presentacion"));
             producto.setCantidadInventario(rs.getInt("Inventario"));
             productos.add(producto);
          }
          
          
          rs.close();
          query.close();
          cnx.close();
          
          System.out.println("Producto buscado con exito");
	} catch (SQLException e) {
            
	  System.out.println("Error: Clase ProductoDao, método registrar");
          System.out.println(sql);
          e.printStackTrace();
          cnx.close();
	}
        
        return productos;
    }
    
    public static ArrayList<Producto> MostrarProductos() throws ClassNotFoundException, SQLException{
        ArrayList<Producto> productos = new ArrayList<Producto>();
        Producto producto;
	Statement query = null;
        Connection cnx = null;
        
	String sql="SELECT * FROM PAPELERIA.Producto;";
        
	try {			
          cnx = DBconnection.getConnection();
        
	  query = cnx.createStatement();
          ResultSet rs = query.executeQuery(sql);

          while (rs.next()){
             producto = new Producto();
             producto.setCodigo(rs.getInt("Codigo"));
             producto.setNombre(rs.getString("Nombre"));
             producto.setPresentacion(rs.getString("Presentacion"));
             producto.setCantidadInventario(rs.getInt("Inventario"));
             productos.add(producto);
          }
          rs.close();
          query.close();
          cnx.close();
          
          System.out.println("Productos Mostrados con exito");
	} catch (SQLException e) {
            
	  System.out.println("Error: Clase ProductoDao, método registrar");
          System.out.println(sql);
          e.printStackTrace();
          cnx.close();
	}
        
        return productos;
    }
    
    
    
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
      Producto producto = new Producto(40,"Carpeta","amarisho",3);
      AgregarProducto(producto);
   }
}
