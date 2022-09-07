package com.example.gra.Ghul;

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

public class WalkaZGhul {
    @FXML
    private Label sila;
    @FXML
    private Label balans;
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
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
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
        if (Ghul.currentHP <= 0) {
            Geralt.money += 200;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZGhul.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Ghula");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Ghul.currentHP > 0) {
            Ghul.currentHP -= Geralt.onNormalAttack(actionEvent);
            Geralt.CurrentHP -= Ghul.onAttack(actionEvent);
        }
        pozoHPGhul.setText(String.valueOf(Ghul.currentHP));
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
        if (Ghul.currentHP <= 0) {
            Geralt.money += 200;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZGhul.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Ghula !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Ghul.currentHP > 0) {
            Ghul.currentHP -= Geralt.onStrongAttack(actionEvent);
            Geralt.CurrentHP -= Ghul.onAttack(actionEvent);
            Geralt.CurrentHP -= Ghul.onAttack(actionEvent);
        }
        pozoHPGhul.setText(String.valueOf(Ghul.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    @FXML
    protected void onRun() {

    }
}
