package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class instruction {
    @FXML
    protected void onHelloButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("tavern/startLocation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    public void onInstructionButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("instruction.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    public void onReturnButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

}
