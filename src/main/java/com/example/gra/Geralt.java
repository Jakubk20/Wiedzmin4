package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Geralt {
    static double power = 15;
    static int money;
    static int HP = 100;

    public static int onNormalAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(10, 20);
        return attack;
    }

    public static int onStrongAttack(ActionEvent actionEvent) {
        Random random = new Random();
        int attack = random.nextInt(0, 40);
        return attack;
    }
}
