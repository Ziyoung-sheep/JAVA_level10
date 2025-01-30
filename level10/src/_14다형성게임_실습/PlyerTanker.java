package _14다형성게임_실습;

import java.util.ArrayList;

public class PlyerTanker extends Player {

	PlyerTanker(String name, int hp, int mAX_HP, int power) {
		super(name, "탱커", hp, mAX_HP, power);
	}
	
	public void limitBreakSkill(ArrayList<Object> player_list, ArrayList<Object> mon_list) {
		StageBattle.tankerLimit=true;
		System.out.println("파티원 전체 보호막!");
	}

}
