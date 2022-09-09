package com.example.gra.Utopiec;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Utopiec {
    public static double power = (1+4)/2;
    public static int currentHP = 550;
    public static int maxHP = 550;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(1, 4);
    }
}

