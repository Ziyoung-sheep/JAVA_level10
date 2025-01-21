package _12콜랙션멤버;

public class ActionPrint implements Action{

	@Override
	public void excute() {
		System.out.println("==== [ 회원목록 ] ==== ");
		memberDAO.print();
	}
}
