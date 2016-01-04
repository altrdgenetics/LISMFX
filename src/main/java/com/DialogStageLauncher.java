/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sceneControllers.*;
import util.Exceptions;
import util.Global;

/**
 *
 * @author Andrew
 */
public class DialogStageLauncher {
    public void MainScene(Global global) {
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
}
