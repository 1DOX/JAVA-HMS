package hmsProject;

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
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class hmsDB extends javax.swing.JFrame {

    private Connection conn;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hms1";
    private static final String URL = "jdbc:mysql://220.92.196.58:3306/hms?serverTimezone=UTC";
    Statement stmt = null;
    ResultSet rs = null;

    /*public void datachange() {
        String name = "1";
        String address = "부산4";
        String phonenum = "01030654055";

        String sql = "UPDATE reservation "
                + "SET"
                + " address=?,"
                + " phonenum=?"
                + "WHERE name=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, address);
        st.setString(2, phonenum);
        st.setString(3, name);



    }
     */
    
    String searchNAME(String a) throws SQLException { //회원정보 조회
        // 예약 필드의 객실 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from reservation WHERE room_num='" + a + "'");
        while (rs.next()) {
            String name = rs.getString("name");
            return name;
        }
        return null;
    }
    int getCost_Bill(String room_num, String type) throws SQLException { //회원정보 조회
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int roomTcost = 0;
        int roomOcost = 0;
        int foodXcost = 0;
        int foodOcost = 0;
        
        rs = stmt2.executeQuery("select * from foodsystem WHERE room_num='" + room_num + "'");
        while(rs.next()){
            foodXcost += rs.getInt("food_total_pay"); //음식 미결제금액
            foodOcost += rs.getInt("payment"); //음식 결제금액
        }
        rs = stmt2.executeQuery("select * from reservation WHERE room_num='" + room_num + "'");
        while(rs.next()){
            roomTcost += rs.getInt("totalPrice"); //객실 총 금액
            roomOcost += rs.getInt("payment"); //객실 결제금액
        }
        
        switch (type){
            case "roomO":
                return roomOcost;
            case "roomX":
                return roomTcost - roomOcost;
            case "roomTotal":
                return roomTcost;
            case "foodO":
                return foodOcost;
            case "foodX":
                return foodXcost;
            case "foodTotal":
                return foodOcost + foodXcost;
            case "totalX":
                return (roomTcost - roomOcost) + foodXcost;
        }
        return 0;
    }
    
    boolean phonetest(String a) {
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

    boolean nametest(String a) {
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

    boolean searchROOM_NUM(String a) throws SQLException { //회원정보 조회
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

    public ArrayList<dataROOM> bookingList() { //사용자 정보
        ArrayList<dataROOM> bookingList = new ArrayList<>();
        try {
            this.dbLoad();
            String sql = "SELECT * FROM booking";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            dataROOM room;
            while (rs.next()) {
                room = new dataROOM(rs.getString("name"), rs.getString("address"), rs.getString("phonenum"), rs.getInt("member"), rs.getInt("room_num"), rs.getInt("default_price"),
                        rs.getString("rate_desc"), rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getLong("number"), rs.getString("autoCancleDate"), rs.getString("realCIdate"),
                        rs.getString("realCItime"), rs.getString("guessCIdate"), rs.getString("guessCItime"), rs.getString("realCOdate"), rs.getString("realCOtime"),
                        rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
                bookingList.add(room);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return bookingList;
    }

    void CICOtime(String CItime, String COtime) {
        String cit = CItime;
        String cot = COtime;
    }

    void Bill(String room_num) throws SQLException {

        Statement stmt = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from login WHERE userID = '" + room_num + "'");
        while (rs.next()) {

        }

    }

    boolean isAdmin(String ID) throws SQLException {
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
        String name = null, address = null, phonenum = null, member = null, room_num = null, guarantee = null, card_num = null, feedback = null, guessCIdate = null, guessCOdate = null, payType = null;
        String sql = "select * from booking WHERE number ='" + a + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            name = rs.getString("name");
            address = rs.getString("address");
            phonenum = rs.getString("phonenum");
            member = rs.getString("member");
            room_num = rs.getString("room_num");
            guarantee = rs.getString("guarantee");
            card_num = rs.getString("card_num");
            feedback = rs.getString("feedback");
            guessCIdate = rs.getString("guessCIdate");
            guessCOdate = rs.getString("guessCOdate");
            payType = rs.getString("payType");
        }

        sql = "INSERT INTO reservation( "
                + " name, "
                + " address, "
                + " phonenum,"
                + " member,"
                + " room_num,"
                + " guarantee,"
                + " payType,"
                + " card_num,"
                + " feedback,"
                + " guessCIdate,"
                + " guessCOdate"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st1 = conn.prepareStatement(sql);
        st1.setString(1, name);
        st1.setString(2, address);
        st1.setString(3, phonenum);
        st1.setString(4, member);
        st1.setString(5, room_num);
        st1.setString(6, guarantee);
        st1.setString(7, payType);
        st1.setString(8, card_num);
        st1.setString(9, feedback);
        st1.setString(10, guessCIdate);
        st1.setString(11, guessCOdate);
        //지정된값 넣도록 변경 (중간에 추가)
        st1.executeUpdate();

    }

    boolean searchROOM(String a) throws SQLException { //회원정보 조회
        // 고객 정보 필드의 객실 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from reservation");
        while (rs.next()) {
            String name = rs.getString("room_num");;
            if (name == null) {
                continue;
            }
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }

    boolean searchROOM2(String a) throws SQLException {
        // 예약 필드의 객실 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from booking");
        while (rs.next()) {
            String name = rs.getString("room_num");
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }

    int dateSearch_Report(Date a, int diff) throws SQLException { //회원정보 조회
        // 예약 필드의 예약 번호를 getter
        int count = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        String paraDate = sdf.format(a);
        System.out.println("paraData: " + paraDate);
        rs = stmt2.executeQuery("select * from datetable WHERE date='" + paraDate + "'");
        //Date saveA = a;
        while (rs.next()) {
            //a = saveA;
            Date date = rs.getDate("date");
            String theDate = sdf.format(date); //DB날짜

            System.out.println("DB date: " + date);
            for (int i = 0; i <= Math.abs(diff); i++) { //숙박할 총 날짜만큼 반복
                //System.out.println("[for문] " + i);
                paraDate = sdf.format(a);
                //System.out.println("현재 비교할 날짜(paraDate): " + paraDate);
                //System.out.println("DB날짜: " + theDate);
                //System.out.println(paraDate);
                if (theDate.equals(paraDate)) {
                    count++;
                }
                Calendar cal = Calendar.getInstance();
                cal.setTime(a);
                cal.add(Calendar.DATE, 1);
                a = cal.getTime();
            }
        }
        return count;
    }

    boolean searchNUM(String a) throws SQLException { //회원정보 조회
        // 예약 필드의 예약 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from booking");
        while (rs.next()) {
            String name = rs.getString("number");
            if (name == null) {
                continue;
            }
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }

    void updateDATE(String room_num, Date date) throws SQLException {
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

    String updateRV(String name, String address,
            String phonenum, String member,
            boolean guarantee, String payType,
            String card_num, String feedback,
            String room_num, String real,
            String guess, String fm1, String fm2) throws SQLException {
        //예약
        String num;
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("YYYYMMdd");
        String theDate = ft.format(date);
        num = theDate + room_num;

        String sql = "INSERT INTO booking( "
                + " name, "
                + " address, "
                + " phonenum,"
                + " member,"
                + " room_num,"
                + " guarantee,"
                + " payType,"
                + " card_num,"
                + " feedback,"
                + " guessCIdate,"
                + " guessCOdate,"
                + " number,"
                + " guessCItime,"
                + " guessCOtime"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, address);
        st.setString(3, phonenum);
        st.setString(4, member);
        st.setString(5, room_num);
        st.setBoolean(6, guarantee);
        st.setString(7, payType);
        st.setString(8, card_num);
        st.setString(9, feedback);
        st.setString(10, real);
        st.setString(11, guess);
        st.setString(12, num);
        st.setString(13, fm1);
        System.out.println(fm1);
        st.setString(14, fm2);
        System.out.println(fm2);
        //지정된값 넣도록 변경 (중간에 추가)

        st.executeUpdate();
        return num;
    }

    boolean datachange(String name, String address,
            String phonenum, String cardnum,
            String roomnum, String changename,
            String member) throws SQLException {
        int result = 0;
        String a, b, c, d, e, f, g = null;
        a = name;
        b = address;
        c = phonenum;
        d = cardnum;
        e = roomnum;
        f = changename;
        g = member;

        Statement stmt = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from reservation");
        while (rs.next()) {
            String z = rs.getString("name");
            String y = rs.getString("room_num");

            if (z.equals(a) && y.equals(e)) {

                if (f.isEmpty()) {
                    String sql = "select * from reservation WHERE name ='" + a + "'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    rs.next();
                    f = rs.getString("name");
                }

                if (b.isEmpty()) {
                    String sql = "select * from reservation WHERE name ='" + a + "'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    rs.next();
                    b = rs.getString("address");
                }

                if (c.isEmpty()) {
                    String sql = "select * from reservation WHERE name ='" + a + "'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    rs.next();
                    c = rs.getString("phonenum");
                }

                if (d.isEmpty()) {
                    String sql = "select * from reservation WHERE name ='" + a + "'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    rs.next();
                    d = rs.getString("card_num");
                }

                if (g.isEmpty()) {
                    String sql = "select * from reservation WHERE name ='" + a + "'";
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    rs.next();
                    g = rs.getString("member");
                }

                String sql = "UPDATE reservation "
                        + "SET"
                        + " name=?,"
                        + " address=?,"
                        + " phonenum=?,"
                        + " card_num=?,"
                        + " member=?"
                        + "WHERE name=? AND room_num=? ";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1, f);
                st.setString(2, b);
                st.setString(3, c);
                st.setString(4, d);
                st.setString(5, g);
                st.setString(6, a);
                st.setString(7, e);
                result = st.executeUpdate();
                return true;
            }
        }

        return false;

    }

    public dataROOM roomIndex(String a) { //사용자 정보
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

    public static LocalDateTime toLocalDateTime(Timestamp ts) {
        return ts.toLocalDateTime();
    }

    public ArrayList<dataROOM> roomList() { //사용자 정보
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

    boolean CheckOut(String Room_num) throws SQLException {
        int result = 0;
        String sql = "DELETE FROM reservation WHERE room_num=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, Room_num);

        result = st.executeUpdate();
        if (result == 0) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<dataUSER> userList() { //사용자 정보
        ArrayList<dataUSER> userList = new ArrayList<>();
        try {
            this.dbLoad();
            String sql = "SELECT * FROM login";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            dataUSER user;
            while (rs.next()) {
                user = new dataUSER(rs.getInt("isAdmin"), rs.getString("UserID"), rs.getString("UserPW"));
                userList.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return userList;
    }

    void DeleteID(String UserID) throws SQLException {

        String sql = "DELETE FROM login WHERE UserID=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, UserID);
        st.executeUpdate();
    }

    void update(String UserID, String UserPW, int isAdmin) throws SQLException { //관리자 아이디 생성
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

    boolean serachID(String a) throws SQLException { //회원정보 조회
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

    boolean getDB(String a, String b) throws SQLException { //로그인
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from login");
        while (rs.next()) {
            String name = rs.getString("userID");;
            String password = rs.getString("userPW");
            if (name.equals(a) && password.equals(b)) {
                return true;
            }
        }
        return false;
    }

    public void NewClass() {
        System.out.println("newclass");
    }

    void dbLoad() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실");
        }

    }

    void dbClose() {
        try {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(hmsDB.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(hmsDB.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(hmsDB.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void loginLoad() {
        loginGUI login = new loginGUI();
        login.setVisible(true);
    }

}
