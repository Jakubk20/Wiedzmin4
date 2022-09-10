package com.example.gra.leszy;

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
    private Label leszyHP;
    @FXML
    private Label leszyPower;
    @FXML
    private Label geraltRemainingHP;
    @FXML
    private Label leszyRemainingHP;
    @FXML
    private Label amountOfPotions;
    @FXML
    private Label textReceivedDamage1;
    @FXML
    private Label textReceivedDamage2;
    @FXML
    private Label dealtDamage;
    @FXML
    private Label textDealtDamage;
    @FXML
    private Label receivedDamage1;
    @FXML
    private Label receivedDamage2;

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
        leszyHP.setText(String.valueOf(leszy.maxHP));
        leszyPower.setText(String.valueOf(leszy.power));
        leszyRemainingHP.setText(String.valueOf(leszy.currentHP));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
        amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
    }
@FXML
protected void onPotion(ActionEvent actionEvent) throws IOException{
    if (geralt.amountOfPotions > 0){
        if (geralt.currentHP + 30 > geralt.maxHP){
            geralt.currentHP = geralt.maxHP;
        } else geralt.currentHP += 30;
        geralt.amountOfPotions--;
    }

}
    @FXML
    protected void onNormalAttack(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.currentHP > 0 && leszy.currentHP > 0) {
            int dealtDMG = (int) geralt.onNormalAttack(actionEvent);
            textDealtDamage.setText("Zadane obrażenia :");
            dealtDamage.setText(String.valueOf(dealtDMG));
            leszy.currentHP -= dealtDMG;
            int receivedDMG = (int) leszy.onAttack(actionEvent);
            textReceivedDamage1.setText("Otrzymane obrażenia :");
            receivedDamage1.setText(String.valueOf(receivedDMG));
            geralt.currentHP -= receivedDMG;


            textReceivedDamage2.setText("");
            receivedDamage2.setText("");
        }
        stats();
    }

    private void stats() {
        leszyHP.setText(String.valueOf(leszy.currentHP));
        leszyPower.setText(String.valueOf(leszy.power));
        leszyRemainingHP.setText(String.valueOf(leszy.currentHP));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.currentHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (geralt.currentHP <= 0) {
            geralt.death(actionEvent);
        }
        if (leszy.currentHP <= 0) {
            geralt.money += 700;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("leszy/win.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onHardAttack(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.currentHP > 0 && leszy.currentHP > 0) {
            textReceivedDamage1.setText("Otrzymane obrażenia :");
            textReceivedDamage2.setText("Otrzymane obrażenia :");
            textDealtDamage.setText("Zadane obrażenia :");
            int receivedDMG1 = (int) leszy.onAttack(actionEvent);
            int receivedDMG2 = (int) leszy.onAttack(actionEvent);
            geralt.currentHP -= receivedDMG1;
            geralt.currentHP -= receivedDMG2;
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            receivedDamage2.setText(String.valueOf(receivedDMG2));
            int dealtDMG = (int) geralt.onStrongAttack(actionEvent);
            leszy.currentHP -= dealtDMG;
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

    private void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("runAwaySuccessful.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
