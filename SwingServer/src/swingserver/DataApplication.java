package swingserver;

import java.awt.List;
import java.awt.Toolkit;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DataApplication extends javax.swing.JFrame {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String userId = "";
    int tFlag = 0;

    public DataApplication() {
        super("File");
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_application", "root", "root");
            bindData();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void bindData() {
        try {
            ps = con.prepareStatement("select * from user_details");
            rs = ps.executeQuery();
            DefaultTableModel tableModel = buildTableModel(rs);
            jTable1.setModel(tableModel);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGender = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDept = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHours = new javax.swing.JTextField();
        txtRate1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnExport = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txtId4 = new javax.swing.JTextField();
        txtId6 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "JDBC Assignment", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ID:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 70, 60, 30);

        txtId.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtId);
        txtId.setBounds(170, 70, 200, 30);

        txtFirstName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtFirstName);
        txtFirstName.setBounds(170, 110, 200, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("First Name:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 110, 90, 17);

        txtLastName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtLastName);
        txtLastName.setBounds(170, 150, 200, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 150, 90, 17);

        txtAge.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtAge);
        txtAge.setBounds(170, 190, 200, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Age:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 190, 60, 20);

        txtGender.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtGender);
        txtGender.setBounds(170, 230, 200, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Gender:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 230, 80, 30);

        txtPosition.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtPosition);
        txtPosition.setBounds(170, 270, 200, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Position:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 270, 80, 30);

        txtDept.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtDept);
        txtDept.setBounds(170, 310, 200, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Department:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 310, 100, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Hours:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 390, 50, 30);

        txtHours.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtHours);
        txtHours.setBounds(170, 390, 200, 30);

        txtRate1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel1.add(txtRate1);
        txtRate1.setBounds(170, 350, 200, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Rate:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 350, 50, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 400, 460);

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(null);

        btnInsert.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel2.add(btnInsert);
        btnInsert.setBounds(29, 70, 120, 40);

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);
        btnDelete.setBounds(30, 140, 120, 40);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);
        btnUpdate.setBounds(30, 210, 120, 40);

        btnExport.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnExport.setText("Export");
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });
        jPanel2.add(btnExport);
        btnExport.setBounds(30, 280, 120, 40);

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel2.add(btnClear);
        btnClear.setBounds(30, 350, 120, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(400, 0, 190, 460);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Export Data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 204))); // NOI18N
        jPanel3.setLayout(null);

        jButton1.setText("ListAllPositions");
        jPanel3.add(jButton1);
        jButton1.setBounds(220, 130, 200, 40);

        jButton7.setText("NumLecturesForDepartment");
        jPanel3.add(jButton7);
        jButton7.setBounds(10, 30, 200, 40);

        jButton8.setText("AvgAgeForDepartment");
        jPanel3.add(jButton8);
        jButton8.setBounds(10, 80, 200, 40);

        jButton9.setText("ListAllDepartments");
        jPanel3.add(jButton9);
        jButton9.setBounds(10, 130, 200, 40);

        txtId4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel3.add(txtId4);
        txtId4.setBounds(220, 80, 200, 40);

        txtId6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jPanel3.add(txtId6);
        txtId6.setBounds(220, 30, 200, 40);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 460, 590, 180);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Database Content", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel4.setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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
        jTable1.setGridColor(new java.awt.Color(204, 204, 255));
        jTable1.setRowMargin(2);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 840, 330);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(590, 0, 860, 640);

        setSize(new java.awt.Dimension(1471, 692));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed

        if (txtId.getText().length() > 0 && txtFirstName.getText().length() > 0 && txtLastName.getText().length() > 0 && txtAge.getText().length() > 0 && txtGender.getText().length() > 0 && txtPosition.getText().length() > 0 && txtDept.getText().length() > 0 && txtRate1.getText().length() > 0 && txtHours.getText().length() > 0) {
            try {
                int flag = 0;
                ps = con.prepareStatement("select * from user_details where id='" + txtId.getText() + "' ");
                rs = ps.executeQuery();
                if (rs.next()) {
                    flag = 1;
                }
                rs.close();

                if (flag == 0) {
                    ps = con.prepareStatement("insert into user_details values('" + txtId.getText() + "','" + txtFirstName.getText() + "','" + txtLastName.getText() + "','" + txtAge.getText() + "','" + txtGender.getText() + "','" + txtPosition.getText() + "','" + txtDept.getText() + "','" + txtRate1.getText() + "','" + txtHours.getText() + "') ");
                    ps.execute();
                    System.out.println("Insertion done");
                    JOptionPane.showMessageDialog(this, "Insertion done...!");
                } else {
                    JOptionPane.showMessageDialog(this, "Id already exits...!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Enter Details...!");
        }

        try {
            ps = con.prepareStatement("select * from user_details");
            rs = ps.executeQuery();
            DefaultTableModel tableModel = buildTableModel(rs);
            jTable1.setModel(tableModel);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnInsertActionPerformed
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tFlag == 1) {
            int input = JOptionPane.showConfirmDialog(null, "Are you want to delete this item ?");
            System.out.println("select is:" + input);
            if (input == 0) {
                try {
                    ps = con.prepareStatement("delete from user_details where id='" + userId + "' ");
                    int f = ps.executeUpdate();
                    if (f == 1) {
                        JOptionPane.showMessageDialog(this, "Data Deleted...!");
                        System.out.println("deleted ");
                        tFlag = 0;
                        bindData();
                    } else {
                        JOptionPane.showMessageDialog(this, "No Such Id...!");
                        System.out.println("no such id");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(DataApplication.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Select any row...!");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        txtId.setText("");
        txtFirstName.setText("");
        txtLastName.setText("");
        txtAge.setText("");
        txtGender.setText("");
        txtPosition.setText("");
        txtDept.setText("");
        txtRate1.setText("");
        txtHours.setText("");
        tFlag = 0;
    }//GEN-LAST:event_btnClearActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int row = jTable1.rowAtPoint(evt.getPoint());
        int column = jTable1.columnAtPoint(evt.getPoint());
        userId = jTable1.getModel().getValueAt(row, 0) + "";
        System.out.println(userId);
        tFlag = 1;

        try {
            ps = con.prepareStatement("select * from user_details where id='" + userId + "' ");
            rs = ps.executeQuery();
            if (rs.next()) {
                txtId.setText(rs.getString(1));
                txtFirstName.setText(rs.getString(2));
                txtLastName.setText(rs.getString(3));
                txtAge.setText(rs.getString(4));
                txtGender.setText(rs.getString(5));
                txtPosition.setText(rs.getString(6));
                txtDept.setText(rs.getString(7));
                txtRate1.setText(rs.getString(8));
                txtHours.setText(rs.getString(9));
            }
            rs.close();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

        try {
            ps = con.prepareStatement("update user_details set first_name='" + txtFirstName.getText() + "' , last_name='" + txtLastName.getText() + "',age='" + txtAge.getText() + "',gender='" + txtGender.getText() + "',position='" + txtPosition.getText() + "',department='" + txtDept.getText() + "',rate='" + txtRate1.getText() + "',hours='" + txtHours.getText() + "' where id='" + userId + "'  ");
            ps.executeUpdate();
            bindData();
        } catch (SQLException ex) {
            Logger.getLogger(DataApplication.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed

        writeData();
    }//GEN-LAST:event_btnExportActionPerformed
    void writeData() {
        try {
            PrintWriter writer = new PrintWriter("d:\\test.csv");
            StringBuilder sb = new StringBuilder();
            sb.append("Id");
            sb.append(',');
            sb.append("First name");
            sb.append(',');
            sb.append("Last name");
            sb.append(',');
            sb.append("Age");
            sb.append(',');
            sb.append("Gender");
            sb.append(',');
            sb.append("Position");
            sb.append(',');
            sb.append("Department");
            sb.append(',');
            sb.append("Rate");
            sb.append(',');
            sb.append("Hours");
            sb.append('\n');

            ps = con.prepareStatement("select * from user_details");
            rs = ps.executeQuery();

            while (rs.next()) {
                sb.append(rs.getString(1));
                sb.append(',');
                sb.append(rs.getString(2));
                sb.append(',');
                sb.append(rs.getString(3));
                sb.append(',');
                sb.append(rs.getString(4));
                sb.append(',');
                sb.append(rs.getString(5));
                sb.append(',');
                sb.append(rs.getString(6));
                sb.append(',');
                sb.append(rs.getString(7));
                sb.append(',');
                sb.append(rs.getString(8));
                sb.append(',');
                sb.append(rs.getString(9));
                sb.append('\n');

            }

            writer.write(sb.toString());
            System.out.println("done!");
            writer.close();
            JOptionPane.showMessageDialog(this, "CSV File Created...!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


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
            java.util.logging.Logger.getLogger(DataApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataApplication().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtDept;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtGender;
    private javax.swing.JTextField txtHours;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtId4;
    private javax.swing.JTextField txtId6;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPosition;
    private javax.swing.JTextField txtRate1;
    // End of variables declaration//GEN-END:variables
}
