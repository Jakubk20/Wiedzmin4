package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class Handlarz1 {
    @FXML
    private Label hp;
    @FXML
    private Label money;
    @FXML
    private Label sila;
    @FXML
    private Label maxhp;
    @FXML
    protected void initialize(){
        hp.setText(String.valueOf(Geralt.CurrentHP));
        maxhp.setText(String.valueOf(Geralt.MaxHP));
        sila.setText(String.valueOf(Geralt.power));
        money.setText(String.valueOf(Geralt.money));
    }
    @FXML
    protected void onOstrzenieMieczaClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 100){
            Geralt.power += 1;
            Geralt.money -= 100;
            hp.setText(String.valueOf(Geralt.CurrentHP));
            maxhp.setText(String.valueOf(Geralt.MaxHP));
            sila.setText(String.valueOf(Geralt.power));
            money.setText(String.valueOf(Geralt.money));
        }
    }
    @FXML
    protected void onLeczenieClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 50 && Geralt.CurrentHP<(Geralt.MaxHP -10)){
            Geralt.CurrentHP += 10;
            Geralt.money -= 50;
            hp.setText(String.valueOf(Geralt.CurrentHP));
            maxhp.setText(String.valueOf(Geralt.MaxHP));
            sila.setText(String.valueOf(Geralt.power));
            money.setText(String.valueOf(Geralt.money));
        }
    }
    @FXML
    protected void onRunaNaMieczClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 180){
            Geralt.power += 2;
            Geralt.money -= 180;
            hp.setText(String.valueOf(Geralt.CurrentHP));
            maxhp.setText(String.valueOf(Geralt.MaxHP));
            sila.setText(String.valueOf(Geralt.power));
            money.setText(String.valueOf(Geralt.money));
        }
    }
    @FXML
    protected void onMocneLeczenieClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 90 && Geralt.CurrentHP<(Geralt.MaxHP-20)){
            Geralt.CurrentHP += 20;
            Geralt.money -= 90;
            hp.setText(String.valueOf(Geralt.CurrentHP));
            maxhp.setText(String.valueOf(Geralt.MaxHP));
            sila.setText(String.valueOf(Geralt.power));
            money.setText(String.valueOf(Geralt.money));
        }
    }
    @FXML
    protected void onMiksturaHPClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 250) {
            Geralt.amountOfPotions++;
            Geralt.money -= 250;
            hp.setText(String.valueOf(Geralt.CurrentHP));
            maxhp.setText(String.valueOf(Geralt.MaxHP));
            sila.setText(String.valueOf(Geralt.power));
            money.setText(String.valueOf(Geralt.money));
        }
    }

}
