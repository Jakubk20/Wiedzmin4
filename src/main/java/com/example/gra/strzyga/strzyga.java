package com.example.gra.strzyga;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class strzyga {
    public static double power = ((4 + 16) / 2);
    public static int maxHP = 600;
    public static int currentHP = maxHP;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        return random.nextInt(4, 17);
    }
}
