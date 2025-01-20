package _10컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;

public class _05Map이론 {
	public static void main(String[] args) {
		//key(사용자가 맘대로 정의하는 인덱스), value
		Map<String, Integer>list=new HashMap<>();
		//키 값으로는 String, 안의 값으로는 integer만 들어갈 수 있다
		list.put("apple", 10000);
		list.put("orange", 3000);
		list.put("melon", 20000);
		list.put("banana", 1000);
		System.out.println(list);//넣은 순서대로 들어가지 않는다.
		
		list.put("apple", 4000); //덮어쓰기
		System.out.println(list);
		
		System.out.println(list.get("orange"));
	}

}
