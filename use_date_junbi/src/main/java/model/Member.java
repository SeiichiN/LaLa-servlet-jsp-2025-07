package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Member implements Serializable {
	private int id;
	private String name;
	private Date birthday;
	private int age;
	
	public Member() {}

	public Member(String name, String birthText) {
		this.name = name;
		this.birthday = Date.valueOf(birthText);
		calcAge();
	}
	
	public Member(int id, String name, Date birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		calcAge();
	}
	
	public void calcAge() {
		// Date sqlDate = Date.valueOf(birthday);
		LocalDate birthDate = birthday.toLocalDate();
		LocalDate currentDate = LocalDate.now();
		age = Period.between(birthDate, currentDate).getYears();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getBirthday() {
		return birthday;
	}
	
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", birthday=" + birthday + ", age=" + age + "]";
	}
	
}
