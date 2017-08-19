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
public class Akuntan {
    public static String NoSP,kdPlgn,namaPlgn,nomor,pesan,noFaktur;
 
    public static String getNoSP() {
        return NoSP;
    }
    
    public static String getKdPlgn(){
        return kdPlgn;
    }
    
    public static String getNamaPlgn(){
        return namaPlgn;
    }
    
    public static String getFaktur(){
        return noFaktur;
    }
    
    //buat sms gateway-------------------------------------------------------------------------------------------------------------
    public static String getNomor(){
        return nomor;
    }
    
    public static String getPesan(){
        return pesan;
    }
    
     public static void addPembayaran(String no_kwitansi,String no_jual, String no_plgn, String tgl, double saldo)throws SQLException{
        String value1=no_kwitansi;
        String value2=no_jual;
        String value3=no_plgn;
        String value4=tgl;
        double value5 = saldo;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into pembayaran values(?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.setString(4, value4);
                pst.setDouble(5, value5);
                pst.execute();
    }
     
     
// Tabel Piutang-----------------------------------------------------------------------------------------------------------------------
     public static void deletePiutang(String kode_fjual)throws SQLException{
         String value1=kode_fjual;
         Connection con = koneksi.GetConnection();
        Statement st = con.createStatement();
        st.executeUpdate("Delete from piutang where kode_fjual ='"+value1+"'");
     }
     
//SMS Gateway -----------------------------------------------------------------------------------------------------------------------
     public static void sendOutbox(String DestinationNumber,String TextDecoded, String CreatorID)throws SQLException{
        String value1=DestinationNumber;
        String value2=TextDecoded;
        String value3=CreatorID;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into outbox(DestinationNumber,TextDecoded,CreatorID) values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.execute();
    }
     
 //User-------------------------------------------------------------------------------------------------------------------------------
     public static void addUser(String username, String password, String level)throws SQLException{
        String value1=username;
        String value2=password;
        String value3=level;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into user(username,password,level) values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.execute();
    }
     
     public static void editUser(String username, String password, String level)throws SQLException{
        String value1=username;
        String value2=password;
        String value3=level;
        
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "Update user set username=?,password=?,level=? where username=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.setString(4, value1);
                pst.executeUpdate();
    }
     
     public static void deleteUser(String username)throws SQLException{
        String value1=username;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            st.executeUpdate("Delete from user where username ='"+value1+"'");
    }
}
