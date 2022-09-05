package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Pierwszy{

    @FXML
    private Label silla;
    @FXML
    private Label ballans;
    @FXML
    private Label zdrowie;



    @FXML
    protected  void onPokaz(){
        ballans.setText(String.valueOf(Geralt.money));
        silla.setText(String.valueOf(Geralt.power));
        zdrowie.setText(String.valueOf(Geralt.HP));


    }

}
