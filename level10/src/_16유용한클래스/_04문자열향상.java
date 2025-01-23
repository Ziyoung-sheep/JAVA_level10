package _16유용한클래스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _04문자열향상 {

	public static void main(String[] args) {
		
		//입출력 성능향상 : BufferedRead & BufferedWrite 사용
		//버퍼라는건 데이터를 묶음으로 옮기는 트랙터 같은 것
		
		StringBuilder builder=new StringBuilder();
		try (BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw=new BufferedWriter( new OutputStreamWriter(System.out))) {
			
			//스캐너를 사용하지 않고 입력과 출력이 가능함
			System.err.print("input: ");
			builder.append(br.readLine()); //스트링빌더에게 한 줄 데이터를 추가하겠다
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
