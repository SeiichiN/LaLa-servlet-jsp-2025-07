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
		MakeMemberFormByParam makeMemberForm = 
				new MakeMemberFormByParam();
		MemberForm memberForm = 
				makeMemberForm.execute(request);
		Validator validator = new Validator();
		List<String> errorList = validator.check(memberForm, request);
		String path = request.getServletPath();
		String nextURL = null;
		switch (path) {
		case "/createConfirm":
			if (errorList.size() > 0) nextURL = "createConfirm";
			else nextURL = "createDone";
			break;
		case "/updateConfirm":
			if (errorList.size() > 0) nextURL = "updateConfirm";
			else nextURL = "updateDone";
			break;
		}
		String url = null;
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "WEB-INF/jsp/input.jsp"; 
		}
		else url = "WEB-INF/jsp/confirm.jsp";
		request.setAttribute("nextURL", nextURL);
		request.setAttribute("memberForm", memberForm);
		request.getRequestDispatcher(url).forward(request,response);
	}

}
