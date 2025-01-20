package _12콜랙션멤버;

import java.util.Scanner;

public class Utils {
	
	private static Utils instance;
	private static Scanner sc=new Scanner(System.in);
	
	public static Utils getInstance() {
		if(instance == null) instance = new Utils();
		return instance;
	}
	
	public int inInt(String msg, int start, int end) {
		System.out.printf("%s(%d-%d)>>",msg, start, end);
		int num;
		while (true) {
			try {
				num=sc.nextInt();
				sc.nextLine();
				if (num<start||num>end) {
					System.err.println("입력 범위 오류");
				}else {
					break;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("입력 오류");
			}
		}
		return num;
	}
	
	public int inInt(String msg) {
		System.out.printf("%s>>",msg);
		int num;
		while (true) {
			try {
				num=sc.nextInt();
				sc.nextLine();
				break;
			} catch (Exception e) {
				sc.nextLine();
				System.err.println("입력 오류");
			}
		}
		return num;
	}
	
	public String inString(String mag) {
		System.out.printf("%s>>",mag);
		return sc.nextLine();
	}

}
