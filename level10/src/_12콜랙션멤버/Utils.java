package _12콜랙션멤버;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
	
	private static final String CUR_PATH=System.getProperty("user.dir")+"\\src\\"+Utils.class.getPackageName()+"\\";
	private static final String FILE_NAME="member.txt";
	private static String filePath=CUR_PATH+FILE_NAME;
	
	public void save(String data) {
		try (FileWriter fw=new FileWriter(filePath)){
			fw.write(data);
			System.out.println("저장 성공");
			System.out.println("저장 위치: "+filePath);
		} catch (Exception e) {
			System.err.println("저장 실패");
			e.printStackTrace();
		}
	}
	
	public void load() {
		try(FileReader fr=new FileReader(filePath);
				BufferedReader br=new BufferedReader(fr)) {
			while(true) {
				String temp=br.readLine();
				if (temp==null) {
					break;
				}
				System.out.println(temp);
			}
			System.out.println("[파일 읽기를 완료했습니다]");
		} catch (Exception e) {
			System.err.println("파일 읽기 실패");
		}
	}
	
	
		
	
}
