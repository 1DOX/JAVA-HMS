package hms_Reservation;

import hms_Main.hmsGUI;
import hms_Main.hmsDB;
import javax.swing.JOptionPane;


public class Guarantee extends hmsDB_Booking {

    String numbers;
    
    public Guarantee(String a) {
        initComponents();
        this.numbers = a;
    }
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InsertButton = new javax.swing.JButton();
        Cardnum1Field = new javax.swing.JTextField();
        Cardnum2Field = new javax.swing.JTextField();
        Cardnum3Field = new javax.swing.JTextField();
        Cardnum4Field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("보증");

        InsertButton.setText("입력");
        InsertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cardnum1Field, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardnum2Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardnum3Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cardnum4Field, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(InsertButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InsertButton)
                    .addComponent(Cardnum1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cardnum2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cardnum3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cardnum4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InsertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        String card_num = Cardnum1Field.getText() + '-' + Cardnum2Field.getText() + '-' + Cardnum3Field.getText() + '-' +Cardnum4Field.getText();
        int len = card_num.length();
        if(len != 19){
            JOptionPane.showMessageDialog(this, "카드번호를 잘못 입력하였습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }else {
            CICard_num(numbers, card_num);
            JOptionPane.showMessageDialog(this, "보증등록이 완료되었습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new hmsCheckinT().setVisible(true);
        }
        dbClose();
    }//GEN-LAST:event_InsertButtonActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Cardnum1Field;
    private javax.swing.JTextField Cardnum2Field;
    private javax.swing.JTextField Cardnum3Field;
    private javax.swing.JTextField Cardnum4Field;
    private javax.swing.JButton InsertButton;
    // End of variables declaration//GEN-END:variables
}
