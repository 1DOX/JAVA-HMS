/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_FoodSystem;


import hms_Main.hmsDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


/**
 *
 * @author 송진영
 */
public class hmsDB_FoodSystem extends hmsDB{
    
    
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

    protected String getfoodString(String a, String b, String c, String d) throws SQLException {
        // DB에 있는 원하는 음식 정보를 불러오는 메쏘드
        // a: 방번호 , b: 몇 번째 음식, c: num(남은 수량) or charge(충전된 갯수) 
        Statement stmt3 = null;
        stmt3 = conn.createStatement();
        rs = stmt3.executeQuery("select * from " + a + " WHERE " + b + "= " + c);
        while (rs.next()) {

            String food_inform = rs.getString(d);
            return food_inform;
        }
        return null;
    }

    protected String search_roomnum(String a) throws SQLException {
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from foodsystem");
        while (rs.next()) {
            String room_num = rs.getString("room_num");
            if (room_num.equals(a)) {
                return room_num;
            }
        }
        return null;
    }
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

    protected String search_roomnum_2(String a, String b) throws SQLException {
        Statement stmt2 = null;
        stmt2 = conn.createStatement();
        rs = stmt2.executeQuery("select * from " + b);
        while (rs.next()) {
            String room_num = rs.getString("room_num");
            if (room_num.equals(a)) {
                return room_num;
            }
        }
        return null;
    }
    
     
}
