package _14다형성게임_실습;

public class PlyerTanker extends Player {

	PlyerTanker(String name, int hp, int mAX_HP, int power) {
		super(name, "탱커", hp, mAX_HP, power);
	}
	
	public void limitBreakSkill() {
		boolean TankerLimit=true;
		System.out.println("파티원 전체 방어력 10 증가!");
	}

}
