package com.example.quizmakerwithgui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GController {

    public Button quitbutton;
    public Game myGame = new Game("GUIGuy", 9);
    public TextArea GameTextArea;
    Sounds s = new Sounds();



    public void tranferMessage(String message) {
        GameTextArea.setText(message);
    }

    public void startGame(){
        myGame.addQuestionNumber();
        myGame.getQuestion();
        GameTextArea.setText(myGame.printQuestionNumber() + myGame.printQuestion());
    }


    public void onButtonAclick(ActionEvent actionEvent) {
        if(myGame.checkAnswer(1)){
            myGame.addPoints();
            GameTextArea.setText("Correct!"+ System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playPosSound();
        }else{
            myGame.deductPoints();
            GameTextArea.setText("Wrong... Correct answer: " + myGame.printRightAnswer() + System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playNegSound();
        }


    }

    public void onButtonBclick(ActionEvent actionEvent) {
        if(myGame.checkAnswer(2)){
            myGame.addPoints();
            GameTextArea.setText("Correct!"+ System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playPosSound();
        }else{
            myGame.deductPoints();
            GameTextArea.setText("Wrong... Correct answer: " + myGame.printRightAnswer() + System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playNegSound();
        }
    }

    public void onButtonCclick(ActionEvent actionEvent) {
        if(myGame.checkAnswer(3)){
            myGame.addPoints();
            GameTextArea.setText("Correct!"+ System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playPosSound();
        }else{
            myGame.deductPoints();
            GameTextArea.setText("Wrong... Correct answer: " + myGame.printRightAnswer() + System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playNegSound();
        }
    }

    public void onButtonDclick(ActionEvent actionEvent) throws InterruptedException {
        if(myGame.checkAnswer(4)){
            myGame.addPoints();
            GameTextArea.setText("Correct!"+ System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playPosSound();
        }else{
            myGame.deductPoints();
            GameTextArea.setText("Wrong... Correct answer: " + myGame.printRightAnswer() + System.lineSeparator() + myGame.printStatus() + System.lineSeparator());
            myGame.addQuestionNumber();
            myGame.getQuestion();
            GameTextArea.setText(GameTextArea.getText() + myGame.printQuestionNumber() + myGame.printQuestion());
            s.playNegSound();
        }
    }

    public void onButton5050click(ActionEvent actionEvent) {
    }

    public void onButtonSkipclick(ActionEvent actionEvent) {
    }

    public void onquitbuttonClick(ActionEvent actionEvent) {
        MainController.quitbuttonaction(quitbutton);
    }
}
