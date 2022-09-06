package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Geralt {
    public static double power = 10;
    public static int money;
    public static double CurrentHP = 100;
    public static double MaxHP = 100;

    public static double onNormalAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(10, 21);
        System.out.println(attack*power/10);
        return attack * power / 10;
    }

    public static double onStrongAttack(ActionEvent actionEvent) {
        Random random = new Random();
        int attack = random.nextInt(0, 71);
        System.out.println(attack*power/10);
        return attack * power / 10;
    }
}
