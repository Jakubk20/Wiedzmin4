package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Śmierć {
    @FXML
    protected void onZagrajPonownieClick(ActionEvent actionEvent) throws IOException {
        Geralt.power=10;
        Geralt.CurrentHP =100;
        Geralt.MaxHP=100;
        Geralt.money=0;
        Geralt.amountOfPotions = 0;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Zaczynamy!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
