package model;

import java.io.Serializable;

public class MemberForm implements Serializable {
	private String name;
	private String birthday;
	public MemberForm() {}
	public MemberForm(String name, String birthday) {
		this.name = name;
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public String getBirthday() {
		return birthday;
	}
	@Override
	public String toString() {
		return "MemberForm [name=" + name + ", birthday=" + birthday + "]";
	}

}
