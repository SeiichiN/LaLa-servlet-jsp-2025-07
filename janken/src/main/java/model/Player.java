package model;

public abstract class Player {
	private String name;
	private int hand;
	private String result;
	private String[] HAND_IMG;
	
	public Player() {
		HAND_IMG = new String[] {
				"<img src=\"img/gu.png\" alt=\"グー\">",
				"<img src=\"img/choki.png\" alt=\"チョキ\">",
				"<img src=\"img/pa.png\" alt=\"パー\">"
		};
	}
	public void judge(Player p) {
		if (this.hand == p.getHand()) {
			this.result = "あいこです";
		} else if ((this.hand + 1) % 3 == p.getHand()) {
			this.result = this.name + "の勝ちです";
		} else {
			this.result = this.name + "の負けです";
		}
	}
	public String showImg() {
		return this.name +  HAND_IMG[this.hand];
	}
	public String getName() {
		return name;
	}
	public int getHand() {
		return hand;
	}
	public String getResult() {
		return result;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setHand(int hand) {
		this.hand = hand;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
