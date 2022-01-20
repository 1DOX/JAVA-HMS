/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_Reservation;

/**
 *
 * @author yangchang-yun
 */
//room = new dataROOM(rs.getString("name"), rs.getString("address"), rs.getString("phonenum"), rs.getInt("member"), rs.getInt("room_num"), 
//               rs.getBoolean("guarantee"), rs.getString("card_num"), rs.getLong("number"), rs.getString("autoCancleDate"), 
//                     rs.getString("guessCIdate"), rs.getString("guessCItime"), re.getString("guessCOdate"), re.getString("guessCOtime"),
//                  rs.getString("feedback"), rs.getBoolean("isPay"), rs.getString("payType"), rs.getInt("totalPrice"));
//        bookingList.add(room);
public class BookingList {

    String name, address, phonenum, card_num, autoCancleDate, feedback, payType, guessCIdate, guessCItime, guessCOdate, guessCOtime;
    long number;
    int member, room_num, totalPrice, default_price;
    boolean guarantee, isPay;

    public BookingList(String name, String address, String phonenum, int member, int room_num, boolean guarantee, String card_num, long number, String autoCancleDate, int default_price,
            String guessCIdate, String guessCItime, String guessCOdate, String guessCOtime, String feedback, boolean isPay, String payType, int totalPrice) {
        this.name = name;
        this.address = address;
        this.phonenum = phonenum;
        this.member = member;
        this.room_num = room_num;
        this.guarantee = guarantee;
        this.card_num = card_num;
        this.number = number;
        this.autoCancleDate = autoCancleDate;
        this.default_price = default_price;
        this.guessCIdate = guessCIdate;
        this.guessCItime = guessCItime;
        this.guessCOdate = guessCOdate;
        this.guessCOtime = guessCOtime;
        this.feedback = feedback;
        this.isPay = isPay;
        this.payType = payType;
        this.totalPrice = totalPrice;
    }

    public int getdefault_price(){
        return default_price;
    }
    public String getGuessCIdate() {
        return guessCIdate;
    }

    public String getGuessCItime() {
        return guessCItime;
    }

    public String getGuessCOdate() {
        return guessCOdate;
    }

    public String getGuessCOtime() {
        return guessCOtime;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public String getCard_num() {
        return card_num;
    }

    public String getAutoCancleDate() {
        return autoCancleDate;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getPayType() {
        return payType;
    }

    public long getNumber() {
        return number;
    }

    public int getMember() {
        return member;
    }

    public int getRoom_num() {
        return room_num;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public boolean isIsPay() {
        return isPay;
    }
}
