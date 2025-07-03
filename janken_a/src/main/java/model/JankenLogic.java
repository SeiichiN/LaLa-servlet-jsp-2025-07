package model;

public class JankenLogic {
	
	public void execute(User user, Com com) {
		user.judge(com);
	}
}
