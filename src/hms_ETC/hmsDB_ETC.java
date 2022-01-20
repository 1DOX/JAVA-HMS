
package hms_ETC;

import hms_Reservation.hmsROOM;
import hms_Main.hmsDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

public class hmsDB_ETC extends hmsDB {
    
   int dateSearch_Report(Date a, Date b, String periods) throws SQLException { //회원정보 조회
        // 예약 필드의 예약 번호를 getter
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String date1 = sdf.format(a);
        String date2 = sdf.format(b);
        //Date saveA = a;
        int totalRecord = 0;
        
        if(periods.equals("real")){
            rs = stmt2.executeQuery("select * from datetable WHERE date between date('" + date1 + "') and date('" + date2 + "')");
            rs.last(); //행의 가장 끝으로 감
            totalRecord = rs.getRow(); //전체 행의 개수
            rs = stmt2.executeQuery("select DISTINCT date from datetable WHERE date between date('" + date1 + "') and date('" + date2 + "')");
            rs.last(); //행의 가장 끝으로 감
            int distRecord = rs.getRow(); //전체 행의 개수
            System.out.println("/totalRecord: " + totalRecord);
            System.out.println("/distRecord: " + distRecord);
            return totalRecord/distRecord;
            
        }
        else if (periods.equals("expect")){
            rs = stmt2.executeQuery("select * from datetable");
            rs.last(); //행의 가장 끝으로 감
            totalRecord = rs.getRow(); //전체 행의 개수
            //rs = stmt2.executeQuery("select * from datetable WHERE date between date('" + minDate + "') and date('" + maxDate + "') +1");
            rs = stmt2.executeQuery("select DISTINCT date from datetable");
            rs.last(); //행의 가장 끝으로 감
            int distRecord = rs.getRow(); //전체 행의 개수
            System.out.println("totalRecord: " + totalRecord);
            System.out.println("distRecord: " + distRecord);
            
            return totalRecord/distRecord;
        }
        return 0;
    }
    
    int getCost_Report(Date a, int diff, String type) throws SQLException { //회원정보 조회
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String paraDate = sdf.format(a);
        int totalCost = 0;
        
        if(type == "room"){
            for (int i = 0; i <= Math.abs(diff); i++){ //객실 추가요금
                rs = stmt2.executeQuery("select * from datetable WHERE date='" + paraDate + "'");
                while(rs.next())
                    totalCost += rs.getInt("extraFee");

                Calendar cal = Calendar.getInstance();
                cal.setTime(a);
                cal.add(Calendar.DATE, 1);
                a = cal.getTime();
                paraDate = sdf.format(a);
            } return totalCost;
        }
        
        else{
            for(int i = 0; i <= Math.abs(diff); i++){
                rs = stmt2.executeQuery("select * from datetable WHERE date='" + paraDate + "'");
                while(rs.next())
                    totalCost += rs.getInt(type);

                Calendar cal = Calendar.getInstance();
                cal.setTime(a);
                cal.add(Calendar.DATE, 1);
                a = cal.getTime();
                paraDate = sdf.format(a);
            } return totalCost;
        }
    }
    
    protected int db_getRow(String dbName) throws SQLException {
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        rs = stmt2.executeQuery("select * from " + dbName + " WHERE isCheckIn = 0");
        rs.last(); //행의 가장 끝으로 감
        int totalRecord = rs.getRow(); //전체 행의 개수
        return totalRecord;
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
    
    protected int getCost_Bill(String room_num, String type) throws SQLException { //회원정보 조회
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        int roomTcost = 0;
        int roomOcost = 0;
        int foodXcost = 0;
        int foodOcost = 0;

        rs = stmt2.executeQuery("select * from foodsystem WHERE room_num='" + room_num + "'");
        while (rs.next()) {
            foodXcost += rs.getInt("food_total_pay"); //음식 미결제금액
            foodOcost += rs.getInt("payment"); //음식 결제금액
        }
        rs = stmt2.executeQuery("select * from reservation WHERE room_num='" + room_num + "'");
        while (rs.next()) {
            roomTcost += rs.getInt("totalPrice"); //객실 총 금액
            roomOcost += rs.getInt("payment"); //객실 결제금액
        }

        switch (type) {
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
    
    protected int getCost_Report(Date a, int diff, String type) throws SQLException { //회원정보 조회
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
        Statement stmt2 = null;
        stmt2 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String paraDate = sdf.format(a);
        int totalCost = 0;

        if (type == "room") {
            for (int i = 0; i <= Math.abs(diff); i++) { //객실 추가요금
                rs = stmt2.executeQuery("select * from datetable WHERE date='" + paraDate + "'");
                while (rs.next()) {
                    totalCost += rs.getInt("extraFee");
                }

                Calendar cal = Calendar.getInstance();
                cal.setTime(a);
                cal.add(Calendar.DATE, 1);
                a = cal.getTime();
                paraDate = sdf.format(a);
            }
            return totalCost;
        } else {
            for (int i = 0; i <= Math.abs(diff); i++) {
                rs = stmt2.executeQuery("select * from datetable WHERE date='" + paraDate + "'");
                while (rs.next()) {
                    totalCost += rs.getInt(type);
                }

                Calendar cal = Calendar.getInstance();
                cal.setTime(a);
                cal.add(Calendar.DATE, 1);
                a = cal.getTime();
                paraDate = sdf.format(a);
            }
            return totalCost;
        }
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
    
    protected ArrayList<dataUSER> userList() { //사용자 정보
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
    
    
    
}
