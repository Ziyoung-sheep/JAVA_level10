package _15함수형프로그래밍;

class Calculate{
	int add(int a, int b) {return a+b;}
	int subtract(int a, int b) {return a-b;}
	int multiply(int a, int b) {return a * b;}
}

@FunctionalInterface
interface CalFuntion{
	int call(int a, int b);
}

public class _03함수형프로그래밍실습 {
	public static void main(String[] args) {
		Calculate cal = new Calculate();
		System.out.println(cal.add(10, 20));
		System.out.println(cal.subtract(10, 20));
		System.out.println(cal.multiply(10, 20));
		
		//함수형 인터페이스 CalFuntion 만들어서 위와 같은 결과 실행
		//각각 함수형 인터페이스 Add , Subtract , Multiply 만들어서 위와 같은 결과 실행 
		
		CalFuntion add=(a, b)-> a+b;
		System.out.println(add.call(10, 20));
		
		CalFuntion sub=(a, b)-> a-b;
		System.out.println(sub.call(10, 20));
		
		CalFuntion mul=( a, b)-> a*b;
		System.out.println(mul.call(10, 20));
		
	}
}
