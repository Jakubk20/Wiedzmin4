package com.example.gra;

import com.example.gra.test1.leszy;
import com.example.gra.test2.ghul;
import com.example.gra.test3.bies;
import com.example.gra.test4.utopiec;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class death {
    @FXML
    protected void onPlayAgainClick(ActionEvent actionEvent) throws IOException {
        geralt.moc = 0;
        geralt.power=((10+20) / 2) + geralt.moc;
        geralt.currentHP =100;
        geralt.maxHP =100;
        geralt.money=0;
        geralt.amountOfPotions = 0;
        leszy.currentHP = leszy.maxHP;
        ghul.currentHP = ghul.maxHP;
        bies.currentHP = bies.maxHP;
        utopiec.currentHP = utopiec.maxHP;

        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
