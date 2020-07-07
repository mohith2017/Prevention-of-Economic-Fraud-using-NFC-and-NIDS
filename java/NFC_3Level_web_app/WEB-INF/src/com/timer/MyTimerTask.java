package com.timer;

import java.sql.SQLException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import com.Database.UserDAO;


public class MyTimerTask extends TimerTask {
	
	public static void main(String[] args) {

	 TimerTask timerTask = new MyTimerTask();
     //running timer task as daemon thread
     Timer timer = new Timer(true);
     timer.scheduleAtFixedRate(timerTask, 0, 10*1000);
     System.out.println("TimerTask started");
     //cancel after sometime
     try {
         Thread.sleep(12000000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     timer.cancel();
     System.out.println("TimerTask cancelled");
     try {
         Thread.sleep(30000);
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
     
	}
	
    @Override
    public void run() {
        System.out.println("Timer task started at:"+new Date());
        try {
			completeTask();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Timer task finished at:"+new Date());
    }

    private void completeTask() throws SQLException {
        try {
        	
        	
     boolean flag=   	UserDAO.selectdata();
        if(flag==false)
        {
        	
        	
        	
        }else
        {
        	
        	UserDAO.deletedata();
        	System.out.println("deleted");
        	
        }
        	
            //assuming it takes 60 secs to complete the task
     Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

  
}