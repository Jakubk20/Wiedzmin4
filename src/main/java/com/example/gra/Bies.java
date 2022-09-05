package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Bies extends Balans{
    Random random = new Random();



    @FXML
    protected void onFight(ActionEvent actionEvent) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("walkaZBies.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Walka z Bies");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
    }

    public int balanss(){
        return this.getBalans();
    }
    public int silaa(){
        return this.getSila();
    }

    @FXML
    protected void onRun(ActionEvent actionEvent) throws IOException {
        int chance = random.nextInt(0, 100);
        if (chance>=10){
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Wygrana.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Udaje ci się uciec !");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }else{FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Śmierć.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Giniesz!");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();}
    }

}
