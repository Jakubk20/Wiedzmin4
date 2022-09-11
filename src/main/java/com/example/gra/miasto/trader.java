package com.example.gra.miasto;

import com.example.gra.geralt;
import com.example.gra.start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.gra.startLocation.isZygfryd;

public class trader {

    @FXML
    private Label currentHP;
    @FXML
    private Label money;
    @FXML
    private Label power;
    @FXML
    private Label maxHP;
    @FXML
    private Label amountOfPotions;

    @FXML
    protected void initialize() {
        currentHP.setText(String.valueOf(geralt.currentHP));
        maxHP.setText(String.valueOf(geralt.maxHP));
        power.setText(String.valueOf(geralt.power));
        money.setText(String.valueOf(geralt.money));
        amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
    }

    @FXML
    protected void onSwordSharpeningClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 80) {
            geralt.moc += 10;
            geralt.money -= 80;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onHealingClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 40) {
            geralt.money -= 40;
            if (geralt.currentHP <= geralt.maxHP - 10) {
                geralt.currentHP += 10;
            } else geralt.currentHP = geralt.maxHP;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onSwordRuneClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 150) {
            geralt.power += 20;
            geralt.money -= 150;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onStrongHealingCLick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 100) {
            geralt.money -= 100;
            if (geralt.currentHP <= geralt.maxHP - 30) {
                geralt.currentHP += 30;
            } else geralt.currentHP = geralt.maxHP;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onHPPotionClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 200) {
            geralt.amountOfPotions += 1;
            geralt.money -= 200;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
            amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
        }
    }

    @FXML
    protected void onLeave(ActionEvent actionEvent) throws IOException {
        if (isZygfryd) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meetZygfrydAwardAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }
}
