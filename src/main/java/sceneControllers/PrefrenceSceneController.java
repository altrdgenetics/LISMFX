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
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import util.Global;

/**
 * FXML Controller class
 *
 * @author Andrew
 */
public class PrefrenceSceneController implements Initializable {

    Stage dialogStage;
    Global global;
    
    @FXML
    private TextField IndexDirectoryTextField;
    @FXML
    private TextField DataDirectoryTextField;
    @FXML
    private CheckBox CreateNewIndexCheckBox;
    @FXML
    private TextField NumberOfThreadsTextField;
    @FXML
    private TextField RAMBufferTextField;
    @FXML
    private TextField ThreadSleepTextField;
    @FXML
    private TextField WriteLimitTextField;
    @FXML
    private TextField MaxBufferedDocsTextField;
    @FXML
    private TextField MergeFactorTextField;
    @FXML
    private CheckBox MergeCheckBox;
    @FXML
    private TextField DayTextField;
    @FXML
    private TextField HourTextField;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDefaults(Global globalPassed, Stage dialogStagePassed) {
        this.global = globalPassed;
        this.dialogStage = dialogStagePassed;
        loadInformation();
    } 
    
    private void loadInformation() {
        IndexDirectoryTextField.setText(global.indexDir);
        DataDirectoryTextField.setText(global.dataDir);
        CreateNewIndexCheckBox.setSelected(global.newIndex);
        NumberOfThreadsTextField.setText(String.valueOf(global.NUM_THREADS));
        RAMBufferTextField.setText(String.valueOf(global.RAM_BUFFER_SIZE));
        ThreadSleepTextField.setText(String.valueOf(global.THREAD_SLEEP));
        WriteLimitTextField.setText(String.valueOf(global.WRITE_LIMIT));
        MaxBufferedDocsTextField.setText(String.valueOf(global.MAX_BUFFERED_DOCS));
        MergeFactorTextField.setText(String.valueOf(global.MERGE_FACTOR));
        MergeCheckBox.setSelected(global.mergeCapable);
        DayTextField.setText(String.valueOf(global.dayOfWeek));
        HourTextField.setText(String.valueOf(global.hourOfDay));
    }
    
    @FXML
    private void closeScene(){
        dialogStage.close();
    }
    
}
