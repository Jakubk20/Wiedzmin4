package com.example.gra.bies;

import com.example.gra.start;
import com.example.gra.geralt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class bies {
    Random random = new Random();
    public static double power = ((1 + 2) / 2);
    public static int maxHP = 600;
    public static int currentHP = maxHP;

    public static double onAttack() {
        Random random = new Random();
        return random.nextInt(1, 3);
    }


    @FXML
    protected void onFight(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bies/fight.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        int chance = random.nextInt(0, 100);
        if (chance >= 20) {
            fight.runSuccessful(actionEvent);
        } else {
            geralt.death(actionEvent);
        }
    }

}
