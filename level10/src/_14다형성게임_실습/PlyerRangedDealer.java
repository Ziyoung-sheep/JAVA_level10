package _14다형성게임_실습;

import java.util.ArrayList;

public class PlyerRangedDealer extends Player {
	
	PlyerRangedDealer(String name, int hp, int mAX_HP, int power) {
		super(name, "원거리 딜러", hp, mAX_HP, power);
	}

	private void limitBreakSkill(ArrayList<Object> mon_list) {
		System.out.println("전체 몹에게 데미지 15!");
		for (int i = 0; i < mon_list.size(); i++) {
			Unit temp=(Unit)mon_list.get(i);
			if (temp.getHp()>0) {
				temp.setHp(temp.getHp()-15);
				if (temp.getHp()<=0) {
					temp.setHp(0);
					System.err.println(temp.getName()+"을 해치웠습니다.");
				}
				mon_list.set(i, temp);
			}
		}
	}

}
