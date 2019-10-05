/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;


import Model.Producto;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class ProductoDAO {
    
    public static void AgregarProducto(Producto producto) throws ClassNotFoundException{
	Statement query = null;
        Connection cnx = null;
	String sql="CALL InsertarProducto("+ producto.getCodigo()+","+producto.getNombre()
                +","+producto.getPresentacion()+","+producto.getCantidadInventario()+");";
	try {			
          cnx = DBconnection.getConnection();
	  query = cnx.createStatement();
          query.execute(sql);
          query.close();
          cnx.close();
	} catch (SQLException e) {
	  System.out.println("Error: Clase ProductoDao, método registrar");
	}

    }
    
    
    public static void main(String args[]) throws ClassNotFoundException {
      Producto producto = new Producto(01,"Carpeta","Azul",3);
      AgregarProducto(producto);
   }
}
