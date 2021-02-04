package com.company;

public class Cards {

    private int rank;
    private int suit;
    private int value;

    Cards(int suit, int value){
        this.rank = value;
        this.suit = suit;
    }

    public int getRank(){

        return rank;
    }

    public int getSuit(){

        return suit;
    }

    public int getValue(){

        if(rank > 10){
            value = 10;
        }
        else if (rank == 1){
            value = 11;
        }
        else {
            value = rank;
        }

        return value;
    }

}
