package model;

public class User extends Player {
	private String result;
	private final String[] HAND_IMG = {
			"<img src=\"img/gu.png\" alt=\"グー\">",
			"<img src=\"img/choki.png\" alt=\"チョキ\">",
			"<img src=\"img/pa.png\" alt=\"パー\">"
	};

	public User() {
		this("ユーザー");
	}
	public User(String name) {
		this.setName(name);
	}

	public void judge(Player other) {
		recordHand(other);
		if (this.getHand() == other.getHand()) {
			this.result += "あいこです";
		} else if ((this.getHand() + 1) % 3 == other.getHand()) {
			this.result += this.getName() + "の勝ちです";
		} else {
			this.result += this.getName() + "の負けです";
		}
	}
	public void recordHand(Player other) {
		this.result = this.getName() + HAND_IMG[this.getHand()];
		this.result += other.getName() + HAND_IMG[other.getHand()];
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	

}
