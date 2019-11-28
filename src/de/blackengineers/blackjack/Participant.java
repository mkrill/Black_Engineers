package de.blackengineers.blackjack;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Participant {

	// Attribute der Klasse Participant
	private ArrayList<Card> hand;

	// Construktor
	public Participant() {
		super();
		this.hand = new ArrayList<Card>();
	}

	// Methoden der Klasse Participant mit fachlicher Logik

	// die übergebene Karte c wird in das Blatt übernommen
	public void addCardToHand(Card c) {
		if (c != null) {
			this.getHand().add(c);
		}
	}

	// notwendige Getter und Setter Methoden
	public ArrayList<Card> getHand() {
		return hand;
	}

	// Bewertet den aktuellen Wert des Blattes unterschiedlich implementiert für
	// Spieler und Dealer
	public abstract int getHandValue();

	// Ziehen der ersten beiden Karten unterschiedlich für Spieler und Dealer
	public abstract void takeFirstTwoCards(Deck deck);

	// Ziehen aller weiteren Karten der Spielrunde unterschiedlich für Spieler und
	// Dealer
	public abstract void finalizeRound(Deck deck);

	// Feststellung, ob Participant noch im Spiel ist
	public boolean isStillInGame() {

		if (this.getHandValue() <= 21) {
			return true;
		} else {
			return false;
		}
	}

	// Ausgabe des aktuellen Blattes in Name und Farbe sowie des Blattwertes
	public void showCards() {

		Iterator<Card> it = hand.iterator();
		Card currentCard;

		while (it.hasNext()) {
			currentCard = it.next();
			System.out.println("Kartenname: " + currentCard.getName() + ", Farbe: " + currentCard.getColor());
		}

		System.out.println("Wert des Blatts: " + this.getHandValue());
		System.out.println();
	}

	// Leeren des Blattes in Vorbereitung eines neuen Spiels
	public void clearHand() {
		this.getHand().clear();
	}

}
