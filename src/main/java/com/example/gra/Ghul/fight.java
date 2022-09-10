package com.example.gra.Ghul;

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
    private Label ghulHP;
    @FXML
    private Label ghulPower;
    @FXML
    private Label geraltRemainingHP;
    @FXML
    private Label ghulRemainingHP;
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
        ghulHP.setText(String.valueOf(ghul.currentHP));
        ghulPower.setText(String.valueOf(ghul.power));
        ghulRemainingHP.setText(String.valueOf(ghul.currentHP));
        geraltPower.setText(String.valueOf(geralt.power));
        geraltHP.setText(String.valueOf(geralt.maxHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
        amountOfPotions.setText(String.valueOf(geralt.amountOfPotions));
    }
    @FXML
    protected void onNormalAttack(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.currentHP > 0 && ghul.currentHP > 0) {
            int dealtDMG = (int) geralt.onNormalAttack(actionEvent);
            textDealtDamage.setText("Zadane obrażenia :");
            dealtDamage.setText(String.valueOf(dealtDMG));
            ghul.currentHP -= dealtDMG;
            int receivedDMG = (int) ghul.onAttack(actionEvent);
            textReceivedDamage1.setText("Otrzymane obrażenia :");
            receivedDamage1.setText(String.valueOf(receivedDMG));
            geralt.currentHP -= receivedDMG;


            textReceivedDamage2.setText("");
            receivedDamage2.setText("");
        }
        ghulRemainingHP.setText(String.valueOf(ghul.currentHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (geralt.currentHP <= 0) {
            geralt.death(actionEvent);
        }
        if (ghul.currentHP <= 0) {
            geralt.money += 200;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ghul/win.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onPotion(ActionEvent actionEvent) throws IOException{
        com.example.gra.Bies.fight.potionHeal(amountOfPotions, geraltRemainingHP);


    }
    @FXML
    protected void onHardAttack(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.currentHP > 0 && ghul.currentHP > 0) {
            textReceivedDamage1.setText("Otrzymane obrażenia :");
            textReceivedDamage2.setText("Otrzymane obrażenia :");
            textDealtDamage.setText("Zadane obrażenia :");
            int receivedDMG1 = (int) ghul.onAttack(actionEvent);
            int receivedDMG2 = (int) ghul.onAttack(actionEvent);
            geralt.currentHP -= receivedDMG1;
            geralt.currentHP -= receivedDMG2;
            receivedDamage1.setText(String.valueOf(receivedDMG1));
            receivedDamage2.setText(String.valueOf(receivedDMG2));
            int dealtDMG = (int) geralt.onStrongAttack(actionEvent);
            ghul.currentHP -= dealtDMG;
            dealtDamage.setText(String.valueOf(dealtDMG));
        }
        ghulRemainingHP.setText(String.valueOf(ghul.currentHP));
        geraltRemainingHP.setText(String.valueOf(geralt.currentHP));
    }

//    @FXML
//    protected void onRun() {
//        Random random = new Random();
//        int chances = random.nextInt(0,10);
//        if ((Geralt.CurrentHP > 50 && chances <8) ,(Geralt.CurrentHP > 20 && chances<4)  ,(Geralt.CurrentHP <= 20 && chances<2));
//            //tutaj napisz jacob co sie stanie jezeli ucieczka sie powiedzie
//         else {
//            //tutaj napisz jacob co sie stanie jezeli ucieczka sie NIE powiedzie
//        }
//    }
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

    static void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("runAwaySuccessful.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
