package _17쓰레드이론;
//쓰레드 만들기
//방법 1 쓰레드 상속받기
class Thread1 extends Thread { 
	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			try {
				Thread.sleep(300); //0.3초 멈춤
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("1");
		}
	}
	
}

//방법 2 러너블 상속받기
//방법 1을 쓰면 기존 클래스가 다른 것을 상속받고 있을 때 스레드를 실행할 수 없기 때문에
//러너블을 상속받는 식
//쓰레드 클래스가 애초에 러너블을 상속받는다
//FunctionalInterface 이 클래스에 포함되어 있기 때문에 람다식도 사용 가능

 class myRunnable implements Runnable { 

	@Override
	public void run() {
		
		for (int i = 0; i <= 20; i++) {
			try {
				Thread.sleep(300); //0.3초 멈춤
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("2");
		}
	}
 }


public class _01쓰레드이론01 {
	
	//동기적: 메모리 호출 순서로 순차적으로 실행
	//비동기적: 호출 할 때 다른 곳에서 실행, 현재 실행하는 것을 멈추지 않는다.
	
	public static void main(String[] args) {
		
		System.out.println("메인쓰레드영역");
		//쓰레드를 상속받은 클래스 생성
//		Thread1 thread1=new Thread1();
		Thread thread1=new Thread1(); //스레드 생성
		
		//위처럼 해도 되지만 나중에 뭐를 상속받아도 괜찮게 앞을 더 큰 쓰레드 클래스로 하면
		//업캐스트
		
		//runnable 구현해서 만든 클래스 생성
		Thread thread2=new Thread(new myRunnable());
		
		
		thread1.start();// 생성한 스레드를 실행하는 메서드 // run을 호출하지 않아도 자동호출
		thread2.start();// 생성한 스레드를 실행하는 메서드
		
//		for (int i = 0; i <= 20; i++) {
//			try {
//				Thread.sleep(300); //0.3초 멈춤
//			}catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.print("M");
//		}
		
		//결과 M122M112M21MM1221MM2112M12M2M1M2112M21MM1212M12M2M12M1M122M1M21
		//thread1, thread2, main 셋 중 먼저 돌아가는 애 없이 각자 동시에 실행되기 때문에 무작위로 순서가 나온다
		
		//상단의 스레드와는 달리 아래는 익명클레스이므로
		//1회용이다
		Thread thread3 = new Thread( new Runnable() {
			@Override
			public void run() {
				for(int i =1; i<=20; i+=1) {
					try {
						Thread.sleep(300);// 0.3초 멈춤
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
					System.out.print("3");
				}
			}
		});
		
		Thread thread4 = new Thread(()->{
			for(int i =1; i<=20; i+=1) {
				try {
					Thread.sleep(300);// 0.3초 멈춤
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				System.out.print("4");
			}
		});
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		for(int i =1; i<=20; i+=1) {
			try {
				Thread.sleep(300);// 0.3초 멈춤
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			System.out.print("M");
		}
	}

}
