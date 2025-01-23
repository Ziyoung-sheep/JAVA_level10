package _14다형성게임_실습;

import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Utiles {
	
	//인스턴스로 스캐너 생성
	//인스턴스로 랜덤 생성
	
	private static Utiles instance;
	private Scanner sc=new Scanner(System.in);
	private Random rd=new Random();
	
	public static Utiles getInstance() {
		if (instance==null)  instance=new Utiles();
		return instance;
	}
	
	//관련 메서드 만들기
	
	public int inInt(String msg) {
		int num=-1;
		while(true) {
			try {
				System.out.print(msg+">>");
				num=sc.nextInt();
				sc.nextLine();
				break;
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("입력 오류");
				e.printStackTrace();
			}
		}
		return num;
	}
	
	public int inInt(String msg, int start, int end) {
		int num=-1;
		while(true) {
				try {
					System.out.printf("(%d-%d)>>",msg,start,end);
					num=sc.nextInt();
					sc.nextLine();
					if (num<start||num>end) {
						System.err.println("입력 범위 오류");
						continue;
					}
					break;
				} catch (Exception e) {
					sc.nextLine();
					System.err.println("입력 오류");
					e.printStackTrace();
				}
		}
		return num;
	}
	
	public String inString(String msg) {
		String temp="";
		while (true) {
			System.out.printf("%s>>", msg);
			try {
				temp=sc.nextLine();
				break;
			} catch (Exception e) {
				System.err.println("입력오류");
				continue;
			}
		}
		return temp;
	}
	
	public int random(int cnt, int startNum) {
		return rd.nextInt(cnt)+startNum;
	}
	
}
