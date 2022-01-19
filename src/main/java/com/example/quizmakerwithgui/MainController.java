package com.example.quizmakerwithgui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public Button quitbutton;

    @FXML
    public void onHighScoreButtonClick(ActionEvent actionEvent) throws IOException, InterruptedException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Highscore.fxml"));
        root = loader.load();

        Highscore h = new Highscore();
        String out = h.printHighscore();
        HSController hsController = loader.getController();
        hsController.tranferMessage(out);

        stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onStartGameButtonClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        root = loader.load();


        GController gController = loader.getController();
        gController.tranferMessage("Please click in the Text Area to Start");


        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onQuitButtonClick(ActionEvent actionEvent) {
        quitbuttonaction(quitbutton);
    }

    public static void quitbuttonaction(Button quitbutton) {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.NO);
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                "Do you want to quit?");

        alert.setTitle("Quit Game");

        alert.getButtonTypes().setAll(yes, no);
        alert.showAndWait().ifPresent(type -> {
            if (type == yes) {
                Stage stage = (Stage) quitbutton.getScene().getWindow();
                stage.close();
            }
        });
    }
}