
package hms_Reservation;

import hms_Main.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class hms_Book_information extends hmsDB_Reservation {

    public void setRoomBox() throws SQLException {
        dbLoad();
        
        int row = db_getRow("booking");
        String room_num = null;
        
        for (int i = 0; i < row; i++) { //체크인하지 않은 방의 전체 갯수만큼 반복
            room_num = checkinnum(i);
            roomBox.addItem(room_num);
        }
        dbClose();
    }
    
    public hms_Book_information() throws SQLException {
        initComponents();
        dbLoad();
        setRoomBox();
        dbClose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toMainButton = new javax.swing.JButton();
        changeButton = new javax.swing.JButton();
        roomBox = new javax.swing.JComboBox<>();
        date_in = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        toMainButton.setBackground(new java.awt.Color(113, 113, 113));
        toMainButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        toMainButton.setForeground(new java.awt.Color(255, 255, 255));
        toMainButton.setText("메인으로");
        toMainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toMainButtonActionPerformed(evt);
            }
        });

        changeButton.setBackground(new java.awt.Color(113, 113, 113));
        changeButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        changeButton.setForeground(new java.awt.Color(255, 255, 255));
        changeButton.setText("예약 취소");
        changeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeButtonActionPerformed(evt);
            }
        });

        roomBox.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        jLabel10.setText("기존 체크인 날짜");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(roomBox, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_in, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(toMainButton)
                .addGap(18, 18, 18)
                .addComponent(changeButton)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(roomBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toMainButton)
                    .addComponent(changeButton))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void toMainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toMainButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hmsGUI().setVisible(true);
    }//GEN-LAST:event_toMainButtonActionPerformed

    private void changeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        
        var date = new Date();
        date = date_in.getDate();
        
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        
        String roombox_num = roomBox.getSelectedItem().toString();
        int idx = roombox_num.indexOf("("); 
        String room_num = roombox_num.substring(0, idx);
        System.out.println(room_num);
        
        if (!deleteBooking(room_num, date)) {
            JOptionPane.showMessageDialog(this, "날짜를 잘못 선택하셨습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new hms_Book_information().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "예약 취소 완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new hms_Book_information().setVisible(true);
        }
        dbClose();
    }//GEN-LAST:event_changeButtonActionPerformed

    private void roomBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomBoxActionPerformed
        // TODO add your handling code here:
        int room_num = roomBox.getSelectedIndex();
    }//GEN-LAST:event_roomBoxActionPerformed

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
            java.util.logging.Logger.getLogger(hms_Book_information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hms_Book_information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hms_Book_information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hms_Book_information.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hms_Book_information().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton changeButton;
    private com.toedter.calendar.JDateChooser date_in;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JComboBox<String> roomBox;
    private javax.swing.JButton toMainButton;
    // End of variables declaration//GEN-END:variables
}
