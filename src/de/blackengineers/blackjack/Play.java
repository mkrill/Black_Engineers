package de.blackengineers.blackjack;

import java.util.Scanner;

public class Play {

	private Player thePlayer;
	private Dealer theDealer;
	private Deck myDeck;
	
	static public Scanner ourScanner = new Scanner(System.in);
	
	// privater Kontruktor
	private Play() {
		this.thePlayer = new Player();
		this.theDealer = new Dealer();
		
	}
	
	public static void main(String[] args) {
		new Play().play();
	}

	
	
	private void play() {
		String eingabe;
		// Schleife 1 Spiel spielen, bis "leave"
		boolean wantsToPlay = true;
		do {

			// initialisiere Kartenspiel
			myDeck = new Deck();
			thePlayer.clearHand();
			theDealer.clearHand();
			
			// Spieler erhalten die ersten beiden Karten
			thePlayer.takeFirstTwoCards(myDeck);
			theDealer.takeFirstTwoCards(myDeck);
			
			thePlayer.finalizeRound(myDeck);
			
			int resultPlayer = thePlayer.getHandValue();
			// int resultPlayer = thePlayer.playRound(myDeck); //Alternative Participant.playRound() liefert direkt den Kartenwert zurück

			// nur wenn Spieler <= 21 hat, spielt der Dealer

			if (resultPlayer <= 21) {
				theDealer.finalizeRound(myDeck);
				int resultDealer = theDealer.getHandValue();
				//int resultDealer = theDealer.playRound(myDeck); //Alternative, siehe oben
				
				
				if (resultDealer > 21) {
					System.out.println("Der Dealer hat über 21. Glückwunsch - Du hast gewonnen!");
				} else if (resultDealer == resultPlayer){
					System.out.println("Gleichstand! Keiner hat gewonnen!");
				} else if (resultDealer > resultPlayer) {
					System.out.println("Dealer hat mehr. Du hast leider verloren.");
				} else {
					System.out.println("Du hast mehr. Glückwunsch - Du hast gewonnen!");
				}
			} else {
				System.out.println("Du hast über 21. Du hast leider verloren.");
			}
			
			

			// Abfrage weiter spielen?
			System.out.println("Möchtest Du ein neues Spiel spielen? (j/n) ");
			eingabe = ourScanner.next();
			wantsToPlay=eingabe.equalsIgnoreCase("j");
			if (wantsToPlay) {
				System.out.println("\n\n\n");
			}
		}
		while (wantsToPlay);
			
		System.out.println("Es war mir eine große Freude! Auf Wiedersehen!");
		
		ourScanner.close();


	}


}
