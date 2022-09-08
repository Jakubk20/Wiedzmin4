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

public class WygranaZGhul {
    @FXML
    private Label brylki;
    @FXML
    protected void initialize(){
        brylki.setText(String.valueOf(Geralt.money));
    }
    @FXML
    protected void onDalejClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scenaWyboruRuchu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Gra");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
