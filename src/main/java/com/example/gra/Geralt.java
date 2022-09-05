package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Geralt {
    static double power = 120;
    static int money;
    static double HP = 100;

    public static double onNormalAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(10, 21);
        System.out.println(attack);
        return attack * power / 100;
    }

    public static double onStrongAttack(ActionEvent actionEvent) {
        Random random = new Random();
        int attack = random.nextInt(0, 71);
        System.out.println(attack);
        return attack * power / 100;
    }
}
