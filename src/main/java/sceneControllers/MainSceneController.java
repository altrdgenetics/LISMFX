/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sceneControllers;

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
    
    public TextArea getMainTextArea() {
        return mainTextArea;
    }

    public void setMainTextArea(TextArea mainTextArea) {
        this.mainTextArea = mainTextArea;
    }
    
}
