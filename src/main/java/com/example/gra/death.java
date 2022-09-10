package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class death {
    @FXML
    protected void onZagrajPonownieClick(ActionEvent actionEvent) throws IOException {
        geralt.power=10;
        geralt.CurrentHP =100;
        geralt.MaxHP=100;
        geralt.money=0;
        geralt.amountOfPotions = 0;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
