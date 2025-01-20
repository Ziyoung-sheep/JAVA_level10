package _12콜랙션멤버;

import java.util.ArrayList;

public class ActionInsert implements Action {

	@Override
	public void excute() {

		// 추가하는 dao 연결 
		System.out.println("==== [ 회원가입 ] ==== ");
		String newId=Utils.getInstance().inString("NEW ID");
		if (MemberList.size()>0) {
			
		}
		System.out.println("회원 가입 완료");
	}

}
