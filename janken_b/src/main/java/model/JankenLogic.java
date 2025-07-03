package model;

public class JankenLogic {
	public String execute(Player p1, Player p2) {
		GameManager manager = new GameManager();
		manager.judge(p1, p2);
		return manager.getResult();
	}
}
