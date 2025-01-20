package _07ZombiGame;

import java.util.Random;

abstract public class Unit {
	
	private Random rd=new Random();
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
		diffenser.hp-=damage;
		if (diffenser.hp<=0) {
			diffenser.hp=0;
			System.out.println(diffenser.toString()+"이 사망했습니다.");
		}
	}
	
	public int playRandom(int num, int startNum) {
		return rd.nextInt(num)+startNum;
	}

}
