package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class GameMenu {

	private String name, userInput;
	private GameOperator gameOperator = new GameOperator();
	private Scanner scanner = new Scanner(System.in);
	
	public void menuOptions() {

		// has the user enter their name
		System.out.println("Welcome to the game of Blackjack");
		System.out.print("Please enter your name >> ");
		name = scanner.nextLine();

		// prints menu and stores it to determine the option
		userInput = menu(scanner);

		while (!userInput.equals("3")) {
			switch (userInput) {
			case "1":
				displayRules();
				break;
			case "2":
				gameOperator.playGame(scanner, name);
				break;
			case "3":
				System.out.println("Thank you " + name + " for playing Blackjack");
				System.out.println("Goodbye");
				return;
			default:
				System.out.println("\nMake a selection by choosing 1, 2, or 3\n");
			}
			userInput = menu(scanner);
		}
		scanner.close();
	}

	// prints the menu for the user to choose from
	private String menu(Scanner scanner) {

		System.out.println("\nPlease make a selection");
		System.out.println("1. Would you like to see how the game works?");
		System.out.println("2. Would you like to start a new game?");
		System.out.println("3. Quit");
		System.out.print(">> ");

		String userInput = scanner.next();
		return userInput;
	}

	// displays the rules of the game
	private void displayRules() {

		System.out.println();
		System.out.println("Blackjack Rules:");
		System.out.println(" - The goal of the game is to get as close to 21 without going over and also beating the house hand");
		System.out.println(" - If your hand and the house hand are the same you end in a tie");
		System.out.println(" - If your hand is greater than the house hand and you are not over 21 your win");
		System.out.println(" - If your hand is exactly 21 at the beginning of the round and the house hand is not 21 you win");
		System.out.println(" - If your hand is less than the house hand and you are under 21 you lose");
		System.out.println(" - If your hand at any point goes over 21 you immediately lose");
		System.out.println();
		
		System.out.println("Game Operation:");
		System.out.println(" - At the beginning of a new round you will be dealt a card face up and the dealer will be dealt a card face down");
		System.out.println(" - You will both be dealt a card face up");
		System.out.println(" - If you would like another card to get closer to 21 you can say hit and the dealer will give you another care");
		System.out.println(" - You can hit as many times as you would like until you tell the dealer you would like to stay");
		System.out.println(" - The dealer will then hit as many times as they need to until they reach at least 17 and then they will stay");
		System.out.println(" - At this point you will check to see who has a greater score to see who won");
		System.out.println(" - Then you can play another round or end the game");
		
		System.out.println();
		System.out.println("Card Values:");
		System.out.println("Card\tValue");
		System.out.println(" 2 \t  2");
		System.out.println(" 3 \t  3");
		System.out.println(" 4 \t  4");
		System.out.println(" 5 \t  5");
		System.out.println(" 6 \t  6");
		System.out.println(" 7 \t  7");
		System.out.println(" 8 \t  8");
		System.out.println(" 9 \t  9");
		System.out.println(" 10\t  10");
		System.out.println(" J \t  10");
		System.out.println(" Q \t  10");
		System.out.println(" K \t  10");
		System.out.println(" A \t  11");
	}
}
