package _17쓰레드이론;

import java.text.SimpleDateFormat;
import java.util.Scanner;

class inputMachine implements Runnable{
	
	private Scanner sc=new Scanner(System.in);
	public static String input;
	boolean running=true;
	
	@Override
	public void run() {
		System.out.print(">>>>");
		String input=sc.next();
		sc.nextLine();

	}
}

class StopWatch implements Runnable{
	
	boolean pause=false;
	private int time;  //소요시간 출력
	
	
	
	@Override
	public void run() {
		System.out.println("[q] quit\t[h] hold\t[x] return");
		SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
		
		while(true) {
			
			if (inputMachine.input.equals("q")) { //이걸 이 안에 넣어 스태틱으로 불러오는거였어...
				int hour=time/(60*60);
				int min=time%(60*60)/60;
				int sec=time%60;
				System.out.print("소요시간 : ");
				if (hour>0) System.out.printf("%d 시간", hour);
				if (min>0) System.out.printf("%d 분", min);
				System.out.printf("%d 초\n", sec);
				System.out.println("종료");
				return;
			}
			if (inputMachine.input.equals("x")) {
				System.out.println("강제 종료");
				return;
			}
			if (!inputMachine.input.equals("h")) {
				
				long preTime=System.currentTimeMillis();
				System.out.println("[현재시각  "+sdf.format(preTime)+"] "+(time++)+"초");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
	}
}

public class _05쓰레드실습 {
	
	public static void main(String[] args) {
		
//		Thread machine = new Thread(new inputMachine());
		Thread stopWatch=new Thread(new StopWatch());
//		machine.start();
		stopWatch.start();
//		machine.setPriority(1);
		stopWatch.setPriority(2);
//		String temp=machine.run
		try(Scanner sc=new Scanner(System.in)) {
			while (sc.hasNext()) {
				String input=sc.nextLine();
				if (input.equals("q")) {
					stopWatch.interrupt();
					break;
				}
				if (input.equals("h")) {
					try {
						stopWatch.wait();
						if (input.equals("r")) {
							stopWatch.start();
						}
					} catch (Exception e) {
						
					}
				}
				if (input.equals("x")) {
					stopWatch.interrupt();
					System.err.println("다시 시작");
					stopWatch=new Thread(new StopWatch());
					stopWatch.start();
				}
				sc.nextLine();
			}
		}
		
		
	}
}