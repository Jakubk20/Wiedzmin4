package com.example.gra.Leszy;

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
        hapekiLeszego.setText(String.valueOf(leszy.maxHP));
        silaLesza.setText(String.valueOf(leszy.power));
        pozoHPLesz.setText(String.valueOf(leszy.currentHP));
        sila.setText(String.valueOf(geralt.power));
        hapeki.setText(String.valueOf(geralt.MaxHP));
        pozoHPGeralt.setText(String.valueOf(geralt.CurrentHP));
        potki.setText(String.valueOf(geralt.amountOfPotions));
    }
@FXML
protected void onPotion(ActionEvent actionEvent) throws IOException{
    if (geralt.amountOfPotions > 0){
        if (geralt.CurrentHP + 30 > geralt.MaxHP){
            geralt.CurrentHP = geralt.MaxHP;
        } else geralt.CurrentHP += 30;
        geralt.amountOfPotions--;
    }

}
    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.CurrentHP > 0 && leszy.currentHP > 0) {
            int obra = (int) geralt.onNormalAttack(actionEvent);
            textzadaneo.setText("Zadane obrażenia :");
            zadaneObra.setText(String.valueOf(obra));
            leszy.currentHP -= obra;
            int otrz = (int) leszy.onAttack(actionEvent);
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            orzymaneObra1.setText(String.valueOf(otrz));
            geralt.CurrentHP -= otrz;


            textotrzymaneo2.setText("");
            orzymaneObra2.setText("");
        }
        stats();
    }

    private void stats() {
        hapekiLeszego.setText(String.valueOf(leszy.currentHP));
        silaLesza.setText(String.valueOf(leszy.power));
        pozoHPLesz.setText(String.valueOf(leszy.currentHP));
        balans.setText(String.valueOf(geralt.money));
        sila.setText(String.valueOf(geralt.power));
        hapeki.setText(String.valueOf(geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(geralt.CurrentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (geralt.CurrentHP <= 0) {
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
    protected void onHard(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.CurrentHP > 0 && leszy.currentHP > 0) {
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            textotrzymaneo2.setText("Otrzymane obrażenia :");
            textzadaneo.setText("Zadane obrażenia :");
            int obraz1 = (int) leszy.onAttack(actionEvent);
            int obraz2 = (int) leszy.onAttack(actionEvent);
            geralt.CurrentHP -= obraz1;
            geralt.CurrentHP -= obraz2;
            orzymaneObra1.setText(String.valueOf(obraz1));
            orzymaneObra2.setText(String.valueOf(obraz2));
            int zadane = (int) geralt.onStrongAttack(actionEvent);
            leszy.currentHP -= zadane;
            zadaneObra.setText(String.valueOf(zadane));
        }
        stats();
    }

    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int chances = random.nextInt(0,10);
        if (geralt.CurrentHP > 50 && chances <8){
            runSuccessful(actionEvent);
        } else if (geralt.CurrentHP > 20 && chances<4) {
            runSuccessful(actionEvent);
        } else if (geralt.CurrentHP <= 20 && chances<2) {
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
