package de.blackengineers.blackjack;

public class Dealer extends Participant {

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
