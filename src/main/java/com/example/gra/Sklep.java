package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Sklep {
    public static void onOstrzenieMieczaClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 100){
            Geralt.power += 1;
            Geralt.money -= 100;
        }
    }

    public static void onLeczenieClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 50){
            Geralt.CurrentHP += 10;
            Geralt.money -= 50;
        }
    }

    public static void onRunaNaMieczClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 180){
            Geralt.power += 2;
            Geralt.money -= 180;
        }
    }

    public static void onMocneLeczenieClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 90){
            Geralt.CurrentHP += 20;
            Geralt.money -= 90;
        }
    }

    public static void onMiksturaHPClick(ActionEvent actionEvent) throws IOException {
        if (Geralt.money >= 250){
            Geralt.CurrentHP += 30;
            Geralt.money -= 250;
        }
    }

}
