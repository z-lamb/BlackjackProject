package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class HouseHand extends Hand {

	public HouseHand() {

	}
	
	public void houseCards(Card cardDealtToHouse) {
		List<Card> cardsInHandList = new ArrayList<>();
		
		cardsInHandList.add(cardDealtToHouse);
		System.out.println(cardsInHandList);
	}
	
	public int getHandValue() {
		
		return 0;
	}
}
