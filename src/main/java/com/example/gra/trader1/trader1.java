package com.example.gra.trader1;

import com.example.gra.geralt;
import com.example.gra.start;
import com.example.gra.startLocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class trader1 {
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
        if (geralt.money >= 100) {
            geralt.moc += 10;
            geralt.power = ((10 + 20) / 2) + geralt.moc;
            geralt.money -= 100;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onHealingClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 50) {
            geralt.money -= 50;
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
        if (geralt.money >= 180) {
            geralt.moc += 20;
            geralt.power = ((10 + 20) / 2) + geralt.moc;
            geralt.money -= 180;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onStrongHealingCLick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 90) {
            geralt.money -= 90;
            if (geralt.currentHP <= geralt.maxHP - 20) {
                geralt.currentHP += 20;
            } else geralt.currentHP = geralt.maxHP;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onHPPotionClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 250) {
            geralt.amountOfPotions += 1;
            geralt.money -= 250;
            currentHP.setText(String.valueOf(geralt.currentHP));
            maxHP.setText(String.valueOf(geralt.maxHP));
            power.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
            amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
        }
    }

    @FXML
    public void onLeave(ActionEvent actionEvent) throws IOException {
        if (startLocation.isQuest && startLocation.isBiesDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadQuestAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (startLocation.isQuest) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadQuestNotDone.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySad.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

}
