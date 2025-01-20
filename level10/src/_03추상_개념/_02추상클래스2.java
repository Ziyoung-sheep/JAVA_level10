package _03추상_개념;

//부모클래스 상위클래스 슈퍼클래스
class Parent{
	int a;
	int b;
}

//자식클래스 하위클래스 서브클래스
class Child extends Parent{
	int c;
	int d;
}

public class _02추상클래스2 {
	public static void main(String[] args) {
		//casting : 형변환
		//강제형변환
		System.out.println((int)10.2345); //10
		
		Parent p=new Parent();
		Child c=new Child();
		//upcasting : 하위클래스가 상위타입 전환 : 자식클래스 객체가 부모 클래스 객체 전환
		Parent parent=new Child();//업케스팅
//		Child child=new Parent(); //자식이 더 크기 때문에 불가능함
		//downcasting : 이미 부모타입으로 만들어진걸 강제로 자식클래스로 전환
		Child child=(Child)parent;
		
	}

}
