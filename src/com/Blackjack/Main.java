package com.Blackjack;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.*;
import javax.swing.*;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int money;
        int bet;
        boolean userWins;

        money = 100;


        System.out.println("Welcome to the game of BlackJack!");


        do {
            System.out.println("You have " + money + " dollars.");
                System.out.println("How much money would you like to bet? (Enter 0 to end)");
                bet = scan.nextInt();
                if (bet < 0 || bet > money){
                    System.out.println("Your answer must be between 0 and " + money + ".");
                }
                if (bet == 0){
                    break;
                }
                userWins = playBlackjack();

                if (userWins) {
                    money = money + bet;
                }
                else {
                    money = money - bet;
                }
                if (money == 0) {
                    System.out.println("Looks like you're all out of money.");
                    break;
                }
        } while(true);

        System.out.println("You leave with $" + money + ".");
    } //end of main

    static boolean playBlackjack() {
        //let user play one game
        //return true if user wins, false if user loses

        Deck deck;
        BlackjackHand dealerHand;
        BlackjackHand userHand;

        dealerHand = new BlackjackHand();
        deck = new Deck();
        userHand = new BlackjackHand();

        //shuffle the deck then deal 2 cards to each player

        deck.shuffle();
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());

        System.out.println();
        System.out.println();

        //check if one of the players has Blackjack (two cards totaling 21)

        if (dealerHand.getBlackjackValue() == 21) {
            System.out.println("Dealer has the " + dealerHand.getCard(0) + "and the " + dealerHand.getCard(1) + ".");
            System.out.println("User has the " + userHand.getCard(0) + " and the " + userHand.getCard(1) + ".");
            System.out.println();
            System.out.println("You have Blackjack. You win!");
            return true;
        }

        //if neither player has blackjack, play the game.
        //the user will first draw cards. the while loop will end when the user decides to stand.
        //if the user goes over 21, they lose immediately

        while (true) {
            //display user's cards, and let user decide to hit or stand

            System.out.println();
            System.out.println();
            System.out.println("Your cards are: ");
            for (int i = 0; i < userHand.getCardCount(); i++) {
                System.out.println("  " + userHand.getCard(i));
            }
            System.out.println("Your total is " + userHand.getBlackjackValue());
            System.out.println();
            System.out.println("Dealer is showing the " + dealerHand.getCard(0));
            System.out.println();
            System.out.println("Hit (H) or Stand (S)");
            char userAction;
            do {
                userAction = Character.toUpperCase(scan.next().charAt(0));
                if (userAction != 'H' && userAction != 'S') {
                    System.out.println("Please type H or S: ");
                }
            }
                while (userAction != 'H' && userAction != 'S');

                if (userAction == 'S') {
                    break;
                }
                else {
                    Card newCard = deck.dealCard();
                    userHand.addCard(newCard);
                    System.out.println();
                    System.out.println("User Hits.");
                    System.out.println("Your card is the " + newCard);
                    System.out.println("Your total is now " + userHand.getBlackjackValue());
                    if (userHand.getBlackjackValue() > 21) {
                        System.out.println("You busted by going over 21. You lose.");
                        System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                        return false;
                    }
                }
            }

            //if you get to this point, the user has stood with 21 or less
            //it is now the dealer's turn to draw.
            //dealer draws cards until the dealer's total is > 16.
            //dealer loses if goes over 21
            System.out.println();
            System.out.println("User stands.");
            System.out.println("Dealer's cards are a " + dealerHand.getCard(0) + " and " + dealerHand.getCard(1));
            while (dealerHand.getBlackjackValue() <= 16) {
                Card newCard = deck.dealCard();
                System.out.println("Dealer hits and gets a " + newCard);
                dealerHand.addCard(newCard);
                if (dealerHand.getBlackjackValue() > 21) {
                    System.out.println();
                    System.out.println("Dealer busted by going over 21.  You win.");
                    return true;
            }
        }

        System.out.println("Dealer's total is " + dealerHand.getBlackjackValue());

          //at this point both players have 21 or less
          //determine the winner by comparing the values with their hands

        System.out.println();
        if (dealerHand.getBlackjackValue() == userHand.getBlackjackValue()) {
            System.out.println("Dealer wins on a tie.  You lose.");
            return false;
        }
        else if (dealerHand.getBlackjackValue() > userHand.getBlackjackValue()) {
            System.out.println("Dealer wins, " + dealerHand.getBlackjackValue()
                    + " points to " + userHand.getBlackjackValue() + ".");
            return false;
        }
        else {
            System.out.println("You win, " + userHand.getBlackjackValue()
                    + " points to " + dealerHand.getBlackjackValue() + ".");
            return true;
        }

        }
    }



