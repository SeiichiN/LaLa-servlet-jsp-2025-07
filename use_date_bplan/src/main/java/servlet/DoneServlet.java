package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.MemberForm;
import model.PostMemberFormLogic;
import servlet.util.MakeMemberFormByParam;

@WebServlet(urlPatterns = {"/createDone", "/updateDone"})
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeMemberFormByParam makeMember = new MakeMemberFormByParam();
		MemberForm memberForm = makeMember.execute(request);
		PostMemberFormLogic logic = new PostMemberFormLogic();
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
