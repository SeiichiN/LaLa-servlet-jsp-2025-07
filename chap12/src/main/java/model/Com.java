package model;

public class Com extends Player {
	public Com() {
		this("コム");
	}
	public Com(String name) {
		this.setName(name);
	}
	public void setRandomHand() {
		int num = (int)(Math.random() * 3);
		this.setHand(num);
	}
}
