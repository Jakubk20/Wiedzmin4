package com.example.gra.miasto;

import com.example.gra.geralt;
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
    public static int banditMoney = 0;
    public static boolean banditTookMoney = false;
    public static boolean jaskierQuestTaken = false;
    public static boolean jaskierQuest2Taken = false;
    public static boolean jaskierQuest1Done = false;
    @FXML
    protected void onLeave(ActionEvent actionEvent) throws IOException {
        if (startLocation.isZygfryd) {
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

    @FXML
    protected void onByeClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/karczmaFight_2.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onTryToConvinceThemClick(ActionEvent actionEvent) throws IOException {
        jaskierQuestTaken = true;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/karczmaFight.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onJaskierAsksYouClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/karczmaFight_1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onAskLastTimeClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/karczmaFight_1_1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGiveAllMoneyClick(ActionEvent actionEvent) throws IOException {
        banditMoney = geralt.money;
        banditTookMoney = true;
        geralt.money = 0;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/karczmaFight3.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onFightClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/fight1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onTryAgainClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/tryAgain.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onTavernOwnerClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("jaskierKarczma/tavernOwner.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onGetQuest2(ActionEvent actionEvent) throws IOException {
        jaskierQuest2Taken = true;
        banditTookMoney = false;
        jaskierQuestTaken = false;
        jaskierQuest1Done = true;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("novigrad/meet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
