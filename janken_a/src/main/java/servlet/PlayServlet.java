package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
<<<<<<< HEAD:janken_a/src/main/java/servlet/PlayServlet.java
import model.Com;
import model.JankenLogic;
=======

import model.Com;
import model.GameManager;
>>>>>>> main:janken/src/main/java/servlet/PlayServlet.java
import model.User;

@WebServlet("/play")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/jsp/janken.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userHand = Integer.parseInt(request.getParameter("hand"));
<<<<<<< HEAD:janken_a/src/main/java/servlet/PlayServlet.java
		User user = new User("ユーザー");
		user.setHand(userHand);
		Com com = new Com("コム");
		com.setRandomHand();
		
		JankenLogic jankenLogic = new JankenLogic();
		jankenLogic.execute(user, com);
		
		request.setAttribute("user", user);
		request.setAttribute("com", com);
=======
		User user = new User();
		user.setHand(userHand);
		Com com = new Com();
		com.setRandomHand();
		
		GameManager manager = new GameManager();
		manager.judge(user, com);
		request.setAttribute("manager", manager);
		
>>>>>>> main:janken/src/main/java/servlet/PlayServlet.java
		String path = "WEB-INF/jsp/result.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
