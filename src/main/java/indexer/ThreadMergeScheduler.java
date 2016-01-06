/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexer;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Global;

/**
 *
 * @author Andrew
 */
public class ThreadMergeScheduler {

    /**
     * Checks the Date and time in order to set the flag for merging
     * 
     * @param global This is for reference to the global class variables 
     * and methods.
     */
    public void MergeThread(Global global) {
        try {
            Thread.sleep(1000);
            while (true) {
                try {
                    //compare date and time
                    checkTime(global);
                    
                    if(global.merge){
                        //Sleeping for 6days
                        Thread.sleep(518400000);
                    } else {
                        //Sleeping for 25 min
                        Thread.sleep(1500000);
                    }
                } catch (InterruptedException ex) {
                   Logger.getLogger(ThreadIndexing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadIndexing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * compares date and time against the global variables and enables the flag
     * for the merge process
     * 
     * @param global This is for reference to the global class variables 
     * and methods.
     */
    private void checkTime(Global global) {
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);        
        
        if (calendar.get(Calendar.DAY_OF_WEEK) == global.dayOfWeek 
                && calendar.get(Calendar.HOUR_OF_DAY) >= global.hourOfDay) {
            global.merge = true;
        }
    }

}
