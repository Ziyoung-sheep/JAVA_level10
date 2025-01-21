package _14다형성게임_실습;

public abstract class Unit {
	
	private String name;
	private int hp;
	private final int MAX_HP;
	private int power;
	
	public Unit(String name, int hp, int mAX_HP, int power) {
		super();
		this.name = name;
		this.hp = hp;
		MAX_HP = mAX_HP;
		this.power = power;
	}
	
	
}