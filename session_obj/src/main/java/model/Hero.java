package model;

import java.io.Serializable;

public class Hero implements Serializable {
    private String name;
    private int hp;
    private int age;
    
    public Hero() {}

	public Hero(String name, int hp, int age) {
		this.name = name;
		this.hp = hp;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public int getAge() {
		return age;
	}
    
}
