package hms_Reservation;

import hms_FoodSystem.foodtrace;
import hms_Main.hmsGUI;
import hms_FoodSystem.foodService;
import hms_ETC.Bill;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class hotelGUI extends hmsDB_Reservation {

    int count = 0;

    public hotelGUI() {
        initComponents();

        buttonGroup1.add(NameRadioButton);
        buttonGroup1.add(RoomnumRadioButton);
    }

    public void booking_List() {
        ArrayList<BookingList> room = bookingList();
        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
        Object[] row = new Object[18];

        for (int i = 0; i < room.size(); i++) {
            row[0] = room.get(i).getNumber();
            row[1] = room.get(i).getRoom_num();
            row[2] = room.get(i).getName();
            row[3] = room.get(i).getAddress();
            row[4] = room.get(i).getPhonenum();
            row[5] = room.get(i).getMember();
            row[6] = room.get(i).getCard_num();
            row[7] = room.get(i).getdefault_price();
            row[8] = room.get(i).getGuessCIdate();
            row[9] = room.get(i).getGuessCItime();
            row[10] = room.get(i).getGuessCOdate();
            row[11] = room.get(i).getGuessCOtime();
            row[12] = room.get(i).getFeedback();
            row[13] = room.get(i).isIsPay();
            row[14] = room.get(i).getPayType();
            row[15] = room.get(i).getTotalPrice();
            row[16] = room.get(i).isGuarantee();
            row[17] = room.get(i).getAutoCancleDate();
            model.addRow(row);
        }
    }

    public void show_User(String v) {
        dataROOM room = USERname(v);
        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
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

    public void show_room(String v) {
        dataROOM room = roomIndex(v);
        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
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
        ArrayList<dataROOM> room = roomList();
        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        CustomerScrollPane = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        CIButton = new javax.swing.JButton();
        COButton = new javax.swing.JButton();
        FoodtraceButton = new javax.swing.JButton();
        PayButton = new javax.swing.JButton();
        FoodReserButton = new javax.swing.JButton();
        RoomnumTextFied = new javax.swing.JTextField();
        AllSearchButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        GoBackButton = new javax.swing.JButton();
        ReserButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ReserSearchButoon = new javax.swing.JButton();
        NameTextField = new javax.swing.JTextField();
        NameRadioButton = new javax.swing.JRadioButton();
        RoomnumRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("?????? ?????? ??? ??????");
        setBackground(new java.awt.Color(255, 255, 255));

        CustomerScrollPane.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N

        CustomerTable.setBackground(new java.awt.Color(204, 204, 204));
        CustomerTable.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "??? ??????", "?????????", "??????", "????????????", "?????? ???", "?????? ??????", "?????? ??????", "?????? ??????", "???????????? ??????", "?????? ????????????", "????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "???????????? ??????", "?????? ???????????? ??????", "?????? ???????????? ??????", "????????? ??????", "?????? ??????", "??? ?????? ??????"
            }
        ));
        CustomerTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        CustomerScrollPane.setViewportView(CustomerTable);

        CIButton.setBackground(new java.awt.Color(113, 113, 113));
        CIButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        CIButton.setForeground(new java.awt.Color(255, 255, 255));
        CIButton.setText("?????????");
        CIButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CIButtonActionPerformed(evt);
            }
        });

        COButton.setBackground(new java.awt.Color(113, 113, 113));
        COButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        COButton.setForeground(new java.awt.Color(255, 255, 255));
        COButton.setText("????????????");
        COButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                COButtonActionPerformed(evt);
            }
        });

        FoodtraceButton.setBackground(new java.awt.Color(113, 113, 113));
        FoodtraceButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        FoodtraceButton.setForeground(new java.awt.Color(255, 255, 255));
        FoodtraceButton.setText("?????? ??????");
        FoodtraceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodtraceButtonActionPerformed(evt);
            }
        });

        PayButton.setBackground(new java.awt.Color(113, 113, 113));
        PayButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        PayButton.setForeground(new java.awt.Color(255, 255, 255));
        PayButton.setText("??????");
        PayButton.setToolTipText("");
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        FoodReserButton.setBackground(new java.awt.Color(113, 113, 113));
        FoodReserButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        FoodReserButton.setForeground(new java.awt.Color(255, 255, 255));
        FoodReserButton.setText("?????? ??? ????????????");
        FoodReserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodReserButtonActionPerformed(evt);
            }
        });

        RoomnumTextFied.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        RoomnumTextFied.setText("??????????????? ??????????????????.");
        RoomnumTextFied.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomnumTextFiedActionPerformed(evt);
            }
        });

        AllSearchButton.setBackground(new java.awt.Color(113, 113, 113));
        AllSearchButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        AllSearchButton.setForeground(new java.awt.Color(255, 255, 255));
        AllSearchButton.setText("????????????");
        AllSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllSearchButtonActionPerformed(evt);
            }
        });

        SearchButton.setBackground(new java.awt.Color(113, 113, 113));
        SearchButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        SearchButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchButton.setText("??????");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        GoBackButton.setBackground(new java.awt.Color(70, 70, 70));
        GoBackButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        GoBackButton.setForeground(new java.awt.Color(255, 255, 255));
        GoBackButton.setText("????????????");
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });

        ReserButton.setBackground(new java.awt.Color(113, 113, 113));
        ReserButton.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        ReserButton.setForeground(new java.awt.Color(255, 255, 255));
        ReserButton.setText("??????");
        ReserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReserButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        jLabel1.setText("---------------------------------------------------");

        jLabel2.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        jLabel2.setText("---------------------------------------------------");

        ReserSearchButoon.setBackground(new java.awt.Color(113, 113, 113));
        ReserSearchButoon.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        ReserSearchButoon.setForeground(new java.awt.Color(255, 255, 255));
        ReserSearchButoon.setText("????????????");
        ReserSearchButoon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReserSearchButoonActionPerformed(evt);
            }
        });

        NameTextField.setFont(new java.awt.Font("?????? ??????", 0, 12)); // NOI18N
        NameTextField.setText("???????????? ?????? ????????????.");

        NameRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameRadioButtonActionPerformed(evt);
            }
        });

        RoomnumRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomnumRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(CustomerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NameRadioButton)
                    .addComponent(RoomnumRadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AllSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(ReserSearchButoon, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ReserButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CIButton))
                            .addComponent(COButton)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(FoodtraceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FoodReserButton))
                            .addComponent(GoBackButton))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RoomnumTextFied, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameTextField)
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchButton)
                            .addComponent(PayButton))
                        .addGap(19, 19, 19))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(890, 890, 890)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                        .addGap(892, 892, 892)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CustomerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AllSearchButton)
                            .addComponent(ReserSearchButoon))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SearchButton))
                            .addComponent(NameRadioButton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RoomnumRadioButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(RoomnumTextFied, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(70, 70, 70)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ReserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CIButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(COButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FoodtraceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FoodReserButton))
                        .addGap(51, 51, 51)
                        .addComponent(GoBackButton)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel2)
                        .addGap(33, 33, 33))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CIButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CIButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new isReservation().setVisible(true);
    }//GEN-LAST:event_CIButtonActionPerformed

    private void FoodtraceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodtraceButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new foodtrace().setVisible(true);
    }//GEN-LAST:event_FoodtraceButtonActionPerformed

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
        // TODO add your handling code here:
        dbLoad();
        
        
        String a = RoomnumTextFied.getText();
        boolean search = searchROOM(a);
        if(search)
        {
            dispose();
            new Bill(a,0).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(this, "?????? ???????????? ???????????? ????????????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
        }
        dbClose();
    }//GEN-LAST:event_PayButtonActionPerformed

    private void AllSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllSearchButtonActionPerformed
        // TODO add your handling code here:
        CustomerTable.setModel(new DefaultTableModel(null, new String[]{"??? ??????", "?????????", "??????", "????????????", "?????? ???", "?????? ??????", "?????? ??????", "?????? ??????", "???????????? ??????", "?????? ????????????", "????????? ??????",
            "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "???????????? ??????", "?????? ???????????? ??????", "?????? ???????????? ??????", "????????? ??????", "?????? ??????", "??? ?????? ??????"}));
        show_room();
        JOptionPane.showMessageDialog(this, "?????? ??????", "?????????", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AllSearchButtonActionPerformed

    private void RoomnumTextFiedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomnumTextFiedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoomnumTextFiedActionPerformed

    private void COButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_COButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hmsCheckout().setVisible(true);
    }//GEN-LAST:event_COButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // TODO add your handling code here:
        String Room_num = RoomnumTextFied.getText();
        String name = NameTextField.getText();
        dbLoad();
        if (count == 2) {
            CustomerTable.setModel(new DefaultTableModel(null, new String[]{"??? ??????", "?????????", "??????", "????????????", "?????? ???", "?????? ??????", "?????? ??????", "?????? ??????", "???????????? ??????", "?????? ????????????", "????????? ??????",
                "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "???????????? ??????", "?????? ???????????? ??????", "?????? ???????????? ??????", "????????? ??????", "?????? ??????", "??? ?????? ??????"}));
            if (Room_num.isEmpty()) {
                JOptionPane.showMessageDialog(this, "??? ????????? ??????????????? ???????????????. ?????? ??? ?????? ????????? ???????????????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
            } else if (searchROOM(Room_num) == false) {
                JOptionPane.showMessageDialog(this, "?????? ????????? ?????? ?????? ??? ????????????. ?????? ??? ?????? ???????????? ????????????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.show_room(Room_num);
                JOptionPane.showMessageDialog(this, Room_num + "??? ????????????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            CustomerTable.setModel(new DefaultTableModel(null, new String[]{"??? ??????", "?????????", "??????", "????????????", "?????? ???", "?????? ??????", "?????? ??????", "?????? ??????", "???????????? ??????", "?????? ????????????", "????????? ??????",
                "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "?????? ????????? ??????", "???????????? ??????", "?????? ???????????? ??????", "?????? ???????????? ??????", "????????? ??????", "?????? ??????", "??? ?????? ??????"}));
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "?????? ?????? ???????????? ???????????????.. ?????? ??? ?????? ????????? ???????????????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
            } else if (searchName(name) == false) {
                JOptionPane.showMessageDialog(this, "?????? ????????? ????????? ?????? ??? ????????????. ?????? ??? ?????? ???????????? ????????????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.show_User(name);
                JOptionPane.showMessageDialog(this, name+"????????? ?????? ??????.", "?????????", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hmsGUI().setVisible(true);
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void ReserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReserButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new hmsCheckinF(1).setVisible(true);
    }//GEN-LAST:event_ReserButtonActionPerformed

    private void ReserSearchButoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReserSearchButoonActionPerformed
        // TODO add your handling code here:
        CustomerTable.setModel(new DefaultTableModel(null, new String[]{"?????? ??????", "??? ??????", "?????? ???", "??????", "????????????", "?????? ???", "?????? ??????", "??? ??????", "?????? ????????? ??????", "?????? ????????? ??????",
            "?????? ???????????? ??????", "?????? ???????????? ??????", "?????????", "?????? ??????", "?????? ??????", "?????? ???", "?????? ??????", "?????? ?????? ??????",}));
        booking_List();
        JOptionPane.showMessageDialog(this, "?????? ??????", "?????????", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_ReserSearchButoonActionPerformed

    private void FoodReserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodReserButtonActionPerformed
        // TODO add your handling code here:
        dispose();
        new foodService().setVisible(true);
    }//GEN-LAST:event_FoodReserButtonActionPerformed

    private void NameRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameRadioButtonActionPerformed
        // TODO add your handling code here:
        count = 0;
        RoomnumTextFied.setText(null);
    }//GEN-LAST:event_NameRadioButtonActionPerformed

    private void RoomnumRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoomnumRadioButtonActionPerformed
        // TODO add your handling code here:
        count = 2;
        NameTextField.setText(null);
    }//GEN-LAST:event_RoomnumRadioButtonActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hotelGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllSearchButton;
    private javax.swing.JButton CIButton;
    private javax.swing.JButton COButton;
    private javax.swing.JScrollPane CustomerScrollPane;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JButton FoodReserButton;
    private javax.swing.JButton FoodtraceButton;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JRadioButton NameRadioButton;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JButton PayButton;
    private javax.swing.JButton ReserButton;
    private javax.swing.JButton ReserSearchButoon;
    private javax.swing.JRadioButton RoomnumRadioButton;
    private javax.swing.JTextField RoomnumTextFied;
    private javax.swing.JButton SearchButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
