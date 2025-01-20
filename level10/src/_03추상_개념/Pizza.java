package _03추상_개념;

public abstract class Pizza {
	
	int price;
	String brand;
	String name;
	
	public Pizza(int price, String brand, String name) {
		super();
		this.price = price;
		this.brand = brand;
		this.name = name;
	}

	void makingPizza() {
		makeDough();
		putTopping();
		bakePizza();
		cutPizza();
		putInBox();
		System.out.println(this+"완성");
	}
	
	void makeDough() {
		System.out.println("피자도우 만들기");
	}
	abstract void putTopping();
	
	void bakePizza() {
		System.out.println(name+"피자 굽기");
	}
	
	void cutPizza() {
		System.out.println("피자 커팅하기");
	}
	void putInBox() {
		System.out.println("피자 포장하기");
	}

}
