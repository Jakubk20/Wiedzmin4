package com.example.gra.utopiec;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class utopiec {
    public static double power = ((1+4)/2);
    public static int maxHP = 300;
    public static int currentHP = maxHP;
    public static boolean isDefeated = false;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(1, 4);
    }
}

