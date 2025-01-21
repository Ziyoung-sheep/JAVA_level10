package _07ZombiGame;

import java.util.Scanner;

public class _gameMain {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int map=10;
		
		int num1=Unit.playRandom(map-1,1);
		int num2=0;
		while(true) {
			num2=Unit.playRandom(map-1,1);
			if (num1!=num2) {
				break;
			}
		}
		
		if (num1>num2) {
			int temp=num2;
			num2=num1;
			num1=temp;
		}
		
		Hero hero=new Hero("용감한 그라하", 0, 1000, 30, 3);
		Zombie zombie=new Zombie("작은 좀비", num1, 100, 10, 5);
		Boss boss=new Boss("보스 좀비", num2, 300, 20, 10, 100);
		
		System.out.println("=========모험 시작=========");
		while (true) {
			System.out.printf("%s의 현재 위치는 %d입니다.\n", hero.getName(), hero.getPos());
			System.out.println("-------------------------------------");
			
			if (hero.getPos()==zombie.getPos()) {
				System.out.println("작은 좀비 만남! 전투 시작!");
				while(true) {
					System.out.println("------------------------------");
					System.out.printf("%s의 체력: %d\n",hero.getName(), hero.getHp());
					System.out.printf("%s의 체력: %d\n",zombie.getName(), zombie.getHp());
					System.out.println("[1] 공격");
					System.out.println("[2] 포션 마시기");
					try {
						System.out.print(">>");
						int sel=sc.nextInt();
						sc.nextLine();
						if (sel<1||sel>2) {
							System.err.println("입력범위 초과!");
							continue;
						}else if(sel==1) {
							hero.attack(zombie);
							hero.repair(zombie);
							if (zombie.getHp()==0) {
								System.out.printf("%s를 무찔렀습니다. 앞으로 전진합니다.\n", zombie.getName());
								break;
							}
						}else {
							if (hero.getPotion()==0) {
								System.err.println("포션이 없습니다.");
								continue;
							}
							System.out.printf("%s가 포션을 마십니다. 체력200 회복!\n", hero.getName());
							hero.setPotion(hero.getPotion()-1);
							hero.setHp(hero.getHp()+200);
							if(hero.getHp()>hero.getMAX_HP()){
								hero.setHp(hero.getMAX_HP());
							}
						}
						zombie.attack(hero);
						if (hero.getHp()==0) {
							break;
						}
					} catch (Exception e) {
						sc.nextLine();
						System.err.println("입력오류");
						continue;
					}
				}
			}
			if (hero.getPos()==boss.getPos()) {
				System.out.println("보스 좀비 만남! 전투 시작!");
				while(true) {
					System.out.println("------------------------------");
					System.out.printf("%s의 체력: %d\n",hero.getName(), hero.getHp());
					System.out.printf("%s의 체력: %d\n",boss.getName(), boss.getHp());
					System.out.printf("%s의 쉴드: %d\n",boss.getName(), boss.getShield());
					System.out.println("[1] 공격");
					System.out.println("[2] 포션 마시기");
					try {
						System.out.print(">>");
						int sel=sc.nextInt();
						sc.nextLine();
						if (sel<1||sel>2) {
							System.err.println("입력범위 초과!");
							continue;
						}else if(sel==1) {
							int beforeHp=boss.getHp();
							hero.attack(boss);
							int thisTurnDamage=beforeHp-boss.getHp();
							if (boss.getShield()>0) {
								boss.setHp(beforeHp);
								boss.setShield(boss.getShield()-thisTurnDamage);
								if (boss.getShield()<0) {
									boss.setHp(boss.getHp()+boss.getShield());
									boss.setShield(0);
								}
							}
							if (boss.getHp()==0) {
								System.out.printf("%s를 무찔렀습니다. 앞으로 전진합니다.\n", boss.getName());
								break;
							}
							hero.repair(boss);
						}else {
							if (hero.getPotion()==0) {
								System.err.println("포션이 없습니다.");
								continue;
							}
							System.out.printf("%s가 포션을 마십니다. 체력200 회복!\n", hero.getName());
							hero.setPotion(hero.getPotion()-1);
							System.out.printf("남은 포션: %d개\n", hero.getPotion());
							hero.setHp(hero.getHp()+100);
							if(hero.getHp()>hero.getMAX_HP()){
								hero.setHp(hero.getMAX_HP());
							}
						}
						boss.attack(hero);
						if (hero.getHp()==0) {
							break;
						}
					} catch (Exception e) {
						sc.nextLine();
						System.err.println("입력오류");
//						e.printStackTrace();
						continue;
					}
				}
			}
			
			if (hero.getHp()==0) {
				System.err.println("모험 종료");
				break;
			}
			
			System.out.println("[1] 앞으로 이동");
			System.out.println("[0] 종료");
			try {
				System.out.print(">>");
				int sel=sc.nextInt();
				sc.nextLine();
				if (sel<0||sel>1) {
					System.err.println("입력범위 초과!");
					continue;
				}else if(sel==0) {
					System.err.println("모험 종료");
					break;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("입력오류");
				continue;
			}
			
			hero.setPos(hero.getPos()+1);
			if (hero.getPos()>map) {
				System.err.println("목표지점에 도달했습니다!");
				System.out.println("모험 끝!");
				break;
			}
			
		}
		
		
	}
}
