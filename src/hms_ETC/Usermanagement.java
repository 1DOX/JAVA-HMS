package hms_ETC;

import hms_Main.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usermanagement extends hmsDB_ETC {

    public Usermanagement() {
        initComponents();
    }

    public void show_user() {
        hmsDB a = new hmsDB();
        ArrayList<dataUSER> list = userList();
        DefaultTableModel model = (DefaultTableModel) IDListTable.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getUserID();
            row[1] = list.get(i).getUserPW();
            row[2] = list.get(i).getisAdmin();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GoBackButton = new javax.swing.JButton();
        IDField = new javax.swing.JTextField();
        IDLabel = new javax.swing.JLabel();
        PWLabel = new javax.swing.JLabel();
        CreateButton = new javax.swing.JButton();
        PWField = new javax.swing.JPasswordField();
        DeleteButton = new javax.swing.JButton();
        IDListScrollPane = new javax.swing.JScrollPane();
        IDListTable = new javax.swing.JTable();
        SearchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("사용자 관리");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        GoBackButton.setBackground(new java.awt.Color(70, 70, 70));
        GoBackButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        GoBackButton.setForeground(new java.awt.Color(255, 255, 255));
        GoBackButton.setText("뒤로가기");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });

        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });

        IDLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        IDLabel.setText("아이디");

        PWLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        PWLabel.setText("비밀번호");

        CreateButton.setBackground(new java.awt.Color(113, 113, 113));
        CreateButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        CreateButton.setForeground(new java.awt.Color(255, 255, 255));
        CreateButton.setText("생성");
        CreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(113, 113, 113));
        DeleteButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteButton.setText("삭제");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        IDListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserID", "UserPW", "isAdmin"
            }
        ));
        IDListTable.setAutoscrolls(false);
        IDListScrollPane.setViewportView(IDListTable);

        SearchButton.setBackground(new java.awt.Color(113, 113, 113));
        SearchButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("조회");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(IDListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(IDLabel)
                                    .addGap(28, 28, 28))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(PWLabel)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PWField, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                                .addComponent(IDField))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CreateButton)
                                .addComponent(DeleteButton))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(SearchButton)
                        .addGap(90, 90, 90)
                        .addComponent(GoBackButton)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDLabel)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DeleteButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateButton)
                    .addComponent(PWField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PWLabel))
                .addGap(18, 18, 18)
                .addComponent(IDListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchButton)
                    .addComponent(GoBackButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hmsGUI().setVisible(true);
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDFieldActionPerformed

    private void CreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateButtonActionPerformed
        // TODO add your handling code here: 
        String UserID = IDField.getText();
        String UserPW = new String(PWField.getPassword());
        int isAdmin = 0;
        dbLoad();
        boolean Serach = serachID(UserID);
        if (UserID.isEmpty()) {
            JOptionPane.showMessageDialog(this, "생성하려는 아이디가 입력되지 않았습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (Serach) {
                JOptionPane.showMessageDialog(this, "중복되는 아이디가 있습니다. 다른 아이디를 입력해주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            } else {
                update(UserID, UserPW, isAdmin);
                JOptionPane.showMessageDialog(this, "아이디 생성 완료.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        dbClose();
    }//GEN-LAST:event_CreateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        // TODO add your handling code here:
        String UserID = IDField.getText();
        dbLoad();
        boolean Serach = serachID(UserID);
        if (Serach) {
            DeleteID(UserID);
            JOptionPane.showMessageDialog(this, "아이디 삭제 완료.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(this, "삭제하려는 아이디를 찾을 수 없습니다. 확인 후 다시 입력해 주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);

        }

        dbClose();
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        IDListTable.setModel(new DefaultTableModel(null, new String[]{"UserID", "UserPW", "isAdmin"}));
        show_user();
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentHidden

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
            java.util.logging.Logger.getLogger(Usermanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Usermanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Usermanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Usermanagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Usermanagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JTextField IDField;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JScrollPane IDListScrollPane;
    private javax.swing.JTable IDListTable;
    private javax.swing.JPasswordField PWField;
    private javax.swing.JLabel PWLabel;
    private javax.swing.JButton SearchButton;
    // End of variables declaration//GEN-END:variables

}
