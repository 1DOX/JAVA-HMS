/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms_Main;

/**
 *
 * @author 송진영
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class hotelTimer extends hmsDB implements Runnable {
    
    @Override
    public void run(){
        dbLoad();
        while(true){
            try {
                
                Date date = new Date();
                SimpleDateFormat ft = new SimpleDateFormat("YYYY-MM-dd '  |  ' a hh:mm:ss");
                String theDate = ft.format(date);
                
                hmsGUI.hotelTimerLabel.setText(theDate);
                String guarantee = guarantee();
                String room_num = guarantee;

                if(guarantee()!= null)
                {

                   Canclebooking(room_num);
                }

                
                Thread.sleep(1000);
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
       dbClose();
        
    }
    String guarantee() // 체크인날에 무보증인 객실 조회
    {
        dbLoad();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        String YE = Integer.toString(year);
        String MO = null;
        if(month < 10)  MO= "0"+Integer.toString(month);
        else MO = Integer.toString(month);
        String DA = null;
        if(day < 10) DA = "0"+Integer.toString(day);
        else DA = Integer.toString(day);
        String SH = null;
        if(hour < 10) SH = "0"+Integer.toString(hour);
        else SH = Integer.toString(hour);
        String SM = null;
        if(min <10) SM = "0" + Integer.toString(min);
        else SM = Integer.toString(min);
        String SS = null;
        if(sec <10) SS = "0"+Integer.toString(sec);
        else SS = Integer.toString(sec);
        String date = YE+"-"+MO+"-"+DA;
        String time = SH + SM + SS;
        String cancle = "180000";
        int Itime = Integer.parseInt(time);
        int Icancle = Integer.parseInt(cancle);
        String guarantee = notguarantee(date);
        dbClose();
        if(guarantee==null) return null;
        else
        {
            if(Itime >= Icancle)
            {
                return guarantee;
            }
            else return null;
        }
    }
}
