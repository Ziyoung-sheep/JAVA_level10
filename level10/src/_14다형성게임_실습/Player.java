package _14다형성게임_실습;

public class Player extends Unit {

	int limitBreak;
	String type;
	
	Player(String name, String type, int hp, int mAX_HP, int power) {
		super(name, hp, mAX_HP, power);
		this.limitBreak = 0;
	}
	
	private void limitBreakSkill() {
		
	}

}