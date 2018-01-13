/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cooperjd;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author cooperjd
 */
public class Box {
//------------------------------------------------GLOBALS----------------------------------------
    //The list of available cards
    private ArrayList<Flashcard> cards;
    //The maximum amount of cards that can be in one box
    public static final int MAX_CARDS = 5;

    //------------------------------------------------CONSTRUCTORS----------------------------------------
    //creates new box with no cards in it
    public Box(){
            cards = new ArrayList<Flashcard>();
    }

    //creates new box with a set of cards in it
    public Box(ArrayList<Flashcard> imports, int boxNumber){
            for(int i=0; i < MAX_CARDS; i++)
                    cards.add(imports.get(i));
    }


    //--------------------------------------------------METHODS----------------------------------------
    //adds a card to this box
    public void AddCard(Flashcard card){
            this.cards.add(card);
    }

    //adds a set of cards to this box
    public void AddCards(ArrayList<Flashcard> addedCards, int boxNumber){
            for(int i=0; i < MAX_CARDS; i++)
                    cards.add(addedCards.get(i));
    }
    
    //gets a random card from the box
    public Flashcard GetCard(){
            Random r = new Random();
            int index = r.nextInt(cards.size());
            if(index <= 0){
                index = 1;
            }
            return cards.get(index);
    }

    //removes a card from this box
    public void RemoveCard(Flashcard card){
            int cardIndex = cards.indexOf(card);
            cards.remove(cardIndex);
    }

    //gets how many cards are in this box
    public int size(){
            return cards.size();
    }
}
