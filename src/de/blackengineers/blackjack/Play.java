package de.blackengineers.blackjack;

import java.util.Scanner;

public class Play {

	private Player thePlayer;
	private Dealer theDealer;
	private Deck myDeck;

	
	// initialisiere einen statischen Scanner
	static public Scanner ourScanner = new Scanner(System.in);

	
	// privater Kontruktor, um eine Play-Klasse zu instanziieren
	private Play() {
		this.thePlayer = new Player();
		this.theDealer = new Dealer();
	}

	
	// main-Methode instanziiert Play() und ruft play() auf
	public static void main(String[] args) {
		new Play().play();
	}
	
	
	private void play() {
		String eingabe;
		System.out.println("\n*** Los geht's!! ***\n");

		//solange spielen bis der Spieler kein (j/J) eingibt
		boolean wantsToPlay = true;
		do {

			// initialisiere Kartenspiel
			myDeck = new Deck();
			thePlayer.clearHand();
			theDealer.clearHand();
			
			// Spieler erhalten die ersten beiden Karten
			thePlayer.takeFirstTwoCards(myDeck);
			theDealer.takeFirstTwoCards(myDeck);
			
			// Spieler spielt zu Ende
			thePlayer.finalizeRound(myDeck);
			int resultPlayer = thePlayer.getHandValue();

			// nur wenn Spieler <= 21 hat, spielt der Dealer
			if (resultPlayer <= 21) {
				theDealer.finalizeRound(myDeck);
				int resultDealer = theDealer.getHandValue();
				
				
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
			
			

			// Abfrage weiterspielen?
			System.out.println("\nMöchtest Du ein neues Spiel spielen? (j/n) ");
			eingabe = ourScanner.next();
			wantsToPlay=eingabe.equalsIgnoreCase("j");
			if (wantsToPlay) {
				System.out.println("\n*** Neues Spiel, neues Glück!! ***\n");
			}
		}
		while (wantsToPlay);
			
		System.out.println("\n*** Es war mir eine große Freude! Auf Wiedersehen! ***");
		
		ourScanner.close();
	}


}
