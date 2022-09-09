package com.example.gra.Ghul;

import com.example.gra.Bies.WalkaZBiesem;
import com.example.gra.Geralt;
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

public class WalkaZGhul {
    @FXML
    private Label sila;
    @FXML
    private Label hapeki;
    @FXML
    private Label hapekiGhul;
    @FXML
    private Label silaGhul;
    @FXML
    private Label pozoHPGeralt;
    @FXML
    private Label pozoHPGhul;
    @FXML
    private Label potki;
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
        hapekiGhul.setText(String.valueOf(Ghul.currentHP));
        silaGhul.setText(String.valueOf(Ghul.power));
        pozoHPGhul.setText(String.valueOf(Ghul.currentHP));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.MaxHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
        potki.setText(String.valueOf(Geralt.amountOfPotions));
    }
    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (Geralt.CurrentHP > 0 && Ghul.currentHP > 0) {
            Ghul.currentHP -= Geralt.onNormalAttack(actionEvent);
            Geralt.CurrentHP -= Ghul.onAttack(actionEvent);
        }
        pozoHPGhul.setText(String.valueOf(Ghul.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            WalkaZBiesem.death(actionEvent);
        }
        if (Ghul.currentHP <= 0) {
            Geralt.money += 200;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZGhul.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onPotion(ActionEvent actionEvent) throws IOException{
        WalkaZBiesem.potionHeal(potki, pozoHPGeralt);


    }
    @FXML
    protected void onHard(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (Geralt.CurrentHP > 0 && Ghul.currentHP > 0) {
            Ghul.currentHP -= Geralt.onStrongAttack(actionEvent);
            Geralt.CurrentHP -= Ghul.onAttack(actionEvent);
            Geralt.CurrentHP -= Ghul.onAttack(actionEvent);
        }
        pozoHPGhul.setText(String.valueOf(Ghul.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
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
        if (Geralt.CurrentHP > 50 && chances <8){
            runSuccessful(actionEvent);
        } else if (Geralt.CurrentHP > 20 && chances<4) {
            runSuccessful(actionEvent);
        } else if (Geralt.CurrentHP <= 20 && chances<2) {
            runSuccessful(actionEvent);
        }else {
            WalkaZBiesem.death(actionEvent);
        }
    }

    static void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ucieczkaGhul.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
