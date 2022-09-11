package com.example.gra.miasto;

import com.example.gra.ghul.ghul;
import com.example.gra.start;
import com.example.gra.startLocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.gra.miasto.jaskierKarczma.*;
import static com.example.gra.startLocation.isZygfryd;

public class meet {
    @FXML
    protected void onTrader(ActionEvent actionEvent) throws IOException {
        if (startLocation.isZygfryd) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/tradermeetAward.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/tradermeet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }


    @FXML
    protected void onLeave(ActionEvent actionEvent) throws IOException {
        if (ghul.awardAvailable) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("BialySadNorthAwardAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("BialySadNorth.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onTavern(ActionEvent actionEvent) throws IOException {
        if (banditTookMoney) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/banditTookMoney.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (jaskierQuest1Done) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/jaskierNone.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/meetFirstTime.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

    @FXML
    protected void onGoNorthClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/port.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGoSouthClick(ActionEvent actionEvent) throws IOException {
        if (isZygfryd) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meetZygfrydAwardAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }
}
