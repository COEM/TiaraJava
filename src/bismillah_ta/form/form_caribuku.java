/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bismillah_ta.form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import koneksi.koneksi;
import module.caribuku;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Tiara Ridha
 */
public class form_caribuku extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    public module.caribuku fab = null;
    
    public form_caribuku() {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon ico = new ImageIcon("src/image/photo.png");
        setIconImage(ico.getImage());
        tampildata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        caribukuTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cari Buku");

        caribukuTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                caribukuTxtKeyReleased(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Form Cari Buku");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/ok1.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search-flat1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(caribukuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caribukuTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        bismillah_ta.form.form_suratpemesanan yo = new bismillah_ta.form.form_suratpemesanan();
//        yo.setVisible(true);
//        this.setVisible(false);
        bismillah_ta.form.form_bukumasuk yo = new bismillah_ta.form.form_bukumasuk();
        yo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void caribukuTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_caribukuTxtKeyReleased
        // TODO add your handling code here:
        try {
               Connection con = koneksi.GetConnection();
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("Select kd_buku,judul,penerbit,hrg_satuan,jumlah from buku "
                       + "inner join harga on kd_buku=id_buku inner join stok on kd_buku=no_buku where kd_buku like '%"+caribukuTxt.getText()+"%'"
                       + "or judul like '%"+caribukuTxt.getText()+"%'");
//               jTable1.setModel(DbUtils.resultSetToTableModel(rs));
                 DefaultTableModel tabel_tes = new DefaultTableModel();
                tabel_tes.addColumn("Kd Buku");
                tabel_tes.addColumn("Judul");
                tabel_tes.addColumn("Penerbit");
                 tabel_tes.addColumn("Hrg Satuan");
                  tabel_tes.addColumn("Jumlah");
            while (rs.next()) {            
              tabel_tes.addRow(new Object[]{
                  rs.getString("kd_buku"),
                  rs.getString("judul"),
                  rs.getString("penerbit"),
                  rs.getString("hrg_satuan"),
                  rs.getString("jumlah"),
              });
              jTable1.setModel(tabel_tes);
            }
           } catch (SQLException sqlEx) {
               System.out.println(sqlEx.getMessage());
           }
         finally {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(65);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(35);
        }
    }//GEN-LAST:event_caribukuTxtKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
         int x = jTable1.getSelectedRow();
        if (x != -1)
        {
            caribuku.kdBuku = jTable1.getValueAt(x, 0).toString();
            caribuku.namaBuku = jTable1.getValueAt(x, 1).toString();
            caribuku.hargaBuku = jTable1.getValueAt(x, 3).toString();
        } 
    }//GEN-LAST:event_jTable1MouseClicked

    public final void tampildata() {
    try {
        Connection con = koneksi.GetConnection();
               Statement st = con.createStatement();
               ResultSet rs = st.executeQuery("Select kd_buku,judul,penerbit,hrg_satuan,jumlah from buku "
                    + "inner join harga on kd_buku=id_buku inner join stok on kd_buku=no_buku");
       DefaultTableModel tabel_tes = new DefaultTableModel();
                tabel_tes.addColumn("Kd Buku");
                tabel_tes.addColumn("Judul");
                tabel_tes.addColumn("Penerbit");
                 tabel_tes.addColumn("Hrg Satuan");
                  tabel_tes.addColumn("Jumlah");
            while (rs.next()) {            
              tabel_tes.addRow(new Object[]{
                  rs.getString("kd_buku"),
                  rs.getString("judul"),
                  rs.getString("penerbit"),
                  rs.getString("hrg_satuan"),
                  rs.getString("jumlah"),
              });
              jTable1.setModel(tabel_tes);
            }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ada kesalahan" + e);
    }
    finally {
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(180);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(65);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(35);
        }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(form_caribuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(form_caribuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(form_caribuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(form_caribuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new form_caribuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField caribukuTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
