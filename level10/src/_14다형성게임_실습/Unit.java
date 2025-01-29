package _14다형성게임_실습;

public abstract class Unit {
	
	private String name;
	private int hp;
	private final int MAX_HP;
	private int power;
	
	Unit(String name, int hp, int mAX_HP, int power) {
		this.name = name;
		this.hp = hp;
		MAX_HP = mAX_HP;
		this.power = power;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getMAX_HP() {
		return MAX_HP;
	}

	public void attack(Unit diffenser){ //공격받을애
		int damage=Utiles.getInstance().random(power, 0);
		System.out.printf("%s가 %s에게 %d의 데미지를 주었습니다.\n", name, diffenser.getName(), damage);
		diffenser.hp-=damage;
		if (diffenser.hp<=0) {
			diffenser.hp=0;
			System.err.println(diffenser.getName()+"가 사망했습니다.");
		}
	}
	
}