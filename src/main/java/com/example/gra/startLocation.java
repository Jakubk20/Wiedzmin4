package com.example.gra;

import com.example.gra.ghul.ghul;
import com.example.gra.utopiec.utopiec;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class startLocation {
    public static boolean isQuest = false;
    public static boolean isBiesDefeated = false;
    public static boolean isZygfryd = false;


    @FXML
    protected void onTavernClick(ActionEvent actionEvent) throws IOException {
        if (isQuest && !isBiesDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/questNotCompleted.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (isQuest && isBiesDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/questCompleted.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (!isQuest && isBiesDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/questDone.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/getQuest.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

    @FXML
    protected void onLeaveClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNorth.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    @FXML
    protected void onGoToNPCNorthClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNorthNPCMeet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onReturnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/startLocation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGetQuestClick(ActionEvent actionEvent) throws IOException {
        isQuest = true;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/startLocation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGetRewardClick(ActionEvent actionEvent) throws IOException {
        geralt.money += 500;
        geralt.amountOfPotions += 1;
        isQuest = false;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/awardGranted.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGetRewardClickNPC(ActionEvent actionEvent) throws IOException {
        geralt.money += 50;
        ghul.awardAvailable = false;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNorth.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onDontGetRewardClick(ActionEvent actionEvent) throws IOException {
        ghul.awardAvailable = false;
        isZygfryd = true;
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNorthNPCGold.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }


    @FXML
    protected void onGoToTavernClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("tavern/startLocation.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGoSouthClick(ActionEvent actionEvent) throws IOException {
        if (isQuest && !isBiesDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bies/meet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNull.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    protected void onGoToWhiteOrchardClick(ActionEvent actionEvent) throws IOException {
        if (isQuest && isBiesDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadQuestAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (isQuest) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadQuestNotDone.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySad.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

    @FXML
    protected void onGoToNorthClick(ActionEvent actionEvent) throws IOException {
        if (!utopiec.isDefeated && !ghul.isDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("utopiec/meet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (!ghul.isDefeated) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("ghul/meet.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else if (ghul.awardAvailable) {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNorthAwardAvailable.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("bialySadNorth.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }

    }

    @FXML
    protected void onTraderClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(start.class.getResource("trader1/trader1meet.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    protected void onGoToNovigradClick(ActionEvent actionEvent) throws IOException {
        if (isZygfryd){
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
