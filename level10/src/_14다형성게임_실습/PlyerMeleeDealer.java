package _14다형성게임_실습;

public class PlyerMeleeDealer extends Player {

	PlyerMeleeDealer(String name, int hp, int mAX_HP, int power) {
		super(name, "[근거리 딜러]", hp, mAX_HP, power);
	}
	
	private void limitBreakSkill() {
		System.out.println("가장 가까운 몹 1마리 데미지 50!");
	}

}
