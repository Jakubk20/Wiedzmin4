package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WygranaZBies {
    @FXML
    private Label brylki;
    @FXML
    protected void onClick(){
        brylki.setText(String.valueOf(Geralt.money));
    }
    @FXML
    protected void onDalejjClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Pierwszy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Gra");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
