package com.Blackjack;
import java.util.*;

public class Hand {
    private Vector hand;

    public Hand(){
        hand = new Vector();
    }

    public void clear(){
        hand.removeAllElements();
    }

    public void addCard(Card c) {
        //add the card c to the hand. c should be non-null
        //if c is null nothing will be added
        if (c != null){
            hand.addElement(c);
        }

    }


    public void removeCard(Card c) {
        //if the specified card is in hand,it is removed
        hand.removeElement(c);
    }

    public void removeCard(int position) {
        //if the specified position is a valid position in the hand then the card in that position is removed.
        if (position >= 0 && position < hand.size()){
            hand.removeElementAt(position);
        }
    }

    public int getCardCount() {
        //return the number of cards in the hand
        return hand.size();
    }

    public Card getCard(int position) {
        //get the card from hand in given position, where pos. are numbered starting from 0
        //if the specified position is not the pos. number of a card in the hand, then null is returned
        if (position >= 0 && position < hand.size()){
            return (Card)hand.elementAt(position);
        }
        else {
            return null;
        }
    }


    public void sortBySuit() {
        //sorts cards so they are grouped together by same suit
        Vector newHand = new Vector();
        while (hand.size() > 0) {
            int pos = 0; //position of minimal card
            Card c = (Card)hand.elementAt(0); //minimal card
            for (int i = 1; i < hand.size(); i++){
                Card c1 = (Card)hand.elementAt(i);
                if (c1.getSuit() < c.getSuit() ||
                        (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.removeElementAt(pos);
            newHand.addElement(c);
        }
        hand = newHand;
    }

    public void sortByValue() {
        //sorts cards in the hand so that cards of the same value are grouped together.
        //cards with same value are sorted by suit
        Vector newHand = new Vector();
        while (hand.size() > 0) {
            int pos = 0;
            Card c = (Card)hand.elementAt(0); //minimal card
            for (int i = 1; i < hand.size(); i++){
                Card c1 = (Card)hand.elementAt(i);
                if (c1.getValue() < c.getValue() ||
                        (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit())) {
                    pos = i;
                    c = c1;
                }
            }
            hand.removeElementAt(pos);
            newHand.addElement(c);
        }
        hand = newHand;
    }

}