package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	private Deck deck;
	private BlackjackHand playerHand;
	private HouseHand houseHand;
	
	public static void main(String[] args) {

		BlackjackApp bj = new BlackjackApp();
		Scanner sc = new Scanner(System.in);
		bj.launch(sc);
		
		sc.close();
	}

	private void launch(Scanner sc) {

		System.out.println("Welcome to the game of Blackjack");
		String userInput = menu(sc);
		
		while(!userInput.equals("3")) {
			switch (userInput) {
				case "1":
					displayGamePlay();
					break;
				case "2":
					deck = new Deck();
					deck.shuffle();
					
					playerHand = new BlackjackHand();
					houseHand = new HouseHand();
					break;
				case "3":
					System.out.println("Thank you for playing Blackjack");
					System.out.println("Goodbye");
					return;
				default:
					System.out.println("Please make a selection by choosing 1, 2, or 3");
				
			}
			userInput = menu(sc);
		}
		
		newRound();
		showHands();
		deal(sc);
		
		
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

	private void displayGamePlay() {

		//Add gameplay here
	}

	private void deal(Scanner sc) {

		
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
