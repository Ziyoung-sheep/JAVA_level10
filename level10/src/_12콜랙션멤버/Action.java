package _12콜랙션멤버;

import java.util.ArrayList;

public interface Action {
	ArrayList<Member>MemberList=MemberDAO.getInstance().getMemberList();
	void excute();
}
