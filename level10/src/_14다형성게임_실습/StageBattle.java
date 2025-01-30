package _14다형성게임_실습;

import java.util.ArrayList;

import _07ZombiGame.Unit;
import _14다형성게임_실습.UnitManager;

public class StageBattle extends Stage {
	
	private String thisDungeon;
	int mobCnt;
	int playerCnt;
	UnitManager unitManager;
	private int playerParty;
	static int monsterParty;
	static boolean tankerLimit;
	
//	public int getMonsterParty() {
//		return monsterParty;
//	}
//
//	public void setMonsterParty(int monsterParty) {
//		this.monsterParty = monsterParty;
//	}

	@Override
	public boolean update() {
		init();
		System.out.printf("======%s======\n",thisDungeon);
		
		while(true) {
			//전투시스템 넣기
			int cnt=-1;
			print(unitManager.player_list, unitManager.mon_list);
			playerTurn(unitManager.player_list, unitManager.mon_list);
			if (!tankerLimit) {
				monsterTurn(unitManager.mon_list, unitManager.player_list);
			}else {
				System.out.println("탱커의 리미트브레이크가 발동해 몬스터들의 공격이 취소되었습니다.");
				tankerLimit=false;
			}
			if (monsterParty==0) {
				System.err.println("던전의 몬스터가 모두 사망했습니다.");
				System.err.println("전투 종료!");
				break;
			}
			if (playerParty==0) {
				GameManager.exit=true;
				System.err.println("파티원이 모두 사망했습니다.");
				System.err.println("GAME OVER!");
				break;
			}
		}
		if (playerParty==0) {
			return false;
		}else {
			return true;
		}
	}

	@Override
	public void init() {
		thisDungeon=StageLobby.pickDungeon;
		//던전 이름이랑 몹 수랑 연동해서 던전에 따라 몹 카운트와 나오는 몹 종류가 달라지게 하는 코드를 만들면 좋겠다아아...
		//지금은 일단 4로 고정하자
		mobCnt=4;
		playerCnt=4;
		unitManager=new UnitManager(mobCnt);
		playerParty=unitManager.player_list.size();
		monsterParty=mobCnt;
		tankerLimit=false;
	}
	
	private void print(ArrayList<Object>playerList, ArrayList<Object>monsterList) {
		System.out.println("-----PLAYER-----");
		for (Object player : playerList) {
			Player temp=(Player)player;
				if (temp.getHp()==0) {
					System.err.printf("[%s]%s(%d/%d), 사망\n",temp.getType(), temp.getName(), temp.getHp(), temp.getMAX_HP());
				}else {
					System.out.printf("[%s]%s(%d/%d)\n",temp.getType(), temp.getName(), temp.getHp(), temp.getMAX_HP());
				}
		}
		System.out.println("생존 파티원 : "+playerParty+"명");
		System.out.println("-----MONSTER-----");
		for (Object monster : monsterList) {
			Monster temp=(Monster)monster;
			if (temp.getHp()==0) {
				System.err.printf("%s(%d/%d), 사망\n",temp.getName(), temp.getHp(), temp.getMAX_HP());
			}else {
				System.out.printf("%s(%d/%d)\n",temp.getName(), temp.getHp(), temp.getMAX_HP());
			}
		}
		System.out.println("남은 적의 숫자 : "+monsterParty+"마리");
	}
	
	private void playerTurn(ArrayList<Object>myTeam, ArrayList<Object>yourTeam) { //플레이어 공격
		
		int idx=0;
		for ( Object user : myTeam) {
			Player me=(Player)user;
			if (me.getHp()>0&&monsterParty>0&&playerParty>0) {
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
					me.limitBreakSkill(myTeam, yourTeam);
					//이게 작동이 안되네...
					me.setLimitBreak(0);
				}
			}
			idx++;
		}
	}
	
	private void monsterTurn(ArrayList<Object>myTeam, ArrayList<Object>yourTeam) {
		//몹 공격 짜기
		for ( Object mob : myTeam) {
			Monster me=(Monster)mob;
			if (me.getHp()>0&&monsterParty>0&&playerParty>0) {
				System.out.printf("-----%s의 TURN-----\n", me.getName());
				int pick; //공격할 파티원 랜덤뽑기 
				while (true) {
					pick=Utiles.getInstance().random(playerCnt, 0);
					Player pickPlayer=(Player)yourTeam.get(pick);
					if (pickPlayer.getHp()!=0) {
						break;
					}
				}
				Unit player=(Unit)yourTeam.get(pick);
				me.attack(player);
				if (player.getHp()==0) {
					playerParty--;
				}
				yourTeam.set(pick, player);
			}
		}
	}
}