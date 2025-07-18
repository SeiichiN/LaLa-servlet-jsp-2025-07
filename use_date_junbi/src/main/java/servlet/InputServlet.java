package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetMemberByIdLogic;
import model.Member;

@WebServlet(urlPatterns = {"/createInput", "/updateInput"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/createInput":
			break;
		case "/updateInput":
			String idTxt = request.getParameter("id");
			int id = Integer.parseInt(idTxt);
			GetMemberByIdLogic logic = new GetMemberByIdLogic();
			Member member = logic.execute(id);
			request.setAttribute("member", member);
			break;
		}
		
		String url = "WEB-INF/jsp/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
