package _07ZombiGame;

import java.util.Scanner;

public class _gameMain {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int map=10;
		
		int num1=Unit.playRandom(10,0);
		int num2=0;
		while(true) {
			num2=Unit.playRandom(10,0);
			if (num1!=num2) {
				break;
			}
		}
		
		if (num1>num2) {
			int temp=num2;
			num2=num1;
			num1=temp;
		}
		
		Hero hero=new Hero("용감한 그라하", 0, 200, 30, 3);
		Zombie zombie=new Zombie("작은 좀비", num1, 100, 10, 5);
		Boss boss=new Boss("보스 좀비", num2, 300, 20, 10, 100);
		
		while (true) {
			System.out.println("=========모험 시작=========");
			System.out.printf("%s의 현재 위치는 %d입니다.\n", hero.getName(), heroPos);
			System.out.println("[1] 앞으로 이동");
			System.out.println("[0] 종료");
			try {
				int sel=sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("입력오류");
				continue;
			}
			
			hero.setPos(hero.getPos()+1);
			if (hero.getPos()==zombie.getPos()) {
				
			}
			if (hero.getPos()==zombie.getPos()) {
				
			}
			
		}
		
		
	}
}
