package com.example.gra.Leszy;

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

public class win {
    @FXML
    private Label money;
    @FXML
    protected void onClick(){
        money.setText(String.valueOf(geralt.money));
    }
    @FXML
    protected void onNextClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("leszy/fight.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
