package model;

import dao.MembersDAO;

public class PostMemberFormLogic implements MemberFormLogic {
	public boolean execute(MemberForm memberForm) {
		MembersDAO dao = new MembersDAO();
		return dao.create(memberForm);
	}
}
