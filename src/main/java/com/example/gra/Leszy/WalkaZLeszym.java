package com.example.gra.Leszy;

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

public class WalkaZLeszym {
    @FXML
    private Label sila;
    @FXML
    private Label balans;
    @FXML
    private Label hapeki;
    @FXML
    private Label hapekiLeszego;
    @FXML
    private Label silaLesza;
    @FXML
    private Label pozoHPGeralt;
    @FXML
    private Label pozoHPLesz;
    @FXML
    private Label potki;
    @FXML
    private Label textotrzymaneo1;
    @FXML
    private Label textotrzymaneo2;
    @FXML
    private Label zadaneObra;
    @FXML
    private Label textzadaneo;
    @FXML
    private Label orzymaneObra1;
    @FXML
    private Label orzymaneObra2;

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
        hapekiLeszego.setText(String.valueOf(Leszy.maxHP));
        silaLesza.setText(String.valueOf(Leszy.power));
        pozoHPLesz.setText(String.valueOf(Leszy.currentHP));
        sila.setText(String.valueOf(com.example.gra.Geralt.power));
        hapeki.setText(String.valueOf(com.example.gra.Geralt.MaxHP));
        pozoHPGeralt.setText(String.valueOf(com.example.gra.Geralt.CurrentHP));
        potki.setText(String.valueOf(com.example.gra.Geralt.amountOfPotions));
    }
@FXML
protected void onPotion(ActionEvent actionEvent) throws IOException{
    if (com.example.gra.Geralt.amountOfPotions > 0){
        if (com.example.gra.Geralt.CurrentHP + 30 > com.example.gra.Geralt.MaxHP){
            com.example.gra.Geralt.CurrentHP = com.example.gra.Geralt.MaxHP;
        } else com.example.gra.Geralt.CurrentHP += 30;
        com.example.gra.Geralt.amountOfPotions--;
    }

}
    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (com.example.gra.Geralt.CurrentHP > 0 && Leszy.currentHP > 0) {
            int obra = (int) com.example.gra.Geralt.onNormalAttack(actionEvent);
            textzadaneo.setText("Zadane obrażenia :");
            zadaneObra.setText(String.valueOf(obra));
            Leszy.currentHP -= obra;
            int otrz = (int) Leszy.onAttack(actionEvent);
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            orzymaneObra1.setText(String.valueOf(otrz));
            com.example.gra.Geralt.CurrentHP -= otrz;


            textotrzymaneo2.setText("");
            orzymaneObra2.setText("");
        }
        stats();
    }

    private void stats() {
        hapekiLeszego.setText(String.valueOf(Leszy.currentHP));
        silaLesza.setText(String.valueOf(Leszy.power));
        pozoHPLesz.setText(String.valueOf(Leszy.currentHP));
        balans.setText(String.valueOf(com.example.gra.Geralt.money));
        sila.setText(String.valueOf(com.example.gra.Geralt.power));
        hapeki.setText(String.valueOf(com.example.gra.Geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(com.example.gra.Geralt.CurrentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            Geralt.death(actionEvent);
        }
        if (Leszy.currentHP <= 0) {
            Geralt.money += 700;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Leszy/wygranaZLesz.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onHard(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (Geralt.CurrentHP > 0 && Leszy.currentHP > 0) {
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            textotrzymaneo2.setText("Otrzymane obrażenia :");
            textzadaneo.setText("Zadane obrażenia :");
            int obraz1 = (int) Leszy.onAttack(actionEvent);
            int obraz2 = (int) Leszy.onAttack(actionEvent);
            Geralt.CurrentHP -= obraz1;
            Geralt.CurrentHP -= obraz2;
            orzymaneObra1.setText(String.valueOf(obraz1));
            orzymaneObra2.setText(String.valueOf(obraz2));
            int zadane = (int) Geralt.onStrongAttack(actionEvent);
            Leszy.currentHP -= zadane;
            zadaneObra.setText(String.valueOf(zadane));
        }
        stats();
    }

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
            Geralt.death(actionEvent);
        }
    }

    private void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ucieczka.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
