/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.io.File;
import java.sql.Connection;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Tiara Ridha
 */
public class cetak {
    public cetak(String namaReport){
        try {
             koneksi konek = new koneksi();
            Connection con = konek.GetConnection();
            
            File report_file = new File(namaReport);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null,con);
            
            JasperViewer.viewReport(jasperPrint,false);
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
}
}
