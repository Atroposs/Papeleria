/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author isoju
 */
public class Producto {
    private int codigo;
    private String nombre;
    private String presentacion;
    private int CantidadInventario;

    public Producto(int codigo, String nombre, String presentacion, int CantidadInventario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.CantidadInventario = CantidadInventario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public int getCantidadInventario() {
        return CantidadInventario;
    }

    public void setCantidadInventario(int CantidadInventario) {
        this.CantidadInventario = CantidadInventario;
    }
    
    
    
    
}
