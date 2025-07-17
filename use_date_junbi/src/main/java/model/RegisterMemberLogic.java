package model;

import dao.MembersDAO;

public class RegisterMemberLogic {
	public boolean execute(MemberForm memberForm) {
		MembersDAO dao = new MembersDAO();
		return dao.create(memberForm);
	}
}
