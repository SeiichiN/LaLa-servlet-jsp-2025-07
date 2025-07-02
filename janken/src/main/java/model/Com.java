package model;

public class Com extends Player {
	public Com() {
		setHand();
	}
	public void setHand() {
		int num = (int)(Math.random() * 3);
		this.setHand(num);
	}
}
