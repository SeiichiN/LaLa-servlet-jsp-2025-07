package model;

import dao.MembersDAO;

public class GetMemberByIdLogic {
	public Member execute(int id) {
		MembersDAO dao = new MembersDAO();
		return dao.findMemberById(id);
	}
}
