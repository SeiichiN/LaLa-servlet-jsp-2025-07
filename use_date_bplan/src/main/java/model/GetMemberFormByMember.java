package model;

public class GetMemberFormByMember {
	public MemberForm execute(Member member) {
		String name = member.getName();
		String birthday = member.getBirthday().toString();
		birthday = birthday.replaceAll("-", "/");
		return new MemberForm(name, birthday);
	}
}
