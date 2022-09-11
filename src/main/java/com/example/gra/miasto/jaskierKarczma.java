package com.example.gra.miasto;

import com.example.gra.start;
import com.example.gra.startLocation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class jaskierKarczma {
    @FXML
    protected void onLeave(ActionEvent actionEvent) throws IOException {
        if (startLocation.isZygfryd){
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meetZygfrydAwardAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else{
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }
}
