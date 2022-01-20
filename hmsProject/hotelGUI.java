package hmsProject;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class hotelGUI extends javax.swing.JFrame {
        public void booking_List() {
        hmsDB a = new hmsDB();
        ArrayList<dataROOM> room = a.bookingList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[21];
        for (int i = 0; i < room.size(); i++) {
            row[0] = room.get(i).getRoom_num();
            row[1] = room.get(i).getName();
            row[2] = room.get(i).getAddress();
            row[3] = room.get(i).getPhonenum();
            row[4] = room.get(i).getMember();
            row[5] = room.get(i).getDefault_price();
            row[6] = room.get(i).getRate_desc();
            row[7] = room.get(i).isGuarantee();
            row[8] = room.get(i).getCard_num();
            row[9] = room.get(i).getNumber();
            row[10] = room.get(i).getAutoCancleDate();
            row[11] = room.get(i).getRealCIdate();
            row[12] = room.get(i).getRealCItime();
            row[13] = room.get(i).getGuessCIdate();
            row[14] = room.get(i).getGuessCItime();
            row[15] = room.get(i).getRealCOdate();
            row[16] = room.get(i).getRealCOtime();
            row[17] = room.get(i).getFeedback();
            row[18] = room.get(i).isIsPay();
            row[19] = room.get(i).getPayType();
            row[20] = room.get(i).getTotalPrice();
            model.addRow(row);
        }
    }

    public void show_room(String v) {
        hmsDB a = new hmsDB();
        dataROOM room = a.roomIndex(v);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[21];
        row[0] = room.getRoom_num();
        row[1] = room.getName();
        row[2] = room.getAddress();
        row[3] = room.getPhonenum();
        row[4] = room.getMember();
        row[5] = room.getDefault_price();
        row[6] = room.getRate_desc();
        row[7] = room.isGuarantee();
        row[8] = room.getCard_num();
        row[9] = room.getNumber();
        row[10] = room.getAutoCancleDate();
        row[11] = room.getRealCIdate();
        row[12] = room.getRealCItime();
        row[13] = room.getGuessCIdate();
        row[14] = room.getGuessCItime();
        row[15] = room.getRealCOdate();
        row[16] = room.getRealCOtime();
        row[17] = room.getFeedback();
        row[18] = room.isIsPay();
        row[19] = room.getPayType();
        row[20] = room.getTotalPrice();
        model.addRow(row);
    }

    public void show_room() {
        hmsDB a = new hmsDB();
        ArrayList<dataROOM> room = a.roomList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[21];
        for (int i = 0; i < room.size(); i++) {
            row[0] = room.get(i).getRoom_num();
            row[1] = room.get(i).getName();
            row[2] = room.get(i).getAddress();
            row[3] = room.get(i).getPhonenum();
            row[4] = room.get(i).getMember();
            row[5] = room.get(i).getDefault_price();
            row[6] = room.get(i).getRate_desc();
            row[7] = room.get(i).isGuarantee();
            row[8] = room.get(i).getCard_num();
            row[9] = room.get(i).getNumber();
            row[10] = room.get(i).getAutoCancleDate();
            row[11] = room.get(i).getRealCIdate();
            row[12] = room.get(i).getRealCItime();
            row[13] = room.get(i).getGuessCIdate();
            row[14] = room.get(i).getGuessCItime();
            row[15] = room.get(i).getRealCOdate();
            row[16] = room.get(i).getRealCOtime();
            row[17] = room.get(i).getFeedback();
            row[18] = room.get(i).isIsPay();
            row[19] = room.get(i).getPayType();
            row[20] = room.get(i).getTotalPrice();
            model.addRow(row);
        }
    }

    public hotelGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "방 번호", "고객명", "주소", "전화번호", "인원 수", "객실 요금", "요금 설명", "보증 여부", "신용카드 번호", "자동 취소일자", "체크인 일정", "예상 체크인 시간", "실제 체크인 날짜", "실제 체크인 날싸", "실제 체크인 시간", "체크아웃 일정", "예상 체크아웃 시간", "실제 체크아웃 날짜", "수령한 지불", "결제 유형", "총 결제 금액"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("체크인");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("체크아웃");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("식품 추적");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("결제");
        jButton5.setToolTipText("");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("식당 및 룸서비스");

        jTextField1.setText("방 번호를 입력해주세요.");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setText("전체조회");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton6.setText("검색");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setText("뒤로가기");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("예약조회");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6))
                    .addComponent(jButton1)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 762, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jButton5)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jButton7))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
        new isReservation().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(new DefaultTableModel(null, new String[]{"방 번호", "고객명", "주소", "전화번호", "인원 수", "객실 요금", "요금 설명", "보증 여부", "신용카드 번호", "자동 취소일자", "체크인 일정",
            "예상 체크인 시간", "실제 체크인 날짜", "실제 체크인 날싸", "실제 체크인 시간", "체크아웃 일정", "예상 체크아웃 시간", "실제 체크아웃 날짜", "수령한 지불", "결제 유형", "총 결제 금액"}));
        show_room();
           JOptionPane.showMessageDialog(this, "갱신 완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        String Room_num = jTextField1.getText();
        hmsDB s = new hmsDB();
        s.dbLoad();

        if (Room_num.equals(null)) {
            JOptionPane.showMessageDialog(this, "방 번호를 입력하지 않았습니다. 입력 후 체크아웃 버튼을 눌러주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        } else if (s.CheckOut(Room_num) == false) {
            JOptionPane.showMessageDialog(this, "체크아웃 하려는 방을 찾을 수 없습니다. 확인 후 다시 체크아웃 해주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        } else {
            s.CheckOut(Room_num);
            JOptionPane.showMessageDialog(this, "체크아웃 하였습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        String Room_num = jTextField1.getText();

        hmsDB s = new hmsDB();
        s.dbLoad();
        if (Room_num.isEmpty()) {
            JOptionPane.showMessageDialog(this, "방 번호를 입력하하지 않았습니다. 입력 후 조회 버튼을 눌러주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        } else if (s.searchROOM(Room_num) == false) {
            JOptionPane.showMessageDialog(this, "조회 하려는 방을 찾을 수 없습니다. 확인 후 다시 체크아웃 해주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.show_room(Room_num);
            JOptionPane.showMessageDialog(this, Room_num +"호 조회완료.", "메세지", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        dispose();
        new hmsGUI().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        jTable1.setModel(new DefaultTableModel(null, new String[]{"방 번호", "고객명", "주소", "전화번호", "인원 수", "객실 요금", "요금 설명", "보증 여부", "신용카드 번호", "자동 취소일자", "체크인 일정",
            "예상 체크인 시간", "실제 체크인 날짜", "실제 체크인 날싸", "실제 체크인 시간", "체크아웃 일정", "예상 체크아웃 시간", "실제 체크아웃 날짜", "수령한 지불", "결제 유형", "총 결제 금액"}));
        booking_List();
        JOptionPane.showMessageDialog(this, "갱신 완료", "메세지", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(hotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hotelGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hotelGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
