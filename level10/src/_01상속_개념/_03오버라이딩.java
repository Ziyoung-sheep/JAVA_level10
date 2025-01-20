package _01상속_개념;
//부모클래스, 슈퍼클래스, 상위클래스
class Parant{
	int num=100;
	void test1() {
		System.out.println("test1호출");
	}
	void printNum() {
		System.out.println("num="+num);
	}
}
//
class Child extends Parant{
	int num=200;
	void test2() {
		System.out.println("test2호출");
	}
	void printNum() {
		System.out.println("num="+num); //자식에 이미 넘이 있으므로 부모까지 갈 필요가 없음
		System.out.println("부모num호출="+super.num); //부모거를 호출하고 싶으면 super. 붙이기
		super.printNum();
	}
	
	@Override //안에 있는 내용만 변경 가능
	void test1() { //타이틀은 같음 
		System.out.println("자식이 변경한 test1호출");
	}
}

public class _03오버라이딩 {

	public static void main(String[] args) {
		
		Parant p= new Parant();
		Child c=new Child();
		c.printNum();
//		c.super.printNum;// super는 자식 클래스 안에서만 사용 가능
		c.test1();

	}

}
