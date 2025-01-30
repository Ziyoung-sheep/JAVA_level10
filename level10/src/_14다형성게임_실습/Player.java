package _14다형성게임_실습;

import java.util.ArrayList;

import _07ZombiGame.Unit;

public class Player extends Unit {

	int limitBreak;
	String type;
	
	Player(String name, String type, int hp, int mAX_HP, int power) {
		super(name ,hp, mAX_HP, power);
		this.type=type;
		this.limitBreak = 0;
	}
	
//	public void attack(Unit diffenser) {
//		super.attack(diffenser);
//	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getLimitBreak() {
		return limitBreak;
	}

	public void setLimitBreak(int limitBreak) {
		this.limitBreak = limitBreak;
	}

	public void limitBreakSkill(ArrayList<Object> myTeam, ArrayList<Object> yourTeam) {
		// TODO Auto-generated method stub
		
	}

}