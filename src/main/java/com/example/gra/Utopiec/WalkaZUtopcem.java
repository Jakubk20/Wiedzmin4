package com.example.gra.Utopiec;

import com.example.gra.Bies.Bies;
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

public class WalkaZUtopcem {
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
protected void initialize(){
    hapekiUtopca.setText(String.valueOf(Utopiec.currentHP));
    silaUtopca.setText(String.valueOf(Utopiec.power));
    pozoHPUtopiec.setText(String.valueOf(Utopiec.currentHP));
    sila.setText(String.valueOf(Geralt.power));
    hapeki.setText(String.valueOf(Geralt.CurrentHP));
    pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    potki.setText(String.valueOf(Geralt.amountOfPotions));
}
    @FXML
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        end(actionEvent);
        if (Geralt.CurrentHP > 0 && Utopiec.currentHP > 0) {
            int obra = (int) Geralt.onNormalAttack(actionEvent);
            textzadaneo.setText("Zadane obrażenia :");
            zadaneObra.setText(String.valueOf(obra));
            Utopiec.currentHP -= obra;
            int otrz = (int) Utopiec.onAttack(actionEvent);
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            orzymaneObra1.setText(String.valueOf(otrz));
            Geralt.CurrentHP -= otrz;


            textotrzymaneo2.setText("");
            orzymaneObra2.setText("");
        }
        pozoHPUtopiec.setText(String.valueOf(Utopiec.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    private void end(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            WalkaZBiesem.death(actionEvent);
        }
        if (Utopiec.currentHP <= 0) {
            Geralt.money += 200;
            Geralt.power+=1;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wygranaUtopiec.fxml"));
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
        if (Geralt.CurrentHP > 0 && Utopiec.currentHP > 0) {
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            textotrzymaneo2.setText("Otrzymane obrażenia :");
            textzadaneo.setText("Zadane obrażenia :");
            int obraz1 = (int) Utopiec.onAttack(actionEvent);
            int obraz2 = (int) Utopiec.onAttack(actionEvent);
            Geralt.CurrentHP -= obraz1;
            Geralt.CurrentHP -= obraz2;
            orzymaneObra1.setText(String.valueOf(obraz1));
            orzymaneObra2.setText(String.valueOf(obraz2));
            int zadane = (int) Geralt.onStrongAttack(actionEvent);
            Utopiec.currentHP -= zadane;
            zadaneObra.setText(String.valueOf(zadane));
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
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (Geralt.CurrentHP > 20 && chances<4) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ucieczkaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (Geralt.CurrentHP <= 20 && chances<2) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ucieczkaUtopiec.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }else {
            WalkaZBiesem.death(actionEvent);
        }
    }
}
