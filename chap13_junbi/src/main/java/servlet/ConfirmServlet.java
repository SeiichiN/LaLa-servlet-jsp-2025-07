package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.MakeEmpByParam;
import servlet.util.Validator;

@WebServlet(urlPatterns = {"/createConfirm", "/updateConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MakeEmpByParam makeEmp = new MakeEmpByParam();
		Employee emp = makeEmp.execute(request);
		String url = "";
		List<String> errorList = new ArrayList<>();
		Validator validator = new Validator();
		
		String path = request.getServletPath();
		switch (path) {
		case "/createConfirm":
			validator.checkCreate(emp, errorList);
			if (errorList.size() > 0) {
				request.setAttribute("targetURL", "createConfirm");
				request.setAttribute("h2_text", "新規社員登録");
			} else {
				request.setAttribute("targetURL", "createDone");
				request.setAttribute("gobackURL", "createInput");
				request.setAttribute("h2_text", "新規社員登録・確認");
			}
			break;
		case "/updateConfirm":
			validator.checkUpdate(emp, errorList);
			if (errorList.size() > 0) {
				request.setAttribute("targetURL", "updateInput");
				request.setAttribute("h2_text", "社員情報編集");
			} else {
				request.setAttribute("targetURL", "updateDone");
				request.setAttribute("gobackURL", "updateInput");
				request.setAttribute("h2_text", "社員情報編集・確認");
			}
			break;
		}
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "WEB-INF/jsp/input.jsp";
		} else {
			url = "WEB-INF/jsp/confirm.jsp";
		}
		request.setAttribute("emp", emp);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
