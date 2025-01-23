package _17쓰레드이론;

class BGMPlay extends Thread{
	boolean isplay=true;
	public void run() {
		while(isplay) {
			try {
				System.out.println("배경음악 연주중");
				Thread.sleep(300);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}

public class _02쓰레드이론02 {
	public static void main(String[] args) {
		
		BGMPlay bgm=new BGMPlay();
		bgm.start();
		
		for (int i = 0; i <=10; i++) {
			System.out.println("게임중");
			if(i == 8) {
				System.out.println(" 앗 엄마다!! ");
				System.out.println("엄마 와서 게임 종료 ㅜㅜ ");
				//bgm.stop();
				bgm.isplay = false;
			//	bgm.interrupt();
				break;
			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
