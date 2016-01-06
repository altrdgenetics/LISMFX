/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.DialogStageLauncher;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import sceneControllers.MainSceneController;

/**
 *
 * @author Andrew
 */
public class Global {
    //INI Information
    public boolean mergeCapable    = false;
    public boolean newIndex        = false;
    public double RAM_BUFFER_SIZE  = 1024.0;
    public int dayOfWeek           = Calendar.FRIDAY;
    public int hourOfDay           = 20;
    public int MAX_BUFFERED_DOCS   = 10;
    public int MERGE_FACTOR        = 100;
    public int NUM_THREADS         = 1;
    public int THREAD_SLEEP        = 600000;
    public int WRITE_LIMIT         = 1000000000;
    public String dataDir          = null;
    public String indexDir         = null;
    
    //System Flags for Indexing
    public boolean executorRunning = false;
    public boolean exitNow         = false;
    public boolean forceExit       = false;
    public boolean lockIndex       = false;
    public boolean merge           = false;
    public Date lastIndexTime      = null;
    
    //Items for the Tray
    public boolean trayActive      = false;
    public SystemTray tray;
    public TrayIcon trayIcon;
    
    //JFX
    public Parent root;    
    public Stage  mainStage;
    public DialogStageLauncher launcher;
    public Image logoImage;
    
    //Other Defaults
    public Thread threadOne, threadTwo;
    public MainSceneController mainPanel;
    public SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
    
    /**
     * Links up the main panel for access across the application
     * 
     * @param mainPanel mainPanel class
     */
    public void setMainPanel(MainSceneController mainPanel) {
        this.mainPanel = mainPanel;
    }

    /**
    * When building the list to index file this is the verified list of 
    * types we can handle.
    * 
    * @param file The path for the file. We only look at the suffix of the path.
    * @return boolean - (true/false) for verification of file type.
    */
    public static boolean validateFileType(Path file){
        return  
            //Microsoft Office Format
            file.toString().endsWith(".wps")  ||
            file.toString().endsWith(".doc")  ||
            file.toString().endsWith(".docx") ||
            file.toString().endsWith(".docm") ||
            file.toString().endsWith(".ppt")  ||
            file.toString().endsWith(".pptm") ||
            file.toString().endsWith(".pptx") ||
            file.toString().endsWith(".xlx")  ||
            file.toString().endsWith(".xlxm") ||
            file.toString().endsWith(".xlsx") ||

            //Open Office Format
            file.toString().endsWith(".odt")  ||
            file.toString().endsWith(".odp")  ||
            file.toString().endsWith(".ods")  ||

            //Other
            file.toString().endsWith(".pdf")  ||
            file.toString().endsWith(".txt")  ||
            file.toString().endsWith(".rtf")  ||
            file.toString().endsWith(".epub") ||
            file.toString().endsWith(".xml")  ||
            file.toString().endsWith(".htm")  ||
            file.toString().endsWith(".html") ||
            file.toString().endsWith(".mhtml")||
            file.toString().endsWith(".csv")   ;
    }
    
    /**
     * Pass the printout information to the main panel for display.
     * 
     * @param global This is for reference to the global class variables 
     * and methods.
     * @param text This is the information that will be displayed on the main
     * panel.
     */
    public static void indexPanelPrintOut(Global global, String text) {
        global.mainPanel.getMainTextArea().appendText(text);
    }
}
