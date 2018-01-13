/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperjd;

/**
 *
 * @author cooperjd
 */
public class User {
//------------------------------------------------GLOBALS----------------------------------------
    //The number of correct answers
    private int correctAnswers;
    //The number of incorrect answers
    private int incorrectAnswers;
    //The name of the user
    private String name;

    //------------------------------------------------CONSTRUCTORS----------------------------------------
    //creates a new user and assigns the user a name
    public User(String userName){
            name = userName;
            correctAnswers = 0;
            incorrectAnswers = 0;
    }

    //------------------------------------------------METHODS----------------------------------------
    //Gets how many correct answers this user has
    public int getCorrectAnswers() {
            return correctAnswers;
    }

    //Gets how many incorrect answers this user has
    public int getIncorrectAnswers() {
            return incorrectAnswers;
    }

    //Gets the name of this user
    public String GetName(){
            return name;
    }

    //adds one to the amount of correct Answers this user has
    public void setCorrectAnswers(int correctAnswer) {
            this.correctAnswers = this.correctAnswers + correctAnswer;
    }

    //adds one to the amount of incorrect Answers this user has
    public void setIncorrectAnswers(int incorrectAnswer) {
            this.incorrectAnswers = this.incorrectAnswers + incorrectAnswer;
    }

    //Displays the amount of correct/incorrect answers
    public void showStats(){
        System.out.println(name.toUpperCase() + " - Correct: " + correctAnswers + " || Incorrect: " + incorrectAnswers);
    }
    
    //Sets the name of this user
    public void SetName(String newName){
            this.name = newName;
    }
}
