package de.blackengineers.blackjack;

import java.util.Iterator;

public class Dealer extends Participant {

	@Override
	public int getHandValue() {
		// TODO Auto-generated method stub
		Card currentCard;
		int handValue = 0;

		// Zaehle die Werte der Nicht-Asse
		Iterator<Card> it = this.getHand().iterator();
		while (it.hasNext()) {
			currentCard = it.next();
			if (!"Ace".equals(currentCard.getName())) {
				handValue += currentCard.getValue();
			}
		}

		// Bewerte die Werte der Asse
		it = this.getHand().iterator();
		while (it.hasNext()) {
			currentCard = it.next();
			if ("Ace".equals(currentCard.getName()) && handValue + 11 >= 17 && handValue + 11 <= 21) {
				handValue += 11;
			} else if ("Ace".equals(currentCard.getName())) {
				handValue += 1;
			}
		}

		return handValue;
	}

	@Override
	public void takeFirstTwoCards (Deck deck) {

		// zieht erste Karte
		this.addCardToHand(deck.getCard());
		
		System.out.println("Die erste Karte des Dealers:");
		this.showCards();

		// zieht zweite Karte
		this.addCardToHand(deck.getCard());

	}

	@Override
	public void finalizeRound(Deck deck) {

		while (this.getHandValue() < 17) {
			this.addCardToHand(deck.getCard());
		}
		
		System.out.println("Abschließendes Blatt des Dealers:");
		this.showCards();

	}

}
