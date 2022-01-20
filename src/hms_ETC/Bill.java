/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_ETC;

import hms_Reservation.hmsCheckout;
import hms_Reservation.hotelGUI;
import hms_Main.hmsDB;
import javax.swing.JOptionPane;

/**
 *
 * @author 송진영
 */
public class Bill extends hmsDB_ETC {

    /**
     * Creates new form Bill
     */
    int choice = 0;
    String room;
    int Billtype;
    public Bill(String room_num, int type) {
        initComponents();
        
        dbLoad();
        Billtype = type;
        int roomF = getCost_Bill(room_num, "roomX");
        int roomT = getCost_Bill(room_num, "roomTotal");
        int roomO = getCost_Bill(room_num, "roomO");
        int foodF = getCost_Bill(room_num, "foodX");
        int foodO = getCost_Bill(room_num, "foodO");
        int foodT = getCost_Bill(room_num, "foodTotal");
        int totalX = getCost_Bill(room_num, "totalX");
        String room = room_num;
        nameField.setText(searchNAME(room_num));
        roomField.setText(room_num);
        roomFField.setText(roomF + " 원");
        roomTField.setText(roomT + " 원");
        roomOField.setText(roomO + " 원");
        foodFField.setText(foodF + " 원");
        foodTField.setText(foodT + " 원");
        foodOField.setText(foodO + " 원");
        totalField.setText(totalX + " 원");
        
        buttonGroup1.add(jRadioButton1);
        buttonGroup1.add(jRadioButton2);
        dbClose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        totalRoomLabel = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        roomnum = new javax.swing.JLabel();
        roomOLabel = new javax.swing.JLabel();
        roomXLabel = new javax.swing.JLabel();
        totalFoodLabel = new javax.swing.JLabel();
        foodOLabel = new javax.swing.JLabel();
        foodXLabel = new javax.swing.JLabel();
        totalXLabel = new javax.swing.JLabel();
        roomTField = new javax.swing.JLabel();
        foodFField = new javax.swing.JLabel();
        foodOField = new javax.swing.JLabel();
        foodTField = new javax.swing.JLabel();
        totalField = new javax.swing.JLabel();
        roomFField = new javax.swing.JLabel();
        roomOField = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        roomField = new javax.swing.JLabel();
        payButton = new javax.swing.JButton();
        payButton2 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("청구서");

        jLabel1.setFont(new java.awt.Font("맑은 고딕", 1, 14)); // NOI18N
        jLabel1.setText("청구서");

        totalRoomLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        totalRoomLabel.setText("총 객실 비용:");

        name.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        name.setText("이름: ");

        roomnum.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomnum.setText("방 번호: ");

        roomOLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomOLabel.setText("결제 완료 금액:");

        roomXLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomXLabel.setText("미결제 금액:");

        totalFoodLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        totalFoodLabel.setText("총 식품 비용:");

        foodOLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        foodOLabel.setText("결제 완료 금액:");

        foodXLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        foodXLabel.setText("미결제 금액:");

        totalXLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        totalXLabel.setText("총 결제할 금액:");

        roomTField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomTField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roomTField.setText("      ");

        foodFField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        foodFField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        foodFField.setText("      ");

        foodOField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        foodOField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        foodOField.setText("      ");

        foodTField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        foodTField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        foodTField.setText("      ");

        totalField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        totalField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalField.setText("      ");

        roomFField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomFField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roomFField.setText("      ");

        roomOField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomOField.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        roomOField.setText("      ");

        nameField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        nameField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        nameField.setText("      ");

        roomField.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        roomField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        roomField.setText("      ");

        payButton.setBackground(new java.awt.Color(255, 255, 255));
        payButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        payButton.setText("결제");
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        payButton2.setBackground(new java.awt.Color(255, 255, 255));
        payButton2.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        payButton2.setText("뒤로가기");
        payButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButton2ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("카드");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("현금");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(33, 33, 33)
                        .addComponent(payButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(payButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalRoomLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(roomOLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(roomXLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalFoodLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(foodOLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(foodXLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalXLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodFField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodOField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(foodTField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomFField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomOField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomTField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(roomnum)
                                .addGap(34, 34, 34)
                                .addComponent(roomField, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(roomnum)
                    .addComponent(nameField)
                    .addComponent(roomField))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(totalRoomLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomTField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomOLabel)
                    .addComponent(roomOField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(roomXLabel)
                    .addComponent(roomFField))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalFoodLabel)
                    .addComponent(foodTField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foodOLabel)
                    .addComponent(foodOField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(foodFField)
                    .addComponent(foodXLabel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalXLabel)
                    .addComponent(totalField))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(payButton)
                    .addComponent(payButton2))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButtonActionPerformed
        // TODO add your handling code here:
        String room_num;
        room_num = roomField.getText();
        if(choice == 0)
        {
            JOptionPane.showMessageDialog(this, "결제 수단을 선택해주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE); 
        }
        else
        {
            if (choice == 1) {
            dbLoad();
            String card_num = Card_num(room_num);

            if (card_num.isEmpty()) {
                dispose();
                if(Billtype ==0)
                {
                    new BillCard(null, room_num,-1).setVisible(true);
                }
                else if(Billtype == 1)
                {
                    new BillCard(null, room_num,1).setVisible(true);
                }
                
            }else{
                
                dispose();
                if(Billtype ==0)
                {
                    new BillCard(card_num, room_num,-1).setVisible(true);
                }
                else if(Billtype == 1)
                {
                    new BillCard(card_num, room_num,1).setVisible(true);
                }
            }
          
           }
            else if(choice == 2)
            {
                dispose();
                if(Billtype ==0)
                {
                    new BillCash(room_num,-1).setVisible(true);
                }
                else if(Billtype == 1)
                {
                    new BillCash(room_num,1).setVisible(true);
                }
            }
        }
        dbClose();
    }//GEN-LAST:event_payButtonActionPerformed

    private void payButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payButton2ActionPerformed
        // TODO add your handling code here:
        String room_num = roomField.getText();
        dbLoad();
            int totalX = getCost_Bill(room_num, "totalX");
            if(Billtype ==0)
            {
                dispose();
                new hotelGUI().setVisible(true);
            }
            else if(Billtype == 1)
            {
                if(totalX != 0) JOptionPane.showMessageDialog(this, "결제를 진행해주세요.", "메세지", JOptionPane.INFORMATION_MESSAGE);
                else
                {
                    JOptionPane.showMessageDialog(this, room_num+"번 방이 체크아웃 되었습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
                    String reser = searchreser(room_num);
                    CheckOut(room_num ,reser);
                    dispose();
                    new hmsCheckout().setVisible(true);
                }
            }
            
            dbClose();
         

    }//GEN-LAST:event_payButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        choice = 1;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        choice = 2;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel foodFField;
    private javax.swing.JLabel foodOField;
    private javax.swing.JLabel foodOLabel;
    private javax.swing.JLabel foodTField;
    private javax.swing.JLabel foodXLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameField;
    private javax.swing.JButton payButton;
    private javax.swing.JButton payButton2;
    private javax.swing.JLabel roomFField;
    private javax.swing.JLabel roomField;
    private javax.swing.JLabel roomOField;
    private javax.swing.JLabel roomOLabel;
    private javax.swing.JLabel roomTField;
    private javax.swing.JLabel roomXLabel;
    private javax.swing.JLabel roomnum;
    private javax.swing.JLabel totalField;
    private javax.swing.JLabel totalFoodLabel;
    private javax.swing.JLabel totalRoomLabel;
    private javax.swing.JLabel totalXLabel;
    // End of variables declaration//GEN-END:variables
}
