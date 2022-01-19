//manages the game the user plays

package com.example.quizmakerwithgui;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //Class variables
    private final Questionnaire questionnaire;
    private final int maxQuestions;
    private int questionNumber;
    private int points;
    private final Player player;
    private Question question;
    private final Joker fifty = new Joker("50/50");
    private final Joker hint = new Joker("Hint");
    private final Joker skip = new Joker("Skip question");

    //Constructor
    public Game(String playerName, int maxQuestions) {
        this.questionnaire = new Questionnaire();
        this.player = new Player(playerName, 0, "");
        this.maxQuestions = maxQuestions;
        this.questionNumber = 0;
        this.points = 0;
    }

    //Methods
    public void addQuestionNumber() {
        this.questionNumber++;
    }

    //Returns question with difficulty appropriate for the progress of the game
    public Question getQuestion() {
        int difficulty = (int) Math.ceil((float)this.questionNumber/(float)this.maxQuestions*3);
        this.question = this.questionnaire.randomQuestion(difficulty);
        return this.questionnaire.randomQuestion(difficulty);
    }

    public String printQuestionNumber() {
        return("Question number " + this.questionNumber + " of " + this.maxQuestions + System.lineSeparator());
    }

    public String printQuestion() {
        String output = this.question.getQuestion() + System.lineSeparator();
        for(int i = 0; i < this.question.getAnswers().length; i++) {
            output += "(" + (i+1) + ") " + this.question.getAnswers()[i] + System.lineSeparator();
        }
        output += "Jokers: (5) " + this.fifty.getJokerName() + " (6) " + this.hint.getJokerName() + " (7) " + this.skip.getJokerName() + System.lineSeparator();
        output += "(8) give up and quit the game";
        return(output);
    }

    public boolean checkAnswer(int answer) {
        return this.question.getRightAnswer() == answer;
    }

    public String printRightAnswer() {
        return(this.question.getAnswers()[this.question.getRightAnswer() - 1]+ System.lineSeparator());
    }

    public void addPoints() {
        int difficulty = (int) Math.ceil((float)this.questionNumber/(float)this.maxQuestions*3);
        this.points += this.questionNumber * difficulty;
    }

    public void deductPoints() {
        int difficulty = (int) Math.ceil((float)this.questionNumber/(float)this.maxQuestions*3);
        if (this.points > this.questionNumber * difficulty / 3) {
            this.points -= this.questionNumber * difficulty / 3;
        } else {
            this.points = 0;
        }
    }

    public String printStatus() {
        return("Current points: " + this.points + System.lineSeparator());
    }

    public boolean End() {
        return this.questionNumber == this.maxQuestions;
    }

    //prints Victory message, different depending on points
    public void printVictory() {
        int maxPoints = 0;
        if (this.maxQuestions == 9) {
            maxPoints = 108;
        } else if (this.maxQuestions == 12) {
            maxPoints = 188;
        } else if (this.maxQuestions == 15) {
            maxPoints = 290;
        }
        String output = this.points + " of " + maxPoints + " Points!";
        if (this.points < maxPoints *0.5) {
            output = "You need some practice. You only have " + output;
        } else if (this.points < maxPoints *0.8) {
            output = "Good job! You have " + output;
        } else if (this.points < maxPoints) {
            output = "Excellent! You have " + output;
        } else {
            output =  "Full score! Incredible!";
        }
        System.out.println(output);
    }

    public int getPoints() {
        return this.points;
    }

    public String getPlayerName() {
        return this.player.getPlayerName();
    }

    public void useFiftyFifty() {
        if (this.fifty.isAvailable()) {
            System.out.println("You selected the 50/50 joker.");
            ArrayList<Integer> a = new ArrayList<>(List.of(0, 1, 2, 3));
            a.remove(this.question.getRightAnswer()-1);  //remove index of right answer --> indices of 3 wrong answers remain
            a.remove((int) (Math.random() * 3));        //remove random index of 1 of 3 remaining wrong answer --> indices of 2 wrong answers remain
            for (int i: a) {
                this.question.getAnswers()[i] = "";      // set values of 2 remaining wrong answers to ""
            }
            this.printQuestion();
            this.fifty.setAvailable(false);
        } else {
            System.out.println("You already used the 50/50 joker.");
        }

    }

    public void useHint() {
        if (this.hint.isAvailable()) {
            System.out.println("You selected the hint joker.");
            System.out.println("Hint: " + this.question.getHint());
            System.out.println("(Hint joker not fully implemented...)");
            this.hint.setAvailable(false);
        } else {
            System.out.println("You already used the hint joker.");
        }
    }

    public void useSkip() {
        if (this.skip.isAvailable()) {
            System.out.println("You selected the skip joker. Here is your new question:");
            this.skip.setAvailable(false);
            this.question = this.getQuestion();
            this.printQuestion();
        } else {
            System.out.println("You already used the skip joker.");
        }
    }

}
