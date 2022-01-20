package hmsProject;

class dataUSER {
    private int isAdmin;
    private String UserID, UserPW;
    
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
