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

@WebServlet(urlPatterns = {"/createConfirm", "/updateConfirm", "/deleteConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeMemberFormByParam makeMemberForm = 
				new MakeMemberFormByParam();
		MemberForm memberForm = 
				makeMemberForm.execute(request);
		Validator validator = new Validator();
		List<String> errorList = validator.check(memberForm, request);
		String url = null;
		if (errorList.size() > 0) {
			// input.jspにもどって、エラー表示
		} else {
			// confirm.jspで確認表示
		}
		request.getRequestDispatcher(url).forward(request,response);
	}

}
