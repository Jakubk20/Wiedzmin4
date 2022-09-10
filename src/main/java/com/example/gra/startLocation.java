package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class startLocation {
    @FXML
    protected void onTavernClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tavern/getQuest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onLeaveClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("utopiec/meet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onReturnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tavern/startLocation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onGetQuestClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bies/meet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


}
