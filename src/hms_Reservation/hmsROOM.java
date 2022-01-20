/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_Reservation;

import hms_Main.*;

/**
 *
 * @author 
 */
public class hmsROOM{
    int room_num, cost, changeCost;
    String rate_desc;
    
       public hmsROOM(int room_num, int cost, int change_cost, String rate_desc){
           this.room_num = room_num;
           this.cost = cost;
           this.changeCost = change_cost;
           this.rate_desc = rate_desc;
       }

    public int getroom_num(){
        return room_num;
    }
    
    public int getCost() {
        return cost;
    }

    public int getChangeCost() {
        return changeCost;
    }

    public String getRate_desc() {
        return rate_desc;
    }
    
}