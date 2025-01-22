package _16유용한클래스;

public class _02문자열향상1 {
	
	public static void main(String[] args) {
		String str1="abc";
		String str2=new String("abc");
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		str1+="def"; //new String ("abcdef") //기존의 종이는 북 찢어버리고 새로운 종이에 쓰는 격
		System.out.println(System.identityHashCode(str1));
		
		//String => 읽기 전용 배열 => 수정이 불가능하다 => 새로운 주소값 다시 할당
		//String Builder (싱글스레드) , String Buffer (멀티스레드)
		//내부적으로 가변문자배열 char[] 가 들어있다.
		//문자열 자체의 여러 변경값이 있을 때 유용하다.
		
		
		StringBuilder builder=new StringBuilder();
		System.out.println(System.identityHashCode(builder));
		builder.append("abc");
		System.out.println(System.identityHashCode(builder));
		builder.append("def");
		System.out.println(System.identityHashCode(builder));
		//한 페이지에 계속 쓰는 것이라 성능이 더 좋다
		
		System.out.println(builder);
		
		//빌더 초기화
		builder.setLength(0); //싹 지워버림
		System.out.println(builder);
		System.out.println("---------------");
		
	}
	
	

}
