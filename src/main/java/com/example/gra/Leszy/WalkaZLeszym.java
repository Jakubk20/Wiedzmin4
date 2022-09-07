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
protected void onPotion(ActionEvent actionEvent) throws IOException{
    if (Geralt.amountOfPotions > 0){
        if (Geralt.CurrentHP + 30 > Geralt.MaxHP){
            Geralt.CurrentHP = Geralt.MaxHP;
        } else Geralt.CurrentHP += 30;
        Geralt.amountOfPotions--;
    }

}
    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Śmierć.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Giniesz!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Lesz.currentHP <= 0) {
            Geralt.money += 700;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZLesz.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Lesza!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Lesz.currentHP > 0) {
            Lesz.currentHP -= Geralt.onNormalAttack(actionEvent);
            Geralt.CurrentHP -= Lesz.onAttack(actionEvent);
        }
        hapekiLeszego.setText(String.valueOf(Lesz.currentHP));
        silaLesza.setText(String.valueOf(Lesz.power));
        pozoHPLesz.setText(String.valueOf(Lesz.currentHP));
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    @FXML
    protected void onHard(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Śmierć.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Giniesz!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Lesz.currentHP <= 0) {
            Geralt.money += 700;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZLesz.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Leszego !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Lesz.currentHP > 0) {
            Lesz.currentHP -= Geralt.onStrongAttack(actionEvent);
            Geralt.CurrentHP -= Lesz.onAttack(actionEvent);
            Geralt.CurrentHP -= Lesz.onAttack(actionEvent);
        }
        hapekiLeszego.setText(String.valueOf(Lesz.currentHP));
        silaLesza.setText(String.valueOf(Lesz.power));
        pozoHPLesz.setText(String.valueOf(Lesz.currentHP));
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    @FXML
    protected void onRun() {

    }
}
