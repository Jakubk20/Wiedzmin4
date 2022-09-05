package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Pierwszy extends Geralt{

    @FXML
    private Label silla;
    @FXML
    private Label ballans;



    @FXML
    protected  void onPokaz(){
        ballans.setText(String.valueOf(money));
        silla.setText(String.valueOf(power));

    }

}
