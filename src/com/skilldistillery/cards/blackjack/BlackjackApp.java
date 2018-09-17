package com.skilldistillery.cards.blackjack;

public class BlackjackApp {

	public static void main(String[] args) {

		BlackjackApp blackjack = new BlackjackApp();
		
		blackjack.launch();
		
	}
	// launch method that calls the Game Menu options
	private void launch() {
		
		GameMenu gameMenu = new GameMenu();
		gameMenu.menuOptions();
		
	}
}
