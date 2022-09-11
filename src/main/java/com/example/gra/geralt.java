package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class geralt {

    public static int moc = 60;
    public static double power = ((10 + 20) / 2) + moc;
    public static int money = 0;
    public static int currentHP = 100;
    public static int maxHP = 100;
    public static int amountOfPotions = 0;

    public static double onNormalAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(10, 21);
        return attack + moc;
    }

    public static double onStrongAttack(ActionEvent actionEvent) {
        Random random = new Random();
        int attack = random.nextInt(1, 41);
        return attack + moc;
    }

    public static void death(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("death.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
