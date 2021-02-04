package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Cards> deck;


    Deck(){
        deck = new ArrayList<Cards>();
        for (int i = 1; i<=4;i++){
            for(int j = 1; j<=13;j++){
                deck.add(new Cards(i, j));
            }
        }

    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public Cards drawCard(int cardsDrawn){

        Cards nextCard = deck.remove(cardsDrawn);

        return nextCard;
    }


}
