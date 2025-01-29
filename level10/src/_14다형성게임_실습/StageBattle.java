package _14다형성게임_실습;

import java.util.ArrayList;

import _07ZombiGame.Unit;
import _14다형성게임_실습.UnitManager;

public class StageBattle extends Stage {
	
	private String thisDungeon;
	int mobCnt;
	UnitManager unitManager;
	private int playerParty;
	private int monsterParty;

	@Override
	public boolean update() {
		init();
		System.out.printf("======%s======\n",thisDungeon);
		
		while(true) {
			//전투시스템 넣기
			int cnt=-1;
			print(unitManager.player_list, unitManager.mon_list);
			playerTurn(unitManager.player_list, unitManager.mon_list);
			monsterTurn();
			if (monsterParty==0) {
				System.err.println("던전의 몬스터가 모두 사망했습니다.");
				System.err.println("전투 종료!");
				break;
			}
			if (playerParty==0) {
				GameManager.exit=true;
				System.err.println("파티원이 모두 사망했습니다.");
				System.err.println("전투 종료!");
				break;
			}
		}
		return true;
	}

	@Override
	public void init() {
		thisDungeon=StageLobby.pickDungeon;
		//던전 이름이랑 몹 수랑 연동해서 던전에 따라 몹 카운트와 나오는 몹 종류가 달라지게 하는 코드를 만들면 좋겠다아아...
		//지금은 일단 4로 고정하자
		mobCnt=4;
		unitManager=new UnitManager(mobCnt);
		playerParty=unitManager.player_list.size();
		monsterParty=mobCnt;
	}
	
	private void print(ArrayList<Object>playerList, ArrayList<Object>monsterList) {
		System.out.println("-----PLAYER-----");
		for (Object player : playerList) {
			Player temp=(Player)player;
			System.out.printf("[%s]%s(%d/%d)\n",temp.getType(), temp.getName(), temp.getHp(), temp.getMAX_HP());
		}
		System.out.println("생존 파티원 : "+playerParty+"명");
		System.out.println("-----MONSTER-----");
		for (Object monster : monsterList) {
			Monster temp=(Monster)monster;
			System.out.printf("%s(%d/%d)\n",temp.getName(), temp.getHp(), temp.getMAX_HP());
		}
		System.out.println("남은 적의 숫자 : "+monsterParty+"마리");
	}
	
	private void playerTurn(ArrayList<Object>myTeam, ArrayList<Object>yourTeam) {
		
		int idx=0;
		for ( Object user : myTeam) {
			Player me=(Player)user;
			System.out.printf("-----%s의 TURN-----\n", me.getName());
			System.out.println("[1] 일반 공격");
			int sel=-1;
			if (me.getLimitBreak()!=100) {
				sel=Utiles.getInstance().inInt("행동 선택", 1, 1);
			}else {
				System.out.println("[2] 리미트 브레이크");
				sel=Utiles.getInstance().inInt("행동 선택", 1, 2);
			}
			if (sel==1) {
				//일반 공격
				int pick; //공격할 몹 랜덤뽑기 
				while (true) {
					pick=Utiles.getInstance().random(mobCnt, 0);
					Monster pickMob=(Monster)yourTeam.get(pick);
					if (pickMob.getHp()!=0) {
						break;
					}
				}
				Unit mob=(Unit)yourTeam.get(pick);
				me.attack(mob);
				if (mob.getHp()==0) {
					monsterParty--;
				}
				yourTeam.set(pick, mob);
				//리미트 게이지가 100보다 적으면 리미트 게이지 채우기/100이면 안채움
				if (me.getLimitBreak()<100) {
					me.setLimitBreak(me.getLimitBreak()+100);
					myTeam.set(idx, me);
				}
			}else {
				//리미트 브레이크 게이지 초기화
				me.limitBreakSkill();
				me.setLimitBreak(0);
			}
			idx++;
		}
	}
	
	private void monsterTurn() {
		System.out.println("몹 턴이지만 지금은 보류");
		//몹 공격 짜기
	}
	
}