package de.blackengineers.blackjack;

import java.util.Iterator;
import java.util.Scanner;

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

		// Bewerte die Werte der Asse
		it = this.getHand().iterator();
		while (it.hasNext()) {
			currentCard = it.next();
			if ("Ace".equals(currentCard.getName()) && handValue + 11 <= 21) {
				handValue += 1;
			} else if ("Ace".equals(currentCard.getName())) {
				handValue += 11;
			}
		}
		return handValue;

	}

	@Override
	public void playRound(Deck deck) {

		boolean stopTakingCards = false;
		String eingabe = "";

		// zieht zwei Karten
		this.addCardToHand(deck.getCard());

		do {
			
			this.addCardToHand(deck.getCard());
			this.showCards();

			// Wenn noch nicht verloren
			if (this.getHandValue() < 21) {
				System.out.println("Möchtest du aufhören (j/n)?");
				eingabe = Play.ourScanner.next();
				stopTakingCards = ("j".equals(eingabe)) ? true : false;
			}
		
		} while (!stopTakingCards && this.getHandValue() < 21);
		
		System.out.println("Dein abschließendes Blatt:");
		this.showCards();


	}

}
