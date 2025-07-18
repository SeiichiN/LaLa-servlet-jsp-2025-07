package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.GetMemberByIdLogic;
import model.GetMemberFormByMember;
import model.Member;
import model.MemberForm;

@WebServlet(urlPatterns = {"/createInput", "/updateInput", "/deleteInput"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String nextURL = null;
		switch (path) {
		case "/createInput":
			nextURL = "createConfirm";
			break;
		case "/updateInput":
			MemberForm memberForm = getMemberFormById(request);
			request.setAttribute("memberForm", memberForm);
			nextURL = "updateConfirm";
			break;
		}
		request.setAttribute("nextURL", nextURL);
		String url = "WEB-INF/jsp/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private MemberForm getMemberFormById(HttpServletRequest request) {
		String idTxt = request.getParameter("id");
		int id = Integer.parseInt(idTxt);
		GetMemberByIdLogic logic = new GetMemberByIdLogic();
		Member member = logic.execute(id);
		GetMemberFormByMember getMember = new GetMemberFormByMember();
		return getMember.execute(member);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
