package com.company;

import java.util.ArrayList;

public class Dealer {

    Deck deck = new Deck();
    ArrayList<Cards> dealerHand;
    int cardsDrawn = 0;

    Dealer() {
        deck.shuffle();
        dealerHand = new ArrayList<Cards>();
        for (int i = 0; i < 2; i++) {
            dealerHand.add(deck.drawCard(cardsDrawn));
            cardsDrawn++;
        }
    }

    public void printHand() {
        Cards currCard;
        System.out.println();
        System.out.println("Dealer: ");
        System.out.println("--------------------------------------");
        for (int i = 0; i < dealerHand.size(); i++) {
            currCard = dealerHand.get(i);
            if (currCard.getRank() == 11) {
                System.out.print("Jack of ");
            } else if (currCard.getRank() == 12) {
                System.out.print("Queen of ");
            } else if (currCard.getRank() == 13) {
                System.out.print("King of ");
            } else if (currCard.getRank() == 1) {
                System.out.print("Ace of ");
            } else {
                System.out.print(currCard.getRank() + " of ");
            }

            if (currCard.getSuit() == 1) {
                System.out.print("Hearts");
            } else if (currCard.getSuit() == 2) {
                System.out.print("Clubs");
            } else if (currCard.getSuit() == 3) {
                System.out.print("Diamond");
            } else if (currCard.getSuit() == 4) {
                System.out.print("Spades");
            }

            System.out.println("");
            dealerHit();
        }

        if (dealerHand.size() == 2 && calculateHand() == 21) {
            System.out.println("Dealer BLACKJACK!!");
        } else if(calculateHand() > 21){
            System.out.println("Dealer Bust: " + calculateHand());
        }else {
            System.out.println("Dealer Hand Total: " + calculateHand());
        }
        System.out.println("--------------------------------------");


    }

    public boolean dealerHit() {

        if (calculateHand() < 17) {
            dealerHand.add(deck.drawCard(cardsDrawn));
            cardsDrawn++;
            return true;
        }else{
            return false;
        }
    }

    public void clearDealerHand(){
        for(int i = 0;i<dealerHand.size();i++){
            dealerHand.remove(i);
        }
    }

    public void resetHand(){
        for (int i = 0; i < 2; i++) {
            dealerHand.add(deck.drawCard(cardsDrawn));
            cardsDrawn++;
        }
    }

    public int calculateHand() {
        int total = 0;
        boolean hasAce = false;
        for (int i = 0; i < dealerHand.size(); i++) {
            total += dealerHand.get(i).getValue();
            if (dealerHand.get(i).getRank() == 1) {
                hasAce = true;
            }
        }
        if (total > 21 && hasAce == true) {
            total -= 10;
        }
        return total;
    }
}

