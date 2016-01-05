/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sceneControllers;

import indexer.ThreadIndexing;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import util.Global;

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
        
    }
    
    @FXML
    private void menuItemExit() {
        
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
