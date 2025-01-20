package _01상속_개념;

public class AccessTest {
	
	public int a; //같은 프로젝트 내에서 접근 가능
	int b; //같은 패키지 내에서 접근 가능
	protected int c; //부모자식 클래스만 접근 가능
	private int d=40; //자기 자신 클래스만 접근 가능
	
	public final int num = 100;
	
	void printAll() {
		System.out.printf("%d %d %d %d \n", a, b, c, d);
	}

}
