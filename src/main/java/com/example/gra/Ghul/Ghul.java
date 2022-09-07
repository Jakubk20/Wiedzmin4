package com.example.gra.Ghul;

import javafx.event.ActionEvent;

import java.io.IOException;
import java.util.Random;

public class Ghul {
    public static double power = 2;
    public static int currentHP = 550;
    public static int maxHP = 550;

    public static double onAttack(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int attack = random.nextInt(1, 11);
        System.out.println(attack*power/10);
        return attack * power / 10;
    }
}
