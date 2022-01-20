package hms_Main;

import hms_Login.loginGUI;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Timer;
import java.util.TimerTask;
import java.util.AbstractCollection;
import hms_Reservation.hotelGUI;
import hms_Login.parametas;
import hms_ETC.Usermanagement;
import hms_Reservation.hms_Customer_information;
import hms_ETC.hmsText;
import hms_ETC.roompayChange;
import hms_FoodSystem.foodChange;
import hms_Reservation.hms_Book_information;


public class hmsGUI extends hmsDB {

    public hmsGUI() {
        initComponents();
        Thread t1 = new Thread(new hotelTimer());
        t1.start();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        RoomManageButton = new javax.swing.JButton();
        ReportButton = new javax.swing.JButton();
        CustomerInformButton = new javax.swing.JButton();
        UserManageButton = new javax.swing.JButton();
        ExitButton = new javax.swing.JButton();
        UserChangeButton = new javax.swing.JButton();
        RoomPayButton = new javax.swing.JButton();
        FoodMenuButton = new javax.swing.JButton();
        hotelTimerLabel = new javax.swing.JLabel();
        ReserCancleButton = new javax.swing.JButton();
        PresentTimeLabel = new javax.swing.JLabel();
        HotelLabel = new javax.swing.JLabel();

        jButton6.setText("jButton6");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("시스템 메인");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        RoomManageButton.setBackground(new java.awt.Color(113, 113, 113));
        RoomManageButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        RoomManageButton.setForeground(new java.awt.Color(255, 255, 255));
        RoomManageButton.setText("객실 조회 및 관리");
        RoomManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomManageButtonActionPerformed(evt);
            }
        });

        ReportButton.setBackground(new java.awt.Color(113, 113, 113));
        ReportButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        ReportButton.setForeground(new java.awt.Color(255, 255, 255));
        ReportButton.setText("보고서");
        ReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportButtonActionPerformed(evt);
            }
        });

        CustomerInformButton.setBackground(new java.awt.Color(113, 113, 113));
        CustomerInformButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        CustomerInformButton.setForeground(new java.awt.Color(255, 255, 255));
        CustomerInformButton.setText("고객 정보 수정");
        CustomerInformButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerInformButtonActionPerformed(evt);
            }
        });

        UserManageButton.setBackground(new java.awt.Color(113, 113, 113));
        UserManageButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        UserManageButton.setForeground(new java.awt.Color(255, 255, 255));
        UserManageButton.setText("사용자 관리");
        UserManageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserManageButtonActionPerformed(evt);
            }
        });

        ExitButton.setBackground(new java.awt.Color(70, 70, 70));
        ExitButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        ExitButton.setForeground(new java.awt.Color(255, 255, 255));
        ExitButton.setText("종료");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });

        UserChangeButton.setBackground(new java.awt.Color(70, 70, 70));
        UserChangeButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        UserChangeButton.setForeground(new java.awt.Color(255, 255, 255));
        UserChangeButton.setText("사용자 전환");
        UserChangeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserChangeButtonActionPerformed(evt);
            }
        });

        RoomPayButton.setBackground(new java.awt.Color(113, 113, 113));
        RoomPayButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        RoomPayButton.setForeground(new java.awt.Color(255, 255, 255));
        RoomPayButton.setText("객실 가격 수정");
        RoomPayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomPayButtonActionPerformed(evt);
            }
        });

        FoodMenuButton.setBackground(new java.awt.Color(113, 113, 113));
        FoodMenuButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        FoodMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        FoodMenuButton.setText("메뉴 항목 수정");
        FoodMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodMenuButtonActionPerformed(evt);
            }
        });

        hotelTimerLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        hotelTimerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hotelTimerLabel.setText("시간 라벨");

        ReserCancleButton.setBackground(new java.awt.Color(113, 113, 113));
        ReserCancleButton.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        ReserCancleButton.setForeground(new java.awt.Color(255, 255, 255));
        ReserCancleButton.setText("예약 취소");
        ReserCancleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReserCancleButtonActionPerformed(evt);
            }
        });

        PresentTimeLabel.setFont(new java.awt.Font("맑은 고딕", 0, 12)); // NOI18N
        PresentTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PresentTimeLabel.setText("현재 시간");

        HotelLabel.setFont(new java.awt.Font("맑은 고딕", 1, 18)); // NOI18N
        HotelLabel.setText("HOTEL MANAGEMENT SYSTEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(RoomManageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CustomerInformButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UserManageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(UserChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(ExitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(RoomPayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FoodMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReserCancleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(hotelTimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addComponent(HotelLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(PresentTimeLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(HotelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PresentTimeLabel)
                .addGap(14, 14, 14)
                .addComponent(hotelTimerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(RoomManageButton)
                .addGap(18, 18, 18)
                .addComponent(CustomerInformButton)
                .addGap(18, 18, 18)
                .addComponent(RoomPayButton)
                .addGap(18, 18, 18)
                .addComponent(FoodMenuButton)
                .addGap(18, 18, 18)
                .addComponent(ReserCancleButton)
                .addGap(18, 18, 18)
                .addComponent(ReportButton)
                .addGap(18, 18, 18)
                .addComponent(UserManageButton)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserChangeButton)
                    .addComponent(ExitButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RoomManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomManageButtonActionPerformed
        // TODO add your handling code here:
        hotelGUI gui = new hotelGUI();
        dispose();
        gui.setVisible(true);
    }//GEN-LAST:event_RoomManageButtonActionPerformed

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        System.exit(0);
        dbClose();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void UserChangeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserChangeButtonActionPerformed
        dispose();
        new loginGUI().setVisible(true);
    }//GEN-LAST:event_UserChangeButtonActionPerformed

    private void UserManageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserManageButtonActionPerformed

        dbLoad();

        var ID = parametas.getNowID();
        System.out.println(ID);
        boolean isadmin = false;
        isadmin = isAdmin(ID);
        if (isadmin) {
            dispose();
             new Usermanagement().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "접근 권한이 없습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }
       dbClose();
    }//GEN-LAST:event_UserManageButtonActionPerformed

    private void CustomerInformButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerInformButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hms_Customer_information().setVisible(true);
    }//GEN-LAST:event_CustomerInformButtonActionPerformed

    private void ReportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        
        var ID = parametas.getNowID();
        System.out.println(ID);
        boolean isadmin = false;
        isadmin = isAdmin(ID);
        if (isadmin) {
            dispose();
            new hmsText().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "접근 권한이 없습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_ReportButtonActionPerformed

    private void RoomPayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomPayButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        
        var ID = parametas.getNowID();
        System.out.println(ID);
        boolean isadmin = false;
        isadmin = isAdmin(ID);
        if (isadmin) {
            dispose();
            new roompayChange().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "접근 권한이 없습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_RoomPayButtonActionPerformed

    private void FoodMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodMenuButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        
        var ID = parametas.getNowID();
        System.out.println(ID);
        boolean isadmin = false;
        isadmin = isAdmin(ID);
        if (isadmin) {
            dispose();
            new foodChange().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "접근 권한이 없습니다.", "메세지", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_FoodMenuButtonActionPerformed

    private void ReserCancleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReserCancleButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hms_Book_information().setVisible(true);
    }//GEN-LAST:event_ReserCancleButtonActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CustomerInformButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JButton FoodMenuButton;
    private javax.swing.JLabel HotelLabel;
    private javax.swing.JLabel PresentTimeLabel;
    private javax.swing.JButton ReportButton;
    private javax.swing.JButton ReserCancleButton;
    private javax.swing.JButton RoomManageButton;
    private javax.swing.JButton RoomPayButton;
    private javax.swing.JButton UserChangeButton;
    private javax.swing.JButton UserManageButton;
    public static javax.swing.JLabel hotelTimerLabel;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
