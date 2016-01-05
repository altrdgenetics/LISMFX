/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indexer;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Global;

/**
 *
 * @author Andrew
 */
public class ThreadIndexing {
    
    private final boolean indexGUI = true;
    
    /**
     * Thread for indexing with Lucene 
     * 
     * @param global This is for reference to the global class variables 
     * and methods.
     */
    public void IndexThread(Global global) {
        try {
            Thread.sleep(1000);
            while (true) {
                try {
                    //lock index so the application can cleanly exit.
                    global.lockIndex = true;
                    
                    //Index the files to the database
                    LuceneIndexer.IndexFiles(global, global.newIndex, indexGUI);
                    
                    //Printout the sleep information
                    System.out.println("Sleeping for: " + TimeUnit.MILLISECONDS.toMinutes(global.THREAD_SLEEP) + "min");
                    if (indexGUI){
                        global.mainPanel.getMainTextArea().appendText("\n\n");
                        global.mainPanel.getMainTextArea().appendText("Sleeping for: " + TimeUnit.MILLISECONDS.toMinutes(global.THREAD_SLEEP) + "min");
                        global.mainPanel.getMainTextArea().appendText("\n\n\n\n");
                    }
                    //unlock the application
                    global.lockIndex = false;
                    
                    //If exit flag exists exit the application safely
                    if (global.exitNow == true){
                        if (global.trayActive == true){
                            global.tray.remove(global.trayIcon);
                        }
                        System.exit(0);
                    }
                    //Sleep the thread based on the INI file variable.
                    Thread.sleep(global.THREAD_SLEEP);
                    
                } catch (InterruptedException ex) {
                   Logger.getLogger(ThreadIndexing.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThreadIndexing.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
