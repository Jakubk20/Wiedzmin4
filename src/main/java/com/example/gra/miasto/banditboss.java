package com.example.gra.miasto;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class banditboss {
    public static double power = ((3 + 6) / 2);
    public static int maxHP = 1000;
    public static int currentHP = maxHP;
    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(3, 7);
    }
}
