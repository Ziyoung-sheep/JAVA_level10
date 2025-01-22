package _15함수형프로그래밍;

// 함수형 프로그램에 사용할 인터페이즈 조건!
//한 하나의 추상에서만 존재햐야한다

@FunctionalInterface //앞에 이거 붙여주면 두개 있을때 자동 에러 띄워준다
interface Test{
	int getSum(int[]arr);
}


public class _01함수형프로그래밍개념 {
	
	public static int getSum(int []arr) {
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		//명령형 프로그래밍: how, 과정 10-60까지 합산해줘
		int arr[]= {10,20,30,40,50,60};
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
		
		//선언형 프로그래밍: 함수형 => 결과에만 집중하기
		//메소드로 만들어주는 것
		System.out.println(getSum(arr));
		
		//내부 클래스 == 이너클래스 => 익명클래스: 이름이 없는 클래스 = > 일회성 클래스
//		Test result=new Test; <= 이렇게 사용 불가능
		
		Test result=new Test() {
			@Override
			public int getSum(int[]arr) {
				int sum=0;
				for (int i = 0; i < arr.length; i++) {
					sum+=arr[i];
				}
				return sum;
			}
		};
		
		System.out.println(result.getSum(arr));
		
		//람다식 : 자바스크립트의 화살표 함수
		//함수형 프로그램을 편하게 사용하는 방법
		
		Test result2=(int[]arrary) ->{ //하나밖에 없어서 이름으로 저정안해도  ㄱㅊ
			int hap=0;
			for (int i = 0; i < arr.length; i++) {
				hap+=arrary[i];
			}
			return hap;
		};
		
		System.out.println(result2.getSum(arr));
		//이미 만들어진 익명 클래스 접근할 때 (매개변수) 
		Test result3= arrays->result2.getSum(arr);
		System.out.println(result3.getSum(arr));
		
	}

}
