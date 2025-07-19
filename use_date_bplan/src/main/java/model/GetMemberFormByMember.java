package model;

public class GetMemberFormByMember {
	public MemberForm execute(Member member) {
		int id = member.getId();
		String name = member.getName();
		String birthday = member.getBirthday().toString();
		birthday = birthday.replaceAll("-", "/");
		return new MemberForm(id, name, birthday);
	}
}
