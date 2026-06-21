package swingserver;

import java.io.*;
import java.net.*;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class KSEBDevice extends javax.swing.JFrame {

    Toolkit toolkit;
    Timer timer;
    Connection con;

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("Triggering...!");
            onSendData();
            toolkit.beep();
        }
    }

    public KSEBDevice() {
        super("Smart Fab");
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://master.herosite.pro:3306/aghosh_dj_kesb", "aghosh", "farm2020");
        } catch (Exception e) {
            System.out.println(e);
        }
        jLabel4.setVisible(true);
    }
    java.util.Random r;

    void sendToServer() {

        try {
            int f = 0;
            PreparedStatement ps = con.prepareStatement("SELECT  * from loads where consumer_no='" + jTextField1.getText() + "' ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) 
            {
                f = 1;
            }
            rs.close();
            if (f == 1) 
            {
                System.out.println("Server Connected...");
                ps = con.prepareStatement("update loads set load_total=load_total+" + Integer.parseInt(lblTemp.getText()) + " where consumer_no='" + jTextField1.getText() + "' ");
                ps.execute();
                System.out.println("Load data Updated...");
                ps = null;
                ps = con.prepareStatement("SELECT DATEDIFF(CURDATE(), lastdate) from bill where consumer_no='" + jTextField1.getText() + "' ");
                rs = ps.executeQuery();
                int d = 0;
                System.out.println("Now checking the bill date...");
                if (rs.next()) 
                {
                    d = rs.getInt(1);
                    System.out.println("after bill date..." + d);
                }
                if (d > 29) 
                {
                    lblMsg.setText("Your electricity become disconnected.....because " + d + " days after bill date");
                } else 
                {
                    lblMsg.setText("");
                }
            }
            else
            {
                ps = con.prepareStatement("insert into loads values(null,'" + jTextField1.getText() + "','"+lblTemp.getText()+"' )");
                ps.execute();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void onSendData() {

        try {
            // get input data for sending
            r = new Random();
            int temp = r.nextInt(50);
            lblTemp.setText("" + temp);
            int mois = r.nextInt(10);

            System.out.println("in function...!");
            sendToServer();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTemp = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(-4144960,true));
        jPanel1.setForeground(new java.awt.Color(-256,true));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setForeground(new java.awt.Color(-256,true));
        jLabel1.setText("Daily Unit");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 30, 120, 40);

        lblTemp.setFont(new java.awt.Font("Dialog", 1, 18));
        lblTemp.setText("0.00");
        jPanel1.add(lblTemp);
        lblTemp.setBounds(160, 30, 130, 40);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField1.setText("1212");
        jPanel1.add(jTextField1);
        jTextField1.setBounds(340, 30, 180, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 960, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swingserver/5.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 120, 960, 420);

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1000, 470, 53, 25);

        jButton2.setText("Start");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1000, 210, 61, 25);

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblMsg);
        lblMsg.setBounds(20, 550, 790, 60);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setText("Generate");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(820, 570, 150, 40);

        setSize(new java.awt.Dimension(1103, 687));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

    toolkit = Toolkit.getDefaultToolkit();
    timer = new Timer();
    timer.schedule(new RemindTask(), 4 * 1000, 6 * 1000);

}//GEN-LAST:event_jButton2ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    System.exit(0);
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {

            PreparedStatement ps = con.prepareStatement("delete from bill where consumer_no='" + jTextField1.getText() + "' ");
            ps.execute();

            Double d = 0.0;
            String totalUnit = "1";
            ps = con.prepareStatement("SELECT * FROM loads WHERE consumer_no='" + jTextField1.getText() + "' ");
            ResultSet rs = ps.executeQuery();
            int gg = 0;
            if (rs.next()) {
                totalUnit = "" + rs.getInt(3);
                gg = 1;
            }
            rs.close();
            if (gg == 0) {
                ps = con.prepareStatement("insert into loads values(null,'" + jTextField1.getText() + "',1 )");
                ps.execute();
                System.out.println("New consumer ");
            }
            System.out.println("Total unit:" + totalUnit);
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Calendar c = Calendar.getInstance();
            c.add(Calendar.DATE, 20);
            System.out.println(dateFormat.format(c.getTime()));
            String s = dateFormat.format(c.getTime()).toString();

            c.add(Calendar.DATE, 30);
            String s1 = dateFormat.format(c.getTime()).toString();

            ps = con.prepareStatement("SELECT * FROM bill_slab WHERE 1000 BETWEEN min_load AND max_load");
            rs = ps.executeQuery();
            String p = "";
            if (rs.next()) {
                p = "" + rs.getInt(4);
            }
            Double to = Double.parseDouble(p) * Double.parseDouble(totalUnit);

            ps = con.prepareStatement("insert into  bill values(null,'" + jTextField1.getText() + "',curdate()," + to + ",'Not paid','Not paid','" + s + "','" + s1 + "','','" + totalUnit + "' ) ");
            ps.execute();
            System.out.println("Bill ok...");
            ps = null;
        } catch (Exception ee) {
            System.out.println(ee);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KSEBDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KSEBDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KSEBDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KSEBDevice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KSEBDevice().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTemp;
    // End of variables declaration//GEN-END:variables
}
