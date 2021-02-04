package com.company;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Hand hand = new Hand();
		Dealer dealer = new Dealer();
		Scanner s = new Scanner(System.in);
		int nextMove;
		String newHand;
		boolean stand = false;

	do {
		hand.printHand();
		do {
			System.out.println("Enter 1 to hit or 2 to stand");
			nextMove = s.nextInt();
			switch (nextMove) {
				case 1:
					hand.Hit();
					dealer.dealerHit();
					hand.printHand();
					break;
				case 2:
					stand = true;
					dealer.dealerHit();
					hand.printHand();
					break;
			}
            if(hand.calculateHand()>21){
                System.out.println("Bust");
                stand = true;
            }


        } while (hand.Stand(stand) == false && hand.calculateHand() <= 21);

		dealer.printHand();
		if(hand.calculateHand() > dealer.calculateHand() && hand.calculateHand() <= 21 || dealer.calculateHand() > 21){
			System.out.println("You Win");
		}else if(hand.calculateHand() > 21 && dealer.calculateHand() > 21){
		    System.out.println("Tie");
		} else{
			System.out.println("You lose");
		}
        stand = false;
		hand.clearHand();
		dealer.clearDealerHand();
		hand.resetHand();
		dealer.resetHand();
		System.out.println("Do you want to do a new hand? y/n");
		newHand = s.next();
	}while(newHand.equals("y"));
	System.out.println("Thanks for playing");

	}
}
