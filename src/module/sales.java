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
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 *
 * @author Tiara Ridha
 */
public class sales {
    public  String kd_sales,kd_manager,nama_sales,alamat_sales,no_telp_sales;
    public void simpan(){
        String sql = "insert into sales (kd_sales,kd_manager,nama_sales,alamat_sales,no_telp_sales) values(?,?,?,?,?)";
        try {
            Connection con = koneksi.GetConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, kd_sales);
            pst.setString(2, kd_manager);
            pst.setString(3, nama_sales);
            pst.setString(4, alamat_sales);
            pst.setString(5, no_telp_sales);
            pst.execute();
        } catch (Exception e) {
            
        }
    }
    
    public ResultSet data(){
        ResultSet data = null;
        try {
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            data = st.executeQuery("Select kd_sales ,kd_manager ,nama_sales ,alamat_sales,no_telp_sales from sales");
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
        return data;
    }
    
    public ResultSet dataCari(String cari){
        ResultSet data = null;
        try {
               Connection con = koneksi.GetConnection();
               Statement st = con.createStatement();
               data = st.executeQuery("Select * from sales where kd_sales like '%"+cari+"%' or nama_sales like '%"+cari+"%' or kd_manager like '%"+cari+"%'");
           } catch (SQLException sqlEx) {
               System.out.println(sqlEx.getMessage());
           } 
        return data;
    }
    
    public void hapus(String kode_sales){
        try {
            String sql = "delete from sales where kd_sales ='"+kode_sales+"'";
            Connection con = koneksi.GetConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage().toString());
        }
    }
    
    public void update(String kode_sales){
        try {
            String sql = "update sales set kd_sales=?,kd_manager=?,nama_sales=?,alamat_sales=?,no_telp_sales=? where kd_sales = ?";
            Connection con = koneksi.GetConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, kd_sales);
            pst.setString(2, kd_manager);
            pst.setString(3, nama_sales);
            pst.setString(4, alamat_sales);
            pst.setString(5, no_telp_sales);
            pst.setString(6, kode_sales);
            pst.execute();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage().toString());
        }
    }
    
    
//    public static void main(String[] args) {
//        sales sales = new sales();
//        sales.kd_sales = "a06";
//        sales.kd_manager = "m02";
//        sales.nama_sales = "Tiara R.A";
//        sales.alamat_sales = "Pontianak";
//        sales.no_telp_sales = "08976788";
//        
//        sales.update("a06");
//    }
}


