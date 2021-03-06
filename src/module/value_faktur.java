/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import koneksi.koneksi;

/**
 *
 * @author Tiara Ridha
 */
public class value_faktur {
    public static String getVal(){
        try {
            int value = 0;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as value from faktur_buku where tgl=date(now())");
            while(rs.next()){
               value =Integer.parseInt(rs.getString("value"));
            }
            DateFormat dateFormat = new SimpleDateFormat("yy");
            Date date = new Date();
            if (value<100) {
                return "FB-"+dateFormat.format(date)+0+0+(value+1);
            }
            else{
                return "FB-"+dateFormat.format(date)+(value+1);
            }
//                System.out.println(String.valueOf(id));
//              if (rs)
//              {
//                  
//              }
        } catch (Exception e) {
        }
        return null;
    }
    public static String getNoSP(){
        try {
            int value = 0;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as value from surat_pemesanan where tgl=date(now())");
            while(rs.next()){
               value =Integer.parseInt(rs.getString("value"));
            }
            DateFormat dateFormat = new SimpleDateFormat("yy");
            Date date = new Date();
            if (value<100) {
                return "SP"+dateFormat.format(date)+"-"+0+0+(value+1);
            }
            else{
                return "SP-"+dateFormat.format(date)+(value+1);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static String getNoFaktur(){
        try {
            int value = 0;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as value from faktur_jual where j_tgl=date(now())");
            while(rs.next()){
               value =Integer.parseInt(rs.getString("value"));
            }
            DateFormat dateFormat = new SimpleDateFormat("yy");
            Date date = new Date();
            if (value<100) {
                return "FJ-"+dateFormat.format(date)+0+0+(value+1);
            }
            else{
                return "FJ-"+dateFormat.format(date)+(value+1);
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static String getNoKwitansi(){
        try {
            int value = 0;
            Connection con = koneksi.GetConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT count(*) as value from pembayaran where tgl=date(now())");
            while(rs.next()){
               value =Integer.parseInt(rs.getString("value"));
            }
            DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
            Date date = new Date();
            if (value<9) {
                return "KW-"+dateFormat.format(date)+0+(value+1);
            }
            else{
                return "KW-"+dateFormat.format(date)+(value+1);
            }
        } catch (Exception e) {
        }
        return null;
    }
}
