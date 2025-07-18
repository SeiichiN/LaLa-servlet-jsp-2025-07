package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.MemberForm;
import servlet.util.MakeMemberFormByParam;
import servlet.util.Validator;

@WebServlet(urlPatterns = {"/createConfirm", "/updateConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		MakeMemberFormByParam makeMember = new MakeMemberFormByParam();
		MemberForm memberForm = makeMember.execute(request);
		Validator validator = new Validator();
		List<String> errorList = validator.check(memberForm);
		String nextURL = null;
		String url = null;
		if (errorList.size() > 0) {
			switch (path) {
			case "/createConfirm":
				nextURL = "createConfirm";
				break;
			case "/updateConfirm":
				nextURL = "updateConfirm";
				break;
			}
			url = "WEB-INF/jsp/input.jsp";
			request.setAttribute("errorList", errorList);
		} else {
			switch (path) {
			case "/createConfirm":
				nextURL = "createDone";
				break;
			case "/updateConfirm":
				nextURL = "updateDone";
				break;
			}
			url = "WEB-INF/jsp/confirm.jsp";
		}
		request.setAttribute("nextURL", nextURL);
		request.setAttribute("memberForm", memberForm);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
