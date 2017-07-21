/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Tiara Ridha
 */
public class koneksi {
    private static Connection koneksi;
    public static String PathReport = System.getProperty("user.dir") + "/build/classes/laporan";
    public static Connection GetConnection()throws SQLException{
     try{
        koneksi= DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
        //JOptionPane.showMessageDialog(null, "koneksi ke database berhasil");
    }
    catch(Exception e){
        //JOptionPane.showMessageDialog(null, "koneksi ke database gagal");
    }
     return koneksi;
    }

    public Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
