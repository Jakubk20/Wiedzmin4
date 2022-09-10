package com.example.gra.trader1;

import com.example.gra.geralt;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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
            geralt.power += 1;
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
            geralt.power += 2;
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
    protected void onGoToTownClick(ActionEvent actionEvent) throws IOException {
    }

}
