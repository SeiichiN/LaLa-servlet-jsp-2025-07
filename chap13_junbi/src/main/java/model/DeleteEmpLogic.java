package model;

import dao.EmployeesDAO;

public class DeleteEmpLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.remove(id);
	}
}
