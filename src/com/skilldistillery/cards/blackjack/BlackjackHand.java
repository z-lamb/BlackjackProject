package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	
	private List<Card> cardsInHandList= new ArrayList<>();
	private int totalHandValue = 0;
	
	public BlackjackHand() {
	}
	
	public void blackjackCards(Card cardDealtToPerson) {
		
		cardsInHandList.add(cardDealtToPerson);
	}
	
	@Override
	public List<Card> getCards() {
		return cardsInHandList;
	}
	
	public void setHandValue(int cardValue) {
		totalHandValue = totalHandValue + cardValue;
	}
	public int getHandValue() {
		return this.totalHandValue;
	}
	
}
