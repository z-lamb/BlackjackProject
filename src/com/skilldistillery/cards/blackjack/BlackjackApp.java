package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	private Deck deck;
	private BlackjackHand playerHand;
	private HouseHand houseHand;
	private String userInput;
	
	public static void main(String[] args) {

		BlackjackApp bj = new BlackjackApp();
		Scanner sc = new Scanner(System.in);
		bj.launch(sc);
		
		sc.close();
	}

	private void launch(Scanner sc) {

		System.out.println("Welcome to the game of Blackjack");
		userInput = menu(sc);
		
		while(!userInput.equals("3")) {
			switch (userInput) {
				case "1":
					displayRules();
					break;
				case "2":
					gamePlay(sc);
					
					break;
				case "3":
					System.out.println("Thank you for playing Blackjack");
					System.out.println("Goodbye");
					return;
				default:
					System.out.println();
					System.out.println("Make a selection by choosing 1, 2, or 3");
					System.out.println();
					
			}
			userInput = menu(sc);
		}
		
		
		
	}

	private void gamePlay(Scanner sc) {
		deck = new Deck();
		deck.shuffle();
		
		playerHand = new BlackjackHand();
		houseHand = new HouseHand();
		newRound();
		showHands();
		
		System.out.println("Would you like to hit (h) or stay (s)");
		userInput = sc.next().toUpperCase();
		while(!userInput.equals("S"))
			switch (userInput) {
				case "H":
					deal(userInput);
					System.out.println("The current value of your hand is: " + playerHand.getHandValue());
					System.out.println(playerHand.getCards());
				case "S":
					break;
				default:
					System.out.println("Please choose hit (h) or stay (s)");
			}
		while(houseHand.getHandValue() < 17) {
			userInput = null;
			deal(userInput);
		}
		
		
	}

	private String menu(Scanner sc) {

		System.out.println("Please make a selection");
		System.out.println("1. Would you like to see how the game works?");
		System.out.println("2. Would you like to start a new game?");
		System.out.println("3. Quit");
		System.out.print(">> ");
		
		String userInput = sc.next();
		return userInput;
	}

	private void displayRules() {

		//Add gameplay here
	}

	private void deal(String userInput) {
		if(userInput.equals("H")) {
			playerHand.blackjackCards(deck.dealCard());
		}
		if(userInput == null) {
			houseHand.houseCards(deck.dealCard());
		}
		
	}

	private void showHands() {
		
		System.out.println(houseHand.getCards());
		System.out.println(playerHand.getCards());
	}

	private void newRound() {

		for (int i = 0; i < 2; i++) {
			playerHand.blackjackCards(deck.dealCard());
			houseHand.houseCards(deck.dealCard());
		}
		
	}
	
	

}
