package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.RegisterEmpLogic;
import model.UpdateEmpLogic;
import servlet.util.MakeEmpByParam;

@WebServlet(urlPatterns = {"/createDone", "/updateDone"})
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeEmpByParam makeEmp = new MakeEmpByParam();
		Employee emp = makeEmp.execute(request);

		String msg = "";
		String path = request.getServletPath();
		switch (path) {
		case "/createDone":
			RegisterEmpLogic registerEmpLogic = new RegisterEmpLogic();
			boolean result = registerEmpLogic.execute(emp);
			if (result) {
				msg = "登録しました";
			} else {
				msg = "登録に失敗しました";
			}
			request.setAttribute("h2_text", "新規社員登録・結果");
			break;
		case "/updateDone":
			UpdateEmpLogic updateEmpLogic = new UpdateEmpLogic();
			if (updateEmpLogic.execute(emp)) {
				msg = "更新しました";
			} else {
				msg = "更新しました";
			}
			request.setAttribute("h2_text", "社員情報編集・結果");
			break;
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/done.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
