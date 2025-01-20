package _03추상_개념;

//클래스 설계: 상태 (state=>data) , 행동 (기능==method)
//단 하나라도 미완성된 매서드가 있으면 추상 클래스로 만들어야 한다!

abstract class A{ //단 하나라도 미완성된 매서드가 있으면 추상화 클래스로 변환
	
	void printSomething() {
		System.out.println("something");
	}//완성된 메서드
	
	abstract void printAnything();
	// 미완성된 매서드 => {} 바디가 없다
}

//추상 클래스를 상속받은 클래스는 반드시 미완성된 클래스를 완성시켜줘야 함
class B extends A{
	@Override
	void printAnything() {
		System.out.println("나는 B야");
	}
}


public class _01추상클래스 {
	
	public static void main(String[] args) {

//		추상 클래스는 미완성된 클래스이기 때문에 객체생성 불가
//		A a=new A();
		B b=new B();
		b.printAnything();
		b.printSomething();
		
	}

}
