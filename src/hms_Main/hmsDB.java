package hms_Main;

import hms_Login.loginGUI;
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

public class hmsDB extends javax.swing.JFrame {

    protected Connection conn;
    protected static final String USERNAME = "root";
    protected static final String PASSWORD = "hms1";
    protected static final String URL = "jdbc:mysql://220.92.196.58:3306/hms?serverTimezone=UTC";
    protected Statement stmt = null;
    protected ResultSet rs = null;

    protected void Updateint(String a, String b, String c, String d, int e) throws SQLException {
        // a: 원하는 테이블 , b: 좌표 칼럼  c: 칼럼 값  d: 바꿀 값 
        // 음식의 원하는 데이터를 수정하는 메쏘드
        Statement stmt3 = null;
        stmt3 = conn.createStatement();
        rs = stmt3.executeQuery("select * from " + a + " WHERE " + b + "= " + c);
        int getData = 0;
        while (rs.next()) {

            getData = rs.getInt(d);
        }
        String data = Integer.toString(getData + e);
        String sql = "UPDATE " + a + " "
                + "SET"
                + " " + b + " =?"
                + "WHERE " + c + " =?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, data);
        st.setString(2, d);
        st.executeUpdate();
    }

    protected void Updatechange(String a, String b, String c, String d, int e) throws SQLException {
        // a: 테이블, b: 값을 바꿀 데이터, c: 좌표 데이터 , d: 좌표 데이터 값, e: 바꿀 데이터 값
        // 원하는 int data를 수정하는 메쏘드
        Statement stmt3 = null;
        stmt3 = conn.createStatement();
        rs = stmt3.executeQuery("select * from " + a + " WHERE " + b + "= " + c);
        int getData = 0;
        while (rs.next()) {

            getData = rs.getInt(d);
        }
        String data = Integer.toString(getData);
        data = Integer.toString(e);
        String sql = "UPDATE " + a + " "
                + "SET"
                + " " + b + " =?"
                + "WHERE " + c + " =?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, data);
        st.setString(2, d);
        st.executeUpdate();
    }

    protected void UpdateString(String a, String b, String c, String d, String e) throws SQLException {
        // a: 테이블, b: 값을 바꿀 데이터, c: 좌표 데이터 , d: 좌표 데이터 값, e: 바꿀 데이터 값
        // 원하는 int data를 수정하는 메쏘드
        String sql = "UPDATE " + a + " "
                + "SET"
                + " " + b + " =?"
                + "WHERE " + c + " =?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, e);
        st.setString(2, d);
        st.executeUpdate();
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

    protected boolean isAdmin(String ID) throws SQLException {
        Statement stmt = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from login WHERE userID = '" + ID + "'");
        while (rs.next()) {
            boolean isAdmin = rs.getBoolean("isAdmin");;
            if (isAdmin) {
                return true;
            } else {
                return false;
            }
        }
        return false;
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

    protected void CICOtime(String CItime, String COtime) {
        String cit = CItime;
        String cot = COtime;
    }

    protected boolean nametest(String a) {
        char tmp;

        Scanner scanner = new Scanner(a);
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            tmp = input.charAt(i);

            if ('0' <= tmp && tmp <= '9') {
                return true;
            }
        }
        return false;
    }

    protected boolean searchROOM_NUM(String a) throws SQLException { //회원정보 조회
        // 고객 정보 필드의 객실 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from roomcost");
        while (rs.next()) {
            String name = rs.getString("room_num");
            if (name == null) {
                continue;
            }
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }

    protected boolean phonetest(String a) {
        char tmp;

        Scanner scanner = new Scanner(a);
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            tmp = input.charAt(i);

            if (!('0' <= tmp && tmp <= '9')) {
                return true;
            }
        }
        return false;
    }

    protected void updateDATE(String room_num, Date date) throws SQLException {
        //Date date1 = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
        String theDate = ft.format(date);
        String sql = "INSERT INTO datetable( "
                + " room, " + " date "
                + ") VALUES (?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, room_num);
        st.setString(2, theDate);

        st.executeUpdate();
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

    protected boolean dateSearch(int diff, Date a, String room) throws SQLException { //회원정보 조회
        // 예약 필드의 예약 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from datetable WHERE room='" + room + "'");
        Date saveA = a;
        while (rs.next()) {
            a = saveA;
            Date date = rs.getDate("date");
            SimpleDateFormat ft = new SimpleDateFormat("YYYYMMdd");
            String theDate = ft.format(date); //DB날짜
            for (int i = 0; i <= Math.abs(diff); i++) { //숙박할 총 날짜만큼 반복
                //System.out.println("[for문] " + i);
                String paraDate = ft.format(a);
                //System.out.println("현재 비교할 날짜(paraDate): " + paraDate);
                //System.out.println("DB날짜: " + theDate);
                //System.out.println(paraDate);
                if (theDate.equals(paraDate)) {
                    return false;
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(a);
                cal.add(Calendar.DATE, 1);
                a = cal.getTime();
            }
        }
        return true;
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

    protected boolean searchNUM(String a) throws SQLException { //회원정보 조회
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

    protected boolean deleteBooking(String room, Date cidate) throws SQLException {
        Statement stmt = null;
        stmt = conn.createStatement();
        SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd");
        String ftcidate = ft.format(cidate);
        rs = stmt.executeQuery("select * from booking WHERE room_num=" + room);
        int count = 0;
        while (rs.next()) {
            String cidateforDB = rs.getString("guessCIdate");
            if (cidateforDB.equals(ftcidate)) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        }
        rs = stmt.executeQuery("select * from booking WHERE room_num='" + room + "' AND guessCIdate='" + ftcidate + "'");
        rs.next();
        Date codate = rs.getDate("guessCOdate"); //삭제할 테이블의 체크아웃날짜
        String sql = "DELETE FROM booking WHERE room_num='" + room + "' AND guessCIdate='" + ftcidate + "'";
        PreparedStatement st = conn.prepareStatement(sql);
        st.executeUpdate();

        var dateci = new Date();
        var dateco = new Date();
        dateci = cidate;
        dateco = codate;
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(dateci);
        cal2.setTime(dateco);
        long mill = (cal1.getTimeInMillis() - cal2.getTimeInMillis());
        long hours = TimeUnit.MILLISECONDS.toHours(mill);
        long days = TimeUnit.HOURS.toDays(hours);
        String diffstr = String.format("%d", days);
        int diff = Integer.parseInt(diffstr);
        Date saveA = cidate;

        rs = stmt.executeQuery("select * from datetable WHERE room='" + room + "'");

        while (rs.next()) {
            dateci = saveA;
            for (int i = 0; i <= Math.abs(diff); i++) { //숙박 날짜만큼 반복
                Date date = rs.getDate("date");
                String theDate = ft.format(date); //DB날짜
                String strdateci = ft.format(dateci); //삭제할날짜
                if (theDate.equals(strdateci)) {
                    sql = "DELETE FROM datetable WHERE room='" + room + "' AND date='" + strdateci + "'";
                    st = conn.prepareStatement(sql);
                    st.executeUpdate();
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(dateci);
                cal.add(Calendar.DATE, 1);
                dateci = cal.getTime();
            }
        }

        return true;
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

    protected static LocalDateTime toLocalDateTime(Timestamp ts) {
        return ts.toLocalDateTime();
    }

    protected boolean CheckOut(String Room_num, String reser) throws SQLException {
        int result = 0;
        String sql = "DELETE FROM reservation WHERE room_num=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, Room_num);
        result = st.executeUpdate();

        sql = "DELETE FROM foodsystem WHERE room_num=?";
        st = conn.prepareStatement(sql);
        st.setString(1, Room_num);
        result = st.executeUpdate();

        sql = "DELETE FROM booking WHERE number=?";
        st = conn.prepareStatement(sql);
        st.setString(1, reser);
        result = st.executeUpdate();
        if (result == 0) {
            return false;
        } else {
            return true;
        }
    }

    protected boolean Emp(String a, String b) {

        if (a.isEmpty() && !(b.isEmpty() || b.equals("0"))) {
            return true;
        } else if (!a.isEmpty() && (b.isEmpty() || b.equals("0"))) {
            return true;
        } else {
            return false;
        }
    }

    

    protected void DeleteID(String UserID) throws SQLException {

        String sql = "DELETE FROM login WHERE UserID=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, UserID);
        st.executeUpdate();
    }

    protected void update(String UserID, String UserPW, int isAdmin) throws SQLException { //관리자 아이디 생성
        String sql = "INSERT INTO login( "
                + " UserID, "
                + " UserPW, "
                + " isAdmin"
                + ") VALUES (?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, UserID);
        st.setString(2, UserPW);
        st.setInt(3, isAdmin);

        st.executeUpdate();

    }

    protected boolean serachID(String a) throws SQLException { //회원정보 조회
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from login");
        while (rs.next()) {
            String name = rs.getString("userID");;
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }

    protected void NewClass() {
        System.out.println("newclass");
    }

    protected void dbLoad() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실");
        }

    }

    protected void dbClose() {
        try {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(hmsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(hmsDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(hmsDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected static void loginLoad() {
        loginGUI login = new loginGUI();
        login.setVisible(true);
    }

}