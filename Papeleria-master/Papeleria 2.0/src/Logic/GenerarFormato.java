/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;


public class GenerarFormato {
    
    public static Formatos formato = new Formatos();
    
    public static void main(String args[]){
        
        String [][] entrada = new String[3][3];
        entrada[0][0] = "Nombre";
        entrada[0][1] = "Nombre1";
        entrada[0][2] = "Nombre2";
        entrada[1][0] = "Nombre3";
        entrada[1][1] = "Nombre4";
        entrada[1][2] = "Nombre5";
        entrada[2][0] = "Nombre6";
        entrada[2][1] = "Nombre7";
        entrada[2][2] = "Nombre8";
        
        String ruta = "\\Users\\mega\\Desktop\\Salida.xls";
        
        formato.generarExcel(entrada, ruta);
    }
}
