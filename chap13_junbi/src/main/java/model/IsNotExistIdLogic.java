package model;

import dao.EmployeesDAO;

public class IsNotExistIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		if (dao.isNotExistId(id)) {
			return true;
		}
		return false;
	}
}
