/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tiara Ridha
 */
public class koneksiGammu {
    private static Connection koneksiGammu;
    
    public static Connection GetConnection()throws SQLException{
     try{
        koneksiGammu= DriverManager.getConnection("jdbc:mysql://localhost/sms","root","");
        //JOptionPane.showMessageDialog(null, "koneksi ke database berhasil");
    }
    catch(Exception e){
        //JOptionPane.showMessageDialog(null, "koneksi ke database gagal");
    }
     return koneksiGammu;
    }

    public Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
