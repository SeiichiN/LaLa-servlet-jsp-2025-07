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
import model.GetListByAgeLogic;
import servlet.util.Validator;

@WebServlet("/listByAge")
public class ListByAgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList = new ArrayList<>();
		String ageTxt = request.getParameter("age");
		Validator validator = new Validator();
		int age = validator.checkAge(ageTxt, errorList);
		
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
		} else {
			GetListByAgeLogic logic = new GetListByAgeLogic();
			List<Employee> empList = logic.execute(age);
			request.setAttribute("empList", empList);
		}
		String path = "WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

}
