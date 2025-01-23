package _17쓰레드이론;

import java.util.Random;

class Customer implements Runnable{
	
	String name;
	ATM atmToUse;
	int needMoney;
	
	public Customer(String name, ATM atmToUse, int needMoney) {
		super();
		this.name = name;
		this.atmToUse = atmToUse;
		this.needMoney = needMoney;
	}

	@Override
	public void run() {
		while (atmToUse.getBalance()>=needMoney) {
			atmToUse.withdraw(name, needMoney);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}


class ATM{
	private int balance =0;
	public void addMoney(int amount) {
		balance+=amount;
	}
	public int getBalance() {
		return balance;
	}
	
	
	//synchronized 동기화 매서드 : 동시에 여러 스레드가 사용 불가능
	//한 번에 하나의 쓰레드만 이용 가능
	//이걸 하지 않으면 여러명이 동시에 접근해서 마이너스 통장 댐... 
	//방법 1. 아래처럼 매소드에 직접 키워드 입력
	public synchronized void withdraw(String name, int amount) {
		
		//방법 2. 따로 구역 만들어주기 
//		synchronized (this) { //this = 현재 스레드
			if (balance<amount) { return; }
			System.out.printf("%s 인출요청 (현재 잔액 %d)\n", name, balance);
			try {
				Thread.sleep(new Random().nextInt(301)+700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			balance -= amount;
			System.out.printf(" %s 인출 완료 (현재 잔액 %d) \n" , name, balance);
			
//		}
	}
	
	
	
	
}

public class _06쓰레드이론05 {
	public static void main(String[] args) {
		ATM atm= new ATM();
		atm.addMoney(5000);
		
		Thread thr1=new Thread(new Customer("철수", atm, 500));
		Thread thr2=new Thread(new Customer("영희", atm, 300));
		Thread thr3=new Thread(new Customer("개똥", atm, 400));
		
		thr1.start();
		thr2.start();
		thr3.start();
	}

}
