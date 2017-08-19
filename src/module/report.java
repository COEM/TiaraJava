/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.io.File;
import java.util.HashMap;
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
public class report {
     public void printPerSales(String nama){
        try {
            String reportName = koneksi.PathReport + "/lap-persales.jasper";
            HashMap parameter = new HashMap();
            parameter.put("nama_sales",nama);
            File reportFile = new File(reportName);
            JasperReport jReport = (JasperReport) JRLoader.loadObject(reportFile);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, koneksi.GetConnection());
            JasperViewer.viewReport(jPrint,false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void printPerManager(String nama){
        try {
            String reportName = koneksi.PathReport + "/lap_permanager.jasper";
            HashMap parameter = new HashMap();
            parameter.put("nama_manager",nama);
             
            File reportFile = new File(reportName);
            JasperReport jReport = (JasperReport) JRLoader.loadObject(reportFile);
            JasperPrint jPrint = JasperFillManager.fillReport(jReport, parameter, koneksi.GetConnection());
            JasperViewer.viewReport(jPrint,false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
//    public static void main(String[] args) {
//        laporan cetak = new laporan();
//        cetak.printPerSales("fahri", "lap-persales");
//    }
}
