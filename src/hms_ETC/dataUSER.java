package hms_ETC;

import hms_Main.*;

class dataUSER {
    private int isAdmin;
    private String UserID, UserPW,room_num ;
    
    public dataUSER(int isAdmin,String UserID,String UserPW)
    {
        this.isAdmin = isAdmin;
        this.UserID = UserID;
        this.UserPW = UserPW;
    }
    
    public int getisAdmin(){
        return isAdmin;
    }
    public String getUserID(){
        return UserID;
    }
    public String getUserPW(){
        return UserPW;
    }
}
