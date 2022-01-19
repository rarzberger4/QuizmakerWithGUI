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
import java.util.Optional;

public class HSController {


    @FXML
    public TextArea highscore;
    public Button quitbutton;

    public void tranferMessage(String message){
        highscore.setText(message);
    }


    public void quit(ActionEvent actionEvent) {
        MainController.quitbuttonaction(quitbutton);
    }

    public void onstartbuttonclick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
        Parent root = loader.load();


        GController gController = loader.getController();
        gController.tranferMessage("Please click in the Text Area to Start");


        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
