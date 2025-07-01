package ex;

import java.io.Serializable;

public class Fruit implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private int price;
	
	public Fruit() {}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
	
}
