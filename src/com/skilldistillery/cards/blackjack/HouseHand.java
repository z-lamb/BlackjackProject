package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class HouseHand extends Hand {

	private List<Card> cardsInHandList = new ArrayList<>();
	private int totalHandValue = 0;
	
	public HouseHand() {

	}
	
	public void houseCards(Card cardDealtToHouse) {
			cardsInHandList.add(cardDealtToHouse);
	}
	
	
	
	@Override
	public List<Card> getCards() {
		return cardsInHandList;
	}

	public void setHandValue(int cardValue) {
		totalHandValue = totalHandValue + cardValue;
	}
	public int getHandValue() {
		int getHandValue = totalHandValue;
		return getHandValue;
	}
}
