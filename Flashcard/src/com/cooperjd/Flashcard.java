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
public class Flashcard {
//------------------------------------------------GLOBALS----------------------------------------
    //Returns true if currently showing the front of the card
    private boolean showingFront;
    //The text on the back of the card
    private String textBack;
    //The text on the front of the card
    private String textFront;

    //------------------------------------------------CONSTRUCTORS----------------------------------------
    //creates flashcard with text on the front and the back
    public Flashcard(String front, String back){
            textFront = front;
            textBack = back;
    }


    //------------------------------------------------METHODS----------------------------------------
    //gets the text on the back of this card
    public String getTextBack() {
            return textBack;
    }

    //gets the front text on this card
    public String getTextFront() {
            return textFront;
    }

    //set the text on the back of this card
    public void setTextBack(String textBack) {
            this.textBack = textBack;
    }

    //sets the front text on this card
    public void setTextFront(String textFront) {
            this.textFront = textFront;
    }

    //prints the text from the back of this card
    public void ShowBack(){
            if(textBack != null){
                    System.out.println(textBack);
                    showingFront = false;
            }
            else
                    System.out.println("No text on back.");
    }

    //prints the text from the front of this card
    public void ShowFront(){
            if(textFront != null){
                    System.out.println(textFront);
                    showingFront = true;
            }
            else
                    System.out.println("No text on front.");
    }
}
