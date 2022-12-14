package com.example.gra.miasto;

import com.example.gra.start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class winboss {
    @FXML
    private Label monety;
    @FXML
    protected void initialize(){
        int monetyy = 500 + jaskierKarczma.banditMoney;
        jaskierKarczma.banditMoney = 0;
        monety.setText(String.valueOf(monetyy));
    }
    @FXML
    protected void onNextClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/jaskierWin.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
