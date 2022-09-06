package com.example.gra.Utopiec;

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

public class WalkaZUtopcem {
    @FXML
    private Label sila;
    @FXML
    private Label balans;
    @FXML
    private Label hapeki;
    @FXML
    private Label hapekiUtopca;
    @FXML
    private Label silaUtopca;
    @FXML
    private Label pozoHPGeralt;
    @FXML
    private Label pozoHPUtopiec;

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
        if (Utopiec.HP <= 0) {
            Geralt.money += 700;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Utopca!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Utopiec.HP > 0) {
            Utopiec.HP -= Geralt.onNormalAttack(actionEvent);
            Geralt.CurrentHP -= Utopiec.onAttack(actionEvent);
        }
        hapekiUtopca.setText(String.valueOf(Utopiec.HP));
        silaUtopca.setText(String.valueOf(Utopiec.power));
        pozoHPUtopiec.setText(String.valueOf(Utopiec.HP));
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
        if (Utopiec.HP <= 0) {
            Geralt.money += 700;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZLesz.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Leszego !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Utopiec.HP > 0) {
            Utopiec.HP -= Geralt.onStrongAttack(actionEvent);
            Geralt.CurrentHP -= Utopiec.onAttack(actionEvent);
            Geralt.CurrentHP -= Utopiec.onAttack(actionEvent);
        }
        hapekiUtopca.setText(String.valueOf(Utopiec.HP));
        silaUtopca.setText(String.valueOf(Utopiec.power));
        pozoHPUtopiec.setText(String.valueOf(Utopiec.HP));
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    @FXML
    protected void onRun() {

    }
}