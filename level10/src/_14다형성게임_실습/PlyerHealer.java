package _14다형성게임_실습;

import java.util.ArrayList;

public class PlyerHealer extends Player {

	PlyerHealer(String name, int hp, int mAX_HP, int power) {
		super(name, "힐러", hp, mAX_HP, power);
	}
	
	private void limitBreakSkill(ArrayList<Object> player_list) {
		System.out.println("생존한 파티원 전원 HP 회복!");
		for (int i = 0; i < player_list.size(); i++) {
			Unit temp=(Unit)player_list.get(i);
			if (temp.getHp()!=0) {
				temp.setHp(temp.getMAX_HP());
				player_list.set(i, temp);
			}
		}
	}
}
