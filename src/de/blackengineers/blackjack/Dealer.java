package de.blackengineers.blackjack;

import java.util.Iterator;

public class Dealer extends Participant {

	@Override
	public int getHandValue() {
		Card currentCard;
		int handValue = 0;

		// Summiere die Werte der Karten ausser den Assen auf
		Iterator<Card> it = this.getHand().iterator();
		while (it.hasNext()) {
			currentCard = it.next();
			if (!"Ace".equals(currentCard.getName())) {
				handValue += currentCard.getValue();
			}
		}

		// Bewerte die Asse
		for (Card cCard : this.getHand()) {

			if ("Ace".equals(cCard.getName()) && handValue + 11 >= 17 && handValue + 11 <= 21) {
				// Dealer-spezifisch: "handValue + 11 >= 17" => Ass zählt 11 bei Blattwert >= 17
				handValue += 11;
			} else if ("Ace".equals(cCard.getName())) {
				handValue += 1;
			}
		}

		return handValue;
	}

	@Override
	public void takeFirstTwoCards(Deck deck) {

		// zieht erste Karte
		this.addCardToHand(deck.getCard());

		// Aufdecken der ersten Karte des Dealers
		System.out.println("Die erste Karte des Dealers:");
		this.showCards();

		// zieht zweite Karte verdeckt
		this.addCardToHand(deck.getCard());

	}

	@Override
	public void finalizeRound(Deck deck) {

		// Dealer zieht Karten, solange der Blattwert unter 17 ist
		while (this.getHandValue() < 17) {
			this.addCardToHand(deck.getCard());
		}

		// Ausgabe des abschließenden Dealer-Blatts
		System.out.println("Abschließendes Blatt des Dealers:");
		this.showCards();

	}

}
