package com.example.gra.ghul;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class ghul {
    public static double power = (1 + 2) / 2;
    public static int maxHP = 420;
    public static int currentHP = maxHP;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(1, 3);
    }
}
