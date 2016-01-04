/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sceneControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import util.Global;

/**
 * FXML Controller class
 *
 * @author Andrew
 */
public class MainSceneController implements Initializable {

    Global global;
    
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
    
}
