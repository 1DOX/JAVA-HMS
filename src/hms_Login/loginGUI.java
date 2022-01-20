package hms_Login;

import hms_Main.hmsGUI;
import javax.swing.JOptionPane;

public class loginGUI extends hmsDB_Login {
    
    int count = 1;

    public loginGUI() {
        initComponents();
        count++;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDTextField = new javax.swing.JTextField();
        LoginButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        IDLabel = new javax.swing.JLabel();
        PWLabel = new javax.swing.JLabel();
        PWTextField = new javax.swing.JPasswordField();
        HotemLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        IDTextField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        IDTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDTextFieldActionPerformed(evt);
            }
        });

        LoginButton.setBackground(new java.awt.Color(113, 113, 113));
        LoginButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        LoginButton.setForeground(new java.awt.Color(255, 255, 255));
        LoginButton.setText("로그인");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        ResetButton.setBackground(new java.awt.Color(70, 70, 70));
        ResetButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        ResetButton.setForeground(new java.awt.Color(255, 255, 255));
        ResetButton.setText("초기화");
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        IDLabel.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        IDLabel.setText("ID");

        PWLabel.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        PWLabel.setText("PW");

        PWTextField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N

        HotemLabel.setFont(new java.awt.Font("Myanmar Text", 1, 14)); // NOI18N
        HotemLabel.setText("HOTEL MANAGEMENT SYSTEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(76, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(HotemLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IDLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PWLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ResetButton))
                            .addComponent(IDTextField)
                            .addComponent(PWTextField))))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(HotemLabel)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PWTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PWLabel))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ResetButton)
                    .addComponent(LoginButton))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void IDTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDTextFieldActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        // 로그인
        dbLoad();
        String ID = IDTextField.getText();
        String a = IDTextField.getText();
        String b = new String(PWTextField.getPassword());
        if(count==2){
            parametas p = new parametas();
            p.nowID = a;
            p.nowPW = b;
        }
        boolean login = false;
        boolean isadmin = false;
        login = getDB(a, b);
        isadmin = isAdmin(ID);
        if (login) {

            dispose();
            isAdmin(ID);
            if (isadmin) {
                JOptionPane.showMessageDialog(this, "대표님 안녕하세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "직원으로 로그인 하였습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            }
            new hmsGUI().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "로그인에 실패하셨습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_LoginButtonActionPerformed

    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        //초기화
        IDTextField.setText(null);
        PWTextField.setText(null);
    }//GEN-LAST:event_ResetButtonActionPerformed

    /*public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login0().setVisible(true);
            }
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HotemLabel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JTextField IDTextField;
    private javax.swing.JButton LoginButton;
    private javax.swing.JLabel PWLabel;
    private javax.swing.JPasswordField PWTextField;
    private javax.swing.JButton ResetButton;
    // End of variables declaration//GEN-END:variables
}
