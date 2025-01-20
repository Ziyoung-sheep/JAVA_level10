package _01상속_개념;

class D{
	int d;
	D(){
		System.out.println("D생성!");
	}
}
class E extends D{
	int e;
	E(){
		System.out.println("E생성!");
	}
}
class F extends E{
	int f;
	F(){
		System.out.println("F생성!");
	}
}
//한 클래스에 두 부모를 설정할 수는 없지만
//상속을 거듭할수는 있다.
public class _02상속2 {
	public static void main(String[] args) {
		
		F f=new F();
		
	}
}
