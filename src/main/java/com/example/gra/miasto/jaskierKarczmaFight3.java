package com.example.gra.miasto;

import com.example.gra.geralt;
import com.example.gra.start;
import com.example.gra.startLocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class jaskierKarczmaFight3 {
    @FXML
    private Label geraltPower;
    @FXML
    private Label geraltHP;
    @FXML
    private Label banditHP;
    @FXML
    private Label banditPower;
    @FXML
    private Label geraltRemainingHP;
    @FXML
    private Label banditRemainingHP;
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

    private int dealtDMGS = dealtDMGS(new ActionEvent());



    public jaskierKarczmaFight3() throws IOException {
    }

    @FXML
    protected void initialize() {
        banditHP.setText(String.valueOf(bandit3.maxHP));
        banditPower.setText(String.valueOf(bandit3.power));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        banditRemainingHP.setText(String.valueOf(bandit3.maxHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
        amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
    }

    @FXML
    protected void onPotion(ActionEvent actionEvent) {
        potionHeal(amountOfPotions, geraltRemainingHP);


    }

    @FXML
    public static void potionHeal(Label potki, Label pozoHPGeralt) {
        if (geralt.amountOfPotions > 0) {
            if (geralt.currentHP + 30 > geralt.maxHP) {
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
        if (geralt.currentHP - receivedDMG1 <= 0) {
            bandit3.currentHP = bandit3.maxHP;
            geralt.death(actionEvent);
        }
        if (bandit3.currentHP - dealtDMGn <= 0) {
            win(actionEvent);
        }

        if (geralt.currentHP > 0 && bandit3.currentHP > 0) {
            textDealtDamage.setText("Zadane obrażenia:");
            dealtDamage.setText(String.valueOf(dealtDMGn));
            bandit3.currentHP -= dealtDMGn;
            textReceivedDamage1.setText("Otrzymane obrażenia:");
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            geralt.currentHP -= receivedDMG1;


            textReceivedDamage2.setText("");
            receivedDamage2.setText("");
        }
        stats();
    }

    private void stats() {
        banditHP.setText(String.valueOf(bandit3.maxHP));
        banditPower.setText(String.valueOf(bandit3.power));
        banditRemainingHP.setText(String.valueOf(bandit3.currentHP));
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
        int receivedDMG1 = (int) bandit3.onAttack(actionEvent);
        return receivedDMG1;
    }

    @FXML
    protected void onHardAttack(ActionEvent actionEvent) throws IOException {
        int dealtDMGS = dealtDMGS(new ActionEvent());
        int receivedDMG1 = receivedDMG1(new ActionEvent());
        int receivedDMG2 = receivedDMG1(new ActionEvent());
        if (geralt.currentHP - (receivedDMG1 + receivedDMG2) <= 0) {
            geralt.death(actionEvent);
        }
        if (bandit3.currentHP - dealtDMGS <= 0) {
            win(actionEvent);
        }

        if (geralt.currentHP > 0 && bandit3.currentHP > 0) {
            textReceivedDamage1.setText("Otrzymane obrażenia:");
            textReceivedDamage2.setText("Otrzymane obrażenia:");
            textDealtDamage.setText("Zadane obrażenia:");
            geralt.currentHP -= receivedDMG1;
            geralt.currentHP -= receivedDMG2;
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            receivedDamage2.setText(String.valueOf(receivedDMG2));
            bandit3.currentHP -= dealtDMGS;
            dealtDamage.setText(String.valueOf(dealtDMGS));
        }
        stats();
    }

    private void win(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/win3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        geralt.death(actionEvent);
    }
}
