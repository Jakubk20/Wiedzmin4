package com.example.gra;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WalkaZBiesem {
    @FXML
    private Label sila;
    @FXML
    private Label balans;
    @FXML
    private Label hapeki;
    @FXML
    protected  void onPokazz(){
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.HP));


    }
}
