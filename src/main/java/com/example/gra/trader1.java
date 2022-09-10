package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class trader1 {
    @FXML
    private Label hp;
    @FXML
    private Label money;
    @FXML
    private Label sila;
    @FXML
    private Label maxhp;
    @FXML
    private Label potki;

    @FXML
    protected void initialize() {
        hp.setText(String.valueOf(geralt.currentHP));
        maxhp.setText(String.valueOf(geralt.maxHP));
        sila.setText(String.valueOf(geralt.power));
        money.setText(String.valueOf(geralt.money));
        potki.setText(String.valueOf(geralt.amountOfPotions));
    }

    @FXML
    protected void onSwordSharpeningClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 100) {
            geralt.power += 1;
            geralt.money -= 100;
            hp.setText(String.valueOf(geralt.currentHP));
            maxhp.setText(String.valueOf(geralt.maxHP));
            sila.setText(String.valueOf(geralt.power));
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
            hp.setText(String.valueOf(geralt.currentHP));
            maxhp.setText(String.valueOf(geralt.maxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onSwordRuneClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 180) {
            geralt.power += 2;
            geralt.money -= 180;
            hp.setText(String.valueOf(geralt.currentHP));
            maxhp.setText(String.valueOf(geralt.maxHP));
            sila.setText(String.valueOf(geralt.power));
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
            hp.setText(String.valueOf(geralt.currentHP));
            maxhp.setText(String.valueOf(geralt.maxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }

    @FXML
    protected void onHPPotionClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 250) {
            geralt.amountOfPotions += 1;
            geralt.money -= 250;
            hp.setText(String.valueOf(geralt.currentHP));
            maxhp.setText(String.valueOf(geralt.maxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
            potki.setText(String.valueOf(geralt.amountOfPotions));
        }
    }

    @FXML
    protected void onGoToTownClick(ActionEvent actionEvent) throws IOException {
    }

}
