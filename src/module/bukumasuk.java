/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.koneksi;

/**
 *
 * @author Tiara Ridha
 */
public class bukumasuk {
    public class simpanbuku {
    }
     public static String kdSuplier, noPO , lokasi;
 
    public static String getkdSuplier() {
        return kdSuplier;
    }
 
    public static String getNoPO() {
        return noPO;
    }
 
    public static String getlokasi() {
        return lokasi;
    }
    
    public static void setNull(){
        kdSuplier = null;
        noPO = null;
        lokasi = null;
    }
    
   //Fungsi Buat Form buku masuk------------------------------------------------------------------------------------------
    
    public static void addDetailBuku(String no_fbuku,String kd_buku, int jumlah, int hrg_satuan) throws SQLException{
        String value1 = no_fbuku;
        String value2 = kd_buku;
        int value3= jumlah;
        int value4=hrg_satuan;
          Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into detail_fbuku values(?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setInt(3, value3);
                pst.setInt(4, value4);
                pst.execute();
    } 
    
}

  
