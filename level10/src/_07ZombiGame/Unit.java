package _07ZombiGame;

import java.util.Random;

abstract public class Unit {
	
	private static Random rd=new Random();
	private String name;
	private int pos;
	private int hp;
	private final int MAX_HP;
	private int power;
	
	public Unit(String name, int pos, int hp, int power) {
		this.name = name;
		this.pos = pos;
		this.hp = hp;
		MAX_HP = hp;
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
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

	public int getMAX_HP() {
		return MAX_HP;
	}

	@Override
	public String toString() {
		return name+"("+hp+"/"+MAX_HP+")";
	}
	
	public void attack(Unit diffenser){ //공격받을애
		int damage=rd.nextInt(power);
		System.out.printf("%s가 %s에게 %d의 데미지를 주었습니다.\n", name, diffenser.getName(), damage);
		diffenser.hp-=damage;
		if (diffenser.hp<=0) {
			diffenser.hp=0;
			System.err.println(diffenser.getName()+"가 사망했습니다.");
		}
	}
	
	public static int playRandom(int num, int startNum) {
		return rd.nextInt(num)+startNum;
	}

}
