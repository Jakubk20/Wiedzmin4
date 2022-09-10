package com.example.gra.Bies;

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

public class WalkaZBies {
    @FXML
    private Label sila;
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
    private Label potki;
    @FXML
    private Label orzymaneObra1;
    @FXML
    private Label orzymaneObra2;
    @FXML
    private Label zadaneObra;
    @FXML
    private Label textotrzymaneo1;
    @FXML
    private Label textotrzymaneo2;
    @FXML
    private Label textzadaneo;

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
        hapekiBiesa.setText(String.valueOf(Bies.maxHP));
        silaBiesa.setText(String.valueOf(Bies.power));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.MaxHP));
        pozoHPBies.setText(String.valueOf(Bies.currentHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
        potki.setText(String.valueOf(Geralt.amountOfPotions));
    }
    @FXML
    protected void onPotion(ActionEvent actionEvent) {
        potionHeal(potki, pozoHPGeralt);


    }

    public static void potionHeal(Label potki, Label pozoHPGeralt) {
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
    protected void onNormal(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            Bies.currentHP = Bies.maxHP;
            Geralt.death(actionEvent);
        }
        win(actionEvent);
        if (Geralt.CurrentHP > 0 && Bies.currentHP > 0) {
            int obra = (int) Geralt.onNormalAttack(actionEvent);
            textzadaneo.setText("Zadane obrażenia :");
            zadaneObra.setText(String.valueOf(obra));
            Bies.currentHP -= obra;
            int otrz = (int) Bies.onAttack();
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            orzymaneObra1.setText(String.valueOf(otrz));
            Geralt.CurrentHP -= otrz;


            textotrzymaneo2.setText("");
            orzymaneObra2.setText("");
        }
        stats();
    }

    private void stats() {
        hapekiBiesa.setText(String.valueOf(Bies.maxHP));
        silaBiesa.setText(String.valueOf(Bies.power));
        pozoHPBies.setText(String.valueOf(Bies.currentHP));
        sila.setText(String.valueOf(Geralt.power));
        hapeki.setText(String.valueOf(Geralt.MaxHP));
        pozoHPGeralt.setText(String.valueOf(Geralt.CurrentHP));
    }

    private void win(ActionEvent actionEvent) throws IOException {
        if (Bies.currentHP <= 0) {
            Geralt.money += 500;
            Geralt.moc +=1;
            Geralt.power = (10 + 20) / 2 + Geralt.moc;
            Geralt.MaxHP +=10;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Bies/wygranaZBiesem.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }



    @FXML
    protected void onHard(ActionEvent actionEvent) throws IOException {
        if (Geralt.CurrentHP <= 0) {
            Bies.currentHP = Bies.maxHP;
            Geralt.death(actionEvent);
        }
        win(actionEvent);
        if (Geralt.CurrentHP > 0 && Bies.currentHP > 0) {
            textotrzymaneo1.setText("Otrzymane obrażenia :");
            textotrzymaneo2.setText("Otrzymane obrażenia :");
            textzadaneo.setText("Zadane obrażenia :");
            int obraz1 = (int) Bies.onAttack();
            int obraz2 = (int) Bies.onAttack();
            Geralt.CurrentHP -= obraz1;
            Geralt.CurrentHP -= obraz2;
            orzymaneObra1.setText(String.valueOf(obraz1));
            orzymaneObra2.setText(String.valueOf(obraz2));
            int zadane = (int) Geralt.onStrongAttack(actionEvent);
            Bies.currentHP -= zadane;
            zadaneObra.setText(String.valueOf(zadane));
            System.out.println("lol");
            System.out.println("lol");
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

    public static void runSuccessful(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ucieczka.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
