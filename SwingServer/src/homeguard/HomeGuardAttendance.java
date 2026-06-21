package homeguard;

import swingserver.*;
import java.io.*;
import java.net.*;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.print.attribute.standard.JobMessageFromOperator;
import javax.swing.JOptionPane;

public class HomeGuardAttendance extends javax.swing.JFrame {

    Toolkit toolkit;
    Timer timer;
    Connection con;
    DateTimeFormatter dtf;
    LocalDateTime now;
    String shift = "Morning";

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("Triggering...!");
            onSendData();
            toolkit.beep();
        }
    }

    public HomeGuardAttendance() {
        super("Smart attendance system");
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://master.herosite.pro:3306/aghosh_dj_home_guard", "aghosh", "farm2020");

            dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            lblDate.setText(dtf.format(now));

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    java.util.Random r;

    void sendToServer() {

        try {
            String salary = "1";
            PreparedStatement ps = con.prepareStatement("select * from daily_salary where home_guard_id='" + txtGuard.getText() + "' ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                salary = rs.getString(3);
            }

            System.out.println("Server Connected...");

            String d = "-2022";

            ps = con.prepareStatement("insert into punching_time values(null,'" + txtGuard.getText() + "','" + dtf.format(now) + "','" + shift + "' ,'" + loginTime + "','" + d + "' )");
            ps.execute();
            System.out.println("Punching time inserted...");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void onSendData() {

        try {
            // get input data for sending

            System.out.println("in function...!");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGuard = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnMorning = new javax.swing.JButton();
        btnEvening = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnCalculate = new javax.swing.JButton();
        lblDec = new javax.swing.JLabel();
        lblJan = new javax.swing.JLabel();
        lblFeb = new javax.swing.JLabel();
        lblMar = new javax.swing.JLabel();
        lblApr = new javax.swing.JLabel();
        lblOct = new javax.swing.JLabel();
        lblSep = new javax.swing.JLabel();
        lblAug = new javax.swing.JLabel();
        lblJuly = new javax.swing.JLabel();
        lblJune = new javax.swing.JLabel();
        lblMay = new javax.swing.JLabel();
        lblNov = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(-20561,true));
        jPanel1.setForeground(new java.awt.Color(-256,true));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel1.setForeground(new java.awt.Color(-1,true));
        jLabel1.setText("Current date and time ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 20, 210, 60);

        txtGuard.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtGuard.setText("10");
        jPanel1.add(txtGuard);
        txtGuard.setBounds(760, 30, 180, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Home Guard Id");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(560, 30, 190, 40);

        lblDate.setFont(new java.awt.Font("Dialog", 1, 18));
        lblDate.setForeground(new java.awt.Color(0, 0, 255));
        lblDate.setText("00.00.00.00.00");
        jPanel1.add(lblDate);
        lblDate.setBounds(240, 30, 300, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 10, 1190, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homeguard/attn.jpg"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 120, 804, 461);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1040, 680, 130, 40);

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(lblMsg);
        lblMsg.setBounds(20, 550, 790, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(null);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Punch");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(70, 440, 130, 40);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(null);

        btnMorning.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMorning.setText("Morning");
        btnMorning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMorningActionPerformed(evt);
            }
        });
        jPanel3.add(btnMorning);
        btnMorning.setBounds(40, 20, 130, 40);

        btnEvening.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEvening.setText("Evening");
        btnEvening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEveningActionPerformed(evt);
            }
        });
        jPanel3.add(btnEvening);
        btnEvening.setBounds(40, 90, 130, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(20, 70, 210, 160);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 255));
        jLabel5.setText("Session");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 10, 90, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Correct Time");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(60, 280, 130, 40);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Late time");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(70, 350, 110, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(820, 120, 380, 540);

        btnCalculate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCalculate.setText("Month Salary ");
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });
        getContentPane().add(btnCalculate);
        btnCalculate.setBounds(820, 680, 140, 40);

        lblDec.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDec.setText("December");
        lblDec.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDecMouseClicked(evt);
            }
        });
        getContentPane().add(lblDec);
        lblDec.setBounds(560, 700, 90, 50);

        lblJan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJan.setText("January");
        lblJan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJanMouseClicked(evt);
            }
        });
        getContentPane().add(lblJan);
        lblJan.setBounds(20, 610, 80, 50);

        lblFeb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFeb.setText("February");
        lblFeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFebMouseClicked(evt);
            }
        });
        getContentPane().add(lblFeb);
        lblFeb.setBounds(130, 610, 80, 50);

        lblMar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMar.setText("March");
        lblMar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMarMouseClicked(evt);
            }
        });
        getContentPane().add(lblMar);
        lblMar.setBounds(230, 620, 80, 40);

        lblApr.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblApr.setText("April");
        lblApr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAprMouseClicked(evt);
            }
        });
        getContentPane().add(lblApr);
        lblApr.setBounds(320, 620, 70, 40);

        lblOct.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblOct.setText("October");
        lblOct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOctMouseClicked(evt);
            }
        });
        getContentPane().add(lblOct);
        lblOct.setBounds(330, 707, 80, 40);

        lblSep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSep.setText("September");
        lblSep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSepMouseClicked(evt);
            }
        });
        getContentPane().add(lblSep);
        lblSep.setBounds(210, 697, 100, 60);

        lblAug.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAug.setText("August");
        lblAug.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAugMouseClicked(evt);
            }
        });
        getContentPane().add(lblAug);
        lblAug.setBounds(120, 707, 80, 40);

        lblJuly.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJuly.setText("July");
        lblJuly.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJulyMouseClicked(evt);
            }
        });
        getContentPane().add(lblJuly);
        lblJuly.setBounds(20, 707, 90, 40);

        lblJune.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblJune.setText("June");
        lblJune.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblJuneMouseClicked(evt);
            }
        });
        getContentPane().add(lblJune);
        lblJune.setBounds(510, 620, 60, 40);

        lblMay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMay.setText("May");
        lblMay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMayMouseClicked(evt);
            }
        });
        getContentPane().add(lblMay);
        lblMay.setBounds(410, 620, 60, 40);

        lblNov.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNov.setText("November");
        lblNov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNovMouseClicked(evt);
            }
        });
        getContentPane().add(lblNov);
        lblNov.setBounds(440, 707, 90, 40);

        lbl21.setBackground(new java.awt.Color(204, 204, 204));
        lbl21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl21.setForeground(new java.awt.Color(0, 0, 255));
        lbl21.setText("2021");
        lbl21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl21MouseClicked(evt);
            }
        });
        getContentPane().add(lbl21);
        lbl21.setBounds(711, 600, 70, 30);

        lbl22.setBackground(new java.awt.Color(0, 51, 255));
        lbl22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lbl22.setForeground(new java.awt.Color(0, 0, 255));
        lbl22.setText("2022");
        lbl22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl22MouseClicked(evt);
            }
        });
        getContentPane().add(lbl22);
        lbl22.setBounds(711, 640, 70, 40);

        setSize(new java.awt.Dimension(1229, 813));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    System.exit(0);
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        sendToServer();
        JOptionPane.showMessageDialog(this, "Punching time inserted...");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnMorningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMorningActionPerformed

        shift = "Morning";
        JOptionPane.showMessageDialog(this, "Your Selection is:" + shift);
    }//GEN-LAST:event_btnMorningActionPerformed

    private void btnEveningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEveningActionPerformed

        shift = "Evening";
        JOptionPane.showMessageDialog(this, "Your Selection is:" + shift);
    }//GEN-LAST:event_btnEveningActionPerformed
    String loginTime = "Correct Time";
    String message = " ";

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loginTime = "Correct Time";
        JOptionPane.showMessageDialog(this, "Correct Time...");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        loginTime = "Late Time";
        message = "Please follow correct timings their own punches";
        JOptionPane.showMessageDialog(this, "Late Time...");
    }//GEN-LAST:event_jButton4ActionPerformed
    String year = "-2021";
    String month = "December";
    String date = month + year;
    
    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        String ds = "1";
        String total = "";
        try {
            int flag = 0;

            System.out.println("year:" + year);
            PreparedStatement ps = con.prepareStatement("select * from salary_details where home_guard_id='" + txtGuard.getText() + "' and salary_month_year='" + date + "' ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                flag = 1;
            }
            rs.close();
            int noWorkDays = 1;

            if (flag == 0) {
                System.out.println("in not");
                ps = con.prepareStatement("select count(id)as id from punching_time where home_guard_id='" + txtGuard.getText() + "' and month_year='" + date + "' ");
                rs = ps.executeQuery();
                if (rs.next()) {
                    noWorkDays = rs.getInt(1);
                    System.out.println("noWorkDays:" + noWorkDays);
                }
                rs.close();
                ps = null;
                ps = con.prepareStatement("select daily_salari from daily_salary where home_guard_id='" + txtGuard.getText() + "'");

                rs = ps.executeQuery();
                if (rs.next()) {
                    ds = "" + rs.getInt(1);
                    System.out.println("daily salary:" + ds);
                }
                int g = Integer.parseInt(ds) * noWorkDays;
                total = "" + g;
                System.out.println("total salary:" + g);

                ps = null;
                System.out.println("insert into salary_details values(null, '" + txtGuard.getText() + "'," + noWorkDays + ",'" + date + "','" + total + "' )");
                ps = con.prepareStatement("insert into salary_details values(null, '" + txtGuard.getText() + "'," + noWorkDays + ",'" + date + "','" + total + "' )");
                ps.execute();
                JOptionPane.showMessageDialog(this, "Salary Inserted...");

            } else {
                System.out.println("in yes");
                ps = con.prepareStatement("select count(id)as id from punching_time where home_guard_id='" + txtGuard.getText() + "' and month_year='" + date + "' ");
                rs = ps.executeQuery();
                if (rs.next()) {
                    noWorkDays = rs.getInt(1);
                    System.out.println("noWorkDays:" + noWorkDays);
                }
                rs.close();
                ps = null;
                ps = con.prepareStatement("select daily_salari from daily_salary where home_guard_id='" + txtGuard.getText() + "'");

                rs = ps.executeQuery();
                if (rs.next()) {
                    ds = "" + rs.getInt(1);
                    System.out.println("daily salary:" + ds);
                }
                int g = Integer.parseInt(ds) * noWorkDays;
                total = "" + g;
                System.out.println("total salary:" + g);

                System.out.println("update salary_details set total_working_days=" + noWorkDays + " ,total_amount='" + total + "' where  home_guard_id='" + txtGuard.getText() + "' and salary_month_year='" + date + "' ");

                ps = null;
                ps = con.prepareStatement("update salary_details set total_working_days=" + noWorkDays + " ,total_amount='" + total + "' where  home_guard_id='" + txtGuard.getText() + "' and salary_month_year='" + date + "' ");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Salary Updated...");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnCalculateActionPerformed

    private void lblJanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJanMouseClicked
         
        month = "January";
        date = month + year;
         JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblJanMouseClicked

    private void lblFebMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFebMouseClicked
         
        month = "February";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblFebMouseClicked

    private void lblMarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMarMouseClicked
         
        month = "March";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblMarMouseClicked

    private void lblAprMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAprMouseClicked
         
        month = "April";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblAprMouseClicked

    private void lblMayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMayMouseClicked
         
        month = "May";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblMayMouseClicked

    private void lblJuneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJuneMouseClicked
        
        month = "June";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblJuneMouseClicked

    private void lblJulyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblJulyMouseClicked
         
        month = "July";
        date = month + year;
        
    }//GEN-LAST:event_lblJulyMouseClicked

    private void lblAugMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAugMouseClicked
         
        month = "August";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblAugMouseClicked

    private void lblSepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSepMouseClicked
         
        month = "September";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblSepMouseClicked

    private void lblOctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOctMouseClicked
         
        month = "February";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblOctMouseClicked

    private void lblNovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNovMouseClicked
         
        month = "November";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblNovMouseClicked

    private void lblDecMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDecMouseClicked
         
        month = "December";
        date = month + year;
        JOptionPane.showMessageDialog(this, "Month..."+month);
    }//GEN-LAST:event_lblDecMouseClicked

    private void lbl21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl21MouseClicked
           year = "-2021";
           JOptionPane.showMessageDialog(this, "Year..."+year);
    }//GEN-LAST:event_lbl21MouseClicked

    private void lbl22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl22MouseClicked
        year = "-2022";
        JOptionPane.showMessageDialog(this, "Year..."+year);
    }//GEN-LAST:event_lbl22MouseClicked

    
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
            java.util.logging.Logger.getLogger(HomeGuardAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeGuardAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeGuardAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeGuardAttendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new HomeGuardAttendance().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnEvening;
    private javax.swing.JButton btnMorning;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbl21;
    private javax.swing.JLabel lbl22;
    private javax.swing.JLabel lblApr;
    private javax.swing.JLabel lblAug;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDec;
    private javax.swing.JLabel lblFeb;
    private javax.swing.JLabel lblJan;
    private javax.swing.JLabel lblJuly;
    private javax.swing.JLabel lblJune;
    private javax.swing.JLabel lblMar;
    private javax.swing.JLabel lblMay;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblNov;
    private javax.swing.JLabel lblOct;
    private javax.swing.JLabel lblSep;
    private javax.swing.JTextField txtGuard;
    // End of variables declaration//GEN-END:variables
}
