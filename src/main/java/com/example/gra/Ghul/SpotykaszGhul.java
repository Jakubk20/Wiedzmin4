package com.example.gra.Ghul;

import com.example.gra.Geralt;
import com.example.gra.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class SpotykaszGhul {
    @FXML
    protected void onWalcz(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ghul/walkaZGhul.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onUciekaj(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int chance = random.nextInt(0, 100);
        if (chance >= 20) {
            WalkaZGhul.runSuccessful(actionEvent);
        } else {
            Geralt.death(actionEvent);
        }
    }
}
