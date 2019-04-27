package com.Blackjack;
import java.util.*;
import java.lang.*;

public class Deck {
    private Card[] deck;
    private int cardsUsed; //cards been dealt from the deck

     public Deck(){
         deck = new Card[52];
         int cardCreated = 0; //cards created so far
         for (int suit = 0; suit < 3; suit++){
             for (int value = 1; value <= 13; value++){
                 deck[cardCreated] = new Card(value, suit);
                 cardCreated++;
             }
         }
         cardsUsed = 0;
     }

     public void shuffle() {
         //put all used cards back into the deck, and shuffle them in random order
         for(int i = 51; i > 0; i--){
             int rand = (int)(Math.random()*(i+1));
             Card temp = deck[i];
             deck[i] = deck[rand];
             deck[rand] = temp;
         }
         cardsUsed = 0;
     }

    public int cardsLeft() {
        // As cards are dealt from the deck, the number of cards left
        // decreases.  This function returns the number of cards that
        // are still left in the deck.
        return 52 - cardsUsed;
    }

    public Card dealCard() {
        // Deals one card from the deck and returns it.
        if (cardsUsed == 52) {
            shuffle();
        }
        cardsUsed++;
        return deck[cardsUsed - 1];
    }

}