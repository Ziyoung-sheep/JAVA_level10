package _14다형성게임_실습;

public class PlyerHealer extends Player {

	PlyerHealer(String name, int hp, int mAX_HP, int power) {
		super(name, "[힐러]", hp, mAX_HP, power);
	}
	
	private void limitBreakSkill() {
		System.out.println("파티원 전원 HP 회복!");
	}
}
