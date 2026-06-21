package swingserver;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.TimerTask;

public class IOTAgriculture extends javax.swing.JFrame {

    String farm_id = "9";
    String deviceTypeId = "";
    String status = "";
    Toolkit toolkit;
    Timer timer;
    Connection con;
    int deviceRegId = 1;
    int tempValue[] = {35, 15, 1, 18, 19, 20, 21, 21, 21, 22, 22, 34, 34, 36, 37};
    int humidityValue[] = {80, 12, 16, 18, 19, 20, 21, 22, 23, 24, 25, 30, 34, 36, 40, 50};
    int moistureValue[] = {80, 12, 16, 18, 19, 20, 21, 22, 23, 24, 25, 30, 34, 36, 40, 50};

    public IOTAgriculture() {
        super("IOT Application");
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iot_agriculture", "root", "root");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("Triggering...!");
            onSendData();
            toolkit.beep();
        }
    }

    void sendToServer() {

        try {
            PreparedStatement ps;
            ResultSet rs;

            Random r = new Random();
            int d = r.nextInt(13);
            String farmId = "1";
            System.out.println("Farm id is:" + farmId);
            System.out.println("Temparature is:" + tempValue[d]);
            System.out.println("Moisture is:" + moistureValue[d]);
            System.out.println("Humidity is:" + humidityValue[d]);

            int f = 0;
            ps = con.prepareStatement("select * from sensor_values where farm_id='" + farm_id + "' ");
            rs = ps.executeQuery();
            if (rs.next()) {
                f = 1;
            }
            rs.close();
            if (f == 1) {
                ps = null;
                ps = con.prepareStatement("update sensor_values set sensor_current_date=curdate(),moisture='" + moistureValue[d] + "',temperature='" + tempValue[d] + "',humidity='" + humidityValue[d] + "' where farm_id='" + farm_id + "' ");
                ps.executeUpdate();
            } else {
                ps = null;
                ps = con.prepareStatement("insert into sensor_values values(null,'" + farm_id + "',curdate(),'" + moistureValue[d] + "','" + tempValue[d] + "','" + humidityValue[d] + "' )");
                ps.execute();
            }

            lblTemparature.setText("" + tempValue[d]);
            lblMoisture.setText("" + moistureValue[d]);
            lblHumidity.setText("" + humidityValue[d]);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    java.util.Random r;

    private void onSendData() {

        try {

            sendToServer();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTemparature = new javax.swing.JLabel();
        lblHumidity = new javax.swing.JLabel();
        lblMoisture = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnFlag = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Temparature Level");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 110, 210, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Humidity Level");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 190, 170, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Mositure Level");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 280, 170, 30);

        lblTemparature.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTemparature.setText("jLabel4");
        jPanel1.add(lblTemparature);
        lblTemparature.setBounds(330, 110, 190, 29);

        lblHumidity.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblHumidity.setText("jLabel5");
        jPanel1.add(lblHumidity);
        lblHumidity.setBounds(330, 200, 190, 29);

        lblMoisture.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMoisture.setText("jLabel6");
        jPanel1.add(lblMoisture);
        lblMoisture.setBounds(330, 280, 190, 29);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 255));
        jLabel4.setText("IOT Agriculture");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(670, 450, 210, 70);

        btnFlag.setText("Flag");
        btnFlag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFlagActionPerformed(evt);
            }
        });
        jPanel1.add(btnFlag);
        btnFlag.setBounds(769, 20, 120, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(260, 150, 920, 540);

        btnSubmit.setText("Start");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(btnSubmit);
        btnSubmit.setBounds(40, 690, 110, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swingserver/agri.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1220, 760);

        setSize(new java.awt.Dimension(1234, 801));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        toolkit = Toolkit.getDefaultToolkit();
        timer = new Timer();
        timer.schedule(new IOTAgriculture.RemindTask(), 4 * 1000, 12 * 1000);
         
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnFlagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFlagActionPerformed

        try {
            PreparedStatement ps1 = null;
            ps1 = con.prepareStatement("update sensor_values set sensor_current_date=curdate(),moisture='10',temperature='38',humidity='45' where farm_id='" + farm_id + "' ");
            ps1.executeUpdate();

             lblTemparature.setText("" + 10);
            lblMoisture.setText("" + 38);
            lblHumidity.setText("" + 45);
            
        } catch (Exception ee) {
        }
    }//GEN-LAST:event_btnFlagActionPerformed

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(IOTAgriculture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IOTAgriculture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IOTAgriculture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IOTAgriculture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IOTAgriculture().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFlag;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblHumidity;
    private javax.swing.JLabel lblMoisture;
    private javax.swing.JLabel lblTemparature;
    // End of variables declaration//GEN-END:variables
}
