package _12콜랙션멤버;

public class ActionUpdate implements Action{

	@Override
	public void excute() {
		
		System.out.println("==== [ 회원수정 ] ==== ");
		if (memberDAO.getMemberList()==null) {
			System.err.println("수정할 회원이 없습니다.");
			return;
		}
		String id=utils.inString("ID");
		int idx=memberDAO.inIdOutIdx(id);
		
		if (idx==-1) {
			System.err.println("해당 ID를 가진 회원이 존재하지 않습니다.");
		}else {
			String pw=utils.inString("PW");
			if (memberDAO.getMemberList().get(idx).getPw().equals(pw)) {
				String newId=utils.inString("NEW ID");
				String newPw=utils.inString("NEW PW");
				String newName=utils.inString("NEW NAME");
				memberDAO.updata(idx, newId, newPw, newName);
				System.out.println("[회원 정보가 수정되었습니다.]");
			}else {
				System.err.println("PW가 맞지 않습니다. 다시 확인해주세요.");
			}
		}
		
	}

}
