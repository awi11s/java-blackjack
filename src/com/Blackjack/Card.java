package com.Blackjack;
import java.util.*;
import java.lang.*;

public class Card {

    public final static int spades = 0,       // Codes for the 4 suits.
            hearts = 1,
            diamonds = 2,
            clubs = 3;

    public final static int ace = 1,          // Codes for the non-numeric cards.
            jack = 11,        //   Cards 2 through 10 have their
            queen = 12,       //   numerical values for their codes.
            king = 13;
//creating card object

    private final int suit;
    private final int value;

    public Card(int theValue, int theSuit) {
        value = theValue;
        suit = theSuit;
}

//string version of card


    public int getSuit() {
        return suit;
}

    public int getValue() {
        return value;
}

    public String getSuitAsString() {
        //returns string representing card's suit
        switch( suit ) {
            case spades: return "Spades";
            case hearts: return "Hearts";
            case diamonds: return "Diamonds";
            case clubs: return "Clubs";
            default: return "??";
        }
    }

    public String getValueAsString() {
        //returns string representing card's value
        switch ( value ) {
            case 1:   return "Ace";
            case 2:   return "2";
            case 3:   return "3";
            case 4:   return "4";
            case 5:   return "5";
            case 6:   return "6";
            case 7:   return "7";
            case 8:   return "8";
            case 9:   return "9";
            case 10:  return "10";
            case 11:  return "Jack";
            case 12:  return "Queen";
            case 13:  return "King";
            default:  return "??";
        }
    }

    public String toString() {
        //return string representing this card such as "2 of Clubs"
        return getValueAsString() + " of " + getSuitAsString();
    }
}