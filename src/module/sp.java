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

public class sp {
    
    public static String kd_pelanggan, nama_plgn , alamat_plgn, kd_sales, judul, kode_bk;
 
    public static String getkdPlgn() {
        return kd_pelanggan;
    }
 
    public static String getNamaPlgn() {
        return nama_plgn;
    }
 
    public static String getAlamat() {
        return alamat_plgn;
    }
    
    public static String getSales(){
        return kd_sales;
    }
    
    public static String getJudul(){
        return judul;
    }
    
    public static String getKodeBk(){
        return kode_bk;
    }
    
    public static void setPlgnNull(){
        kd_pelanggan = null;
        nama_plgn = null;
        alamat_plgn = null;
        kd_sales =null;
    }
    
    public static void setBukuNull(){
        judul = null;
        kode_bk=null;
    }
    
    
    public static void addDetailSP(String kode_sp,String kode_buku, int jumlah) throws SQLException{
        String value1 = kode_sp;
        String value2 = kode_buku;
        int value3= jumlah;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            try {
                int nilai = 0;
                ResultSet rs = st.executeQuery("SELECT count(*) as id_sp from detail_sp");
                while(rs.next()){
                    nilai =Integer.parseInt(rs.getString("id_sp"));
                    nilai+=1;
                String sql = "insert into detail_sp values(?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, nilai);
                    pst.setString(2, value1);
                    pst.setString(3, value2);
                    pst.setInt(4, value3);
                    pst.execute();                   
            }          
        } catch (Exception e) {
                System.out.println(e.getLocalizedMessage().toString());
                }
    }
    
    public static void deleteDetailBuku(String kode_sp)throws SQLException{
        String value1 = kode_sp;
        Connection con = koneksi.GetConnection();
        Statement st = con.createStatement();
        st.executeUpdate("Delete from detail_sp where kode_sp ='"+value1+"'");
    }
    
    public static void saveDetailBuku(String kode_sp,String kd_pelanggan, String kd_sales, String tgl) throws SQLException{
         String value1 = kode_sp;
        String value2 = kd_pelanggan;
        String value3= kd_sales;
        String value4=tgl;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into surat_pemesanan values(?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.setString(4, value4);
                pst.execute();
    }
}
