package _15함수형프로그래밍;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05스트림_개념 {
	public static void main(String[] args) {
		
		List<String> names=Arrays.asList("박연미","유재석","하하","정형돈","노홍철","박연미","하하");
		System.out.println("=========1=========");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("=========2=========");
		for (String name : names) {
			System.out.println(name);
		}
		
		System.out.println("=========3=========");
		names.forEach(System.out::println);
		
		System.out.println("=========4=========");
		Stream<String>nameStream=names.stream(); //리스트 names 스트림 객체 생성
		nameStream.forEach(System.out::println);
		//스트림은 마지막 연산이 끝나면 자동으로 사라진다
//		nameStream.count();//이미 연산이 끝나 스트림 객체가 사라졌다는 오류 메세지 발생
		
		System.out.println("=========5=========");
		
		names.stream() //스트림 객체 생성
		.distinct() //중복제거 메서드 호출 : 중간 연산
		.forEach(System.out::println); //값 호출 최종 연산
		
		System.out.println("=========6=========");
		//위의 것을 아래처럼 한 줄로 표현
		names.stream().distinct().forEach(System.out::println);
		
		System.out.println("=========7=========");
		//중복 제외된 배열 만들기
		List<String>copyNames=names.stream().distinct().collect(Collectors.toList());
		System.out.println(copyNames);
		
//		names.set(0, "홍길동");
//		System.out.println(names);
//		System.out.println(copyNames);
		
		System.out.println("----------------------------");
		
		List<Integer> list = new ArrayList<>(Arrays.asList(5,2,0,8,4,1,7,9,3,6));
		
		System.out.println(list);
		
		List<Integer> odds = new ArrayList<>();
		
		for(int i =0; i < list.size(); i+=1) 
			if(list.get(i)%2!=0) odds.add(list.get(i));
		
		System.out.println(odds);
		
		Collections.sort(odds);
		System.out.println(odds);
		
		String data ="";
		for(Integer i : odds)
			data+=i +", ";
		data = data.substring(0 , data.length()-2);
		
		System.out.println(data);
		
		System.out.println("-----------------------");
		
		String result = list.stream()
						.filter(i -> i%2!=0)
						.sorted(Integer::compare)
						.map(i -> i+"")
						.collect(Collectors.joining(", "));
		
		System.out.println(result);
		
	}
}
