package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class GameOperator {

	private Deck deck;
	private PlayerHand playerHand = new PlayerHand();
	private HouseHand houseHand = new HouseHand();
	private String userInput, name;

	// creates list to check against for user options
	private List<String> hitSelection = new ArrayList<>(Arrays.asList("H", "HIT"));
	private List<String> staySelection = new ArrayList<>(Arrays.asList("S", "STAY"));
	private List<String> newRoundCheck = new ArrayList<>(Arrays.asList("Y", "YES", "N", "NO"));

	public void playGame(Scanner sc, String name) {

		// assigns name to this.name so that it can be used throughout the class
		this.name = name;
		
		// creates and shuffles a new deck
		deck = new Deck();
		deck.shuffle();

		// list to check against if the user would like to play a new hand
		List<String> newRoundSelection = new ArrayList<>(Arrays.asList("Y", "YES"));

		// loop for new round
		do {
			// calls method to create new round
			newRound();

			// if user has 21 and house does not have 21 at initial shuffle the user wins
			if (playerHand.getHandValue() == 21 && houseHand.getHandValue() != 21) {
				System.out.println("BLACKJACK! You win!!!");
				System.out.println("Play another round");
				endOfRound();
				continue;
			}

			// call method to prints hands
			showHands();

			// if user has less than 21 ask to see if they would like to hit or stay
			if (playerHand.getHandValue() < 21) {
				// loop until the user decides to stay
				do {
					System.out.print("\nWould you like to hit (h) or stay (s) >> ");
					userInput = sc.next().toUpperCase();
					// deal card is user decides to hit and show hands
					if (hitSelection.contains(userInput)) {
						deal(true);
						showHands();
					}
					// if user goes over 21 round is over
					if (playerHand.getHandValue() > 21) {
						System.out.println("\nBUST! You went over 21 and lose this round.\n");
						break;
					}
				} while (!staySelection.contains(userInput));
			}

			// if player hand is less than or equal to 21 house will draw cards until it
			// hits 17 or more
			if (playerHand.getHandValue() <= 21) {
				while (houseHand.getHandValue() < 17) {
					deal(false);
				}
			}

			// if player hand is less than or equal to 21 go the end of game method
			if (playerHand.getHandValue() <= 21) {
				endOfRound();
			}

			// loop to check userInput
			do {
				// reset userInput to empty string
				userInput = "";
				System.out.println("Would you like to play another round?");
				System.out.print("Yes or No >> ");
				userInput = sc.next().toUpperCase();

				// if user did not enter a proper input print out
				if (!newRoundCheck.contains(userInput)) {
					System.out.println("Please make a proper selection");
				}
			} while (!newRoundCheck.contains(userInput));

		} while (newRoundSelection.contains(userInput));
	}

	// end of round operations
	private void endOfRound() {
		// print all house cards
		System.out.println("\nHouse Cards:");
		for (int i = 0; i < houseHand.getCards().size(); i++) {
			System.out.println(houseHand.getCards().get(i));
		}

		// print out all user cards
		System.out.println("\n" + name + "'s Cards:");
		for (int i = 0; i < playerHand.getCards().size(); i++) {
			System.out.println(playerHand.getCards().get(i));
		}

		// determines winner
		if (houseHand.getHandValue() > 21) {
			System.out.println(
					"\nHouse is BUST and went over 21 with a hand of " + houseHand.getHandValue() + ". You WIN!!!\n");
		} else if (houseHand.getHandValue() > playerHand.getHandValue()) {
			System.out.println("House wins this round with a hand of " + houseHand.getHandValue()
					+ " compared to your hand of " + playerHand.getHandValue() + "\n");
		} else if (houseHand.getHandValue() == playerHand.getHandValue()) {
			System.out.println("This round ends in a tie with hand values of " + houseHand.getHandValue() + "\n");
		} else if (houseHand.getHandValue() < playerHand.getHandValue() && playerHand.getHandValue() <= 21) {
			System.out.println("You win this round with a hand of " + playerHand.getHandValue()
					+ " compared to the house hand of " + houseHand.getHandValue() + "\n");
		}
	}

	// method checks to make sure deck size is large enough for a new round
	private void checkDeckSize() {
		if (deck.checkDeckSize() < 13) {
			deck = new Deck();
			deck.shuffle();
		}
	}

	// starts a new round
	private void newRound() {
		playerHand.clearHand();
		houseHand.clearHand();

		// call method to check deck size
		checkDeckSize();

		// add cards to user and house
		for (int i = 0; i < 2; i++) {
			addPlayerCard();
			addHouseCard();
		}
	}

	// add cards if player player opts for a hit or add cards if house is less than
	// 17
	private void deal(boolean selection) {
		if (selection == true) {
			addPlayerCard();
		} else {
			addHouseCard();
		}
	}

	// add card to user
	private void addPlayerCard() {
		Card playerCard = deck.dealCard();
		playerHand.blackjackCards(playerCard);
		playerHand.setHandValue(playerCard.getValue());
	}

	// add card to house
	private void addHouseCard() {
		Card houseCard = deck.dealCard();
		houseHand.houseCards(houseCard);
		houseHand.setHandValue(houseCard.getValue());
	}

	// prints cards for user and house except for house's first card
	private void showHands() {
		System.out.println("\nHouse Cards:");
		System.out.println("Mystery Card ???");
		for (int i = 1; i < houseHand.getCards().size(); i++) {
			System.out.println(houseHand.getCards().get(i));
		}
		System.out.println("House hand value is: " + houseHand.getCards().get(1).getValue());

		System.out.println("\n" + name + "'s Cards:");
		for (int i = 0; i < playerHand.getCards().size(); i++) {
			System.out.println(playerHand.getCards().get(i));
		}
		System.out.println(name + "'s hand value is: " + playerHand.getHandValue());
	}
}
