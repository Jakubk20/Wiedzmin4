package com.example.gra.strzyga;

import com.example.gra.geralt;
import com.example.gra.ghul.ghul;
import com.example.gra.start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class fight {
    @FXML
    private Label geraltPower;
    @FXML
    private Label geraltHP;
    @FXML
    private Label strzygaHP;
    @FXML
    private Label strzygaPower;
    @FXML
    private Label geraltRemainingHP;
    @FXML
    private Label strzygaRemainingHP;
    @FXML
    private Label amountOfPotions;
    @FXML
    private Label receivedDamage1;
    @FXML
    private Label receivedDamage2;
    @FXML
    private Label dealtDamage;
    @FXML
    private Label textReceivedDamage1;
    @FXML
    private Label textReceivedDamage2;
    @FXML
    private Label textDealtDamage;



    public fight() throws IOException {
    }

    @FXML
    protected void initialize(){
        strzygaHP.setText(String.valueOf(strzyga.maxHP));
        strzygaPower.setText(String.valueOf(strzyga.power));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        strzygaRemainingHP.setText(String.valueOf(strzyga.currentHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
        amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
    }
    @FXML
    protected void onPotion(ActionEvent actionEvent) {
        potionHeal(amountOfPotions, geraltRemainingHP);


    }

    public static void potionHeal(Label potki, Label pozoHPGeralt) {
        if (geralt.amountOfPotions > 0){
            if (geralt.currentHP + 30 > geralt.maxHP){
                geralt.currentHP = geralt.maxHP;
            } else geralt.currentHP += 30;
            geralt.amountOfPotions--;
            potki.setText(String.valueOf(geralt.amountOfPotions));
            pozoHPGeralt.setText(String.valueOf(geralt.currentHP));
        }
    }

    @FXML
    protected void onNormalAttack(ActionEvent actionEvent) throws IOException {
        int dealtDMGn = dealtDMGN(new ActionEvent());
        int receivedDMG1 = receivedDMG1(new ActionEvent());
        if (geralt.currentHP - receivedDMG1<= 0) {
            strzyga.currentHP = strzyga.maxHP;
            geralt.death(actionEvent);
        }
        if (strzyga.currentHP - dealtDMGn <= 0 ) {
            win(actionEvent);
        }

        if (geralt.currentHP > 0 && strzyga.currentHP > 0) {
            textDealtDamage.setText("Zadane obrażenia:");
            dealtDamage.setText(String.valueOf(dealtDMGn));
            strzyga.currentHP -= dealtDMGn;
            textReceivedDamage1.setText("Otrzymane obrażenia:");
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            geralt.currentHP -= receivedDMG1;


            textReceivedDamage2.setText("");
            receivedDamage2.setText("");
        }
        stats();
    }

    private void stats() {
        strzygaHP.setText(String.valueOf(strzyga.maxHP));
        strzygaPower.setText(String.valueOf(strzyga.power));
        strzygaRemainingHP.setText(String.valueOf(strzyga.currentHP));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
    }
    private int dealtDMGS(ActionEvent actionEvent) throws IOException {
        int dealtDMG = (int) geralt.onStrongAttack(actionEvent);
        return dealtDMG;
    }
    private int dealtDMGN(ActionEvent actionEvent) throws IOException {
        int dealtDMGN1 = (int) geralt.onNormalAttack(actionEvent);
        return dealtDMGN1;
    }
    private int receivedDMG1(ActionEvent actionEvent) throws IOException {
        int receivedDMG1 = (int) strzyga.onAttack(actionEvent);
        return receivedDMG1;
    }
    private int receivedDMG2(ActionEvent actionEvent) throws IOException {
        int receivedDMG2 = (int) strzyga.onAttack(actionEvent);
        return receivedDMG2;
    }
    @FXML
    protected void onHardAttack(ActionEvent actionEvent) throws IOException {
        int dealtDMGS = dealtDMGS(new ActionEvent());
        int receivedDMG1 = receivedDMG1(new ActionEvent());
        int receivedDMG2 = receivedDMG2(new ActionEvent());
        if (geralt.currentHP - (receivedDMG1 + receivedDMG2) <= 0) {
            geralt.death(actionEvent);
        }
        if (strzyga.currentHP - dealtDMGS <= 0 ) {
            win(actionEvent);
        }

        if (geralt.currentHP > 0 && strzyga.currentHP > 0) {
            textReceivedDamage1.setText("Otrzymane obrażenia:");
            textReceivedDamage2.setText("Otrzymane obrażenia:");
            textDealtDamage.setText("Zadane obrażenia:");
            geralt.currentHP -= receivedDMG1;
            geralt.currentHP -= receivedDMG2;
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            receivedDamage2.setText(String.valueOf(receivedDMG2));
            strzyga.currentHP -= dealtDMGS;
            dealtDamage.setText(String.valueOf(dealtDMGS));
        }
        stats();
    }

    private void win(ActionEvent actionEvent) throws IOException {
        geralt.money += 200;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("strzyga/win.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }





    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int chances = random.nextInt(0,10);
        if (geralt.currentHP > 50 && chances <8){
            runSuccessful(actionEvent);
        } else if (geralt.currentHP > 20 && chances<4) {
            runSuccessful(actionEvent);
        } else if (geralt.currentHP <= 20 && chances<2) {
            runSuccessful(actionEvent);
        }else {
            geralt.death(actionEvent);
        }
    }

    public static void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("strzyga/runAway.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
