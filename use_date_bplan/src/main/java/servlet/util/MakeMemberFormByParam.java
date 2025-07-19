package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.MemberForm;

public class MakeMemberFormByParam {
	public MemberForm execute(HttpServletRequest request) {
		String idTxt = request.getParameter("id");
		int id = 0;
		try {
			id = Integer.parseInt(idTxt);
		} catch (NumberFormatException e) {
			id = 0;
		}
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		MemberForm memberForm = new MemberForm(id, name, birthday);
		return memberForm;
	}
}
