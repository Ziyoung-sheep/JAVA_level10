package _17쓰레드이론;

import java.util.Scanner;

class SingASong implements Runnable{

	int max;
	public SingASong(int max) {
		this.max=max;
	}
	
	@Override
	public void run() {
		String song="%s : %d +%d는 귀요미";
		for (int i = 0; i <= max; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("내 노래는 좋아~");
				return;
			}
			System.out.printf("%s \n",
					String.format(song, Thread.currentThread().getName(),i,i));
		}
	}
}

public class _04쓰레드이론04 {
	
	public static void main(String[] args) {
		
		Thread mySongThread=new Thread(new SingASong(10));
		mySongThread.setName("귀요미송");
		
		mySongThread.start();
		
		try(Scanner sc=new Scanner(System.in)) {
			while (sc.hasNext()) {
				String input=sc.nextLine();
				
				if (input.equals("끝")) {
					System.out.println("노래 끝났니?");
					System.out.println(mySongThread.isAlive()?"아니":"응"); //스레드가 진행중인지 확인
				}
				if (input.equals("멈춰")) {
					System.out.println("내 노래 시끄럽니?");
					mySongThread.interrupt();//스레드강제종료
					break;
				}
				if (input.equals("같이")) {
					System.out.println("나도 끼워줘");
					try {
						mySongThread.join(3000); //비동기를 동기처럼 만들어주기
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.err.println("----------같이 노래부르기 끝");
					break;
				}
			}
		}
	}
}
