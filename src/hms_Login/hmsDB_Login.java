/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_Login;

import java.sql.SQLException;
import java.sql.Statement;
import hms_Main.hmsDB;

/**
 *
 * @author 송진영
 */
public class hmsDB_Login extends hmsDB{
      
       
       protected boolean getDB(String a, String b) throws SQLException { //로그인
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

       
}
