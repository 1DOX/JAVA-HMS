
package hms_Reservation;

import hms_Main.hmsDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class hmsDB_Booking extends hmsDB {
    
    protected void CICard_num(String numbers, String a) throws SQLException {
        int isPay = 1;

        String sql23 = "UPDATE booking SET card_num=?, ispay=? WHERE number=?";
        PreparedStatement st23 = conn.prepareStatement(sql23);
        st23.setString(1, a);
        st23.setInt(2, isPay);
        st23.setString(3, numbers);
        st23.executeUpdate();
    }
    
    protected String updateRV(String name, String address, String phonenum, String member, boolean guarantee, String payType, boolean isPay,
            String card_num, String feedback, String room_num, String guessCIdate, String guessCOdate, String fm1, String fm2) throws SQLException, ParseException {
        //예약
        int default_price = 0;

        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        String sql1 = "select * from roomcost WHERE room_num ='" + room_num + "'";
        rs = stmt2.executeQuery(sql1);
        while (rs.next()) {
            default_price = rs.getInt("change_rate");
        }

        String num;
        String inStr = guessCIdate.replaceAll("[^0-9]", "");
        num = inStr + room_num;

        String sql = "INSERT INTO booking( "
                + " name, "
                + " address, "
                + " phonenum,"
                + " member,"
                + " room_num,"
                + " guarantee,"
                + " payType,"
                + " isPay,"
                + " card_num,"
                + " feedback,"
                + " guessCIdate,"
                + " guessCOdate,"
                + " number,"
                + " default_price,"
                + " autoCancleDate,"
                + " guessCItime,"
                + " guessCOtime"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, address);
        st.setString(3, phonenum);
        st.setString(4, member);
        st.setString(5, room_num);
        st.setBoolean(6, guarantee);
        st.setString(7, payType);
        st.setBoolean(8, isPay);
        st.setString(9, card_num);
        st.setString(10, feedback);
        st.setString(11, guessCIdate);
        st.setString(12, guessCOdate);
        st.setString(13, num);
        st.setInt(14, default_price);
        st.setString(15, guessCIdate);
        st.setString(16, fm1);
        st.setString(17, fm2);
        //지정된값 넣도록 변경 (중간에 추가)

        st.executeUpdate();
        return num;
    }
        
    protected boolean CIisPay(String a) throws SQLException {
        boolean isPay;
        String card_num = null;
        String sql = "select * from booking WHERE number ='" + a + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        rs.next();
        isPay = rs.getBoolean("isPay");
        card_num = rs.getString("card_num");
        if (isPay == false || card_num.equals("----") || card_num == null) {
            return false;
        } else {
            return true;
        }
    }
    
    protected ArrayList<BookingList> bookingList() { //사용자 정보
        ArrayList<BookingList> bookingList = new ArrayList<>();
        try {
            this.dbLoad();
            String sql = "SELECT * FROM booking";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            BookingList room;
            while (rs.next()) {
                room = new BookingList(rs.getString("name"), rs.getString("address"), rs.getString("phonenum"), rs.getInt("member"), rs.getInt("room_num"),
                        rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getLong("number"), rs.getString("autoCancleDate"), rs.getInt("default_price"),
                        rs.getString("guessCIdate"), rs.getString("guessCItime"), rs.getString("guessCOdate"), rs.getString("guessCOtime"),
                        rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
                bookingList.add(room);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return bookingList;
    }
    
    protected boolean searchROOM2(String a) throws SQLException { //회원정보 조회
        // 예약 필드의 객실 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from booking");
        while (rs.next()) {
            String name = rs.getString("room_num");;
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }
    
    protected String notguarantee(String date) throws SQLException { //체크인날에 무보증인 객실 조회
        try {
            this.dbLoad();
            Statement stmt2 = null;
            stmt2 = conn.createStatement();
            rs = stmt2.executeQuery("select * from booking WHERE guessCIdate='" + date + "' AND guarantee=false");

            if (rs.next()) {
                String room = rs.getString("room_num");
                return room;
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    protected void Canclebooking(String room_num) throws SQLException // 체크인날 무보증 객실 취소
    {
        String sql = "DELETE FROM booking WHERE room_num=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, room_num);
        st.executeUpdate();
    }
    
    protected int searchCHECK(String a) throws SQLException { //회원정보 조회
        // 예약 필드의 체크인 여부 getter
        String sql = "select * from booking WHERE number ='" + a + "'";
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery(sql);
        int check = 0;
        while (rs.next()) {
            check = rs.getInt("isCheckIn");
        }
        return check;
    }
       
    protected  boolean searchNUM(String a) throws SQLException { //회원정보 조회
        // 예약 필드의 예약 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from booking");
        while (rs.next()) {
            String name = rs.getString("number");
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }
    
    protected String checkinnum(int k) throws SQLException { //회원정보 조회
        // 예약 필드의 방 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from booking WHERE isCheckIn = 0");
        for (int i = 0; i < k; i++) {
            rs.next();
        }
        String room_num = null;
        String cidate = null;

        if (rs.next()) {
            room_num = rs.getString("room_num");
            cidate = rs.getString("guessCIdate");
        }
        return room_num + "(" + cidate + ")";
    }
    
    protected int get_reserroom(String reser) throws SQLException { // 예약번호를 통해서 룸 넘버 반환
        Statement stmt3 = null;
        stmt3 = conn.createStatement();
        rs = stmt3.executeQuery("select * from booking WHERE number= " + reser);
        while (rs.next()) {
            int room_num = rs.getInt("room_num");
            return room_num;
        }
        return 0;
    }
    
     protected int get_roomcost(String room_num) throws SQLException {
        // DB에 있는 원하는 음식 정보를 불러오는 메쏘드
        // a: 방번호 , b: 몇 번째 음식, c: num(남은 수량) or charge(충전된 갯수) 
        Statement stmt3 = null;
        stmt3 = conn.createStatement();
        rs = stmt3.executeQuery("select * from roomcost WHERE room_num= " + room_num);
        while (rs.next()) {
            int room_cost = rs.getInt("change_rate");
            return room_cost;
        }
        return 0;
    }
     protected ArrayList<hmsROOM> roomCost(int a) throws SQLException { //사용자 정보
        ArrayList<hmsROOM> roomCost = new ArrayList<>();
        try {
            this.dbLoad();
            int start = 0;
            int limit = 10;

            for (int i = 1; i <= 10; i++) {
                if (a == i) {
                    break;
                } else {
                    start += 10;
                }
            }
            String sql = "SELECT * FROM roomcost ORDER BY room_num ASC limit " + limit + " offset " + start;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            hmsROOM roomcost;
            while (rs.next()) {
                roomcost = new hmsROOM(rs.getInt("room_num"), rs.getInt("default_rate"), rs.getInt("change_rate"), rs.getString("rate_desc"));
                roomCost.add(roomcost);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return roomCost;
    }
     protected  void foodroomInsert(int a) throws SQLException {
        String sql = "INSERT INTO foodsystem( "
                + " room_num, "
                + " food_1_num, "
                + " food_2_num, "
                + " food_3_num, "
                + " food_4_num, "
                + " food_5_num, "
                + " food_6_num "
                + ") VALUES (?,?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1, a);
        st.setInt(2, 5);
        st.setInt(3, 5);
        st.setInt(4, 5);
        st.setInt(5, 5);
        st.setInt(6, 5);
        st.setInt(7, 5);

        st.executeUpdate();
    }
     protected dataROOM USERname(String a) { //사용자 정보
        try {
            this.dbLoad();
            String sql = "SELECT * FROM reservation WHERE name ='" + a + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                dataROOM room = new dataROOM(rs.getString("name"), rs.getString("address"), rs.getString("phonenum"), rs.getInt("member"), rs.getInt("room_num"), rs.getInt("default_price"),
                        rs.getString("rate_desc"), rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getLong("number"), rs.getString("autoCancleDate"), rs.getString("realCIdate"),
                        rs.getString("realCItime"), rs.getString("guessCIdate"), rs.getString("guessCItime"), rs.getString("realCOdate"), rs.getString("realCOtime"),
                        rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
                return room;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     protected dataROOM roomIndex(String a) { //사용자 정보
        try {
            this.dbLoad();
            String sql = "SELECT * FROM reservation WHERE room_num='" + a + "'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                dataROOM room = new dataROOM(rs.getString("name"), rs.getString("address"), rs.getString("phonenum"), rs.getInt("member"), rs.getInt("room_num"), rs.getInt("default_price"),
                        rs.getString("rate_desc"), rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getInt("number"), rs.getString("autoCancleDate"), rs.getString("realCIdate"),
                        rs.getString("realCItime"), rs.getString("guessCIdate"), rs.getString("guessCItime"), rs.getString("realCOdate"), rs.getString("realCOtime"),
                        rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
                return room;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
     protected ArrayList<dataROOM> roomList() { //사용자 정보
        ArrayList<dataROOM> roomList = new ArrayList<>();
        try {
            this.dbLoad();
            String sql = "SELECT * FROM reservation";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            dataROOM room;
            while (rs.next()) {
                room = new dataROOM(rs.getString("name"), rs.getString("address"), rs.getString("phonenum"), rs.getInt("member"), rs.getInt("room_num"), rs.getInt("default_price"),
                        rs.getString("rate_desc"), rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getInt("number"), rs.getString("autoCancleDate"), rs.getString("realCIdate"),
                        rs.getString("realCItime"), rs.getString("guessCIdate"), rs.getString("guessCItime"), rs.getString("realCOdate"), rs.getString("realCOtime"),
                        rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
                roomList.add(room);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return roomList;
    }
     void RealCI(String a) throws SQLException {
        //예약 > 체크인 값 넘겨줌
        String name = null, address = null, phonenum = null, member = null, room_num = null, card_num = null, feedback = null, number = null,
                autoCancleDate = null, guessCIdate = null, guessCItime = null, guessCOdate = null, guessCOtime = null, payType = null, totalPrice = null;
        boolean guarantee = false, isPay = false;
        String sql = "select * from booking WHERE number ='" + a + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            name = rs.getString("name");
            address = rs.getString("address");
            phonenum = rs.getString("phonenum");
            member = rs.getString("member");
            room_num = rs.getString("room_num");
            guarantee = rs.getBoolean("guarantee");
            card_num = rs.getString("card_num");
            feedback = rs.getString("feedback");
            guessCIdate = rs.getString("guessCIdate");
            guessCOdate = rs.getString("guessCOdate");
            payType = rs.getString("payType");
            autoCancleDate = rs.getString("autoCancleDate");
            guessCItime = rs.getString("guessCItime");
            guessCOtime = rs.getString("guessCOtime");
            totalPrice = rs.getString("totalPrice");
            number = rs.getString("number");
            isPay = rs.getBoolean("isPay");

        }

        int isCheckIn = 1;
        String sql23 = "UPDATE booking SET isCheckIn=? WHERE number='" + a + "'";
        PreparedStatement st23 = conn.prepareStatement(sql23);
        st23.setInt(1, isCheckIn);
        st23.executeUpdate();

        sql = "INSERT INTO reservation( "
                + " name, "
                + " address, "
                + " phonenum,"
                + " member,"
                + " room_num,"
                + " guarantee,"
                + " card_num,"
                + " feedback,"
                + " guessCIdate,"
                + " guessCOdate,"
                + " payType,"
                + " autoCancleDate,"
                + " guessCItime,"
                + " guessCOtime,"
                + " totalPrice,"
                + " number,"
                + " isPay"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st1 = conn.prepareStatement(sql);
        st1.setString(1, name);
        st1.setString(2, address);
        st1.setString(3, phonenum);
        st1.setString(4, member);
        st1.setString(5, room_num);
        st1.setBoolean(6, guarantee);
        st1.setString(7, card_num);
        st1.setString(8, feedback);
        st1.setString(9, guessCIdate);
        st1.setString(10, guessCOdate);
        st1.setString(11, payType);
        st1.setString(12, autoCancleDate);
        st1.setString(13, guessCItime);
        st1.setString(14, guessCOtime);
        st1.setString(15, totalPrice);
        st1.setString(16, number);
        st1.setBoolean(17, isPay);

        //지정된값 넣도록 변경 (중간에 추가)
        st1.executeUpdate();

    }
    
        
}
