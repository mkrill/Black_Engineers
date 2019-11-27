package de.blackengineers.blackjack;

import java.util.Scanner;

public class Play {

	private Player thePlayer;
	private Dealer theDealer;
	private Deck myDeck;
	
	// privater Kontruktor
	private Play() {
		this.thePlayer = new Player();
		this.theDealer = new Dealer();
	}
	
	public static void main(String[] args) {
		new Play().play();
		//main(args);
	}

	
	
	private void play() {
		// Schleife 1 Spiel spielen, bis "leave"
		boolean wantsToPlay = true;
		do {

			// initialisiere Kartenspiel
			myDeck = new Deck();
		
			
			// Spieler spielt
			thePlayer.playRound(myDeck);
			int resultPlayer = thePlayer.getHandValue();
			// int resultPlayer = thePlayer.playRound(myDeck); //Alternative Participant.playRound() liefert direkt den Kartenwert zurück

			// nur wenn Spieler <= 21 hat, spielt der Dealer
			if (resultPlayer <= 21) {
				theDealer.playRound(myDeck);
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
			Scanner sc = new Scanner(System.in);
			String eingabe = sc.nextLine();
			sc.close();
			wantsToPlay=eingabe.equalsIgnoreCase("j");
		}
		while (!wantsToPlay);
			
		System.out.println("Es war mir eine große Freude! Auf Wiedersehen!");


	}


}
