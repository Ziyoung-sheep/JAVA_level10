package _17쓰레드이론;

import java.util.Iterator;

class ExThread implements Runnable { 
	
	int no;
	public ExThread(int no) {
		this.no=no;
	}

	@Override
	public void run() {
		System.out.println("쓰레드 이름: "+Thread.currentThread().getName());
		for (int i = 0; i <20; i++) {
			System.out.print(no);
			//시간 지연을 위한 포문
			for (int j = 0; j < Integer.MAX_VALUE; j++) {}
		}
	}
}

public class _03쓰레드이론03 {
	public static void main(String[] args) {
		Thread th1=new Thread(new ExThread(1));
		Thread th2=new Thread(new ExThread(2));
		Thread th3=new Thread(new ExThread(3));
		
		//Thread-0쓰레드 이름은 0부터 시작
		th1.setName("쓰레드1");
		th2.setName("쓰레드2");
		th3.setName("쓰레드3");
		//이름 변경 가능
		
		//우선순위는 1에서 10: 높을수록 우선순위가 높다
		//가장 높은건 1 가장 낮은건 5 설정해주지 않으면 디폴트값 5
		th1.setPriority(Thread.MIN_PRIORITY); //1
		th2.setPriority(Thread.NORM_PRIORITY); //5
		th3.setPriority(Thread.MAX_PRIORITY); //10
		
		//결과값 21132132132132132132132132132132132132132132132132132132132
		//우선순위를 해주긴 해주는데 믿지마라!
		//jvm에서 쓰레드 우선순위를 권장한다
		//실제 스레드를 컨트롤 하는건 OS(window)에서 처리한다
		//따라서 우선순위를 설정하면 OS가 무시해버리면 그만인 것
		//따라서 jvm은 우선순위를 지키려 노력하고 있지만 OS에서 이뤄지지 않을 수 있다
		//OS는 돌리는 프로그램이 여러개고 본인이 좋아하는 처리 순서로 가기 때문에...
		
		th1.start();
		th2.start();
		th3.start();
	}
}
