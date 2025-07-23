package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetMemberFormByIdLogic;
import model.MemberForm;

@WebServlet(urlPatterns = {"/createInput", "/updateInput", "/deleteInput"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String nextURL = null;
		MemberForm memberForm = null;
		String url = "WEB-INF/jsp/input.jsp";
		switch (path) {
		case "/createInput":
			nextURL = "createConfirm";
			break;
		case "/updateInput":
			memberForm = getMemberFormById(request);
			request.setAttribute("memberForm", memberForm);
			nextURL = "updateConfirm";
			break;
		case "/deleteInput":
			memberForm = getMemberFormById(request);
			request.setAttribute("memberForm", memberForm);
			nextURL = "deleteDone";
			url = "WEB-INF/jsp/confirm.jsp";
			break;
		}
		request.setAttribute("nextURL", nextURL);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private MemberForm getMemberFormById(HttpServletRequest request) {
		String idTxt = request.getParameter("id");
		int id = Integer.parseInt(idTxt);
		GetMemberFormByIdLogic logic = new GetMemberFormByIdLogic();
		return logic.execute(id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
