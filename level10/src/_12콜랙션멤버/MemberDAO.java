package _12콜랙션멤버;

import java.util.ArrayList;

public class MemberDAO {
	
	private static MemberDAO instance;
	private ArrayList<Member> memberList;
	
	public static MemberDAO getInstance() {
		if(instance == null) instance = new MemberDAO();
		return instance;
	}

	public ArrayList<Member> getMemberList() {
		return memberList;
	}
	
	public int inIdOutIdx(String Id) {
		int idx=-1;
		if (memberList!=null) {
			for (int i = 0; i < memberList.size(); i++) {
				if (memberList.get(i).getId().equals(Id)) {
					idx=i; break;
				}
			}
		}
		return idx;
	}
	
	public void join(String id, String pw, String name) {
		if (memberList==null) {
			memberList=new ArrayList<Member>();
		}
		memberList.add(new Member(id, pw, name));
	}
	
	public void remove(int idx) {
		memberList.remove(idx);
		if (memberList.size()==0) {
			memberList=null;
		}
	}
	
	public void updata(int idx, String id, String pw, String name) {
		memberList.set(idx, new Member(id, pw, name));
	}
	
	public void print() {
		if (memberList==null) {
			System.err.println("회원이 없습니다.");
		}else {
			int num=1;
			for (Member member : memberList) {
				System.out.println("["+(num++)+"]"+member.toString());
			}
		}
	}
	
	public String makeData() {
		String data = "";
		for (Member member : memberList) {
			data+=member.toString()+"\n";
		}
		return data;
	}
	
}
