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

	public void setMemberList(ArrayList<Member> memberList) {
		this.memberList = memberList;
	}
	
	public int inIdOutIdx(String Id) {
		int idx=-1;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getId().equals(Id)) idx=i;break;
		}
		return idx;
	}
	
	public void join(String id, String pw, String name) {
		memberList.add(new Member(id, pw, name));
	}
	
}
