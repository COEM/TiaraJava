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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import static java.util.Collections.list;
import java.util.Date;
import javax.swing.JOptionPane;
import koneksi.koneksi;

/**
 *
 * @author Tiara Ridha
 */
public class buku {
    public static Boolean checkBuku(String kode){
        try {
            int value = 0;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as value from data_buku where kode_buku='"+kode+"'");
            while(rs.next()){
               value =Integer.parseInt(rs.getString("value"));
            }
            if (value >= 1) {
                return true;
            }
            else{
                return false;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    //Fungsi buat Form data Buku , Buku Baru----------------------------------------------------------------------------------
    
    public static void addBukuandHrg(String kd_buku,String judul, String penerbit, int hrg_satuan, int hrg_distributor) throws SQLException{
        String value1 = kd_buku;
        String value2 = judul;
        String value3 = penerbit;
        int value4= hrg_satuan;
        int value5=hrg_distributor;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into buku values(?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setString(3, value3);
                pst.execute();
            String sql2 ="insert into harga values(?,?,?)";
            PreparedStatement pst2 = con.prepareStatement(sql2);
            pst2.setString(1, value1);
            pst2.setInt(2, value4);
            pst2.setInt(3, value5);
            pst2.execute();
    }
    
    public static void updateBukuandHrg(String kd_buku,String judul, String penerbit, int hrg_satuan, int hrg_distributor) throws SQLException{
         String value1 = kd_buku;
        String value2 = judul;
        String value3 = penerbit;
        int value4= hrg_satuan;
        int value5=hrg_distributor;
           Connection con = koneksi.GetConnection();
            String sql = "Update buku set kd_buku='"+value1+"',judul='"+value2+"',penerbit='"+value3+"' where kd_buku='"+value1+"'";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.executeUpdate();
            String sql2 = "Update harga set id_buku='"+value1+"',hrg_satuan='"+value4+"',hrg_distributor='"+value5+"' where id_buku='"+value1+"'";
                PreparedStatement pst2 = con.prepareStatement(sql2);
                pst2.executeUpdate();
    }
    
    public static void deleteBukuandHrg(String kd_buku,String judul, String penerbit, int hrg_satuan, int hrg_distributor)throws SQLException{
        String value1 = kd_buku;
        String value2 = judul;
        String value3 = penerbit;
        int value4= hrg_satuan;
        int value5=hrg_distributor;
         Connection con = koneksi.GetConnection();
         String sql = "delete from buku where kd_buku ='"+value1+"'";
         PreparedStatement pst = con.prepareStatement(sql);
                pst.executeUpdate();
                String sql2 = "delete from harga where id_buku ='"+value1+"'";
         PreparedStatement pst2 = con.prepareStatement(sql2);
                pst2.executeUpdate();
    }
    
    public static String tampilBuku(String kd_buku,String judul, String penerbit, int hrg_satuan, int hrg_distributor)throws SQLException{
            try {
             Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select kd_buku,judul,penerbit,hrg_satuan,hrg_distributor from buku "
                    + "inner join harga on kd_buku=id_buku");
        } catch (Exception e) {
        }
         return null;  
    }
  
    public static void addOrUpdateBuku(String kode_buku,String no_faktur, String nama_buku, String penerbit, int hrg_distributor, int hrg_satuan, int stok ) throws SQLException{
        //sesuaikan dengan name tabel
        String value1 = kode_buku;
        String value2 = nama_buku;
        String value3 = penerbit;
        int value4 = hrg_distributor;
        int value5 = hrg_satuan;
        int value6 = stok;
        String value7 = no_faktur;
        int value = 0;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
        try {
            if (checkBuku(kode_buku)==false) {
            //ambek query inser into tabel data_buku, masokkan sini
//            try{

                
//                if("".equals(kode_buku.getText()) || "".equals(nama_buku.getText()) ||
//                    "".equals(penerbit.getText()) || "".equals(hrg_distributor.getText()) || 
//                    "".equals(hrg_jual.getText()) || "".equals(stok.getText()))
//                {
//                    JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
//                }
//                else 
//                {
                String sql = "insert into data_buku values(?,?,?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value7);
                pst.setString(3, value2);
                pst.setString(4, value3);
                pst.setInt(5, value4);
                pst.setInt(6, value5);
                pst.setInt(7, value6);
                pst.execute();
                

//                bismillah_ta.form.form_bukumasuk yo = new bismillah_ta.form.form_bukumasuk();
//                yo.setVisible(true); 
//                this.setVisible(false);
//                }                
             }
             else if (checkBuku(kode_buku)== true){
                try {

                    ResultSet rs = st.executeQuery("SELECT stok from data_buku where kode_buku='"+kode_buku+"'");
                        while(rs.next()){
                           value =Integer.parseInt(rs.getString("stok"));
                        }
                    stok += value;
                    String sql = "UPDATE data_buku set stok = '"+stok+"', hrg_satuan = '"+hrg_satuan+"' where kode_buku = '"+kode_buku+"' ";
                    st.executeUpdate(sql);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage().toString());
                }                   
            }           
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage().toString());
        }
    }
    
    public static ResultSet getBukuData(String kode){
        ResultSet rs = null;
        
        try {
            //sabar agek miker wkwk
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            
//             rs = 
//             System.out.println(rs.getString(0));
            return st.executeQuery("SELECT * from data_buku where kode_buku='"+kode+"'");
        } catch (Exception e) {
        }
        return rs;
        
    }
    
    public static void main(String[] args) throws SQLException {
        ResultSet a = getBukuData("a009");
//        disini ni susah ngecek isi variabale kyk mane
        //dimane mane index tu dimulai dari 0 sial
        //wkwk begune
        //inilah ni java, kalo dah object,result, ky taik,njir merah semua hahaha yeay
        //yang ini ke?
         while(a.next()){
             System.out.println(a.getString(1));
                        }
//        int x = 2;
//        int y = 5;
//        y +=x;
//        System.out.println(y);
//        System.out.println(buku.checkBuku("a009"));
//        try {
//            //fuck, ndak ade efek
//             addOrUpdateBuku("4h4h", "S-15051701", "sa","asde", 12, 13, 5);
//        } catch (Exception e) {
//            System.out.println(e.getLocalizedMessage().toString());
//        }
        
    }
}
