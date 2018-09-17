package com.skilldistillery.cards.common;

import java.util.List;

public abstract class Hand {
	
	public Hand() {
	}
	
	public int getHandValue() {
		return 0;
	}
	
	public void addCard(Card c) {
	}
	
	public void clearHand() {
	}
	
	public List<Card> getCards(){
		return null ;
	}

	@Override
	public String toString() {
		return "Hand [toString()=" + super.toString() + "]";
	}
}
