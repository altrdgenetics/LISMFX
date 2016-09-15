/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sceneControllers.*;
import util.Exceptions;
import util.Global;

/**
 *
 * @author Andrew
 */
public class DialogStageLauncher {
    
    public void MainScene(Global global, Stage stage) {
        global.mainStage = stage;
        global.logoImage = new Image(getClass().getResourceAsStream("/images/image.png"));
        stage.getIcons().add(global.logoImage);
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/MainScene.fxml"));
            global.root = (Parent)fxmlLoader.load();
            MainSceneController controller = fxmlLoader.<MainSceneController>getController();
            controller.setDefaults(global);    
            
            Scene scene = new Scene(global.root);
            global.mainStage.setResizable(false);
            global.mainStage.setScene(scene);
            global.mainStage.show();
        } catch (IOException e) {
            Exceptions.IOException(e);
        }
    }
    
    public void TicketArchiveScene(Global global) {
        try {
            // Load the fxml file and create a new stage for the popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/PrefrenceScene.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(global.mainStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            PrefrenceSceneController controller = loader.<PrefrenceSceneController>getController();
            controller.setDefaults(global, dialogStage);

            dialogStage.show();
        } catch (IOException e) {
            Exceptions.IOException(e);
        }
    }
}
