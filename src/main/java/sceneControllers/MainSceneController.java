/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sceneControllers;

import indexer.LuceneIndexer;
import indexer.ThreadIndexing;
import indexer.ThreadMergeScheduler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import util.Global;
import util.ParseTime;

/**
 * FXML Controller class
 *
 * @author Andrew
 */
public class MainSceneController implements Initializable {

    Global global;
    
    @FXML
    private TextArea mainTextArea;
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDefaults(Global globalPassed) {
        global = globalPassed;     
        global.mainPanel = this;
        //NEED TRAY ICON        
        lastIndexTime();
        runMergeTimerThread();
        runIndexThread();
    }   
    
    @FXML
    private void menuItemClearText() {
        mainTextArea.clear();
    }
    
    @FXML
    private void menuItemPreferences() {
        
    }
    
    @FXML
    private void menuItemForceExit() {
        global.forceExit = true;
        if (global.executorRunning == true){
            LuceneIndexer.kill();
        }
        System.err.println("EXIT NOW!");
        exitApplication();
    }
    
    @FXML
    private void menuItemExit() {
        exitApplication();
    }
    
    
    /**
     * Exit the Application as long as the index is not locked
     */
    private void exitApplication() {
        if (global.lockIndex == false) {
            System.exit(0);
        } else {
            global.exitNow = true;
        }
    }
    
    /**
     * If we are just updating the index and not creating a new one we pull the 
     * last time the index was ran if the application was closed out. That way
     * we can limit the amount of files that need to be index.
     */
    private void lastIndexTime(){
        if (global.newIndex == false){
            ParseTime connectionIni = new ParseTime();
            global.lastIndexTime = connectionIni.getLastIndexTime();
        }
    }  
    
    /**
     * When the INI flag is set to allow merging this sets the timer so we can
     * merge when the Day of the week and hour allows us to do so.
     */
    private void runMergeTimerThread() {
        if (global.mergeCapable == true){
        global.threadTwo = new Thread() {
            @Override
            public void run() {
                ThreadMergeScheduler mrg = new ThreadMergeScheduler();
                mrg.MergeThread(global);
            }
        };
        global.threadTwo.start();
        }
    }
    
    /**
     * The thread for in indexing. Separating it out allows for the updating of 
     * the AWT elements so we can duplicate the console text.
     */
    private void runIndexThread() {
        global.threadOne = new Thread() {
            @Override
            public void run() {
                ThreadIndexing ixd = new ThreadIndexing();
                ixd.IndexThread(global);
            }
        };
        global.threadOne.start();
    }
    
    public TextArea getMainTextArea() {
        return mainTextArea;
    }

    public void setMainTextArea(TextArea mainTextArea) {
        this.mainTextArea = mainTextArea;
    }
    
}
