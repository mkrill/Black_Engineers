package de.blackengineers.blackjack;

import java.util.Iterator;

public class Player extends Participant {

	@Override
	public int getHandValue() {

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

		// Bewertet die Asse
		for (Card cCard : this.getHand()) {
			if ("Ace".equals(cCard.getName()) && handValue + 11 <= 21) {
				handValue += 11;
			} else if ("Ace".equals(cCard.getName())) {
				handValue += 1;
			}
		}
		return handValue;

	}

	@Override
	public void takeFirstTwoCards(Deck deck) {

		// zieht zwei Karten
		this.addCardToHand(deck.getCard());
		this.addCardToHand(deck.getCard());

		// Aufdecken der Spielerkarten
		System.out.println("Deine ersten beiden Karten: ");
		this.showCards();

	}

	@Override
	public void finalizeRound(Deck deck) {

		boolean anotherCardWanted = false;
		String eingabe = "";

		// Abfrage, ob eine Karte gezogen werden soll, sofern der Blattwert unter 21
		// liegt
		if (this.getHandValue() < 21) {
			System.out.println("Möchtest du noch eine Karte (j/n)?");
			eingabe = Play.ourScanner.next();
			anotherCardWanted = ("j".equals(eingabe)) ? true : false;
		}

		// solange weitere Karte gewünscht ist und Blattwert unter 21 liegt
		while (anotherCardWanted && this.getHandValue() < 21) {

			// Ziehen einer weiteren Karte und Anzeige des Blattes
			this.addCardToHand(deck.getCard());
			this.showCards();

			// Abfrage, ob eine Karte gezogen werden soll, sofern der Blattwert unter 21
			// liegt
			if (this.getHandValue() < 21) {
				System.out.println("Möchtest du noch eine Karte (j/n)?");
				eingabe = Play.ourScanner.next();
				anotherCardWanted = ("j".equals(eingabe)) ? true : false;
			}

		}

		System.out.println("Dein abschließendes Blatt:");
		this.showCards();

	}

}
