package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.MemberForm;
import model.RegisterMemberLogic;

@WebServlet(urlPatterns = "/createDone")
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		MemberForm memberForm = new MemberForm(name, birthday);
		RegisterMemberLogic logic = new RegisterMemberLogic();
		String msg = null;
		if (logic.execute(memberForm)) {
			msg = "登録しました";
		} else {
			msg = "登録に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/done.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
