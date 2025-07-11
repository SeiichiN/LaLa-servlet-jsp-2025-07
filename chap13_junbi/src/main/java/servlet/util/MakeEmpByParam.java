package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.Employee;

public class MakeEmpByParam {
	public Employee getParam(HttpServletRequest request) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ageTxt = request.getParameter("age");
		Validator validator = new Validator();
		int age = validator.checkAge(ageTxt);
		Employee emp = new Employee(id, name, age);
		return emp;
	}
}
