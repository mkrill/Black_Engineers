package de.blackengineers.blackjack;

import java.util.*;


public class Deck {
	
		private ArrayList<Card> newCards = new ArrayList<>();

	public Deck() {
		super();

		Card diamonds2  = new Card("\u2662 ", Integer.toString(2),  2);
		Card diamonds3  = new Card("\u2662 ", Integer.toString(3),  3);
		Card diamonds4  = new Card("\u2662 ", Integer.toString(4),  4);
		Card diamonds5  = new Card("\u2662 ", Integer.toString(5),  5);
		Card diamonds6  = new Card("\u2662 ", Integer.toString(6),  6);
		Card diamonds7  = new Card("\u2662 ", Integer.toString(7),  7);
		Card diamonds8  = new Card("\u2662 ", Integer.toString(8),  8);
		Card diamonds9  = new Card("\u2662 ", Integer.toString(9),  9);
		Card diamonds10 = new Card("\u2662 ", Integer.toString(10), 10);
		Card diamondsB  = new Card("\u2662 ", String.valueOf('B'),  10);
		Card diamondsD  = new Card("\u2662 ", String.valueOf('D'),  10);
		Card diamondsK  = new Card("\u2662 ", String.valueOf('K'),  10);
		Card diamondsA  = new Card("\u2662 ", "Ace",  11);
		newCards.add(diamonds2);
		newCards.add(diamonds3);
		newCards.add(diamonds4);
		newCards.add(diamonds5);
		newCards.add(diamonds6);
		newCards.add(diamonds7);
		newCards.add(diamonds8);
		newCards.add(diamonds9);
		newCards.add(diamonds10);
		newCards.add(diamondsB);
		newCards.add(diamondsD);
		newCards.add(diamondsK);
		newCards.add(diamondsA);

		Card hearts2  = new Card("\u2661", Integer.toString(2),  2);
		Card hearts3  = new Card("\u2661", Integer.toString(3),  3);
		Card hearts4  = new Card("\u2661", Integer.toString(4),  4);
		Card hearts5  = new Card("\u2661", Integer.toString(5),  5);
		Card hearts6  = new Card("\u2661", Integer.toString(6),  6);
		Card hearts7  = new Card("\u2661", Integer.toString(7),  7);
		Card hearts8  = new Card("\u2661", Integer.toString(8),  8);
		Card hearts9  = new Card("\u2661", Integer.toString(9),  9);
		Card hearts10 = new Card("\u2661", Integer.toString(10), 10);
		Card heartsB  = new Card("\u2661", String.valueOf('B'),  10);
		Card heartsD  = new Card("\u2661", String.valueOf('D'),  10);
		Card heartsK  = new Card("\u2661", String.valueOf('K'),  10);
		Card heartsA  = new Card("\u2661", "Ace",  11);
		newCards.add(hearts2);
		newCards.add(hearts3);
		newCards.add(hearts4);
		newCards.add(hearts5);
		newCards.add(hearts6);
		newCards.add(hearts7);
		newCards.add(hearts8);
		newCards.add(hearts9);
		newCards.add(hearts10);
		newCards.add(heartsB);
		newCards.add(heartsD);
		newCards.add(heartsK);
		newCards.add(heartsA);
		
		Card spades2  = new Card("\u2660", Integer.toString(2),  2);
		Card spades3  = new Card("\u2660", Integer.toString(3),  3);
		Card spades4  = new Card("\u2660", Integer.toString(4),  4);
		Card spades5  = new Card("\u2660", Integer.toString(5),  5);
		Card spades6  = new Card("\u2660", Integer.toString(6),  6);
		Card spades7  = new Card("\u2660", Integer.toString(7),  7);
		Card spades8  = new Card("\u2660", Integer.toString(8),  8);
		Card spades9  = new Card("\u2660", Integer.toString(9),  9);
		Card spades10 = new Card("\u2660", Integer.toString(10), 10);
		Card spadesB  = new Card("\u2660", String.valueOf('B'),  10);
		Card spadesD  = new Card("\u2660", String.valueOf('D'),  10);
		Card spadesK  = new Card("\u2660", String.valueOf('K'),  10);
		Card spadesA  = new Card("\u2660", "Ace",  11);
		newCards.add(spades2);
		newCards.add(spades3);
		newCards.add(spades4);
		newCards.add(spades5);
		newCards.add(spades6);
		newCards.add(spades7);
		newCards.add(spades8);
		newCards.add(spades9);
		newCards.add(spades10);
		newCards.add(spadesB);
		newCards.add(spadesD);
		newCards.add(spadesK);
		newCards.add(spadesA);

		Card clubs2  = new Card("\u2663", Integer.toString(2),  2);
		Card clubs3  = new Card("\u2663", Integer.toString(3),  3);
		Card clubs4  = new Card("\u2663", Integer.toString(4),  4);
		Card clubs5  = new Card("\u2663", Integer.toString(5),  5);
		Card clubs6  = new Card("\u2663", Integer.toString(6),  6);
		Card clubs7  = new Card("\u2663", Integer.toString(7),  7);
		Card clubs8  = new Card("\u2663", Integer.toString(8),  8);
		Card clubs9  = new Card("\u2663", Integer.toString(9),  9);
		Card clubs10 = new Card("\u2663", Integer.toString(10), 10);
		Card clubsB  = new Card("\u2663", String.valueOf('B'),  10);
		Card clubsD  = new Card("\u2663", String.valueOf('D'),  10);
		Card clubsK  = new Card("\u2663", String.valueOf('K'),  10);
		Card clubsA  = new Card("\u2663", "Ace",  11);
		newCards.add(clubs2);
		newCards.add(clubs3);
		newCards.add(clubs4);
		newCards.add(clubs5);
		newCards.add(clubs6);
		newCards.add(clubs7);
		newCards.add(clubs8);
		newCards.add(clubs9);
		newCards.add(clubs10);
		newCards.add(clubsB);
		newCards.add(clubsD);
		newCards.add(clubsK);
		newCards.add(clubsA);

		/*
		 * for (Card card : newCards) { System.out.printf("%3s %8s \n", card.getName(),
		 * card.getColor()); }
		 */		
		Collections.shuffle(newCards);
		Collections.shuffle(newCards);

		/*
		 * for (Card card : newCards) { System.out.printf("%3s %8s \n", card.getName(),
		 * card.getColor()); }
		 */		
		
	}
	
	public Card getCard() {
		Card retCard = newCards.get(0);
		newCards.remove(0);
		return retCard;
	}
}
