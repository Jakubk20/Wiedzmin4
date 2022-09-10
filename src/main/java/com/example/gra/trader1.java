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
    protected void initialize(){
        hp.setText(String.valueOf(geralt.CurrentHP));
        maxhp.setText(String.valueOf(geralt.MaxHP));
        sila.setText(String.valueOf(geralt.power));
        money.setText(String.valueOf(geralt.money));
        potki.setText(String.valueOf(geralt.amountOfPotions));
    }
    @FXML
    protected void onOstrzenieMieczaClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 100){
            geralt.power += 1;
            geralt.money -= 100;
            hp.setText(String.valueOf(geralt.CurrentHP));
            maxhp.setText(String.valueOf(geralt.MaxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }
    @FXML
    protected void onLeczenieClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 50 && geralt.CurrentHP<(geralt.MaxHP -10)){
            geralt.CurrentHP += 10;
            geralt.money -= 50;
            hp.setText(String.valueOf(geralt.CurrentHP));
            maxhp.setText(String.valueOf(geralt.MaxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }
    @FXML
    protected void onRunaNaMieczClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 180){
            geralt.power += 2;
            geralt.money -= 180;
            hp.setText(String.valueOf(geralt.CurrentHP));
            maxhp.setText(String.valueOf(geralt.MaxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }
    @FXML
    protected void onMocneLeczenieClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 90 && geralt.CurrentHP<(geralt.MaxHP-20)){
            geralt.CurrentHP += 20;
            geralt.money -= 90;
            hp.setText(String.valueOf(geralt.CurrentHP));
            maxhp.setText(String.valueOf(geralt.MaxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
        }
    }
    @FXML
    protected void onMiksturaHPClick(ActionEvent actionEvent) throws IOException {
        if (geralt.money >= 250){
            geralt.amountOfPotions += 1;
            geralt.money -= 250;
            hp.setText(String.valueOf(geralt.CurrentHP));
            maxhp.setText(String.valueOf(geralt.MaxHP));
            sila.setText(String.valueOf(geralt.power));
            money.setText(String.valueOf(geralt.money));
            potki.setText(String.valueOf(geralt.amountOfPotions));
        }
    }

    @FXML
    protected void idzWstroneMiasta(ActionEvent actionEvent) throws IOException {
    }

}
