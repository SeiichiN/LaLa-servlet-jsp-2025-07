package model;

public class Com extends Player {

	public Com(String name) {
		super(name);
		setRandomHand();
	}
	public Com() {
		this("コム");
	}

	public void setRandomHand() {
		int num = (int)(Math.random() * 3);
		setHand(num);
	}
}
