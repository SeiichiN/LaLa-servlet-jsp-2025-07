package model;

public abstract class Player {
	private String name;
	private int hand;
	
	public Player() {}
	
	public String getName() {
		return name;
	}
	public int getHand() {
		return hand;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHand(int hand) {
		this.hand = hand;
	}
}
