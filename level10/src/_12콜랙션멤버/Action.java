package _12콜랙션멤버;

import java.util.ArrayList;

public interface Action {
	Utils utils=Utils.getInstance();
	MemberDAO memberDAO=MemberDAO.getInstance();
	void excute();
}
