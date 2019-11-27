package de.blackengineers.blackjack;

public abstract class Card {

	// attributes
	private String color;
	private String name;
	private int value;
	
	// constructor
	public Card(String color, String name, int value) {
		super();
		this.color = color;
		this.name = name;
		this.value = value;
	}

	// setter & getters
	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	
}
