package _12콜랙션멤버;

public class ActionInsert implements Action {

	@Override
	public void excute() {
		// 추가하는 dao 연결 
		System.out.println("==== [ 회원가입 ] ==== ");
		String newId=utils.inString("NEW ID");
		
		if (memberDAO.inIdOutIdx(newId)!=-1) {
			System.err.println("이미 아이디가 있습니다.");
		}else {
			String newPw=utils.inString("NEW PW");
			String newName=utils.inString("NEW NAME");
			memberDAO.join(newId, newPw, newName);
			System.out.printf("[%s님, 회원 가입을 축하드립니다]\n",newId);
		}
	}
}
