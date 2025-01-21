package _12콜랙션멤버;

import java.util.Comparator;

public class Member {
	private String id;
	private String pw;
	private String name;
	
	Member(String id, String pw, String name) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
	}
	@Override
	public String toString() {
		return "ID:" + id +"\tPW: " + pw +"\tNAME: " + name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

class MemberComp implements Comparator<Member>{
	
	enum SortBy{ ID, NAME };
	private SortBy sortBy;
	
	MemberComp(SortBy sortBy){
		super();
		this.sortBy=sortBy;
	}
	
	@Override
	public int compare(Member o1, Member o2) {
		int result=0;
		switch(sortBy) {
		case ID: result= o1.getId().compareTo(o2.getId()); break;
		case NAME: result= o1.getName().compareTo(o2.getName()); break;
		}
		return result;
	}
	
}
