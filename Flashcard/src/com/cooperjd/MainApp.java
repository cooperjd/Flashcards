/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperjd;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cooperjd
 */
public class MainApp {
    //Main Driver Class
    //------------------------------------------------GLOBALS----------------------------------------
    //The list of boxes
    private static ArrayList<Box> boxes = new ArrayList<Box>();
    //The index of the box that contains the picked card
    private static int boxIndex = 0;
    //The list of flashcards
    private static ArrayList<Flashcard> cards;
    //The string that will terminate the application
    private static final String exitString = "!exit";
    //The card that is currently chosen to be shown
    private static Flashcard pickedCard;
    //A reference to the box that the last picked card was chosen from 
    private static Box previousBox;
    //The scanner used to read user input
    private static Scanner scan;
    //The user
    private static User user;

    //------------------------------------------------METHODS----------------------------------------
    //Reads user name and FlashCard File
    public static void main(String[] args)throws FileNotFoundException, IOException{
        scan = new Scanner(System.in);
        System.out.println("What is your name?");
        user = new User(scan.next());  //Sets the Users name
        Load();
    }

        //tells user that they answered correctly and keeps track of how many answers are correct and gets a new card
        public static void answeredCorrect(Flashcard card){
            user.setCorrectAnswers(1);
            System.out.println("Correct. " + user.GetName() + " has " + user.getCorrectAnswers() + " card(s) answered correctly.");
            user.showStats();
            if(boxIndex < 5){
                    boxes.get(boxIndex + 1).AddCard(card);
            }
            GetRandomCard();		
        }

        //tells user that they answered incorrectly and keeps track of how many answers are incorrect and gets a new card
        public static void answeredIncorrect(Flashcard card){
            user.setIncorrectAnswers(1);
            System.out.println("Incorrect. " + user.GetName() + " has " + user.getIncorrectAnswers() + " card(s) answered incorrectly.");
            user.showStats();
            GetRandomCard();
        }

        //puts the cards into boxes by increments of 5
        public static void BoxPlacement(){
            int BoxesToCreate = cards.size()/Box.MAX_CARDS;
            for(int i=0; i < BoxesToCreate; i++)
                    boxes.add(new Box());

            for(int i=0; i < BoxesToCreate; i++)
                    boxes.get(i).AddCards(cards, i);
        }

        //Removes all cards from all boxes
        public static void EmptyBoxes(){
            for(int i=0; i < boxes.size(); i++){
                boxes.remove(i);
            }
        }
        
        //returns a random box 
        public static Box GetRandomBox(){
            Random r = new Random();
            int index = r.nextInt(boxes.size());
            if(index == boxes.indexOf(previousBox))
                    index = 1;
            previousBox = boxes.get(index);
            return boxes.get(index);
        }

        //Gets a random card from a random box
        public static void GetRandomCard(){
            Scanner scan = new Scanner(System.in);
            Flashcard card = GetRandomBox().GetCard();
            pickedCard = card;
            card.ShowFront();
            String input = scan.nextLine().toString();
            if(input.equals(exitString)){
                    System.exit(0);
            }else if(input.equals(card.getTextBack())){
                answeredCorrect(pickedCard);
            }else{
                answeredIncorrect(pickedCard);
            }
        }
        
        //Loads a file that contains the information for the flashcards
        public static void Load() throws FileNotFoundException, IOException{
            System.out.println("Import");
            EmptyBoxes();
            user.setCorrectAnswers(0);
            user.setIncorrectAnswers(0);
            //Gets the cards info from a text file and creates the cards
            InputStream in = new FileInputStream(new File("Resources/" + scan.next()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder out = new StringBuilder();
            ArrayList<String> lines = new ArrayList<String>();
            int count = 0;
            int lineCount = 0;
            String line;

            while ((line = reader.readLine()) != null){
                out.append(line);
                out.append("\n");
                lines.add(line);
                count++;
            }
            cards = new ArrayList<Flashcard>();
            if(count%2 !=0)
                count = count - 1;

            for(int c=0; c < count/2; c++){
                cards.add(new Flashcard("front" + " " + c, "Back" + " " + c));
            }

            for(int i=0; i < count/2; i++){
                Flashcard card = cards.get(i);
                card.setTextFront(lines.get(lineCount));
                card.setTextBack(lines.get(lineCount+1));
                lineCount = lineCount + 2;
            }

            System.out.println(count/2 + " cards have been imported.\nBeginning Study");

            BoxPlacement();
            GetRandomCard();
        }
}
