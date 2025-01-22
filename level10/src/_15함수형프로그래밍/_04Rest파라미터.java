package _15함수형프로그래밍;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _04Rest파라미터 {
	
	//매개변수의 갯수를 모를 때 사용
	public static int getSum(int ...nums) { //int[]nums 의 배열이라는 말과 같다
		int sum=0;
		for (int i = 0; i < nums.length; i++) { //자동으로 배열취급
			sum+=nums[i];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(getSum());
		System.out.println(getSum(10));
		System.out.println(getSum(10,20,30));
		System.out.println(getSum(10,20,30,40,50));
		
		List<String>list=Arrays.asList("강아지","고양이","사자","호랑이");
		
		for(String element: list) System.out.println(element);
		
		System.out.println("--------------");
		
		//리스트의 요소를 처음부터 끝까지 한 개씩 꺼내오는 매서드
		list.forEach(element -> System.out.println(element));
		
		System.out.println("--------------");

		//사용할클래스 객체:: 매서드 이름 = > 매개변수 값 생략
		list.forEach(System.out::println);
		
	}
	
}
