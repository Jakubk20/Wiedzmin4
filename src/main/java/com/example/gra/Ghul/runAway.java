package com.example.gra.Ghul;

import com.example.gra.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class runAway {
    @FXML
    protected void onNextClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("trader1/trader1meet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
