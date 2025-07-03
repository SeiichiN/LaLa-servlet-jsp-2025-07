package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Com;
import model.JankenLogic;
import model.User;

@WebServlet("/play")
public class PlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "WEB-INF/jsp/janken.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userHand = Integer.parseInt(request.getParameter("hand"));
		User user = new User("ユーザー");
		user.setHand(userHand);
		Com com = new Com("コム");
		com.setRandomHand();
		
		JankenLogic jankenLogic = new JankenLogic();
		jankenLogic.execute(user, com);
		
		request.setAttribute("user", user);
		request.setAttribute("com", com);
		String path = "WEB-INF/jsp/result.jsp";
		RequestDispatcher d = request.getRequestDispatcher(path);
		d.forward(request, response);
	}

}
