package com.example.gra.Utopiec;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Utopiec {
     public static double power = 3;
    public static double currentHP = 550;
    public static double maxHP = 550;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(1, 11);
        System.out.println(attack*power/10);
        return attack * power / 10;
    }
}

