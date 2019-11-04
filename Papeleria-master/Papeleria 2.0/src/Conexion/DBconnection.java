/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {
   private static final String URL = "jdbc:mysql://localhost:3306/Papeleria?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&autoReconnect=true&useSSL=false";
   private static final String USERNAME = "root";
   private static final String PASSWORD = "1234";
   private static Connection cnx = null;

    public DBconnection() {
    }
   
   
   public static Connection getConnection() throws SQLException, ClassNotFoundException{
       if (cnx == null) {
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnx = DriverManager.getConnection(URL, USERNAME, PASSWORD);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      if (cnx != null) {
        System.out.println("Conexión 3: Conexión a mi base satisfacoria");
      }
      else{
        System.out.println("Conexión 3: Conexión a mi base fallida"); 
      }
      return cnx;
   }
   
   public static void cerrar() throws SQLException {
      if (cnx != null) {
         cnx.close();
         System.out.println("Conexión 3: Conexión a mi base cerrada");
      }
   }
   public static void main(String args[]) throws SQLException, ClassNotFoundException {
    DBconnection.getConnection();
    DBconnection.cerrar();
   }
   
}

