package de.blackengineers.blackjack;

import java.util.*;


public class Deck {

	ArrayList<Card> newCards = new ArrayList<>();
	
	Card diamonds2 = new Card ("Diamonds", Integer.toString(2), 2);
	Card diamonds3 = new Card ("Diamonds", Integer.toString(3), 3);
	Card diamonds4 = new Card ("Diamonds", Integer.toString(4), 4);
	Card diamonds5 = new Card ("Diamonds", Integer.toString(5), 5);
	Card diamonds6 = new Card ("Diamonds", Integer.toString(6), 6);
	Card diamonds7 = new Card ("Diamonds", Integer.toString(7), 7);
	Card diamonds8 = new Card ("Diamonds", Integer.toString(8), 8);
	Card diamonds9 = new Card ("Diamonds", Integer.toString(9), 9);
	Card diamonds10 = new Card ("Diamonds", Integer.toString(10), 10);
	Card diamondsB = new Card ("Diamonds", String.valueOf('B'), 10);
	Card diamondsD = new Card ("Diamonds", String.valueOf('D'), 10);
	Card diamondsK = new Card ("Diamonds", String.valueOf('K'), 10);
	Card diamondsA = new Card ("Diamonds", String.valueOf('A'), 11);
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

}
