package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class HouseHand extends Hand {

	private List<Card> cardsInHandList;
	
	public HouseHand() {

	}
	
	public void houseCards(Card cardDealtToHouse) {
		cardsInHandList = new ArrayList<>();
		
		cardsInHandList.add(cardDealtToHouse);
	}
	
	
	
	@Override
	public List<Card> getCards() {
		return cardsInHandList;
	}

	public int getHandValue() {
		
		return 0;
	}
}
