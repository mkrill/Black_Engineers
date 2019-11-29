package de.blackengineers.blackjack;

public class Player extends Participant {

	@Override
	public void takeFirstTwoCards(Deck deck) {

		// zieht zwei Karten
		this.addCardToHand(deck.getCard());
		this.addCardToHand(deck.getCard());

		// Aufdecken der Spielerkarten
		System.out.println("Deine ersten beiden Karten: ");
		this.showCards();

	}

	// Ask Player, if she ants another Card
	private boolean playerWantsAnotherCard() {

		String eingabe;

		System.out.println("Möchtest du noch eine Karte (j/n)?");
		eingabe = Play.ourScanner.next();

		return ("j".equals(eingabe)) ? true : false;
	}

	@Override
	public void finalizeRound(Deck deck) {

		boolean anotherCardWanted = false;

		// Abfrage, ob eine Karte gezogen werden soll, sofern der Blattwert unter 21
		// liegt
		if (this.getHandValue() < 21) {
			anotherCardWanted = this.playerWantsAnotherCard();
		}

		// solange weitere Karte gewünscht ist und Blattwert unter 21 liegt
		while (anotherCardWanted && this.getHandValue() < 21) {

			// Ziehen einer weiteren Karte und Anzeige des Blattes
			this.addCardToHand(deck.getCard());
			this.showCards();

			// Abfrage, ob eine Karte gezogen werden soll, sofern der Blattwert unter 21
			// liegt
			if (this.getHandValue() < 21) {
				anotherCardWanted = this.playerWantsAnotherCard();
			}

		}

		System.out.println("Dein abschließendes Blatt:");
		this.showCards();

	}

}
