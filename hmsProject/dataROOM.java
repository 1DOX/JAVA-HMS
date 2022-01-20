package hmsProject;

class dataROOM {
    private long number;
    private int member, room_num, default_price,  totalPrice;
    private String name, address, phonenum, rate_desc, card_num, autoCancleDate, realCIdate, realCItime, guessCIdate, guessCItime,
                    realCOdate, realCOtime, feedback, payType;
    private boolean guarantee, isPay;
    
    public dataROOM(String name, String address, String phonenum, int member, int room_num, int default_price, String rate_desc, boolean guarantee,
            String card_num, long number, String autoCancleDate, String realCIdate, String realCItime, String guessCIdate, String guessCItime,
            String realCOdate, String realCOtime, String feedback, boolean isPay, String payType, int totalPrice)
    {
        this.name = name;
        this.address = address;
        this.phonenum = phonenum;
        this.member = member;
        this.room_num = room_num;
        this.default_price = default_price;
        this.rate_desc = rate_desc;
        this.guarantee = guarantee;
        this.card_num = card_num;
        this.number = number;
        this.autoCancleDate = autoCancleDate;
        this.realCIdate = realCIdate;
        this.realCItime = realCItime;
        this.guessCIdate = guessCIdate;
        this.guessCItime = guessCItime;
        this.realCOdate = realCOdate;
        this.realCOtime = realCOtime;
        this.feedback = feedback;
        this.isPay = isPay;
        this.payType = payType;
        this.totalPrice = totalPrice;
    }

    public int getMember() {
        return member;
    }

    public int getRoom_num() {
        return room_num;
    }

    public int getDefault_price() {
        return default_price;
    }

    public long getNumber() {
        return number;
    }

    public int getTotalPrice() {
        return totalPrice;
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

    public String getRate_desc() {
        return rate_desc;
    }

    public String getCard_num() {
        return card_num;
    }

    public String getAutoCancleDate() {
        return autoCancleDate;
    }

    public String getRealCIdate() {
        return realCIdate;
    }

    public String getRealCItime() {
        return realCItime;
    }

    public String getGuessCIdate() {
        return guessCIdate;
    }

    public String getGuessCItime() {
        return guessCItime;
    }

    public String getRealCOdate() {
        return realCOdate;
    }

    public String getRealCOtime() {
        return realCOtime;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getPayType() {
        return payType;
    }

    public boolean isGuarantee() {
        return guarantee;
    }

    public boolean isIsPay() {
        return isPay;
    }
    
}
