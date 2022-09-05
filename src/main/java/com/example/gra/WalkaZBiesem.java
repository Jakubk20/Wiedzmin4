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
    private Label hapekiBiesa;
    @FXML
    private Label silaBiesa;
    @FXML
    private Label pozoHPGeralt;
    @FXML
    private Label pozoHPBies;
    @FXML
    protected  void onPokazz(){
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.HP));
        pozoHPGeralt.setText(String.valueOf(Geralt.HP));
    }
    @FXML
    protected  void onPokazzz(){
        hapekiBiesa.setText(String.valueOf(Bies.HPB));
        silaBiesa.setText(String.valueOf(Bies.power));
        pozoHPBies.setText(String.valueOf(Bies.HPB));
    }
}
