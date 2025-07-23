package model;

import dao.MembersDAO;

public class DeleteMemberFormLogic implements MemberFormLogic {
	public boolean execute(MemberForm memberForm) {
		MembersDAO dao = new MembersDAO();
		return dao.remove(memberForm.getId());
	}
}
