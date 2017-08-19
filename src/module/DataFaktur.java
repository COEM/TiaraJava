/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import koneksi.koneksi;

/**
 *
 * @author Tiara Ridha
 */
public class DataFaktur {
    public static String kdBuku, judul , jumlah, hrg_satuan;
 
    public static String getkdBuku() {
        return kdBuku;
    }
 
    public static String getJudul() {
        return judul;
    }
 
    public static String getJumlah() {
        return jumlah;
    }
    
    public static String getHrg(){
        return hrg_satuan;
    }
    
    //Fungsi buat CRUD ----------------------------------------------------------------------------------------------------
    public static void addDetailBuku(String kd_fjual,String kode_bk, int jumlah, int discount, double subtotal)throws SQLException{
        String value1=kd_fjual;
        String value2=kode_bk;
        int value3=jumlah;
        int value4=discount;
        double value5 = subtotal;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            try {
                int nilai = 0;
                ResultSet rs = st.executeQuery("SELECT count(*) as id_fjual from detail_fjual");
                while(rs.next()){
                    nilai =Integer.parseInt(rs.getString("id_fjual"));
                    nilai+=1;
                String sql = "insert into detail_fjual values(?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, nilai);
                    pst.setString(2, value1);
                    pst.setString(3, value2);
                    pst.setInt(4, value3);
                    pst.setInt(5, value4);
                    pst.setDouble(6, value5);
                    pst.execute();
            }          
        } catch (Exception e) {
                System.out.println(e.getLocalizedMessage().toString());
                }
    }
    
    public static void saveDetailBuku(String no_fjual, String no_sp, String kode_plgn, String kode_sales, String j_tgl, String j_tempo) throws SQLException{
        String value1 = no_fjual;
        String value2 = no_sp;
        String value3 = kode_plgn;
        String value4 = kode_sales;
        String value5 = j_tgl;
        String value6 = j_tempo;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into faktur_jual values(?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.setString(4, value4);
                pst.setString(5, value5);
                pst.setString(6, value6);
                pst.execute();
    }
    
    public static void deleteDetailBuku(String kd_fjual)throws SQLException{
        String value1 = kd_fjual;
        Connection con = koneksi.GetConnection();
        Statement st = con.createStatement();
        st.executeUpdate("Delete from detail_fjual where kd_fjual ='"+value1+"'");
    }
    
      
}
