package model;

import dao.MembersDAO;

public class UpdateMemberFormLogic implements MemberFormLogic {
	public boolean execute(MemberForm memberForm) {
		MembersDAO dao = new MembersDAO();
		return dao.update(memberForm);
	}
}
