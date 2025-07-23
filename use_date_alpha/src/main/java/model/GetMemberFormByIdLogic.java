package model;

import dao.MembersDAO;

public class GetMemberFormByIdLogic {
	public MemberForm execute(int id) {
		MembersDAO dao = new MembersDAO();
		Member member = dao.findMemberById(id);
		String name = member.getName();
		String birthday = member.getBirthday().toString();
		birthday = birthday.replaceAll("-", "/");
		MemberForm memberForm = new MemberForm(id, name, birthday);
		return memberForm;
	}
}
