package de.blackengineers.blackjack;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Participant {

	public Participant() {
		super();
		this.hand = new ArrayList<Card>();
	}

	private ArrayList<Card> hand;

	public void addCardToHand(Card c)  {
		if (c!= null)  {
			this.getHand().add(c);
		}
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}

	public abstract int getHandValue();
		// Bewertet den aktuellen Wert des Blattes

	public abstract void playRound(Deck deck);
	// Feststellung, ob Participant noch im Spiel

	public boolean isStillInGame() {

		if (this.getHandValue() <= 21) {
			return true;
		} else {
			return false;
		}
	}

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
	
	public void clearHand() {
		this.getHand().clear();
	}

}
