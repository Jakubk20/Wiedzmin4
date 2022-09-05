package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WalkaZBiesem {
    @FXML
    private Label sila;
    @FXML
    private Label balans;
    @FXML
    private Label hapeki;
    @FXML
    private Label hapekiBiesa;
    @FXML
    private Label silaBiesa;
    @FXML
    private Label pozoHPGeralt;
    @FXML
    private Label pozoHPBies;

    @FXML
    protected void onPokazz() {
        balans.setText(String.valueOf(Geralt.money));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.HP));
        pozoHPGeralt.setText(String.valueOf(Geralt.HP));
    }

    @FXML
    protected void onPokazzz() {
        hapekiBiesa.setText(String.valueOf(Bies.HPB));
        silaBiesa.setText(String.valueOf(Bies.power));
        pozoHPBies.setText(String.valueOf(Bies.HPB));
    }

    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        if (Geralt.HP <= 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Śmierć.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Giniesz!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Bies.HPB <= 0) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaZBies.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Biesa !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        while (Geralt.HP > 0 && Bies.HPB > 0) {
            Bies.HPB -= Geralt.onNormalAttack(actionEvent);
            Geralt.HP -= Bies.onAttack(actionEvent);
        }


    }

    @FXML
    protected void onHard() {

    }

    @FXML
    protected void onRun() {

    }
}
