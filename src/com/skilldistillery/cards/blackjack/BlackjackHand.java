package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	public BlackjackHand() {

	}
	
	public void blackjackCards(Card cardDealtToPerson) {
		List<Card> cardsInHandList = new ArrayList<>();
		
		cardsInHandList.add(cardDealtToPerson);
		System.out.println(cardsInHandList);
	}
	
	public int getHandValue() {
		
		return 0;
	}
	
}
