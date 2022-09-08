package com.example.gra;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScenaWyboruRuchu {
    @FXML
    protected void onHandlarz(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("handlarz1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Handlarz");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onIdzDalej(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startLocation.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        stage.setTitle("Gra");
//        stage.setScene(scene);
//        stage.centerOnScreen();
//        stage.show();
    }
    @FXML
    protected void onIdzWStroneMiasta(ActionEvent actionEvent) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startLocation.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
//        stage.setTitle("Gra");
//        stage.setScene(scene);
//        stage.centerOnScreen();
//        stage.show();
    }
}
