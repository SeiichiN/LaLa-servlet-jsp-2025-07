package model;

public class GameManager {
	private String result;
	
	public void judge(Player p1, Player p2) {
		if (p1.getHand() == p2.getHand()) {
			result = "あいこです";
		} else if ((p1.getHand() + 1) % 3 == p2.getHand()) {
			result = p1.getName() + "の勝ちです";
		} else {
			result = p1.getName() + "の負けです";
		}
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
