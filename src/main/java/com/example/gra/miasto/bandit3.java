package com.example.gra.miasto;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class bandit3 {
    public static double power = ((2 + 4) / 2);
    public static int maxHP = 500;
    public static int currentHP = maxHP;
    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(2, 5);
    }
}
