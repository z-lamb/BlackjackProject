package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackjackApp {

	private Deck deck;
	private BlackjackHand playerHand;
	private HouseHand houseHand;
	private String userInput, name;

	public static void main(String[] args) {

		BlackjackApp bj = new BlackjackApp();
		Scanner sc = new Scanner(System.in);
		bj.launch(sc);

		sc.close();
	}

	private void launch(Scanner sc) {

		System.out.println("Welcome to the game of Blackjack");
//		System.out.print("Please enter your name >> ");
//		name = sc.nextLine();
		name = "Zach";

		userInput = menu(sc);

		while (!userInput.equals("3")) {
			switch (userInput) {
			case "1":
				displayRules();
				break;
			case "2":
				gamePlay(sc);

				break;
			case "3":
				System.out.println("Thank you " + name + " for playing Blackjack");
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

		newRound();
		showHands();

		while (!userInput.equals("S")) {
			System.out.println("Would you like to hit (h) or stay (s)");
			userInput = sc.next().toUpperCase();
			switch (userInput) {
			case "H":
			case "HIT":
				deal(userInput);
				System.out.println("The current value of your hand is: " + playerHand.getHandValue());
				System.out.println(playerHand.getCards());
			case "S":
			case "STAY":
				break;
			default:
				System.out.print("Please choose hit (h) or stay (s) >> ");
			}
			while (houseHand.getHandValue() < 17) {
				deal(userInput);
			}
		}
	}

	private void newRound() {
		playerHand = new BlackjackHand();
		houseHand = new HouseHand();
		
		for (int i = 0; i < 2; i++) {
			addPlayerCard();
			addHouseCard();
		}
		
	}
	
	private void deal(String userInput) {
		if (userInput.equals("H")) {
			addPlayerCard();
			
		} else {
			addHouseCard();
			
		}

	}

	private void addPlayerCard() {
		Card playerCard = deck.dealCard();
		playerHand.blackjackCards(playerCard);
		playerHand.setHandValue(playerCard.getValue());		
	}
	
	private void addHouseCard() {
		Card houseCard = deck.dealCard();
		houseHand.houseCards(houseCard);
		houseHand.setHandValue(houseCard.getValue());		
	}

	private void showHands() {
		System.out.println();
		System.out.println("House Cards:");
		System.out.println("Mystery Card ???");
		for (int i = 1; i < houseHand.getCards().size(); i++) {
			System.out.println(houseHand.getCards().get(i));
		}
		System.out.println("House hand value is: " + houseHand.getCards().get(1).getValue());
		
		System.out.println();
		System.out.println(name + "'s Cards:");
		for (int i = 0; i < playerHand.getCards().size(); i++) {
			System.out.println(playerHand.getCards().get(i));
		}
		System.out.println(name + "'s hand value is: " + playerHand.getHandValue());
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

		// Add gameplay here
	}

}
