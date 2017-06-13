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
    
    public static void addDetailBuku(String no_fbuku,String kd_buku, int jumlah, int hrg_satuan) throws SQLException{
        String value1 = no_fbuku;
        String value2 = kd_buku;
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
}

  
