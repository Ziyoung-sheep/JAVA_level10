package _12콜랙션멤버;

import java.util.ArrayList;

public class ActionInsert implements Action {

	@Override
	public void excute() {
		// 추가하는 dao 연결 
		System.out.println("==== [ 회원가입 ] ==== ");
		String newId=Utils.getInstance().inString("NEW ID");
		if (MemberDAO.getInstance().inIdOutIdx(newId)==-1) {
			System.err.println("이미 아이디가 있습니다.");
		}else {
			String newPw=Utils.getInstance().inString("NEW PW");
			String newName=Utils.getInstance().inString("NEW NAME");
			MemberDAO.getInstance().join(newId, newPw, newName);
			System.out.printf("[%님, 회원 가입을 축하드립니다]\n",newId);
		}
	}
}
