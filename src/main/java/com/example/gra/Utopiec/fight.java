package com.example.gra.Utopiec;

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
    private Label hapeki;
    @FXML
    private Label hapekiUtopca;
    @FXML
    private Label silaUtopca;
    @FXML
    private Label pozoHPGeralt;
    @FXML
    private Label pozoHPUtopiec;
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
    protected void initialize() {
        hapekiUtopca.setText(String.valueOf(utopiec.currentHP));
        silaUtopca.setText(String.valueOf(utopiec.power));
        pozoHPUtopiec.setText(String.valueOf(utopiec.currentHP));
        sila.setText(String.valueOf(geralt.power));
        hapeki.setText(String.valueOf(geralt.CurrentHP));
        pozoHPGeralt.setText(String.valueOf(geralt.CurrentHP));
        potki.setText(String.valueOf(geralt.amountOfPotions));
    }

    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.CurrentHP > 0 && utopiec.currentHP > 0) {
            int obra = (int) geralt.onNormalAttack(actionEvent);
            textzadaneo.setText("Zadane obrażenia :");
            zadaneObra.setText(String.valueOf(obra));
            utopiec.currentHP -= obra;
            int otrz = (int) utopiec.onAttack(actionEvent);
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            orzymaneObra1.setText(String.valueOf(otrz));
            geralt.CurrentHP -= otrz;


            textotrzymaneo2.setText("");
            orzymaneObra2.setText("");
        }
        pozoHPUtopiec.setText(String.valueOf(utopiec.currentHP));
        pozoHPGeralt.setText(String.valueOf(geralt.CurrentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (geralt.CurrentHP <= 0) {
            geralt.death(actionEvent);
        }
        if (utopiec.currentHP <= 0) {
            geralt.money += 200;
            geralt.moc += 1;
            geralt.power = (10 + 20) / 2 + geralt.moc;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("utopiec/win.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onPotion(ActionEvent actionEvent) throws IOException {
        com.example.gra.Bies.fight.potionHeal(potki, pozoHPGeralt);


    }

    @FXML
    protected void onHard(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (geralt.CurrentHP > 0 && utopiec.currentHP > 0) {
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            textotrzymaneo2.setText("Otrzymane obrażenia :");
            textzadaneo.setText("Zadane obrażenia :");
            int obraz1 = (int) utopiec.onAttack(actionEvent);
            int obraz2 = (int) utopiec.onAttack(actionEvent);
            geralt.CurrentHP -= obraz1;
            geralt.CurrentHP -= obraz2;
            orzymaneObra1.setText(String.valueOf(obraz1));
            orzymaneObra2.setText(String.valueOf(obraz2));
            int zadane = (int) geralt.onStrongAttack(actionEvent);
            utopiec.currentHP -= zadane;
            zadaneObra.setText(String.valueOf(zadane));
        }
        pozoHPUtopiec.setText(String.valueOf(utopiec.currentHP));
        pozoHPGeralt.setText(String.valueOf(geralt.CurrentHP));
    }

    protected void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("runAwaySuccessful.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int chances = random.nextInt(0, 10);
        if (geralt.CurrentHP > 50 && chances < 8) {
            runSuccessful(actionEvent);
        } else if (geralt.CurrentHP > 20 && chances < 4) {
            runSuccessful(actionEvent);
        } else if (geralt.CurrentHP <= 20 && chances < 2) {
            runSuccessful(actionEvent);
        } else {
            geralt.death(actionEvent);
        }
    }
}
