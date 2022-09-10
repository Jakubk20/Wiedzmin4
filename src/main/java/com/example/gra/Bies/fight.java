package com.example.gra.Bies;

import com.example.gra.geralt;
import com.example.gra.HelloApplication;
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
    private Label biesHP;
    @FXML
    private Label biesPower;
    @FXML
    private Label geraltRemainingHP;
    @FXML
    private Label biesRemainingHP;
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

//    @FXML
//    protected void onPokazz() {
//        balans.setText(String.valueOf(Geralt.money));
//        sila.setText(String.valueOf(Geralt.power));
//        hapeki.setText(String.valueOf(Geralt.HP));
//        pozoHPGeralt.setText(String.valueOf(Geralt.HP));
//    }
//
//    @FXML
//    protected void onPokazzz() {
//        hapekiBiesa.setText(String.valueOf(Bies.HPB));
//        silaBiesa.setText(String.valueOf(Bies.power));
//        pozoHPBies.setText(String.valueOf(Bies.HPB));
//    }
    @FXML
    protected void initialize(){
        biesHP.setText(String.valueOf(bies.maxHP));
        biesPower.setText(String.valueOf(bies.power));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        biesRemainingHP.setText(String.valueOf(bies.currentHP));
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
        if (geralt.currentHP <= 0) {
            bies.currentHP = bies.maxHP;
            geralt.death(actionEvent);
        }
        win(actionEvent);
        if (geralt.currentHP > 0 && bies.currentHP > 0) {
            int dealtDMG = (int) geralt.onNormalAttack(actionEvent);
            textDealtDamage.setText("Zadane obrażenia :");
            dealtDamage.setText(String.valueOf(dealtDMG));
            bies.currentHP -= dealtDMG;
            int receivedDMG = (int) bies.onAttack();
            textReceivedDamage1.setText("Otrzymane obrażenia :");
            receivedDamage1.setText(String.valueOf(receivedDMG));
            geralt.currentHP -= receivedDMG;


            textReceivedDamage2.setText("");
            receivedDamage2.setText("");
        }
        stats();
    }

    private void stats() {
        biesHP.setText(String.valueOf(bies.maxHP));
        biesPower.setText(String.valueOf(bies.power));
        biesRemainingHP.setText(String.valueOf(bies.currentHP));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
    }

    private void win(ActionEvent actionEvent) throws IOException {
        if (bies.currentHP <= 0) {
            geralt.money += 500;
            geralt.moc +=1;
            geralt.power = (10 + 20) / 2 + geralt.moc;
            geralt.maxHP +=10;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("bies/win.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }



    @FXML
    protected void onHardAttack(ActionEvent actionEvent) throws IOException {
        if (geralt.currentHP <= 0) {
            bies.currentHP = bies.maxHP;
            geralt.death(actionEvent);
        }
        win(actionEvent);
        if (geralt.currentHP > 0 && bies.currentHP > 0) {
            textReceivedDamage1.setText("Otrzymane obrażenia :");
            textReceivedDamage2.setText("Otrzymane obrażenia :");
            textDealtDamage.setText("Zadane obrażenia :");
            int receivedDMG1 = (int) bies.onAttack();
            int receivedDMG2 = (int) bies.onAttack();
            geralt.currentHP -= receivedDMG1;
            geralt.currentHP -= receivedDMG2;
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            receivedDamage2.setText(String.valueOf(receivedDMG2));
            int dealtDMG = (int) geralt.onStrongAttack(actionEvent);
            bies.currentHP -= dealtDMG;
            dealtDamage.setText(String.valueOf(dealtDMG));
        }
        stats();
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("runAwaySuccessful.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
