package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Pierwszy extends Bies{

    @FXML
    private Label silla;
    @FXML
    private Label ballans;


    @FXML
    protected  void onPokaz(){
        ballans.setText(String.valueOf(getBalans()));
        silla.setText(String.valueOf(getSila()));
        System.out.println(getBalans());
        System.out.println(getSila());
//        getBalans() = onFight();
        System.out.println(balanss());
        System.out.println(silaa());
    }

}
