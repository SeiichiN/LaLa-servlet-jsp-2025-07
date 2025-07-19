package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.MemberForm;
import model.MemberFormLogic;
import model.PostMemberFormLogic;
import model.UpdateMemberFormLogic;
import servlet.util.MakeMemberFormByParam;

@WebServlet(urlPatterns = {"/createDone", "/updateDone"})
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeMemberFormByParam makeMember = new MakeMemberFormByParam();
		MemberForm memberForm = makeMember.execute(request);
		MemberFormLogic logic = null;
		String job = null;
		String path = request.getServletPath();
		switch (path) {
		case "/createDone":
			logic = new PostMemberFormLogic();
			job = "登録";
			break;
		case "/updateDone":
			logic = new UpdateMemberFormLogic();
			job = "更新";
			break;
		}
		String msg = null;
		if (logic.execute(memberForm)) {
			msg = job + "しました";
		} else {
			msg = job + "に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/done.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
