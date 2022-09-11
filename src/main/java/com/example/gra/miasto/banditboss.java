package com.example.gra.miasto;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class banditboss {
    public static double power = ((1 + 5) / 2);
    public static int maxHP = 300;
    public static int currentHP = maxHP;
    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(1, 6);
    }
}
