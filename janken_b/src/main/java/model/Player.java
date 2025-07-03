package model;

import java.io.Serializable;

public abstract class Player implements Serializable {
	private int hand;
	private String name;
	private String[] handImage = {
		"<img src=\"img/gu.png\" alt=\"グー\">",	
		"<img src=\"img/choki.png\" alt=\"チョキ\">",	
		"<img src=\"img/pa.png\" alt=\"パー\">"	
	};
	
	public Player() {}
	public Player(String name) {
		this.name = name;
	}
	
	public String showHand() {
		return this.name + handImage[hand];
	}
	
	public int getHand() {
		return hand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
