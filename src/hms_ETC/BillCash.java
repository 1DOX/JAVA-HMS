/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_ETC;


import javax.swing.JOptionPane;
import hms_FoodSystem.foodtrace;
import hms_FoodSystem.foodService;
import hms_Reservation.hotelGUI;

/**
 *
 * @author 송진영
 */
public class BillCash extends hmsDB_ETC {
int type;
String room_num;
int room_cost;
    /**
     * Creates new form BillCash
     */
    public BillCash(String a, int b) {
        initComponents();
        type = b;
        room_num = a;
        dbLoad();
        int roomF = getCost_Bill(room_num, "roomX");
        int foodF = getCost_Bill(room_num, "foodX");
        int foodtype;
        int coursetype;
        int coursepay = 0;
        room_cost = get_roomcost(room_num);
        
        if(type == 0)
        {
            jLabel2.setText(Integer.toString(room_cost));
        }
        else if(type == 1)
        {
            jLabel2.setText(Integer.toString(roomF+foodF));
        }
        else if(type == 2)
        {
            jLabel2.setText(Integer.toString(foodF));
        }
        else if(type >= 3)
        {
                if(type > 5) 
            {
                foodtype = 3;
                coursetype = type-5;
                coursepay = getfoodint("hmsfood", "foodtype", Integer.toString(foodtype), "food_"+coursetype+"_pay");
            }
            else if(type>2 && type <=5)
            {
                foodtype = 2;
                coursetype = type-2;
                coursepay = getfoodint("hmsfood", "foodtype", Integer.toString(foodtype), "food_"+coursetype+"_pay");
            }
                
            jLabel2.setText(Integer.toString(coursepay));
        }
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

        jLabel6 = new javax.swing.JLabel();
        TotalPriceLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ReceiveCashLabel = new javax.swing.JLabel();
        ReceiveCashField = new javax.swing.JTextField();
        PayButton = new javax.swing.JButton();
        SendCashLabel = new javax.swing.JLabel();
        SendCashField = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("현금결제");

        TotalPriceLabel.setText("결제 비용");

        jLabel2.setText(" ");

        ReceiveCashLabel.setText("받은 현금");

        ReceiveCashField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReceiveCashFieldActionPerformed(evt);
            }
        });

        PayButton.setText("계산");
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        SendCashLabel.setText("거스름돈");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PayButton)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(SendCashLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ReceiveCashLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TotalPriceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(ReceiveCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(SendCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalPriceLabel)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReceiveCashLabel)
                    .addComponent(ReceiveCashField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SendCashLabel)
                    .addComponent(SendCashField, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(PayButton)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        int roomF = getCost_Bill(room_num, "roomX");
        int foodF = getCost_Bill(room_num, "foodX");
        int foodtype = 0;
        int coursetype = 0;
        int coursepay = 0;
        if(type > 5) 
        {
            foodtype = 3;
            coursetype = type - 5;
            coursepay = getfoodint("hmsfood", "foodtype", Integer.toString(foodtype), "food_"+coursetype+"_pay");
        }
        else if(type >2 && type <= 5)
        {
            foodtype = 2;
            coursetype = type - 2;
            coursepay = getfoodint("hmsfood", "foodtype", Integer.toString(foodtype), "food_"+coursetype+"_pay");
        }

        int cash = Integer.parseInt(ReceiveCashField.getText());
        int sum = 0;
        if(type == 0)
        {
            sum = cash - room_cost;
            SendCashField.setText(Integer.toString(sum));
            JOptionPane.showMessageDialog(this, room_cost+"원이 결제되었습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new hotelGUI().setVisible(true);
        }
        if(type == 1 || type == -1)
        {
            sum = cash - (roomF+foodF);
            if(sum >= 0)
            {
                SendCashField.setText(Integer.toString(sum));
                JOptionPane.showMessageDialog(this, foodF+roomF+"원이 결제되었습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE); 
                Updateint("foodsystem", "payment", "room_num",room_num , foodF);
                Updatechange("foodsystem", "food_total_pay", "room_num",room_num , 0);
                Updateint("reservation", "payment", "room_num",room_num , roomF);
              dispose();
              if(type == 1) new Bill(room_num, 1).setVisible(true);
              else if(type == -1) new Bill(room_num, 0).setVisible(true);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "돈이 모자랍니다.", "메세지", JOptionPane.INFORMATION_MESSAGE); 
            }
            
        }
        else if(type == 2)
        {
            sum = cash - foodF;
            if(sum >= 0)
            {
                SendCashField.setText(Integer.toString(sum));
                for(int i=1; i<=6; i++)
              { 
                 Updatechange("foodsystem", "food_"+i+"_charge", "room_num", room_num, 0);
                 Updatechange("foodsystem", "food_service_"+i, "room_num", room_num, 0);
               }       
               JOptionPane.showMessageDialog(this, foodF+"원이 결제되었습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE); 
                 Updateint("foodsystem", "payment", "room_num",room_num , foodF);
                 Updatechange("foodsystem", "food_total_pay", "room_num",room_num , 0);
               dispose();
               new foodtrace().setVisible(true);
            }
            else JOptionPane.showMessageDialog(this, "돈이 모자랍니다.", "메세지", JOptionPane.INFORMATION_MESSAGE); 
            
        }
        else if(type >= 3)
        {
            sum = cash - coursepay;
            if(sum >= 0)
            {
               SendCashField.setText(Integer.toString(sum));
                JOptionPane.showMessageDialog(this, coursepay+"원이 결제되었습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            new foodService().setVisible(true);
            }
            else JOptionPane.showMessageDialog(this, "돈이 모자랍니다.", "메세지", JOptionPane.INFORMATION_MESSAGE); 
        }
        dbClose();
    }//GEN-LAST:event_PayButtonActionPerformed

    private void ReceiveCashFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReceiveCashFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReceiveCashFieldActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PayButton;
    private javax.swing.JTextField ReceiveCashField;
    private javax.swing.JLabel ReceiveCashLabel;
    private javax.swing.JLabel SendCashField;
    private javax.swing.JLabel SendCashLabel;
    private javax.swing.JLabel TotalPriceLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
