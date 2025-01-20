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
	
}
