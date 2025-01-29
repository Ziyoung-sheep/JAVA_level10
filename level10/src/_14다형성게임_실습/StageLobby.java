package _14다형성게임_실습;

import java.util.ArrayList;

public class StageLobby extends Stage {
	
	private ArrayList<String>dungeon=new ArrayList<String>();
	static String pickDungeon;
//	static int pickDungeon;
	// 던전 클래스를 하나 뽑아서
	// String name; 던전 이름
	// int monsterCnt; 던전에서 나오는 몬스터 숫자
	//	ArrayList<Monster>list; 던전에서 나오는 몬스터 리스트 만들기
	
	@Override
	public boolean update() {
		init();
		System.out.println("======LOBBY======");
		int num=1;
		for (String dungeonName : dungeon) {
			System.out.print((num++)+". ");
			System.out.println(dungeonName);
		}
		System.out.println("0. 종료");
		int pick=Utiles.getInstance().inInt("입장할 던전", 0, dungeon.size());
		if (pick==0) {
			return false;
		}else {
			pickDungeon=dungeon.get(pick-1);
//			pickDungeon=pick-1;
			return true;
		}
	}

	@Override
	public void init() {
		dungeon.add("사스타샤 침식 동굴");
		dungeon.add("탐타라 묘소");
		dungeon.add("구리종 광산");
	}

}