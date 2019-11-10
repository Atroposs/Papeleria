/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Formatos {

    public void generarExcel(String[][] entrada, String ruta) {
        
        try {
            WorkbookSettings conf = new WorkbookSettings();
            conf.setEncoding("ISO-8859-1");
            WritableWorkbook workBook = Workbook.createWorkbook(new File(ruta), conf);
        
            WritableSheet sheet = workBook.createSheet("Resultado", 0);
            
            WritableFont fuente = new WritableFont(WritableFont.COURIER,16,WritableFont.NO_BOLD);
            WritableCellFormat hFormat = new WritableCellFormat(fuente);
            
            for(int fila=0;fila<entrada.length;fila++){
                for(int columna=0;columna<entrada[fila].length;columna++){
                    
                    try {
                        sheet.addCell(new jxl.write.Label(columna, fila, entrada[columna][fila],hFormat));
                    } catch (WriteException ex) {
                        Logger.getLogger(Formatos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            workBook.write();
            
            workBook.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Formatos.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (WriteException ex) {
            Logger.getLogger(Formatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
