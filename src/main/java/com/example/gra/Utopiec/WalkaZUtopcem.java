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
import java.util.Random;

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
    hapekiUtopca.setText(String.valueOf(Utopiec.currentHP));
    silaUtopca.setText(String.valueOf(Utopiec.power));
    pozoHPUtopiec.setText(String.valueOf(Utopiec.currentHP));
    balans.setText(String.valueOf(Geralt.money));
    sila.setText(String.valueOf(Geralt.power));
    hapeki.setText(String.valueOf(Geralt.CurrentHP));
    pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    potki.setText(String.valueOf(Geralt.amountOfPotions));
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
        if (Utopiec.currentHP <= 0) {
            Geralt.money += 200;
            Geralt.power+=1;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Utopca!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Utopiec.currentHP > 0) {
            Utopiec.currentHP -= Geralt.onNormalAttack(actionEvent);
            Geralt.CurrentHP -= Utopiec.onAttack(actionEvent);
        }
        pozoHPUtopiec.setText(String.valueOf(Utopiec.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }
    @FXML
    protected void onPotion(ActionEvent actionEvent) throws IOException{
        if (Geralt.amountOfPotions > 0){
            if (Geralt.CurrentHP + 30 > Geralt.MaxHP){
                Geralt.CurrentHP = Geralt.MaxHP;
            } else Geralt.CurrentHP += 30;
            Geralt.amountOfPotions--;
            potki.setText(String.valueOf(Geralt.amountOfPotions));
            pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
        }


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
        if (Utopiec.currentHP <= 0) {
            Geralt.money += 200;
            Geralt.power+=1;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Zabijasz Utopca !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
        if (Geralt.CurrentHP > 0 && Utopiec.currentHP > 0) {
            Utopiec.currentHP -= Geralt.onStrongAttack(actionEvent);
            Geralt.CurrentHP -= Utopiec.onAttack(actionEvent);
            Geralt.CurrentHP -= Utopiec.onAttack(actionEvent);
        }
        pozoHPUtopiec.setText(String.valueOf(Utopiec.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        Random random = new Random();
        int chances = random.nextInt(0,10);
        if (Geralt.CurrentHP > 50 && chances <8){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ucieczkaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Udaje ci się uciec !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (Geralt.CurrentHP > 20 && chances<4) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ucieczkaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Udaje ci się uciec !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (Geralt.CurrentHP <= 20 && chances<2) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ucieczkaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Udaje ci się uciec !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Śmierć.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Giniesz!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }
}
