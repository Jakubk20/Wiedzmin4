package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Geralt {
    static int power = 100;
    static int money;
    static int HP = 100;
    protected int  onNormalAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(10, 20) * Geralt.power / 100;
        return attack;
    }

    protected int onStrongAttack(ActionEvent actionEvent) {
        Random random = new Random();
        int attack = random.nextInt(0, 40) * Geralt.power / 100;
        return attack;
    }
}
