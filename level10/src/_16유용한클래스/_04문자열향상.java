package _16유용한클래스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _04문자열향상 {

	public static void main(String[] args) {
		
		//입출력 성능향상 : BufferedRead & BufferedWrite 사용
		//버퍼라는건 데이터를 묶음으로 옮기는 트랙터 같은 것
		
		//인풋스트림을 만들고 어쩌고 하며 변수에변수에변수를 지정해서 사용하는데
		//여러번 사용 안할 변수는 만들지 않고 아래처럼 만들어 쓰는게 효율적이다...
		
		StringBuilder builder=new StringBuilder();
		try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw=new BufferedWriter( new OutputStreamWriter(System.out))) {
			
			//스캐너를 사용하지 않고 입력과 출력이 가능함
			//근데 그러면...어떤 때 스캐너를 써야하고 어떤 때 빌더를 써야하지?
			//아하 스캐너는 성능이 떨어진다
			//그러니 스캐너보다는 얘가 좋다...라는 이야기구나
			//입력
			System.out.print("input: ");
			builder.append(br.readLine()); //스트링빌더에게 한 줄 데이터를 추가하겠다
			
			bw.write(builder.toString());
			
			builder.setLength(0);//빌더 값 초기화
			
			//버퍼 남은 데이터 지우기
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
