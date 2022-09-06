package com.example.gra;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Utopiec {
    static double power = 10;
    static double HP = 100;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(5, 10);
        return attack * power/10;
    }
}

