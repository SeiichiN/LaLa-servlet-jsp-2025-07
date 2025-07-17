package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class Member implements Serializable {
	private int id;
	private String name;
	private LocalDate birthday;
	
	public Member() {}

	public Member(String name, String birthText) {
		this.name = name;
		Date sqlBirthday = Date.valueOf(birthText);
		this.birthday = sqlBirthday.toLocalDate();
	}
	
	public Member(int id, String name, LocalDate birthday) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	
	public int getAge() {
		// Date sqlDate = Date.valueOf(birthday);
		// LocalDate birthDate = birthday.toLocalDate();
		LocalDate currentDate = LocalDate.now();
		return Period.between(birthday, currentDate).getYears();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	
}
