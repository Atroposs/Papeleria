/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Conexion.ProductoDAO;
import Model.Producto;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mega
 */
public class PruebaTable extends javax.swing.JFrame {

  
    public PruebaTable() throws ClassNotFoundException, SQLException {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jsp1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        btn1 = new javax.swing.JButton();
        jtf1 = new javax.swing.JTextField();
        jtf2 = new javax.swing.JTextField();
        jtf3 = new javax.swing.JTextField();
        jtf4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jsp1.setViewportView(tableProductos);

        btn1.setText("OK");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        jtf1.setText("2");
        jtf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf1ActionPerformed(evt);
            }
        });

        jtf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtf4)
                    .addComponent(jtf3)
                    .addComponent(jtf2)
                    .addComponent(jtf1, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
                .addGap(88, 88, 88)
                .addComponent(btn1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jsp1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jtf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        try {
            buscarProductos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PruebaTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PruebaTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void jtf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf1ActionPerformed

    private void jtf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf4ActionPerformed

    public void cargarProductos() throws ClassNotFoundException, SQLException{
        String titulos[]={ "Codigo", "Nombre", "Presentacion", "Inventario",};
        String informacion[][] = obtenerMatriz();
        tableProductos = new JTable(informacion,titulos);
        jsp1.setViewportView(tableProductos);
        System.out.println("hello1");
    }
    
    public void buscarProductos() throws ClassNotFoundException, SQLException{
        Producto producto = new Producto(Integer.parseInt(jtf1.getText()),jtf2.getText(),jtf3.getText()
            ,Integer.parseInt(jtf4.getText()));
        String titulos[]={ "Codigo", "Nombre", "Presentacion", "Inventario",};
        String informacion[][] = obtenerMatriz2(producto);
        tableProductos = new JTable(informacion,titulos);
        jsp1.setViewportView(tableProductos);
        System.out.println("hello1");
    }
    
    public String[][]  obtenerMatriz() throws ClassNotFoundException, SQLException{
      ArrayList<Producto> productos = ProductoDAO.MostrarProductos(); 
      
      String matrizInfo[][]=new String[productos.size()][4];
      
      for (int i = 0; i < productos.size(); i++) {
        matrizInfo[i][0]= productos.get(i).getCodigo()+"";
        matrizInfo[i][1]= productos.get(i).getNombre()+"";
        matrizInfo[i][2]= productos.get(i).getPresentacion()+"";
        matrizInfo[i][3]= productos.get(i).getCantidadInventario()+"";
      }
    
      return matrizInfo;
    }
    
    public String[][]  obtenerMatriz2(Producto producto) throws ClassNotFoundException, SQLException{
      ArrayList<Producto> productos = ProductoDAO.BuscarProducto(producto); 
      
      String matrizInfo[][]=new String[productos.size()][4];
      
      for (int i = 0; i < productos.size(); i++) {
        matrizInfo[i][0]= productos.get(i).getCodigo()+"";
        matrizInfo[i][1]= productos.get(i).getNombre()+"";
        matrizInfo[i][2]= productos.get(i).getPresentacion()+"";
        matrizInfo[i][3]= productos.get(i).getCantidadInventario()+"";
      }
    
      return matrizInfo;
    }
    
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        PruebaTable pbt;
        pbt = new PruebaTable();
        pbt.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JScrollPane jsp1;
    private javax.swing.JTextField jtf1;
    private javax.swing.JTextField jtf2;
    private javax.swing.JTextField jtf3;
    private javax.swing.JTextField jtf4;
    private javax.swing.JTable tableProductos;
    // End of variables declaration//GEN-END:variables
}
