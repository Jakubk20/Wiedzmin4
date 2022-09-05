package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Utopiec {
    static int power = 100;
    static int HP = 100;

    public static int onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(5, 10) * power / 100;
        return attack;
    }
}

