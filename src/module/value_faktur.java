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
            ResultSet rs = st.executeQuery("SELECT count(*) as value from buku_masuk` where tgl=date(now())");
            while(rs.next()){
               value =Integer.parseInt(rs.getString("value"));
//               Date date = new Date();
//               //date = rs.getDate("tgl_masuk");
//               ate tgl = rs.getString("tgl");
            }
            DateFormat dateFormat = new SimpleDateFormat("ddMMyy");
            Date date = new Date();
            if (value<9) {
                return "S-"+dateFormat.format(date)+0+(value+1);
            }
            else{
                return "S-"+dateFormat.format(date)+(value+1);
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
    
}
