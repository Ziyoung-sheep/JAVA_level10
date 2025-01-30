package _14다형성게임_실습;

import java.util.ArrayList;

public class PlyerMeleeDealer extends Player {

	PlyerMeleeDealer(String name, int hp, int mAX_HP, int power) {
		super(name, "근거리 딜러", hp, mAX_HP, power);
	}
	
	public void limitBreakSkill(ArrayList<Object> player_list, ArrayList<Object> mon_list) {
		System.out.println("랜덤 몹 1마리 데미지 50!");
		while(true) {
			int pick=Utiles.getInstance().random(mon_list.size(), 0);
			Monster temp=(Monster)mon_list.get(pick);
			if (temp.getHp()==0) {
				continue;
			}
			temp.setHp(temp.getHp()-50);
			System.out.printf("%s가 %s에게 %d의 데미지를 주었습니다.\n", getName(), temp.getName(), 50);
			if (temp.getHp()<=0) {
				temp.setHp(0);
				StageBattle.monsterParty--;
				System.err.println(temp.getName()+"을 해치웠습니다.");
			}
			mon_list.set(pick, temp);
			break;
		}
		
	}

}
