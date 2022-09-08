package com.example.gra.Leszy;

import com.example.gra.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Lesz {
    Random random = new Random();
    public static double power = 10;
    public static double currentHP = 500;
    public static double maxHP = 500;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(4, 8);
        System.out.println(attack*power/10);
        return attack * power / 10;
    }


    @FXML
    protected void onFight(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("walkaZLeszem.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Walka z Lesz");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        int chance = random.nextInt(0, 100);
        if (chance >= 10) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Wygrana.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Udaje ci się uciec !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Śmierć.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Giniesz!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

}
