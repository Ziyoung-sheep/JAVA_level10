package _14다형성게임_실습;

import java.util.ArrayList;
import java.util.Vector;

public class UnitManager {
//	Vector<Object> player_list = new Vector<>();
//	Vector<Object> mon_list = new Vector<>();
	ArrayList<Object> player_list = new ArrayList();
	ArrayList<Object> mon_list = new ArrayList();
	
	UnitManager(int cnt) {
		player_list.add(new PlyerTanker("에이", 500, 500, 30));
		player_list.add(new PlyerHealer("비올렛", 200, 200, 25));
		player_list.add(new PlyerMeleeDealer("클레망", 400, 400, 60));
		player_list.add(new PlyerRangedDealer("그라하", 200, 200, 55));
		makeMonList(cnt); //지금은 뭘 택하든 4마리...나중에는 던전에 따라 다르게 입력할 수 있게...
	}
	
	public void makeMonList(int cnt) {
		for (int i = 0; i < cnt; i++) {
			int num=Utiles.getInstance().random(3, 0);
			if (num==0) {
				int batHp=Utiles.getInstance().random(10, 50);
				int batPower=Utiles.getInstance().random(6, 10);
				mon_list.add(new MonsterBat(batHp, batPower));
			}else if (num==1) {
				int jellyfishHp=Utiles.getInstance().random(10, 70);
				int jellyfishPower=Utiles.getInstance().random(6, 10);
				mon_list.add(new MonsterJellyfish(jellyfishHp,jellyfishPower));
			}else {
				int malboroHp=Utiles.getInstance().random(10, 100);
				int malboroPower=Utiles.getInstance().random(6, 10);
				mon_list.add(new MonsterMalboro(malboroHp,malboroPower));
			}
		}
//		for (int i = 0; i < player_list.size(); i++) {
//			System.out.println(player_list.get(i).toString());
//			System.out.println(mon_list.get(i).toString());
//		}
	}
} 