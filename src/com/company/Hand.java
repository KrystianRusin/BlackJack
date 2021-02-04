package com.company;

import java.util.ArrayList;

public class Hand{

    Deck deck = new Deck();
    ArrayList<Cards> hand;
    int cardsDrawn = 0;

    Hand(){
        deck.shuffle();
        hand = new ArrayList<Cards>();
        for(int i = 0; i<2;i++){
            hand.add(deck.drawCard(cardsDrawn));
            cardsDrawn++;
        }

    }

    public void printHand(){
        Cards currCard;
        System.out.println("Your Hand:");
        System.out.println("--------------------------------------");
        for(int i = 0; i<hand.size();i++){
            currCard = hand.get(i);
            if(currCard.getRank() == 11){
                System.out.print("Jack of ");
            }else if(currCard.getRank() == 12){
                System.out.print("Queen of ");
            }else if(currCard.getRank() == 13){
                System.out.print("King of ");
            }else if (currCard.getRank() == 1){
                System.out.print("Ace of ");
            }else {
                System.out.print(currCard.getRank() + " of ");
            }

            if(currCard.getSuit() == 1){
                System.out.print("Hearts");
            }else if(currCard.getSuit() == 2){
                System.out.print("Clubs");
            }else if(currCard.getSuit() == 3){
                System.out.print("Diamond");
            }else if(currCard.getSuit() == 4){
                System.out.print("Spades");
            }

            System.out.println("");

        }

            if(hand.size() == 2 && calculateHand() == 21){
               System.out.println("BLACKJACK!!");
            }else{
                System.out.println("Hand Total: " + calculateHand());
            }
             System.out.println("--------------------------------------");

    }

    public void Hit(){
        hand.add(deck.drawCard(cardsDrawn));
        cardsDrawn++;
    }

    public void resetHand(){
            hand.add(deck.drawCard(cardsDrawn));
            cardsDrawn++;
        }

    public boolean Stand(boolean stand){
        if(stand == true) {
            return true;
        }else{
            return false;
        }
    }

    public void clearHand(){
        for(int i = 0;i<hand.size();i++){
            hand.remove(i);
        }
    }

    public int calculateHand(){
        int total = 0;
        boolean hasAce = false;
        for(int i = 0; i<hand.size();i++){
            total += hand.get(i).getValue();
            if(hand.get(i).getRank() == 1){
                hasAce = true;
            }
        }
        if(total > 21 && hasAce == true){
            total -= 10;
        }
        return total;
    }

}
