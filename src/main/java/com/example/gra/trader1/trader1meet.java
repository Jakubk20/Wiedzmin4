package com.example.gra.trader1;

import com.example.gra.start;
import com.example.gra.startLocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class trader1meet {
    @FXML
    protected void onTrader(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("trader1/trader1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    public void onGo(ActionEvent actionEvent) throws IOException {
        if (startLocation.isQuest && startLocation.isBiesDefeated){
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadQuestAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (startLocation.isQuest){
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadQuestNotDone.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySad.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

}
