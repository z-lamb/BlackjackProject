package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;
	private Card card;

	public Deck() {

		deck = new ArrayList<>();
				
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				card = new Card(suit, rank);
				deck.add(card);

			}
		}

	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}

}
