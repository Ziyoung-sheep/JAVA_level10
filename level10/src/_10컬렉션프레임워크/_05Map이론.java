package _10컬렉션프레임워크;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class _05Map이론 {
	public static void main(String[] args) {
		//key(사용자가 맘대로 정의하는 인덱스), value
		//key값은 중복을 허용하지 않는다
		//키 값은 하나만 가능(배열은 들어갈 수 없다)
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
		
		Set<String>keyList=list.keySet(); //중복을 허용하지 않는 셋 리스트에 받아오기 가능
		for (String string : keyList) {
			System.out.println(string);
		}
		
		System.out.println(list.containsKey("apple")); //키 값에 있는지 확인하는 중
		System.out.println(list.containsKey("waterMelon"));
		System.out.println(list.containsValue(1000));//값에 잇는지 확인
		
		Set<Map.Entry<String, Integer>>list2=list.entrySet();
		for (Map.Entry<String, Integer> entry : list2) {
			System.out.println(entry);
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
	}

}
