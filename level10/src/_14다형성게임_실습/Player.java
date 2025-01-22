package _14다형성게임_실습;

public class Player extends Unit {

	int limitBreak;
	
	Player(String name, int hp, int mAX_HP, int power, int limitBreak) {
		super(name, hp, mAX_HP, power);
		this.limitBreak = limitBreak;
	}
	
	private void limitBreakSkill() {
		
	}

}