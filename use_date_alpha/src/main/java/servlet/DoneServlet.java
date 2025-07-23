package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.DeleteMemberFormLogic;
import model.MemberForm;
import model.MemberFormLogic;
import model.PostMemberFormLogic;
import model.UpdateMemberFormLogic;
import servlet.util.MakeMemberFormByParam;

@WebServlet(urlPatterns = {"/createDone", "/updateDone", "/deleteDone"})
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeMemberFormByParam makeMemberForm = new MakeMemberFormByParam();
		MemberForm memberForm = makeMemberForm.execute(request);
		MemberFormLogic logic = null;
		String msg = null;
		switch (request.getServletPath()) {
		case "/createDone":
			logic = new PostMemberFormLogic();
			if (logic.execute(memberForm)) msg = "登録しました";
			else msg = "登録に失敗しました";
			break;
		case "/updateDone":
			logic = new UpdateMemberFormLogic();
			if (logic.execute(memberForm)) msg = "更新しました";
			else msg = "更新に失敗しました";
			break;
		case "/deleteDone":
			logic = new DeleteMemberFormLogic();
			if (logic.execute(memberForm)) msg = "削除しました";
			else msg = "削除に失敗しました";
			break;
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/done.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
