package _14다형성게임_실습;

public class PlyerRangedDealer extends Player {
	
	PlyerRangedDealer(String name, int hp, int mAX_HP, int power) {
		super(name, "[원거리 딜러]", hp, mAX_HP, power);
	}

	private void limitBreakSkill() {
		System.out.println("전체 몹에게 데미지 15!");
	}

}
