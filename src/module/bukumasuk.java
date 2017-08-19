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
    
    public static void addDetailBuku(String no_fbuku,String kode_buku, int jumlah, int hrg_satuan) throws SQLException{
        String value1 = no_fbuku;
        String value2 = kode_buku;
        int value3= jumlah;
        int value4=hrg_satuan;

        
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            try {
                int nilai = 4;
                ResultSet rs = st.executeQuery("SELECT count(*) as id_fbuku from detail_fbuku");
                while(rs.next()){
                    nilai =Integer.parseInt(rs.getString("id_fbuku"));
                    nilai+=1;
                String sql = "insert into detail_fbuku values(?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setInt(1, nilai);
                    pst.setString(2, value1);
                    pst.setString(3, value2);
                    pst.setInt(4, value3);
                    pst.setInt(5, value4);
                    pst.execute();
                    
            }          
        } catch (Exception e) {
                System.out.println(e.getLocalizedMessage().toString());
                }
    } 
    
    public static void deleteDetailBuku(String no_fbuku)throws SQLException{
        String value1 = no_fbuku;
        Connection con = koneksi.GetConnection();
        Statement st = con.createStatement();
        st.executeUpdate("Delete from detail_fbuku where no_fbuku ='"+value1+"'");
    }
    
    public static void saveDetailBuku(String no_fbuku,String tgl, int kd_suplier, int no_po, int lokasi) throws SQLException{
         String value1 = no_fbuku;
        String value2 = tgl;
        int value3= kd_suplier;
        int value4=no_po;
        int value5=lokasi;
        Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            String sql = "insert into faktur_buku values(?,?,?,?,?)";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, value1);
                pst.setString(2, value2);
                pst.setInt(3, value3);
                pst.setInt(4, value4);
                pst.setInt(5, value5);
                pst.execute();
    }
    
    public static String getStok(){

        try {
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select * from stok where kd_buku=kode_buku");
            
//            ResultSet rs = st.executeQuery("SELECT count(*) as value from faktur_buku where tgl=date(now())");
//            while(rs.next()){
//               value =Integer.parseInt(rs.getString("value"));
//            }
//            DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
//            Date date = new Date();
//            if (value<9) {
//                return "FB-"+dateFormat.format(date)+0+(value+1);
//            }
//            else{
//                return "FB-"+dateFormat.format(date)+(value+1);
//            }
        } catch (Exception e) {
        }
        return null;
    }
}

  
