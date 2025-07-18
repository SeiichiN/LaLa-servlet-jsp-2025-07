package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.MemberForm;

public class MakeMemberFormByParam {
	public MemberForm execute(HttpServletRequest request) {
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		MemberForm memberForm = new MemberForm(name, birthday);
		return memberForm;
	}
}
