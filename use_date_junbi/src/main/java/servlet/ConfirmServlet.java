package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.MemberForm;
import servlet.util.Validator;

@WebServlet(urlPatterns = {"/createConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String birth = request.getParameter("birthday");
		MemberForm memberForm = new MemberForm(name, birth);

		List<String> errorList = new ArrayList<>();
		Validator validator = new Validator();
		validator.check(memberForm, errorList);
		
		String path = request.getServletPath();
		String url = null;
		switch (path) {
		case "/createConfirm":
			if (errorList.size() > 0) {
				url = "WEB-INF/jsp/input.jsp";
			} else {
				url = "WEB-INF/jsp/confirm.jsp";
			}
			break;
		}
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
		}
		request.setAttribute("memberForm", memberForm);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
