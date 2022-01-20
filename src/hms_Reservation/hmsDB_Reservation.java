
package hms_Reservation;

import hms_Main.hmsDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class hmsDB_Reservation extends hmsDB {
    
    protected String Card_num(String room) throws SQLException {
        String card_num = null;
        String sql = "select * from reservation WHERE room_num ='" + room + "'";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            card_num = rs.getString("card_num");

            if (card_num.equals(null)) {
                return null;
            }
        }
        return card_num;
    }
    
    protected dataROOM USERname(String a) { //사용자 정보
        try {
            this.dbLoad();
            String sql = "SELECT * FROM reservation WHERE name ='" + a + "'";
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
    }
    
    protected boolean datachange(String name, String address,
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
    
    protected  String getDate(String a) throws SQLException {
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        String sql = "select * from reservation WHERE room_num ='" + a + "'";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            Date time = rs.getDate("guessCOdate");;
            SimpleDateFormat ft = new SimpleDateFormat("YYYYMMdd");
            String theDate = ft.format(time);
            return theDate;
        }
        return null;
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
                        rs.getString("rate_desc"), rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getLong("number"), rs.getString("autoCancleDate"), rs.getString("realCIdate"),
                        rs.getString("realCItime"), rs.getString("guessCIdate"), rs.getString("guessCItime"), rs.getString("realCOdate"), rs.getString("realCOtime"),
                        rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
                roomList.add(room);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return roomList;
    }
    
    protected ArrayList<BookingList> bookingList() { //사용자 정보
        ArrayList<BookingList> bookingList = new ArrayList<>();
        try {
            this.dbLoad();
            String sql = "SELECT * FROM booking WHERE isCheckIn =0 ";
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
    
    protected int getfoodint(String a, String b, String c, String d) throws SQLException {
        // DB에 있는 원하는 음식 정보를 불러오는 메쏘드
        // a: 방번호 , b: 몇 번째 음식, c: num(남은 수량) or charge(충전된 갯수) 
        Statement stmt3 = null;
        stmt3 = conn.createStatement();
        rs = stmt3.executeQuery("select * from " + a + " WHERE " + b + "= " + c);
        while (rs.next()) {

            int food_inform = rs.getInt(d);
            return food_inform;
        }
        return 0;
    }
    
    protected int minibar(String a) throws SQLException {
        int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0, pay1 = 0, pay2 = 0, pay3 = 0,
                pay4 = 0, pay5 = 0, pay6 = 0, result = 0;
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        String sql = "select * from foodsystem WHERE room_num ='" + a + "'";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            num1 = rs.getInt("food_1_record");
            num2 = rs.getInt("food_2_record");
            num3 = rs.getInt("food_3_record");
            num4 = rs.getInt("food_4_record");
            num5 = rs.getInt("food_5_record");
            num6 = rs.getInt("food_6_record");
        }
        sql = "select * from hmsfood WHERE foodtype =1";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            pay1 = rs.getInt("food_1_pay");
            pay2 = rs.getInt("food_2_pay");
            pay3 = rs.getInt("food_3_pay");
            pay4 = rs.getInt("food_4_pay");
            pay5 = rs.getInt("food_5_pay");
            pay6 = rs.getInt("food_6_pay");
        }
        result += num1 * pay1;
        result += num2 * pay2;
        result += num3 * pay3;
        result += num4 * pay4;
        result += num5 * pay5;
        result += num6 * pay6;
        return result;
    }

   protected int restaurant(String a) throws SQLException {
        int num1 = 0, num2 = 0, num3 = 0, pay1 = 0, pay2 = 0, pay3 = 0, result = 0;
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        String sql = "select * from foodsystem WHERE room_num ='" + a + "'";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            num1 = rs.getInt("food_7_record");
            num2 = rs.getInt("food_8_record");
            num3 = rs.getInt("food_9_record");
        }
        sql = "select * from hmsfood WHERE foodtype =2";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            pay1 = rs.getInt("food_1_pay");
            pay2 = rs.getInt("food_2_pay");
            pay3 = rs.getInt("food_3_pay");
        }
        result += num1 * pay1;
        result += num2 * pay2;
        result += num3 * pay3;
        return result;
    }

    protected int roomservice(String a) throws SQLException {
        int num1 = 0, num2 = 0, num3 = 0, pay1 = 0, pay2 = 0, pay3 = 0, result = 0;
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        String sql = "select * from foodsystem WHERE room_num ='" + a + "'";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            num1 = rs.getInt("food_10_record");
            num2 = rs.getInt("food_11_record");
            num3 = rs.getInt("food_12_record");
        }
        sql = "select * from hmsfood WHERE foodtype =3";
        rs = stmt2.executeQuery(sql);
        while (rs.next()) {
            pay1 = rs.getInt("food_1_pay");
            pay2 = rs.getInt("food_2_pay");
            pay3 = rs.getInt("food_3_pay");
        }
        result += num1 * pay1;
        result += num2 * pay2;
        result += num3 * pay3;
        return result;
    }
    
    protected int db_getRow(String dbName) throws SQLException {
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt2.executeQuery("select * from " + dbName + " WHERE isCheckIn = 0");
        rs.last(); //행의 가장 끝으로 감
        int totalRecord = rs.getRow(); //전체 행의 개수
        return totalRecord;
    }
    
    protected void foodInsert(String a, int b, int c, int d) throws SQLException {
        String sql = "INSERT INTO datetable( "
                + " room, "
                + " bar, "
                + " restaurant, "
                + " roomService "
                + ") VALUES (?,?,?,?)";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1, a);
        st.setInt(2, b);
        st.setInt(3, c);
        st.setInt(4, d);

        st.executeUpdate();
    }
    
    protected ArrayList<Checkiin> roomnum() { //사용자 정보
        ArrayList<Checkiin> checkList = new ArrayList<>();
        try {
            this.dbLoad();
            String sql = "SELECT * FROM reservation ORDER BY room_num ASC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Checkiin check;
            while (rs.next()) {
                check = new Checkiin(rs.getString("room_num"));
                checkList.add(check);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return checkList;
    }
    
    protected Checkiin roomnumber() {
        try {
            this.dbLoad();
            String sql = "SELECT * FROM reservation";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                Checkiin check = new Checkiin(rs.getString("room_num"));
                return check;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return null;
    }
    
    protected String searchNAME(String a) throws SQLException { //회원정보 조회
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
    
    protected boolean searchName(String a) throws SQLException { //회원정보 조회(고객명)
        // 고객 정보 필드의 객실 번호를 getter
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from reservation");
        while (rs.next()) {
            String name = rs.getString("name");
            if (name == null) {
                continue;
            }
            if (name.equals(a)) {
                return true;
            }
        }
        return false;
    }
    
    protected boolean searchROOM(String a) throws SQLException { //회원정보 조회
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
    
    String searchreser(String a) throws SQLException { //룸 넘버로 예약번호 찾기
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from reservation WHERE room_num=" + a);
        while (rs.next()) {
            String number = rs.getString("number");
            return number;
        }
        return null;
    }
    
}
