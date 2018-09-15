package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	
	private List<Card> cardsInHandList;
	
	public BlackjackHand() {
	}
	
	public void blackjackCards(Card cardDealtToPerson) {
		cardsInHandList = new ArrayList<>();
		
		cardsInHandList.add(cardDealtToPerson);
	}
	
	@Override
	public List<Card> getCards() {
		return cardsInHandList;
	}
	
	public int getHandValue() {
		
		return 0;
	}
	
}
