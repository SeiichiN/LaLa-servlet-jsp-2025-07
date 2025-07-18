package model;

import java.io.Serializable;

public class MemberForm implements Serializable {
	private int id;
	private String name;
	private String birthday;
	public MemberForm() {}
	public MemberForm(int id, String name, String birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	public MemberForm(String name, String birthday) {
		this(0, name, birthday);
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getBirthday() {
		return birthday;
	}
	@Override
	public String toString() {
		return "MemberForm [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
	
}
